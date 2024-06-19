package com.mobius.software.telco.protocols.diameter.primitives.s15;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

import java.util.List;
import io.netty.buffer.ByteBuf;

/* E.6.3.6	CS-Service-Resource-Report
 * CS-Service-Resource-Report AVP (AVP code 2813) is type of Grouped, 
 * and it is used to report a resource result for the CS service in the Fixed Broadband Access network.
 * CS-Service-Resource-Result-Operation AVP indicates a resource result operation of the CS service in the Fixed Broadband Access network.
 * CS-Service-QoS-Request-Identifier AVP indicates the QoS request identifier that corresponding resource result is reported by the BPCF.
 * CS-Service-Resource-Failure-Cause AVP indicates the reason why the resource is released.
 *
 *     AVP Format:
 *   CS-Service-Resource-Report ::= < AVP Header: 2813 >
 *						   *[ CS-Service-QoS-Request-Identifier ]
 *		      			    [ CS-Service-Resource-Result-Operation ]
 *						    [ CS-Service-Resource-Failure-Cause ]
 *
*/

@DiameterAvpDefinition(code = TgppAvpCodes.CS_SERVICE_RESOURCE_REPORT, vendorId = VendorIDs.TGPP_ID, must = true, name = "CS-Service-Resource-Report")
public interface CSServiceResourceReport extends DiameterAvp
{ 
	List<ByteBuf> getCSServiceQoSRequestIdentifier();
	
	void setCSServiceQoSRequestIdentifier(List<ByteBuf> value);
	
	CSServiceResourceResultOperationEnum getCSServiceResourceResultOperation();
	
	void setCSServiceResourceResultOperation(CSServiceResourceResultOperationEnum value);
	
	CSServiceResourceFailureCauseEnum getCSServiceResourceFailureCause();
	
	void setCSServiceResourceFailureCause(CSServiceResourceFailureCauseEnum value);
	
	
}
