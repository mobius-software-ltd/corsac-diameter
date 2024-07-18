package com.mobius.software.telco.protocols.diameter.impl.app;
import java.util.Collection;

import com.mobius.software.common.dal.timers.Task;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthSessionStateless;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthStatelessListener;
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
	private DiameterProvider<?, ? extends ServerAuthStatelessListener, ?, ?, ?> provider;
	public ServerAuthSessionStatelessImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerAuthStatelessListener, ?, ?, ?> provider)
	{
		super(sessionID, remoteHost, remoteRealm, provider);
		this.provider = provider;
	}

	@Override
	public void sendInitialAnswer(A1 answer, AsyncCallback callback)
	{
		final Long startTime = System.currentTimeMillis();
		provider.getStack().getWorkerPool().getQueue().offerLast(new Task()
		{
			@Override
			public long getStartTime()
			{
				return startTime;
			}
			
			@Override
			public void execute()
			{
				answerSent(answer, callback, null);
				provider.getStack().sendAnswer(answer, getRemoteHost(), getRemoteRealm(), callback);
			}
		});					
	}
	
	@Override
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{		
		try
		{
			@SuppressWarnings("unchecked")
			R1 castedRequest = (R1)request;
			
			if(provider.getServerListeners()!=null)
			{
				@SuppressWarnings("unchecked")
				Collection<ServerAuthStatelessListener> listeners = (Collection<ServerAuthStatelessListener>) provider.getServerListeners().values();
				for(ServerAuthStatelessListener listener:listeners)
					listener.onInitialRequest(castedRequest, callback);
			}
		}
		catch(Exception ex)
		{
			callback.onError(new DiameterException("Received unexpected request", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));			
		}			
	}

	@Override
	public boolean isServer()
	{
		return true;
	}
}