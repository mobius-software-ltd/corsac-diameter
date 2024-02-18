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
/* 	3.2.150  P2PSMS-Information AVP
	AVP Name
	P2PSMS-Information

	AVP Code
	20400

	AVP Data Type
	Grouped

	Vendor ID
	2011

	Description
	Indicates the point-to-point short message information group.
	The P2PSMS-Information AVP is an AVP group. The detailed ABNF syntax is as follows:

	P2PSMS-Information ::= <AVP Header: 20400> 
                    [Sms-Type] 
                    [SMSC-Address] 
                    [SM-Id] 
                    [SM-Length] 
                    [mo_msc_addr] 
                    [mt_msc_addr] 
                    [source_addr] 
                    [dest_addr] 
                    [fee_flag] 
                    [fee_type]  
                    [message_pid] 
                    [status_report_request] 
                    [Orig-IMSI] 
                    [Dest-IMSI] 
                    [Calling_IMEI] 
                    [Called_IMEI] 
                    [send_result] 
                    [DATA_CODING_SCHEMA]
					[v-mcc-mnc_addr]
					[Original-Called-Party-Id]
					[Notify_Mode]
					[Operation_Result]
*/
@DiameterAvpDefinition(code = HuaweiAvpCodes.P2P_SMS_INFORMATION, vendorId = VendorIDs.HUAWEI_ID, name = "P2PSMS-Information")
public interface P2PSMSInformation extends DiameterAvp 
{
	Long getSmsType();
	
	void setSmsType(Long value);
	
	String getSMSCAddress();
	
	void setSMSCAddress(String value);
	
	String getSMId();
	
	void setSMId(String value);
	
	Long getSMLength();
	
	void setSMLength(Long value);
	
	String getMOMSCAddr();
	
	void setMOMSCAddr(String value);
	
	String getMTMSCAddr();
	
	void setMTMSCAddr(String value);
	
	String getSourceAddress();
	
	void setSourceAddress(String value);			
	
	String getDestAddress();
	
	void setDestAddress(String value);			
	
	Long getFeeFlag();
	
	void setFeeFlag(Long value);	
	
	Long getFeeType();
	
	void setFeeType(Long value);
	
	Long getFeeFixed();
	
	void setFeeFixed(Long value);
	
	Long getFeeSingle();
	
	void setFeeSingle(Long value);
	
	Long getMessagePid();
	
	void setMessagePid(Long value);	
	
	String getOrigIMSI();
	
	void setOrigIMSI(String value);
	        
	String getDestIMSI();
	
	void setDestIMSI(String value);
	
	Long getStatusReportRequest();
	
	void setStatusReportRequest(Long value);	
	
	String getCallingIMEI();
	
	void setCallingIMEI(String value);
	        
	String getCalledIMEI();
	
	void setCalledIMEI(String value);
	
	Long getSendResult();
	
	void setSendResult(Long value);
	        
	ByteBuf getSPId();
	
	void setSPId(ByteBuf value);		
	
	Long getDCS();
	
	void setDCS(Long value);		

	Long getVMccMncAddr();
	
	void setVMccMncAddr(Long value);		

	String getOriginalCalledPartyId();
	
	void setOriginalCalledPartyId(String value);	
	
	Long getOriginalCalledPartyIdNature();
	
	void setOriginalCalledPartyIdNature(Long value);	
	
	Long getNotifyMode();
	
	void setNotifyMode(Long value);	
	
	Long getOperationResult();
	
	void setOperationResult(Long value);
}