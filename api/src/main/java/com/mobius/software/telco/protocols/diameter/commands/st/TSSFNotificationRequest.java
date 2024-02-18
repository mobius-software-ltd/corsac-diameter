package com.mobius.software.telco.protocols.diameter.commands.st;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleReport;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5c.6.6	TSSF-Notification-Request (TNR) Command
	The TNR command, indicated by the Command-Code field set to 8388731 and the 'R' bit set in the Command Flags field, is sent by the TSSF to the PCRF in order to provide notifications.
	Message Format:

	<TN-Request> ::= < Diameter Header: 8388731, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Vendor-Specific-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Destination-Host }
				 [ Origin-State-Id ]
				*[ ADC-Rule-Report]
				 [ OC-Supported-Features ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.ST, commandCode = CommandCodes.TSSF_NOTIFCATION, request = true, proxyable = true, name="TSSF-Notification-Request")
public interface TSSFNotificationRequest extends StRequest
{
	List<ADCRuleReport> getADCRuleReport();
	
	void setADCRuleReport(List<ADCRuleReport> value);
}