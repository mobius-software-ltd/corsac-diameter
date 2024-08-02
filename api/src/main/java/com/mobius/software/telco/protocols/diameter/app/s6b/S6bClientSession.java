package com.mobius.software.telco.protocols.diameter.app.s6b;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.s6b.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6b.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6b.S6bRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6b.SessionTerminationRequest;

public interface S6bClientSession extends ClientAuthSession<S6bRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{	
}

