package com.mobius.software.telco.protocols.diameter.primitives.pc6;
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
 * 	6.3.20	ProSe-Discovery-Filter
	The ProSe-Discovery-Filter AVP is of type Grouped. It shall contain a Filter ID, a ProSe Application ID name, a validity timer, a ProSe Application Code and zero or more ProSe Application Masks.
	The AVP format shall conform to:
		
	ProSe-Discovery-Filter ::=	<AVP header: 3813 10415>
		 { Filter-Id }
		 { ProSe-App-Id }
		 { ProSe-Validity-Timer }
		 { ProSe-App-Code }
		*[ ProSe-App-Mask ]
		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PROSE_DISCOVERY_FILTER, vendorId = VendorIDs.TGPP_ID, name = "ProSe-Discovery-Filter")
public interface ProSeDiscoveryFilter extends DiameterGroupedAvp
{
	ByteBuf getFilterId();
	
	void setFilterId(ByteBuf value) throws MissingAvpException;
	
	String getProSeAppId();
	
	void setProSeAppId(String value) throws MissingAvpException;
	
	Long getProSeValidityTimer();
	
	void setProSeValidityTimer(Long value) throws MissingAvpException;
	
	ByteBuf getProSeAppCode();
	
	void setProSeAppCode(ByteBuf value) throws MissingAvpException;
	
	List<ByteBuf> getProSeAppMask();
	
	void setProSeAppMask(List<ByteBuf> value);
}