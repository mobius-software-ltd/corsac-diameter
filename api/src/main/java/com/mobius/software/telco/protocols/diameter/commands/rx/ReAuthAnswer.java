package com.mobius.software.telco.protocols.diameter.commands.rx;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentDescription;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.4	Re-Auth-Answer (RAA) command
	The RAA command, indicated by the Command-Code field set to 258 and the ‘R’ bit cleared in the Command Flags field, is sent by the AF to the PCRF in response to the RAR command.
	Message Format:

	<RA-Answer> ::=  < Diameter Header: 258, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Origin-Host }
				 { Origin-Realm }
				 [ Result-Code ]
				 [ Experimental-Result ]
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				*[ Media-Component-Description ]
				 [ Service-URN ]
				 [ Origin-State-Id ]
				*[ Class ]
				 [ Error-Message ]
				 [ Error-Reporting-Host ]
				*[ Redirect-Host ]
				 [ Redirect-Host-Usage ]
				 [ Redirect-Max-Cache-Time ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.RX, commandCode = CommandCodes.REAUTH, request = false, proxyable = true, name="Re-Auth-Answer")
public interface ReAuthAnswer extends RxAnswer,com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer
{
	public List<MediaComponentDescription> getMediaComponentDescription();
	
	void setMediaComponentDescription(List<MediaComponentDescription> value);
	
	ByteBuf getServiceURN();
	
	void setServiceURN(ByteBuf value);
	
	List<ByteBuf> getDiameterClass();

	void setDiameterClass(List<ByteBuf> value);
}