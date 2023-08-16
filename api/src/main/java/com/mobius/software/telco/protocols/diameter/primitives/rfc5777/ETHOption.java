package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.8.14.  ETH-Option AVP

   The ETH-Option AVP (AVP Code 548) is of type Grouped and specifies
   Ethernet specific attributes.

   ETH-Option ::= < AVP Header: 548 >
                  { ETH-Proto-Type }
                * [ VLAN-ID-Range ]
                * [ User-Priority-Range ]
                * [ AVP ]
 */
@DiameterAvpDefinition(code = 548L, vendorId = -1L, name = "ETH-Option")
public interface ETHOption extends DiameterGroupedAvp
{
	ETHProtoType getETHProtoType();
	
	void setETHProtoType(ETHProtoType ethProtoType);
	
	List<VLANIDRange> getVLANIDRange();
	
	void setVLANIDRange(List<VLANIDRange> value);	
	
	List<UserPriorityRange> getUserPriorityRange();
	
	void setUserPriorityRange(List<UserPriorityRange> value);
}