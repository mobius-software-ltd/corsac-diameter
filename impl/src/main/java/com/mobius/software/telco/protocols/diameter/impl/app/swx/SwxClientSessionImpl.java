package com.mobius.software.telco.protocols.diameter.impl.app.swx;
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
import com.mobius.software.telco.protocols.diameter.app.swx.SwxClientSession;
import com.mobius.software.telco.protocols.diameter.commands.swx.SwxAnswer;
import com.mobius.software.telco.protocols.diameter.commands.swx.SwxRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionStatelessImpl;
/**
*
* @author yulian oifa
*
*/
public class SwxClientSessionImpl extends ClientAuthSessionStatelessImpl<SwxRequest, SwxAnswer> implements SwxClientSession
{
	public SwxClientSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.SWX));
	}
	
	public SwxClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthStatelessListener<SwxRequest>, ?, ?, ?, ?> provider)
	{
		super(sessionID, Long.valueOf(ApplicationIDs.SWX), remoteHost, remoteRealm, provider);
	}
}