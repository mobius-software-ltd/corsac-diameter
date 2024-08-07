package com.mobius.software.telco.protocols.diameter.app.sy;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.sy.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SyAnswer;
/**
*
* @author yulian oifa
*
*/
public interface SyServerSession extends ServerAuthSession<SyAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}