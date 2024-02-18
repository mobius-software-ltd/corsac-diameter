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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.54	Discovery-Auth-Response
	The Discovery-Auth-Response is of type Grouped. It shall contain the information elements used in ProSe direct discovery authorization answer.
	The AVP format shall conform to:
		
	Discovery-Auth-Response ::=		<AVP header: 3855 10415>
		 { Discovery-Type }
		*[ ProSe-Discovery-Filter ]
		 [ Visited-PLMN-Id ]
		 [ ProSe-Restricted-Code ]
		 [ ProSe-Query-Code ] --- can not find definition
		 [ ProSe-Response-Code ] --- can not find definition
		 [ ProSe-Validity Timer ]
		 [ Code-Sending-Security-Material ]
		 [ Code-Receiving-Security-Material ]
		 [ DUIK ]
		 [ PC5-tech ]
 		*[AVP]

	When the Discovery-Type is set to "ANNOUNCING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Response shall contain no other parameters.
	When the Discovery-Type is set to "MONITORING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Response shall contain one or more ProSe Discovery Filters, optionally a PLMN ID and the PC5 radio technology that the UE is using.
	When the Discovery-Type is set to "MONITORING_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Response shall contain a ProSe Restricted Code, a Code Receiving Security Material, optionally a DUIK, a ProSe Validity Timer and the PC5 radio technology that the UE is using. The DUIK parameter shall be included in Discovery-Auth-Response only if the Code-Receiving-Security-Material contains a MIC Check Indicator set to MIC_CHECK_BY_PROSE_FUNCTION.
	When the Discovery-Type is set to "DISCOVERER_REQUEST_FOR_RESTRICTED_PROSE_DIRECT_DISCOVERY", the Discovery-Auth-Response shall contain a ProSe Query Code, a Code Sending Security Material, a ProSe Response Code, a Code Receiving Security Material, optionally a DUIK, a ProSe Validity Timer and the PC5 radio technology that the UE is using. The DUIK parameter shall be included in Discovery-Auth-Response only if the Code-Receiving-Security-Material contains a MIC Check Indicator set to MIC_CHECK_BY_PROSE_FUNCTION.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.DISCOVERY_AUTH_RESPONSE, vendorId = VendorIDs.TGPP_ID, name = "Discovery-Auth-Response")
public interface DiscoveryAuthResponse extends DiameterGroupedAvp
{
	DiscoveryTypeEnum getDiscoveryType();
	
	void setDiscoveryType(DiscoveryTypeEnum value) throws MissingAvpException;
	
	List<ProSeDiscoveryFilter> getProSeDiscoveryFilter();
	
	void setProSeDiscoveryFilter(List<ProSeDiscoveryFilter> value);
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
	
	ByteBuf getProSeRestrictedCode();
	
	void setProSeRestrictedCode(ByteBuf value);
	
	Long getProSeValidityTimer();
	
	void setProSeValidityTimer(Long value);
	
	CodeSendingSecurityMaterial getCodeSendingSecurityMaterial();
	
	void setCodeSendingSecurityMaterial(CodeSendingSecurityMaterial value);
	
	CodeReceivingSecurityMaterial getCodeReceivingSecurityMaterial();
	
	void setCodeReceivingSecurityMaterial(CodeReceivingSecurityMaterial value);
	
	ByteBuf getDUIK();
	
	void setDUIK(ByteBuf value);
	
	ByteBuf getPC5Tech();
	
	void setPC5Tech(ByteBuf value);
}