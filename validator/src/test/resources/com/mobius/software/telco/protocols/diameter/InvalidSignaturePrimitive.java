package com.mobius.software.telco.protocols.diameter;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterLength;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterEncode;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;

public class InvalidSignaturePrimitive implements AvpInterface
{
	@DiameterLength
	public Integer getLength(Integer badParameter) {
		return 0;
	}
	
	@DiameterDecode
	public DiameterException decode(Integer badParameter) {	
		return null;
	}
	
	@DiameterEncode
	public void encode() {		
	}
}