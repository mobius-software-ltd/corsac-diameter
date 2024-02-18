package com.mobius.software.telco.protocols.diameter.primitives.e4;
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

import com.mobius.software.telco.protocols.diameter.EtsiAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASFilterRule;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.4 Initial-Gate-Setting-Description AVP
	The Initial-Gate-Setting-Description AVP (AVP code 303 13019) is of type Grouped.

	AVP Format:
	
	Initial-Gate-Setting-Description ::= < AVP Header: 303 13019 >
		 1*{NAS-Filter-Rule}
		 [	Maximum-Allowed-Bandwidth-UL]
		 [	Maximum-Allowed-Bandwidth-DL]

	Absence of the Maximum-Allowed-Bandwidth-UL AVP indicates that no limitation is placed by the subscription on the
	amount of bandwidth that can be used on the uplink direction.

	Absence of the Maximum-Allowed-Bandwidth-DL AVP indicates that no limitation is placed by the subscription on the
	amount of bandwidth that can be used on the downlink direction. 
 */
@DiameterAvpDefinition(code = EtsiAvpCodes.INITIAL_GATE_SETTING_DESCRIPTION, vendorId = VendorIDs.ETSI_ID,must = false, name = "Initial-Gate-Setting-Description")
public interface InitialGateSettingDescription extends DiameterAvp
{
	List<NASFilterRule> getNASFilterRule();
	
	void setNASFilterRule(List<NASFilterRule> value);	
	
	Long getMaximumAllowedBandwidthUL();
	
	void setMaximumAllowedBandwidthUL(Long value);
	
	Long getMaximumAllowedBandwidthDL();
	
	void setMaximumAllowedBandwidthDL(Long value);
}