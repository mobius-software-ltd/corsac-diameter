package com.mobius.software.telco.protocols.diameter.app.sgmb;

import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SgmbRequest;

public interface SgmbClientSession extends ClientAuthSession<SgmbRequest, ReAuthAnswer, AbortSessionAnswer, SessionTerminationRequest>
{

	void sendInitialRequest(SgmbRequest request, AsyncCallback callback);
}