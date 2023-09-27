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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 *	6.3.4	Server-Capabilities AVP
	The Server-Capabilities AVP is of type Grouped. This AVP contains information to assist the I-CSCF in the selection of an S-CSCF.
	AVP format

		Server-Capabilities ::= <AVP header: 603 10415>
			*[Mandatory-Capability]
			*[Optional-Capability]
			*[Server-Name]
			*[AVP]
 */
@DiameterAvpDefinition(code = 603L, vendorId = KnownVendorIDs.TGPP_ID, name = "Server-Capabilities")
public interface ServerCapabilities extends DiameterGroupedAvp
{
	List<Long> getMandatoryCapability();
	
	void setMandatoryCapability(List<Long> value);
	
	List<Long> getOptionalCapability();
	
	void setOptionalCapability(List<Long> value);
	
	List<String> getServerName();
	
	void setServerName(List<String> value);
}