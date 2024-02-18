package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.35 Cause-Code AVP
	The Cause-Code AVP (AVP code 861) is of type Integer32 and includes the cause code value from IMS node. It is used
	in ACR[Stop] and/or ACR[Event] messages. It is also used in the CCR[Terminate] and/or CCR[Event] messages.
	Within the cause codes, values ≤ 0 are reserved for successful causes while values ≥ 1 are used for failure causes. In case
	of errors where the session has been terminated as a result of a specific known SIP error code, then the SIP error code is
	also used as the cause code.

	Successful cause code values
		
		0 Normal end of session
	
		The cause "Normal end of session" is used in Accounting-request[stop] message to indicate that an
		ongoing SIP session has been normally released either by the user or by the network (SIP BYE message
		initiated by the user or initiated by the network has been received by the IMS node after the reception of
		the SIP ACK message).

		-1 Successful transaction when 200 Final Response

		The cause "Successful transaction" is used in Accounting-request[Event] message to indicate a successful SIP
		transaction (e.g. SIP REGISTER, SIP MESSAGE, SIP NOTIFY, SIP SUBSCRIBE when 200 Final Response). It may
		also be used by an Application Server to indicate successful service event execution.

		-2 End of SUBSCRIBE dialog
		
		The cause "End of SUBSCRIBE dialog" is used to indicate the closure of a SIP SUBSCRIBE dialog . For
		instance a successful SIP SUBSCRIBE transaction terminating the dialog has been detected by the IMS
		node (i.e. SIP SUBSCRIBE with expire time set to 0).

		-2xx 2xx Final Response
		
		The cause-code "2xx Final Response"(except 200) is used when the SIP transaction is terminated due to
		an IMS node receiving/initiating a 2xx Final response as described in RFC 3261 [405].

		-3xx 3xx Redirection

		The cause "3xx Redirection" is used when the SIP transaction is terminated due to an IMS node
		receiving/initiating a 3xx response as described in RFC 3261 [405].

		-3 End of REGISTER dialog

		The cause "End of REGISTER dialog" is used to indicate the closure of a SIP REGISTER dialog. For
		instance a successful SIP REGISTER transaction terminating the dialog has been detected by the IMS
		node (i.e. SIP REGISTER with expire time set to 0).

		Failure cause code values

		1 Unspecified error

		The cause "Unspecified error" is used when the SIP transaction is terminated due to an unknown error.

		4xx 4xx Request failure

		The cause "4xx Request failure" is used when the SIP transaction is terminated due to an IMS node
		receiving/initiating a 4xx error response as described in RFC 3261 [405].

		5xx 5xx Server failure

		The cause "5xx Server failure" is used when the SIP transaction is terminated due to an IMS node
		receiving/initiating a 5xx error response as described in RFC 3261 [405].

		6xx 6xx Global failure

		The cause "6xx Global failure" is used when the SIP transaction is terminated due to an IMS node
		receiving/initiating a 6xx error response as described in RFC 3261 [405].

		2 Unsuccessful session setup

		The cause "Unsuccessful session setup" is used in the Accounting-request[stop] when the SIP session has
		not been successfully established (i.e. Timer H expires and SIP ACK is not received or SIP BYE is
		received after reception of the SIP 200 OK final response and SIP ACK is not received) as described in
		TS 24.229 [202] and in RFC 3261 [405].

		3 Internal error

		The cause "Internal error" is used when the SIP transaction is terminated due to an IMS node internal
		error (e.g. error in processing a request/response). 
*/
@DiameterAvpDefinition(code = TgppAvpCodes.CAUSE_CODE, vendorId = VendorIDs.TGPP_ID, name = "Cause-Code")
public interface CauseCode extends DiameterUnsigned32
{
}