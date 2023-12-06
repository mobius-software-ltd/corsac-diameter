package com.mobius.software.telco.protocols.diameter.impl.commands.t4;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.t4.DeviceTriggerAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t4.MTCErrorDiagnosticImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t4.TriggerActionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.tsp.OldReferenceNumberImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.t4.MTCErrorDiagnostic;
import com.mobius.software.telco.protocols.diameter.primitives.t4.MTCErrorDiagnosticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.t4.TriggerAction;
import com.mobius.software.telco.protocols.diameter.primitives.t4.TriggerActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.OldReferenceNumber;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
@DiameterCommandImplementation(applicationId = 16777311, commandCode = 8388643, request = false)
public class DeviceTriggerAnswerImpl extends T4AnswerImpl implements DeviceTriggerAnswer
{
	private MTCErrorDiagnostic mtcErrorDiagnostic;
	
	private OldReferenceNumber oldReferenceNumber;
	
	private TriggerAction triggerAction;
	
	protected DeviceTriggerAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public DeviceTriggerAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
	
	@Override
	public MTCErrorDiagnosticEnum getMTCErrorDiagnostic()
	{
		if(mtcErrorDiagnostic==null)
			return null;
		
		return mtcErrorDiagnostic.getEnumerated(MTCErrorDiagnosticEnum.class);
	}
	
	@Override
	public void setMTCErrorDiagnostic(MTCErrorDiagnosticEnum value)
	{
		if(value==null)
			this.mtcErrorDiagnostic = null;
		else
			this.mtcErrorDiagnostic = new MTCErrorDiagnosticImpl(value, null, null);
	}
	
	@Override
	public Long getOldReferenceNumber()
	{
		if(oldReferenceNumber == null)
			return null;
		
		return oldReferenceNumber.getUnsigned();
	}
	
	@Override
	public void setOldReferenceNumber(Long value)
	{
		if(value == null)
			this.oldReferenceNumber = null;
		else
			this.oldReferenceNumber = new OldReferenceNumberImpl(value, null, null);
	}
	
	@Override
	public TriggerActionEnum getTriggerAction()
	{
		if(triggerAction == null)
			return null;
		
		return triggerAction.getEnumerated(TriggerActionEnum.class);
	}
	
	@Override
	public void setTriggerAction(TriggerActionEnum value)
	{
		if(value == null)
			this.triggerAction = null;
		else
			this.triggerAction = new TriggerActionImpl(value, null, null);
	}
}