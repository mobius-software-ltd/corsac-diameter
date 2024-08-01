package com.mobius.software.telco.protocols.diameter.app.rfc5778a;
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

import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.commands.rfc5778a.MIP6Request;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public interface SessionFactory
{
	public Rfc5778aClientSession createClientSession(AccountingRequest request) throws AvpNotSupportedException;	
	
	public Rfc5778aServerSession createServerSession(AccountingRequest request) throws AvpNotSupportedException;	
	
	public Rfc5778aClientSession createClientSession(MIP6Request request) throws AvpNotSupportedException;	
	
	public Rfc5778aServerSession createServerSession(MIP6Request request) throws AvpNotSupportedException;
}