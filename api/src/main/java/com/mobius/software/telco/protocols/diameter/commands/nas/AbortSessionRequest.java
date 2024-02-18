package com.mobius.software.telco.protocols.diameter.commands.nas;
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
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * <AS-Request>  ::= < Diameter Header: 274, REQ, PXY >
                          < Session-Id >
                          { Origin-Host }
                          { Origin-Realm }
                          { Destination-Realm }
                          { Destination-Host }
                          { Auth-Application-Id }
                          [ User-Name ]
                          [ Origin-AAA-Protocol ]
                          [ Origin-State-Id ]
                          [ NAS-Identifier ]
                          [ NAS-IP-Address ]
                          [ NAS-IPv6-Address ]
                          [ NAS-Port ]
                          [ NAS-Port-Id ]
                          [ NAS-Port-Type ]
                          [ Service-Type ]
                          [ Framed-IP-Address ]
                          [ Framed-IPv6-Prefix ]
                          [ Framed-Interface-Id ]
                          [ Called-Station-Id ]
                          [ Calling-Station-Id ]
                          [ Originating-Line-Info ]
                          [ Acct-Session-Id ]
                          [ Acct-Multi-Session-Id ]
                          [ State ]
                        * [ Class ]
                        * [ Reply-Message ]
                        * [ Proxy-Info ]
                        * [ Route-Record ]
                        * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.NASREQ, commandCode = CommandCodes.ABORT_SESSION, request = true, proxyable = true, name="Abort-Session-Request")
public interface AbortSessionRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionRequest
{
	OriginAAAProtocolEnum getOriginAAAProtocol();
	
	void setOriginAAAProtocol(OriginAAAProtocolEnum value);
	
	String getNASIdentifier();
	
	void setNASIdentifier(String value);	
	
	InetAddress getNASIPAddress();
	
	void setNASIPAddress(Inet4Address value);	
	
	InetAddress getNASIPv6Address();
	
	void setNASIPv6Address(Inet6Address value);	
	
	Long getNASPort();
	
	void setNASPort(Long value);	
	
	String getNASPortId();
	
	void setNASPortId(String value);	
	
	NASPortTypeEnum getNASPortType();
	
	void setNASPortType(NASPortTypeEnum value);	
	
	ServiceTypeEnum getServiceType();	
	
	void setServiceType(ServiceTypeEnum value);	
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);	
	
	Long getFramedInterfaceId();
	
	void setFramedInterfaceId(Long value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	String getCallingStationId();
	
	void setCallingStationId(String value);
	
	ByteBuf getOriginatingLineInfo();
	
	void setOriginatingLineInfo(ByteBuf value);	
	
	public ByteBuf getAcctSessionId();
	
	void setAcctSessionId(ByteBuf value);
	
	public String getAcctMultiSessionId();
	
	void setAcctMultiSessionId(String value);
	
	ByteBuf getState();
	
	void setState(ByteBuf value);	
	
	List<ByteBuf> getDiameterClass();

	void setDiameterClass(List<ByteBuf> value);	
	
	List<String> getReplyMessage();

	void setReplyMessage(List<String> value);	
}