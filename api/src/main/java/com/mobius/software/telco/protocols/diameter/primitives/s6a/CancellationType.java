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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.24	Cancellation-Type
	The Cancellation-Type AVP is of type Enumerated and indicates the type of cancellation. The following values are defined:
	
	MME_UPDATE_PROCEDURE (0)
	This value is used when the Cancel Location is sent to the previous MME due to a received Update Location message from a new MME or due to the HSS+UDM receiving an Nudm_UEContextManagement service request from the AMF or due to the HSS receiving Nhss_UECM_SNDeregistration service operation from UDM (see clause 5.4.2.2 of 3GPP TS 29.563 [70]).

	SGSN_UPDATE_PROCEDURE (1)
	This value is used when the Cancel Location is sent to the previous SGSN due to a received Update Location message from a new SGSN or due to the HSS+UDM receiving an Nudm_UEContextManagement service request from the AMF or due to the HSS receiving Nhss_UECM_SNDeregistration service operation from UDM (see clause 5.4.2.2 of 3GPP TS 29.563 [70]).
	
	SUBSCRIPTION_WITHDRAWAL (2)
	This value is used:
		-	when the Cancel Location is sent by the HSS to the current MME or SGSN due to withdrawal of the user's subscription by the HSS operator;
		-	when the Cancel VCSG Location is sent by the CSS to the current MME or SGSN due to withdrawal of the user's VPLMN CSG subscription by the CSS operator.
	
	UPDATE_PROCEDURE_IWF (3)
	This value is used by an IWF when interworking with a pre-Rel-8 HSS.

	INITIAL_ATTACH_PROCEDURE (4)
	This value is used when the Cancel Location is sent to the MME or SGSN due to a received Update Location message during initial attach procedure from an SGSN or MME respectively.
 */
@DiameterAvpDefinition(code = 1420L, vendorId = KnownVendorIDs.TGPP_ID, name = "Cancellation-Type")
public interface CancellationType extends DiameterEnumerated<CancellationTypeEnum>
{
}