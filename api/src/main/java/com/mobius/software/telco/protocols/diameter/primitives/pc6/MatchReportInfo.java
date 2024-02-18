package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.3.56	Match-Report-Info 
	The Match-Report-Info is of type Grouped. It shall contain the information elements used in ProSe Match Report Info request. 
	The AVP format shall conform to:
		
	Match-Report-Info ::=		<AVP header: 3857 10415>
		 { Discovery-Type }
		 [ User-Identity ]
		*[ ProSe-App-ID ]
		*[AVP]

	The valid value for Discovery-Type for Match-Report-Info AVP is: "MONITORING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY",
	When the Discovery-Type is set to "MONITORING_REQUEST_FOR_OPEN_PROSE_DIRECT_DISCOVERY", the Match-Report-Info shall contain one User Identity and one or more ProSe Application IDs.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MATCH_REPORT_INFO, vendorId = VendorIDs.TGPP_ID, name = "Match-Report-Info")
public interface MatchReportInfo extends DiameterGroupedAvp
{
	DiscoveryTypeEnum getDiscoveryType();
	
	void setDiscoveryType(DiscoveryTypeEnum value) throws MissingAvpException;
	
	UserIdentity getUserIdentity();
	
	void setUserIdentity(UserIdentity value);
	
	List<String> getProSeAppId();
	
	void setProSeAppId(List<String> value);
}