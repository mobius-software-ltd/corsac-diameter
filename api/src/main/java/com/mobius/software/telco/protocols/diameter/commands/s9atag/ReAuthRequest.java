package com.mobius.software.telco.protocols.diameter.commands.s9atag;
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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.gx.SessionReleaseCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	A.8.6.4	Re-Authorization-Request (RAR) Command
	The RAR command, indicated by the Command-Code field set to 258 and the 'R' bit set in the Command Flags field, is sent by the PCRF to the BPCF in order to provision PCC rules and address information for the S9a session.
	Message Format:

	<RA-Request> ::= < Diameter Header: 258, REQ, PXY >
                < Session-Id >
                [ DRMP ]
                { Auth-Application-Id }
                { Origin-Host }
                { Origin-Realm }
                { Destination-Realm }
                { Destination-Host }
                { Re-Auth-Request-Type }
                [ Origin-State-Id ]
                [ OC-Supported-Features ]
               *[ Charging-Rule-Install ]
               *[ Charging-Rule-Remove ]
                [ Session-Release-Cause ]
               *[ Proxy-Info ]
               *[ Route-Record ]
               *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S9ATAG, commandCode = CommandCodes.REAUTH, request = true, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends AuthenticationRequest
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	ReAuthRequestTypeEnum getReAuthRequestType();
	
	void setReAuthRequestType(ReAuthRequestTypeEnum value) throws MissingAvpException;
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	List<ChargingRuleInstall> getChargingRuleInstall();
	
	void setChargingRuleInstall(List<ChargingRuleInstall> value);	
	
	List<ChargingRuleRemove> getChargingRuleRemove();
	
	void setChargingRuleRemove(List<ChargingRuleRemove> value);
	
	SessionReleaseCauseEnum getSessionReleaseCause();
	
	void setSessionReleaseCause(SessionReleaseCauseEnum value);
}