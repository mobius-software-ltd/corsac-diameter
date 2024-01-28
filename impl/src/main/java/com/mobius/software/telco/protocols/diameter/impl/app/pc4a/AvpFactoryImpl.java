package com.mobius.software.telco.protocols.diameter.impl.app.pc4a;
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

import com.mobius.software.telco.protocols.diameter.app.pc4a.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TGPPOCSpecificReductionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.PNRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSeAllowedPLMNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSeDirectAllowedImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSeInitialLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSePermissionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSeSubscriptionDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.UPRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPOCSpecificReduction;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.PNRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeAllowedPLMN;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeDirectAllowed;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeInitialLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSePermission;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.UPRFlags;
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
	
	public TGPPOCSpecificReduction getTGPPOCSpecificReduction()
	{
		return new TGPPOCSpecificReductionImpl();
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return new OCSupportedFeaturesImpl();
	}
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList)
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public ProSeInitialLocationInformation getProSeInitialLocationInformation()
	{
		return new ProSeInitialLocationInformationImpl();
	}
	
	public ProSePermission getProSePermission()
	{
		return new ProSePermissionImpl();
	}
	
	public ProSeSubscriptionData getProSeSubscriptionData(ProSePermission proSePermission)
	{
		return new ProSeSubscriptionDataImpl(proSePermission);
	}
	
	public ProSeAllowedPLMN getProSeAllowedPLMN()
	{
		return new ProSeAllowedPLMNImpl();
	}
	
	public ProSeDirectAllowed getProSeDirectAllowed()
	{
		return new ProSeDirectAllowedImpl();
	}
	
	public PNRFlags getPNRFlags()
	{
		return new PNRFlagsImpl();
	}
	
	public UPRFlags getUPRFlags()
	{
		return new UPRFlagsImpl();
	}
}
