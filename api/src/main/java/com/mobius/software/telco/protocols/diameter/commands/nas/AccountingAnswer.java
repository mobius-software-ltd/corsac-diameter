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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
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
 *  The AVPs listed in the Diameter Base protocol specification [RFC6733]
   MUST be assumed to be present, as appropriate.  NAS service-specific
   accounting AVPs SHOULD be present as described in Section 4.6 and the
   rest of this specification.

      Message Format

         <AC-Answer> ::= < Diameter Header: 271, PXY >
                         < Session-Id >
                         { Result-Code }
                         { Origin-Host }
                         { Origin-Realm }
                         { Accounting-Record-Type }
                         { Accounting-Record-Number }
                         { Acct-Application-Id }
                         [ User-Name ]
                         [ Accounting-Sub-Session-Id ]
                         [ Acct-Session-Id ]
                         [ Acct-Multi-Session-Id ]
                         [ Event-Timestamp ]
                         [ Error-Message ]
                         [ Error-Reporting-Host ]
                       * [ Failed-AVP ]
                         [ Origin-AAA-Protocol ]
                         [ Origin-State-Id ]
                         [ NAS-Identifier ]
                         [ NAS-IP-Address ]
                         [ NAS-IPv6-Address ]
                         [ NAS-Port ]
                         [ NAS-Port-Id ]
                         [ NAS-Port-Type ]
                         [ Service-Type ]
                         [ Termination-Cause ]
                         [ Accounting-Realtime-Required ]
                         [ Acct-Interim-Interval ]
                       * [ Class ]
                       * [ Proxy-Info ]
                       * [ AVP ]
 */
@DiameterCommandDefinition(applicationId = 1, commandCode = 271, request = false, proxyable = true, name="Accounting-Answer")
public interface AccountingAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.AccountingAnswer
{
	OriginAAAProtocolEnum getOriginAAAProtocol();
	
	void setOriginAAAProtocol(OriginAAAProtocolEnum originAAAProtocol);	
	
	String getNASIdentifier();
	
	void setNASIdentifier(String nasIdentifier);	
	
	InetAddress getNASIPAddress();
	
	void setNASIPAddress(Inet4Address nasIPAddress);	
	
	InetAddress getNASIPv6Address();
	
	void setNASIPv6Address(Inet6Address nasIPv6Address);	
	
	Long getNASPort();
	
	void setNASPort(Long nasPort);	
	
	String getNASPortId();
	
	void setNASPortId(String nasPortId);	
	
	NASPortTypeEnum getNASPortType();
	
	void setNASPortType(NASPortTypeEnum nasPortType);	
	
	ServiceTypeEnum getServiceType();		
	
	void setServiceType(ServiceTypeEnum serviceType);	
	
	TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum terminationCauseEnum);
	
	List<ByteBuf> getDiameterClass();	
	
	void setDiameterClass(List<ByteBuf> diameterClass);		
}