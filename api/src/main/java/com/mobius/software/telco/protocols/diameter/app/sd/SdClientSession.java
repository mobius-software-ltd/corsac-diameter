package com.mobius.software.telco.protocols.diameter.app.sd;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.app.ClientCCSession;
import com.mobius.software.telco.protocols.diameter.commands.sd.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sd.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sd.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sd.TDFSessionRequest;

public interface SdClientSession extends ClientAuthSession<TDFSessionRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest>,ClientCCSession<CreditControlRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}