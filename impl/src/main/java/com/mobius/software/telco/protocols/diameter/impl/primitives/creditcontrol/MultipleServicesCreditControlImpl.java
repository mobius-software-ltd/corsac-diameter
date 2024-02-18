package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol;
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

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ResultCodeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.ResultCode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GSUPoolReference;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.QoSFinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RatingGroup;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.TariffChangeUsage;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.TariffChangeUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ValidityTime;

/**
*
* @author yulian oifa
*
*/
public class MultipleServicesCreditControlImpl extends DiameterGroupedAvpImpl implements MultipleServicesCreditControl
{
	private GrantedServiceUnit grantedServiceUnit;
	
	private RequestedServiceUnit requestedServiceUnit;
	
	private List<UsedServiceUnit> usedServiceUnit;
	
	private TariffChangeUsage tariffChangeUsage;
	
	private List<ServiceIdentifier> serviceIdentifier;
	
	private RatingGroup ratingGroup;
	
	private List<GSUPoolReference> gsuPoolReference;
	
	private ValidityTime validityTime;
	
	private ResultCode resultCode;
	
	private FinalUnitIndication finalUnitIndication;
	
	private QoSFinalUnitIndication qosFinalUnitIndication;
	
	public MultipleServicesCreditControlImpl()
	{
	}
	
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return this.grantedServiceUnit;
	}
	
	public void setGrantedServiceUnit(GrantedServiceUnit grantedServiceUnit)
	{
		this.grantedServiceUnit = grantedServiceUnit;
	}
	
	public RequestedServiceUnit getRequestedServiceUnit()	
	{
		return this.requestedServiceUnit;
	}

	public void setRequestedServiceUnit(RequestedServiceUnit requestedServiceUnit)
	{
		this.requestedServiceUnit = requestedServiceUnit;
	}
	
	public List<UsedServiceUnit> getUsedServiceUnit()
	{
		return this.usedServiceUnit;
	}

	public void setUsedServiceUnit(List<UsedServiceUnit> usedServiceUnit)
	{
		this.usedServiceUnit = usedServiceUnit;
	}
	
	public TariffChangeUsageEnum getTariffChangeUsage()
	{
		if(this.tariffChangeUsage == null)
			return null;
		
		return this.tariffChangeUsage.getEnumerated(TariffChangeUsageEnum.class);
	}

	public void setTariffChangeUsage(TariffChangeUsageEnum value)
	{
		if(value == null)
			this.tariffChangeUsage = null;
		else
			this.tariffChangeUsage = new TariffChangeUsageImpl(value, null, null);
	}
	
	public List<Long> getServiceIdentifier()
	{
		if(this.serviceIdentifier == null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(ServiceIdentifier curr:serviceIdentifier)
			result.add(curr.getUnsigned());
		
		return result;
	}

	public void setServiceIdentifier(List<Long> value)
	{
		if(serviceIdentifier == null || serviceIdentifier.size()==0)
			this.serviceIdentifier = null;
		else
		{
			this.serviceIdentifier = new ArrayList<ServiceIdentifier>(value.size());
			for(Long curr:value)
				this.serviceIdentifier.add(new ServiceIdentifierImpl(curr, null, null));
		}
	}
	
	public Long getRatingGroup()
	{
		if(this.ratingGroup == null)
			return null;
		
		return this.ratingGroup.getUnsigned();
	}

	public void setRatingGroup(Long value)
	{
		if(value == null)
			this.ratingGroup = null;
		else
			this.ratingGroup = new RatingGroupImpl(value, null, null);
	}
			
	public List<GSUPoolReference> getGSUPoolReference()
	{
		return this.gsuPoolReference;
	}

	public void setGSUPoolReference(List<GSUPoolReference> value)
	{
		this.gsuPoolReference = value;
	}
	
	public Long getValidityTime()
	{
		if(this.validityTime == null)
			return null;
		
		return this.validityTime.getUnsigned();
	}

	public void setValidityTime(Long value)
	{
		if(value == null)
			this.validityTime = null;
		else
			this.validityTime = new ValidityTimeImpl(value, null, null);
	}
			
	public Long getResultCode()
	{
		if(this.resultCode == null)
			return null;
		
		return this.resultCode.getUnsigned();
	}

	public void setResultCode(Long value)
	{
		if(value == null)
			this.resultCode = null;
		else
			this.resultCode = new ResultCodeImpl(value, null, null);
	}
			
	public FinalUnitIndication getFinalUnitIndication()
	{
		return this.finalUnitIndication;
	}

	public void setFinalUnitIndication(FinalUnitIndication value)
	{
		this.finalUnitIndication = value;
	}

	public QoSFinalUnitIndication getQoSFinalUnitIndication()
	{
		return this.qosFinalUnitIndication;
	}

	public void setQoSFinalUnitIndication(QoSFinalUnitIndication value)
	{
		this.qosFinalUnitIndication = value;
	}
}