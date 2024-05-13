package com.mobius.software.telco.protocols.diameter;

import static com.google.common.truth.Truth.assertAbout;
import static com.google.common.truth.Truth.assertThat;
import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;

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

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Rule;
import org.junit.Test;

import com.google.common.truth.ExpectFailure;
import com.google.testing.compile.JavaFileObjects;

public class DiameterAnnotationsTest 
{
	@Rule public final ExpectFailure expectFailure = new ExpectFailure();

	 @Test
	 public void MissingAllAnnotationsTest() throws MalformedURLException {
		 ClassLoader classLoader = getClass().getClassLoader();
		 final DiameterTagAnnotationProcessor processor = new DiameterTagAnnotationProcessor();
		 
		 URL badPrimiteURL=classLoader.getResource("com/mobius/software/telco/protocols/diameter/AllAnnotationsMissing.java");
		 expectFailure.whenTesting().about(javaSource()).that(JavaFileObjects.forResource(badPrimiteURL)).processedWith(processor).compilesWithoutError();
		 
		 AssertionError expected = expectFailure.getFailure();
		 assertThat(expected.getMessage()).contains("error: Class 'com.mobius.software.telco.protocols.diameter.AllAnnotationsMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterLength annotation");
		 assertThat(expected.getMessage()).contains("error: Class 'com.mobius.software.telco.protocols.diameter.AllAnnotationsMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterEncode annotation");	
		 assertThat(expected.getMessage()).contains("error: Class 'com.mobius.software.telco.protocols.diameter.AllAnnotationsMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterDecode annotation");		 
	 }
	 
	 
	 @Test
	 public void MissingDecodeTest() throws MalformedURLException {
		 ClassLoader classLoader = getClass().getClassLoader();
		 final DiameterTagAnnotationProcessor processor = new DiameterTagAnnotationProcessor();
		 
		 URL badPrimiteURL=classLoader.getResource("com/mobius/software/telco/protocols/diameter/DecodeMissing.java");
		 expectFailure.whenTesting().about(javaSource()).that(JavaFileObjects.forResource(badPrimiteURL)).processedWith(processor).compilesWithoutError();
		 
		 AssertionError expected = expectFailure.getFailure();
		 assertThat(expected.getMessage()).doesNotContain("error: Class 'com.mobius.software.telco.protocols.diameter.DecodeMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterLength annotation");
		 assertThat(expected.getMessage()).doesNotContain("error: Class 'com.mobius.software.telco.protocols.diameter.DecodeMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterEncode annotation");	
		 assertThat(expected.getMessage()).contains("error: Class 'com.mobius.software.telco.protocols.diameter.DecodeMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterDecode annotation");		 
	 }
	 
	 @Test
	 public void MissingEncodeTest() throws MalformedURLException {
		 ClassLoader classLoader = getClass().getClassLoader();
		 final DiameterTagAnnotationProcessor processor = new DiameterTagAnnotationProcessor();
		 	
		 URL badPrimiteURL=classLoader.getResource("com/mobius/software/telco/protocols/diameter/EncodeMissing.java");
		 expectFailure.whenTesting().about(javaSource()).that(JavaFileObjects.forResource(badPrimiteURL)).processedWith(processor).compilesWithoutError();

		 AssertionError expected = expectFailure.getFailure();
		 assertThat(expected.getMessage()).doesNotContain("error: Class 'com.mobius.software.telco.protocols.diameter.EncodeMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterLength annotation");
		 assertThat(expected.getMessage()).contains("error: Class 'com.mobius.software.telco.protocols.diameter.EncodeMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterEncode annotation");	
		 assertThat(expected.getMessage()).doesNotContain("error: Class 'com.mobius.software.telco.protocols.diameter.EncodeMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterDecode annotation");
	}
	 
