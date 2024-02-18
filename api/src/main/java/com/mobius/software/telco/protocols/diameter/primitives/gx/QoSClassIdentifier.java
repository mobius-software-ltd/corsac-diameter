package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.17 QoS-Class-Identifier AVP (All access types)
	QoS-Class-Identifier AVP (AVP code 1028) is of type Enumerated, and it identifies a set of IP-CAN specific QoS
	parameters that define the authorized QoS, excluding the applicable bitrates and ARP for the IP-CAN bearer or service
	data flow. The allowed values for the standard QCIs are defined in Table 6.1.7 of 3GPP TS 23.203 [7].
	The following values are defined:

	QCI_1 (1)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 1 from
		3GPP TS 23.203 [7].
	QCI_2 (2)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 2 from
		3GPP TS 23.203 [7].
	QCI_3 (3)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 3 from
		3GPP TS 23.203 [7].
	QCI_4 (4)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 4 from
		3GPP TS 23.203 [7].
	QCI_5 (5)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 5 from
		3GPP TS 23.203 [7].
	QCI_6 (6)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 6 from
		3GPP TS 23.203 [7].
	QCI_7 (7)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 7 from
		3GPP TS 23.203 [7].
	QCI_8 (8)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 8 from
		3GPP TS 23.203 [7].
	QCI_9 (9)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 9 from
		3GPP TS 23.203 [7].
	QCI_65 (65)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 65 from
		3GPP TS 23.203 [7].
	QCI_66 (66)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 66 from
		3GPP TS 23.203 [7].
	QCI_67 (67)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 67 from
		3GPP TS 23.203 [7]. 
	QCI_69 (69)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 69 from
		3GPP TS 23.203 [7].
	QCI_70 (70)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 70 from
		3GPP TS 23.203 [7].
	QCI_71 (71)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 71 from
		3GPP TS 23.203 [7].
	QCI_72 (72)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 72 from
		3GPP TS 23.203 [7].
	QCI_73 (73)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 73 from
		3GPP TS 23.203 [7].
	QCI_74 (74)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 74 from
		3GPP TS 23.203 [7].
	QCI_75 (75)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 75 from
		3GPP TS 23.203 [7].
	QCI_76 (76)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 76 from
		3GPP TS 23.203 [7].
	QCI_79 (79)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 79
		from3GPP TS 23.203 [7] .
	QCI_80 (80)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 80 from
		3GPP TS 23.203 [7].
	QCI_82 (82)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 82 from
		3GPP TS 23.203 [7].
	QCI_83 (83)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 83 from
		3GPP TS 23.203 [7].
	QCI_84 (84)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 84 from
		3GPP TS 23.203 [7]. 
	QCI_85 (85)
 		This value shall be used to indicate standardized characteristics associated with standardized QCI value 85 from
		3GPP TS 23.203 [7].
	
	The QCI values 0, 10 – 64, 68, 77 – 78, 81, and 86 - 255 are divided for usage as follows:
	0: Reserved
	10-64: Spare
	68: Spare
	77-78: Spare
	81: Spare
	86-127: Spare
	128-254: Operator specific
	255: Reserved

	NOTE: For the different use of the terms "Reserved" and "Spare" see clause 9.9.4.3 in 3GPP TS 24.301 [42].
 */
@DiameterAvpDefinition(code = TgppAvpCodes.QOS_CLASS_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, name = "QoS-Class-Identifier")
public interface QoSClassIdentifier extends DiameterEnumerated<QoSClassIdentifierEnum>
{
}