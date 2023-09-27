package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPDataDeliveryMechanismEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPPDNTypeIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNTypeEnum;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.77	PDN-Connectivity-Status-Report
	The PDN-Connectivity-Status-Report AVP is of type Grouped and it contains the different parameters associated to the reporting of the PDN Connectivity Status event type.
	AVP format:
	
	PDN-Connectivity-Status-Report ::= <AVP header: 3181 10415>
			   { Service-Selection }
			   { PDN-Connectivity-Status-Type }
			   [ PDN-Type ]
			   [ Non-IP-PDN-Type-Indicator ]
			   [ Non-IP-Data-Delivery-Mechanism ]
			*2 [ Served-Party-IP-Address ]
			*  [AVP]
						
	Absence of PDN-Connectivity-Status-Report in Monitoring-Event-Report AVP including Monitoring-Type AVP with value PDN_CONNECTIVITY_STATUS (10) in responses (immediate report) shall indicate that none of the requested APNs are active. The AVP shall always be present in RIR command if Monitoring-Event-Report AVP includes Monitoring-Type AVP with value PDN_CONNECTIVITY_STATUS (10).
	The PDN-Type AVP is defined in 3GPP TS 29.272 [14] and it shall be present when the PDN Connection is an IP connection, and it may contain the value IPv4, IPv6 or IPv4v6. The value IPv4_OR_IPv6 shall not be used for this event reporting. If PDN-Type AVP is present, then the Non-IP-PDN-Type-Indicator and Non-IP-Data-Delivery-Mechanism AVPs shall be absent.
	The Non-IP-PDN-Type-Indicator AVP is defined in 3GPP TS 29.272 [14] and it indicates whether the PDN Connection is of type "Non-IP". If this AVP is present, it shall be set to TRUE and the PDN-Type AVP shall be absent.
	The Non-IP-Data-Delivery-Mechanism AVP is defined in 3GPP TS 29.272 [14] and it shall be present if the Non-IP-PDN-Type-Indicator AVP is present and set to TRUE. It shall indicate whether the Non-IP data delivery is done via Point-To-Point tunnelling over the SGi interface, or via the SCEF.

	NOTE:	In 3GPP TS 23.682 [2], clause 5.6.3.9, the reporting of the data delivery mechanism is described in terms of a parameter called "3GPP Interface Indication"; however, the conveyance of such information inside the PDN-Connectivity-Status-Report AVP is done in the present specification in terms of the same set of AVPs used for the definition of the subscription data in 3GPP TS 29.272 [14]. The correspondence of the values of the parameter "3GPP Interface Indication" from 3GPP TS 23.682 [2] is as follows:

	-	"API-Connectivity" corresponds to the presence of Non-IP-Data-Delivery-Mechanism set to value SCEF-BASED-DATA-DELIVERY;
	-	"IP-connectivity" corresponds to the presence of PDN-Type AVP, and the absence of Non-IP-PDN-Type-Indicator and Non-IP-Data-Delivery-Mechanism AVPs;
	-	"Other" corresponds to the presence of Non-IP-Data-Delivery-Mechanism set to value SGi-BASED-DATA-DELIVERY.

	The Served-Party-IP-Address AVP may be present 0, 1 or 2 times, and contain the IP address(es) used by the UE (if available) and, if present, they shall contain either of:
	-	an IPv4 address, or
	-	an IPv6 address/prefix, or
	-	both, an IPv4 address and an IPv6 address/prefix (for dual-stack UEs with PDN-Type set to "IPv4v6").
	
	For the IPv6 prefix, the lower 64 bits of the address shall be set to zero.
 */
@DiameterAvpDefinition(code = 3181L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "PDN-Connectivity-Status-Report")
public interface PDNConnectivityStatusReport extends DiameterGroupedAvp
{
	String getServiceSelection();
	
	void setServiceSelection(String value);	
	
	PDNConnectivityStatusTypeEnum getPDNConnectivityStatusType();
	
	void setPDNConnectivityStatusType(PDNConnectivityStatusTypeEnum value);
	
	PDNTypeEnum getPDNType();
	
	void setPDNType(PDNTypeEnum value);
	
	NonIPPDNTypeIndicatorEnum getNonIPPDNTypeIndicator();
	
	void setNonIPPDNTypeIndicator(NonIPPDNTypeIndicatorEnum value);
	
	NonIPDataDeliveryMechanismEnum getNonIPDataDeliveryMechanism();
	
	void setNonIPDataDeliveryMechanism(NonIPDataDeliveryMechanismEnum value);
	
	List<InetAddress> getServedPartyIPAddress();
	
	void setServedPartyIPAddress(List<InetAddress> value);
}