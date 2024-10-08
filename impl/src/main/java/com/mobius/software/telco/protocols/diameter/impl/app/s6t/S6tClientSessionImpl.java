package com.mobius.software.telco.protocols.diameter.impl.app.s6t;
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
import com.mobius.software.telco.protocols.diameter.app.ClientAuthStatelessListener;
import com.mobius.software.telco.protocols.diameter.app.s6t.S6tClientSession;
import com.mobius.software.telco.protocols.diameter.commands.s6t.S6tAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s6t.S6tRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionStatelessImpl;
/**
*
* @author yulian oifa
*
*/
public class S6tClientSessionImpl extends ClientAuthSessionStatelessImpl<S6tRequest, S6tAnswer> implements S6tClientSession
{
	public S6tClientSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.S6T));
	}
	
	public S6tClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthStatelessListener<S6tRequest, S6tAnswer>, ?, ?, ?, ?> provider)
	{
		super(sessionID, Long.valueOf(ApplicationIDs.S6T), remoteHost, remoteRealm, provider);
	}
}