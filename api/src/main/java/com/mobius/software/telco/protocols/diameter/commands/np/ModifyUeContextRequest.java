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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.np.ConditionalRestriction;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.np.RUCIActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.np.ReportingRestrictionEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.5	Modify-Uecontext-Request (MUR) command
	The MUR command, indicated by the Command-Code field set to 8388722 and the 'R' bit set in the Command Flags field, is sent by the PCRF to the RCAF in order to request congestion reporting restrictions or remove the context for a specific user id and PDN ID.
	Message Format:

	< Modify-Uecontext‑Request > ::= < Diameter Header: 8388722, REQ, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Vendor-Specific-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { Destination-Host }
                 [ Origin-State-Id ]
                 [ Subscription-Id ]
                 [ Called-Station-Id ]
                 [ OC-Supported-Features ]
                 [ Reporting-Restriction ]
                 [ Conditional-Restriction ]
                 [ RUCI-Action ]
                *[ Congestion-Level-Definition ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.NP, commandCode = CommandCodes.MODIFY_UE_CONTEXT, request = true, proxyable = true, name="Modify-Uecontext‑Request")
public interface ModifyUeContextRequest extends NpRequest
{
	SubscriptionId getSubscriptionId();
	
	void setSubscriptionId(SubscriptionId value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);
	
	ReportingRestrictionEnum getReportingRestriction();
	 
	void setReportingRestriction(ReportingRestrictionEnum value);
	
	ConditionalRestriction getConditionalRestriction();
	 
	void setConditionalRestriction(ConditionalRestriction value);
	 		
	RUCIActionEnum getRUCIAction();
	 
	void setRUCIAction(RUCIActionEnum value);
	
	List<CongestionLevelDefinition> getCongestionLevelDefinition();
	
	void setCongestionLevelDefinition(List<CongestionLevelDefinition> value);	
}