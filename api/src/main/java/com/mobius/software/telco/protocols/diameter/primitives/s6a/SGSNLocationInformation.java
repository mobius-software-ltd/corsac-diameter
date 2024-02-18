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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.116	SGSN-Location-Information
	The SGSN-Location-Information AVP is of type Grouped. It shall contain the information related to the user location relevant for the SGSN.
	AVP format

	SGSN-Location-Information ::= <AVP header: 1601 10415>
		[Cell-Global-Identity]
		[Location-Area-Identity]
		[Service-Area-Identity]
		[Routing-Area-Identity]
		[Geographical-Information]
		[Geodetic-Information]
		[Current-Location-Retrieved]
		[Age-Of-Location-Information]
		[ User-CSG-Information]
		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SGSN_LOCATION_INFORMATION, vendorId = VendorIDs.TGPP_ID, must = false, name = "SGSN-Location-Information")
public interface SGSNLocationInformation extends DiameterGroupedAvp
{
	ByteBuf getCellGlobalIdentity();
	
	void setCellGlobalIdentity(ByteBuf value);	
	
	ByteBuf getLocationAreaIdentity();
	
	void setLocationAreaIdentity(ByteBuf value);
	
	ByteBuf getServiceAreaIdentity();
	
	void setServiceAreaIdentity(ByteBuf value);
	
	ByteBuf getRoutingAreaIdentity();
	
	void setRoutingAreaIdentity(ByteBuf value);
	
	ByteBuf getGeographicalInformation();
	
	void setGeographicalInformation(ByteBuf value);
	
	ByteBuf getGeodeticInformation();
	
	void setGeodeticInformation(ByteBuf value);
	
	CurrentLocationRetrievedEnum getCurrentLocationRetrieved();
	
	void setCurrentLocationRetrieved(CurrentLocationRetrievedEnum value);
	
	Long getAgeOfLocationInformation();
	
	void setAgeOfLocationInformation(Long value);
	
	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);
}