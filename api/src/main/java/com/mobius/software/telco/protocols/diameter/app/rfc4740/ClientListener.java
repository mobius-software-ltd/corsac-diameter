package com.mobius.software.telco.protocols.diameter.app.rfc4740;

import com.mobius.software.telco.protocols.diameter.app.ClientAuthListener;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.AbortSessionRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.LocationInfoAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.MultimediaAuthAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.PushProfileAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.RegistrationTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.ServerAssignmentAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.rfc4740.UserAuthorizationAnswer;
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
public interface ClientListener extends ClientAuthListener<LocationInfoAnswer, ReAuthRequest, AbortSessionRequest, SessionTerminationAnswer>
{
	void onInitialAnswer(MultimediaAuthAnswer answer);
	
	void onInitialAnswer(PushProfileAnswer answer);
	
	void onInitialAnswer(RegistrationTerminationAnswer answer);
	
	void onInitialAnswer(ServerAssignmentAnswer answer);
	
	void onInitialAnswer(UserAuthorizationAnswer answer);	
}
