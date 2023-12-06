package com.mobius.software.telco.protocols.diameter.commands.gi;
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
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  16a.4.4	ACA Command
	The ACA command, defined in Diameter Base (IETF RFC 6733 [111]), is indicated by the Command-Code field set to 271 and the ‘R’ bit cleared in the Command Flags field., It is sent by the Diameter server to the GGSN/P-GW in response to the ACR command.
	The relevant AVPs that are of use for the Gi/Sgi interface are detailed in the ABNF description below. Other valid AVPs for this command are not used for Gi/Sgi purposes and should be ignored by the receiver or processed according to the relevant specifications.
	Message Format:
	<AC-Answer> ::= < Diameter Header: 271, PXY >
                      	< Session-Id >
                      	{ Result-Code }
                      	{ Origin-Host }
                      	{ Origin-Realm }
                      	{ Accounting-Record-Type }
                      	{ Accounting-Record-Number }
                      	[ Acct-Application-Id ]
                      	[ User-Name ]
                      	[ Event-Timestamp ]
                      	[ Error-Message ]
                      	[ Error-Reporting-Host ]
                       	[ Failed-AVP ]
                      	[ Origin-State-Id ]
                      	[ NAS-Identifier ]
                      	[ NAS-IP-Address ]
                      	[ NAS-IPv6-Address ]
                      	[ NAS-Port ]
                      	[ NAS-Port-Id ]
                      	[ NAS-Port-Type ]
                      	[ Service-Type ]
                      	[ Accounting-Realtime-Required ]
                      	[ Acct-Interim-Interval ]
                      *	[ Class ]
                      *	[ Proxy-Info ]
                      *	[ Route-Record ]
                      *	[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 1, commandCode = 271, request = false, proxyable = true, name="Accounting-Answer")
public interface AccountingAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.AccountingAnswer
{
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
	
	List<ByteBuf> getDiameterClass();	
	
	void setDiameterClass(List<ByteBuf> value);		
}