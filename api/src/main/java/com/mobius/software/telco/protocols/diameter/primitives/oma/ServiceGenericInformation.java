package com.mobius.software.telco.protocols.diameter.primitives.oma;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.5.10 Service-Generic-Information AVP
	The Service-Generic-Information AVP (AVP code 1256) is of type Grouped refer [TS32.299]. Its purpose is to allow the
	transmission of additional OMA service/enabler specific information elements which are common to different
	service/enablers.

	<Services-Generic-Information> ::= < AVP Header: 1256 >
		[ Application-Server-ID ]
		[ Application-Service-Type ]
		[ Application-Session-ID ]
		[ Delivery-Status ] 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SERVICE_GENERIC_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "Service-Generic-Information")
public interface ServiceGenericInformation extends DiameterAvp
{
	String getApplicationServerID();
	
	void setApplicationServerID(String value);
	
	ApplicationServiceTypeEnum getApplicationServiceType();
	
	void setApplicationServiceType(ApplicationServiceTypeEnum value);
	
	Long getApplicationSessionID();
	
	void setApplicationSessionID(Long value);
	
	String getDeliveryStatus();
	
	void setDeliveryStatus(String value);
}