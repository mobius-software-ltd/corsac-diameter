package com.mobius.software.telco.protocols.diameter.commands.creditcontrol;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailoverEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CheckBalanceResultEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.QoSFinalUnitIndication;

/**
*
* @author yulian oifa
*
*/

/*
 * The Credit-Control-Answer message (CCA) is indicated by the Command
   Code field being set to 272 and the 'R' bit being cleared in the
   Command Flags field.  It is used between the credit-control server
   and the Diameter Credit-Control client to acknowledge a
   Credit-Control-Request command.

   Message Format:

        <Credit-Control-Answer> ::= < Diameter Header: 272, PXY >
                                  < Session-Id >
                                  { Result-Code }
                                  { Origin-Host }
                                  { Origin-Realm }
                                  { Auth-Application-Id }
                                  { CC-Request-Type }
                                  { CC-Request-Number }
                                  [ User-Name ]
                                  [ CC-Session-Failover ]
                                  [ CC-Sub-Session-Id ]
                                  [ Acct-Multi-Session-Id ]
                                  [ Origin-State-Id ]
                                  [ Event-Timestamp ]
                                  [ Granted-Service-Unit ]
                                 *[ Multiple-Services-Credit-Control ]
                                  [ Cost-Information]
                                  [ Final-Unit-Indication ]
                                  [ QoS-Final-Unit-Indication ]
                                  [ Check-Balance-Result ]
                                  [ Credit-Control-Failure-Handling ]
                                  [ Direct-Debiting-Failure-Handling ]
                                  [ Validity-Time]
                                 *[ Redirect-Host]
                                  [ Redirect-Host-Usage ]
                                  [ Redirect-Max-Cache-Time ]
                                 *[ Proxy-Info ]
                                 *[ Route-Record ]
                                 *[ Failed-AVP ]
                                 *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.CREDIT_CONTROL, commandCode = CommandCodes.CREDIT_CONTROL, request = false, proxyable = true, name="Credit-Control-Answer")
public interface CreditControlAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlAnswer
{
	public CcSessionFailoverEnum getCcSessionFailover();
	
	void setCcSessionFailover(CcSessionFailoverEnum value);
	
	public Long getCcSubSessionId();
	
	void setCcSubSessionId(Long value);
	
	public String getAcctMultiSessionId();
	
	void setAcctMultiSessionId(String value);
	
	public Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	public GrantedServiceUnit getGrantedServiceUnit();
	
	void setGrantedServiceUnit(GrantedServiceUnit value);
	
	public List<MultipleServicesCreditControl> getMultipleServicesCreditControl();
	
	void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> value);
		
	public CostInformation getCostInformation();
	
	void setCostInformation(CostInformation value);
	
	public FinalUnitIndication getFinalUnitIndication();
	
	void setFinalUnitIndication(FinalUnitIndication value);
	
	public QoSFinalUnitIndication getQosFinalUnitIndication();
	
	void setQosFinalUnitIndication(QoSFinalUnitIndication value);
	
	public CheckBalanceResultEnum getCheckBalanceResult();
	
	void setCheckBalanceResult(CheckBalanceResultEnum value);
	
	public Long getValidityTime();
	
	void setValidityTime(Long value);
	
	public List<String> getRouteRecords();
	
	public void setRouteRecords(List<String> value);
	
}