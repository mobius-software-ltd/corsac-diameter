package com.mobius.software.telco.protocols.diameter.app.gx;
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
import com.mobius.software.telco.protocols.diameter.app.ServerCCListener;
import com.mobius.software.telco.protocols.diameter.commands.gx.AbortSessionAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gx.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.gx.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gx.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.commands.gx.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gx.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.gx.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gx.SessionTerminationRequest;
/**
*
* @author yulian oifa
*
*/
public interface ServerListener extends ServerCCListener<CreditControlRequest, CreditControlAnswer, ReAuthRequest, ReAuthAnswer, AbortSessionRequest, AbortSessionAnswer, SessionTerminationRequest, SessionTerminationAnswer>
{
}
