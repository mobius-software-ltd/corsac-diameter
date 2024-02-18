package com.mobius.software.telco.protocols.diameter.primitives.gq;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 *	6.5.11	Flows AVP
	The Flows AVP (AVP code 510) is of type Grouped, and it indicates IP flows via their flow identifiers.
	If no Flow-Number AVP(s) are supplied, the Flows AVP refers to all Flows matching the media component number.
	AVP Format:
		Flows::= < AVP Header: x >
	      	{ Media-Component-Number}
	      *	[ Flow-Number]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.FLOWS, vendorId = VendorIDs.TGPP_ID, name = "Flows")
public interface Flows extends DiameterAvp
{
	Long getMediaComponentNumber();
	
	void setMediaComponentNumber(Long value) throws MissingAvpException;
	
	List<Long> getFlowNumber();
	
	void setFlowNumber(List<Long> value);
}