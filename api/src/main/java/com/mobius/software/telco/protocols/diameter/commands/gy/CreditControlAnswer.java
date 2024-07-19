package com.mobius.software.telco.protocols.diameter.commands.gy;
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
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailoverEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gy.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gy.TGPPMultipleServicesCreditControl;

/*
  
      		Gy-Credit-Control-Answer message
   This section describes the Diameter Gy CCA message format as defined in RFC 4006.
      <CCA> ::=  < Diameter Header: 272, PXY >
                 < Session-Id > 
                 { Result-Code }
                 { Origin-Host } 
                 { Origin-Realm } 
                 { Auth-Application-Id } 
                 { CC-Request-Type } 
                 { CC-Request-Number }
                 [ CC-Session-Failover ] 
                *[ Multiple-Services-Credit-Control ]    
                 [ Credit-Control-Failure-Handling ]
                 [ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Route-Record ]
                 [ Service-Information ]   
                 [ Failed-AVP ]
                *[ AVP ]                  
 */

@DiameterCommandDefinition(applicationId = ApplicationIDs.CREDIT_CONTROL, commandCode = CommandCodes.CREDIT_CONTROL, request = false, proxyable = true, name="Credit-Control-Answer")
public interface CreditControlAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlAnswer
{
	public CcSessionFailoverEnum getCcSessionFailover();
	
	void setCcSessionFailover(CcSessionFailoverEnum value);
	
	public List<TGPPMultipleServicesCreditControl> getTGPPMultipleServicesCreditControl();

	void setTGPPMultipleServicesCreditControl(List<TGPPMultipleServicesCreditControl> value);
	 
	CreditControlFailureHandlingEnum getCreditControlFailureHandling();
	 
	void setCreditControlFailureHandling(CreditControlFailureHandlingEnum value);
	
	public List<String> getRouteRecords() throws AvpNotSupportedException;
	
	public void setRouteRecords(List<String> value) throws AvpNotSupportedException;
	
	ServiceInformation getServiceInformation();
	
	void setServiceInformation(ServiceInformation value);


	
}