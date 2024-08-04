package com.mobius.software.telco.protocols.diameter.impl.app.gmb;
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
import com.mobius.software.telco.protocols.diameter.app.ServerAuthListener;
import com.mobius.software.telco.protocols.diameter.app.gmb.GMBAuthServerSession;
import com.mobius.software.telco.protocols.diameter.commands.gmb.AAAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gmb.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.gmb.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gmb.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gmb.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gmb.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gmb.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gmb.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAuthSessionImpl;

public class GMBAuthServerSessionImpl extends ServerAuthSessionImpl<AARequest, AAAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements GMBAuthServerSession
{
	public GMBAuthServerSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.GMB));
	}
	
	public GMBAuthServerSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerAuthListener<AARequest, AAAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?> provider)
	{
		super(sessionID,Long.valueOf(ApplicationIDs.GMB), remoteHost, remoteRealm, provider);
	}
}