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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.111Ac Monitoring-UE-Identifier AVP
	The Monitoring-UE-Identifier AVP (AVP code 3432) is of type UTF8String and carry identifier of the party who
	initiate monitor/match report, i.e. IMSI, which corresponds to UE Identifier parameter in monitor/match report request.
 */
@DiameterAvpDefinition(code = 3432L, vendorId = KnownVendorIDs.TGPP_ID, name = "Monitoring-UE-Identifier")
public interface MonitoringUEIdentifier extends DiameterUTF8String
{
}