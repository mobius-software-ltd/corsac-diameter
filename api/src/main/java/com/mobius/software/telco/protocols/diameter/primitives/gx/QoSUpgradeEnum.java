package com.mobius.software.telco.protocols.diameter.primitives.gx;

import java.util.HashMap;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.primitives.IntegerEnum;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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
public enum QoSUpgradeEnum implements IntegerEnum
{
	QOS_UPGRADE_NOT_SUPPORTED(0),QOS_UPGRADE_SUPPORTED(1);

	private static final Map<Integer, QoSUpgradeEnum> intToTypeMap = new HashMap<Integer, QoSUpgradeEnum>();
	static
	{
	    for (QoSUpgradeEnum type : QoSUpgradeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static QoSUpgradeEnum fromInt(Integer value) 
	{
		QoSUpgradeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private QoSUpgradeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
