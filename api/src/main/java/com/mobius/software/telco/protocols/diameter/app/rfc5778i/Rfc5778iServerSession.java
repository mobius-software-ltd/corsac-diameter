package com.mobius.software.telco.protocols.diameter.app.rfc5778i;
import com.mobius.software.telco.protocols.diameter.app.ServerAccSession;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.SessionTerminationAnswer;
/**
*
* @author yulian oifa
*
*/
public interface Rfc5778iServerSession extends ServerAccSession<AccountingAnswer>,ServerAuthSession<EAPAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
}