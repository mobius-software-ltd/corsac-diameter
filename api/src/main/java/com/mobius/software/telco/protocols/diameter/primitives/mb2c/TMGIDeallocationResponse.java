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
 * 	6.4.15	TMGI‑Deallocation‑Response AVP
	The TMGI‑Deallocation‑Response AVP (AVP code 3513) is of type Grouped. It is used by the BM‑SC to inform the GCS AS about the results of a TMGI deallocation request for a given TMGI.
	The TMGI AVP shall indicate the TMGI.
	For an unsuccessful TMGI deallocation request, the TMGI‑Deallocation‑Result AVP shall be included.
	AVP Format:
	
	TMGI-Deallocation-Response::=    < AVP Header: 3513 >
                                 { TMGI }
                                 [ TMGI-Deallocation-Result ]
                                *[ AVP ]
 */
@DiameterAvpDefinition(code = 3513L, vendorId = KnownVendorIDs.TGPP_ID, name = "TMGI-Deallocation-Response")
public interface TMGIDeallocationResponse extends DiameterGroupedAvp
{
	List<ByteBuf> getTMGI();
	
	void setTMGI(List<ByteBuf> value);	
	
	TMGIDeallocationResult getTMGIDeallocationResult();
	
	void setTMGIDeallocationResult(TMGIDeallocationResult value);	
}