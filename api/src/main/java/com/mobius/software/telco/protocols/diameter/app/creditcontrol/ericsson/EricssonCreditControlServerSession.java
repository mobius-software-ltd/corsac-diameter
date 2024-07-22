package com.mobius.software.telco.protocols.diameter.app.creditcontrol.ericsson;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ericsson.SessionTerminationAnswer;

public interface EricssonCreditControlServerSession extends ServerAuthSession<CreditControlAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}