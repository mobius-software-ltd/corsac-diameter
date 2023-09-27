package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfigurationProfile;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AdditionalContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AllAPNConfigurationsIncludedIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AllAPNConfigurationsIncludedIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ThirdContextIdentifier;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1429L, vendorId = KnownVendorIDs.TGPP_ID)
public class APNConfigurationProfileImpl extends DiameterGroupedAvpImpl implements APNConfigurationProfile
{
	private ContextIdentifier contextIdentifier;
	
	private AdditionalContextIdentifier additionalContextIdentifier;
	
	private ThirdContextIdentifier thirdContextIdentifier;
	
	private AllAPNConfigurationsIncludedIndicator allAPNConfigurationsIncludedIndicator;
	
	private List<APNConfiguration> apnConfiguration;
	
	protected APNConfigurationProfileImpl() 
	{
	}
	
	public APNConfigurationProfileImpl(Long contextIdentifier,List<APNConfiguration> apnConfiguration)
	{
		if(contextIdentifier==null)
			throw new IllegalArgumentException("Context-Identifier is required");
		
		if(apnConfiguration==null || apnConfiguration.size()==0)
			throw new IllegalArgumentException("APN-Configuration is required");
		
		this.contextIdentifier = new ContextIdentifierImpl(contextIdentifier, null, null);
		
		this.apnConfiguration = apnConfiguration;
	}
	
	public Long getContextIdentifier()
	{
		if(contextIdentifier==null)
			return null;
		
		return contextIdentifier.getUnsigned();
	}
	
	public void setContextIdentifier(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Context-Identifier is required");
		
		this.contextIdentifier = new ContextIdentifierImpl(value, null, null);	
	}
	
	public Long getAdditionalContextIdentifier()
	{
		if(additionalContextIdentifier==null)
			return null;
		
		return additionalContextIdentifier.getUnsigned();
	}
	
	public void setAdditionalContextIdentifier(Long value)
	{
		if(value==null)
			this.additionalContextIdentifier = null;
		else
			this.additionalContextIdentifier = new AdditionalContextIdentifierImpl(value, null, null);			
	}
	
	public Long getThirdContextIdentifier()
	{
		if(thirdContextIdentifier==null)
			return null;
		
		return thirdContextIdentifier.getUnsigned();
	}
	
	public void setThirdContextIdentifier(Long value)
	{
		if(value==null)
			this.thirdContextIdentifier = null;
		else
			this.thirdContextIdentifier = new ThirdContextIdentifierImpl(value, null, null);			
	}
	
	public AllAPNConfigurationsIncludedIndicatorEnum getAllAPNConfigurationsIncludedIndicator()
	{
		if(allAPNConfigurationsIncludedIndicator==null)
			return null;
		
		return allAPNConfigurationsIncludedIndicator.getEnumerated(AllAPNConfigurationsIncludedIndicatorEnum.class);
	}
	
	public void setAllAPNConfigurationsIncludedIndicator(AllAPNConfigurationsIncludedIndicatorEnum value)
	{
		if(value==null)
			this.allAPNConfigurationsIncludedIndicator = null;
		else
			this.allAPNConfigurationsIncludedIndicator = new AllAPNConfigurationsIncludedIndicatorImpl(value, null, null);			
	}
	
	public List<APNConfiguration> getAPNConfiguration()
	{
		return apnConfiguration;
	}
	
	public void setAPNConfiguration(List<APNConfiguration> value)
	{
		if(value==null || value.size()==0)
			throw new IllegalArgumentException("APN-Configuration is required");
		
		this.apnConfiguration = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(contextIdentifier==null)
			return "Context-Identifier is required";
		
		if(apnConfiguration==null || apnConfiguration.size()==0)
			return "APN-Configuration is required";
		
		return null;
	}
}