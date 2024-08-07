package com.mobius.software.telco.protocols.diameter.impl.app.sgmb;
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
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.app.ServerAuthListener;
import com.mobius.software.telco.protocols.diameter.app.sgmb.SgmbServerSession;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SgmbAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.SgmbRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAuthSessionImpl;

public class SgmbServerSessionImpl extends ServerAuthSessionImpl<SgmbRequest, SgmbAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements SgmbServerSession
{
	public SgmbServerSessionImpl() throws DiameterException
	{
		super(Long.valueOf(ApplicationIDs.SGMB));
		
	}
	
	public SgmbServerSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerAuthListener<SgmbRequest, SgmbAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?> provider) 
	{
		super(sessionID, Long.valueOf(ApplicationIDs.SGMB), remoteHost, remoteRealm, provider);
		
	}
	
	@Override
	public void sendInitialAnswer(SgmbAnswer request, AsyncCallback callback)
	{
			sendInitialAnswer(request, callback); 
			callback.onError(new DiameterException("The SgmbRequest is not real and can not be created", null, ResultCodes.DIAMETER_COMMAND_UNSUPPORTED, null));
	}
	
}