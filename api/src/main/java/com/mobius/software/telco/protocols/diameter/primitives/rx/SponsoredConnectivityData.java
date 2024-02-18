package com.mobius.software.telco.protocols.diameter.primitives.rx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;

/**
*
* @author yulian oifa
*
*/

/*
 *	5.3.27	Sponsored-Connectivity-Data AVP
	The Sponsored-Connectivity-Data AVP (AVP code 530) is of type Grouped, and contains the data associated with the sponsored data connectivity.
	The Sponsor-Identity AVP identifies the sponsor. It shall be included by the AF in the Sponsored-Connectivity-Data AVP except for the case of disabling sponsored data connectivity.
	The Application-Service-Provider-Identity AVP identifies the application service provider. It shall be included by the AF in the Sponsored-Connectivity-Data AVP except for the case of disabling sponsored data connectivity.
	The Granted-Service-Unit AVP shall be used by the AF to provide usage threshold to the PCRF if the volume and/or time of traffic allowed during the sponsored data connectivity is to be monitored.
	The Used-Service-Unit AVP shall be used by the PCRF to provide the measured usage to the AF. Reporting shall be done, as requested by the AF, in CC-Total-Octets, CC-Input-Octets, CC-Output-Octets or CC-Time of the Used-Service-Unit AVP.
	Sponsoring-Action AVP shall be used by the AF to provide the indication to the PCRF if sponsored data connectivity is to be enabled or disabled.
	AVP format:

		Sponsored-Connectivity-Data::= < AVP Header: 530 >
			[ Sponsor-Identity ]
	 	 	[ Application-Service-Provider-Identity ]
			[ Granted-Service-Unit ]
			[ Used-Service-Unit ]
			[ Sponsoring-Action ]
		   *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SPONSORED_CONNECTIVITY_DATA, vendorId = VendorIDs.TGPP_ID, must = false, name = "Sponsored-Connectivity-Data")
public interface SponsoredConnectivityData extends DiameterGroupedAvp
{
	String getSponsorIdentity();
	
	void setSponsorIdentity(String value);
	
	String getApplicationServiceProviderIdentity();
	
	void setApplicationServiceProviderIdentity(String value);	
	
	GrantedServiceUnit getGrantedServiceUnit();
	
	void setGrantedServiceUnit(GrantedServiceUnit value);
	
	UsedServiceUnit getUsedServiceUnit();
	
	void setUsedServiceUnit(UsedServiceUnit value);	
	
	SponsoringActionEnum getSponsoringAction();
	
	void setSponsoringAction(SponsoringActionEnum value);
}