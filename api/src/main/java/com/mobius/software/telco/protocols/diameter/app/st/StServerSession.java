package com.mobius.software.telco.protocols.diameter.app.st;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.st.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.st.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.st.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.st.StAnswer;

public interface StServerSession extends ServerAuthSession<StAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{	
}


