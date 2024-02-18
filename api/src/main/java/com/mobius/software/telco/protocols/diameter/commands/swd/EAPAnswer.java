package com.mobius.software.telco.protocols.diameter.commands.swd;
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
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc6734.Key;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.sta.DEAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sta.TWANConnectivityParameters;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TraceInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  6.2.2.1.1.2	Diameter-EAP-Answer (DEA) Command
	The Diameter-EAP-Answer (DEA) command, indicated by the Command-Code field set to 268 and the "R" bit cleared in the Command Flags field, is sent from a 3GPP AAA server to a 3GPP AAA Proxy. The ABNF is re-used from the IETF RFC 5779 [2]. The ABNF also contains AVPs that are reused from IETF RFC 4072 [5].
	< Diameter-EAP-Answer > ::=	< Diameter Header: 268, PXY, 16777250 >
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
				 [ Context-Identifier ]
				 [ APN-OI-Replacement ]
				*[ APN-Configuration ]
				 [ MIP6-Feature-Vector ]
				 [ Mobile-Node-Identifier ]
				*[ Redirect-Host ] ]
				 [ Trace-Info ]
				 [ Subscription-ID ]
				*[ Supported-Features ]
				 [ DEA-Flags ]
				 [ TWAN-Connection-Mode ]
				 [ TWAN-Connectivity-Parameters ]
				 [ Terminal-Information ]
				 [ Key ]
				 [ ERP-Realm ]
				…
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.STA, commandCode = CommandCodes.EAP, request = false, proxyable = true, name="Diameter-EAP-Answer")
public interface EAPAnswer extends SwdAnswer
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
	
	Long getContextIdentifier();
	
	void setContextIdentifier(Long value);
	
	String getAPNOIReplacement();
	
	void setAPNOIReplacement(String value);
	
	List<APNConfiguration> getAPNConfiguration();
				
	void setAPNConfiguration(List<APNConfiguration> value);	
				
	Long getMIP6FeatureVector();
	
	void setMIP6FeatureVector(Long value);	
	
	String getMobileNodeIdentifier();
				
	void setMobileNodeIdentifier(String value);								 
	
	TraceInfo getTraceInfo();

	void setTraceInfo(TraceInfo value);
	
	SubscriptionId getSubscriptionID();
	
	void setSubscriptionID(SubscriptionId value);					 	
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);		
	
	public DEAFlags getDEAFlags();
	
	public void setDEAFlags(DEAFlags value);
	
	public Long getTWANConnectionMode();
	
	public void setTWANConnectionMode(Long value);
	
	public TWANConnectivityParameters getTWANConnectivityParameters();
	
	public void setTWANConnectivityParameters(TWANConnectivityParameters value);
	
	public TerminalInformation getTerminalInformation();
    
    public void setTerminalInformation(TerminalInformation value);        
    
    public Key getKey();
    
    public void setKey(Key value);
    
    public String getERPRealm();
    
    public void setERPRealm(String value);
}