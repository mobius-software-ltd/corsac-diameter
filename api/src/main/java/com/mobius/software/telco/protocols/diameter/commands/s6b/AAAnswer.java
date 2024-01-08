package com.mobius.software.telco.protocols.diameter.commands.s6b;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSResources;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	9.2.2.2.2	AA-Answer (AAA) Command
	The AA-Answer (AAA) command, indicated by the Command-Code field set to 265 and the "R" bit cleared in the Command Flags field, is sent from the 3GPP AAA Server to the PDN GW. The Command Code value and ABNF are re-used from the IETF RFC 4005 [4] AA-Answer command. New AVPs are added using the *[AVP] extension mechanism in the original ABNF.
	NOTE:	This command is used for the S6b Authorization Procedure for PMIPv6 or GTPv2, and also for the S6b Service Authorization Information Update procedure for PMIPv6, GTPv2 or DSMIPv6 following a previous RAR/RAA command exchange initiated by the 3GPP AAA Server.
   
   	<AA-Answer> ::=	< Diameter Header: 265, PXY, 16777272 >
			 < Session-Id >
			 [ DRMP ]
			 { Auth-Application-Id }
			 { Auth-Request-Type }
			 { Result-Code }
			 { Origin-Host }
			 { Origin-Realm }
			...
			 [ MIP6-Feature-Vector ]
			 [ Session-Timeout ]
			 [ APN-Configuration ]
			 [ QoS-Resources ]
			 [ AN-Trusted ]
			*[ Redirect-Host ]
			 [ Trace-Info ]
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			*[ Supported-Features ]
			...
			*[ AVP ]
			
	9.2.2.5.2	AA-Answer (AAA) Command
	The AA-Answer (AAA) command, indicated by the Command-Code field set to 265 and the "R" bit cleared in the Command Flags field, is sent from a 3GPP AAA Server to a PDN GW. The Command Code value and ABNF are re-used from the IETF RFC 4005 [4] AA-Answer command. New AVPs are added using the *[AVP] extension mechanism in the original ABNF.
   
   	<AA-Answer> ::=	< Diameter Header: 265, PXY, 16777272 >
			 < Session-Id >
			 [ DRMP ]
			 { Auth-Application-Id }
			 { Auth-Request-Type }
			 { Result-Code }
			 { Origin-Host }
			 { Origin-Realm }
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			...
			 [ MIP6-Feature-Vector ]
			 [ Session-Timeout ]
			 [ APN-Configuration ]
			 [ QoS-Resources ]
			*[ Redirect-Host ]
			*[ Supported-Features ]
			 [MIP-Session-Key]
			...
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777272, commandCode = 265, request = false, proxyable = true, name="AA-Answer")
public interface AAAnswer extends S6bAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value);		
	
	ANTrustedEnum getANTrusted();
	
	void setANTrusted(ANTrustedEnum value);
	
	TraceInfo getTraceInfo();

	void setTraceInfo(TraceInfo value);
	
	public OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	
	void setLoad(List<Load> value);
	
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	Long getSessionTimeout();
	
	void setSessionTimeout(Long value);
	
	APNConfiguration getAPNConfiguration();
	
	void setAPNConfiguration(APNConfiguration value);	
	
	QoSResources getQoSResources();
	
	void setQoSResources(QoSResources value);
	
	public List<SupportedFeatures> getSupportedFeatures();
			 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	ByteBuf getMIPSessionKey();
	
	void setMIPSessionKey(ByteBuf value);
}