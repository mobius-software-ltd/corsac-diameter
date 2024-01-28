package com.mobius.software.telco.protocols.diameter.impl.app.np;
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

import com.mobius.software.telco.protocols.diameter.app.np.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.AggregatedCongestionInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.AggregatedRUCIReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.ConditionalRestrictionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.CongestionLevelDefinitionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.CongestionLevelRangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.np.CongestionLocationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.np.AggregatedCongestionInfo;
import com.mobius.software.telco.protocols.diameter.primitives.np.AggregatedRUCIReport;
import com.mobius.software.telco.protocols.diameter.primitives.np.ConditionalRestriction;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLevelRange;
import com.mobius.software.telco.protocols.diameter.primitives.np.CongestionLocationId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public Load getLoad()
	{
		return new LoadImpl();
	}
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType)
	{
		return new OCOLRImpl(ocSequenceNumber, ocReportType);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return new OCSupportedFeaturesImpl();
	}
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList)
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public CongestionLevelDefinition getCongestionLevelDefinition(Long congestionLevelSetId,CongestionLevelRange congestionLevelRange)
	{
		return new CongestionLevelDefinitionImpl(congestionLevelSetId, congestionLevelRange);
	}
	
	public CongestionLevelRange getCongestionLevelRange()
	{
		return new CongestionLevelRangeImpl();
	}
	
	public ConditionalRestriction getConditionalRestriction()
	{
		return new ConditionalRestrictionImpl();
	}
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData)
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public AggregatedRUCIReport getAggregatedRUCIReport(List<AggregatedCongestionInfo> aggregatedCongestionInfo)
	{
		return new AggregatedRUCIReportImpl(aggregatedCongestionInfo);
	}
	
	public AggregatedCongestionInfo getAggregatedCongestionInfo()
	{
		return new AggregatedCongestionInfoImpl();
	}
	
	public CongestionLocationId getCongestionLocationId()
	{
		return new CongestionLocationIdImpl();
	}
}
