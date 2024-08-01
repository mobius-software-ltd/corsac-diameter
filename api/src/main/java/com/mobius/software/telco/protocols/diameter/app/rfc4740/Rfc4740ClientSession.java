package com.mobius.software.telco.protocols.diameter.app.rfc4740;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.Rfc4740Request;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.SessionTerminationRequest;

public interface Rfc4740ClientSession extends ClientAuthSession<Rfc4740Request,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{	
}

