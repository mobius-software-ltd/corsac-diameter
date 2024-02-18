package com.mobius.software.telco.protocols.diameter.commands.commons;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRealtimeRequiredEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * The Accounting-Request (ACR) command, indicated by the Command Code
   field set to 271 and the Command Flags' 'R' bit set, is sent by a
   Diameter node, acting as a client, in order to exchange accounting
   information with a peer.

   In addition to the AVPs listed below, Accounting-Request messages
   SHOULD include service-specific accounting AVPs.

   Message Format

         <ACR> ::= < Diameter Header: 271, REQ, PXY >
                   < Session-Id >
                   { Origin-Host }
                   { Origin-Realm }
                   { Destination-Realm }
                   { Accounting-Record-Type }
                   { Accounting-Record-Number }
                   [ Acct-Application-Id ]
                   [ Vendor-Specific-Application-Id ]
                   [ User-Name ]
                   [ Destination-Host ]
                   [ Accounting-Sub-Session-Id ]
                   [ Acct-Session-Id ]
                   [ Acct-Multi-Session-Id ]
                   [ Acct-Interim-Interval ]
                   [ Accounting-Realtime-Required ]
                   [ Origin-State-Id ]
                   [ Event-Timestamp ]
                 * [ Proxy-Info ]
                 * [ Route-Record ]
                 * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.COMMON, commandCode = CommandCodes.ACCOUNTING, request = true, proxyable = true, name="Accounting-Request")
public interface AccountingRequest extends DiameterRequest
{
	AccountingRecordTypeEnum getAccountingRecordType();
	
	void setAccountingRecordType(AccountingRecordTypeEnum value) throws MissingAvpException;
	
	Long getAccountingRecordNumber();
	
	void setAccountingRecordNumber(Long value) throws MissingAvpException;
	
	public Long getAcctApplicationId();
	
	void setAcctApplicationId(Long value) throws MissingAvpException;
	
	public VendorSpecificApplicationId getVendorSpecificApplicationId() throws AvpNotSupportedException;
	
	void setVendorSpecificApplicationId(VendorSpecificApplicationId value) throws AvpNotSupportedException;
	
	public Long getAccountingSubSessionId() throws AvpNotSupportedException;
	
	void setAccountingSubSessionId(Long value) throws AvpNotSupportedException;
	
	public ByteBuf getAcctSessionId() throws AvpNotSupportedException;
	
	void setAcctSessionId(ByteBuf value) throws AvpNotSupportedException;
	
	public String getAcctMultiSessionId() throws AvpNotSupportedException;
	
	void setAcctMultiSessionId(String value) throws AvpNotSupportedException;
	
	public Long getAcctInterimInterval();
	
	void setAcctInterimInterval(Long value);
	
	AccountingRealtimeRequiredEnum getAccountingRealtimeRequired() throws AvpNotSupportedException;
	
	void setAccountingRealtimeRequired(AccountingRealtimeRequiredEnum value) throws AvpNotSupportedException;
		  
	public Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	public List<String> getRouteRecords();
	
	void setRouteRecords(List<String> value);
}