package com.mobius.software.telco.protocols.diameter;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterLength;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterEncode;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import io.netty.buffer.ByteBuf;

public class GoodPrimitive implements AvpInterface 
{
	@DiameterLength
	public Integer getLength() {
		return 0;
	}
	
	@DiameterDecode
	public DiameterException decode(ByteBuf buffer,Integer length) {		
		return null;
	}
	
	@DiameterEncode
	public void encode(ByteBuf buffer) {		
	}
}