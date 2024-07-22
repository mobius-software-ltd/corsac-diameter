
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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPMultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.2	Credit-Control-Request message
The CCR messages, indicated by the Command-Code field set to 272 is sent by the CTF to the OCF in order to request credits for the request bearer / subsystem /service. 
The CCR message format is defined according to RFC 4006 [402] as follows:
	   <CCR> ::= < Diameter Header: 272, REQ, PXY >
				 < Session-Id > 
                 { Origin-Host } 
                 { Origin-Realm } 
                 { Destination-Realm } 
                 { Auth-Application-Id }
                 { Service-Context-Id } 
                 { CC-Request-Type } 
                 { CC-Request-Number } 
                 [ Destination-Host ] 
                 [ User-Name ] 
                 [ Origin-State-Id ] 
                 [ Event-Timestamp ] 
                *[ Subscription-Id ]
                 [ Termination-Cause ] 
                 [ Requested-Action ] 
                 [ AoC-Request-Type ] 
                 [ Multiple-Services-Indicator ] 
                *[ Multiple-Services-Credit-Control ]  
                 [ CC-Correlation-Id ] 
                 [ User-Equipment-Info ] 
                 [ OC-Supported-Features ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				 [ Service-Information ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.CREDIT_CONTROL, commandCode = CommandCodes.CREDIT_CONTROL, request = true, proxyable = true, name="Credit-Control-Request")
public interface CreditControlRequest extends com.mobius.software.telco.protocols.diameter.commands.commons.CreditControlRequest
{
	public String getServiceContextId();
	
	void setServiceContextId(String value) throws MissingAvpException;
	
	public Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);

	public TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value);
	
	public RequestedActionEnum getRequestedAction();
	
	void  setRequestedAction(RequestedActionEnum value);
	
	AoCRequestTypeEnum getAoCRequestType();
	
	void setAoCRequestType(AoCRequestTypeEnum value);
	
	public MultipleServicesIndicatorEnum getMultipleServicesIndicator();
	
	void setMultipleServicesIndicator(MultipleServicesIndicatorEnum value);

	public ByteBuf getCcCorrelationId();
	
	void setCcCorrelationId(ByteBuf value);
	
	public UserEquipmentInfo getUserEquipmentInfo();
	
	void setUserEquipmentInfo(UserEquipmentInfo value);
	
	public List<TGPPMultipleServicesCreditControl> getTGPPMultipleServicesCreditControl();
	
	void setTGPPMultipleServicesCreditControl(List<TGPPMultipleServicesCreditControl> value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	ServiceInformation getServiceInformation();
	
	void setServiceInformation(ServiceInformation value);
}