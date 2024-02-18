package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 8.18.  Requested-Service-Unit AVP

   The Requested-Service-Unit AVP (AVP Code 437) is of type Grouped and
   contains the amount of requested units specified by the Diameter
   Credit-Control client.  A server is not required to implement all the
   unit types, and it must treat unknown or unsupported unit types as
   invalid AVPs.

   The Requested-Service-Unit AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

         Requested-Service-Unit ::= < AVP Header: 437 >
                                    [ CC-Time ]
                                    [ CC-Money ]
                                    [ CC-Total-Octets ]
                                    [ CC-Input-Octets ]
                                    [ CC-Output-Octets ]
                                    [ CC-Service-Specific-Units ]
                                   *[ AVP ]
 */

@DiameterAvpDefinition(code = AvpCodes.REQUESTED_SERVICE_UNIT, vendorId = -1, name = "Requested-Service-Unit")
public interface RequestedServiceUnit extends DiameterGroupedAvp 
{
	Date getCCTime();
	
	void setCCTime(Date ccTime);
	
	CCMoney getCCMoney();
	
	void setCCMoney(CCMoney ccMoney);
	
	Long getCCTotalOctets();
	
	void setCCTotalOctets(Long ccTotalOctets);
	
	Long getCCInputOctets();
	
	void setCCInputOctets(Long ccInputOctets);
	
	Long getCCOutputOctets();
	
	void setCCOutputOctets(Long ccOutputOctets);
	
	Long getCCServiceSpecificUnits();
	
	void setCCServiceSpecificUnits(Long ccServiceSpecificUnits);		
}