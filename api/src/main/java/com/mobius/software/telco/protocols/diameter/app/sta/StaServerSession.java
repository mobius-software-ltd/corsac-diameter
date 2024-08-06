package com.mobius.software.telco.protocols.diameter.app.sta;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.sta.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sta.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sta.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sta.StaAnswer;

public interface StaServerSession extends ServerAuthSession<StaAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{	
}


