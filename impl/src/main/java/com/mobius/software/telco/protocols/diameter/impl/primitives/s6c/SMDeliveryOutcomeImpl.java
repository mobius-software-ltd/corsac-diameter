package com.mobius.software.telco.protocols.diameter.impl.primitives.s6c;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.IPSMGWSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MMESMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MSCSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SGSNSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPSMDeliveryOutcome;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3316L, vendorId = KnownVendorIDs.TGPP_ID)
public class SMDeliveryOutcomeImpl extends DiameterGroupedAvpImpl implements SMDeliveryOutcome
{
	private MMESMDeliveryOutcome mmeSMDeliveryOutcome;
	
	private MSCSMDeliveryOutcome mscSMDeliveryOutcome;
	
	private SGSNSMDeliveryOutcome sgsnSMDeliveryOutcome;
	
	private IPSMGWSMDeliveryOutcome ipSMGWSMDeliveryOutcome;
	
	private SMSF3GPPSMDeliveryOutcome smsf3GPPSMDeliveryOutcome;
	
	private SMSFNon3GPPSMDeliveryOutcome smsfNon3GPPSMDeliveryOutcome;
	
	public SMDeliveryOutcomeImpl()
	{
		
	}
	
	public MMESMDeliveryOutcome getMMESMDeliveryOutcome()
	{
		return mmeSMDeliveryOutcome;
	}
	
	public void setMMESMDeliveryOutcome(MMESMDeliveryOutcome value)
	{
		this.mmeSMDeliveryOutcome = value;
	}
	
	public MSCSMDeliveryOutcome getMSCSMDeliveryOutcome()
	{
		return mscSMDeliveryOutcome;
	}
	
	public void setMSCSMDeliveryOutcome(MSCSMDeliveryOutcome value)
	{
		this.mscSMDeliveryOutcome = value;
	}
	
	public SGSNSMDeliveryOutcome getSGSNSMDeliveryOutcome()
	{
		return sgsnSMDeliveryOutcome;
	}
	
	public void setSGSNSMDeliveryOutcome(SGSNSMDeliveryOutcome value)
	{
		this.sgsnSMDeliveryOutcome = value;
	}
	
	public IPSMGWSMDeliveryOutcome getIPSMGWSMDeliveryOutcome()
	{
		return ipSMGWSMDeliveryOutcome;
	}
	
	public void setIPSMGWSMDeliveryOutcome(IPSMGWSMDeliveryOutcome value)
	{
		this.ipSMGWSMDeliveryOutcome = value;
	}
	
	public SMSF3GPPSMDeliveryOutcome getSMSF3GPPSMDeliveryOutcome()
	{
		return smsf3GPPSMDeliveryOutcome;
	}	
	
	public void setSMSF3GPPSMDeliveryOutcome(SMSF3GPPSMDeliveryOutcome value)
	{
		this.smsf3GPPSMDeliveryOutcome = value;
	}
	
	public SMSFNon3GPPSMDeliveryOutcome getSMSFNon3GPPSMDeliveryOutcome()
	{
		return smsfNon3GPPSMDeliveryOutcome;
	}
	
	public void setSMSFNon3GPPSMDeliveryOutcome(SMSFNon3GPPSMDeliveryOutcome value)
	{
		this.smsfNon3GPPSMDeliveryOutcome = value;
	}
}