package com.mobius.software.telco.protocols.diameter.impl.app.mb2c;
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
import com.mobius.software.telco.protocols.diameter.app.ServerAuthStatelessListener;
import com.mobius.software.telco.protocols.diameter.app.mb2c.Mb2cServerSession;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.MB2CAnswer;
import com.mobius.software.telco.protocols.diameter.commands.mb2c.MB2CRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAuthSessionStatelessImpl;

public class Mb2cServerSessionImpl extends ServerAuthSessionStatelessImpl<MB2CRequest, MB2CAnswer> implements Mb2cServerSession
{
	public Mb2cServerSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.MB2C));
	}
	
	public Mb2cServerSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerAuthStatelessListener<MB2CAnswer>, ?, ?, ?> provider)
	{
		super(sessionID, Long.valueOf(ApplicationIDs.MB2C), remoteHost, remoteRealm, provider);
	}
}