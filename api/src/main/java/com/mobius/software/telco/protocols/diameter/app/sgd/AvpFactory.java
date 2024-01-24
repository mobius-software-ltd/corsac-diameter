package com.mobius.software.telco.protocols.diameter.app.sgd;
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

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList);
	
	public SMSMICorrelationID getSMSMICorrelationID();
	
	public EPSLocationInformation getEPSLocationInformation();
	
	public MMELocationInformation getMMELocationInformation();
	
	public SGSNLocationInformation getSGSNLocationInformation();
	
	public UserCSGInformation getUserCSGInformation(Long csgId,CSGAccessModeEnum csgAccessMode);	
	
	public UserIdentifier getUserIdentifier();
	
	public SMDeliveryOutcome getSMDeliveryOutcome();
	
	public MMESMDeliveryOutcome getMMESMDeliveryOutcome();
	
	public MSCSMDeliveryOutcome getMSCSMDeliveryOutcome();
	
	public SGSNSMDeliveryOutcome getSGSNSMDeliveryOutcome();
	
	public IPSMGWSMDeliveryOutcome getIPSMGWSMDeliveryOutcome();
	
	public SMSF3GPPSMDeliveryOutcome getSMSF3GPPSMDeliveryOutcome();
	
	public SMSFNon3GPPSMDeliveryOutcome getSMSFNon3GPPSMDeliveryOutcome();
	
	public SMDeliveryFailureCause getSMDeliveryFailureCause(SMEnumeratedDeliveryFailureCauseEnum smEnumeratedDeliveryFailureCause);
	
	public OFRFlags getOFRFlags();
	
	public TFRFlags getTFRFlags();
}
