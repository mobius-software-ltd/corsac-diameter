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

import java.util.Date;
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
 * 	7.3.78	CSG-Subscription-Data
	The CSG-Subscription-Data AVP is of type Grouped. This AVP shall contain the CSG-Id, and may contain the associated Visited-PLMN-Id, an associated expiration date and the APNs which are allowed to be accessed via Local IP Access from the CSG.
	If the Visited-PLMN-Id is not present, the CSG-Subscription-Data corresponds to the registered PLMN (i.e. the visited PLMN) of the MME or the SGSN.
	AVP format

	CSG-Subscription-Data ::= <AVP header: 1436 10415>
			 { CSG-Id }
			 [ Expiration-Date ]
			*[ Service-Selection ]
			 [ Visited-PLMN-Id ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 1436L, vendorId = KnownVendorIDs.TGPP_ID, name = "CSG-Subscription-Data")
public interface CSGSubscriptionData extends DiameterGroupedAvp
{
	Long getCSGId();
	
	void setCSGId(Long value);	
	
	Date getExpirationDate();
	
	void setExpirationDate(Date value);	
	
	List<String> getServiceSelection();
	
	void setServiceSelection(List<String> value);	
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);	
}