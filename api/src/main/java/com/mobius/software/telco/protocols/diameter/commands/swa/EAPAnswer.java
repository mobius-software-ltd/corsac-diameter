package com.mobius.software.telco.protocols.diameter.commands.swa;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  4.2.2.1.2	Diameter-EAP-Answer (DEA) Command
	The Diameter-EAP-Answer (DEA) command, indicated by the Command-Code field set to 268 and the 'R' bit cleared in the Command Flags field, is sent from a 3GPP AAA Server to a trusted non-3GPP access network NAS.

	< Diameter-EAP-Answer > ::=	< Diameter Header: 268, PXY >
			 < Session-Id >
			 [ DRMP ]
			 { Auth-Application-Id }
			 { Result-Code }
			 [ Experimental-Result ]
			 { Origin-Host }
			 { Origin-Realm }
			 { Auth-Request-Type }
			 [ EAP-Payload ]
			 [ User-Name ]
			 [ Session-Timeout ]
			 [ Accounting-Interim-Interval ]
			 [ EAP-Master-Session-Key ]
			*[ Redirect-Host ]
			 [ AN-Trusted ]
			*[ Supported-Features ]
			 [ Mobile-Node-Identifier]
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			…
			*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.STA, commandCode = CommandCodes.EAP, request = false, proxyable = true, name="Diameter-EAP-Answer")
public interface EAPAnswer extends SwaAnswer
{
	public AuthRequestTypeEnum getAuthRequestType();
	
	void setAuthRequestType(AuthRequestTypeEnum value) throws MissingAvpException;		
	
	ByteBuf getEAPPayload();
	
	void setEAPPayload(ByteBuf value);	
	
	Long getSessionTimeout();
	
	void setSessionTimeout(Long value);	

	Long getAccountingInterimInterval();
	
	void setAccountingInterimInterval(Long value);	
	 				 
	ByteBuf getEAPMasterSessionKey();
	
	void setEAPMasterSessionKey(ByteBuf value);	
	
	ANTrustedEnum getANTrusted();
	
	void setANTrusted(ANTrustedEnum value);				 
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	String getMobileNodeIdentifier();
	
	void setMobileNodeIdentifier(String value);				 
	
	public OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	public List<Load> getLoad();
	
	void setLoad(List<Load> value);
	
}