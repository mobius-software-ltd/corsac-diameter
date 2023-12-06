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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.sy.PolicyCounterStatusReport;

/**
*
* @author yulian oifa
*
*/

/*
 *  5.6.3	Spending-Limit-Answer (SLA) command
	The SLA command, indicated by the Command-Code field set to 8388635 and the 'R' bit cleared in the Command Flags field, is sent by the OCS to the PCRF as part of the Initial or Intermediate Spending Limit Report Request procedure.
	Message Format:

	<SL-Answer> ::=  < Diameter Header: 8388635, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Auth-Application-Id }
                 { Origin-Host }
                 { Origin-Realm }
                 [ Result-Code ]
                 [ Experimental-Result ]
                 [ OC-Supported-Features ]
                 [ OC-OLR ]
                *[ Supported-Features ]
                *[ Policy-Counter-Status-Report ]
                 [ Error-Message ]
                 [ Error-Reporting-Host ]
                 [ Failed-AVP ]
                 [ Origin-State-Id ]
                *[ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
                *[ Proxy-Info ]
                *[ Load ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777302, commandCode = 8388635, request = false, proxyable = true, name="AA-Answer")
public interface SpendingLimitAnswer extends SyAnswer
{
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	public List<PolicyCounterStatusReport> getPolicyCounterStatusReport();
	 
	void setPolicyCounterStatusReport(List<PolicyCounterStatusReport> value);
	
	public List<Load> getLoad();
	 
	void setLoad(List<Load> value);
}