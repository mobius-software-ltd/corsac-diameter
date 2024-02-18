package com.mobius.software.telco.protocols.diameter.impl.app.sgmb;
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

import com.mobius.software.telco.protocols.diameter.app.sgmb.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ConditionalAPNAggregateMaxBitrateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.QoSInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mb2c.LocalM1InformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.DiagnosticInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSFlagsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.LocalM1Information;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.DiagnosticInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSFlags;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public QoSInformation getQoSInformation()
	{
		return new QoSInformationImpl();
	}
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException
	{
		return new AllocationRetentionPriorityImpl(priorityLevel);
	}
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate()
	{
		return new ConditionalAPNAggregateMaxBitrateImpl();
	}
	
	public LocalM1Information getLocalM1Information()
	{
		return new LocalM1InformationImpl();
	}
	
	public DiagnosticInfo getDiagnosticInfo()
	{
		return new DiagnosticInfoImpl();
	}
	
	public MBMSFlags getMBMSFlags()
	{
		return new MBMSFlagsImpl();
	}
}