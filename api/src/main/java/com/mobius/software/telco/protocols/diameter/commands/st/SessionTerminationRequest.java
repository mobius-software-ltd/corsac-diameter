package com.mobius.software.telco.protocols.diameter.commands.st;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5c.6.4	Session-Termination-Request (STR) command
	The STR command, indicated by the Command-Code field set to 275 and the ‘R’ bit set in the Command Flags field, is sent by the PCRF to inform the TSSF that an established St session shall be terminated.
	Message Format:
	
	<ST-Request> ::= < Diameter Header: 275, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Auth-Application-Id }
				 { Termination-Cause }
				 [ Destination-Host ]
				 [ OC-Supported-Features ]
				*[ Class ]
				 [ Origin-State-Id ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777349, commandCode = 275, request = true, proxyable = true, name="Session-Termination-Request")
public interface SessionTerminationRequest extends AuthenticationRequest
{
	public TerminationCauseEnum getTerminationCause();
	
	void setTerminationCause(TerminationCauseEnum value);
	
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	public List<ByteBuf> getDiameterClass();
	
	void setDiameterClass(List<ByteBuf> value);		
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
}