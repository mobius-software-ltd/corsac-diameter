package com.mobius.software.telco.protocols.diameter.app.s9a;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.ServerCCSession;
import com.mobius.software.telco.protocols.diameter.commands.s9a.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9a.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9a.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9a.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9a.TriggerEstablishmentAnswer;

public interface S9aServerSession extends ServerAuthSessionStateless<TriggerEstablishmentAnswer>,ServerCCSession<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}
