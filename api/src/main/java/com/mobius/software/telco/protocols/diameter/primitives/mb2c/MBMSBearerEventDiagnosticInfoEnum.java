package com.mobius.software.telco.protocols.diameter.primitives.mb2c;

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
 * 	6.4.35	MBMS‑Bearer‑Event‑Diagnostic-Info AVP
	The MBMS‑Bearer‑Event-Diagnostic-Info AVP (AVP code 3533) is of type Enumerated. It indicates the diagnostic reason of an event notified. The following values are supported:
	
	TMGI-Expiry (0)
	The MBMS bearer was terminated due to the expiry of TMGI.

	MBMS-GW-Not-Establishment (1)
	The MBMS bearer was activated failure due to MBMS-GW is not established.

	SGmb-Transient-Path-Failure (2)
	The MBMS bearer was activated failure due to SGmb transient path failure.

	SGmb-Non-Transient-Path-Failure (3)
	The MBMS bearer was terminated due to SGmb non-transient path failure.

	MBMS-GW-User-Plane-Failure (4)
	The MBMS bearer was terminated due to User Plane Failure detected by the MBMS-GW.

	MBMS-GW-Permanent-Error (5)
	The MBMS bearer was terminated due to MBMS-GW Permanent Error response.

	MBMS-GW-Transient-Error (6)
	The MBMS bearer was activated failure due to MBMS-GW Transient Error response. 
 */
public enum MBMSBearerEventDiagnosticInfoEnum implements IntegerEnum
{
	TMGI_EXPIRY(0),MBMS_GW_NOT_ESTABLISHMENT(1),SGMB_TRANSIENT_PATH_FAILURE(2),
	SGMB_NON_TRANSIENT_PATH_FAILURE(3),MBMS_GW_USER_PLANE__FAILURE(4),MBMS_GW_PERMANENT_ERROR(5),
	MBMS_GW_TRANSIENT_ERROR(6);

	private static final Map<Integer, MBMSBearerEventDiagnosticInfoEnum> intToTypeMap = new HashMap<Integer, MBMSBearerEventDiagnosticInfoEnum>();
	static
	{
	    for (MBMSBearerEventDiagnosticInfoEnum type : MBMSBearerEventDiagnosticInfoEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static MBMSBearerEventDiagnosticInfoEnum fromInt(Integer value) 
	{
		MBMSBearerEventDiagnosticInfoEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private MBMSBearerEventDiagnosticInfoEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
