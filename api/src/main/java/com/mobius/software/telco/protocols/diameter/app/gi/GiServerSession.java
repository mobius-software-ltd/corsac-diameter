package com.mobius.software.telco.protocols.diameter.app.gi;
import com.mobius.software.telco.protocols.diameter.app.ServerAccSession;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.gi.AAAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.SessionTerminationAnswer;
/**
*
* @author yulian oifa
*
*/
public interface GiServerSession extends ServerAccSession<AccountingAnswer>,ServerAuthSession<AAAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}