package com.mobius.software.telco.protocols.diameter.app.creditcontrol;

import com.mobius.software.telco.protocols.diameter.app.ServerCCSession;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.SessionTerminationAnswer;

public interface CreditControlServerSession extends ServerCCSession<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}