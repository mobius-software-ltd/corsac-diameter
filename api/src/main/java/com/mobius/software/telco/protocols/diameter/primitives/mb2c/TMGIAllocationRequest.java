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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.11	TMGI‑Allocation‑Request AVP
	The TMGI‑Allocation‑Request AVP (AVP code 3509) is of type Grouped. It is used by the GCS AS to request the allocation, or timer refresh of TMGIs.
	The TMGI‑Number shall indicate the number of newly requested TMGI, excluding any TMGI where a timer refresh is requested. Any TMGIs where a timer refresh is requested shall be included in TMGI AVPs. 
	AVP Format:
	
	TMGI-Allocation-Request::=         < AVP Header: 3509 >
                                 { TMGI-Number }
                                *[ TMGI ]
                                *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TMGI_ALLOCATION_REQUEST, vendorId = VendorIDs.TGPP_ID, name = "TMGI‑Allocation‑Request")
public interface TMGIAllocationRequest extends DiameterGroupedAvp
{
	Long getTMGINumber();
	
	void setTMGINumber(Long value) throws MissingAvpException;
	
	List<ByteBuf> getTMGI();
	
	void setTMGI(List<ByteBuf> value);			
}