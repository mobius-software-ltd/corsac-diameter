package com.mobius.software.telco.protocols.diameter.impl.commands.sta;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.sta.EAPRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.VisitedNetworkIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallingStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5447.MIP6FeatureVectorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ANIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.FullNetworkNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ShortNetworkNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.TWAGCPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.TWANConnectionModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.AAAFailureIndicationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.VisitedNetworkIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallingStationId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6FeatureVector;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6942.ERPRKRequest;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANID;
import com.mobius.software.telco.protocols.diameter.primitives.sta.DERFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sta.FullNetworkName;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ShortNetworkName;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWAGCPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANConnectionMode;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANConnectivityParameters;
import com.mobius.software.telco.protocols.diameter.primitives.sta.WLANIdentifier;
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
public class EAPRequestImpl extends StaRequestImpl implements EAPRequest
{
	private AuthRequestType authRequestType;
	
	private EAPPayload eapPayload;	
	
	private CallingStationId callingStationId;
	
	private RATType ratType;
	
	private ANID anid;
	
	private FullNetworkName fullNetworkName;
	
	private ShortNetworkName shortNetworkName;
	
	private QoSCapability qosCapability;
	
	private MIP6FeatureVector mip6FeatureVector;
	
	private VisitedNetworkIdentifier visitedNetworkIdentifier;
	
	private ServiceSelection serviceSelection;
    
	private TerminalInformation terminalInformation;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private List<SupportedFeatures> supportedFeatures;	
	
	private AAAFailureIndication aaaFailureIndication;
	
	private WLANIdentifier wlanIdentifier;
	
	private DERFlags derFlags;
	
	private TWANConnectionMode twanConnectionMode;
	
	private TWANConnectivityParameters twanConnectivityParameters;
	
	private List<TWAGCPAddress> twagCPAddress;
	
	private ERPRKRequest erprkRequest;
	
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
	public String getCallingStationId()
	{
		if(callingStationId==null)
			return null;
		
		return this.callingStationId.getString();
	}
	
	@Override
	public void setCallingStationId(String value)
	{
		if(value==null)
			this.callingStationId = null;
		else
			this.callingStationId = new CallingStationIdImpl(value, null, null);
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
	public String getANID()
	{
		if(anid==null)
			return null;
		
		return this.anid.getString();
	}
	
	@Override
	public void setANID(String value)
	{
		if(value==null)
			this.anid = null;
		else
			this.anid = new ANIDImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getFullNetworkName()
	{
		if(fullNetworkName==null)
			return null;
		
		return this.fullNetworkName.getValue();
	}
	
	@Override
	public void setFullNetworkName(ByteBuf value)
	{
		if(value==null)
			this.fullNetworkName = null;
		else
			this.fullNetworkName = new FullNetworkNameImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getShortNetworkName()
	{
		if(shortNetworkName==null)
			return null;
		
		return this.shortNetworkName.getValue();
	}
	
	@Override
	public void setShortNetworkName(ByteBuf value)
	{
		if(value==null)
			this.shortNetworkName = null;
		else
			this.shortNetworkName = new ShortNetworkNameImpl(value, null, null);
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
	public WLANIdentifier getWLANIdentifier()
	{
		return this.wlanIdentifier;
	}
	
	@Override
	public void setWLANIdentifier(WLANIdentifier value)
	{
		this.wlanIdentifier = value;
	}
	
	@Override
	public DERFlags getDERFlags()
	{
		return derFlags;
	}
	
	@Override
	public void setDERFlags(DERFlags value)
	{
		this.derFlags = value;
	}

	@Override
	public Long getTWANConnectionMode()
	{
		if(twanConnectionMode == null)
			return null;
		
		return twanConnectionMode.getUnsigned();
	}
	
	@Override
	public void setTWANConnectionMode(Long value)
	{
		if(value==null)
			this.twanConnectionMode = null;
		else
			this.twanConnectionMode = new TWANConnectionModeImpl(value, null, null);
	}
	
	@Override
	public TWANConnectivityParameters getTWANConnectivityParameters()
	{
		return this.twanConnectivityParameters;
	}
	
	@Override
	public void setTWANConnectivityParameters(TWANConnectivityParameters value)
	{
		this.twanConnectivityParameters = value;
	}
	
	@Override
	public List<InetAddress> getTWAGCPAddress()
	{
		if(twagCPAddress==null || twagCPAddress.size()==0)
			return null;
		
		List<InetAddress> result=new ArrayList<InetAddress>();
		for(TWAGCPAddress curr:twagCPAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	@Override
	public void setTWAGCPAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException
	{
		if(value==null || value.size()==0)
			this.twagCPAddress = null;
		else if(value.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			for(InetAddress curr:value)
				failedAvps.add(new TWAGCPAddressImpl(curr, null, null));
			
			throw new AvpOccursTooManyTimesException("Up to 2 TWAG-CP-Address allowed", failedAvps);
		}
		else
		{
			this.twagCPAddress = new ArrayList<TWAGCPAddress>();
			for(InetAddress curr:value)
				this.twagCPAddress.add(new TWAGCPAddressImpl(curr, null, null));
		}		
	}
	
	@Override
	public ERPRKRequest getERPRKRequest()
	{
		return this.erprkRequest;
	}
	
	@Override
	public void setERPRKRequest(ERPRKRequest value)
	{
		this.erprkRequest = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authRequestType==null)
			return new MissingAvpException("Auth-Request-Type is required", Arrays.asList(new DiameterAvp[] { new AuthRequestTypeImpl() }));
		
		if(eapPayload==null)
			return new MissingAvpException("EAP-Payload is required", Arrays.asList(new DiameterAvp[] { new EAPPayloadImpl() }));
		
		if(twagCPAddress!=null && twagCPAddress.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(twagCPAddress);
			
			return new AvpOccursTooManyTimesException("Up to 2 TWAG-CP-Address allowed", failedAvps);
		}
		
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
		result.add(callingStationId);
		result.add(ratType);
		result.add(anid);
		result.add(fullNetworkName);
		result.add(shortNetworkName);
		result.add(qosCapability);
		result.add(mip6FeatureVector);
		result.add(visitedNetworkIdentifier);
		result.add(serviceSelection);
		result.add(terminalInformation);
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(aaaFailureIndication);
		result.add(wlanIdentifier);
		result.add(derFlags);
		result.add(twanConnectionMode);
		result.add(twanConnectivityParameters);
		
		if(twagCPAddress!=null)
			result.addAll(twagCPAddress);
		
		result.add(erprkRequest);
		
		if(optionalAvps!=null)
        {
        	for(List<DiameterAvp> curr:optionalAvps.values())
        		result.addAll(curr);
        }
		
		return result;
	}
}