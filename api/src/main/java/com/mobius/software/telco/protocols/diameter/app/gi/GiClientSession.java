package com.mobius.software.telco.protocols.diameter.app.gi;
import com.mobius.software.telco.protocols.diameter.app.ClientAccSession;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.gi.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.SessionTerminationRequest;
/**
*
* @author yulian oifa
*
*/
public interface GiClientSession extends ClientAccSession<AccountingRequest>,ClientAuthSession<AARequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
}