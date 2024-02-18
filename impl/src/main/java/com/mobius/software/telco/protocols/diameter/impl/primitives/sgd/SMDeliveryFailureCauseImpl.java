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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
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
public class SMDeliveryFailureCauseImpl extends DiameterGroupedAvpImpl implements SMDeliveryFailureCause
{
	private SMEnumeratedDeliveryFailureCause smEnumeratedDeliveryFailureCause;
	
	private SMDiagnosticInfo smDiagnosticInfo;
	
	protected SMDeliveryFailureCauseImpl()
	{
	}
	
	public SMDeliveryFailureCauseImpl(SMEnumeratedDeliveryFailureCauseEnum smEnumeratedDeliveryFailureCause) throws MissingAvpException
	{
		setSMEnumeratedDeliveryFailureCause(smEnumeratedDeliveryFailureCause);
	}
	
	public SMEnumeratedDeliveryFailureCauseEnum getSMEnumeratedDeliveryFailureCause()
	{
		if(smEnumeratedDeliveryFailureCause==null)
			return null;
		
		return smEnumeratedDeliveryFailureCause.getEnumerated(SMEnumeratedDeliveryFailureCauseEnum.class);
	}
	
	public void setSMEnumeratedDeliveryFailureCause(SMEnumeratedDeliveryFailureCauseEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("SM-Enumerated-Delivery-Failure-Cause is required is required", Arrays.asList(new DiameterAvp[] { new SMEnumeratedDeliveryFailureCauseImpl() }));
			
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
	public DiameterException validate()
	{
		if(smEnumeratedDeliveryFailureCause==null)
			return new MissingAvpException("SM-Enumerated-Delivery-Failure-Cause is required is required", Arrays.asList(new DiameterAvp[] { new SMEnumeratedDeliveryFailureCauseImpl() }));
		
		return null;
	}
}