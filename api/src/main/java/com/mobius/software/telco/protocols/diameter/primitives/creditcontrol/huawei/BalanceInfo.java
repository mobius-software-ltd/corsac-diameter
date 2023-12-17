package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/* 	3.2.526  Balance-Info AVP (60001)
	
	AVP Name
	Balance-Info

	AVP Code
	60001

	AVP Data Type
	Group

	Vendor ID
	2011

	Description
	Information about accounts whose balances are queried. The account information includes the main fund, bonus amount, and free resource. A maximum of 20 groups of records can be saved.
	
	Balance-Info ::= <AVP Header: 60001> 
           [Payment-Type] 
           {Balance-Category} 
           {Balance-Id} 
           {Balance-Type} 
           {Current-Balance} 
           {BalanceDate} 
           {Measure-Type} 
           [Currency-Code] 
           [Related-Object-Type] 
           [Related-Object-ID] 
           [Unpaid-Fee]
*/
@DiameterAvpDefinition(code = 20856L, vendorId = KnownVendorIDs.HUAWEI_ID, name = "Balance-Info")
public interface BalanceInfo extends DiameterAvp 
{
	Integer getPaymentType();
	
	void setPaymentType(Integer value);		
	
	Integer getBalanceCategory();
	
	void setBalanceCategory(Integer value);		
	
	Long getBalanceID();
	
	void setBalanceID(Long value);		
	
	Long getBalanceType();
	
	void setBalanceType(Long value);		
	
	Long getCurrentBalance();
	
	void setCurrentBalance(Long value);		
	
	Date getBalanceDate();
	
	void setBalanceDate(Date value);		
	
	Long getMeasureType();
	
	void setMeasureType(Long value);		
	
	Long getCurrencyCode();
	
	void setCurrencyCode(Long value);		
	
	Integer getRelatedObjectType();
	
	void setRelatedObjectType(Integer value);		
	
	Long getRelatedObjectID();
	
	void setRelatedObjectID(Long value);		
	
	Long getUnpaidFee();
	
	void setUnpaidFee(Long value);
}