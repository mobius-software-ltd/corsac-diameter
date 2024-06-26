package com.mobius.software.telco.protocols.diameter.impl.app;
/*
 * Mobius Software LTD
 * Copyright 2023, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
import java.util.Collection;

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
		answerSent(answer, callback, null);
		provider.getStack().sendAnswerToNetwork(answer, getRemoteHost(), getRemoteRealm(), callback);			
	}
	
	@Override
	public void requestReceived(DiameterRequest request, AsyncCallback callback)
	{		
		try
		{
			@SuppressWarnings("unchecked")
			R1 castedRequest = (R1)request;
			@SuppressWarnings("unchecked")
			Collection<ServerAuthStatelessListener> listeners = (Collection<ServerAuthStatelessListener>) provider.getServerListeners().values();
			for(ServerAuthStatelessListener listener:listeners)
				listener.onInitialRequest(castedRequest, callback);					
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