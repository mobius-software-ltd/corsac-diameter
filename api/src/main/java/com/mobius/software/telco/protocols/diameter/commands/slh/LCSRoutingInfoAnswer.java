package com.mobius.software.telco.protocols.diameter.commands.slh;
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
import com.mobius.software.telco.protocols.diameter.primitives.slh.AdditionalServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.slh.RIAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slh.ServingNode;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.4	LCS-Routing-Info-Answer (RIA) Command
	The LCS-Routing-Info-Answer (RIA) command, indicated by the Command-Code field set to 8388622 and the 'R' bit cleared in the Command Flags field, is sent from HSS to GMLC. 
	Message Format

	< LCS-Routing-Info-Answer> ::=	< Diameter Header: 8388622, PXY, 16777291 >
					 < Session-Id >
					 [ Vendor-Specific-Application-Id ]
					 [ Result-Code ]
					 [ Experimental-Result ] 
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					*[ Supported-Features ]
					 [ User-Name ]
					 [ MSISDN ]
					 [ LMSI ]
					 [ Serving-Node ]
					*[ Additional-Serving-Node ]
					 [ GMLC-Address ]
					 [ PPR-Address ]
					 [ RIA-Flags ]
					*[ AVP ]
					 [ Failed-AVP ]
					*[ Proxy-Info ]
					*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.SLH, commandCode = CommandCodes.LCS_ROUTING_INFO, request = false, proxyable = true, name="LCS-Routing-Info-Answer")
public interface LCSRoutingInfoAnswer extends SlhAnswer
{
	String getMSISDN();
	 
	void setMSISDN(String value);
	
	ByteBuf getLMSI();
	 
	void setLMSI(ByteBuf value);
	 		
	ServingNode getServingNode();
	 
	void setServingNode(ServingNode value);
	
	List<AdditionalServingNode> getAdditionalServingNode();
	 
	void setAdditionalServingNode(List<AdditionalServingNode> value);
	 		
	InetAddress getGMLCAddress();
	
	void setGMLCAddress(InetAddress value);
	
	InetAddress getPPRAddress();
	 
	void setPPRAddress(InetAddress value);
	
	RIAFlags getRIAFlags();
	 
	void setRIAFlags(RIAFlags value);
}