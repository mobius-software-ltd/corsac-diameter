package com.mobius.software.telco.protocols.diameter.app.sta;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.sta.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sta.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sta.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sta.StaRequest;

public interface StaClientSession extends ClientAuthSession<StaRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{	
}

