package com.mobius.software.telco.protocols.diameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterEncode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterLength;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterPrint;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/*
 * Mobius Software LTD
 * Copyright 2019, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

/**
*
* @author yulian oifa
*
*/

import io.netty.buffer.ByteBuf;

@SupportedAnnotationTypes( { "*" } )
public class DiameterTagAnnotationProcessor extends AbstractProcessor {
	private static final String EXPECTED_ENCODE_DECODE_PARAM=ByteBuf.class.getCanonicalName();
	private static final String EXPECTED_PRINT_PARAM=StringBuilder.class.getCanonicalName();
	private static final String EXPECTED_INTEGER_PARAM=Integer.class.getCanonicalName();
	private static final String EXPECTED_COMMAND_PARAM=DiameterCommandDefinition.class.getCanonicalName();
	private static final String EXPECTED_AVP_PARAM=DiameterAvpDefinition.class.getCanonicalName();
	private static final String EXPECTED_GROUPED_PARAM=DiameterGroupedAvp.class.getCanonicalName();
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations,RoundEnvironment roundEnv) {
		Set<? extends Element> rootElements = roundEnv.getRootElements();
		List<Element> annotatedCommandsElements = new ArrayList<Element>();
		List<Element> annotatedAvpsElements = new ArrayList<Element>();
		
		for(Element annotatedElement:rootElements) {
			List<? extends TypeMirror> tm = ((TypeElement) annotatedElement).getInterfaces();
			if(tm!=null) {
				for(TypeMirror currTm:tm) {	
					List<? extends AnnotationMirror> am = processingEnv.getElementUtils().getAllAnnotationMirrors(((DeclaredType)currTm).asElement());
					if(am!=null) {
						for(AnnotationMirror currAm:am) {
							TypeElement annotationElement = (TypeElement) currAm.getAnnotationType().asElement();
			                if (annotationElement.getQualifiedName().contentEquals(EXPECTED_COMMAND_PARAM))
			                	annotatedCommandsElements.add(annotatedElement);
			                else if (annotationElement.getQualifiedName().contentEquals(EXPECTED_AVP_PARAM))
			                	annotatedAvpsElements.add(annotatedElement);
						}
					}
				}
			}
		}
		
		return validateCommandStructure(annotatedCommandsElements) && validateAvpStructure(annotatedAvpsElements);
	}
	
	public boolean validateCommandStructure(List<? extends Element> annotatedElements) {
		for(Element annotatedElement:annotatedElements) {
			
			final TypeElement typeElement = ( TypeElement )annotatedElement;
			String className=typeElement.getQualifiedName().toString();		
			if(annotatedElement.getKind()!=ElementKind.INTERFACE) {
				List<? extends Element> innerElements=annotatedElement.getEnclosedElements();				
				List<ExecutableElement> methods=ElementFilter.methodsIn(innerElements);
				List<VariableElement> fields=ElementFilter.fieldsIn(innerElements);
				TypeMirror mirror=typeElement.getSuperclass();
				while(mirror.getKind()!=TypeKind.NONE)
				{					
					TypeElement parentTypeElement = (TypeElement) processingEnv.getTypeUtils().asElement(mirror);					
					innerElements=parentTypeElement.getEnclosedElements();				
					methods.addAll(ElementFilter.methodsIn(innerElements));
					fields.addAll(ElementFilter.fieldsIn(innerElements));
					mirror=parentTypeElement.getSuperclass();
				}
				
				Integer validateTags=0;
				Integer lengthTags=0;
				Integer encodeTags=0;
				Integer printTags=0;
				Integer decodeTags=0;
				Integer orderTags=0;
				
				for(ExecutableElement method:methods) {
					List<? extends VariableElement> params=method.getParameters();
					DiameterValidate validate=method.getAnnotation(DiameterValidate.class);
					if(validate!=null) {
						//we may have multiple validates in subclasses
						validateTags=1;					
						if(params.size()!=0)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterCommandDefinition, however its method %s annoted with @DiameterValidate should not have any parameters", className, method.getSimpleName()));						
					}
					
					DiameterOrder order=method.getAnnotation(DiameterOrder.class);
					if(order!=null) {
						//we may have multiple orders in subclasses
						orderTags=1;					
						if(params.size()!=0)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterCommandDefinition, however its method %s annoted with @DiameterOrder should not have any parameters", className, method.getSimpleName()));						
					}
					
					DiameterLength length=method.getAnnotation(DiameterLength.class);
					if(length!=null) {
						lengthTags+=1;					
						if(params.size()!=0)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterCommandDefinition, however its method %s annoted with @DiameterLength should not have any parameter", className, method.getSimpleName()));						
					}
					
					DiameterEncode encode=method.getAnnotation(DiameterEncode.class);
					if(encode!=null) {
						encodeTags+=1;	
						
						if(params.size()!=1)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterCommandDefinition, however its method %s annoted with @DiameterEncode should have one parameter", className, method.getSimpleName()));
						else {
							String realParamName=((TypeElement)processingEnv.getTypeUtils().asElement(params.get(0).asType())).getQualifiedName().toString();
							if(!realParamName.equals(EXPECTED_ENCODE_DECODE_PARAM))
									processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterCommandDefinition, however its method %s annoted with @DiameterEncode should have one parameter with type %s", className, method.getSimpleName(), EXPECTED_ENCODE_DECODE_PARAM));
						}
					}
					
					DiameterPrint print=method.getAnnotation(DiameterPrint.class);
					if(print!=null) {
						printTags+=1;	
						
						if(params.size()!=1)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterCommandDefinition, however its method %s annoted with @DiameterPrint should have one parameter", className, method.getSimpleName()));
						else {
							String realParamName=((TypeElement)processingEnv.getTypeUtils().asElement(params.get(0).asType())).getQualifiedName().toString();
							if(!realParamName.equals(EXPECTED_PRINT_PARAM))
									processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterCommandDefinition, however its method %s annoted with @DiameterPrint should have one parameter with type %s", className, method.getSimpleName(), EXPECTED_PRINT_PARAM));
						}
					}
					
					DiameterDecode decode=method.getAnnotation(DiameterDecode.class);
					if(decode!=null) {
						decodeTags+=1;					
	
						if(params.size()!=2)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterCommandDefinition, however its method %s annoted with @DiameterDecode should have two parameters", className, method.getSimpleName()));
						else {
							String firstParamName=((TypeElement)processingEnv.getTypeUtils().asElement(params.get(0).asType())).getQualifiedName().toString();
							String secondParamName=((TypeElement)processingEnv.getTypeUtils().asElement(params.get(1).asType())).getQualifiedName().toString();
							if(!firstParamName.equals(EXPECTED_ENCODE_DECODE_PARAM))
									processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterCommandDefinition, however its method %s annoted with @DiameterDecode should have two parameters with type %s %s", className, method.getSimpleName(), EXPECTED_ENCODE_DECODE_PARAM, EXPECTED_INTEGER_PARAM));							
							
							if(!secondParamName.equals(EXPECTED_INTEGER_PARAM))
								processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterCommandDefinition, however its method %s annoted with @DiameterDecode should have two parameters with type %s %s", className, method.getSimpleName(), EXPECTED_ENCODE_DECODE_PARAM, EXPECTED_INTEGER_PARAM));
						}
					}
				}
				
				if(validateTags>1)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterCommandDefinition, however has multiple methods found with DiameterValidate annotation", className));
				
				if(orderTags>1)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterCommandDefinition, however has multiple methods found with DiameterOrder annotation", className));
				
				if(lengthTags>1)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterCommandDefinition, however has multiple methods found with DiameterLength annotation", className));
				
				if(encodeTags>1)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterCommandDefinition, however has multiple methods found with DiameterEncode annotation", className));
					
				if(printTags>1)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterCommandDefinition, however has multiple methods found with DiameterPrint annotation", className));
					
				if(decodeTags>1)
						processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterCommandDefinition, however has multiple methods found with DiameterDecode annotation", className));
				
				if(lengthTags!=0) 
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterCommandDefinition, however has method with DiameterLength annotation", className)); 			        
				
				if(encodeTags!=0)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterCommandDefinition, however has method found with DiameterEncode annotation", className));
				
				if(printTags!=0)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterCommandDefinition, however has method found with DiameterPrint annotation", className));
				
				if(decodeTags!=0)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterCommandDefinition, however has method found with DiameterDecode annotation", className));
			}
		}	
		
		return true;
	}
	

	
	public boolean validateAvpStructure(List<? extends Element> annotatedElements) {
		for(Element annotatedElement:annotatedElements) {
			
			final TypeElement typeElement = ( TypeElement )annotatedElement;
			String className=typeElement.getQualifiedName().toString();		
			if(annotatedElement.getKind()!=ElementKind.INTERFACE) {
				List<? extends Element> innerElements=annotatedElement.getEnclosedElements();				
				List<ExecutableElement> methods=ElementFilter.methodsIn(innerElements);
				List<VariableElement> fields=ElementFilter.fieldsIn(innerElements);
				List<TypeMirror> interfaces = new ArrayList<TypeMirror>();
				List<? extends TypeMirror> currInterfaces = typeElement.getInterfaces();
				for(TypeMirror currInterface:currInterfaces)
					interfaces.add((TypeMirror)currInterface);
				
				TypeMirror mirror=typeElement.getSuperclass();
				while(mirror.getKind()!=TypeKind.NONE)
				{					
					TypeElement parentTypeElement = (TypeElement) processingEnv.getTypeUtils().asElement(mirror);					
					innerElements=parentTypeElement.getEnclosedElements();				
					methods.addAll(ElementFilter.methodsIn(innerElements));
					fields.addAll(ElementFilter.fieldsIn(innerElements));
					currInterfaces = parentTypeElement.getInterfaces();
					for(TypeMirror currInterface:currInterfaces)
						interfaces.add((TypeMirror)currInterface);
					
					mirror=parentTypeElement.getSuperclass();
				}
				
				Boolean hasChildAvps=false;
				Integer validateTags=0;
				Integer lengthTags=0;
				Integer encodeTags=0;
				Integer printTags=0;
				Integer decodeTags=0;
				Integer orderTags=0;
				
				for(VariableElement field:fields) {
					Boolean hasAvpDefinition=false;
					Element fieldElement=processingEnv.getTypeUtils().asElement(field.asType());
					if(fieldElement instanceof TypeElement) {
							if(interfaces !=null) {
							for(TypeMirror currInterface:interfaces) {
								TypeElement currElement = (TypeElement) processingEnv.getTypeUtils().asElement(currInterface);					
								if (currElement.getQualifiedName().contentEquals(EXPECTED_GROUPED_PARAM))
									hasChildAvps=true;						                
							}
						}
						
						List<? extends AnnotationMirror> am=null;
						if(((TypeElement)fieldElement).getQualifiedName().toString().equals(List.class.getCanonicalName())) {
							if (field.asType().getKind() == TypeKind.DECLARED) {
								List<? extends TypeMirror> args =((DeclaredType) field.asType()).getTypeArguments();
								if(args.size()==1) {
									am=processingEnv.getElementUtils().getAllAnnotationMirrors(processingEnv.getTypeUtils().asElement(args.get(0)));									
								}
							}
						}
						else
							am = processingEnv.getElementUtils().getAllAnnotationMirrors(((TypeElement)fieldElement));
						
						if(am!=null) {
							for(AnnotationMirror currAm:am) {
								TypeElement annotationElement = (TypeElement) currAm.getAnnotationType().asElement();
				                if (annotationElement.getQualifiedName().contentEquals(EXPECTED_AVP_PARAM))
				                	hasAvpDefinition=true;						                
							}
						}
						
						if(hasAvpDefinition) {										
							hasChildAvps=true;
							break;
						}
					}
				}
				
				for(ExecutableElement method:methods) {
					List<? extends VariableElement> params=method.getParameters();
					DiameterValidate validate=method.getAnnotation(DiameterValidate.class);
					if(validate!=null) {
						//we may have multiple validates in subclasses
						validateTags=1;					
						if(params.size()!=0)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterAvpDefinition, however its method %s annoted with @DiameterValidate should not have any parameters", className, method.getSimpleName()));						
					}
					
					DiameterOrder order=method.getAnnotation(DiameterOrder.class);
					if(order!=null) {
						//we may have multiple orders in subclasses
						orderTags=1;					
						if(params.size()!=0)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterAvpDefinition, however its method %s annoted with @DiameterOrder should not have any parameters", className, method.getSimpleName()));						
					}
					
					DiameterLength length=method.getAnnotation(DiameterLength.class);
					if(length!=null) {
						lengthTags+=1;					
						if(params.size()!=0)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterAvpDefinition, however its method %s annoted with @DiameterLength should not have any parameter", className, method.getSimpleName()));						
					}
					
					DiameterEncode encode=method.getAnnotation(DiameterEncode.class);
					if(encode!=null) {
						encodeTags+=1;	
						
						if(params.size()!=1)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterAvpDefinition, however its method %s annoted with @DiameterEncode should have one parameter", className, method.getSimpleName()));
						else {
							String realParamName=((TypeElement)processingEnv.getTypeUtils().asElement(params.get(0).asType())).getQualifiedName().toString();
							if(!realParamName.equals(EXPECTED_ENCODE_DECODE_PARAM))
									processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterAvpDefinition, however its method %s annoted with @DiameterEncode should have one parameter with type %s", className, method.getSimpleName(), EXPECTED_ENCODE_DECODE_PARAM));
						}
					}
					
					DiameterPrint print=method.getAnnotation(DiameterPrint.class);
					if(print!=null) {
						//we may have multiple print for example for AsciiString/OctetString
						printTags=1;	
						
						if(params.size()!=1)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterAvpDefinition, however its method %s annoted with @DiameterPrint should have one parameter", className, method.getSimpleName()));
						else {
							String realParamName=((TypeElement)processingEnv.getTypeUtils().asElement(params.get(0).asType())).getQualifiedName().toString();
							if(!realParamName.equals(EXPECTED_PRINT_PARAM))
									processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterAvpDefinition, however its method %s annoted with @DiameterPrint should have one parameter with type %s", className, method.getSimpleName(), EXPECTED_PRINT_PARAM));
						}
					}
					
					DiameterDecode decode=method.getAnnotation(DiameterDecode.class);
					if(decode!=null) {
						//we may have multiple decode for example for AsciiString/OctetString
						decodeTags=1;					
	
						if(params.size()!=2)
							processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterAvpDefinition, however its method %s annoted with @DiameterDecode should have two parameters", className, method.getSimpleName()));
						else {
							String firstParamName=((TypeElement)processingEnv.getTypeUtils().asElement(params.get(0).asType())).getQualifiedName().toString();
							String secondParamName=((TypeElement)processingEnv.getTypeUtils().asElement(params.get(1).asType())).getQualifiedName().toString();
							if(!firstParamName.equals(EXPECTED_ENCODE_DECODE_PARAM))
									processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterAvpDefinition, however its method %s annoted with @DiameterDecode should have two parameters with type %s %s", className, method.getSimpleName(), EXPECTED_ENCODE_DECODE_PARAM, EXPECTED_INTEGER_PARAM));							
							
							if(!secondParamName.equals(EXPECTED_INTEGER_PARAM))
								processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Element '%s' is annotated as @DiameterAvpDefinition, however its method %s annoted with @DiameterDecode should have two parameters with type %s %s", className, method.getSimpleName(), EXPECTED_ENCODE_DECODE_PARAM, EXPECTED_INTEGER_PARAM));
						}
					}
				}
				
				if(validateTags>1)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterAvpDefinition, however has multiple methods found with DiameterValidate annotation", className));
				
				if(orderTags>1)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterAvpDefinition, however has multiple methods found with DiameterOrder annotation", className));
				
				if(lengthTags>1)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterAvpDefinition, however has multiple methods found with DiameterLength annotation", className));
				
				if(encodeTags>1)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterAvpDefinition, however has multiple methods found with DiameterEncode annotation", className));
					
				if(printTags>1)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterAvpDefinition, however has multiple methods found with DiameterPrint annotation", className));
					
				if(decodeTags>1)
						processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterAvpDefinition, however has multiple methods found with DiameterDecode annotation", className));
				
				if(!hasChildAvps && lengthTags==0) 
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterAvpDefinition, however no method found with DiameterLength annotation", className)); 			        
				
				if(!hasChildAvps && encodeTags==0)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterAvpDefinition, however no method found with DiameterEncode annotation", className));
				
				if(!hasChildAvps && printTags==0)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterAvpDefinition, however no method found with DiameterPrint annotation", className));
				
				if(!hasChildAvps && decodeTags==0)
					processingEnv.getMessager().printMessage( Diagnostic.Kind.ERROR,String.format( "Class '%s' is annotated as @DiameterAvpDefinition, however no method found with DiameterDecode annotation", className));
			}
		}	
		
		return true;
	}
}