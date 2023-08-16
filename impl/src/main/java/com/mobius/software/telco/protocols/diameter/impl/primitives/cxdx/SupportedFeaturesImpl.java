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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.FeatureList;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.FeatureListID;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 628L, vendorId = KnownVendorIDs.TGPP_ID)
public class SupportedFeaturesImpl extends DiameterGroupedAvpImpl implements SupportedFeatures
{
	private VendorId vendorId;
	
	private FeatureListID featureListID;
	
	private FeatureList featureList;
	
	protected SupportedFeaturesImpl() 
	{
		super();
	}
	
	public SupportedFeaturesImpl(Long vendorId, Long featureListID, Long featureList)
	{
		if(vendorId == null)
			throw new IllegalArgumentException("Vendor-Id is required");
		
		if(featureListID == null)
			throw new IllegalArgumentException("Feature-List-ID is required");
		
		if(featureList == null)
			throw new IllegalArgumentException("Feature-List is required");
		
		this.vendorId = new VendorIdImpl(vendorId, null, null);
		
		this.featureListID = new FeatureListIDImpl(featureListID, null, null);
		
		this.featureList = new FeatureListImpl(featureList, null, null);		
	}
	
	public Long getVendorId()
	{
		if(vendorId==null)
			return null;
		
		return vendorId.getUnsigned();
	}
	
	public void setVendorId(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("Vendor-Id is required");	
		
		this.vendorId = new VendorIdImpl(value, null, null);
	}
	
	public Long getFeatureListID()
	{
		if(featureListID==null)
			return null;
		
		return featureListID.getUnsigned();
	}
	
	public void setFeatureListID(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("Feature-List-ID is required");
		
		this.featureListID = new FeatureListIDImpl(value, null, null);
	}
	
	public Long getFeatureList()
	{
		if(featureList==null)
			return null;
		
		return featureList.getUnsigned();
	}
	
	public void setFeatureList(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("Feature-List is required");
		
		this.featureList = new FeatureListImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(vendorId == null)
			return "Vendor-Id is required";
		
		if(featureListID == null)
			return "Feature-List-ID is required";
		
		if(featureList == null)
			return "Feature-List is required";
		
		return null;
	}
}