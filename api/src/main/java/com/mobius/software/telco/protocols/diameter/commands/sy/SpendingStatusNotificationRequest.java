package com.mobius.software.telco.protocols.diameter.commands.sy;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterStatusReport;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.4	Spending-Status-Notification-Request (SNR) command
	The SNR command, indicated by the Command-Code field set to 8388636 and the 'R' bit set in the Command Flags field, is sent by the OCS to the PCRF as part of the Spending Limit Report procedure.
	Message Format:
	<SN-Request> ::= < Diameter Header: 8388636, REQ, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { Destination-Host }
                 { Auth-Application-Id }
                 [ Origin-State-Id ]
                 [ OC-Supported-Features ]
                *[ Policy-Counter-Status-Report ]
                 [ SN-Request-Type ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777302, commandCode = 8388636, request = true, proxyable = true, name="SL-Request")
public interface SpendingStatusNotificationRequest extends SyRequest
{	
	public List<PolicyCounterStatusReport> getPolicyCounterStatusReport();
	 
	void setPolicyCounterStatusReport(List<PolicyCounterStatusReport> value);
	
	public Long getSNRequestType();
	
	void setSNRequestType(Long value);
}