package com.mobius.software.telco.protocols.diameter.impl.app.rf;
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
import com.mobius.software.telco.protocols.diameter.app.ServerAccListener;
import com.mobius.software.telco.protocols.diameter.app.rf.RfServerSession;
import com.mobius.software.telco.protocols.diameter.commands.rf.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rf.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerAccSessionImpl;
/**
*
* @author yulian oifa
*
*/
public class RfServerSessionImpl extends ServerAccSessionImpl<AccountingRequest, AccountingAnswer> implements RfServerSession
{
	public RfServerSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerAccListener<AccountingRequest>, ?, ?, ?> provider)
	{
		super(sessionID, remoteHost, remoteRealm, provider);
	}
}