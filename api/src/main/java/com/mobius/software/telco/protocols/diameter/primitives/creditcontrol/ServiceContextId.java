package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.42.  Service-Context-Id AVP

   The Service-Context-Id AVP is of type UTF8String (AVP Code 461) and
   contains a unique identifier of the Diameter Credit-Control service-
   specific document (as defined in Section 4.1.2) that applies to the
   request.  This is an identifier allocated by the service provider,
   the Service Element manufacturer, or a standardization body, and MUST
   uniquely identify a given Diameter Credit-Control service-specific
   document.  The format of the Service-Context-Id is:

   "service-context" "@" "domain"

   service-context = Token

   The Token is an arbitrary string of characters and digits.

   "domain" represents the entity that allocated the Service-Context-Id.
   It can be ietf.org, 3gpp.org, etc. if the identifier is allocated by
   a standardization body, or it can be the Fully Qualified Domain Name
   (FQDN) of the service provider (e.g., provider.example.com) or the
   vendor (e.g., vendor.example.com) if the identifier is allocated by a
   private entity.

   This AVP SHOULD be placed as close to the Diameter header as
   possible.
   
   Service-specific documents that are for private use only (i.e., for
   one provider's own use, where no interoperability is deemed useful)
   may define private identifiers without a need for coordination.
   However, when interoperability is desired, coordination of the
   identifiers via, for example, publication of an informational RFC is
   RECOMMENDED in order to make the Service-Context-Id AVP globally
   available.
 */
@DiameterAvpDefinition(code = 461L, vendorId = -1L, name = "Service-Context-Id")
public interface ServiceContextId extends DiameterUTF8String
{
}