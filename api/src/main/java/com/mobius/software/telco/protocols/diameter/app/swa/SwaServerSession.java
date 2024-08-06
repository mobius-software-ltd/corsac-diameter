package com.mobius.software.telco.protocols.diameter.app.swa;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.swa.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.swa.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.swa.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swa.EAPAnswer;

public interface SwaServerSession extends ServerAuthSession<EAPAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{	
}


