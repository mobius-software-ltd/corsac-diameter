package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ApplicationDetectionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFApplicationIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFApplicationInstanceIdentifier;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class ApplicationDetectionInformationImpl extends DiameterGroupedAvpImpl implements ApplicationDetectionInformation
{
	private TDFApplicationIdentifier tdfApplicationIdentifier;
	private TDFApplicationInstanceIdentifier tdfApplicationInstanceIdentifier;
	private List<FlowInformation> flowInformation;
		
	protected ApplicationDetectionInformationImpl()
	{
		
	}
	
	public ApplicationDetectionInformationImpl(ByteBuf tdfApplicationIdentifier) throws MissingAvpException
	{
		setTDFApplicationIdentifier(tdfApplicationIdentifier);
	}
	
	public ByteBuf getTDFApplicationIdentifier()
	{
		if(tdfApplicationIdentifier==null)
			return null;
		
		return tdfApplicationIdentifier.getValue();
	}
	
	public void setTDFApplicationIdentifier(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("TDF-Application-Identifier is required", Arrays.asList(new DiameterAvp[] { new TDFApplicationIdentifierImpl() }));
			
		this.tdfApplicationIdentifier = new TDFApplicationIdentifierImpl(value, null, null);				
	}
	
	public ByteBuf getTDFApplicationInstanceIdentifier()
	{
		if(tdfApplicationInstanceIdentifier==null)
			return null;
		
		return tdfApplicationInstanceIdentifier.getValue();
	}
	
	public void setTDFApplicationInstanceIdentifier(ByteBuf value)
	{
		if(value==null)
			this.tdfApplicationInstanceIdentifier = null;
		else
			this.tdfApplicationInstanceIdentifier = new TDFApplicationInstanceIdentifierImpl(value, null, null);			
	}
	
	public List<FlowInformation> getFlowInformation()
	{
		return flowInformation;
	}
	
	public void setFlowInformation(List<FlowInformation> value)
	{
		this.flowInformation = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(tdfApplicationIdentifier==null)
			return new MissingAvpException("TDF-Application-Identifier is required", Arrays.asList(new DiameterAvp[] { new TDFApplicationIdentifierImpl() }));
		
		return null;
	}
}