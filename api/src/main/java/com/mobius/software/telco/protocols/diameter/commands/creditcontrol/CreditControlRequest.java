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
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceParameterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdExtension;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * The Credit-Control-Request message (CCR) is indicated by the Command
   Code field being set to 272 and the 'R' bit being set in the Command
   Flags field.  It is used between the Diameter Credit-Control client
   and the credit-control server to request credit authorization for a
   given service.

   The Auth-Application-Id MUST be set to the value 4, indicating the
   Diameter Credit-Control application.

   The CCR is extensible via the inclusion of one or more
   Attribute-Value Pairs (AVPs).

   Message Format:

   <Credit-Control-Request> ::= < Diameter Header: 272, REQ, PXY >
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
                                [ CC-Sub-Session-Id ]
                                [ Acct-Multi-Session-Id ]
                                [ Origin-State-Id ]
                                [ Event-Timestamp ]
                               *[ Subscription-Id ]
                               *[ Subscription-Id-Extension ]
                                [ Service-Identifier ]
                                [ Termination-Cause ]
                                [ Requested-Service-Unit ]
                                [ Requested-Action ]
                               *[ Used-Service-Unit ]
                                [ Multiple-Services-Indicator ]
                               *[ Multiple-Services-Credit-Control ]
                               *[ Service-Parameter-Info ]
                                [ CC-Correlation-Id ]
                                [ User-Equipment-Info ]
                                [ User-Equipment-Info-Extension ]
                               *[ Proxy-Info ]
                               *[ Route-Record ]
                               *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.CREDIT_CONTROL, commandCode = CommandCodes.CREDIT_CONTROL, request = true, proxyable = true, name="Credit-Control-Request")
public interface CreditControlRequest extends DiameterRequest
{
	public Long getAuthApplicationId();
	
	public String getServiceContextId();
	
	void setServiceContextId(String value) throws MissingAvpException;
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value) throws MissingAvpException;
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value) throws MissingAvpException;
	
	public Long getCcSubSessionId() throws AvpNotSupportedException;
	
	void setCcSubSessionId(Long value) throws AvpNotSupportedException;
	
	public String getAcctMultiSessionId() throws AvpNotSupportedException;
	
	void setAcctMultiSessionId(String value) throws AvpNotSupportedException;
	
	public Date getEventTimestamp();
	
	void setEventTimestamp(Date value);
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);

	public List<SubscriptionIdExtension> getSubscriptionIdExtension() throws AvpNotSupportedException;
	
	void setSubscriptionIdExtension(List<SubscriptionIdExtension> value) throws AvpNotSupportedException;

	public Long getServiceIdentifier() throws AvpNotSupportedException;
	
	void setServiceIdentifier(Long value) throws AvpNotSupportedException;			
	
	public TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value);
	
	public RequestedServiceUnit getRequestedServiceUnit() throws AvpNotSupportedException;
	
	void setRequestedServiceUnit(RequestedServiceUnit value) throws AvpNotSupportedException;
	
	public RequestedActionEnum getRequestedAction();
	
	void setRequestedAction(RequestedActionEnum value);
	
	public List<UsedServiceUnit> getUsedServiceUnit() throws AvpNotSupportedException;
	
	void setUsedServiceUnit(List<UsedServiceUnit> value) throws AvpNotSupportedException;

	public MultipleServicesIndicatorEnum getMultipleServicesIndicator();
	
	void setMultipleServicesIndicator(MultipleServicesIndicatorEnum value);
	
	public List<MultipleServicesCreditControl> getMultipleServicesCreditControl();
	
	void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> value);
	
	public List<ServiceParameterInfo> getServiceParameterInfo() throws AvpNotSupportedException;
	
	void setServiceParameterInfo(List<ServiceParameterInfo> value) throws AvpNotSupportedException;

	public ByteBuf getCcCorrelationId();
	
	void setCcCorrelationId(ByteBuf value);
	
	public UserEquipmentInfo getUserEquipmentInfo();
	
	void setUserEquipmentInfo(UserEquipmentInfo value);
	
	public UserEquipmentInfoExtension getUserEquipmentInfoExtension() throws AvpNotSupportedException;
	
	void setUserEquipmentInfoExtension(UserEquipmentInfoExtension value) throws AvpNotSupportedException;
	
	public List<String> getRouteRecords();
	
	void setRouteRecords(List<String> value);	  	
}