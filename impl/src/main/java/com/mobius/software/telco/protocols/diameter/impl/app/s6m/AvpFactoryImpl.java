package com.mobius.software.telco.protocols.diameter.impl.app.s6m;
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

import com.mobius.software.telco.protocols.diameter.app.s6m.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.AdditionalServingNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.HSSCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.SIRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ServiceDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ServiceParametersImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ServingNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.T4DataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.T4ParametersImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.UserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.AdditionalServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.HSSCause;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.SIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceParameters;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.T4Data;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.T4Parameters;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;

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
	
	public ServiceParameters getServiceParameters()
	{
		return new ServiceParametersImpl();
	}
	
	public T4Parameters getT4Parameters()
	{
		return new T4ParametersImpl();
	}
	
	public UserIdentifier getUserIdentifier()
	{
		return new UserIdentifierImpl();
	}
	
	public ServiceData getServiceData()
	{
		return new ServiceDataImpl();
	}
	
	public T4Data getT4Data()
	{
		return new T4DataImpl();
	}
	
	public HSSCause getHSSCause()
	{
		return new HSSCauseImpl();
	}
	
	public ServingNode getServingNode()
	{
		return new ServingNodeImpl();
	}
	
	public AdditionalServingNode getAdditionalServingNode()
	{
		return new AdditionalServingNodeImpl();
	}
	
	public SIRFlags getSIRFlags()
	{
		return new SIRFlagsImpl();
	}
}
