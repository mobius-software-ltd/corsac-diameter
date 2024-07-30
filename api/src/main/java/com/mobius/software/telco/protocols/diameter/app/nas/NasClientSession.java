package com.mobius.software.telco.protocols.diameter.app.nas;
import com.mobius.software.telco.protocols.diameter.app.ClientAccSession;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.nas.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.nas.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nas.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.nas.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.nas.SessionTerminationRequest;
/**
*
* @author yulian oifa
*
*/
public interface NasClientSession extends ClientAccSession<AccountingRequest>,ClientAuthSession<AARequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}