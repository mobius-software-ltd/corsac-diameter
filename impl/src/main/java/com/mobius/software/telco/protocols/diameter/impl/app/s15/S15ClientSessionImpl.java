package com.mobius.software.telco.protocols.diameter.impl.app.s15;
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
import com.mobius.software.telco.protocols.diameter.app.ClientCCListener;
import com.mobius.software.telco.protocols.diameter.app.s15.S15ClientSession;
import com.mobius.software.telco.protocols.diameter.commands.s15.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.s15.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.s15.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.s15.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s15.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientCCSessionImpl;

public class S15ClientSessionImpl extends ClientCCSessionImpl<CreditControlRequest, CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements S15ClientSession
{
	public S15ClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientCCListener<CreditControlRequest, CreditControlAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?, ?> provider)
	{
		super(sessionID,remoteHost, remoteRealm, provider);
	}
}