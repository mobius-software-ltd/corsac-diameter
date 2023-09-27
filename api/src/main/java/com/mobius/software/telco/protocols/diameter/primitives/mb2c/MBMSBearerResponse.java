package com.mobius.software.telco.protocols.diameter.primitives.mb2c;
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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.7	MBMS‑Bearer‑Response AVP
	The MBMS‑Bearer‑Response AVP (AVP code 3505) is of type Grouped. It is used by the BM‑SC to inform the GCS AS about the result of a MBMS bearer request.
	For a successful MBMS bearer activation, the TMGI AVP, the MBMS‑Flow‑Identifier AVP, the MBMS‑Session‑Duration AVP, the BMSC‑Address AVP and the BMSC‑Port AVP shall be included, and Radio‑Frequency AVP(s) and the MB2U‑Security AVP may be included.
	For a successful MBMS bearer modification, the TMGI AVP and the MBMS‑Flow‑Identifier AVP shall be included, and the Radio-Frequency AVP(s) may be included.
	For a successful MBMS bearer deactivation, the TMGI AVP and the MBMS‑Flow‑Identifier AVP shall be included.
	For an unsuccessful MBMS bearer request, the MBMS-Bearer-Result AVP shall be included.
	If the IPv4v6 feature is supported, the BM-SC IPv4 address and BM-SC IPv6 address may be both provided as the BMSC-Address AVP, otherwise only one BM-SC IP address may be provided as the BMSC-Address AVP.
	AVP Format:
	
	MBMS-Bearer-Response::=          < AVP Header: 3505 >
                                 [ TMGI]
                                 [ MBMS-Flow-Identifier ]
                                 [ MBMS-Session-Duration ]
                                 [ MBMS-Bearer-Result ]
                              0*2[ BMSC-Address ]
                                 [ BMSC-Port ]
                                 [ MB2U-Security ]
                                *[ Radio-Frequency ]
                                *[ Userplane-Protocol‑Result ]
                                *[ AVP ]
 */
@DiameterAvpDefinition(code = 3505L, vendorId = KnownVendorIDs.TGPP_ID, name = "MBMS‑Bearer‑Event‑Notification")
public interface MBMSBearerResponse extends DiameterGroupedAvp
{
	ByteBuf getTMGI();
	
	void setTMGI(ByteBuf value);	
	
	ByteBuf getMBMSFlowIdentifier();
	
	void setMBMSFlowIdentifier(ByteBuf value);
	
	Long getMBMSBearerResult();
	
	void setMBMSBearerResult(Long value);
	
	List<InetAddress> getBMSCAddress();
	
	void setBMSCAddress(List<InetAddress> value);
	
	Long getBMSCPort();
	
	void setBMSCPort(Long value);
	
	Long getMB2USecurity();
	
	void setMB2USecurity(Long value);
	
	List<Long> getRadioFrequency();
	
	void setRadioFrequency(List<Long> value);
	
	List<UserplaneProtocolResult> getUserplaneProtocolResult();
	
	void setUserplaneProtocolResult(List<UserplaneProtocolResult> value);
}