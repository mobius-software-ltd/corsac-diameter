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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CSGIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGAccessMode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGAccessModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGMembershipIndication;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGMembershipIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CSGId;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.240A	User-CSG-Information AVP
	The User-CSG-Information AVP (AVP code 2319) is of type Grouped and holds the user "Closed Subscriber Group" information associated to CSG cell access: it comprises CSG ID within the PLMN, access mode and indication on CSG membership for the user when hybrid access applies, as defined in TS 29.060 [225] for GPRS case, and in TS 29.274 [226] for EPC case.  
	It has the following ABNF grammar:

	User-CSG-Information :: = 	< AVP Header: 2319>
		 	{ CSG-Id }
		 	{ CSG-Access-Mode } 
			[ CSG-Membership-Indication ]
 */
@DiameterAvpImplementation(code = 2319L, vendorId = KnownVendorIDs.TGPP_ID)
public class UserCSGInformationImpl implements UserCSGInformation
{
	private CSGId csgId;
	private CSGAccessMode csgAccessMode; 
	private CSGMembershipIndication csgMembershipIndication;
	
	protected UserCSGInformationImpl() 
	{
	}
	
	public UserCSGInformationImpl(Long csgId,CSGAccessModeEnum csgAccessMode)
	{
		if(csgId==null)
			throw new IllegalArgumentException("CSG-Id is required");
		
		if(csgAccessMode==null)
			throw new IllegalArgumentException("CSG-Access-Mode is required");
		
		this.csgId = new CSGIdImpl(csgId, null, null);				
		
		this.csgAccessMode = new CSGAccessModeImpl(csgAccessMode, null, null);
	}
			
	public Long getCSGId()
	{
		if(csgId==null)
			return null;
		
		return csgId.getUnsigned();
	}
	
	public void setCSGId(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("CSG-Id is required");
		
		this.csgId = new CSGIdImpl(value, null, null);		
	}
	
	public CSGAccessModeEnum getCSGAccessMode()
	{
		if(csgAccessMode==null)
			return null;
		
		return csgAccessMode.getEnumerated(CSGAccessModeEnum.class);
	}
	
	public void setCSGAccessMode(CSGAccessModeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("CSG-Access-Mode is required");
		
		this.csgAccessMode = new CSGAccessModeImpl(value, null, null);		
	}
	
	public CSGMembershipIndicationEnum getCSGMembershipIndication()
	{
		if(csgMembershipIndication==null)
			return null;
		
		return csgMembershipIndication.getEnumerated(CSGMembershipIndicationEnum.class);
	}
	
	public void setCSGMembershipIndication(CSGMembershipIndicationEnum value)
	{
		if(value==null)
			this.csgMembershipIndication = null;
		else
			this.csgMembershipIndication = new CSGMembershipIndicationImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(csgId==null)
			return "CSG-Id is required";
		
		if(csgAccessMode==null)
			return "CSG-Access-Mode is required";
		
		return null;
	}
}