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
 * 	The Metering-Method AVP (AVP code 1007) is of type Enumerated, and it defines what parameters shall be metered
	for offline charging. The PCEF may use the AVP for unit request in online charging in case of decentralized unit
	determination, refer to 3GPP TS 32.299 [19].
	The following values are defined:

	DURATION (0)
 		This value shall be used to indicate that the duration of the service data flow traffic shall be metered.
	VOLUME (1)
 		This value shall be used to indicate that volume of the service data flow traffic shall be metered.
	DURATION_VOLUME (2)
 		This value shall be used to indicate that the duration and the volume of the service data flow traffic shall be
		metered.
	EVENT (3)
 		This value shall be used to indicate that events of the service data flow traffic shall be metered.

	NOTE: Event based charging is only applicable to predefined PCC rule using a service data flow filter and any
	PCC rule (predefined and dynamic) using an application detection filter (i.e. with an application
	identifier).

	If the Metering-Method AVP is omitted but has been supplied previously, the previous information remains valid. If the
	Metering-Method AVP is omitted and has not been supplied previously, the metering method pre-configured at the
	PCEF is applicable as default metering method. 
 */
public enum MeteringMethodEnum implements IntegerEnum
{
	DURATION(0),VOLUME(1),DURATION_VOLUME(2),EVENT(3);

	private static final Map<Integer, MeteringMethodEnum> intToTypeMap = new HashMap<Integer, MeteringMethodEnum>();
	static
	{
	    for (MeteringMethodEnum type : MeteringMethodEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MeteringMethodEnum fromInt(Integer value) 
	{
		MeteringMethodEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MeteringMethodEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
