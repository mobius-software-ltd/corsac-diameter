package com.mobius.software.telco.protocols.diameter.commands.rfc5778;
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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  5.1.2.  Diameter-EAP-Answer

   	The Diameter-EAP-Answer (DEA) message, indicated by the Command-Code
   	field set to 268 and 'R' bit cleared in the Command Flags field, is
   	sent in response to the Diameter-EAP-Request (DER) message.  The
   	Application-Id field in the Diameter message header MUST be set to
   	the Diameter Mobile IPv6 IKE Application-Id (value of 7).  If the
   	Mobile IPv6 authentication procedure was successful, then the
   	response MAY include any set of bootstrapping AVPs.
   
   	<Diameter-EAP-Answer> ::= < Diameter Header: 268, PXY >
                             < Session-Id >
                             { Auth-Application-Id }
                             { Auth-Request-Type }
                             { Result-Code }
                             { Origin-Host }
                             { Origin-Realm }
                             [ User-Name ]
                             [ EAP-Payload ]
                             [ EAP-Reissued-Payload ]
                             [ EAP-Master-Session-Key ]
                             [ EAP-Key-Name ]
                             [ Multi-Round-Time ]
                             ...
                           *2[ MIP-Mobile-Node-Address ]
                             [ MIP6-Feature-Vector ]
                             [ MIP6-Agent-Info ]
                             [ Service-Selection ]
                           * [ QoS-Resources ]
                             [ Chargeable-User-Identity ]
                             ...
                           * [ AVP ]
                           
                           
    If the EAP-based authentication and the authorization for the
   	mobility service succeeds, then the Mobile IPv6 bootstrapping AVPs
   	are included in the last DEA message that also carries the EAP-
   	Success EAP payload.  The other DEA messages required by the used
   	EAP-method do not include any Mobile IPv6 bootstrapping AVPs.
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.MIP6I, commandCode = CommandCodes.EAP, request = false, proxyable = true, name="Diameter-EAP-Answer")
public interface EAPAnswer extends AuthenticationAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException;		
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value);	
	
	ByteBuf getEAPReissuedPayload();
	
	void setEAPReissuedPayload(ByteBuf value);	
	
	ByteBuf getEAPMasterSessionKey();
	
	void setEAPMasterSessionKey(ByteBuf value);	
	
	ByteBuf getEAPKeyName();
	
	void setEAPKeyName(ByteBuf value);	
	        		  
	Long getMultiRoundTimeOut();
	
	void setMultiRoundTimeOut(Long value);	
	
	List<InetAddress> getMIPMobileNodeAddress();
	
	void setMIPMobileNodeAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException;	
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);	
	
	String getServiceSelection();
	
	void setServiceSelection(String value);	
	
	List<QoSResources> getQoSResources();
	
	void setQoSResources(List<QoSResources> value);
	
	ByteBuf getChargeableUserIdentity();
	
	void setChargeableUserIdentity(ByteBuf value);
}