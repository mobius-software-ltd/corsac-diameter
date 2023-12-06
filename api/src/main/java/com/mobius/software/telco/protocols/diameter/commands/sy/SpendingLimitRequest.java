package com.mobius.software.telco.protocols.diameter.commands.sy;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.sy.SLRequestTypeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.2	Spending-Limit-Request (SLR) command
	The SLR command, indicated by the Command-Code field set to 8388635 and the 'R' bit set in the Command Flags field, is sent by the PCRF to the OCS as part of the Initial or Intermediate Spending Limit Report Request procedure.
	Message Format:

	<SL-Request> ::= <Diameter Header: 8388635, REQ, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Auth-Application-Id }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 [ Destination-Host ]
                 [ Origin-State-Id ]
                 [ OC-Supported-Features ]
                *[ Supported-Features ]
                 { SL-Request-Type }
                *[ Subscription-Id ]
                *[ Policy-Counter-Identifier ]
                 [ Logical-Access-ID ]
                 [ Physical-Access-ID ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ AVP ]

	NOTE:	Multiple instances of the Subscription-Id AVP in the SLR command correspond to multiple types of identifier for the same subscriber, for example IMSI and MSISDN.
 */
@DiameterCommandDefinition(applicationId = 16777302, commandCode = 8388635, request = true, proxyable = true, name="SL-Request")
public interface SpendingLimitRequest extends SyRequest
{	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	public SLRequestTypeEnum getSLRequestType();
	
	void setSLRequestType(SLRequestTypeEnum value);				
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);

	public List<String> getPolicyCounterIdentifier();
	
	void setPolicyCounterIdentifier(List<String> value);				
	
	public ByteBuf getLogicalAccessID();
	
	void setLogicalAccessID(ByteBuf value);
	
	public String getPhysicalAccessID();
	
	void setPhysicalAccessID(String value);	
}