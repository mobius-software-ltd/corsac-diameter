package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.0A	Access-Network-Info-Change AVP
	The Access-Network-Info-Change AVP (AVP code 4401) is of type Grouped and holds information on subsequent changes in one or two SIP P-header(s) "P-Access-Network-Info" together with the time it was acquired.
	It has the following ABNF grammar:
            
    Access-Network-Info-Change :: =  < AVP Header: 4401>
 			*	[ Access-Network-Information ] 
				[ Cellular-Network-Information ]
				[ Change-Time ]
 */
@DiameterAvpDefinition(code = 4401L, vendorId = KnownVendorIDs.TGPP_ID, name = "Access-Network-Info-Change")
public interface AccessNetworkInfoChange extends DiameterAvp
{
	List<ByteBuf> getAccessNetworkInformation();
	
	void setAccessNetworkInformation(List<ByteBuf> value);	
	
	ByteBuf getCellularNetworkInformation();
	
	void setCellularNetworkInformation(ByteBuf value);
	
	Date getChangeTime();
	
	void setChangeTime(Date value);
}