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
 * 	5.3.29 QoS-Upgrade AVP (3GPP-GPRS Access Type only)
	The QoS-Upgrade AVP (AVP code 1030) is of type Enumerated. The value of the AVP indicates whether the SGSN
	supports that the GGSN upgrades the QoS in a Create PDP context response or Update PDP context response. If the
	SGSN does not support a QoS upgrade, the PCRF shall not provision an authorized bitrates (e.g. GBR, MBR) which are
	higher than the requested bitrates for this IP CAN bearer in the response of the IP-CAN session establishment or
	modification. The setting is applicable to the bearer indicated in the request within the Bearer-Identifier AVP.
	If no QoS-Upgrade AVP has been supplied for an IP CAN bearer, the default value
	QoS_UPGRADE_NOT_SUPPORTED is applicable. If the QoS-Upgrade AVP has previously been supplied for an IP
	CAN bearer but is not supplied in a new PCC rule request, the previously supplied value remains applicable.
	The following values are defined:

	QoS_UPGRADE_NOT_SUPPORTED (0)
 		This value indicates that the IP-CAN bearer does not support the upgrading of the requested QoS. This is the
		default value applicable if no QoS-Upgrade AVP has been supplied for an IP CAN bearer.
	QoS_UPGRADE_SUPPORTED (1)
 		This value indicates that the IP-CAN bearer supports the upgrading of the requested QoS. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.QOS_UPGRADE, vendorId = VendorIDs.TGPP_ID, name = "QoS-Upgrade")
public interface QoSUpgrade extends DiameterEnumerated<QoSUpgradeEnum>
{
}