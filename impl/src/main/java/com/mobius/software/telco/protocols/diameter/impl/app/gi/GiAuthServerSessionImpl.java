package com.mobius.software.telco.protocols.diameter.impl.app.gi;
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
import com.mobius.software.telco.protocols.diameter.app.gi.GiAuthServerSession;
import com.mobius.software.telco.protocols.diameter.commands.gi.AAAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gi.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gi.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAuthSessionImpl;
/**
*
* @author yulian oifa
*
*/
public class GiAuthServerSessionImpl extends ServerAuthSessionImpl<AARequest, AAAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements GiAuthServerSession
{
	public GiAuthServerSessionImpl(String sessionID, DiameterProvider<?, ? extends ServerAuthListener<AARequest,ReAuthAnswer,AbortSessionAnswer,SessionTerminationRequest>, ?, ?, ?> provider)
	{
		super(sessionID, provider);
	}
}