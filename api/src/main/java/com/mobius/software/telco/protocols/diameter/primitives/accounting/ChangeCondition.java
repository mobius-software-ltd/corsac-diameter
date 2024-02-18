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
 * 	7.2.37 Change-Condition AVP
	The Change-Condition AVP (AVP code 2037) is of type Integer32, and indicates the change in charging condition:
	(Qos change, tariff time change …) which causes:

		- Sending of Accounting-Request from node;
		- Volume counts container closing for an IP-CAN bearer;
		- Service data container closing;
		- ProSe direct communication data container closing;
		- Record closing.

	The following values are defined :

	0 Normal Release
		The "Normal Release" value is used to indicate IP-CAN session termination , IP-CAN bearer release or Service
		Data Flow Termination; PDN connection to SCEF release.
	1 Abnormal Release
	2 Qos Change
	3 Volume Limit
	4 Time Limit
	5 Serving Node Change
	6 Serving Node PLMN Change
	7 User Location Change
	8 RAT Change
	9 UE TimeZone Change
	10 Tariff Time Change
	11 Service Idled Out
	12 ServiceSpecificUnitLimit
	13 Max Number of Changes in Charging conditions
	14 CGI-SAI Change
	15 RAI Change 
	16 ECGI Change
	17 TAI Change
	18 Service Data Volume Limit
	19 Service Data Time Limit
	20 Management Intervention
	21 Service Stop
	22 User CSG Information Change
	23 S-GW Change
	24 Change of UE Presence in Presence Reporting Area
	25 Proximity alerted
	26 Time expired with no renewal
	27 Requestor cancellation
	28 Maximum number of reports
	29 PLMN change
	30 Coverage status change
	31 Removal of access
	32 Unavailability of access
	33 Access change of service data flow
	34 Indirect change condition
	35 Maximum number of NIDD submissions
	36 Change in UP to UE
	37 Serving PLMN Rate Control Change
	38 APN Rate Control Change
	39 NIDD Submission Response Receipt
	40 NIDD Submission Response Sending
	41 NIDD Delivery to UE
	42 NIDD Delivery from UE Error
	43 NIDD Submission Timeout
	44 MO exception data counter
	45 Change of 3GPP PS Data off Status
	46 VoLTE Bearer Normal Release
	47 VoLTE Bearer Abnormal Release
	
	NOTE: Values 25-30 are applied for ProSe charging only. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.CHANGE_CONDITION, vendorId = VendorIDs.TGPP_ID, name = "Change-Condition")
public interface ChangeCondition extends DiameterUnsigned32
{
}