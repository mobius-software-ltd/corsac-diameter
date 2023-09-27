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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.107 Message-Type AVP
	The Message-Type AVP (AVP code 1211) is of type Enumerated and holds the type of the message according to the
	MMS transactions e.g. submission, delivery. The following values are defined and are as specified in MMS

	Encapsulation [209]:
 	
 	1 m-send-req
 	2 m-send-conf
 	3 m-notification-ind
 	4 m-notifyresp-ind
 	5 m-retrieve-conf
 	6 m-acknowledge-ind
 	7 m-delivery-ind
 	8 m-read-rec-ind
 	9 m-read-orig-ind
 	10 m-forward-req
 	11 m-forward-conf
 	12 m-mbox-store-conf
 	13 m-mbox-view-conf
 	14 m-mbox-upload-conf
 	15 m-mbox-delete-conf 
*/
@DiameterAvpDefinition(code = 1211L, vendorId = KnownVendorIDs.TGPP_ID, name = "Message-Type")
public interface MessageType extends DiameterEnumerated<MessageTypeEnum>
{
}