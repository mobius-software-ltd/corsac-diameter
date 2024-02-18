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

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TunnelInformation;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5a.3.1	QoS-Rule-Install AVP (All access types)
	The QoS-Rule-Install AVP (AVP code 1051) is of type Grouped, and it is used to activate, install or modify QoS rules as instructed from the PCRF to the BBERF.
	For installing a new QoS rule or modifying a QoS rule already installed, QoS-Rule-Definition AVP shall be used.
	For activating a specific QoS rule predefined at the BBERF, QoS-Rule-Name AVP shall be used as a reference for that QoS rule. The QoS-Rule-Base-Name AVP is a reference that may be used for activating a group of QoS rules predefined at the BBERF.
	When Tunnel-Information AVP is provided it applies to all the QoS rules included within the QoS-Rule-Install AVP. When QoS rules are being modified, the newly provided Tunnel-Information AVP replaces previously provided Tunnel-Information AVP for the modified QoS rules. If Resource-Allocation-Notification AVP is included then it applies to all the rules within the QoS-Rule-Install AVP. If a QoS-Rule-Install AVP does not include the Resource-Allocation-Notification AVP, the resource allocation shall not be notified by the BBERF even if this AVP was present in previous installations of the same rule.
	In case 2a, the QoS-Rule-Install AVP may also contain a charging identifier within the Access-Network-Qos-Identifier-Value AVP. The charging identifier information is used by the BBERF for charging correlation. When the Access-Network-Qos-Identifier-Value AVP is included, the identifier applies to all the QoS rules included within the QoS-Rule-Install AVP. The charging identifier value for a QoS rule shall be the same as that for the corresponding PCC rule. When a QoS rule is being modified and no new charging identifier is provided, then the previously provided charging identifier shall apply for the modified QoS rules.
	If Rule-Activation-Time or Rule-Deactivation-Time is specified then it applies to all the QoS rules within the QoS-Rule-Install AVP.
	The 3GPP-GGSN-Address AVP, 3GPP-GGSN-Ipv6-Address AVP, AN-GW-Address AVP and UDP-Source-Port AVP are only applicable for S9a interface when provided. UDP-Source-Port AVP provided within QoS-Rule-Install AVP is only applicable for the trusted S2c case and shall take precedence over the one provided at the S9a command level.
	AVP Format:

	QoS-Rule-Install ::= < AVP Header: 1051>
							* [ QoS-Rule-Definition ]
							* [ QoS-Rule-Name ]
							* [ QoS-Rule-Base-Name ]
							  [ Tunnel-Information ]
							  [ Access-Network-Charging-Identifier-Value ]
							  [ Resource-Allocation-Notification ]
							  [ Rule-Activation-Time ]
							  [ Rule-Deactivation-Time ]
							  [ 3GPP-GGSN-Address ]
							  [ 3GPP-GGSN-Ipv6-Address ]
						  0*2 [ AN-GW-Address ]
							  [ UDP-Source-Port ]
							* [ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.QOS_RULE_INSTALL, vendorId = VendorIDs.TGPP_ID, name = "QoS-Rule-Install")
public interface QoSRuleInstall extends DiameterGroupedAvp
{
	List<QoSRuleDefinition> getQoSRuleDefinition();
	
	void setQoSRuleDefinition(List<QoSRuleDefinition> value);	
	
	List<ByteBuf> getQoSRuleName();
	
	void setQoSRuleName(List<ByteBuf> value);	
	
	List<String> getQoSRuleBaseName();
	
	void setQoSRuleBaseName(List<String> value);	
	
	TunnelInformation getTunnelInformation();
	
	void setTunnelInformation(TunnelInformation value);
	
	ByteBuf getAccessNetworkChargingIdentifierValue();
	
	void setAccessNetworkChargingIdentifierValue(ByteBuf value);	
	
	Date getRuleActivationTime();
	
	void setRuleActivationTime(Date value);	
	
	Date getRuleDeactivationTime();
	
	void setRuleDeactivationTime(Date value);	
	
	ByteBuf getTGPPGGSNAddress();
	
	void setTGPPGGSNAddress(ByteBuf value);	
	
	ByteBuf getTGPPGGSNIPv6Address();
	
	void setTGPPGGSNIPv6Address(ByteBuf value);	
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value) throws AvpOccursTooManyTimesException;
	
	Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);	
}