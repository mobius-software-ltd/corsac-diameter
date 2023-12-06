package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.RegistrationTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.IdentityWithEmergencyRegistration;

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
@DiameterCommandImplementation(applicationId = 16777216, commandCode = 304, request = false)
public class RegistrationTerminationAnswerImpl extends CxDxAnswerImpl implements RegistrationTerminationAnswer
{
	private AssociatedIdentities associatedIdentities;
	
	private List<IdentityWithEmergencyRegistration> identityWithEmergencyRegistration;
	
	protected RegistrationTerminationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public RegistrationTerminationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
	
	public AssociatedIdentities getAssociatedIdentities()
	{
		return associatedIdentities;
	}
	 
	public void setAssociatedIdentities(AssociatedIdentities value)
	{
		this.associatedIdentities = value;				
	}
	
	public List<IdentityWithEmergencyRegistration> getIdentityWithEmergencyRegistration()
	{
		return this.identityWithEmergencyRegistration;
	}
	 
	public void setIdentityWithEmergencyRegistration(List<IdentityWithEmergencyRegistration> value)
	{
		this.identityWithEmergencyRegistration = value;
	}
}