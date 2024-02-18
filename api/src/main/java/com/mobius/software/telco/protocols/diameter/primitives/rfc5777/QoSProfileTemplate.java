package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 5.3.  QoS-Profile-Template AVP

   The QoS-Profile-Template AVP (AVP Code 574) is of type Grouped and
   defines the namespace of the QoS profile (indicated in the Vendor-ID
   AVP) followed by the specific value for the profile.

   The Vendor-Id AVP contains a 32-bit IANA Private Enterprise Number
   (PEN), and the QoS-Profile-Id AVP contains the template identifier
   assigned by the vendor.  The vendor identifier of zero (0) is used
   for the IETF.
   
   QoS-Profile-Template ::= < AVP Header: 574 >
                            { Vendor-Id }
                            { QoS-Profile-Id }
                          * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.QOS_PROFILE_TEMPLATE, vendorId = -1L, name = "QoS-Profile-Template")
public interface QoSProfileTemplate extends DiameterGroupedAvp
{
	Long getVendorId();
	
	void setVendorId(Long value) throws MissingAvpException;	
	
	Long getQoSProfileId();
	
	void setQoSProfileId(Long value) throws MissingAvpException;	
}