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
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfoEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5a.3.2	QoS-Rule-Remove AVP (All access types)
	The QoS-Rule-Remove AVP (AVP code 1052) is of type Grouped, and it is used to deactivate or remove QoS rules from an Gateway Control session.
	QoS-Rule-Name AVP is a reference for a specific QoS rule at the BBERF to be removed or for a specific QoS rule predefined at the BBERF to be deactivated. The QoS-Rule-Base-Name AVP is a reference for a group of QoS rules predefined at the BBERF to be deactivated.
	Required-Access-Info AVP may be included if the AF requests the PCRF to report user access network information and the PCRF is removing QoS rules based on the AF requests.
	AVP Format:

	QoS-Rule-Remove ::= < AVP Header: 1052>
							*[ QoS-Rule-Name ]
							*[ QoS-Rule-Base-Name ]
							*[ Required-Access-Info ]
							*[ AVP ]
 */
@DiameterAvpDefinition(code = 1052L, vendorId = KnownVendorIDs.TGPP_ID, name = "QoS-Rule-Remove")
public interface QoSRuleRemove extends DiameterGroupedAvp
{
	List<ByteBuf> getQoSRuleName();
	
	void setQoSRuleName(List<ByteBuf> value);	
	
	List<String> getQoSRuleBaseName();
	
	void setQoSRuleBaseName(List<String> value);	
	
	List<RequiredAccessInfoEnum> getRequiredAccessInfo();
	
	void setRequiredAccessInfo(List<RequiredAccessInfoEnum> value);
}