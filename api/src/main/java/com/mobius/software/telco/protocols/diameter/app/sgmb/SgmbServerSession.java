package com.mobius.software.telco.protocols.diameter.app.sgmb;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SgmbAnswer;

public interface SgmbServerSession extends ServerAuthSession<SgmbAnswer, ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{

	void sendInitialAnswer(SgmbAnswer request, AsyncCallback callback);
}
