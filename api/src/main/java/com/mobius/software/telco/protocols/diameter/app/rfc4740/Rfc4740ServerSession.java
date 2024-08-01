package com.mobius.software.telco.protocols.diameter.app.rfc4740;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.Rfc4740Answer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.SessionTerminationAnswer;

public interface Rfc4740ServerSession extends ServerAuthSession<Rfc4740Answer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{	
}


