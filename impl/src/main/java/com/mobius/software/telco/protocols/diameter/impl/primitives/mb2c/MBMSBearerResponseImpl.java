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

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSFlowIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSSessionDurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.TMGIImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSFlowIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSSessionDuration;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.TMGI;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.BMSCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.BMSCPort;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MB2USecurity;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerResponse;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.MBMSBearerResult;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.RadioFrequency;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.UserplaneProtocolResult;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3505L, vendorId = KnownVendorIDs.TGPP_ID)
public class MBMSBearerResponseImpl extends DiameterGroupedAvpImpl implements MBMSBearerResponse
{
	private TMGI tmgi;
    private MBMSFlowIdentifier mbmsFlowIdentifier;
    private MBMSSessionDuration mbmsSessionDuration;
    private MBMSBearerResult mbmsBearerResult;	
    private List<BMSCAddress> bmscAddress;
    private BMSCPort bmscPort;
    private MB2USecurity mb2uSecurity;
    private List<RadioFrequency> radioFrequency;
    private List<UserplaneProtocolResult> userplaneProtocolResult;
            	
    public MBMSBearerResponseImpl()
    {
    	
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
			this.tmgi = null;
		else
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
			this.mbmsFlowIdentifier = null;
		else
			this.mbmsFlowIdentifier = new MBMSFlowIdentifierImpl(value, null, null);			
	}
	
	public ByteBuf getMBMSSessionDuration()
	{
		if(mbmsSessionDuration==null)
			return null;
		
		return mbmsSessionDuration.getValue();
	}
	
	public void setMBMSSessionDuration(ByteBuf value)
	{
		if(value==null)
			this.mbmsSessionDuration = null;
		else
			this.mbmsSessionDuration = new MBMSSessionDurationImpl(value, null, null);			
	}
	
	public MBMSBearerResult getMBMSBearerResult()
	{
		return mbmsBearerResult;
	}
	
	public void setMBMSBearerResult(MBMSBearerResult value)
	{
		this.mbmsBearerResult = value;			
	}
	
	public List<InetAddress> getBMSCAddress()
	{
		if(bmscAddress==null || bmscAddress.size()==0)
			return null;
		
		List<InetAddress> result=new ArrayList<InetAddress>();
		for(BMSCAddress curr:bmscAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setBMSCAddress(List<InetAddress> value)
	{
		if(value!=null && value.size()>2)
			throw new IllegalArgumentException("Only 2 BMSC‑Address are allowed");
		else if(value==null || value.size()==0)
			this.bmscAddress = null;
		else
		{
			this.bmscAddress = new ArrayList<BMSCAddress>();
			for(InetAddress curr:value)
				this.bmscAddress.add(new BMSCAddressImpl(curr, null, null));
		}
	}
	
	public Long getBMSCPort()
	{
		if(bmscPort==null)
			return null;
		
		return bmscPort.getUnsigned();
	}
	
	public void setBMSCPort(Long value)
	{
		if(value==null)
			this.bmscPort = null;
		else
			this.bmscPort = new BMSCPortImpl(value, null, null);			
	}
	
	public Long getMB2USecurity()
	{
		if(mb2uSecurity==null)
			return null;
		
		return mb2uSecurity.getUnsigned();
	}
	
	public void setMB2USecurity(Long value)
	{
		if(value==null)
			this.mb2uSecurity = null;
		else
			this.mb2uSecurity = new MB2USecurityImpl(value, null, null);			
	}
	
	public List<Long> getRadioFrequency()
	{
		if(radioFrequency==null || radioFrequency.size()==0)
			return null;
		
		List<Long> result=new ArrayList<Long>();
		for(RadioFrequency curr:radioFrequency)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setRadioFrequency(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.radioFrequency = null;
		else
		{
			this.radioFrequency = new ArrayList<RadioFrequency>();
			for(Long curr:value)
				this.radioFrequency.add(new RadioFrequencyImpl(curr, null, null));
		}
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
		if(bmscAddress!=null || bmscAddress.size()>2)
			return "Only 2 BMSC‑Address are allowed";
		
		return null;
	}
}