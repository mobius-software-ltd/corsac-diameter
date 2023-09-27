package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceResult;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.53	Discovery-Auth-Request 
	The Discovery-Auth-Request is of type Grouped. It shall contain the information elements used in ProSe direct discovery authorization request.
	The AVP format shall conform to:
		
	Discovery-Auth-Request ::=		<AVP header: 3854 10415>
		 { Discovery-Type }
		 [ User-Identity ]
		 [ ProSe-App-ID ]
		 [ ProSe-App-Code ]
		 [ ProSe-App-Code-Suffix-Range ]
		 [ ProSe-Validity-Timer ]
		 [ App-Identifier ]
		 [ Requesting-RPAUID ]
		 [ Target-RPAUID ]
		 [ Target-PDUID ]
		 [ ProSe-Restricted-Code ] 
		 [ ProSe-Query-Code ] --- can not find definition
		 [ ProSe-Response-Code ] --- can not find definition
		*[ ProSe-Restricted-Code-Suffix-Range ]
		 [ Banned-RPAUID ]
		 [ Banned-PDUID ]
		 [ Service-Result ]
		 [ PC5-tech ]
		*[AVP] 

	When the Discovery-Type is set to "ANNOUNCING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Request shall contain a UE identity, a ProSe Application ID, a ProSe Application Code and optionally one or more ProSe Restricted Code Suffix-Range, ProSe Validity Timer and the PC5 radio technology that the UE is using.
	When the Discovery-Type is set to "MONITORING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Request shall contain a UE identity, a ProSe Application ID and optionally the PC5 radio technology that the UE is using.
	When the Discovery-Type is set to "ANNOUNCING_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Request shall contain a UE identity, an Application Identifier, the Requesting RPAUID, ProSe Restricted Code and optionally one or more ProSe Restricted Code SuffixRange, a ProSe Validity Timer and the PC5 radio technology that the UE is using.
	When the Discovery-Type is set to "MONITORING_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Request shall contain a UE identity, an Application Identifier, Requesting RPAUID, Target RPAUID, Target PDUID and optionally the PC5 radio technology that the UE is using.
	When the Discovery-Type is set to "DISCOVEREE_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Request shall contain a UE identity, an Application Identifier, Requesting RPAUID, a ProSe Response Code and optionally the PC5 radio technology that the UE is using.
	When the Discovery-Type is set to "DISCOVERER_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Request shall contain a UE identity, an Application Identifier, Requesting RPAUID, Target RPAUID, Target PDUID and optionally the PC5 radio technology that the UE is using.
	When the Discovery-Type is set to "DISCOVERER_ANNOUNCING_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Request shall contain a UE identity, an Application Identifier, Requesting RPAUID, a ProSe Query Code and optionally the PC5 radio technology that the UE is using.
	When the Discovery-Type is set to "MONITORING_UPDATE_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Request shall contain an Application Identifier, a ProSe Restricted Code, a Banned RPAUID, a Banned PDUID and optionally the PC5 radio technology that the UE is using.
	When the Discovery-Type is set to "MONITORING_RESPONSE_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Request shall contain an Application Identifier, ProSe-Restricted-Code, Banned RPAUID, Banned PDUID, Result and optionally the PC5 radio technology that the UE is using.
 */
@DiameterAvpDefinition(code = 3854L, vendorId = KnownVendorIDs.TGPP_ID, name = "Discovery-Auth-Request")
public interface DiscoveryAuthRequest extends DiameterGroupedAvp
{
	DiscoveryTypeEnum getDiscoveryType();
	
	void setDiscoveryType(DiscoveryTypeEnum value);
	
	UserIdentity getUserIdentity();
	
	void setUserIdentity(UserIdentity value);
	
	String getProSeAppId();
	
	void setProSeAppId(String value);
	
	ByteBuf getProSeAppCode();
	
	void setProSeAppCode(ByteBuf value);
	
	ProSeAppCodeSuffixRange getProSeAppCodeSuffixRange();
	
	void setProSeAppCodeSuffixRange(ProSeAppCodeSuffixRange value);
	
	Long getProSeValidityTimer();
	
	void setProSeValidityTimer(Long value);
	
	AppIdentifier getAppIdentifier();
	
	void setAppIdentifier(AppIdentifier value);
	
	String getRequestingRPAUID();
	
	void setRequestingRPAUID(String value);
	
	String getTargetRPAUID();
	
	void setTargetRPAUID(String value);
	
	ByteBuf getTargetPDUID();
	
	void setTargetPDUID(ByteBuf value);
	
	ByteBuf getProSeRestrictedCode();
	
	void setProSeRestrictedCode(ByteBuf value);
	
	List<ProSeRestrictedCodeSuffixRange> getProSeRestrictedCodeSuffixRange();
	
	void setProSeRestrictedCodeSuffixRange(List<ProSeRestrictedCodeSuffixRange> value);
	
	String getBannedRPAUID();
	
	void setBannedRPAUID(String value);
	
	ByteBuf getBannedPDUID();
	
	void setBannedPDUID(ByteBuf value);
	
	ServiceResult getServiceResult();
	
	void setServiceResult(ServiceResult value);
	
	ByteBuf getPC5Tech();
	
	void setPC5Tech(ByteBuf value);
}