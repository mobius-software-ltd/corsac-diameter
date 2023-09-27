package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 *	5.3.72	NGAP-Cause AVP 
	The NGAP-Cause AVP (AVP code 575) is of type Grouped and indicates the NG Application Protocol cause value as specified in clause 9.4.5 of 3GPP TS 38.413 [71]. 
	AVP Format:

		NGAP-Cause ::= < AVP Header: 575 >
					  {NGAP-Group}
					  {NGAP-Value}
 */
@DiameterAvpDefinition(code = 575L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "NGAP-Cause")
public interface NGAPCause extends DiameterAvp
{
	Long getNGAPGroup();
	
	void setNGAPGroup(Long value);
	
	Long getNGAPValue();
	
	void setNGAPValue(Long value);		
}