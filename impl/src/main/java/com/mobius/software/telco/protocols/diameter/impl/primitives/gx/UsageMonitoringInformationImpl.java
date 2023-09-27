package com.mobius.software.telco.protocols.diameter.impl.primitives.gx;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.QuotaConsumptionTimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.QuotaConsumptionTime;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.gx.MonitoringKey;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringLevel;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringLevelEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringReportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UsageMonitoringSupportEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1067L, vendorId = KnownVendorIDs.TGPP_ID)
public class UsageMonitoringInformationImpl extends DiameterGroupedAvpImpl implements UsageMonitoringInformation
{
	private MonitoringKey monitoringKey;
	private List<GrantedServiceUnit> grantedServiceUnit;
	private List<UsedServiceUnit> usedServiceUnit;
	private QuotaConsumptionTime quotaConsumptionTime;
	private UsageMonitoringLevel usageMonitoringLevel;
	private UsageMonitoringReport usageMonitoringReport;
	private UsageMonitoringSupport usageMonitoringSupport;
		
	public UsageMonitoringInformationImpl()
	{
		
	}
	
	public ByteBuf getMonitoringKey()
	{
		if(monitoringKey==null)
			return null;
		
		return monitoringKey.getValue();
	}
	
	public void setMonitoringKey(ByteBuf value)
	{
		if(value==null)
			this.monitoringKey = null;
		else
			this.monitoringKey = new MonitoringKeyImpl(value, null, null);			
	}
	
	public List<GrantedServiceUnit> getGrantedServiceUnit()
	{
		return grantedServiceUnit;
	}
	
	public void setGrantedServiceUnit(List<GrantedServiceUnit> value)
	{
		if(value!=null && value.size()>2)
			throw new IllegalArgumentException("Up to 2 Granted-Service-Unit allowed");
		
		this.grantedServiceUnit = value;
	}
	
	public List<UsedServiceUnit> getUsedServiceUnit()
	{
		return usedServiceUnit;
	}
	
	public void setUsedServiceUnit(List<UsedServiceUnit> value)
	{
		if(value!=null && value.size()>2)
			throw new IllegalArgumentException("Up to 2 Used-Service-Unit allowed");
		
		this.usedServiceUnit = value;
	}
	
	public Long getQuotaConsumptionTime()
	{
		if(quotaConsumptionTime==null)
			return null;
		
		return quotaConsumptionTime.getUnsigned();
	}
	
	public void setQuotaConsumptionTime(Long value)
	{
		if(value==null)
			this.quotaConsumptionTime = null;
		else
			this.quotaConsumptionTime = new QuotaConsumptionTimeImpl(value, null, null);			
	}
	
	public UsageMonitoringLevelEnum getUsageMonitoringLevel()
	{
		if(usageMonitoringLevel==null)
			return null;
		
		return usageMonitoringLevel.getEnumerated(UsageMonitoringLevelEnum.class);
	}
	
	public void setUsageMonitoringLevel(UsageMonitoringLevelEnum value)
	{
		if(value==null)
			this.usageMonitoringLevel = null;
		else
			this.usageMonitoringLevel = new UsageMonitoringLevelImpl(value, null, null);			
	}
	
	public UsageMonitoringReportEnum getUsageMonitoringReport()
	{
		if(usageMonitoringReport==null)
			return null;
		
		return usageMonitoringReport.getEnumerated(UsageMonitoringReportEnum.class);
	}
	
	public void setUsageMonitoringReport(UsageMonitoringReportEnum value)
	{
		if(value==null)
			this.usageMonitoringReport = null;
		else
			this.usageMonitoringReport = new UsageMonitoringReportImpl(value, null, null);			
	}
	
	public UsageMonitoringSupportEnum getUsageMonitoringSupport()
	{
		if(usageMonitoringSupport==null)
			return null;
		
		return usageMonitoringSupport.getEnumerated(UsageMonitoringSupportEnum.class);
	}
	
	public void setUsageMonitoringSupport(UsageMonitoringSupportEnum value)
	{
		if(value==null)
			this.usageMonitoringSupport = null;
		else
			this.usageMonitoringSupport = new UsageMonitoringSupportImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(grantedServiceUnit!=null && grantedServiceUnit.size()>2)
			return "Up to 2 Granted-Service-Unit allowed";
		
		if(usedServiceUnit!=null && usedServiceUnit.size()>2)
			return "Up to 2 Used-Service-Unit allowed";
		
		return null;
	}		  		  	  
}