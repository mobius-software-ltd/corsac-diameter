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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.160B	Radio-Parameter-Set-Info AVP
	The Radio-Parameter-Set-Info AVP (AVP code 3463) is of type Grouped and provides information on a radio parameter set configured in the UE for direct communication use. Each set has an associated time stamp of when it became active.
	It has the following ABNF grammar:
	
	Radio-Parameter-Set-Info :: = < AVP Header: 3463>
		[ Radio-Parameter-Set-Values ]
		[ Change-Time ]
 */
@DiameterAvpDefinition(code = 3463L, vendorId = KnownVendorIDs.TGPP_ID, name = "Radio-Parameter-Set-Info")
public interface RadioParameterSetInfo extends DiameterAvp
{
	ByteBuf getRadioParameterSetValues();
	
	void setRadioParameterSetValues(ByteBuf value);
	
	Date getChangeTime();
	
	void setChangeTime(Date value);
}