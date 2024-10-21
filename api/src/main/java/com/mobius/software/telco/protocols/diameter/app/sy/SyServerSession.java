package com.mobius.software.telco.protocols.diameter.app.sy;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSession;
import com.mobius.software.telco.protocols.diameter.commands.sy.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingLimitAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SpendingStatusNotificationRequest;
/**
*
* @author yulian oifa
*
*/
public interface SyServerSession extends ServerAuthSession<SpendingLimitAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>
{
	void sendStatusNotificationRequest(SpendingStatusNotificationRequest request,AsyncCallback callback);		
}