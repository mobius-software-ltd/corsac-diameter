package com.mobius.software.telco.protocols.diameter.primitives.gy;
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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;


/*
		
                                    
 */
@DiameterAvpDefinition(code = AvpCodes.GRANTED_SERVICE_UNIT, vendorId = -1, name = "Granted-Service-Unit")
public interface GrantedServiceUnit extends RequestedServiceUnit
{	
	Date getCCTime();
	
	void setCCTime(Date ccTime);
	
	Long getCCTotalOctets();
	
	void setCCTotalOctets(Long ccTotalOctets);

	Long getCCInputOctets();
	
	void setCCInputOctets(Long ccInputOctets);

	Long getCCOutputOctets();
	
	void setCCOutputOctets(Long ccOutputOctets);

}
