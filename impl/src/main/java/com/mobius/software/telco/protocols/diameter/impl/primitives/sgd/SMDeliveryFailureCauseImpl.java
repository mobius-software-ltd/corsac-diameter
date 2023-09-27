package com.mobius.software.telco.protocols.diameter.impl.primitives.sgd;
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
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMDeliveryFailureCause;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMDiagnosticInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMEnumeratedDeliveryFailureCause;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMEnumeratedDeliveryFailureCauseEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3303L, vendorId = KnownVendorIDs.TGPP_ID)
public class SMDeliveryFailureCauseImpl extends DiameterGroupedAvpImpl implements SMDeliveryFailureCause
{
	private SMEnumeratedDeliveryFailureCause smEnumeratedDeliveryFailureCause;
	
	private SMDiagnosticInfo smDiagnosticInfo;
	
	protected SMDeliveryFailureCauseImpl()
	{
	}
	
	public SMDeliveryFailureCauseImpl(SMEnumeratedDeliveryFailureCauseEnum smEnumeratedDeliveryFailureCause)
	{
		if(smEnumeratedDeliveryFailureCause==null)
			throw new IllegalArgumentException("SM-Enumerated-Delivery-Failure-Cause");
		
		this.smEnumeratedDeliveryFailureCause = new SMEnumeratedDeliveryFailureCauseImpl(smEnumeratedDeliveryFailureCause, null, null);				
	}
	
	public SMEnumeratedDeliveryFailureCauseEnum getSMEnumeratedDeliveryFailureCause()
	{
		if(smEnumeratedDeliveryFailureCause==null)
			return null;
		
		return smEnumeratedDeliveryFailureCause.getEnumerated(SMEnumeratedDeliveryFailureCauseEnum.class);
	}
	
	public void setSMEnumeratedDeliveryFailureCause(SMEnumeratedDeliveryFailureCauseEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("SM-Enumerated-Delivery-Failure-Cause");
		
		this.smEnumeratedDeliveryFailureCause = new SMEnumeratedDeliveryFailureCauseImpl(value, null, null);				
	}
	
	public ByteBuf getSMDiagnosticInfo()
	{
		if(smDiagnosticInfo==null)
			return null;
		
		return smDiagnosticInfo.getValue();
	}
	
	public void setSMDiagnosticInfo(ByteBuf value)
	{
		if(value==null)
			this.smDiagnosticInfo = null;
		else
			this.smDiagnosticInfo = new SMDiagnosticInfoImpl(value, null, null);			
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(smEnumeratedDeliveryFailureCause==null)
			return "SM-Enumerated-Delivery-Failure-Cause";
		
		return null;
	}
}