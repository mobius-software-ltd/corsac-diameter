package com.mobius.software.telco.protocols.diameter.app.np;
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

import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
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

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public Load getLoad();
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException;
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	public CongestionLevelDefinition getCongestionLevelDefinition(Long congestionLevelSetId,CongestionLevelRange congestionLevelRange) throws MissingAvpException;
	
	public CongestionLevelRange getCongestionLevelRange();
	
	public ConditionalRestriction getConditionalRestriction();
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException;
	
	public AggregatedRUCIReport getAggregatedRUCIReport(List<AggregatedCongestionInfo> aggregatedCongestionInfo) throws MissingAvpException;
	
	public AggregatedCongestionInfo getAggregatedCongestionInfo();
	
	public CongestionLocationId getCongestionLocationId();
}
