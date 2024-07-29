package com.mobius.software.telco.protocols.diameter.app.gx;
import com.mobius.software.telco.protocols.diameter.app.ServerCCListener;
import com.mobius.software.telco.protocols.diameter.commands.gx.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gx.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gx.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gx.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.gx.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gx.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gx.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gx.SessionTerminationRequest;
/**
*
* @author yulian oifa
*
*/
public interface ServerListener extends ServerCCListener<CreditControlRequest, CreditControlAnswer, ReAuthRequest, ReAuthAnswer, AbortSessionRequest, AbortSessionAnswer, SessionTerminationRequest, SessionTerminationAnswer>
{
}
