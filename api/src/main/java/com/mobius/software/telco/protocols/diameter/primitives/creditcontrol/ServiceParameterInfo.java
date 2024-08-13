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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 8.43.  Service-Parameter-Info AVP

   The Service-Parameter-Info AVP (AVP Code 440) is of type Grouped and
   contains service-specific information used for price calculation or
   rating.  The Service-Parameter-Type AVP defines the service parameter
   type, and the Service-Parameter-Value AVP contains the parameter
   value.  The actual contents of these AVPs are not within the scope of
   this document and SHOULD be defined in another Diameter application,
   in standards written by other standardization bodies, or in service-
   specific documentation.

   In the case of an unknown service request (e.g., unknown Service-
   Parameter-Type), the corresponding Answer message MUST contain the
   error code DIAMETER_RATING_FAILED.  A Credit-Control-Answer message
   with this error MUST contain one or more Failed-AVP AVPs containing
   the Service-Parameter-Info AVPs that caused the failure.

   The Service-Parameter-Info AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

         Service-Parameter-Info ::= < AVP Header: 440 >
                                    { Service-Parameter-Type }
                                    { Service-Parameter-Value }
 */

@DiameterAvpDefinition(code = AvpCodes.SERVICE_PARAMETER_INFO, vendorId = -1, must = false, name = "Service-Parameter-Info")
public interface ServiceParameterInfo extends DiameterAvp 
{
	Long getServiceParameterType();
	
	void setServiceParameterType(Long value) throws MissingAvpException;
	
	ByteBuf getServiceParameterValue();
	
	void setServiceParameterValue(ByteBuf value) throws MissingAvpException;
}