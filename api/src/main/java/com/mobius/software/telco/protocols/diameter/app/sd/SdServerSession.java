package com.mobius.software.telco.protocols.diameter.app.sd;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.app.ServerCCSession;
import com.mobius.software.telco.protocols.diameter.commands.sd.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sd.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sd.TDFSessionAnswer;

public interface SdServerSession extends ServerAuthSession<TDFSessionAnswer, ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>,ServerCCSession<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}
