package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
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
 * 4.1.1.  Classifier AVP

   The Classifier AVP (AVP Code 511) is a grouped AVP that consists of a
   set of attributes that specify how to match a packet.

   Classifier ::= < AVP Header: 511 >
                  { Classifier-ID }
                  [ Protocol ]
                  [ Direction ]
                * [ From-Spec ]
                * [ To-Spec ]
                * [ Diffserv-Code-Point ]
                  [ Fragmentation-Flag ]
                * [ IP-Option ]
                * [ TCP-Option ]
                  [ TCP-Flags ]
                * [ ICMP-Type ]
                * [ ETH-Option ]
                * [ AVP ]
 */
@DiameterAvpDefinition(code = AvpCodes.CLASSIFIER, vendorId = -1L, name = "Classifier")
public interface Classifier extends DiameterGroupedAvp
{
	ByteBuf getClassifierID();
	
	void setClassifierID(ByteBuf value) throws MissingAvpException;	
	
	ProtocolEnum getProtocol();
	
	void setProtocol(ProtocolEnum value);
	
	DirectionEnum getDirection();
	
	void setDirection(DirectionEnum value);
	
	List<FromSpec> getFromSpec();
	
	void setFromSpec(List<FromSpec> value);	
	
	List<ToSpec> getToSpec();	
	
	void setToSpec(List<ToSpec> value);
	
	DiffServCodePointEnum getDiffServCodePoint();
	
	void setDiffServCodePoint(DiffServCodePointEnum value);
	
	FragmentationFlagEnum getFragmentationFlag();
	
	void setFragmentationFlag(FragmentationFlagEnum value);
	
	List<IPOption> getIPOption();	
	
	void setIPOption(List<IPOption> value);		
	
	List<TCPOption> getTCPOption();	
	
	void setTCPOption(List<TCPOption> value);		
	
	List<TCPFlags> getTCPFlags();	
	
	void setTCPFlags(List<TCPFlags> value);	
	
	List<ICMPType> getICMPType();	
	
	void setICMPType(List<ICMPType> value);	
	
	List<ETHOption> getETHOption();	
	
	void setETHOption(List<ETHOption> value);	
}