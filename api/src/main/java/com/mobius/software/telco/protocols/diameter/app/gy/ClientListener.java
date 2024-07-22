package com.mobius.software.telco.protocols.diameter.app.gy;
import com.mobius.software.telco.protocols.diameter.app.ClientCCListener;
import com.mobius.software.telco.protocols.diameter.commands.gy.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gy.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gy.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gy.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.gy.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gy.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gy.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gy.SessionTerminationRequest;

public interface ClientListener extends ClientCCListener<CreditControlRequest, CreditControlAnswer, ReAuthRequest, ReAuthAnswer, AbortSessionRequest, AbortSessionAnswer, SessionTerminationRequest, SessionTerminationAnswer>
{
}
