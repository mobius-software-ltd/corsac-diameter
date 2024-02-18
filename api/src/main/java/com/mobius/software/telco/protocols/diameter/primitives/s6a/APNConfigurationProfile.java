package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.34	APN-Configuration-Profile
	The APN-Configuration-Profile AVP is of type Grouped. It shall contain the information related to the user's subscribed APN configurations for EPS.
	The AVP format shall conform to:
	
	APN-Configuration-Profile ::= <AVP header: 1429 10415>
			  { Context-Identifier }
			  [ Additional-Context-Identifier ]
			  [ Third-Context-Identifier ]
			  { All-APN-Configurations-Included-Indicator }
			1*{APN-Configuration}
			* [AVP]

	The Subscription-Data AVP associated with an IMSI contains one APN-Configuration-Profile AVP.
	Each APN-Configuration-Profile AVP contains one or more APN-Configuration AVPs.
	Each APN-Configuration AVP describes the configuration for a single APN.
	Therefore, the cardinality of the relationship between IMSI and APN is one-to-many.
	The Context-Identifier AVP shall identify the per subscriber's default APN configuration.
	If present, the Additional-Context-Identifier AVP shall identify another default APN configuration, only for those subscriptions containing more than one types of APNs i.e. among APNs with an IP-based PDN type, APNs with a Non-IP PDN type, and APNs with an Ethernet PDN type; in this case, each of those two default APN configurations shall have a different PDN type category (e.g. one default APN with an IP-based PDN type, and another default APN with a Non-IP PDN type).
	If present, the Third-Context-Identifier AVP shall identify another default APN configuration, only for those subscriptions containing more than two types of APNs i.e. among APNs with an IP-based PDN type, APNs with a Non-IP PDN type, and APNs with an Ethernet PDN type; in this case, each of those three default APN configurations shall have a different PDN type category (i.e. one default APN with an IP-based PDN type, and another default APN with a Non-IP PDN type and one default APN with an Ethernet PDN type).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.APN_CONFIGURATION_PROFILE, vendorId = VendorIDs.TGPP_ID, name = "APN-Configuration-Profile")
public interface APNConfigurationProfile extends DiameterGroupedAvp
{
	Long getContextIdentifier();
	
	void setContextIdentifier(Long value) throws MissingAvpException;	
	
	Long getAdditionalContextIdentifier();
	
	void setAdditionalContextIdentifier(Long value);
	
	Long getThirdContextIdentifier();
	
	void setThirdContextIdentifier(Long value);
	
	AllAPNConfigurationsIncludedIndicatorEnum getAllAPNConfigurationsIncludedIndicator();
	
	void setAllAPNConfigurationsIncludedIndicator(AllAPNConfigurationsIncludedIndicatorEnum value);
	
	List<APNConfiguration> getAPNConfiguration();
	
	void setAPNConfiguration(List<APNConfiguration> value) throws MissingAvpException;
}