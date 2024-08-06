package com.mobius.software.telco.protocols.diameter.app.swd;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.swd.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.swd.EAPRequest;

public interface SwdClientSession extends ClientAuthSession<EAPRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{	
}

