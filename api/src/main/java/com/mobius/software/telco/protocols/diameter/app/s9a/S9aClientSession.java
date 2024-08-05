package com.mobius.software.telco.protocols.diameter.app.s9a;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.ClientCCSession;
import com.mobius.software.telco.protocols.diameter.commands.s9a.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9a.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9a.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9a.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9a.TriggerEstablishmentRequest;

public interface S9aClientSession extends ClientAuthSessionStateless<TriggerEstablishmentRequest>,ClientCCSession<CreditControlRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}