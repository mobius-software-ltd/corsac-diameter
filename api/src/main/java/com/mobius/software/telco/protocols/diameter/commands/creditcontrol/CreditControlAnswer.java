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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailoverEnum;
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
                                    [ Cost-Information ]
                                    [ Final-Unit-Indication ]
                                    [ QoS-Final-Unit-Indication ]
 */
@DiameterCommandDefinition(applicationId = -1, commandCode = 272, request = false, proxyable = true, name="Accounting-Answer")
public interface CreditControlAnswer extends DiameterAnswer
{
    public Long getAuthApplicationId();
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum ccRequestType);
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long ccRequestNumber);
	
	public String getUsername();
	
	void setUsername(String value);
	
	public CcSessionFailoverEnum getCcSessionFailover();
	
	void setCcSessionFailover(CcSessionFailoverEnum ccSessionFailover);
	
	public Long getCcSubSessionId() throws AvpNotSupportedException;
	
	void setCcSubSessionId(Long value) throws AvpNotSupportedException;
	
	public String getAcctMultiSessionId() throws AvpNotSupportedException;
	
	void setAcctMultiSessionId(String value) throws AvpNotSupportedException;
	
	public Long getOriginStateId();
	
	void setOriginStateId(Long value);			
	
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
	
	public QoSFinalUnitIndication getQoSFinalUnitIndication();
	
	void setQoSFinalUnitIndication(QoSFinalUnitIndication value);
	
}