package com.mobius.software.telco.protocols.diameter.commands.rfc5778i;
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

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 5.1.1.  Diameter-EAP-Request

   	The Diameter-EAP-Request (DER) message, indicated by the Command-Code
   	field set to 268 and the 'R' bit set in the Command Flags field, is
   	sent by the HA to the Diameter server to initiate a Mobile IPv6
   	service authentication and authorization procedure.  The
   	Application-ID field of the Diameter Header MUST be set to the
   	Diameter Mobile IPv6 IKE Application ID (value of 7).  The grouped
   	AVP has the following modified ABNF (as defined in [RFC3588]):
   
   	<Diameter-EAP-Request> ::= < Diameter Header: 268, REQ, PXY >
                              < Session-Id >
                              { Auth-Application-Id }
                              { Origin-Host }
                              { Origin-Realm }
                              { Destination-Realm }
                              { Auth-Request-Type }
                              [ Destination-Host ]
                              [ NAS-Identifier ]
                              [ NAS-IP-Address ]
                              [ NAS-IPv6-Address ]
                              [ NAS-Port-Type ]
                              [ User-Name ]
                              ...
                              { EAP-Payload }
                              ...
                              [ MIP6-Feature-Vector ]
                              [ MIP6-Agent-Info ]
                            *2[ MIP-Mobile-Node-Address ]
                              [ Chargeable-User-Identity ]
                              [ Service-Selection ]
                              [ QoS-Capability ]
                            * [ QoS-Resources ]
                              ...
                            * [ AVP ]

   Mobile IPv6 bootstrapping AVPs are only included in the first DER
   message send by the HA.  The subsequent DER messages required by the
   EAP method do not need to include any Mobile IPv6 bootstrapping AVPs.
   The MN is both authenticated and authorized for the mobility service
   during the EAP authentication.  Thus, the Auth-Request-Type AVP MUST
   be set to the value AUTHORIZE_AUTHENTICATE.
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.MIP6I, commandCode = CommandCodes.EAP, request = true, proxyable = true, name="Diameter-EAP-Request")
public interface EAPRequest extends AuthenticationRequest
{	
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException;		
	
	String getNASIdentifier();
	
	void setNASIdentifier(String value);	
	
	InetAddress getNASIPAddress();
	
	void setNASIPAddress(Inet4Address value);	
	
	InetAddress getNASIPv6Address();
	
	void setNASIPv6Address(Inet6Address value);	
	
	NASPortTypeEnum getNASPortType();
	
	void setNASPortType(NASPortTypeEnum value);	
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value) throws MissingAvpException;	
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	MIP6AgentInfo getMIP6AgentInfo();
	
	void setMIP6AgentInfo(MIP6AgentInfo value);	
	
	List<InetAddress> getMIPMobileNodeAddress();
	
	void setMIPMobileNodeAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException;	
	
	ByteBuf getChargeableUserIdentity();
	
	void setChargeableUserIdentity(ByteBuf value);	
	
	String getServiceSelection();
	
	void setServiceSelection(String value);	
	
	QoSCapability getQoSCapability();
	
	void setQoSCapability(QoSCapability value);	
	
	List<QoSResources> getQoSResources();
	
	void setQoSResources(List<QoSResources> value);	
}