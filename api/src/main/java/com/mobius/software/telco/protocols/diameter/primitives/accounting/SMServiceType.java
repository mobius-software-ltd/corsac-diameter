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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.213 SM-Service-Type AVP
	The SM-Service-Type AVP (AVP code 2029) is of type Enumerated and indicates the type of SM service that caused
	the charging interaction. The values as defined in TS 22.142 [217] are given below:

	0 VAS4SMS Short Message content processing
	1 VAS4SMS Short Message forwarding
	2 VAS4SMS Short Message Forwarding multiple subscriptions
	3 VAS4SMS Short Message filtering
	4 VAS4SMS Short Message receipt
	5 VAS4SMS Short Message Network Storage
	6 VAS4SMS Short Message to multiple destinations
	7 VAS4SMS Short Message Virtual Private Network (VPN)
	8 VAS4SMS Short Message Auto Reply
	9 VAS4SMS Short Message Personal Signature
	10 VAS4SMS Short Message Deferred Delivery
	11 .. 99 Reserved for 3GPP defined SM services
	100 .. 199 Vendor specific SM services

	The SM-Service-Type AVP shall be present if the SM-Message-Type AVP has value 2, SM Service Request.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SM_SERVICE_TYPE, vendorId = VendorIDs.TGPP_ID, name = "SM-Service-Type")
public interface SMServiceType extends DiameterEnumerated<SMServiceTypeEnum>
{
}