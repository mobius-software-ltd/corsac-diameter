package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUri;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
	6.3.20	Primary-Event-Charging-Function-Name AVP
	The Primary-Event-Charging-Function-Name AVP is of type DiameterURI. This AVP contains the address of the Primary Online Charging Function. The receiving network element shall extract the FQDN 
	of the DiameterURI in this AVP and may use it as content of the Destination-Host AVP for the Diameter accounting requests. The parent domain of the FQDN in the DiameterURI shall be used as Destination-Realm. 
	The number of labels used for the Destination-Realm shall be determined before the Charging Information is provisioned and may be a configuration option.
	
	NOTE:	A FQDN is an absolute domain name including a subdomain and its parent domain. The subdomain and the parent domain contain one or more labels separated by dots.
 */
@DiameterAvpDefinition(code = 619L, vendorId = KnownVendorIDs.TGPP_ID, name = "Primary-Event-Charging-Function-Name")
public interface PrimaryEventChargingFunctionName extends DiameterUri
{
}