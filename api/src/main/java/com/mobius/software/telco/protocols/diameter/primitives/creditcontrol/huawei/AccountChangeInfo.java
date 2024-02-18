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

import com.mobius.software.telco.protocols.diameter.HuaweiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
/* 3.2.113  Account-Change-Info AVP

	AVP Name 
	Account-Change-Info

	AVP Code 
	20349

	AVP Data Type 
	Grouped

	Vendor ID
	2011

	Description 
	Indicates the balance change information of an account.
	The Account-Change-Info AVP is an AVP group. The detailed ABNF syntax is as follows: 

	Account-Change-Info ::= <AVP Header:20349> 
                {AccountID} 
                {Account-Type} 
                {Current-Account-Balance} 
                {Account-Balance-Change} 
                {AccountDate} 
                {Account-Date-Change}
                {Measure-Type}
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.ACCOUNT_CHANGE_INFO, vendorId = VendorIDs.HUAWEI_ID, name = "Account-Change-Info")
public interface AccountChangeInfo extends DiameterAvp 
{
	ByteBuf getAccountID();
	
	void setAccountID(ByteBuf value) throws MissingAvpException;
	
	Long getAccountType();
	
	void setAccountType(Long value) throws MissingAvpException;
	
	Long getCurrentAccountBalance();
	
	void setCurrentAccountBalance(Long value) throws MissingAvpException;
	
	Long getAccountBalanceChange();	
	
	void setAccountBalanceChange(Long value) throws MissingAvpException;
	
	ByteBuf getAccountDate();
	
	void setAccountDate(ByteBuf value) throws MissingAvpException;
	
	Long getAccountDateChange();
	
	void setAccountDateChange(Long value) throws MissingAvpException;
	
	Long getMeasureType();
	
	void setMeasureType(Long value) throws MissingAvpException;	
}