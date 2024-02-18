package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
 * 	7.3.138	Area-Scope
	The Area-Scope AVP is of type Grouped. See 3GPP TS 32.422 [23].
	The AVP format shall conform to:
	
	Area-Scope ::= <AVP header: 1624 10415>
			*[ Cell-Global-Identity ]
			*[ E-UTRAN-Cell-Global-Identity ]
			*[ Routing-Area-Identity ]
			*[ Location-Area-Identity ]
			*[ Tracking-Area-Identity ]
			*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.AREA_SCOPE, vendorId = VendorIDs.TGPP_ID, must = false, name = "Area-Scope")
public interface AreaScope extends DiameterGroupedAvp
{
	List<ByteBuf> getCellGlobalIdentity();
	
	void setCellGlobalIdentity(List<ByteBuf> value);	
	
	List<ByteBuf> getEUTRANCellGlobalIdentity();
	
	void setEUTRANCellGlobalIdentity(List<ByteBuf> value);	
	
	List<ByteBuf> getRoutingAreaIdentity();
	
	void setRoutingAreaIdentity(List<ByteBuf> value);
	
	List<ByteBuf> getLocationAreaIdentity();
	
	void setLocationAreaIdentity(List<ByteBuf> value);
	
	List<ByteBuf> getTrackingAreaIdentity();
	
	void setTrackingAreaIdentity(List<ByteBuf> value);		
}