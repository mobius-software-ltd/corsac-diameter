package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.commons.CapabilitiesExchangeRequest;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterMessageBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.FirmwareRevisionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.HostIpAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.InbandSecurityIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginStateIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ProductNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SupportedVendorIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.FirmwareRevision;
import com.mobius.software.telco.protocols.diameter.primitives.common.HostIpAddress;
import com.mobius.software.telco.protocols.diameter.primitives.common.InbandSecurityId;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginStateId;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProductName;
import com.mobius.software.telco.protocols.diameter.primitives.common.SupportedVendorId;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorId;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

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
@DiameterCommandImplementation(applicationId = -1, commandCode = 257, request = true)
public class CapabilitiesExchangeRequestmpl extends DiameterMessageBase implements CapabilitiesExchangeRequest
{
	private OriginStateId originStateId;
	
	private List<HostIpAddress> hostIpAddresses;
	
	private VendorId vendorId;
	
	private ProductName productName;
	
	private List<SupportedVendorId> supportedVendorIds;
	
	private List<AuthApplicationId> authApplicationIds;
	
	private List<AcctApplicationId> acctApplicationIds;
	
	private List<InbandSecurityId> inbandSecurityIds;
	
	private List<VendorSpecificApplicationId> vendorSpecificApplicationId;
	
	private FirmwareRevision firmwareRevision;
	
	protected CapabilitiesExchangeRequestmpl() 
	{
	}
	
	public CapabilitiesExchangeRequestmpl(String originHost,String originRealm,Boolean isRetransmit)
	{
		super(originHost, originRealm, isRetransmit);
	}

	@Override
	public List<InetAddress> getHostIpAddresses() 
	{
		if(this.hostIpAddresses==null)
			return null;
		else
		{
			List<InetAddress> ipAddresses = new ArrayList<InetAddress>();
			for(HostIpAddress curr:hostIpAddresses)
				ipAddresses.add(curr.getAddress());
			
			return ipAddresses;
		}
	}

	@Override
	public void setHostIpAddress(List<InetAddress> value) 
	{
		if(value==null || value.size()==0)
			this.hostIpAddresses = null;
		else
		{
			this.hostIpAddresses = new ArrayList<HostIpAddress>();
			for(InetAddress curr:value)
				this.hostIpAddresses.add(new HostIpAddressImpl(curr, null, null));
		}
	}

	@Override
	public Long getVendorId() 
	{
		if(vendorId==null)
			return null;
		
		return vendorId.getUnsigned();
	}

	@Override
	public void setVendorId(Long value) 
	{
		if(value == null)
			this.vendorId = null;
		else
			this.vendorId = new VendorIdImpl(value, null, null);
	}

	@Override
	public String getProductName() 
	{
		if(productName==null)
			return null;
		
		return productName.getString();
	}

	@Override
	public void setProductName(String value) 
	{
		if(value==null)
			this.productName = null;
		else
			this.productName = new ProductNameImpl(value, null, null);
	}

	@Override
	public List<Long> getSupportedVendorIds() 
	{
		if(supportedVendorIds==null)
			return null;
		else
		{
			List<Long> result=new ArrayList<Long>();
			for(SupportedVendorId curr:supportedVendorIds)
				result.add(curr.getUnsigned());
			
			return result;
		}
	}

	@Override
	public void setSupportedVendorIds(List<Long> value) 
	{
		if(value==null || value.size()==0)
			this.supportedVendorIds=null;
		else
		{
			this.supportedVendorIds=new ArrayList<SupportedVendorId>();
			for(Long curr:value)
				this.supportedVendorIds.add(new SupportedVendorIdImpl(curr, null, null));
		}
	}

	@Override
	public List<Long> getAuthApplicationIds() 
	{
		if(authApplicationIds==null)
			return null;
		else
		{
			List<Long> result=new ArrayList<Long>();
			for(AuthApplicationId curr:authApplicationIds)
				result.add(curr.getUnsigned());
			
			return result;
		}
	}

	@Override
	public void setAuthApplicationIds(List<Long> value) 
	{
		if(value==null || value.size()==0)
			this.authApplicationIds=null;
		else
		{
			this.authApplicationIds=new ArrayList<AuthApplicationId>();
			for(Long curr:value)
				this.authApplicationIds.add(new AuthApplicationIdImpl(curr, null, null));
		}
	}

	@Override
	public List<Long> getAcctApplicationIds() 
	{
		if(acctApplicationIds==null)
			return null;
		else
		{
			List<Long> result=new ArrayList<Long>();
			for(AcctApplicationId curr:acctApplicationIds)
				result.add(curr.getUnsigned());
			
			return result;
		}
	}

	@Override
	public void setAcctApplicationIds(List<Long> value) 
	{
		if(value==null || value.size()==0)
			this.acctApplicationIds=null;
		else
		{
			this.acctApplicationIds=new ArrayList<AcctApplicationId>();
			for(Long curr:value)
				this.acctApplicationIds.add(new AcctApplicationIdImpl(curr, null, null));
		}
	}

	@Override
	public List<Long> getInbandSecurityIds() 
	{
		if(inbandSecurityIds==null)
			return null;
		else
		{
			List<Long> result=new ArrayList<Long>();
			for(InbandSecurityId curr:inbandSecurityIds)
				result.add(curr.getUnsigned());
			
			return result;
		}
	}

	@Override
	public void setInbandSecurityIds(List<Long> value) 
	{
		if(value==null || value.size()==0)
			this.inbandSecurityIds=null;
		else
		{
			this.inbandSecurityIds=new ArrayList<InbandSecurityId>();
			for(Long curr:value)
				this.inbandSecurityIds.add(new InbandSecurityIdImpl(curr, null, null));
		}
	}

	@Override
	public List<VendorSpecificApplicationId> getVendorSpecificApplicationIds() 
	{
		if(vendorSpecificApplicationId==null)
			return null;
		else
			return vendorSpecificApplicationId; 
	}

	@Override
	public void setVendorSpecificApplicationIds(List<VendorSpecificApplicationId> value) 
	{
		this.vendorSpecificApplicationId = value;
	}

	@Override
	public Long getFirmwareRevision() 
	{
		if(firmwareRevision==null)
			return null;
		else
			return firmwareRevision.getUnsigned();
	}

	@Override
	public void setFirmwareRevision(Long value) 
	{
		if(value==null)
			this.firmwareRevision = null;
		else
			this.firmwareRevision = new FirmwareRevisionImpl(value, null, null);
	}

	@Override
	public Long getOriginStateId() 
	{
		if(this.originStateId == null)
			return null;
		
		return this.originStateId.getUnsigned();
	}

	@Override
	public void setOriginStateId(Long value) 
	{
		if(value == null)
			this.originStateId = null;
		else
			this.originStateId = new OriginStateIdImpl(value, null, null);
	}
}