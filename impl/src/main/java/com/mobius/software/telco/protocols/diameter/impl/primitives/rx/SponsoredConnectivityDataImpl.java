package com.mobius.software.telco.protocols.diameter.impl.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ApplicationServiceProviderIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsorIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsoredConnectivityData;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsoringAction;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsoringActionEnum;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 530L, vendorId = KnownVendorIDs.TGPP_ID)
public class SponsoredConnectivityDataImpl extends DiameterGroupedAvpImpl implements SponsoredConnectivityData
{
	private SponsorIdentity sponsorIdentity;
	
	private ApplicationServiceProviderIdentity applicationServiceProviderIdentity;
	
	private GrantedServiceUnit grantedServiceUnit;
	
	private UsedServiceUnit usedServiceUnit;
	
	private SponsoringAction sponsoringAction;
	
	public SponsoredConnectivityDataImpl()
	{
		
	}
	
	public String getSponsorIdentity()
	{
		if(sponsorIdentity == null)
			return null;
		
		return sponsorIdentity.getString();
	}
	
	public void setSponsorIdentity(String value)
	{
		if(value==null)
			this.sponsorIdentity = null;
		else
			this.sponsorIdentity = new SponsorIdentityImpl(value, null, null);
	}
	
	public String getApplicationServiceProviderIdentity()
	{
		if(applicationServiceProviderIdentity == null)
			return null;
		
		return applicationServiceProviderIdentity.getString();
	}
	
	public void setApplicationServiceProviderIdentity(String value)
	{
		if(value==null)
			this.applicationServiceProviderIdentity = null;
		else
			this.applicationServiceProviderIdentity = new ApplicationServiceProviderIdentityImpl(value, null, null);
	}
	
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return grantedServiceUnit;
	}
	
	public void setGrantedServiceUnit(GrantedServiceUnit value)
	{
		this.grantedServiceUnit = value;
	}
	
	public UsedServiceUnit getUsedServiceUnit()
	{
		return usedServiceUnit;
	}
	
	public void setUsedServiceUnit(UsedServiceUnit value)
	{
		this.usedServiceUnit =  value;
	}
	
	public SponsoringActionEnum getSponsoringAction()
	{
		if(sponsoringAction==null)
			return null;
		
		return sponsoringAction.getEnumerated(SponsoringActionEnum.class);
	}
	
	public void setSponsoringAction(SponsoringActionEnum value)
	{
		if(value==null)
			this.sponsoringAction = null;
		else
			this.sponsoringAction = new SponsoringActionImpl(value, null, null);	
	}
}