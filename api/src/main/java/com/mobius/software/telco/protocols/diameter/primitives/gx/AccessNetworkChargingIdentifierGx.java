package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.22	Access-Network-Charging-Identifier-Gx AVP (All access types)
	The Access-Network-Charging-Identifier-Gx AVP (AVP code 1022) is of type Grouped. It contains a charging identifier (e.g. GCID) within the Access-Network-Charging-Identifier-Value AVP, when applicable, and the related PCC rule name(s) within the Charging-Rule-Name AVP(s) and/or within the Charging-Rule-Base-Name AVP(s). If the charging identifier applies to the entire IP CAN session, no Charging-Rule-Name AVPs or Charging-Rule-Base-Name AVPs need to be provided. Otherwise, all the Charging-Rule-Name AVPs or Charging-Rule-Base-Name AVPs corresponding to PCC rules associated to the provided Access-Network-Charging-Identifier-Value shall be included.

	NOTE 1: During the IP-CAN Session Establishment no Charging-Rule-Name AVPs or Charging-Rule-Base-Name AVPs are provided regardless if the charging identifier applies to the entire IP-CAN session or to the default bearer since the PCC Rules are not yet authorized at this stage.

	NOTE 2:	For Case 1 and GPRS, the charging identifier for an IP-CAN bearer is provided together with all the Charging-Rule-Name AVPs or Charging-Rule-Base-Name AVPs corresponding to PCC rules activated or installed within the IP-CAN bearer.

	The Access-Network-Charging-Identifier-Gx AVP can be sent from the PCEF to the PCRF. The PCRF may use this information for charging correlation towards the AF.
	AVP Format:

	Access-Network-Charging-Identifier-Gx ::= 	< AVP Header: 1022 >
		 { Access-Network-Charging-Identifier-Value}
		*[ Charging-Rule-Base-Name ]
		*[ Charging-Rule-Name ] 
		 [ IP-CAN-Session-Charging-Scope ]
		*[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ACCESS_NETWORK_CHARGING_IDENTIFIER_GX, vendorId = VendorIDs.TGPP_ID, name = "Access-Network-Charging-Identifier-Gx")
public interface AccessNetworkChargingIdentifierGx extends DiameterGroupedAvp
{
	ByteBuf getAccessNetworkChargingIdentifierValue();
	
	void setAccessNetworkChargingIdentifierValue(ByteBuf value) throws MissingAvpException;		
	
	List<String> getChargingRuleBaseName();
	
	void setChargingRuleBaseName(List<String> value);	
	
	List<ByteBuf> getChargingRuleName();
	
	void setChargingRuleName(List<ByteBuf> value);	
	
	IPCANSessionChargingScopeEnum getIPCANSessionChargingScope();
	
	void setIPCANSessionChargingScope(IPCANSessionChargingScopeEnum value);			  
}