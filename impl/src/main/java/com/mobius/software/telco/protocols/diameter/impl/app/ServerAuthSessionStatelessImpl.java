package com.mobius.software.telco.protocols.diameter.impl.app;
import java.util.Collection;

import com.mobius.software.common.dal.timers.Task;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthStatelessListener;
import com.mobius.software.telco.protocols.diameter.app.SessionStateEnum;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterSessionImpl;
/**
*
* @author yulian oifa
*
*/
public class ServerAuthSessionStatelessImpl<R1 extends DiameterRequest,A1 extends DiameterAnswer> extends DiameterSessionImpl implements ServerAuthSessionStateless<A1>
{
	private DiameterProvider<?, ? extends ServerAuthStatelessListener<R1,A1>, ?, ?, ?> provider;
	//for serialization
	public ServerAuthSessionStatelessImpl(Long applicationID)
	{
		super(applicationID);				
	}
								
	public ServerAuthSessionStatelessImpl(String sessionID, Long applicationID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerAuthStatelessListener<R1,A1>, ?, ?, ?> provider)
	{
		super(sessionID, applicationID, remoteHost, remoteRealm, provider);
		this.provider = provider;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setProvider(DiameterProvider<?, ?, ?, ?, ?> provider)
	{
		this.provider = (DiameterProvider<?, ? extends ServerAuthStatelessListener<R1,A1>, ?, ?, ?>)provider;
		super.setProvider(provider);
	}

	@Override
	public void sendInitialAnswer(A1 answer, AsyncCallback callback)
	{
		if(getSessionState()!=null && getSessionState()!=SessionStateEnum.IDLE && getSessionState()!=SessionStateEnum.OPEN)
		{
			callback.onError(new DiameterException("session state is invalid, can not send message", null, ResultCodes.DIAMETER_UNABLE_TO_COMPLY, null));
			return;
		}
		
		final Long startTime = System.currentTimeMillis();
		provider.getStack().getQueue().offerLast(new Task()
		{
			@Override
			public long getStartTime()
			{
				return startTime;
			}
			
			@Override
			public void execute()
			{
				answerSent(answer, null, callback);
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);
				terminate(answer.getResultCode());
			}
		});					
	}
	
	@Override
	public void requestReceived(DiameterRequest request, String linkID, AsyncCallback callback)
	{		
		try
		{
			@SuppressWarnings("unchecked")
			R1 castedRequest = (R1)request;
			
			if(provider.getServerListeners()!=null)
			{
				@SuppressWarnings("unchecked")
				Collection<ServerAuthStatelessListener<R1,A1>> listeners = (Collection<ServerAuthStatelessListener<R1,A1>>) provider.getServerListeners().values();
				for(ServerAuthStatelessListener<R1,A1> listener:listeners)
					listener.onInitialRequest(castedRequest, this, linkID,callback);
			}
		}
		catch(Exception ex)
		{
			callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));			
		}			
	}
	
	@Override
	public void answerReceived(DiameterAnswer answer, Long idleTime,Boolean stopSendTimer,String linkID, AsyncCallback callback)
	{
		callback.onError(new DiameterException("Received unexpected answer", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));		
	}

	@Override
	public boolean isServer()
	{
		return true;
	}
}