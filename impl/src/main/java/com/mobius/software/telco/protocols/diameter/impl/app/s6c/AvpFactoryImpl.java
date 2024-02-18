package com.mobius.software.telco.protocols.diameter.impl.app.s6c;
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

import com.mobius.software.telco.protocols.diameter.app.s6c.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.AdditionalServingNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.IPSMGWSMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MMESMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MSCSMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.MWDStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.RDRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SGSNSMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSF3GPPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSF3GPPSMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSFNon3GPPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSFNon3GPPSMDeliveryOutcomeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSGMSCAlertEventImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SRRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.ServingNodeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.UserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.SMSMICorrelationIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.AdditionalServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.IPSMGWSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MMESMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MSCSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MWDStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.RDRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SGSNSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSGMSCAlertEvent;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SRRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMSMICorrelationID;

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
	
	public MWDStatus getMWDStatus()
	{
		return new MWDStatusImpl();
	}
	
	public UserIdentifier getUserIdentifier()
	{
		return new UserIdentifierImpl();
	}
	
	public SMSFNon3GPPAddress getSMSFNon3GPPAddress()
	{
		return new SMSFNon3GPPAddressImpl();
	}
	
	public SMSF3GPPAddress getSMSF3GPPAddress()
	{
		return new SMSF3GPPAddressImpl();
	}
	
	public ServingNode getServingNode()
	{
		return new ServingNodeImpl();
	}
	
	public AdditionalServingNode getAdditionalServingNode()
	{
		return new AdditionalServingNodeImpl();
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
	
	public SMSGMSCAlertEvent getSMSGMSCAlertEvent()
	{
		return new SMSGMSCAlertEventImpl();
	}
	
	public SRRFlags getSRRFlags()
	{
		return new SRRFlagsImpl();
	}
	
	public RDRFlags getRDRFlags()
	{
		return new RDRFlagsImpl();
	}
}