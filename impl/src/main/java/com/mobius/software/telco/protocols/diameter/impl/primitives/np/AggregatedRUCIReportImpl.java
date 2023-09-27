package com.mobius.software.telco.protocols.diameter.impl.primitives.np;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.np.AggregatedCongestionInfo;
import com.mobius.software.telco.protocols.diameter.primitives.np.AggregatedRUCIReport;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelSetId;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelValue;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 4001L, vendorId = KnownVendorIDs.TGPP_ID)
public class AggregatedRUCIReportImpl extends DiameterGroupedAvpImpl implements AggregatedRUCIReport
{
	private List<AggregatedCongestionInfo> aggregatedCongestionInfo;
	
	private CalledStationId calledStationId;
	
	private CongestionLevelValue congestionLevelValue;
	
	private CongestionLevelSetId congestionLevelSetId;
	
	protected AggregatedRUCIReportImpl()
	{
		
	}
	
	public AggregatedRUCIReportImpl(List<AggregatedCongestionInfo> aggregatedCongestionInfo)
	{
		if(aggregatedCongestionInfo==null || aggregatedCongestionInfo.size()==0)
			throw new IllegalArgumentException("Aggregated-Congestion-Info is required");
		
		this.aggregatedCongestionInfo = aggregatedCongestionInfo;
	}
	
	public List<AggregatedCongestionInfo> getAggregatedCongestionInfo()
	{
		return aggregatedCongestionInfo;
	}
	
	public void setAggregatedCongestionInfo(List<AggregatedCongestionInfo> value)
	{
		if(value==null || value.size()==0)
			throw new IllegalArgumentException("Aggregated-Congestion-Info is required");
		
		this.aggregatedCongestionInfo = value;
	}
	
	public String getCalledStationId()
	{
		if(calledStationId==null)
			return null;
		
		return calledStationId.getString();
	}
	
	public void setCalledStationId(String value)
	{
		if(value == null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(value, null, null);
	}
	
	public Long getCongestionLevelValue()
	{
		if(congestionLevelValue==null)
			return null;
		
		return congestionLevelValue.getUnsigned();
	}
	
	public void setCongestionLevelValue(Long value)
	{
		if(value == null)
			this.congestionLevelValue = null;
		else
			this.congestionLevelValue = new CongestionLevelValueImpl(value, null, null);
	}
	
	public Long getCongestionLevelSetId()
	{
		if(congestionLevelSetId==null)
			return null;
		
		return congestionLevelSetId.getUnsigned();
	}
	
	public void setCongestionLevelSetId(Long value)
	{
		if(value == null)
			this.congestionLevelSetId = null;
		else
			this.congestionLevelSetId = new CongestionLevelSetIdImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(aggregatedCongestionInfo == null || aggregatedCongestionInfo.size()==0)
			return "Aggregated-Congestion-Info is required";
		
		return null;
	}
}