package com.mobius.software.telco.protocols.diameter.app.rx;

import com.mobius.software.telco.protocols.diameter.app.ServerAuthListener;
import com.mobius.software.telco.protocols.diameter.commands.rx.AAAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rx.AARequest;
import com.mobius.software.telco.protocols.diameter.commands.rx.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rx.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rx.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rx.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rx.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rx.SessionTerminationRequest;
/*
 * Mobius Software LTD, Open Source Cloud Communications
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
/**
*
* @author yulian oifa
*
*/
public interface ServerListener extends ServerAuthListener<AARequest, AAAnswer, ReAuthRequest, ReAuthAnswer, AbortSessionRequest, AbortSessionAnswer, SessionTerminationRequest, SessionTerminationAnswer>
{
}