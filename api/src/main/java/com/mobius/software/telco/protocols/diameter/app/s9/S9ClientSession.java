package com.mobius.software.telco.protocols.diameter.app.s9;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.ClientCCSession;
import com.mobius.software.telco.protocols.diameter.commands.s9.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9.TriggerEstablishmentRequest;

public interface S9ClientSession extends ClientAuthSessionStateless<TriggerEstablishmentRequest>,ClientCCSession<CreditControlRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}