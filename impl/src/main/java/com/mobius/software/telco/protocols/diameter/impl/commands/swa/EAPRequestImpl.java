package com.mobius.software.telco.protocols.diameter.impl.commands.swa;

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.swa.EAPRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPPayloadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallingStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ANIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.FullNetworkNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.ShortNetworkNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.TransportAccessTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.AAAFailureIndicationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPPayload;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallingStationId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANID;
import com.mobius.software.telco.protocols.diameter.primitives.sta.AccessNetworkInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sta.FullNetworkName;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ShortNetworkName;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TransportAccessType;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TransportAccessTypeEnum;
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
@DiameterCommandImplementation(applicationId = 16777250, commandCode = 268, request = true)
public class EAPRequestImpl extends SwaRequestImpl implements EAPRequest
{
	private AuthRequestType authRequestType;
	
	private EAPPayload eapPayload;	
	
	private CallingStationId callingStationId;
	
	private RATType ratType;
	
	private ANID anid;
	
	private FullNetworkName fullNetworkName;
	
	private ShortNetworkName shortNetworkName;
	
	private List<SupportedFeatures> supportedFeatures;	
	
	private AAAFailureIndication aaaFailureIndication;	
	
	private TransportAccessType transportAccessType;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private AccessNetworkInfo accessNetworkInfo;
	
	private UserLocationInfoTime userLocationInfoTime;
	
	protected EAPRequestImpl() 
	{
		super();
	}
	
	public EAPRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, AuthRequestTypeEnum authRequestType, ByteBuf eapPayload)
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
	public void setAuthRequestType(AuthRequestTypeEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Auth-Request-Type is required");
		
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
	public void setEAPPayload(ByteBuf value) 
	{
		if(value==null)
			throw new IllegalArgumentException("EAP-Payload is required");				

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
	public TransportAccessTypeEnum getTransportAccessType()
	{
		if(transportAccessType==null)
			return null;
		
		return transportAccessType.getEnumerated(TransportAccessTypeEnum.class);
	}
	
	@Override
	public void setTransportAccessType(TransportAccessTypeEnum value)
	{
		if(value == null)
			this.transportAccessType = null;
		else
			this.transportAccessType = new TransportAccessTypeImpl(value, null, null);
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
	public AccessNetworkInfo getAccessNetworkInfo()
	{
		return this.accessNetworkInfo;
	}
	
	@Override
	public void setAccessNetworkInfo(AccessNetworkInfo value)
	{
		this.accessNetworkInfo = value;
	}

	@Override
	public Date getUserLocationInfoTime()
	{
		if(userLocationInfoTime==null)
			return null;
		
		return this.userLocationInfoTime.getDateTime();
	}
	
	@Override
	public void setUserLocationInfoTime(Date value)
	{
		if(value==null)
			this.userLocationInfoTime = null;
		else
			this.userLocationInfoTime = new UserLocationInfoTimeImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(authRequestType==null)
			throw new IllegalArgumentException("Auth-Request-Type is required");
		
		if(eapPayload==null)
			return "EAP-Payload is required";
		
		return super.validate();
	}
}