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
 * 	6.3.39	ProSe-App-Code-Info
	The ProSe-App-Code-Info AVP is of type Grouped. It shall contain a ProSe Application Code, the associated MIC and the associated UTC-based counter.
	The AVP format shall conform to:
		
	ProSe-App-Code-Info ::=		<AVP header: 3835 10415>
		 { ProSe-App-Code }
		 { MIC }
		 { UTC-based-Counter }
		*[AVP]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PROSE_APP_CODE_INFO, vendorId = VendorIDs.TGPP_ID, name = "ProSe-App-Code-Info")
public interface ProSeAppCodeInfo extends DiameterGroupedAvp
{
	ByteBuf getProSeAppCode();
	
	void setProSeAppCode(ByteBuf value) throws MissingAvpException;
	
	ByteBuf getMIC();
	
	void setMIC(ByteBuf value) throws MissingAvpException;
	
	Long getUTCBasedCounter();
	
	void setUTCBasedCounter(Long value) throws MissingAvpException;
}