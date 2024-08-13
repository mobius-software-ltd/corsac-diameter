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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
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
 * 8.52.  User-Equipment-Info-Extension AVP

   The User-Equipment-Info-Extension AVP (AVP Code 653) is of type
   Grouped and allows the credit-control client to indicate the identity
   and capability of the terminal the subscriber is using for the
   connection to the network.  If the type of the equipment is one of
   the enumerated User-Equipment-Info-Type AVP values, then the
   credit-control client SHOULD send the information in the
   User-Equipment-Info AVP, in addition to or instead of the
   User-Equipment-Info-Extension AVP.  This is done in order to preserve
   backward compatibility with credit-control servers that support only
   [RFC4006].  Exactly one AVP MUST be included inside the
   User-Equipment-Info-Extension AVP.

   The User-Equipment-Info-Extension AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

    User-Equipment-Info-Extension ::= < AVP Header: 653 >
                                  [ User-Equipment-Info-IMEISV ]
                                  [ User-Equipment-Info-MAC ]
                                  [ User-Equipment-Info-EUI64 ]
                                  [ User-Equipment-Info-ModifiedEUI64 ]
                                  [ User-Equipment-Info-IMEI ]
                                  [ AVP ]  
 */
@DiameterAvpDefinition(code = AvpCodes.USER_EQUIPMENT_INFO_EXTENSION, vendorId = -1, must = false, name = "User-Equipment-Info-Extension")
public interface UserEquipmentInfoExtension extends DiameterGroupedAvp 
{
	ByteBuf getIMEISV();
	
	void setIMEISV(ByteBuf value) throws MissingAvpException;
	
	ByteBuf getMAC();
	
	void setMAC(ByteBuf value) throws MissingAvpException;
	
	ByteBuf getEUI64();
	
	void setEUI64(ByteBuf value) throws MissingAvpException;
	
	ByteBuf getModifiedEUI64();
	
	void setModifiedEUI64(ByteBuf value) throws MissingAvpException;
	
	ByteBuf getIMEI();
	
	void setIMEI(ByteBuf value) throws MissingAvpException;
}