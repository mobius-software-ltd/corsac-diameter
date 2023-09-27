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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTime;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.38 Change-Time AVP
	The Change-Time AVP (AVP code 2038) is of type Time.
	In EPC Charging, it holds the time in UTC format when the volume counts associated to the IP-CAN bearer/TDF
	session, or the service data container, is closed and reported due to charging condition change.
	For IMS Charging, it holds the time in UTC format at which the access transfer occurred.
	For MMTel Charging, it holds the time in UTC format and it is a time stamp that defines the moment when the
	conference participant has an action (e.g. creating the conference, joining in the conference, being invited into the
	conference and quiting the conference) triggering the Accounting Request message to CDF.
	In ProSe Charging, it holds the time in UTC format when the volume counts associated to the ProSe group
	communication container, is closed and reported due to ProSe charging condition change.
 */
@DiameterAvpDefinition(code = 2038L, vendorId = KnownVendorIDs.TGPP_ID, name = "Change-Time")
public interface ChangeTime extends DiameterTime
{
}