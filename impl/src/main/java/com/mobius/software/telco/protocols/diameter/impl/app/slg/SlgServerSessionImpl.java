package com.mobius.software.telco.protocols.diameter.impl.app.slg;
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
import com.mobius.software.telco.protocols.diameter.app.ServerAuthStatelessListener;
import com.mobius.software.telco.protocols.diameter.app.slg.SlgServerSession;
import com.mobius.software.telco.protocols.diameter.commands.slg.SlgAnswer;
import com.mobius.software.telco.protocols.diameter.commands.slg.SlgRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAuthSessionStatelessImpl;
/**
*
* @author yulian oifa
*
*/
public class SlgServerSessionImpl extends ServerAuthSessionStatelessImpl<SlgRequest, SlgAnswer> implements SlgServerSession
{
	public SlgServerSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.SLG));
	}
	
	public SlgServerSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerAuthStatelessListener<SlgRequest, SlgAnswer>, ?, ?, ?> provider)
	{
		super(sessionID, Long.valueOf(ApplicationIDs.SLG), remoteHost, remoteRealm, provider);
	}
}