package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ServedPartyIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.NonIPDataDeliveryMechanismImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.NonIPPDNTypeIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.PDNTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServedPartyIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPDataDeliveryMechanism;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPDataDeliveryMechanismEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPPDNTypeIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPPDNTypeIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusType;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.PDNConnectivityStatusTypeEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3181L, vendorId = KnownVendorIDs.TGPP_ID)
public class PDNConnectivityStatusReportImpl extends DiameterGroupedAvpImpl implements PDNConnectivityStatusReport
{
	private ServiceSelection serviceSelection;
	private PDNConnectivityStatusType pdnConnectivityStatusType;
	private PDNType pdnType;
	private NonIPPDNTypeIndicator nonIPPDNTypeIndicator;
	private NonIPDataDeliveryMechanism nonIPDataDeliveryMechanism;
	private List<ServedPartyIPAddress> servedPartyIPAddress;
	
	protected PDNConnectivityStatusReportImpl() 
	{
	}
	
	public PDNConnectivityStatusReportImpl(Long contextIdentifier,PDNConnectivityStatusTypeEnum pdnConnectivityStatusType,String serviceSelection)
	{
		if(pdnConnectivityStatusType==null)
			throw new IllegalArgumentException("PDN-Connectivity-Status-Type");
		
		if(serviceSelection==null)
			throw new IllegalArgumentException("Service-Selection is required");
		
		this.pdnConnectivityStatusType = new PDNConnectivityStatusTypeImpl(pdnConnectivityStatusType, null, null);
		
		this.serviceSelection = new ServiceSelectionImpl(serviceSelection, null, null);
	}
	
	public String getServiceSelection()
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}
	
	public void setServiceSelection(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Service-Selection is required");
		
		this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}	
	
	public PDNConnectivityStatusTypeEnum getPDNConnectivityStatusType()
	{
		if(pdnConnectivityStatusType == null)
			return null;
		
		return pdnConnectivityStatusType.getEnumerated(PDNConnectivityStatusTypeEnum.class);
	}
	
	public void setPDNConnectivityStatusType(PDNConnectivityStatusTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("PDN-Connectivity-Status-Type is required");
		
		this.pdnConnectivityStatusType = new PDNConnectivityStatusTypeImpl(value, null, null);		
	}
	
	public PDNTypeEnum getPDNType()
	{
		if(pdnType == null)
			return null;
		
		return pdnType.getEnumerated(PDNTypeEnum.class);
	}
	
	public void setPDNType(PDNTypeEnum value)
	{
		if(value==null)
			this.pdnType = null;
		else
			this.pdnType = new PDNTypeImpl(value, null, null);			
	}
	
	public NonIPPDNTypeIndicatorEnum getNonIPPDNTypeIndicator()
	{
		if(nonIPPDNTypeIndicator == null)
			return null;
		
		return nonIPPDNTypeIndicator.getEnumerated(NonIPPDNTypeIndicatorEnum.class);
	}
	
	public void setNonIPPDNTypeIndicator(NonIPPDNTypeIndicatorEnum value)
	{
		if(value==null)
			this.nonIPPDNTypeIndicator = null;
		else
			this.nonIPPDNTypeIndicator = new NonIPPDNTypeIndicatorImpl(value, null, null);			
	}
	
	public NonIPDataDeliveryMechanismEnum getNonIPDataDeliveryMechanism()
	{
		if(nonIPDataDeliveryMechanism == null)
			return null;
		
		return nonIPDataDeliveryMechanism.getEnumerated(NonIPDataDeliveryMechanismEnum.class);
	}
	
	public void setNonIPDataDeliveryMechanism(NonIPDataDeliveryMechanismEnum value)
	{
		if(value==null)
			this.nonIPDataDeliveryMechanism = null;
		else
			this.nonIPDataDeliveryMechanism = new NonIPDataDeliveryMechanismImpl(value, null, null);			
	}
	
	public List<InetAddress> getServedPartyIPAddress()
	{
		if(servedPartyIPAddress==null || servedPartyIPAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(ServedPartyIPAddress curr:servedPartyIPAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setServedPartyIPAddress(List<InetAddress> value)
	{
		if(value!=null && value.size()>2)
			throw new IllegalArgumentException("Up to 2 Served-Party-IP-Address allowed");	
		
		if(value==null || value.size()==0)
			this.servedPartyIPAddress = null;
		else
		{
			this.servedPartyIPAddress = new ArrayList<ServedPartyIPAddress>();
			for(InetAddress curr:value)
				this.servedPartyIPAddress.add(new ServedPartyIPAddressImpl(curr, null, null));
		}
	}
	
	@DiameterValidate
	public String validate()
	{
		if(serviceSelection==null)
			return "Service-Selection is required";
		
		if(pdnConnectivityStatusType==null)
			return "PDN-Connectivity-Status-Type is required";
		
		if(servedPartyIPAddress!=null && servedPartyIPAddress.size()>2)
			return "Up to 2 Served-Party-IP-Address allowed";
		
		return null;
	}
}