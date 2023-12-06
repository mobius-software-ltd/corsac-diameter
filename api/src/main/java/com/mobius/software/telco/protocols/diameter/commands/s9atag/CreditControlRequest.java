package com.mobius.software.telco.protocols.diameter.commands.s9atag;
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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	A.8.6.2	CC-Request (CCR) Command
	The CCR command, indicated by the Command-Code field set to 272 and the 'R' bit set in the Command Flags field, is sent by the BPCF to the PCRF in order to initiate an S9a* session establishment and to request PCC rules. The CCR command is also sent by the BPCF to the PCRF in order to indicate PCC rule related events.
	Message Format:
	<CC-Request> ::= < Diameter Header: 272, REQ, PXY >
                < Session-Id >
                [ DRMP ]
              	{ Auth-Application-Id }
                { Origin-Host }
                { Origin-Realm }
                { Destination-Realm }
                { CC-Request-Type }
                { CC-Request-Number }
                [ Destination-Host ]
                [ Origin-State-Id ]
                [ Subscription-Id ]
                [ Called-Station-Id ]
                [ OC-Supported-Features ]
               *[ Supported-Features ]
               *[ Charging-Rule-Report ]
                [ UE-Local-IP-Address ]
                [ UE-Local-IPv6-Prefix ]
                [ QoS-Information ]
                [ TDF-Information ]
                [ Termination-Cause ]
               *[ Proxy-Info ]
               *[ Route-Record ]
               *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777320, commandCode = 272, request = true, proxyable = true, name="Credit-Control-Request")
public interface CreditControlRequest extends AuthenticationRequest
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value);
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value);
	
	public SubscriptionId getSubscriptionId();
	
	void setSubscriptionId(SubscriptionId value);	
	
	String getCalledStationId();
	
	void setCalledStationId(String value);

	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	 
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	List<ChargingRuleReport> getChargingRuleReport();
	
	void setChargingRuleReport(List<ChargingRuleReport> value);	
	
	InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);	
	
	ByteBuf getUELocalIPv6Prefix();
	
	void setUELocalIPv6Prefix(ByteBuf value);
	
	public QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);
	
	public TDFInformation getTDFInformation();
	
	void setTDFInformation(TDFInformation value);
	
	public TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value);
}