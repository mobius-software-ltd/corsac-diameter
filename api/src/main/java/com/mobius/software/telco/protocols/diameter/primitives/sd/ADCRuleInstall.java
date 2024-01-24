package com.mobius.software.telco.protocols.diameter.primitives.sd;
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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MonitoringFlags;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5b.3.1	ADC-Rule-Install AVP
	The ADC-Rule-Install AVP (AVP code 1092) is of type Grouped, and it is used to activate, install or modify ADC rules as instructed from the PCRF.
	For installing a new ADC rule or modifying an ADC rule already installed, ADC-Rule-Definition AVP shall be used.
	For activating a specific predefined ADC rule, ADC-Rule-Name AVP shall be used as a reference for that ADC rule. The ADC-Rule-Base-Name AVP is a reference that may be used for activating a group of predefined ADC rules.
	If Rule-Activation-Time or Rule-Deactivation-Time is specified then it applies to all the ADC rules within the ADC-Rule-Install. 
	If the Monitoring-Flags AVP is included within the ADC-Rule-Install AVP, it is used to indicate the monitoring action related to the corresponding application. It applies to all the ADC rules within the ADC-Rule-Install AVP. If the Monitoring-Flags AVP is provided, the value will be valid for the ADC rules until the new value is provided for the ADC rules.
	AVP Format:

	ADC-Rule-Install ::= 	< AVP Header: 1092 >
							*[ ADC-Rule-Definition ]
							*[ ADC-Rule-Name ]
							*[ ADC-Rule-Base-Name ]
							 [ Monitoring-Flags ]
							 [ Rule-Activation-Time ]
							 [ Rule-Deactivation-Time ]
							*[ AVP ]
 */
@DiameterAvpDefinition(code = 1092L, vendorId = KnownVendorIDs.TGPP_ID, name = "ADC-Rule-Install")
public interface ADCRuleInstall extends DiameterGroupedAvp
{
	List<ADCRuleDefinition> getADCRuleDefinition();
	
	void setADCRuleDefinition(List<ADCRuleDefinition> value);	
	
	List<ByteBuf> getADCRuleName();
	
	void setADCRuleName(List<ByteBuf> value);	
	
	List<String> getADCRuleBaseName();
	
	void setADCRuleBaseName(List<String> value);	
	
	MonitoringFlags getMonitoringFlags();
	
	void setMonitoringFlags(MonitoringFlags value);	
	
	Date getRuleActivationTime();
	
	void setRuleActivationTime(Date value);	
	
	Date getRuleDeactivationTime();
	
	void setRuleDeactivationTime(Date value);			  
}