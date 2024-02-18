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

import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRBeginTime;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRChargeMode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRDuration;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDREndTime;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRPkgProductId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRPkgServiceId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRPkgSpId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRProductID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRSPName;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRServiceName;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRTimes;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CDRVolume;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CategoryID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ContentID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.RTBPInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SPId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.TransactionId;

/**
*
* @author yulian oifa
*
*/
public class RTBPInformationImpl implements RTBPInformation
{
	private SPId spId;
	
	private ServiceId serviceId;
	
	private CategoryID categoryID;
	
	private ContentID contentID;
	
	private CDRProductID cdrProductID;
	
	private CDRChargeMode cdrChargeMode;
	
	private CDRTimes cdrTimes;
	
	private CDRDuration cdrDuration;
	
	private CDRVolume cdrVolume;
	
	private CDRType cdrType;
	
	private CDRServiceType cdrServiceType;
	
	private CDRBeginTime cdrBeginTime;
	
	private CDREndTime cdrEndTime;
	
	private CDRPkgSpId cdrPkgSpId;
	
	private CDRPkgServiceId cdrPkgServiceId;
	
	private CDRPkgProductId cdrPkgProductId;
	
	private CDRSPName cdrSPName;
	
	private CDRServiceName cdrServiceName;
	
	private TransactionId transactionID;
	
	public RTBPInformationImpl()
	{
		
	}
	
	@Override
	public String getSPId()
	{
		if(spId==null)
			return null;
		
		return spId.getString();
	}
	
	@Override
	public void setSPId(String value)
	{
		if(value==null)
			this.spId = null;
		else
			this.spId = new SPIdImpl(value);
	}
	
	@Override
	public String getServiceId()
	{
		if(serviceId==null)
			return null;
		
		return serviceId.getString();
	}
	
	@Override
	public void setServiceId(String value)
	{
		if(value==null)
			this.serviceId = null;
		else
			this.serviceId = new ServiceIdImpl(value);
	}
	
	@Override
	public String getCategoryID()
	{
		if(categoryID==null)
			return null;
		
		return categoryID.getString();
	}
	
	@Override
	public void setCategoryID(String value)
	{
		if(value==null)
			this.categoryID = null;
		else
			this.categoryID = new CategoryIDImpl(value);
	}
	
	@Override
	public String getContentID()
	{
		if(contentID==null)
			return null;
		
		return contentID.getString();
	}
	
	@Override
	public void setContentID(String value)
	{
		if(value==null)
			this.contentID = null;
		else
			this.contentID = new ContentIDImpl(value);
	}
	
	@Override
	public String getCDRProductID()
	{
		if(cdrProductID==null)
			return null;
		
		return cdrProductID.getString();
	}
	
	@Override
	public void setCDRProductID(String value)
	{
		if(value==null)
			this.cdrProductID = null;
		else
			this.cdrProductID = new CDRProductIDImpl(value);
	}
	
	@Override
	public Integer getCDRChargeMode()
	{
		if(cdrChargeMode==null)
			return null;
		
		return cdrChargeMode.getInteger();
	}
	
	@Override
	public void setCDRChargeMode(Integer value)
	{
		if(value==null)
			this.cdrChargeMode = null;
		else
			this.cdrChargeMode = new CDRChargeModeImpl(value, null, null);
	}
	
	@Override
	public Integer getCDRTimes()
	{
		if(cdrTimes==null)
			return null;
		
		return cdrTimes.getInteger();
	}
	
	@Override
	public void setCDRTimes(Integer value)
	{
		if(value==null)
			this.cdrTimes = null;
		else
			this.cdrTimes = new CDRTimesImpl(value, null, null);
	}
	
	@Override
	public Integer getCDRDuration()
	{
		if(cdrDuration==null)
			return null;
		
		return cdrDuration.getInteger();
	}
	
	@Override
	public void setCDRDuration(Integer value)
	{
		if(value==null)
			this.cdrDuration = null;
		else
			this.cdrDuration = new CDRDurationImpl(value, null, null);
	}

