package com.mobius.software.telco.protocols.diameter.app.creditcontrol.ericsson;

import com.mobius.software.telco.protocols.diameter.app.ClientCCSession;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson.SessionTerminationRequest;

public interface EricssonCreditControlClientSession extends ClientCCSession<CreditControlRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}