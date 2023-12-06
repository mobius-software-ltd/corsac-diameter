package com.mobius.software.telco.protocols.diameter.primitives.gxx;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5a.3.3	QoS-Rule-Definition AVP (All access types)
	The QoS-Rule-Definition AVP (AVP code 1053) is of type Grouped, and it defines the QoS rule for a service data flow sent by the PCRF to the BBERF. The QoS-Rule-Name AVP uniquely identifies the QoS rule and it is used to reference to a QoS rule in communication between the BBERF and the PCRF within one Gateway Control session. The Flow-Information AVP(s) determines the traffic that belongs to the service data flow.
	If optional AVP(s) within a QoS-Rule-Definition AVP are omitted, but corresponding information has been provided in previous Gxx messages, the previous information remains valid. If Flow-Information AVP(s) are supplied, they replace all previous Flow-Information AVP(s).
	Required-Access-Info AVP may appear if the AF requests PCRF to report user access network information.
	Sharing-Key-UL AVP and/or Sharing-Key-DL AVP may appear if the QoS rule is a candidate for resource sharing.
	The Content-Version AVP may be included if the QoS rule is installed or modified.
	AVP Format:

	QoS-Rule-Definition ::= < AVP Header: 1053>
							 { QoS-Rule-Name }
							*[ Flow-Information ]
							 [ QoS-Information ]
							 [ Precedence ]
							*[ Required-Access-Info ]
							 [ Sharing-Key-DL ]
							 [ Sharing-Key-UL ]
							 [ Content-Version ]
							*[ AVP ]
*/
@DiameterAvpDefinition(code = 1053L, vendorId = KnownVendorIDs.TGPP_ID, name = "QoS-Rule-Definition")
public interface QoSRuleDefinition extends DiameterGroupedAvp
{
	ByteBuf getQoSRuleName();
	
	void setQoSRuleName(ByteBuf value);
	
	List<FlowInformation> getFlowInformation();
	
	void setFlowInformation(List<FlowInformation> value);	
	
	QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);	
	
	Long getPrecedence();
	
	void setPrecedence(Long value);	
	
	List<RequiredAccessInfo> getRequiredAccessInfo();
	
	void setRequiredAccessInfo(List<RequiredAccessInfo> value);
	
	Long getSharingKeyDL();
	
	void setSharingKeyDL(Long value);	
	
	Long getSharingKeyUL();
	
	void setSharingKeyUL(Long value);
	
	Long getContentVersion();
	
	void setContentVersion(Long value);
}