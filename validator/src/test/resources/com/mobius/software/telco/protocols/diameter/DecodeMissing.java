package com.mobius.software.telco.protocols.diameter;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterLength;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterEncode;
import io.netty.buffer.ByteBuf;

public class DecodeMissing implements AvpInterface 
{
	@DiameterLength
	public Integer getLength() {
		return 0;
	}
	
	@DiameterEncode
	public void encode(ByteBuf buffer) {		
	}
}
