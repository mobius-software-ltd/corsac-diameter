package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.Negated;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.NegatedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TCPFlagType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TCPFlags;

/**
*
* @author yulian oifa
*
*/

public class TCPFlagsImpl extends DiameterGroupedAvpImpl implements TCPFlags
{
	private TCPFlagType tcpFlagType;
	
	private Negated negated;
	
	protected TCPFlagsImpl() 
	{
	}
	
	public TCPFlagsImpl(Long tcpFlagType) throws MissingAvpException
	{
		setTCPFlagType(tcpFlagType);
	}
	
	public Long getTCPFlagType()
	{
		if(this.tcpFlagType==null)
			return null;
		
		return this.tcpFlagType.getUnsigned();
	}
	
	public void setTCPFlagType(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("TCP-Flag-Type is required is required", Arrays.asList(new DiameterAvp[] { new TCPFlagTypeImpl() }));
		
		this.tcpFlagType = new TCPFlagTypeImpl(value, null, null);	
	}
	
	public NegatedEnum getNegated()
	{
		if(negated==null)
			return null;
		
		return this.negated.getEnumerated(NegatedEnum.class);
	}
	
	public void setNegated(NegatedEnum value)
	{
		if(value==null)
			this.negated = null;
		else
			this.negated = new NegatedImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(tcpFlagType==null)
			return new MissingAvpException("TCP-Flag-Type is required is required", Arrays.asList(new DiameterAvp[] { new TCPFlagTypeImpl() }));
		
		return null;
	}
}