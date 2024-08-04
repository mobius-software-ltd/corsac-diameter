package com.mobius.software.telco.protocols.diameter.impl.app.rfc4740;
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
import com.mobius.software.telco.protocols.diameter.app.rfc4740.Rfc4740ClientSession;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.Rfc4740Answer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.Rfc4740Request;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionImpl;

public class Rfc4740ClientSessionImpl extends ClientAuthSessionImpl<Rfc4740Request, Rfc4740Answer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements Rfc4740ClientSession
{
	public Rfc4740ClientSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.SIP_APPLICATION));
	}
	
	public Rfc4740ClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthListener<Rfc4740Request, Rfc4740Answer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?, ?> provider)
	{
		super(sessionID,Long.valueOf(ApplicationIDs.SIP_APPLICATION),remoteHost, remoteRealm, provider);
	}
}
