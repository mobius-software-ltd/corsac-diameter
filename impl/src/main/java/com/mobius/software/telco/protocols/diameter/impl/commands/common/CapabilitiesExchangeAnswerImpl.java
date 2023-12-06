package com.mobius.software.telco.protocols.diameter.impl.commands.common;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.commons.CapabilitiesExchangeAnswer;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterAnswerBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.FirmwareRevisionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.HostIpAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.InbandSecurityIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ProductNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SupportedVendorIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.FirmwareRevision;
import com.mobius.software.telco.protocols.diameter.primitives.common.HostIpAddress;
import com.mobius.software.telco.protocols.diameter.primitives.common.InbandSecurityId;
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
@DiameterCommandImplementation(applicationId = 0, commandCode = 257, request = false)
public class CapabilitiesExchangeAnswerImpl extends DiameterAnswerBase implements CapabilitiesExchangeAnswer
{
	private List<HostIpAddress> hostIpAddresses;
	
	private VendorId vendorId;
	
	private ProductName productName;
	
	private List<SupportedVendorId> supportedVendorIds;
	
	private List<AuthApplicationId> authApplicationIds;
	
	private List<AcctApplicationId> acctApplicationIds;
	
	private List<InbandSecurityId> inbandSecurityIds;
	
	private List<VendorSpecificApplicationId> vendorSpecificApplicationId;
	
	private FirmwareRevision firmwareRevision;
	
	protected CapabilitiesExchangeAnswerImpl() 
	{
		super();
		setSessionIdAllowed(false);
		setProxyInfoAllowed(false);
		setExperimentalResultAllowed(false);
		setErrorReportingHostAllowed(false);
		setUsernameAllowed(false);
	}
	
	public CapabilitiesExchangeAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, List<InetAddress> hostIpAddresses, Long vendorId, String productName)
	{
		super(originHost, originRealm, isRetransmit, resultCode);
		
		setSessionIdAllowed(false);
		setProxyInfoAllowed(false);
		setExperimentalResultAllowed(false);
		setErrorReportingHostAllowed(false);
		setUsernameAllowed(false);
		
		setHostIpAddress(hostIpAddresses);
		
		setVendorId(vendorId);
		
		setProductName(productName);
	}

	@Override
	public List<InetAddress> getHostIpAddress() 
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
		if(hostIpAddresses == null || hostIpAddresses.size() < 1)
			throw new IllegalArgumentException("At least 1 Host-IP-Address is required");
		
		this.hostIpAddresses = new ArrayList<HostIpAddress>();
		for(InetAddress curr:value)
			this.hostIpAddresses.add(new HostIpAddressImpl(curr, null, null));		
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
		if(vendorId==null)
			throw new IllegalArgumentException("Vendor-Id is required");
		
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
			throw new IllegalArgumentException("Product-Name is required");
		
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
	
	@DiameterValidate
	public String validate()
	{
		if(hostIpAddresses == null || hostIpAddresses.size() < 1)
			throw new IllegalArgumentException("At least 1 Host-IP-Address is required");
		
		if(vendorId==null)
			return "Vendor-Id is required";
		
		if(productName==null)
			return "Product-Name is required";
		
		return super.validate();
	}
}