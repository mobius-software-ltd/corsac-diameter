package com.mobius.software.telco.protocols.diameter.app.custom;

import com.mobius.software.telco.protocols.diameter.app.ClientCCSession;
import com.mobius.software.telco.protocols.diameter.commands.custom.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.custom.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.custom.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.custom.SessionTerminationRequest;

public interface СustomClientSession extends ClientCCSession<CreditControlRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}