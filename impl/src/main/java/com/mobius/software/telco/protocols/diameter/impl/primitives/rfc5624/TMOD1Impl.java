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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
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

@DiameterAvpImplementation(code = 495L, vendorId = -1L)
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
	
	public TMOD1Impl(Float tokenRate,Float bucketDepth,Float peakTrafficRate,Long minimumPolicedUnit,Long maximumPacketSize)
	{
		if(tokenRate==null)
			throw new IllegalArgumentException("Token-Rate is required");
		
		if(bucketDepth==null)
			throw new IllegalArgumentException("Bucket-Depth is required");
		
		if(peakTrafficRate==null)
			throw new IllegalArgumentException("Peak-Traffic-Rate is required");
		
		if(minimumPolicedUnit==null)
			throw new IllegalArgumentException("Minimum-Policed-Unit is required");
		
		if(maximumPacketSize==null)
			throw new IllegalArgumentException("Maximum-Packet-Size is required");
		
		this.tokenRate = new TokenRateImpl(tokenRate, null, null);
		
		this.bucketDepth = new BucketDepthImpl(bucketDepth, null, null);
		
		this.peakTrafficRate = new PeakTrafficRateImpl(peakTrafficRate, null, null);
		
		this.minimumPolicedUnit = new MinimumPolicedUnitImpl(minimumPolicedUnit, null, null);
		
		this.maximumPacketSize = new MaximumPacketSizeImpl(maximumPacketSize, null, null);
	}
	
	public Float getTokenRate()
	{
		if(tokenRate==null)
			return null;
		
		return tokenRate.getFloat();
	}
	
	public void setTokenRate(Float value)
	{
		if(value==null)
			throw new IllegalArgumentException("Token-Rate is required");
		
		this.tokenRate = new TokenRateImpl(value, null, null);
	}
	
	public Float getBucketDepth()
	{
		if(bucketDepth==null)
			return null;
		
		return bucketDepth.getFloat();
	}
	
	public void setBucketDepth(Float value)
	{
		if(value==null)
			throw new IllegalArgumentException("Bucket-Depth is required");
		
		this.bucketDepth = new BucketDepthImpl(value, null, null);
	}
	
	public Float getPeakTrafficRate()
	{
		if(peakTrafficRate==null)
			return null;
		
		return peakTrafficRate.getFloat();
	}
	
	public void setPeakTrafficRate(Float value)
	{
		if(value==null)
			throw new IllegalArgumentException("Peak-Traffic-Rate is required");
		
		this.peakTrafficRate = new PeakTrafficRateImpl(value, null, null);
	}
	
	public Long getMinimumPolicedUnit()
	{
		if(minimumPolicedUnit==null)
			return null;
		
		return minimumPolicedUnit.getUnsigned();
	}
	
	public void setMinimumPolicedUnit(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Minimum-Policed-Unit is required");
		
		this.minimumPolicedUnit = new MinimumPolicedUnitImpl(value, null, null);
	}
	
	public Long getMaximumPacketSize()
	{
		if(maximumPacketSize==null)
			return null;
		
		return maximumPacketSize.getUnsigned();
	}
	
	public void setMaximumPacketSize(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Maximum-Packet-Size is required");
		
		this.maximumPacketSize = new MaximumPacketSizeImpl(value, null, null);
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(tokenRate==null)
			return "Token-Rate is required";
		
		if(bucketDepth==null)
			return "Bucket-Depth is required";
		
		if(peakTrafficRate==null)
			return "Peak-Traffic-Rate is required";
		
		if(minimumPolicedUnit==null)
			return "Minimum-Policed-Unit is required";
		
		if(maximumPacketSize==null)
			return "Maximum-Packet-Size is required";
		
		return null;
	}
}