	 @Test
	 public void MissingLengthTest() throws MalformedURLException {
		 ClassLoader classLoader = getClass().getClassLoader();
		 final DiameterTagAnnotationProcessor processor = new DiameterTagAnnotationProcessor();
		 
		 URL badPrimiteURL=classLoader.getResource("com/mobius/software/telco/protocols/diameter/LengthMissing.java");
		 expectFailure.whenTesting().about(javaSource()).that(JavaFileObjects.forResource(badPrimiteURL)).processedWith(processor).compilesWithoutError();
		 
		 AssertionError expected = expectFailure.getFailure();
		 assertThat(expected.getMessage()).contains("error: Class 'com.mobius.software.telco.protocols.diameter.LengthMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterLength annotation");
		 assertThat(expected.getMessage()).doesNotContain("error: Class 'com.mobius.software.telco.protocols.diameter.LengthMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterEncode annotation");	
		 assertThat(expected.getMessage()).doesNotContain("error: Class 'com.mobius.software.telco.protocols.diameter.LengthMissing' is annotated as @DiameterAvpDefinition, however no method found with DiameterDecode annotation");
	 }
	 
	 @Test
	 public void InvalidSignatureTest() throws MalformedURLException {
		 ClassLoader classLoader = getClass().getClassLoader();
		 final DiameterTagAnnotationProcessor processor = new DiameterTagAnnotationProcessor();
		 
		 URL badPrimiteURL=classLoader.getResource("com/mobius/software/telco/protocols/diameter/InvalidSignaturePrimitive.java");
		 expectFailure.whenTesting().about(javaSource()).that(JavaFileObjects.forResource(badPrimiteURL)).processedWith(processor).compilesWithoutError();
		 
		 AssertionError expected = expectFailure.getFailure();
		 assertThat(expected.getMessage()).contains("error: Element 'com.mobius.software.telco.protocols.diameter.InvalidSignaturePrimitive' is annotated as @DiameterAvpDefinition, however its method getLength annoted with @DiameterLength should not have any parameter");
		 assertThat(expected.getMessage()).contains("error: Element 'com.mobius.software.telco.protocols.diameter.InvalidSignaturePrimitive' is annotated as @DiameterAvpDefinition, however its method decode annoted with @DiameterDecode should have two parameters");	
		 assertThat(expected.getMessage()).contains("error: Element 'com.mobius.software.telco.protocols.diameter.InvalidSignaturePrimitive' is annotated as @DiameterAvpDefinition, however its method encode annoted with @DiameterEncode should have one parameter");
	 }
	 
	 @Test
	 public void GoodPrimitiveTest() throws MalformedURLException {
		 ClassLoader classLoader = getClass().getClassLoader();
		 final DiameterTagAnnotationProcessor processor = new DiameterTagAnnotationProcessor();
		 
		 URL badPrimiteURL=classLoader.getResource("com/mobius/software/telco/protocols/diameter/GoodPrimitive.java");
		 assertAbout(javaSource()).that(JavaFileObjects.forResource(badPrimiteURL)).processedWith(processor).compilesWithoutError();				 		 
	 }
	 
	 @Test
	 public void GoodCompoundPrimitiveTest() throws MalformedURLException {
		 ClassLoader classLoader = getClass().getClassLoader();
		 final DiameterTagAnnotationProcessor processor = new DiameterTagAnnotationProcessor();
		 
		 URL badPrimiteURL=classLoader.getResource("com/mobius/software/telco/protocols/diameter/GoodCompoundPrimitive.java");
		 assertAbout(javaSource()).that(JavaFileObjects.forResource(badPrimiteURL)).processedWith(processor).compilesWithoutError();				 		 
	 }
	 
	 @Test
	 public void GoodCompoundPrimitive2Test() throws MalformedURLException {
		 ClassLoader classLoader = getClass().getClassLoader();
		 final DiameterTagAnnotationProcessor processor = new DiameterTagAnnotationProcessor();
		 
		 URL badPrimiteURL=classLoader.getResource("com/mobius/software/telco/protocols/diameter/GoodCompoundPrimitive2.java");
		 assertAbout(javaSource()).that(JavaFileObjects.forResource(badPrimiteURL)).processedWith(processor).compilesWithoutError();				 		 
	 }
}