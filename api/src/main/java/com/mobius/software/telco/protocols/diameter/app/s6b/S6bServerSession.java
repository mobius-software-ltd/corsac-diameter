package com.mobius.software.telco.protocols.diameter.app.s6b;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.s6b.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6b.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.s6b.S6bAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6b.SessionTerminationAnswer;

public interface S6bServerSession extends ServerAuthSession<S6bAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{	
}


