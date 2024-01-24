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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.86	LCS-PrivacyException
	The LCS-PrivacyException AVP is of type Grouped. This AVP shall contain the classes of LCS Client that are allowed to locate any target UE.
	AVP format
	LCS-PrivacyException ::= <AVP header: 1475 10415>
			 { SS-Code }
			 { SS-Status }
			 [ Notification-To-UE-User ]
			*[ External-Client ]
			*[ PLMN-Client ]
			*[ Service-Type ]
			*[AVP]
 */
@DiameterAvpDefinition(code = 1475L, vendorId = KnownVendorIDs.TGPP_ID, name = "LCS-Privacy-Exception")
public interface LCSPrivacyException extends DiameterGroupedAvp
{
	ByteBuf getSSCode();
	
	void setSSCode(ByteBuf value);	
	
	ByteBuf getSSStatus();
	
	void setSSStatus(ByteBuf value);
	
	NotificationToUEUserEnum getNotificationToUEUser();
	
	void setNotificationToUEUser(NotificationToUEUserEnum value);
	
	List<ExternalClient> getExternalClient();
	
	void setExternalClient(List<ExternalClient> value);
	
	List<PLMNClientEnum> getPLMNClient();
	
	void setPLMNClient(List<PLMNClientEnum> value);
	
	List<ServiceType> getServiceType();
	
	void setServiceType(List<ServiceType> value);
}