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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
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
@DiameterAvpImplementation(code = 322L, vendorId = -1L)
public class MIPMNAAAAuthImpl extends DiameterGroupedAvpImpl implements MIPMNAAAAuth
{
	private MIPMNAAASPI mipMNAAASPI;
	
	private MIPAuthInputDataLength mipAuthInputDataLength;
	
	private MIPAuthenticatorLength mipAuthenticatorLength;
	
	private MIPAuthenticatorOffset mipAuthenticatorOffset;
	
	protected MIPMNAAAAuthImpl()
	{
		
	}
	
	public MIPMNAAAAuthImpl(Long mipMNAAASPI,Long mipAuthInputDataLength,Long mipAuthenticatorLength,Long mipAuthenticatorOffset)
	{
		if(mipMNAAASPI==null)
			throw new IllegalArgumentException("MIP-MN-AAA-SPI is required");
		
		if(mipAuthInputDataLength==null)
			throw new IllegalArgumentException("MIP-Auth-Input-Data-Length");
		
		if(mipAuthenticatorLength==null)
			throw new IllegalArgumentException("MIP-Authenticator-Length");
		
		if(mipAuthenticatorOffset==null)
			throw new IllegalArgumentException("MIP-Authenticator-Offset");
		
		this.mipMNAAASPI = new MIPMNAAASPIImpl(mipMNAAASPI, null, null);		

		this.mipAuthInputDataLength = new MIPAuthInputDataLengthImpl(mipAuthInputDataLength, null, null);
		
		this.mipAuthenticatorLength = new MIPAuthenticatorLengthImpl(mipAuthenticatorLength, null, null);
		
		this.mipAuthenticatorOffset = new MIPAuthenticatorOffsetImpl(mipAuthenticatorOffset, null, null);
	}
	
	public Long getMIPMNAAASPI()
	{
		if(mipMNAAASPI == null)
			return null;
		
		return mipMNAAASPI.getUnsigned();
	}
	
	public void setMIPMNAAASPI(Long value)
	{
		if(mipMNAAASPI==null)
			throw new IllegalArgumentException("MIP-MN-AAA-SPI is required");
		
		this.mipMNAAASPI = new MIPMNAAASPIImpl(value, null, null);		
	}
	
	public Long getMIPAuthInputDataLength()
	{
		if(mipAuthInputDataLength == null)
			return null;
		
		return mipAuthInputDataLength.getUnsigned();
	}
	
	public void setMIPAuthInputDataLength(Long value)
	{
		if(mipAuthInputDataLength==null)
			throw new IllegalArgumentException("MIP-Auth-Input-Data-Length");
		
		this.mipAuthInputDataLength = new MIPAuthInputDataLengthImpl(value, null, null);		
	}
	
	public Long getMIPAuthenticatorLength()
	{
		if(mipAuthenticatorLength == null)
			return null;
		
		return mipAuthenticatorLength.getUnsigned();
	}
	
	public void setMIPAuthenticatorLength(Long value)
	{
		if(mipAuthenticatorLength==null)
			throw new IllegalArgumentException("MIP-Authenticator-Length");
		
		this.mipAuthenticatorLength = new MIPAuthenticatorLengthImpl(value, null, null);		
	}
	
	public Long getMIPAuthenticatorOffset()
	{
		if(mipAuthenticatorOffset == null)
			return null;
		
		return mipAuthenticatorOffset.getUnsigned();
	}
	
	public void setMIPAuthenticatorOffset(Long value)
	{
		if(mipAuthenticatorOffset==null)
			throw new IllegalArgumentException("MIP-Authenticator-Offset");
		
		this.mipAuthenticatorOffset = new MIPAuthenticatorOffsetImpl(value, null, null);
	}
}