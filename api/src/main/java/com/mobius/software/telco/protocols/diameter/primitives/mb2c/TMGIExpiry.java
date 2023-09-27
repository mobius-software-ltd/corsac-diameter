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
 * 	6.4.17	TMGI‑Expiry AVP
	The TMGI‑Expiry AVP (AVP code 3515) is of type Grouped. It is used by the BM‑SC to notify the GCS AS about the expiry of TMGIs.
	The TMGI AVPs shall include all TMGIs that have expired.
	AVP Format:

	TMGI-Expiry::=    < AVP Header: 3515 >
                                *{ TMGI }
                                *[ AVP ]
 */
@DiameterAvpDefinition(code = 3515L, vendorId = KnownVendorIDs.TGPP_ID, name = "TMGI‑Expiry")
public interface TMGIExpiry extends DiameterGroupedAvp
{
	List<ByteBuf> getTMGI();
	
	void setTMGI(List<ByteBuf> value);			
}