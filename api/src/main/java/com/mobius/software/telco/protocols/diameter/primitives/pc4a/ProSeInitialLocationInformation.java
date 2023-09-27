package com.mobius.software.telco.protocols.diameter.primitives.pc4a;
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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.9	ProSe-Initial-Location-Information
	The ProSe-Initial-Location-Information AVP is of type Grouped. This AVP shall contain the location information of the UE.
	AVP format

	ProSe-Initial-Location-Information ::= <AVP header: 3707 10415>
		 [MME-Name]
		 [E-UTRAN-Cell-Global-Identity]
		 [Tracking-Area-Identity]
		 [Age-Of-Location-Information]
		*[AVP]
 */
@DiameterAvpDefinition(code = 3707L, vendorId = KnownVendorIDs.TGPP_ID, name = "ProSe-Initial-Location-Information")
public interface ProSeInitialLocationInformation extends DiameterGroupedAvp
{
	String getMMEName();
	
	void setMMEName(String value);
	
	ByteBuf getEUTRANCellGlobalIdentity();
	
	void setEUTRANCellGlobalIdentity(ByteBuf value);	
	
	ByteBuf getTrackingAreaIdentity();
	
	void setTrackingAreaIdentity(ByteBuf value);
	
	Long getAgeOfLocationInformation();
	
	void setAgeOfLocationInformation(Long value);
}