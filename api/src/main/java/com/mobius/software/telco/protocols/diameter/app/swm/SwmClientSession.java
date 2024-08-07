package com.mobius.software.telco.protocols.diameter.app.swm;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.swm.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.swm.SwmRequest;

public interface SwmClientSession extends ClientAuthSession<SwmRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{	
}

