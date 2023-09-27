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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnsigned32;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.160 Quota-Holding-Time AVP
	The Quota-Holding-Time AVP (AVP code 871) is of type Unsigned32 and contains the quota holding time in seconds.
	The client shall start the quota holding timer when quota consumption ceases. This is always when traffic ceases, i.e.
	the timer is re-started at the end of each packet. The Credit-Control Client shall deem a quota to have expired when no
	traffic associated with the quota is observed for the value indicated by this AVP. The timer is stopped on sending a
	CCR and re-initialised on receiving a CCA with the previous used value or a new value of Quota-Holding-Time if
	received.
	This optional AVP may only occur in a CCA command. It is contained in the Multiple-Services-Credit-Control AVP.
	It applies equally to the granted time quota and to the granted volume quota.
	A Quota-Holding-Time value of zero indicates that this mechanism shall not be used. If the Quota-Holding-Time AVP
	is not present, then a locally configurable default value in the client shall be used. 
 */
@DiameterAvpDefinition(code = 871L, vendorId = KnownVendorIDs.TGPP_ID, name = "Quota-Holding-Time")
public interface QuotaHoldingTime extends DiameterUnsigned32
{
}