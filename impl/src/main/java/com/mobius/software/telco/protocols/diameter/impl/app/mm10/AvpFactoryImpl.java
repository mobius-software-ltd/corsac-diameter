package com.mobius.software.telco.protocols.diameter.impl.app.mm10;
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

import com.mobius.software.telco.protocols.diameter.app.mm10.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.InitialRecipientAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.ResultRecipientAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.ServedUserIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.StatusImpl;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.InitialRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ResultRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ServedUserIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.Status;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public InitialRecipientAddress getInitialRecipientAddress(Long sequenceNumber,String recipientAddress) throws MissingAvpException
	{
		return new InitialRecipientAddressImpl(sequenceNumber, recipientAddress);
	}
	
	public ServedUserIdentity getServedUserIdentity()
	{
		return new ServedUserIdentityImpl();
	}
	
	public ResultRecipientAddress getResultRecipientAddress(Long sequenceNumber,String recipientAddress) throws MissingAvpException
	{
		return new ResultRecipientAddressImpl(sequenceNumber, recipientAddress);
	}
	
	public Status getStatus()
	{
		return new StatusImpl();
	}
}
