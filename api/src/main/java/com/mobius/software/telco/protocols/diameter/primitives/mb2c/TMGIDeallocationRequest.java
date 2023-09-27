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
 * 	6.4.14	TMGI‑Deallocation‑Request AVP
	The TMGI‑Deallocation‑Request AVP (AVP code 3512) is of type Grouped. It is used by the GCS AS to request the deallocation of TMGIs.
	AVP Format:
	
	TMGI-Deallocation-Request::=     < AVP Header: 3512 >
                                *[ TMGI ]
                                *[ AVP ]
 */
@DiameterAvpDefinition(code = 3512L, vendorId = KnownVendorIDs.TGPP_ID, name = "TMGI‑Deallocation‑Request")
public interface TMGIDeallocationRequest extends DiameterGroupedAvp
{
	List<ByteBuf> getTMGI();
	
	void setTMGI(List<ByteBuf> value);			
}