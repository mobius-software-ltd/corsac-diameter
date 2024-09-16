package com.mobius.software.telco.protocols.diameter.app.custom;
import com.mobius.software.telco.protocols.diameter.app.ClientCCListener;
import com.mobius.software.telco.protocols.diameter.commands.custom.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.custom.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.custom.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.custom.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.custom.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.custom.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.custom.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.custom.SessionTerminationRequest;

public interface ClientListener extends ClientCCListener<CreditControlRequest, CreditControlAnswer, ReAuthRequest, ReAuthAnswer, AbortSessionRequest, AbortSessionAnswer, SessionTerminationRequest, SessionTerminationAnswer>
{
}
