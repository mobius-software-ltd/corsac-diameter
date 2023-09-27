package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.111	MMTel-Information AVP
	The MMTel-Information AVP (AVP code 2030) is of type Grouped. Its purpose is to allow the transmission of additional MMtel  service specific information elements. It holds MMTel supplementary services invoked during MMTel service.
	It has the following ABNF grammar:
	
	MMTel-Information :: =  < AVP Header: 2030>
 			* [ Supplementary-Service ]
 */
@DiameterAvpDefinition(code = 1203L, vendorId = KnownVendorIDs.TGPP_ID, name = "MMTel-Information")
public interface MMTelInformation extends DiameterAvp
{
	List<SupplementaryService> getSupplementaryService();
	
	void setSupplementaryService(List<SupplementaryService> value);
}