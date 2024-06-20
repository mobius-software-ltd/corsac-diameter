package com.mobius.software.telco.protocols.diameter.app.gi;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.gi.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.SessionTerminationRequest;
/**
*
* @author yulian oifa
*
*/
public interface GiAuthClientSession extends ClientAuthSession<AARequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}