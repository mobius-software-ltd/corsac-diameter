package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAuthInputDataLength;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAuthenticatorLength;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAuthenticatorOffset;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNAAAAuth;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNAAASPI;

/**
*
* @author yulian oifa
*
*/
public class MIPMNAAAAuthImpl extends DiameterGroupedAvpImpl implements MIPMNAAAAuth
{
	private MIPMNAAASPI mipMNAAASPI;
	
	private MIPAuthInputDataLength mipAuthInputDataLength;
	
	private MIPAuthenticatorLength mipAuthenticatorLength;
	
	private MIPAuthenticatorOffset mipAuthenticatorOffset;
	
	protected MIPMNAAAAuthImpl()
	{
		
	}
	
	public MIPMNAAAAuthImpl(Long mipMNAAASPI,Long mipAuthInputDataLength,Long mipAuthenticatorLength,Long mipAuthenticatorOffset) throws MissingAvpException
	{
		setMIPMNAAASPI(mipMNAAASPI);
		
		setMIPAuthInputDataLength(mipAuthInputDataLength);
		
		setMIPAuthenticatorLength(mipAuthenticatorLength);
		
		setMIPAuthenticatorOffset(mipAuthenticatorOffset);
	}
	
	public Long getMIPMNAAASPI()
	{
		if(mipMNAAASPI == null)
			return null;
		
		return mipMNAAASPI.getUnsigned();
	}
	
	public void setMIPMNAAASPI(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIP-MN-AAA-SPI is required", Arrays.asList(new DiameterAvp[] { new MIPMNAAASPIImpl() }));
		
		this.mipMNAAASPI = new MIPMNAAASPIImpl(value, null, null);		
	}
	
	public Long getMIPAuthInputDataLength()
	{
		if(mipAuthInputDataLength == null)
			return null;
		
		return mipAuthInputDataLength.getUnsigned();
	}
	
	public void setMIPAuthInputDataLength(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIP-Auth-Input-Data-Length is required", Arrays.asList(new DiameterAvp[] { new MIPAuthInputDataLengthImpl() }));
			
		this.mipAuthInputDataLength = new MIPAuthInputDataLengthImpl(value, null, null);		
	}
	
	public Long getMIPAuthenticatorLength()
	{
		if(mipAuthenticatorLength == null)
			return null;
		
		return mipAuthenticatorLength.getUnsigned();
	}
	
	public void setMIPAuthenticatorLength(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIP-Authenticator-Length is required", Arrays.asList(new DiameterAvp[] { new MIPAuthenticatorLengthImpl() }));
			
		this.mipAuthenticatorLength = new MIPAuthenticatorLengthImpl(value, null, null);		
	}
	
	public Long getMIPAuthenticatorOffset()
	{
		if(mipAuthenticatorOffset == null)
			return null;
		
		return mipAuthenticatorOffset.getUnsigned();
	}
	
	public void setMIPAuthenticatorOffset(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("MIP-Authenticator-Offset is required", Arrays.asList(new DiameterAvp[] { new MIPAuthenticatorOffsetImpl() }));
			
		this.mipAuthenticatorOffset = new MIPAuthenticatorOffsetImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(mipMNAAASPI==null)
			return new MissingAvpException("MIP-MN-AAA-SPI is required", Arrays.asList(new DiameterAvp[] { new MIPMNAAASPIImpl() }));
		
		if(mipAuthInputDataLength==null)
			return new MissingAvpException("MIP-Auth-Input-Data-Length is required", Arrays.asList(new DiameterAvp[] { new MIPAuthInputDataLengthImpl() }));
		
		if(mipAuthenticatorLength==null)
			return new MissingAvpException("MIP-Authenticator-Length is required", Arrays.asList(new DiameterAvp[] { new MIPAuthenticatorLengthImpl() }));
		
		if(mipAuthenticatorOffset==null)
			return new MissingAvpException("MIP-Authenticator-Offset is required", Arrays.asList(new DiameterAvp[] { new MIPAuthenticatorOffsetImpl() }));
		
		return null;
	}
}