package com.mobius.software.telco.protocols.diameter.commands.sh;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;

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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReferenceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.IdentitySetEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.OneTimeNotificationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.SendDataIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.SubsReqTypeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.5	Subscribe-Notifications-Request (SNR) Command
	The Subscribe-Notifications-Request (SNR) command, indicated by the Command-Code field set to 308 and the 'R' bit set in the Command Flags field, is sent by a Diameter client to a Diameter server in order to request notifications of changes in user data.
	Message Format

	< Subscribe-Notifications-Request > ::=	< Diameter Header: 308, REQ, PXY, 16777217 >
				 < Session-Id >
				 [ DRMP ]
				 { Vendor-Specific-Application-Id }
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				*[ Supported-Features ]
				 { User-Identity }
				 [ Wildcarded-Public-Identity ]
				 [ Wildcarded-IMPU ]
				*[ Service-Indication ]
				 [ Send-Data-Indication ]
				 [ Server-Name ]
				 { Subs-Req-Type }
				*{ Data-Reference }
				*[ Identity-Set ]
				 [ Expiry-Time ]
				*[ DSAI-Tag ]
				 [ One-Time-Notification]
				 [ User-Name ]
				 [ OC-Supported-Features ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SH, commandCode = CommandCodes.SUBSCRIBE_NOTIFICATION, request = true, proxyable = true, name="Subscribe-Notifications-Request")
public interface SubscribeNotificationsRequest extends ShRequest
{
	public List<ByteBuf> getServiceIndication();
	 
	void setServiceIndication(List<ByteBuf> value);
	
	public SendDataIndicationEnum getSendDataIndication();
	
	void setSendDataIndication(SendDataIndicationEnum value);
	
	public String getServerName();
	
	void setServerName(String value);
	
	public SubsReqTypeEnum getSubsReqType();
	
	void setSubsReqType(SubsReqTypeEnum value) throws MissingAvpException;
	
	public List<DataReferenceEnum> getDataReference();
	 
	void setDataReference(List<DataReferenceEnum> value) throws MissingAvpException;
	
	public List<IdentitySetEnum> getIdentitySet();
	 
	void setIdentitySet(List<IdentitySetEnum> value);
	
	Date getExpiryTime();
	
	void setExpiryTime(Date value);
	
	List<ByteBuf> getDSAITag();
	
	void setDSAITag(List<ByteBuf> value);
	
	OneTimeNotificationEnum getOneTimeNotification();
	
	void setOneTimeNotification	(OneTimeNotificationEnum value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);	
}