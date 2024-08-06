package com.mobius.software.telco.protocols.diameter.app.st;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.st.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.st.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.st.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.st.StRequest;

public interface StClientSession extends ClientAuthSession<StRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{	
}

