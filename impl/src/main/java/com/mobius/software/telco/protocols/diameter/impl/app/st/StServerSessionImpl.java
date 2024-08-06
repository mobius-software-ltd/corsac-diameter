package com.mobius.software.telco.protocols.diameter.impl.app.st;
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
import com.mobius.software.telco.protocols.diameter.app.ServerAuthListener;
import com.mobius.software.telco.protocols.diameter.app.st.StServerSession;
import com.mobius.software.telco.protocols.diameter.commands.st.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.st.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.st.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.st.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.st.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.st.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.commands.st.StAnswer;
import com.mobius.software.telco.protocols.diameter.commands.st.StRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAuthSessionImpl;

public class StServerSessionImpl extends ServerAuthSessionImpl<StRequest, StAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements StServerSession
{
	public StServerSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.ST));
	}
	
	public StServerSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerAuthListener<StRequest, StAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer>, ?, ?, ?> provider)
	{
		super(sessionID, Long.valueOf(ApplicationIDs.ST), remoteHost, remoteRealm, provider);
	}
}