package com.mobius.software.telco.protocols.diameter;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;

@DiameterCommandDefinition(applicationId = ApplicationIDs.COMMON, commandCode = CommandCodes.ABORT_SESSION, request = false, proxyable = true, name="Abort-Session-Answer")
public interface CommandInterface 
{
	
}
