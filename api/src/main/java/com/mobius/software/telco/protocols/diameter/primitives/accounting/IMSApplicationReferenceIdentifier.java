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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.74A IMS-Application-Reference-Identifier AVP
	The IMS-Application-Reference-Identifier AVP (AVP code 2601) is of type UTF8String and holds the IMS Application
	Reference Identifier (IARI) as contained in a SIP request to identify an IMS Application as defined in TS 24.229 [202].
	Editor's Note: The SIP parameter from which the IMS Application Reference ID (IARI) is to be extracted requires
	further investigation in CT1. A mechanism to identify the IARI in use is FFS. 
 */
@DiameterAvpDefinition(code = TgppAvpCodes.IMS_APPLICATION_REFERENCE_IDENTIFIER, vendorId = VendorIDs.TGPP_ID, name = "IMS-Application-Reference-Identifier")
public interface IMSApplicationReferenceIdentifier extends DiameterUTF8String
{
}