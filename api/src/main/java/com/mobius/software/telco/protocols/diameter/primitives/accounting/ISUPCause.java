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
 * 	7.2.80B	ISUP-Cause AVP
	The ISUP-Cause AVP (AVP code 3416) is of type Grouped and indicates the reason a voice call service is released. When used for IMS charging, this AVP indicates the reason a CS call is released.
	It has the following ABNF:
	
	ISUP-Cause ::= <AVP Header: 3416>
		[ ISUP-Cause-Location ]
		[ ISUP-Cause-Value ]
		[ ISUP-Cause-Diagnostics ]
 */
@DiameterAvpDefinition(code = 3416L, vendorId = KnownVendorIDs.TGPP_ID, name = "ISUP-Cause")
public interface ISUPCause extends DiameterAvp
{
	Long getISUPCauseLocation();
	
	void setISUPCauseLocation(Long value);
	
	Long getISUPCauseValue();
	
	void setISUPCauseValue(Long value);
	
	ByteBuf getISUPCauseDiagnostics();
	
	void setISUPCauseDiagnostics(ByteBuf value);
}