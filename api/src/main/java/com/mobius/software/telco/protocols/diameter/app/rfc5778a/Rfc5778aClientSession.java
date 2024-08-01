package com.mobius.software.telco.protocols.diameter.app.rfc5778a;
import com.mobius.software.telco.protocols.diameter.app.ClientAccSession;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.MIP6Request;
/**
*
* @author yulian oifa
*
*/
public interface Rfc5778aClientSession extends ClientAccSession<AccountingRequest>,ClientAuthSession<MIP6Request,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}