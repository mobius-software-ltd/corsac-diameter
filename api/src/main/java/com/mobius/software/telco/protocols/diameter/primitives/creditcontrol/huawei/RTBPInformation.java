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

/**
*
* @author yulian oifa
*
*/
/* 	3.2.190  RTBP-Information AVP
	
	AVP Name
	RTBP-Information

	AVP Code
	20600

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	Indicates the RTBP information group, which stores the information about the one-off deduction.
	The RTBP-Information AVP is an AVP group. The detailed ABNF syntax is as follows:

	RTBP-Information ::= <AVP Header: 20600> 
                     [sp-id] 
                     [service-id] 
                     [CategoryID] 
                     [ContentID] 
                     [CDRProductID] 
                     [CDRChargeMode] 
                     [CDRTimes] 
                     [CDRDuration] 
                     [CDRVolume] 
                     [CDRCDRType] 
                     [CDRServiceType] 
                     [CDRBeginTime] 
                     [CDREndTime] 
                     [CDRPkgSpid] 
                     [CDRPkgServiceid] 
                     [CDRPkgProductid] 
                     [CDRSPName] 
                     [CDRServiceName] 
                     [TransactionID] 
                    
	NOTE
	RTBP: Real Time Billing Protocol
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.RTBP_INFORMATION, vendorId = VendorIDs.HUAWEI_ID, name = "RTBP-Information")
public interface RTBPInformation extends DiameterAvp 
{
	String getSPId();
	
	void setSPId(String value);
	
	String getServiceId();
	
	void setServiceId(String value);
	
	String getCategoryID();
	
	void setCategoryID(String value);
	
	String getContentID();
	
	void setContentID(String value);
	
	String getCDRProductID();
	
	void setCDRProductID(String value);
	
	Integer getCDRChargeMode();
	
	void setCDRChargeMode(Integer value);
	
	Integer getCDRTimes();
	
	void setCDRTimes(Integer value);
	
	Integer getCDRDuration();
	
	void setCDRDuration(Integer value);

	Integer getCDRVolume();
	
	void setCDRVolume(Integer value);
	
	Integer getCDRType();
	
	void setCDRType(Integer value);
	
	Integer getCDRServiceType();
	
	void setCDRServiceType(Integer value);
	
	Integer getCDRBeginTime();
	
	void setCDRBeginTime(Integer value);
	
	Integer getCDREndTime();
	
	void setCDREndTime(Integer value);
	
	String getCDRPkgSpId();
	
	void setCDRPkgSpId(String value);
	
	String getCDRPkgServiceId();
	
	void setCDRPkgServiceId(String value);
	
	String getCDRPkgProductId();
	
	void setCDRPkgProductId(String value);
	
	String getCDRSPName();
	
	void setCDRSPName(String value);
	
	String getCDRServiceName();
	
	void setCDRServiceName(String value);
	
	String getTransactionID();
	
	void setTransactionID(String value);
}