package com.mobius.software.telco.protocols.diameter.commands.cip;
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
import com.mobius.software.telco.protocols.diameter.primitives.cip.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.cip.SubscriberInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CheckBalanceResultEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;

import io.netty.buffer.ByteBuf;

/*
	3.3 Charging-Interrogation-Answer
	The Charging-Interrogation-Answer (CIA) is indicated by the command code
	set to 16777214 and the ‘R’ bit cleared in the command flag field. It is sent as a
	response to the Charging-Interrogation-Request.
	
	The Application-ID for CIA shall be set to 16777232.
			<CIA> ::= < Diameter Header: 16777214 PXY>
				< Vendor-Specific-Application-Id >
				< Session-Id >
				{ Result-Code }
				{ Origin-Host }
				{ Origin-Realm }
				{ CC-Request-Number }
				{ CC-Request-Type }
				[ Result-Code-Extension ]
				[ Origin-State-Id ]
				[ Cost-Information ]
				[ Event-Timestamp ]
				[ Charging-State-Information ]
				[ CIP-IP-Version ]
				[ Subscriber-Information ]
			   *[ Failed-AVP ]
			   *[ AVP ]
			   *[ Multiple-Services-Credit-Control ]
				[ Check-Balance-Result ] //For one time event
				[ Granted-Service-Unit ] //For one time event
				[ CDR-Information ] //For one time event
 */

@DiameterCommandDefinition(applicationId = ApplicationIDs.CIP, commandCode = CommandCodes.CHARGING_INTERROGATION, request = false, proxyable = true, name="Charging-Interrogation-Answer")
public interface ChargingInterrogationAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlAnswer
{
	public VendorSpecificApplicationId getVendorSpecificApplicationId();
	
	void setVendorSpecificApplicationId(VendorSpecificApplicationId value);
	
	public Long getResultCodeExtension();
	
	void setResultCodeExtension(Long value);
	
	public CostInformation getCostInformation();
	
	void setCostInformation(CostInformation value);
	
	public Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	public ByteBuf getChargingStateInformation();
  	
	void setChargingStateInformation(ByteBuf value);
	
	public String getCIPIPVersion();
	
	void setCIPIPVersion(String value);
	
	public SubscriberInformation getSubscriberInformation();
	
	void setSubscriberInformation(SubscriberInformation value);
	
	public List<MultipleServicesCreditControl> getMultipleServicesCreditControl();
	
	void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> value);
	
	public CheckBalanceResultEnum getCheckBalanceResult();
	
	void setCheckBalanceResult(CheckBalanceResultEnum value);
	
	public GrantedServiceUnit getGrantedServiceUnit();
	
	void setGrantedServiceUnit(GrantedServiceUnit value);
	
	public ByteBuf getCDRInformation();
  	
	void setCDRInformation(ByteBuf value);
}