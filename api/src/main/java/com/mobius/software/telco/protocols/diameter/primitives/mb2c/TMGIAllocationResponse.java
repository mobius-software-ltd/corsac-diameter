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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.12	TMGI‑Allocation‑Response AVP
	The TMGI‑Allocation‑Response AVP (AVP code 3510) is of type Grouped. It is used by the BM‑SC to inform the GCS AS about the result of a TMGI allocation request.
	For a successful TMGI allocation, TMGI AVPs and the MBMS‑Session‑Duration AVP shall be included. The TMGI AVPs shall contain all successfully allocated or refreshed TMGIs and the MBMS‑Session‑Duration AVP shall indicate their common new expiration time.
	For an unsuccessful TMGI allocation request, the TMGI‑Allocation‑Result AVP shall be included.
	For a partial success, if some, but not all of the requested TMGIs are allocated or timers refreshed, TMGI AVPs, the MBMS‑Session‑Duration AVP and the TMGI‑Allocation‑Result AVP shall be included. The TMGI AVPs shall contain all successfully allocated or refreshed TMGIs and the MBMS‑Session‑Duration AVP shall indicate their common new expiration time. The TMGI‑Allocation‑Result AVP shall indicate both success and the reason(s) why the allocation or refresh failed for some TMGIs.
	AVP Format:

	TMGI-Allocation-Response::=     < AVP Header: 3510 >
                                *[ TMGI ]
                                 [ MBMS-Session-Duration ]
                                 [ TMGI-Allocation-Result ]
                                *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TMGI_ALLOCATION_RESPONSE, vendorId = VendorIDs.TGPP_ID, name = "TMGI-Allocation-Response")
public interface TMGIAllocationResponse extends DiameterGroupedAvp
{
	List<ByteBuf> getTMGI();
	
	void setTMGI(List<ByteBuf> value);	
	
	ByteBuf getMBMSSessionDuration();
	
	void setMBMSSessionDuration(ByteBuf value);
	
	TMGIAllocationResult getTMGIAllocationResult();
	
	void setTMGIAllocationResult(TMGIAllocationResult value);	
}