package com.mobius.software.telco.protocols.diameter.commands.np;
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
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.np.RUCIActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.np.ReportingRestrictionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.2	Non-Aggregated-RUCI-Report-Answer (NRA) command
	The NRA command, indicated by the Command-Code field set to 8388720 and the 'R' bit cleared in the Command Flags field, is sent by the PCRF to the RCAF as part of the Non-aggregated RUCI report procedure.
	Message Format:

	<NR-Answer> ::=  < Diameter Header: 8388720, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Vendor-Specific-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 [ Result-Code ]
                 [ Experimental-Result ]
                 [ Error-Message ]
                 [ Error-Reporting-Host ]
                 [ Failed-AVP ]
                 [ OC-Supported-Features ]
                 [ OC-OLR ]
                 [ Reporting-Restriction ]
                 [ Conditional-Restriction ]
                 [ RUCI-Action ]
                *[ Congestion-Level-Definition ]
                 [ PCRF-Address ]
                 [ Origin-State-Id ]
                *[ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
                *[ Proxy-Info ]
                *[ Supported-Features ]
                *[ Load ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777342, commandCode = 8388720, request = false, proxyable = true, name="Non-Aggregated-RUCI-Report-Answer")
public interface NonAggregatedRUCIReportAnswer extends NpAnswer
{
	ReportingRestrictionEnum getReportingRestriction();
	 
	void setReportingRestriction(ReportingRestrictionEnum value);
	
	Long getConditionalRestriction();
	 
	void setConditionalRestriction(Long value);
	 		
	RUCIActionEnum getRUCIAction();
	 
	void setRUCIAction(RUCIActionEnum value);
	
	List<CongestionLevelDefinition> getCongestionLevelDefinition();
	
	void setCongestionLevelDefinition(List<CongestionLevelDefinition> value);
					 
	String getPCRFAddress();
	
	void setPCRFAddress(String value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);	 			
}