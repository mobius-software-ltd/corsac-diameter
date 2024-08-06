package com.mobius.software.telco.protocols.diameter.app.swa;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.swa.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swa.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swa.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.swa.EAPRequest;

public interface SwaClientSession extends ClientAuthSession<EAPRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{	
}

