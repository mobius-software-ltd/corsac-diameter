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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.cip.AccessInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cip.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;

import io.netty.buffer.ByteBuf;

/*
	3.2 Charging-Interrogation-Request
	The Charging-Interrogation-Request (CIR) is indicated by the command code
	set to 16777214 and the ‘R’ bit being set in the command flag field. It is sent
	from the CIP/IP Client to the SDP. It is used to request credit authorization for
	a given service or services.
	
	The Application-ID for CIR shall be set to 16777232.
		<CIR> ::= < Diameter Header: 16777214, REQ PXY>
				< Vendor-Specific-Application-Id >
				< Session-Id >
				{ Origin-Host }
				{ Origin-Realm }
				{ Destination-Realm }
				{ CC-Request-Number }
				{ CC-Request-Type }
				{ Charging-Context-Id }
			   *{ Subscription-Id }
				[ Service-Context-Id ]
				[ Destination-Host ]
				[ Origin-State-Id ]
				[ Event-Timestamp ]
				[ Termination-Cause ]
				[ User-Equipment-Info ]
				[ Access-Information ]
				[ Charging-State-Information ]
				[ CIP-IP-Version ]
				[ 3GPP-MS-TimeZone ]
			   *[ AVP ]
			   *[ Multiple-Services-Credit-Control ]
				[ Requested-Action ] //For one time event
				[ Requested-Service-Unit ] //For one time event
				[ Service-Identifier ] //For one time event
 */

@DiameterCommandDefinition(applicationId = ApplicationIDs.CIP, commandCode = CommandCodes.CHARGING_INTERROGATION, request = true, proxyable = true, name="Charging-Interrogation-Request")
public interface ChargingInterrogationRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlRequest
{
	public VendorSpecificApplicationId getVendorSpecificApplicationId();
	
	void setVendorSpecificApplicationId(VendorSpecificApplicationId value);
	
	public String getChargingContextId();
	
	void setChargingContextId(String value) throws MissingAvpException;
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value) throws MissingAvpException;
	
	public String getServiceContextId();
	
	void setServiceContextId(String value);
	
	public Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	public TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value);
	
	public UserEquipmentInfo getUserEquipmentInfo();
	
	void setUserEquipmentInfo(UserEquipmentInfo value);
	
	public AccessInformation getAccessInformation();
	
	void setAccessInformation(AccessInformation value);
	
	public ByteBuf getChargingStateInformation();
		  	
	void setChargingStateInformation(ByteBuf value);
	
	public String getCIPIPVersion();
	
	void setCIPIPVersion(String value);
	
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);
	
	public List<MultipleServicesCreditControl> getMultipleServicesCreditControl();
	
	void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> value);
	
	public RequestedServiceUnit getRequestedServiceUnit();
	
	void setRequestedServiceUnit(RequestedServiceUnit value);
	
	public RequestedActionEnum getRequestedAction();
	
	void  setRequestedAction(RequestedActionEnum value);
	
	public Long getServiceIdentifier();
	
	void setServiceIdentifier(Long value);		
}