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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleInstall;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleRemove;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

/**
*
* @author yulian oifa
*
*/

/*
 *  A.8.6.3	CC-Answer (CCA) Command
	The CCA command, indicated by the Command-Code field set to 272 and the 'R' bit cleared in the Command Flags field, is sent by the PCRF to the BPCF in response to the CCR command. It is used to provision PCC rules for the S9a session.
	Message Format:

	<CC-Answer> ::=  < Diameter Header: 272, PXY >
                < Session-Id >
                [ DRMP ]
                { Auth-Application-Id }
                { Origin-Host }
                { Origin-Realm }
                [ Result-Code ]
                [ Experimental-Result ]
                { CC-Request-Type }
                { CC-Request-Number }
                [ OC-Supported-Features ]
                [ OC-OLR ]
               *[ Supported-Features]
               *[ Charging-Rule-Install ]
               *[ Charging-Rule-Remove ]
                [ Origin-State-Id ]
                [ Error-Message ]
                [ Error-Reporting-Host ]
                [ Failed-AVP ]
               *[ Proxy-Info ]
               *[ Route-Record ]
               *[ Load ]
               *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S9ATAG, commandCode = CommandCodes.CREDIT_CONTROL, request = false, proxyable = true, name="Credit-Control-Answer")
public interface CreditControlAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlAnswer
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value) throws MissingAvpException;
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value) throws MissingAvpException;
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	List<ChargingRuleInstall> getChargingRuleInstall();
	
	void setChargingRuleInstall(List<ChargingRuleInstall> value);	
	
	List<ChargingRuleRemove> getChargingRuleRemove();
	
	void setChargingRuleRemove(List<ChargingRuleRemove> value);
	
	List<Load> getLoad();
	
	void setLoad(List<Load> value);	
	
	public List<String> getRouteRecords(); 

	public void setRouteRecords(List<String> value);
}