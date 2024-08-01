package com.mobius.software.telco.protocols.diameter.app.rfc5778a;
import com.mobius.software.telco.protocols.diameter.app.ServerAccSession;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.MIP6Answer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.SessionTerminationAnswer;
/**
*
* @author yulian oifa
*
*/
public interface Rfc5778aServerSession extends ServerAccSession<AccountingAnswer>,ServerAuthSession<MIP6Answer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}