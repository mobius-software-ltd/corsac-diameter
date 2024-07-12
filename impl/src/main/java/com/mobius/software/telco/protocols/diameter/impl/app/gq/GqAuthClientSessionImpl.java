package com.mobius.software.telco.protocols.diameter.impl.app.gq;
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
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.app.ClientAuthListener;
import com.mobius.software.telco.protocols.diameter.app.gq.GqAuthClientSession;
import com.mobius.software.telco.protocols.diameter.commands.gq.AAAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gq.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.gq.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gq.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gq.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gq.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gq.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gq.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionImpl;

public class GqAuthClientSessionImpl extends ClientAuthSessionImpl<AARequest, AAAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements GqAuthClientSession
{
	public GqAuthClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthListener<AAAnswer,ReAuthRequest,AbortSessionRequest,SessionTerminationAnswer>, ?, ?, ?, ?> provider)
	{
		super(sessionID, remoteHost, remoteRealm, provider);
	}
}
