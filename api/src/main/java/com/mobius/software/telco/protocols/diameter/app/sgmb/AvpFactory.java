package com.mobius.software.telco.protocols.diameter.app.sgmb;
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

import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.AllocationRetentionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ConditionalAPNAggregateMaxBitrate;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.LocalM1Information;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.DiagnosticInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSFlags;


public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	public QoSInformation getQoSInformation();
	
	public AllocationRetentionPriority getAllocationRetentionPriority(Long priorityLevel) throws MissingAvpException;
	
	public ConditionalAPNAggregateMaxBitrate getConditionalAPNAggregateMaxBitrate();
	
	public LocalM1Information getLocalM1Information();
	
	public DiagnosticInfo getDiagnosticInfo();
	
	public MBMSFlags getMBMSFlags();
}