package com.mobius.software.telco.protocols.diameter.app.s9atag;

import com.mobius.software.telco.protocols.diameter.app.ServerCCSession;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.SessionTerminationAnswer;

public interface S9atagServerSession extends ServerCCSession<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}