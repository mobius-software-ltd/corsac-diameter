package com.mobius.software.telco.protocols.diameter.impl.app.swm;
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
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthListener;
import com.mobius.software.telco.protocols.diameter.app.swm.SwmClientSession;
import com.mobius.software.telco.protocols.diameter.commands.swm.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.swm.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.swm.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.swm.SwmAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swm.SwmRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionImpl;

public class SwmClientSessionImpl extends ClientAuthSessionImpl<SwmRequest, SwmAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements SwmClientSession
{
	public SwmClientSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.SWM));
	}
	
	public SwmClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthListener<SwmRequest, SwmAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?, ?> provider)
	{
		super(sessionID,Long.valueOf(ApplicationIDs.SWM),remoteHost, remoteRealm, provider);
	}
}
