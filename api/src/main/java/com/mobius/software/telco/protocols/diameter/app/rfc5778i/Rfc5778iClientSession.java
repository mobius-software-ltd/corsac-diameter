package com.mobius.software.telco.protocols.diameter.app.rfc5778i;
import com.mobius.software.telco.protocols.diameter.app.ClientAccSession;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778i.EAPRequest;
/**
*
* @author yulian oifa
*
*/
public interface Rfc5778iClientSession extends ClientAccSession<AccountingRequest>,ClientAuthSession<EAPRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}