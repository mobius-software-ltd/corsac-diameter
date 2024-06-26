package com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.FeatureList;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.FeatureListID;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;

/**
*
* @author yulian oifa
*
*/
public class SupportedFeaturesImpl extends DiameterGroupedAvpImpl implements SupportedFeatures
{
	private VendorId vendorId;
	
	private FeatureListID featureListID;
	
	private FeatureList featureList;
	
	public SupportedFeaturesImpl() 
	{
		super();
	}
	
	public SupportedFeaturesImpl(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		setVendorId(vendorId);
		
		setFeatureListID(featureListID);
		
		setFeatureList(featureList);
	}
	
	public Long getVendorId()
	{
		if(vendorId==null)
			return null;
		
		return vendorId.getUnsigned();
	}
	
	public void setVendorId(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Vendor-Id is required is required", Arrays.asList(new DiameterAvp[] { new VendorIdImpl() }));
		
		this.vendorId = new VendorIdImpl(value, null, null);
	}
	
	public Long getFeatureListID()
	{
		if(featureListID==null)
			return null;
		
		return featureListID.getUnsigned();
	}
	
	public void setFeatureListID(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Feature-List-ID is required is required", Arrays.asList(new DiameterAvp[] { new FeatureListIDImpl() }));
		
		this.featureListID = new FeatureListIDImpl(value, null, null);
	}
	
	public Long getFeatureList()
	{
		if(featureList==null)
			return null;
		
		return featureList.getUnsigned();
	}
	
	public void setFeatureList(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Feature-List is required is required", Arrays.asList(new DiameterAvp[] { new FeatureListImpl() }));
		
		this.featureList = new FeatureListImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(vendorId == null)
			return new MissingAvpException("Vendor-Id is required is required", Arrays.asList(new DiameterAvp[] { new VendorIdImpl() }));
		
		if(featureListID == null)
			return new MissingAvpException("Feature-List-ID is required is required", Arrays.asList(new DiameterAvp[] { new FeatureListIDImpl() }));
		
		if(featureList == null)
			return new MissingAvpException("Feature-List is required is required", Arrays.asList(new DiameterAvp[] { new FeatureListImpl() }));
		
		return null;
	}
}