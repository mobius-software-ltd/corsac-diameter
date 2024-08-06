package com.mobius.software.telco.protocols.diameter.impl.app.swd;
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
import com.mobius.software.telco.protocols.diameter.app.swd.SwdClientSession;
import com.mobius.software.telco.protocols.diameter.commands.swd.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.swd.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.swd.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.swd.EAPAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swd.EAPRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionImpl;

public class SwdClientSessionImpl extends ClientAuthSessionImpl<EAPRequest, EAPAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements SwdClientSession
{
	public SwdClientSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.STA));
	}
	
	public SwdClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthListener<EAPRequest, EAPAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?, ?> provider)
	{
		super(sessionID,Long.valueOf(ApplicationIDs.STA),remoteHost, remoteRealm, provider);
	}
}
