package com.mobius.software.telco.protocols.diameter.impl.primitives.sh;
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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.sh.RepositoryDataID;
import com.mobius.software.telco.protocols.diameter.primitives.sh.SequenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.sh.ServiceIndication;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class RepositoryDataIDImpl extends DiameterGroupedAvpImpl implements RepositoryDataID
{
	private ServiceIndication serviceIndication;
	
	private SequenceNumber sequenceNumber;
	
	protected RepositoryDataIDImpl() 
	{
		super();
	}
	
	public RepositoryDataIDImpl(ByteBuf serviceIndication, Long sequenceNumber) throws MissingAvpException
	{
		setServiceIndication(serviceIndication);
		
		setSequenceNumber(sequenceNumber);
	}
	
	public ByteBuf getServiceIndication()
	{
		if(serviceIndication==null)
			return null;
		
		return serviceIndication.getValue();
	}
	
	public void setServiceIndication(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Service-Indication is required is required", Arrays.asList(new DiameterAvp[] { new ServiceIndicationImpl() }));
			
		this.serviceIndication = new ServiceIndicationImpl(value, null, null);		
	}
	
	public Long getSequenceNumber()
	{
		if(sequenceNumber==null)
			return null;
		
		return sequenceNumber.getUnsigned();
	}
	
	public void setSequenceNumber(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Sequence-Number is required is required", Arrays.asList(new DiameterAvp[] { new SequenceNumberImpl() }));
		
		this.sequenceNumber = new SequenceNumberImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(serviceIndication == null)
			return new MissingAvpException("Service-Indication is required is required", Arrays.asList(new DiameterAvp[] { new ServiceIndicationImpl() }));
		
		if(sequenceNumber == null)
			return new MissingAvpException("Sequence-Number is required is required", Arrays.asList(new DiameterAvp[] { new SequenceNumberImpl() }));
		
		return null;
	}
}