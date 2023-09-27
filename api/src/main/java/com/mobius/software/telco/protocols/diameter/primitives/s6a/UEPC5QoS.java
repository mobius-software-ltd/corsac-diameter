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
 * 	7.3.236	UE-PC5-QoS
	The UE-PC5-QoS AVP is of type Grouped. It shall contain the PC5 QoS parameters for V2X communication over NR PC5 reference point.
	AVP format:

	UE-PC5-QoS ::= <AVP header: 1711 10415>
			1*{ PC5-QoS-Flow }
			  [ PC5-Link-AMBR ]
			* [AVP]
 */
@DiameterAvpDefinition(code = 1711L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "UE-PC5-QoS")
public interface UEPC5QoS extends DiameterGroupedAvp
{
	List<PC5QoSFlow> getPC5QoSFlow();
	
	void setPC5QoSFlow(List<PC5QoSFlow> value);
	
	Integer getPC5LinkAMBR();
	
	void setPC5LinkAMBR(Integer value);
}