
package com.mobius.software.telco.protocols.diameter.commands.ro;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LowBalanceIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RemainingBalance;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPMultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailoverEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

/**
*
* @author yulian oifa
*
*/

/*
 *  6.4.3	Credit-Control-Answer message
The CCA messages, indicated by the Command-Code field set to 272 is sent by the OCF to the CTF in order to reply to the CCR. 
The CCA message format is defined according to RFC 4006 [402] as follows:
      <CCA> ::=  < Diameter Header: 272, PXY >
                 < Session-Id > 
                 { Result-Code }
 				 [ Experimental-Result ]
                 { Origin-Host } 
                 { Origin-Realm } 
                 { Auth-Application-Id } 
                 { CC-Request-Type } 
                 { CC-Request-Number }
                 [ CC-Session-Failover ] 
                *[ Multiple-Services-Credit-Control ]  
                 [ Cost-Information]  
                 [ Low-Balance-Indication ]  
                 [ Remaining-Balance ]  
                 [ Credit-Control-Failure-Handling ] 
                 [ Direct-Debiting-Failure-Handling ] 
                 [ OC-Supported-Features ]
                 [ OC-OLR ]
                *[ Redirect-Host] 
                 [ Redirect-Host-Usage ] 
                 [ Redirect-Max-Cache-Time ] 
                *[ Proxy-Info ] 
                *[ Route-Record ] 
                 [ Failed-AVP ]
                 [ Service-Information ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.CREDIT_CONTROL, commandCode = CommandCodes.CREDIT_CONTROL, request = false, proxyable = true, name="Credit-Control-Answer")
public interface CreditControlAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlAnswer
{
	public CcSessionFailoverEnum getCcSessionFailover();
	
	void setCcSessionFailover(CcSessionFailoverEnum value);

	public List<TGPPMultipleServicesCreditControl> getMultipleServicesCreditControl();
	
	void setMultipleServicesCreditControl(List<TGPPMultipleServicesCreditControl> value);
	
	public CostInformation getCostInformation();
	
	void setCostInformation(CostInformation value);
	
	LowBalanceIndicationEnum getLowBalanceIndication();
	
	void setLowBalanceIndication(LowBalanceIndicationEnum value);
	
	RemainingBalance getRemainingBalance();
	
	void setRemainingBalance(RemainingBalance value);

	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	public List<String> getRouteRecords() throws AvpNotSupportedException;
	
	public void setRouteRecords(List<String> value) throws AvpNotSupportedException;
	
	ServiceInformation getServiceInformation();
	
	void setServiceInformation(ServiceInformation value);
}
