package com.mobius.software.telco.protocols.diameter.impl.app.sgd;
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

import com.mobius.software.telco.protocols.diameter.app.sgd.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.UserCSGInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.EPSLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MMELocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SGSNLocationInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.IPSMGWSMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MMESMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MSCSMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SGSNSMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSF3GPPSMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSFNon3GPPSMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.UserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.OFRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.SMDeliveryFailureCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.SMSMICorrelationIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.TFRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CSGAccessModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MMELocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SGSNLocationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.IPSMGWSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MMESMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MSCSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SGSNSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.OFRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMDeliveryFailureCause;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMEnumeratedDeliveryFailureCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMSMICorrelationID;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.TFRFlags;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public SMSMICorrelationID getSMSMICorrelationID()
	{
		return new SMSMICorrelationIDImpl();
	}
	
	public EPSLocationInformation getEPSLocationInformation()
	{
		return new EPSLocationInformationImpl();
	}
	
	public MMELocationInformation getMMELocationInformation()
	{
		return new MMELocationInformationImpl();
	}
	
	public SGSNLocationInformation getSGSNLocationInformation()
	{
		return new SGSNLocationInformationImpl();
	}
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode) throws MissingAvpException
	{
		return new UserCSGInformationImpl(csgId, csgAccessMode);
	}	
	
	public UserIdentifier getUserIdentifier()
	{
		return new UserIdentifierImpl();
	}
	
	public SMDeliveryOutcome getSMDeliveryOutcome()
	{
		return new SMDeliveryOutcomeImpl();
	}
	
	public MMESMDeliveryOutcome getMMESMDeliveryOutcome()
	{
		return new MMESMDeliveryOutcomeImpl();
	}
	
	public MSCSMDeliveryOutcome getMSCSMDeliveryOutcome()
	{
		return new MSCSMDeliveryOutcomeImpl();
	}
	
	public SGSNSMDeliveryOutcome getSGSNSMDeliveryOutcome()
	{
		return new SGSNSMDeliveryOutcomeImpl();
	}
	
	public IPSMGWSMDeliveryOutcome getIPSMGWSMDeliveryOutcome()
	{
		return new IPSMGWSMDeliveryOutcomeImpl();
	}
	
	public SMSF3GPPSMDeliveryOutcome getSMSF3GPPSMDeliveryOutcome()
	{
		return new SMSF3GPPSMDeliveryOutcomeImpl();
	}
	
	public SMSFNon3GPPSMDeliveryOutcome getSMSFNon3GPPSMDeliveryOutcome()
	{
		return new SMSFNon3GPPSMDeliveryOutcomeImpl();
	}
	
	public SMDeliveryFailureCause getSMDeliveryFailureCause(SMEnumeratedDeliveryFailureCauseEnum smEnumeratedDeliveryFailureCause) throws MissingAvpException
	{
		return new SMDeliveryFailureCauseImpl(smEnumeratedDeliveryFailureCause);
	}
	
	public OFRFlags getOFRFlags()
	{
		return new OFRFlagsImpl();
	}
	
	public TFRFlags getTFRFlags()
	{
		return new TFRFlagsImpl();
	}
}
