package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei;
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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.IBrandID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.IFirstCallFlag;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ILanguageType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ISMSLanguageType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ISaasTenantID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ISubCOSID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ITenantID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.IUserType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.UserBasicInfo;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 20856L, vendorId = KnownVendorIDs.HUAWEI_ID)
public class UserBasicInfoImpl implements UserBasicInfo
{
	private ISubCOSID iSubCOSID;
	
	private IUserType iUserType;
	
	private ITenantID iTenantID;
	
	private ILanguageType iLanguageType;
	
	private ISMSLanguageType iSMSLanguageType;
	
	private IBrandID iBrandID;
	
	private ISaasTenantID iSaasTenantID;
	
	private IFirstCallFlag iFirstCallFlag;
	
	public UserBasicInfoImpl()
	{
		
	}
	
	@Override
	public Integer getISubCOSID()
	{
		if(iSubCOSID==null)
			return null;
		
		return iSubCOSID.getInteger();
	}
	
	@Override
	public void setISubCOSID(Integer value)
	{
		if(value==null)
			this.iSubCOSID = null;
		else
			this.iSubCOSID = new ISubCOSIDImpl(value, null, null);
	}	
	
	@Override
	public Integer getIUserType()
	{
		if(iUserType==null)
			return null;
		
		return iUserType.getInteger();
	}
	
	@Override
	public void setIUserType(Integer value)
	{
		if(value==null)
			this.iUserType = null;
		else
			this.iUserType = new IUserTypeImpl(value, null, null);
	}	
	
	@Override
	public Integer getITenantID()
	{
		if(iTenantID==null)
			return null;
		
		return iTenantID.getInteger();
	}
	
	@Override
	public void setITenantID(Integer value)
	{
		if(value==null)
			this.iTenantID = null;
		else
			this.iTenantID = new ITenantIDImpl(value, null, null);
	}	
	
	@Override
	public Integer getILanguageType()
	{
		if(iLanguageType==null)
			return null;
		
		return iLanguageType.getInteger();
	}
	
	@Override
	public void setILanguageType(Integer value)
	{
		if(value==null)
			this.iLanguageType = null;
		else
			this.iLanguageType = new ILanguageTypeImpl(value, null, null);
	}		
	
	@Override
	public Integer getISMSLanguageType()
	{
		if(iSMSLanguageType==null)
			return null;
		
		return iSMSLanguageType.getInteger();
	}
	
	@Override
	public void setISMSLanguageType(Integer value)
	{
		if(value==null)
			this.iSMSLanguageType = null;
		else
			this.iSMSLanguageType = new ISMSLanguageTypeImpl(value, null, null);
	}
	
	@Override
	public Integer getIBrandID()
	{
		if(iBrandID==null)
			return null;
		
		return iBrandID.getInteger();
	}
	
	@Override
	public void setIBrandID(Integer value)
	{
		if(value==null)
			this.iBrandID = null;
		else
			this.iBrandID = new IBrandIDImpl(value, null, null);
	}
	
	@Override
	public Integer getISaasTenantID()
	{
		if(iSaasTenantID==null)
			return null;
		
		return iSaasTenantID.getInteger();
	}
	
	@Override
	public void setISaasTenantID(Integer value)
	{
		if(value==null)
			this.iSaasTenantID = null;
		else
			this.iSaasTenantID = new ISaasTenantIDImpl(value, null, null);
	}	
	
	@Override
	public String getIFirstCallFlag()
	{
		if(iFirstCallFlag==null)
			return null;
		
		return iFirstCallFlag.getString();
	}
	
	@Override
	public void setIFirstCallFlag(String value)
	{
		if(value==null)
			this.iFirstCallFlag = null;
		else
			this.iFirstCallFlag = new IFirstCallFlagImpl(value, null, null);
	}	
}