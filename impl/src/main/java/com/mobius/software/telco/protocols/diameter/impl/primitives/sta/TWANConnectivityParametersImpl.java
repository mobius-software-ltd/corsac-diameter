package com.mobius.software.telco.protocols.diameter.impl.primitives.sta;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ServedPartyIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.PDNTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServedPartyIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ConnectivityFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sta.SMBackOffTimer;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWAGUPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANConnectivityParameters;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANPCO;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANS2aFailureCause;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class TWANConnectivityParametersImpl extends DiameterGroupedAvpImpl implements TWANConnectivityParameters
{
	private ConnectivityFlags connectivityFlags;
	
	private ServiceSelection serviceSelection;
	
	private PDNType pdnType;
	
	private List<ServedPartyIPAddress> servedPartyIPAddress;
	
	private TWANPCO twanPCO;
	
	private TWAGUPAddress twagupAddress;
	
	private TWANS2aFailureCause twanS2aFailureCause;
	
	private SMBackOffTimer smBackOffTimer;
	
	public TWANConnectivityParametersImpl()
	{
		
	}
	
	public ConnectivityFlags getConnectivityFlags()
	{
		return connectivityFlags;
	}
	
	public void setConnectivityFlags(ConnectivityFlags value)
	{
		this.connectivityFlags = value;
	}
	
	public String getServiceSelection()
	{
		if(serviceSelection==null)
			return null;
		
		return serviceSelection.getString();
	}
	
	public void setServiceSelection(String value)
	{
		if(value == null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}
	
	public PDNTypeEnum getPDNType()
	{
		if(pdnType==null)
			return null;
		
		return pdnType.getEnumerated(PDNTypeEnum.class);
	}
	
	public void setPDNType(PDNTypeEnum value)
	{
		if(value == null)
			this.pdnType = null;
		else
			this.pdnType = new PDNTypeImpl(value, null, null);
	}
	
	public List<InetAddress> getServedPartyIPAddress()
	{
		if(servedPartyIPAddress==null || servedPartyIPAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(ServedPartyIPAddress curr: servedPartyIPAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setServedPartyIPAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException
	{
		if(value == null || value.size() == 0)
			this.servedPartyIPAddress = null;
		else if(value.size() > 2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			for(InetAddress curr:value)
				failedAvps.add(new ServedPartyIPAddressImpl(curr, null, null));
			
			throw new AvpOccursTooManyTimesException("Up to 2 Served-Party-IP-Address are allowed", failedAvps);
		}
		else
		{
			this.servedPartyIPAddress = new ArrayList<ServedPartyIPAddress>();
			for(InetAddress curr: value)
				this.servedPartyIPAddress.add(new ServedPartyIPAddressImpl(curr, null, null));
		}
	}
	
	public ByteBuf getTWANPCO()
	{
		if(twanPCO==null)
			return null;
		
		return twanPCO.getValue();
	}
	
	public void setTWANPCO(ByteBuf value)
	{
		if(value == null)
			this.twanPCO = null;
		else
			this.twanPCO = new TWANPCOImpl(value, null, null);
	}
	
	public String getTWAGUPAddress()
	{
		if(twagupAddress==null)
			return null;
		
		return twagupAddress.getString();
	}
	
	public void setTWAGUPAddress(String value)
	{
		if(value == null)
			this.twagupAddress = null;
		else
			this.twagupAddress = new TWAGUPAddressImpl(value, null, null);
	}
	
	public Long getTWANS2aFailureCause()
	{
		if(twanS2aFailureCause==null)
			return null;
		
		return twanS2aFailureCause.getUnsigned();
	}
	
	public void setTWANS2aFailureCause(Long value)
	{
		if(value == null)
			this.twanS2aFailureCause = null;
		else
			this.twanS2aFailureCause = new TWANS2aFailureCauseImpl(value, null, null);
	}
	
	public Long getSMBackOffTimer()
	{
		if(smBackOffTimer==null)
			return null;
		
		return smBackOffTimer.getUnsigned();
	}
	
	public void setSMBackOffTimer(Long value)
	{
		if(value == null)
			this.smBackOffTimer = null;
		else
			this.smBackOffTimer = new SMBackOffTimerImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(servedPartyIPAddress!=null && servedPartyIPAddress.size()>2)
		{
			List<DiameterAvp> failedAvps=new ArrayList<DiameterAvp>();
			failedAvps.addAll(servedPartyIPAddress);
			return new AvpOccursTooManyTimesException("Up to 2 Served-Party-IP-Address are allowed", failedAvps);
		}
		
		return null;
	}
}