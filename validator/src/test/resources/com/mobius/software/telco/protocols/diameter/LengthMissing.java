package com.mobius.software.telco.protocols.diameter;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterEncode;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import io.netty.buffer.ByteBuf;

public class LengthMissing implements AvpInterface 
{
	@DiameterDecode
	public DiameterException decode(ByteBuf buffer,Integer parameter) {		
		return null;
	}
	
	@DiameterEncode
	public void encode(ByteBuf buffer) {		
	}
}