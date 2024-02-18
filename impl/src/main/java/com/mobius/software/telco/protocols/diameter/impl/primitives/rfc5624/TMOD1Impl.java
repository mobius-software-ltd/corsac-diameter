package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5624;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5624.BucketDepth;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5624.MaximumPacketSize;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5624.MinimumPolicedUnit;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5624.PeakTrafficRate;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5624.TMOD1;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5624.TokenRate;

/**
*
* @author yulian oifa
*
*/

public class TMOD1Impl implements TMOD1
{
	private TokenRate tokenRate;
	private BucketDepth bucketDepth;
	private PeakTrafficRate peakTrafficRate;
	private MinimumPolicedUnit minimumPolicedUnit;
	private MaximumPacketSize maximumPacketSize;
	
	protected TMOD1Impl() 
	{
	}
	
	public TMOD1Impl(Float tokenRate,Float bucketDepth,Float peakTrafficRate,Long minimumPolicedUnit,Long maximumPacketSize) throws MissingAvpException
	{
		setTokenRate(tokenRate);
		
		setBucketDepth(bucketDepth);
		
		setPeakTrafficRate(peakTrafficRate);
		
		setMinimumPolicedUnit(minimumPolicedUnit);
		
		setMaximumPacketSize(maximumPacketSize);
	}
	
	public Float getTokenRate()
	{
		if(tokenRate==null)
			return null;
		
		return tokenRate.getFloat();
	}
	
	public void setTokenRate(Float value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Token-Rate is required is required", Arrays.asList(new DiameterAvp[] { new TokenRateImpl() }));
		
		this.tokenRate = new TokenRateImpl(value, null, null);
	}
	
	public Float getBucketDepth()
	{
		if(bucketDepth==null)
			return null;
		
		return bucketDepth.getFloat();
	}
	
	public void setBucketDepth(Float value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Bucket-Depth is required is required", Arrays.asList(new DiameterAvp[] { new BucketDepthImpl() }));
		
		this.bucketDepth = new BucketDepthImpl(value, null, null);
	}
	
	public Float getPeakTrafficRate()
	{
		if(peakTrafficRate==null)
			return null;
		
		return peakTrafficRate.getFloat();
	}
	
	public void setPeakTrafficRate(Float value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Peak-Traffic-Rate is required is required", Arrays.asList(new DiameterAvp[] { new PeakTrafficRateImpl() }));
			
		this.peakTrafficRate = new PeakTrafficRateImpl(value, null, null);
	}
	
	public Long getMinimumPolicedUnit()
	{
		if(minimumPolicedUnit==null)
			return null;
		
		return minimumPolicedUnit.getUnsigned();
	}
	
	public void setMinimumPolicedUnit(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Minimum-Policed-Unit is required is required", Arrays.asList(new DiameterAvp[] { new MinimumPolicedUnitImpl() }));
		
		this.minimumPolicedUnit = new MinimumPolicedUnitImpl(value, null, null);
	}
	
	public Long getMaximumPacketSize()
	{
		if(maximumPacketSize==null)
			return null;
		
		return maximumPacketSize.getUnsigned();
	}
	
	public void setMaximumPacketSize(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Maximum-Packet-Size is required is required", Arrays.asList(new DiameterAvp[] { new MaximumPacketSizeImpl() }));
		
		this.maximumPacketSize = new MaximumPacketSizeImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(tokenRate==null)
			return new MissingAvpException("Token-Rate is required is required", Arrays.asList(new DiameterAvp[] { new TokenRateImpl() }));
		
		if(bucketDepth==null)
			return new MissingAvpException("Bucket-Depth is required is required", Arrays.asList(new DiameterAvp[] { new BucketDepthImpl() }));
		
		if(peakTrafficRate==null)
			return new MissingAvpException("Peak-Traffic-Rate is required is required", Arrays.asList(new DiameterAvp[] { new PeakTrafficRateImpl() }));
		
		if(minimumPolicedUnit==null)
			return new MissingAvpException("Minimum-Policed-Unit is required is required", Arrays.asList(new DiameterAvp[] { new MinimumPolicedUnitImpl() }));
		
		if(maximumPacketSize==null)
			return new MissingAvpException("Maximum-Packet-Size is required is required", Arrays.asList(new DiameterAvp[] { new MaximumPacketSizeImpl() }));
		
		return null;
	}
}