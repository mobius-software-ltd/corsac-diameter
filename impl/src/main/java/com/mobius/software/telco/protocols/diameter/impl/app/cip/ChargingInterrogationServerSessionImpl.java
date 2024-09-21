package com.mobius.software.telco.protocols.diameter.impl.app.cip;
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
import com.mobius.software.telco.protocols.diameter.app.ServerCCListener;
import com.mobius.software.telco.protocols.diameter.app.cip.ChargingInterrogationServerSession;
import com.mobius.software.telco.protocols.diameter.commands.cip.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.cip.ChargingInterrogationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.ChargingInterrogationRequest;
import com.mobius.software.telco.protocols.diameter.commands.cip.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.cip.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.cip.SessionTerminationRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.ServerCCSessionImpl;

public class ChargingInterrogationServerSessionImpl extends ServerCCSessionImpl<ChargingInterrogationRequest, ChargingInterrogationAnswer,ReAuthRequest,ReAuthAnswer,AbortSessionRequest,AbortSessionAnswer,SessionTerminationRequest,SessionTerminationAnswer> implements ChargingInterrogationServerSession
{
	public ChargingInterrogationServerSessionImpl()
	{
		super(Long.valueOf(ApplicationIDs.CIP));
	}
	
	public ChargingInterrogationServerSessionImpl(String sessionID, String remoteHost, String remoteRealm, DiameterProvider<?, ? extends ServerCCListener<ChargingInterrogationRequest,ChargingInterrogationAnswer, ReAuthRequest,ReAuthAnswer,AbortSessionRequest, AbortSessionAnswer,SessionTerminationRequest, SessionTerminationAnswer>, ?, ?, ?> provider)
	{
		super(sessionID, Long.valueOf(ApplicationIDs.CIP), remoteHost, remoteRealm, provider);
	}
}