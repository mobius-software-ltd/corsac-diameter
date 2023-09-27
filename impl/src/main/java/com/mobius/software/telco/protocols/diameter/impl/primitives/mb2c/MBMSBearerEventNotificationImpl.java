package com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c;
/*
 * Mobius Software LTD
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSFlowIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.TMGIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSFlowIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.TMGI;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerEvent;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerEventDiagnosticInfo;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerEventDiagnosticInfoEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerEventNotification;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.UserplaneProtocolResult;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3503L, vendorId = KnownVendorIDs.TGPP_ID)
public class MBMSBearerEventNotificationImpl extends DiameterGroupedAvpImpl implements MBMSBearerEventNotification
{
	private TMGI tmgi;
    private MBMSFlowIdentifier mbmsFlowIdentifier;
    private MBMSBearerEvent mbmsBearerEvent;
    private MBMSBearerEventDiagnosticInfo mbmsBearerEventDiagnosticInfo;
    private List<UserplaneProtocolResult> userplaneProtocolResult;
		 
    protected MBMSBearerEventNotificationImpl()
    {
    	super();
    }
    
    public MBMSBearerEventNotificationImpl(ByteBuf tmgi,ByteBuf mbmsFlowIdentifier,Long mbmsBearerEvent)
    {
    	if(tmgi==null)
			throw new IllegalArgumentException("TMGI is required");
		
    	if(mbmsFlowIdentifier==null)
			throw new IllegalArgumentException("MBMS-Flow-Identifier is required");
		
    	if(mbmsBearerEvent==null)
			throw new IllegalArgumentException("MBMS‑Bearer‑Event is required");
		
		this.tmgi = new TMGIImpl(tmgi,null,null);
    	
    	this.mbmsFlowIdentifier = new MBMSFlowIdentifierImpl(mbmsFlowIdentifier,null,null);
    	
    	this.mbmsBearerEvent = new MBMSBearerEventImpl(mbmsBearerEvent,null,null);
    }
    
	public ByteBuf getTMGI()
	{
		if(tmgi==null)
			return null;
		
		return tmgi.getValue();
	}
	
	public void setTMGI(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("TMGI is required");
		
		this.tmgi = new TMGIImpl(value, null, null);	
	}
	
	public ByteBuf getMBMSFlowIdentifier()
	{
		if(mbmsFlowIdentifier==null)
			return null;
		
		return mbmsFlowIdentifier.getValue();
	}
	
	public void setMBMSFlowIdentifier(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("MBMS-Flow-Identifier is required");
		
		this.mbmsFlowIdentifier = new MBMSFlowIdentifierImpl(value, null, null);	
	}
	
	public Long getMBMSBearerEvent()
	{
		if(mbmsBearerEvent==null)
			return null;
		
		return mbmsBearerEvent.getUnsigned();
	}
	
	public void setMBMSBearerEvent(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("MBMS‑Bearer‑Event is required");
		
		this.mbmsBearerEvent = new MBMSBearerEventImpl(value, null, null);	
	}
	
	public MBMSBearerEventDiagnosticInfoEnum getMBMSBearerEventDiagnosticInfo()
	{
		if(mbmsBearerEventDiagnosticInfo==null)
			return null;
		
		return mbmsBearerEventDiagnosticInfo.getEnumerated(MBMSBearerEventDiagnosticInfoEnum.class);
	}
	
	public void setMBMSBearerEventDiagnosticInfo(MBMSBearerEventDiagnosticInfoEnum value)
	{
		if(value==null)
			this.mbmsBearerEventDiagnosticInfo = null;
		else
			this.mbmsBearerEventDiagnosticInfo = new MBMSBearerEventDiagnosticInfoImpl(value, null, null);			
	}
	
	public List<UserplaneProtocolResult> getUserplaneProtocolResult()
	{
		return userplaneProtocolResult;
	}
	
	public void setUserplaneProtocolResult(List<UserplaneProtocolResult> value)
	{
		this.userplaneProtocolResult = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(tmgi==null)
			return "TMGI is required";
		
		if(mbmsFlowIdentifier==null)
			return "MBMS-Flow-Identifier is required";
		
		if(mbmsBearerEvent==null)
			return "MBMS‑Bearer‑Event is required";
		
		return null;
	}	
}