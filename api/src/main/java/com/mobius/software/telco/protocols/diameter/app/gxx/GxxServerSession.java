package com.mobius.software.telco.protocols.diameter.app.gxx;

import com.mobius.software.telco.protocols.diameter.app.ServerCCSession;
import com.mobius.software.telco.protocols.diameter.commands.gxx.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gxx.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gxx.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gxx.SessionTerminationAnswer;

public interface GxxServerSession extends ServerCCSession<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}