package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson;
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

import com.mobius.software.telco.protocols.diameter.EricssonAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUTF8String;

/**
*
* @author yulian oifa
*
*/
/*
 * 	3.1.2 Subscription-Id-Location AVP
	The Subscription-Id-Location AVP (AVP Code 1074), of type UTF8String, is
	used to define the location of a user, identified by the Subscription-Id AVP. The
	format of the UTF8String is in international E.164 format according to the ITU-T
	E.164 numbering plan defined in Reference [4].
	The Subscription-Id-Location AVP in DAAC/SCAPv2 is an optional parameter,
	but must be provided when MNP functions of the Service are to be used for
	terminating traffic cases.
	When sending the Location data it is mandatory to provide the CC and
	recommended to send NDC. LSP is considered optional.
	The AVP is in this service context defined as ‘static’ and ‘cached’
 */
@DiameterAvpDefinition(code = EricssonAvpCodes.SUBSCRIPTION_ID_LOCATION, vendorId = VendorIDs.ERICSSON_ID, name = "Subscription-Id-Location")
public interface SubscriptionIdLocation extends DiameterUTF8String
{
}