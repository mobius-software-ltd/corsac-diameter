package com.mobius.software.telco.protocols.diameter.primitives.common;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIdentity;

/**
*
* @author yulian oifa
*
*/
/*
 * 7.4.  Error-Reporting-Host AVP

   The Error-Reporting-Host AVP (AVP Code 294) is of type
   DiameterIdentity.  This AVP contains the identity of the Diameter
   host that sent the Result-Code AVP to a value other than 2001
   (Success), only if the host setting the Result-Code is different from
   the one encoded in the Origin-Host AVP.  This AVP is intended to be
   used for troubleshooting purposes, and it MUST be set when the
   Result-Code AVP indicates a failure.
 */
@DiameterAvpDefinition(code = AvpCodes.ERROR_REPORTING_HOST, vendorId = -1L, must = false, name = "Error-Reporting-Host")
public interface ErrorReportingHost extends DiameterIdentity
{
}