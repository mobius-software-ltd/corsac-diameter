package com.mobius.software.telco.protocols.diameter.app.swm;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.swm.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.swm.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.swm.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.SwmAnswer;

public interface SwmServerSession extends ServerAuthSession<SwmAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{	
}


