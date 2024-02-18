package com.mobius.software.telco.protocols.diameter.app.s6c;
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

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException;
	
	public SMSMICorrelationID getSMSMICorrelationID();
	
	public MWDStatus getMWDStatus();
	
	public UserIdentifier getUserIdentifier();
	
	public SMSFNon3GPPAddress getSMSFNon3GPPAddress();
	
	public SMSF3GPPAddress getSMSF3GPPAddress();
	
	public ServingNode getServingNode();
	
	public AdditionalServingNode getAdditionalServingNode();
	
	public SMDeliveryOutcome getSMDeliveryOutcome();
	
	public MMESMDeliveryOutcome getMMESMDeliveryOutcome();
	
	public MSCSMDeliveryOutcome getMSCSMDeliveryOutcome();
	
	public SGSNSMDeliveryOutcome getSGSNSMDeliveryOutcome();
	
	public IPSMGWSMDeliveryOutcome getIPSMGWSMDeliveryOutcome();
	
	public SMSF3GPPSMDeliveryOutcome getSMSF3GPPSMDeliveryOutcome();
	
	public SMSFNon3GPPSMDeliveryOutcome getSMSFNon3GPPSMDeliveryOutcome();
	
	public SMSGMSCAlertEvent getSMSGMSCAlertEvent();
	
	public SRRFlags getSRRFlags();
	
	public RDRFlags getRDRFlags();
}