	@Override
	public Integer getCDRVolume()
	{
		if(cdrVolume==null)
			return null;
		
		return cdrVolume.getInteger();
	}
	
	@Override
	public void setCDRVolume(Integer value)
	{
		if(value==null)
			this.cdrVolume = null;
		else
			this.cdrVolume = new CDRVolumeImpl(value, null, null);
	}
	
	@Override
	public Integer getCDRType()
	{
		if(cdrType==null)
			return null;
		
		return cdrType.getInteger();
	}
	
	@Override
	public void setCDRType(Integer value)
	{
		if(value==null)
			this.cdrType = null;
		else
			this.cdrType = new CDRTypeImpl(value, null, null);
	}
	
	@Override
	public Integer getCDRServiceType()
	{
		if(cdrServiceType==null)
			return null;
		
		return cdrServiceType.getInteger();
	}
	
	@Override
	public void setCDRServiceType(Integer value)
	{
		if(value==null)
			this.cdrServiceType = null;
		else
			this.cdrServiceType = new CDRServiceTypeImpl(value, null, null);
	}
	
	@Override
	public Integer getCDRBeginTime()
	{
		if(cdrBeginTime==null)
			return null;
		
		return cdrBeginTime.getInteger();
	}
	
	@Override
	public void setCDRBeginTime(Integer value)
	{
		if(value==null)
			this.cdrBeginTime = null;
		else
			this.cdrBeginTime = new CDRBeginTimeImpl(value, null, null);
	}
	
	@Override
	public Integer getCDREndTime()
	{
		if(cdrEndTime==null)
			return null;
		
		return cdrEndTime.getInteger();
	}
	
	@Override
	public void setCDREndTime(Integer value)
	{
		if(value==null)
			this.cdrEndTime = null;
		else
			this.cdrEndTime = new CDREndTimeImpl(value, null, null);
	}
	
	@Override
	public String getCDRPkgSpId()
	{
		if(cdrPkgSpId==null)
			return null;
		
		return cdrPkgSpId.getString();
	}
	
	@Override
	public void setCDRPkgSpId(String value)
	{
		if(value==null)
			this.cdrPkgSpId = null;
		else
			this.cdrPkgSpId = new CDRPkgSpIdImpl(value);
	}
	
	@Override
	public String getCDRPkgServiceId()
	{
		if(cdrPkgServiceId==null)
			return null;
		
		return cdrPkgServiceId.getString();
	}
	
	@Override
	public void setCDRPkgServiceId(String value)
	{
		if(value==null)
			this.cdrPkgServiceId = null;
		else
			this.cdrPkgServiceId = new CDRPkgServiceIdImpl(value);
	}
	
	@Override
	public String getCDRPkgProductId()
	{
		if(cdrPkgProductId==null)
			return null;
		
		return cdrPkgProductId.getString();
	}
	
	@Override
	public void setCDRPkgProductId(String value)
	{
		if(value==null)
			this.cdrPkgProductId = null;
		else
			this.cdrPkgProductId = new CDRPkgProductIdImpl(value);
	}
	
	@Override
	public String getCDRSPName()
	{
		if(cdrSPName==null)
			return null;
		
		return cdrSPName.getString();
	}
	
	@Override
	public void setCDRSPName(String value)
	{
		if(value==null)
			this.cdrSPName = null;
		else
			this.cdrSPName = new CDRSPNameImpl(value);
	}
	
	@Override
	public String getCDRServiceName()
	{
		if(cdrServiceName==null)
			return null;
		
		return cdrServiceName.getString();
	}
	
	@Override
	public void setCDRServiceName(String value)
	{
		if(value==null)
			this.cdrServiceName = null;
		else
			this.cdrServiceName = new CDRServiceNameImpl(value);
	}
	
	@Override
	public String getTransactionID()
	{
		if(transactionID==null)
			return null;
		
		return transactionID.getString();
	}
	
	@Override
	public void setTransactionID(String value)
	{
		if(value==null)
			this.transactionID = null;
		else
			this.transactionID = new TransactionIdImpl(value);
	}
}