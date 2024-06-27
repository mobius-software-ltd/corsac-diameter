package com.mobius.software.telco.protocols.diameter.primitives.nta;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.LocationInformationConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringTypeEnum;



/*A.6.3.3	Event-Configuration
The Event-Configuration AVP (AVP code 4211) is of type Grouped, 
and it contains the details of the monitoring event configuration from the SCEF.
Event-Configuration ::= < AVP Header: 4211 >
                   { Extended-SCEF-Reference-ID }
                   { SCEF-ID }
                   { Monitoring-Type }
                   [ Location-Information-Configuration ]
                  *[ AVP ]
*/

@DiameterAvpDefinition(code = TgppAvpCodes.EVENT_CONFIGURATION, vendorId = VendorIDs.TGPP_ID, name = "Event-Configuration")
public interface EventConfiguration extends DiameterGroupedAvp
{
	Long getExtendedSCEFReferenceID();
	
	void setExtendedSCEFReferenceID(Long value)throws MissingAvpException;
	
	String getSCEFID();
	 
	void setSCEFID(String value) throws MissingAvpException;

	MonitoringTypeEnum getMonitoringType();
	
	void setMonitoringType(MonitoringTypeEnum value) throws MissingAvpException;	
	
	LocationInformationConfiguration getLocationInformationConfiguration();
	
	void setLocationInformationConfiguration(LocationInformationConfiguration value);
}

