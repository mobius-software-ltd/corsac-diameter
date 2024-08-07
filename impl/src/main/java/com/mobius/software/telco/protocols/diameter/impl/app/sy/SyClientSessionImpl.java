package com.mobius.software.telco.protocols.diameter.impl.app.sy;
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
import com.mobius.software.telco.protocols.diameter.app.sy.SyClientSession;
import com.mobius.software.telco.protocols.diameter.commands.sy.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.sy.SyAnswer;
import com.mobius.software.telco.protocols.diameter.commands.sy.SyRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionImpl;

public class SyClientSessionImpl extends ClientAuthSessionImpl<SyRequest, SyAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements SyClientSession
{
	public SyClientSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.SY));
	}
	
	public SyClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthListener<SyRequest, SyAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?, ?> provider)
	{
		super(sessionID,Long.valueOf(ApplicationIDs.SY),remoteHost, remoteRealm, provider);
	}
}
