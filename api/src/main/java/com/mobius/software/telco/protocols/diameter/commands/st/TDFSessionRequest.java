package com.mobius.software.telco.protocols.diameter.commands.st;
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
import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventReportIndication;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleRemove;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5c.6.2 	TDF-Session-Request (TSR) Command
	The TSR command, indicated by the Command-Code field set to 8388637 and the 'R' bit set in the Command Flags field, is sent by the PCRF to the TSSF in order to establish an St session, provision and update ADC rules. 
	Message Format:

	<TS-Request> ::= < Diameter Header: 8388637, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Vendor-Specific-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Request-Type }
				 [ Destination-Host ]
				 [ Origin-State-Id ]
				 [ OC-Supported-Features ]
				 [ Event-Report-Indication ]
				 [ Framed-IP-Address ]
				 [ Framed-Ipv6-Prefix ]
				 [ Called-Station-Id ]
				*[ ADC-Rule-Install ]
				*[ ADC-Rule-Remove ]
				*[ Supported-Features ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777349, commandCode = 8388637, request = true, proxyable = true, name="TS-Request")
public interface TDFSessionRequest extends StRequest
{
	EventReportIndication getEventReportIndication();
	
	void setEventReportIndication(EventReportIndication value);
	
	InetAddress getFramedIPAddress();
	
	void setFramedIPAddress(Inet4Address value);	
	
	ByteBuf getFramedIPv6Prefix();
	
	void setFramedIPv6Prefix(ByteBuf value);
	
	String getCalledStationId();
	
	void setCalledStationId(String value);	
	
	List<ADCRuleInstall> getADCRuleInstall();
	
	void setADCRuleInstall(List<ADCRuleInstall> value);	
	
	List<ADCRuleRemove> getADCRuleRemove();
	
	void setADCRuleRemove(List<ADCRuleRemove> value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
}