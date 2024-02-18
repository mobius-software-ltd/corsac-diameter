package com.mobius.software.telco.protocols.diameter.primitives.pc2;
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

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.4.9	Monitor-Target AVP
	The Monitor-Target AVP (AVP code 3607) is of type Grouped. It contains a Target-RPAUID, a PDUID and zero or more ProSe Code Suffix Mask(s).
	The AVP format shall conform to:

	Monitor-Target ::= <AVP header:3607>
                   { Target-RPAUID }
                   { PDUID }
                   [ Metadata-Indicator ]
                  *[ ProSe-Code-Suffix-Mask ]
                  *[AVP]

If the Metadata-Indicator value is "0 (NO_METADATA)", the Metadata-Indicator AVP may be omitted.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MONITOR_TARGET, vendorId = VendorIDs.TGPP_ID, must = false, name = "Monitor-Target")
public interface MonitorTarget extends DiameterGroupedAvp
{
	String getTargetRPAUID();
	
	void setTargetRPAUID(String value) throws MissingAvpException;
	
	ByteBuf getPDUID();
	
	void setPDUID(ByteBuf value) throws MissingAvpException;
	
	MetadataIndicatorEnum getMetadataIndicator();
	
	void setMetadataIndicator(MetadataIndicatorEnum value);
	
	List<ProSeCodeSuffixMask> getProSeCodeSuffixMask();
	
	void setProSeCodeSuffixMask(List<ProSeCodeSuffixMask> value);
}