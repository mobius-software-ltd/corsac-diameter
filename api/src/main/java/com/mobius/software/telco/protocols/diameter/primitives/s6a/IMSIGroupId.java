package com.mobius.software.telco.protocols.diameter.primitives.s6a;
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
 * 	7.3.189	IMSI-Group-Id
	The IMSI-Group-Id AVP shall be of type Grouped. This AVP shall contain the information about the IMSI-Group-Id.
	AVP format

	IMSI-Group-Id ::= <AVP header: 1675 10415>
			 { Group-Service-Id }
			 { Group-PLMN-Id }
			 { Local-Group-Id }
			*[AVP]

	For details see 3GPP TS 23.003 [3], clause 19.9).
 */
@DiameterAvpDefinition(code = TgppAvpCodes.IMSI_GROUP_ID, vendorId = VendorIDs.TGPP_ID, must = false, name = "IMSI-Group-Id")
public interface IMSIGroupId extends DiameterGroupedAvp
{
	Long getGroupServiceId();
	
	void setGroupServiceId(Long value) throws MissingAvpException;
	
	ByteBuf getGroupPLMNId();
	
	void setGroupPLMNId(ByteBuf value) throws MissingAvpException;
	
	ByteBuf getLocalGroupId();
	
	void setLocalGroupId(ByteBuf value) throws MissingAvpException;
}