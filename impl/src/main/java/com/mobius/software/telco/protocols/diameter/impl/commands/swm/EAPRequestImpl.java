package com.mobius.software.telco.protocols.diameter.impl.commands.swm;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.swm.EAPRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.VisitedNetworkIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.AAAFailureIndicationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.VisitedNetworkIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.swm.EmergencyServices;
import com.mobius.software.telco.protocols.diameter.primitives.swx.AAAFailureIndication;

import io.netty.buffer.ByteBuf;

/*
 * Mobius Software LTD, Open Source Cloud Communications
 * Copyright 2023, Mobius Software LTD and individual contributors
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
public class EAPRequestImpl extends SwmRequestImpl implements EAPRequest
{
	private AuthRequestType authRequestType;
	
	private EAPPayload eapPayload;
	
	private RATType ratType;
	
	private ServiceSelection serviceSelection;
    
	private MIP6FeatureVector mip6FeatureVector;
	
	private QoSCapability qosCapability;
	
	private VisitedNetworkIdentifier visitedNetworkIdentifier;
	
	private AAAFailureIndication aaaFailureIndication;
	
	private List<SupportedFeatures> supportedFeatures;	
	
	private UELocalIPAddress ueLocalIPAddress;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private TerminalInformation terminalInformation;
	
	private EmergencyServices emergencyServices;
	
	protected EAPRequestImpl() 
	{
		super();
	}
	
	public EAPRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType, ByteBuf eapPayload) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId);
		
		setAuthRequestType(authRequestType);
		
		setEAPPayload(eapPayload);
	}

	@Override
	public AuthRequestTypeEnum getAuthRequestType() 
	{
		if(authRequestType == null)
			return null;
		
		return authRequestType.getEnumerated(AuthRequestTypeEnum.class);
	}

	@Override
	public void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Auth-Request-Type is required", Arrays.asList(new DiameterAvp[] { new AuthRequestTypeImpl() }));
		
		this.authRequestType = new AuthRequestTypeImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getEAPPayload() 
	{
		if(eapPayload == null)
			return null;
		
		return eapPayload.getValue();
	}

	@Override
	public void setEAPPayload(ByteBuf value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("EAP-Payload is required", Arrays.asList(new DiameterAvp[] { new EAPPayloadImpl() }));				

		this.eapPayload = new EAPPayloadImpl(value, null, null);
	}
	
	@Override
	public RATTypeEnum getRATType()
	{
		if(ratType==null)
			return null;
		
		return this.ratType.getEnumerated(RATTypeEnum.class);
	}
	
	@Override
	public void setRATType(RATTypeEnum value)
	{
		if(value==null)
			this.ratType = null;
		else
			this.ratType = new RATTypeImpl(value, null, null);
	}

	@Override
	public String getServiceSelection() 
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}

	@Override
	public void setServiceSelection(String value) 
	{
		if(value == null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}
	
	@Override
	public Long getMIP6FeatureVector() 
	{
		if(mip6FeatureVector==null)
			return null;
		
		return mip6FeatureVector.getLong();
	}

	@Override
	public void setMIP6FeatureVector(Long value) 
	{
		if(value == null)
			this.mip6FeatureVector = null;
		else
			this.mip6FeatureVector = new MIP6FeatureVectorImpl(value, null, null);
	}
	
	@Override
	public QoSCapability getQoSCapability()
	{
		return this.qosCapability;
	}
	
	@Override
	public void setQoSCapability(QoSCapability value)
	{
		this.qosCapability = value;
	}
	
	@Override
	public ByteBuf getVisitedNetworkIdentifier() 
	{
		if(visitedNetworkIdentifier==null)
			return null;
		
		return visitedNetworkIdentifier.getValue();
	}
	
	@Override
	public void setVisitedNetworkIdentifier(ByteBuf value)
	{
		if(value == null)
			this.visitedNetworkIdentifier = null;
		else
			this.visitedNetworkIdentifier = new VisitedNetworkIdentifierImpl(value, null, null);
	}

	@Override
	public Long getAAAFailureIndication()
	{
		if(aaaFailureIndication==null)
			return null;
		
		return aaaFailureIndication.getUnsigned();
	}
	
	@Override
	public void setAAAFailureIndication(Long value)
	{
		if(value == null)
			this.aaaFailureIndication = null;
		else
			this.aaaFailureIndication = new AAAFailureIndicationImpl(value, null, null);
	}
	
	@Override
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;				
	}
			 
	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}
	
	@Override
	public InetAddress getUELocalIPAddress()
	{
		if(ueLocalIPAddress==null)
			return null;
		
		return this.ueLocalIPAddress.getAddress();
	}
	
	@Override
	public void setUELocalIPAddress(InetAddress value) 
	{
		if(value==null)
			this.ueLocalIPAddress = null;
		else
			this.ueLocalIPAddress = new UELocalIPAddressImpl(value, null, null);
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public TerminalInformation getTerminalInformation()
	{
		return this.terminalInformation;
	}
	
	@Override
	public void setTerminalInformation(TerminalInformation value)
	{
		this.terminalInformation = value;
	}
	 
	@Override
	public EmergencyServices getEmergencyServices()
	{
		return emergencyServices;
	}

	@Override
	public void setEmergencyServices(EmergencyServices value)
	{
		this.emergencyServices = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authRequestType==null)
			return new MissingAvpException("Auth-Request-Type is required", Arrays.asList(new DiameterAvp[] { new AuthRequestTypeImpl() }));
		
		if(eapPayload==null)
			return new MissingAvpException("EAP-Payload is required", Arrays.asList(new DiameterAvp[] { new EAPPayloadImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(authRequestType);
		result.add(eapPayload);
		result.add(username);
		result.add(ratType);
		result.add(serviceSelection);
		result.add(mip6FeatureVector);
		result.add(qosCapability);
		result.add(visitedNetworkIdentifier);
		result.add(aaaFailureIndication);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(ueLocalIPAddress);
		result.add(ocSupportedFeatures);
		result.add(terminalInformation);
		result.add(emergencyServices);
		

		if(optionalAvps!=null)
        {
        	for(List<DiameterUnknownAvp> curr:optionalAvps.values())
        		result.addAll(curr);
        }
		
		return result;
	}
}