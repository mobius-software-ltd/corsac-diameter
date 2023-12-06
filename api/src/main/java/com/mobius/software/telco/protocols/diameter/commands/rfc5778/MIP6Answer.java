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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.MIPMNHAMSA;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.2.2.  MIP6-Answer

   	The MIP6-Answer (MIA) message, indicated by the Command-Code field
   	set to 325 and the 'R' bit cleared in the Command Flags field, is
   	sent by the Diameter server in response to the MIP6-Request message.
   	
   	The User-Name AVP MAY be included in the MIA if it is present in the
   MIR.  The Result-Code AVP MAY contain one of the values defined in
   Section 7, in addition to the values defined in [RFC3588].

   An MIA message with the Result-Code AVP set to DIAMETER_SUCCESS MUST
   include the MIP-Mobile-Node-Address AVP.

   The message format is shown below.

   <MIP6-Answer> ::= < Diameter Header: 325, PXY >
                     < Session-Id >
                     { Auth-Application-Id }
                     { Result-Code }
                     { Origin-Host }
                     { Origin-Realm }
                     { Auth-Request-Type }
                     [ User-Name ]
                     [ Authorization-Lifetime ]
                     [ Auth-Session-State ]
                     [ Error-Message ]
                     [ Error-Reporting-Host ]
                     [ Re-Auth-Request-Type ]
                     [ MIP6-Feature-Vector ]
                     [ MIP-Agent-Info ]
                   *2[ MIP-Mobile-Node-Address ]
                     [ MIP-MN-HA-MSA ]
                   * [ QoS-Resources ]
                     [ Chargeable-User-Identity ]
                     [ Service-Selection ]
                     [ Origin-State-Id ]
                   * [ Proxy-Info ]
                   * [ Redirect-Host ]
                     [ Redirect-Host-Usage ]
                     [ Redirect-Max-Cache-Time ]
                   * [ Failed-AVP ]
                   * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 8, commandCode = 325, request = false, proxyable = true, name="MIP6-Answer")
public interface MIP6Answer extends AuthenticationAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	Long getAuthorizationLifetime();
	
	void setAuthorizationLifetime(Long value);
	
	AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value);
	
	public ReAuthRequestTypeEnum getReAuthRequestType();
	
	void setReAuthRequestType(ReAuthRequestTypeEnum value);	
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);	
	
	List<InetAddress> getMIPMobileNodeAddress();
	
	void setMIPMobileNodeAddress(List<InetAddress> value);	
	
	MIPMNHAMSA getMIPMNHAMSA();
	
	void setMIPMNHAMSA(MIPMNHAMSA value);	
	
	List<QoSResources> getQoSResources();
	
	void setQoSResources(List<QoSResources> value);	
	
	ByteBuf getChargeableUserIdentity();
	
	void setChargeableUserIdentity(ByteBuf value);	
	
	String getServiceSelection();
	
	void setServiceSelection(String value);	
}