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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  The Service-Parameter-Info AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

         Service-Parameter-Info ::= < AVP Header: 440 >
                                    { Service-Parameter-Type }
                                    { Service-Parameter-Value }
 */

@DiameterAvpDefinition(code = 440L, vendorId = -1, must = false, name = "Service-Parameter-Info")
public interface ServiceParameterInfo extends DiameterAvp 
{
	Long getServiceParameterType();
	
	void setServiceParameterType(Long serviceParameterType);
	
	ByteBuf getServiceParameterValue();
	
	void setServiceParameterValue(ByteBuf serviceParameterValue);
}