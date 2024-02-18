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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/* 	3.2.107  Recharge-Information AVP
	
	AVP Name
	Recharge-Information

	AVP Code
	20341

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	Indicates the information about recharge.
	The Recharge-Information AVP is an AVP group. The detailed ABNF syntax is as follows:  
	
	Recharge-Information ::= <AVP Header: 20314>  
                         [Charge-Number] 
                         [Card-Number] 
                         [Card-Batch] 
                         [Card-Type] 
                         [Card-Money] 
                         [Charge-Money] 
                         [CardSpID] 
                         [CardBrandID]
                         [Card-CurDistributorID]
                         [FraudTimes] 
                         [SerialNo] 
                         [UniformSerialNo]
                         [Recharge-Method] 
                         [Etopup-SessionID] 
                         [Account-Type]
                         [New-Card-Money]
                         [Ex-Trans-Type]
                         [ChannelID]
                         [ExParameter1]
                         [ExParameter2]
						 [ExParameter3]
						 [ExParameter4]
						 [ExParameter5]
						 [ExParameter6]
						 [ExParameter7]
						 [ExParameter8]
						 [ExParameter9]
						 [ExParameter10]
						 [AccessModule]
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.RECHARGE_INFORMATION, vendorId = VendorIDs.HUAWEI_ID, name = "Recharge-Information")
public interface RechargeInformation extends DiameterAvp 
{
	ByteBuf getChargeNumber();
	
	void setChargeNumber(ByteBuf value);
	
	ByteBuf getCardNumber();
	
	void setCardNumber(ByteBuf value);	
	
	ByteBuf getCardBatch();
	
	void setCardBatch(ByteBuf value);	
	
	Long getCardType();
	
	void setCardType(Long value);	
	
	Long getCardMoney();
	
	void setCardMoney(Long value);	
	
	ChargeMoney getChargeMoney();
	
	void setChargeMoney(ChargeMoney value);	
	
	Long getCardSpID();
	
	void setCardSpID(Long value);	
	
	ByteBuf getCardBrandID();
	
	void setCardBrandID(ByteBuf value);	
	
	String getCardCurDistributorID();
	
	void setCardCurDistributorID(String value);	
	
	Long getFraudTimes();
	
	void setFraudTimes(Long value);	
	
	String getSerialNo();
	
	void setSerialNo(String value);			
	
	String getUniformSerialNo();
	
	void setUniformSerialNo(String value);			
	
	RechargeMethodEnum getRechargeMethod();
	
	void setRechargeMethod(RechargeMethodEnum value);	
	
	String getEtopupSessionID();
	
	void setEtopupSessionID(String value);	
	
	Long getAccountType();
	
	void setAccountType(Long value);	
	
	Long getNewCardMoney();
	
	void setNewCardMoney(Long value);		
	
	String getExTransType();
	
	void setExTransType(String value);	
	
	String getChannelID();
	
	void setChannelID(String value);
	
	String getExParameter1();
	
	void setExParameter1(String value);
	
	String getExParameter2();
	
	void setExParameter2(String value);
	
	String getExParameter3();
	
	void setExParameter3(String value);
	
	String getExParameter4();
	
	void setExParameter4(String value);
	
	String getExParameter5();
	
	void setExParameter5(String value);
	
	String getExParameter6();
	
	void setExParameter6(String value);
	
	String getExParameter7();
	
	void setExParameter7(String value);
	
	String getExParameter8();
	
	void setExParameter8(String value);
	
	String getExParameter9();
	
	void setExParameter9(String value);
	
	String getExParameter10();
	
	void setExParameter10(String value);
	
	Integer getAccessModule();
	
	void setAccessModule(Integer value);
}