package com.mobius.software.telco.protocols.diameter.commands.st;
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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleReport;

/**
*
* @author yulian oifa
*
*/

/*
 *  5c.6.3	TDF-Session-Answer (TSA) Command
	The TSA command, indicated by the Command-Code field set to 8388637 and the 'R' bit cleared in the Command Flags field, is sent by the TSSF to the PCRF in response to the TC-Request command.
	Message Format:

	<TS-Answer> ::=  < Diameter Header: 8388637, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Vendor-Specific-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Result-Code ]
				 [ Experimental-Result ]
				 [ Origin-State-Id ]
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				*[ ADC-Rule-Report ]
				*[ Supported-Features ]
				 [ Error-Message ]
				 [ Error-Reporting-Host ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ Load ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777349, commandCode = 8388637, request = false, proxyable = true, name="TS-Answer")
public interface TDFSessionAnswer extends StAnswer
{
	List<ADCRuleReport> getADCRuleReport();
	
	void setADCRuleReport(List<ADCRuleReport> value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	List<Load> getLoad();
	
	void setLoad(List<Load> value);					
}