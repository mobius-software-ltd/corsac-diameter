package com.mobius.software.telco.protocols.diameter.impl.app.gqtag;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
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
import com.mobius.software.telco.protocols.diameter.app.gqtag.GqTagAuthClientSession;
import com.mobius.software.telco.protocols.diameter.commands.gqtag.AAAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gqtag.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.gqtag.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gqtag.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gqtag.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gqtag.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gqtag.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gqtag.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionImpl;

public class GqTagAuthClientSessionImpl extends ClientAuthSessionImpl<AARequest, AAAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements GqTagAuthClientSession
{
	public GqTagAuthClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthListener<AARequest, AAAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?, ?> provider)
	{
		super(sessionID,Long.valueOf(ApplicationIDs.GQ), remoteHost, remoteRealm, provider);
	}
}
