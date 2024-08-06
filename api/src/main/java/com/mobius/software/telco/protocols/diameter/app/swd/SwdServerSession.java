package com.mobius.software.telco.protocols.diameter.app.swd;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.swd.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.swd.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.swd.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.EAPAnswer;

public interface SwdServerSession extends ServerAuthSession<EAPAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{	
}


