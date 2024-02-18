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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
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
 * The Accounting-Answer (ACA) command, indicated by the Command Code
   field set to 271 and the Command Flags' 'R' bit cleared, is used to
   acknowledge an Accounting-Request command.  The Accounting-Answer
   command contains the same Session-Id as the corresponding request.

   Only the target Diameter server, known as the home Diameter server,
   SHOULD respond with the Accounting-Answer command.

   In addition to the AVPs listed below, Accounting-Answer messages
   SHOULD include service-specific accounting AVPs.
   
    Message Format

         <ACA> ::= < Diameter Header: 271, PXY >
                   < Session-Id >
                   { Result-Code }
                   { Origin-Host }
                   { Origin-Realm }
                   { Accounting-Record-Type }
                   { Accounting-Record-Number }
                   [ Acct-Application-Id ]
                   [ Vendor-Specific-Application-Id ]
                   [ User-Name ]
                   [ Accounting-Sub-Session-Id ]
                   [ Acct-Session-Id ]
                   [ Acct-Multi-Session-Id ]
                   [ Error-Message ]
                   [ Error-Reporting-Host ]
                   [ Failed-AVP ]
                   [ Acct-Interim-Interval ]
                   [ Accounting-Realtime-Required ]
                   [ Origin-State-Id ]
                   [ Event-Timestamp ]
                 * [ Proxy-Info ]
                 * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.COMMON, commandCode = CommandCodes.ACCOUNTING, request = false, proxyable = true, name="Accounting-Answer")
public interface AccountingAnswer extends DiameterAnswer
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
}