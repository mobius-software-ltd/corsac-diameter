package com.mobius.software.telco.protocols.diameter.app.s9;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.ServerCCSession;
import com.mobius.software.telco.protocols.diameter.commands.s9.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9.TriggerEstablishmentAnswer;

public interface S9ServerSession extends ServerAuthSessionStateless<TriggerEstablishmentAnswer>,ServerCCSession<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}
