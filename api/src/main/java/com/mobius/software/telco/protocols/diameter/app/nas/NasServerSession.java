package com.mobius.software.telco.protocols.diameter.app.nas;
import com.mobius.software.telco.protocols.diameter.app.ServerAccSession;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.nas.AAAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nas.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.nas.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nas.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.nas.SessionTerminationAnswer;
/**
*
* @author yulian oifa
*
*/
public interface NasServerSession extends ServerAccSession<AccountingAnswer>,ServerAuthSession<AAAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}