package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ValidityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.ApplicationPortIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.PriorityIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.ReferenceNumberImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MTCIWFAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMDeviceTriggerInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ApplicationPortIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.PriorityIndication;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.PriorityIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ReferenceNumber;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.205B	SM-Device-Trigger-Information AVP
	The SM-Device-Trigger-Information AVP (AVP code 3405) is of type Grouped and holds the specific device trigger details for the Short Message.
	It has the following ABNF grammar:
	
	SM-Device-Trigger-Information :: =   < AVP Header: 3405>
		[ MTC-IWF-Address ]
		[ Reference-Number ]
		[ Serving-Node ]
		[ Validity-Time ]
		[ Priority-Indication ]
		[ Application-Port-Identifier ] 
 */
@DiameterAvpImplementation(code = 3405L, vendorId = KnownVendorIDs.TGPP_ID)
public class SMDeviceTriggerInformationImpl implements SMDeviceTriggerInformation
{
	private MTCIWFAddress mtcIWFAddress;
	private ReferenceNumber referenceNumber;
	private ServingNode servingNode;
	private ValidityTime validityTime;
	private PriorityIndication priorityIndication;
	private ApplicationPortIdentifier applicationPortIdentifier; 
		
	public SMDeviceTriggerInformationImpl()
	{
		
	}
	
	public InetAddress getMTCIWFAddress()
	{
		if(mtcIWFAddress==null)
			return null;
		
		return mtcIWFAddress.getAddress();
	}
	
	public void setMTCIWFAddress(InetAddress value)
	{
		if(value==null)
			this.mtcIWFAddress = null;
		else
			this.mtcIWFAddress = new MTCIWFAddressImpl(value, null, null);			
	}
	
	public Long getReferenceNumber()
	{
		if(referenceNumber==null)
			return null;
		
		return referenceNumber.getUnsigned();
	}
	
	public void setReferenceNumber(Long value)
	{
		if(value==null)
			this.referenceNumber = null;
		else
			this.referenceNumber = new ReferenceNumberImpl(value, null, null);			
	}
	
	public ServingNode getServingNode()
	{
		return this.servingNode;
	}
	
	public void setServingNode(ServingNode value)
	{
		this.servingNode = value;
	}
	
	public Long getValidityTime()
	{
		if(validityTime==null)
			return null;
		
		return validityTime.getUnsigned();
	}
	
	public void setValidityTime(Long value)
	{
		if(value==null)
			this.validityTime = null;
		else
			this.validityTime = new ValidityTimeImpl(value, null, null);			
	}
	
	public PriorityIndicationEnum getPriorityIndication()
	{
		if(priorityIndication==null)
			return null;
		
		return priorityIndication.getEnumerated(PriorityIndicationEnum.class);
	}
	
	public void setPriorityIndication(PriorityIndicationEnum value)
	{
		if(value==null)
			this.priorityIndication = null;
		else
			this.priorityIndication = new PriorityIndicationImpl(value, null, null);			
	}
	
	public Long getApplicationPortIdentifier()
	{
		if(applicationPortIdentifier==null)
			return null;
		
		return applicationPortIdentifier.getUnsigned();
	}
	
	public void setApplicationPortIdentifier(Long value)
	{
		if(value==null)
			this.applicationPortIdentifier = null;
		else
			this.applicationPortIdentifier = new ApplicationPortIdentifierImpl(value, null, null);			
	}
}