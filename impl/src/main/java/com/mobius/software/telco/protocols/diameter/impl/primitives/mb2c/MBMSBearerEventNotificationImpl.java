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

import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSFlowIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.TMGIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
    
    public MBMSBearerEventNotificationImpl(ByteBuf tmgi,ByteBuf mbmsFlowIdentifier,MBMSBearerEvent mbmsBearerEvent) throws MissingAvpException
    {
    	setTMGI(tmgi);
    	
    	setMBMSFlowIdentifier(mbmsFlowIdentifier);
    	
    	setMBMSBearerEvent(mbmsBearerEvent);    	
    }
    
	public ByteBuf getTMGI()
	{
		if(tmgi==null)
			return null;
		
		return tmgi.getValue();
	}
	
	public void setTMGI(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("TMGI is required", Arrays.asList(new DiameterAvp[] { new TMGIImpl() }));
			
		this.tmgi = new TMGIImpl(value, null, null);	
	}
	
	public ByteBuf getMBMSFlowIdentifier()
	{
		if(mbmsFlowIdentifier==null)
			return null;
		
		return mbmsFlowIdentifier.getValue();
	}
	
	public void setMBMSFlowIdentifier(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MBMS-Flow-Identifier is required", Arrays.asList(new DiameterAvp[] { new MBMSFlowIdentifierImpl() }));
		
		this.mbmsFlowIdentifier = new MBMSFlowIdentifierImpl(value, null, null);	
	}
	
	public MBMSBearerEvent getMBMSBearerEvent()
	{
		return mbmsBearerEvent;
	}
	
	public void setMBMSBearerEvent(MBMSBearerEvent value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MBMS‑Bearer‑Event is required", Arrays.asList(new DiameterAvp[] { new MBMSBearerEventImpl() }));
			
		this.mbmsBearerEvent = value;	
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
	public DiameterException validate()
	{
		if(tmgi==null)
			return new MissingAvpException("TMGI is required", Arrays.asList(new DiameterAvp[] { new TMGIImpl() }));
		
		if(mbmsFlowIdentifier==null)
			return new MissingAvpException("MBMS-Flow-Identifier is required", Arrays.asList(new DiameterAvp[] { new MBMSFlowIdentifierImpl() }));
		
		if(mbmsBearerEvent==null)
			return new MissingAvpException("MBMS‑Bearer‑Event is required", Arrays.asList(new DiameterAvp[] { new MBMSBearerEventImpl() }));
		
		return null;
	}
}