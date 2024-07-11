package com.mobius.software.telco.protocols.diameter.app.gy;
import com.mobius.software.telco.protocols.diameter.app.ClientCCSession;
import com.mobius.software.telco.protocols.diameter.commands.gy.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gy.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.gy.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gy.SessionTerminationRequest;

public interface GyClientSession extends ClientCCSession<CreditControlRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}