package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * Exactly one AVP MUST be included inside the User-Equipment-Info-Extension AVP.
 * The User-Equipment-Info-Extension AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

    User-Equipment-Info-Extension ::= < AVP Header: 653 >
                                  [ User-Equipment-Info-IMEISV ]
                                  [ User-Equipment-Info-MAC ]
                                  [ User-Equipment-Info-EUI64 ]
                                  [ User-Equipment-Info-ModifiedEUI64 ]
                                  [ User-Equipment-Info-IMEI ]
                                  [ AVP ]
 */
@DiameterAvpDefinition(code = 653L, vendorId = -1, must = false, name = "User-Equipment-Info-Extension")
public interface UserEquipmentInfoExtension extends DiameterGroupedAvp 
{
	ByteBuf getIMEISV();
	
	void setIMEISV(ByteBuf imeiSV);
	
	ByteBuf getMAC();
	
	void setMAC(ByteBuf mac);
	
	ByteBuf getEUI64();
	
	void setEUI64(ByteBuf eui64);
	
	ByteBuf getModifiedEUI64();
	
	void setModifiedEUI64(ByteBuf modifiedEUI64);
	
	ByteBuf getIMEI();
	
	void setIMEI(ByteBuf imei);
}