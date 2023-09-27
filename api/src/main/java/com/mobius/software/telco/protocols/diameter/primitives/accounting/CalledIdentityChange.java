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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.31B	Called-Identity-Change AVP
	The Called-Identity-Change AVP (AVP code 3917) is of type Grouped and provides the terminating identity address change and associated time stamp.
	It has the following ABNF grammar:
           
    Called-Identity-Change :: =  < AVP Header: 3917>
			[ Called-Identity ]
			[ Change-Time ]
 */
@DiameterAvpDefinition(code = 3917L, vendorId = KnownVendorIDs.TGPP_ID, name = "Called-Identity-Change")
public interface CalledIdentityChange extends DiameterAvp
{
	String getCalledIdentity();
	
	void setCalledIdentity(String value);
	
	Date getChangeTime();
	
	void setChangeTime(Date value);
}