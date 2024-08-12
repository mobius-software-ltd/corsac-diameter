package com.mobius.software.telco.protocols.diameter.impl.app.pc2;
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
import com.mobius.software.telco.protocols.diameter.app.ClientAuthStatelessListener;
import com.mobius.software.telco.protocols.diameter.app.pc2.PC2ClientSession;
import com.mobius.software.telco.protocols.diameter.commands.pc2.Pc2Answer;
import com.mobius.software.telco.protocols.diameter.commands.pc2.Pc2Request;
import com.mobius.software.telco.protocols.diameter.impl.app.ClientAuthSessionStatelessImpl;

public class PC2ClientSessionImpl extends ClientAuthSessionStatelessImpl<Pc2Request,Pc2Answer> implements PC2ClientSession
{
	public PC2ClientSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.PC2));
	}
	
	public PC2ClientSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<? extends ClientAuthStatelessListener<Pc2Request,Pc2Answer>, ?, ?, ?, ?> provider)
	{
		super(sessionID, Long.valueOf(ApplicationIDs.PC2), remoteHost, remoteRealm, provider);
	}
	
	
}