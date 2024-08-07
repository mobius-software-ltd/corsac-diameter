package com.mobius.software.telco.protocols.diameter.app.sy;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.sy.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SyRequest;
/**
*
* @author yulian oifa
*
*/
public interface SyClientSession extends ClientAuthSession<SyRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}