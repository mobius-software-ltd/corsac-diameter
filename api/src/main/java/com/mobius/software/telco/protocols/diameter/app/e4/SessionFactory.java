package com.mobius.software.telco.protocols.diameter.app.e4;
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


import com.mobius.software.telco.protocols.diameter.commands.e4.PushNotificationRequest;
import com.mobius.software.telco.protocols.diameter.commands.e4.UserDataRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;

public interface SessionFactory
{
	public E4ClientSession createClientSession(PushNotificationRequest request) throws DiameterException;

	public E4ServerSession createServerSession(PushNotificationRequest request) throws DiameterException;
	
	public E4ClientSession createClientSession(UserDataRequest request) throws DiameterException;

	public E4ServerSession createServerSession(UserDataRequest request) throws DiameterException;
}
