package com.mobius.software.telco.protocols.diameter.app.sy;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.sy.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingLimitRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingStatusNotificationAnswer;
/**
*
* @author yulian oifa
*
*/
public interface SyClientSession extends ClientAuthSession<SpendingLimitRequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>
{
	void sendStatusNotificationAnswer(SpendingStatusNotificationAnswer answer,AsyncCallback callback);		
}