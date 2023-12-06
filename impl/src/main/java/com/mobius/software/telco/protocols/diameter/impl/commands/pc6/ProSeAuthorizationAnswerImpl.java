package com.mobius.software.telco.protocols.diameter.impl.commands.pc6;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeAuthorizationAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.AuthorizedDiscoveryRangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc4a.ProSeDirectAllowedImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ValidityTimeAnnounceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ValidityTimeCommunicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ValidityTimeMonitorImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.AuthorizedDiscoveryRange;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeDirectAllowed;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ValidityTimeAnnounce;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ValidityTimeCommunication;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ValidityTimeMonitor;

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
@DiameterCommandImplementation(applicationId = 16777340, commandCode = 8388668, request = false)
public class ProSeAuthorizationAnswerImpl extends Pc6AnswerImpl implements ProSeAuthorizationAnswer
{
	private ProSeDirectAllowed proSeDirectAllowed;
	 
	private ValidityTimeAnnounce validityTimeAnnounce;
	 
	private ValidityTimeMonitor validityTimeMonitor;
	 
	private ValidityTimeCommunication validityTimeCommunication;
	 
	private AuthorizedDiscoveryRange authorizedDiscoveryRange;
	 
	protected ProSeAuthorizationAnswerImpl() 
	{
		super();
	}
	
	public ProSeAuthorizationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
	}
	
	@Override
	public Long getProSeDirectAllowed()
	{
		if(proSeDirectAllowed == null)
			return null;
		
		return proSeDirectAllowed.getUnsigned();
	}
	 
	@Override
	public void setProSeDirectAllowed(Long value)
	{
		if(value==null)
			this.proSeDirectAllowed = null;
		else
			this.proSeDirectAllowed = new ProSeDirectAllowedImpl(value, null, null);
	}
	 		
	@Override
	public Long getValidityTimeAnnounce()
	{
		if(validityTimeAnnounce == null)
			return null;
		
		return validityTimeAnnounce.getUnsigned();
	}
	 
	@Override
	public void setValidityTimeAnnounce(Long value)
	{
		if(value==null)
			this.validityTimeAnnounce = null;
		else
			this.validityTimeAnnounce = new ValidityTimeAnnounceImpl(value, null, null);
	}
	
	@Override
	public Long getValidityTimeMonitor()
	{
		if(validityTimeMonitor == null)
			return null;
		
		return validityTimeMonitor.getUnsigned();
	}
	 
	@Override
	public void setValidityTimeMonitor(Long value)
	{
		if(value==null)
			this.validityTimeMonitor = null;
		else
			this.validityTimeMonitor = new ValidityTimeMonitorImpl(value, null, null);
	}
	 		
	@Override
	public Long getValidityTimeCommunication()
	{
		if(validityTimeCommunication == null)
			return null;
		
		return validityTimeCommunication.getUnsigned();
	}
	 
	@Override
	public void setValidityTimeCommunication(Long value)
	{
		if(value==null)
			this.validityTimeCommunication = null;
		else
			this.validityTimeCommunication = new ValidityTimeCommunicationImpl(value, null, null);
	}
	
	@Override
	public Long getAuthorizedDiscoveryRange()
	{
		if(authorizedDiscoveryRange == null)
			return null;
		
		return authorizedDiscoveryRange.getUnsigned();
	}
	 
	@Override
	public void setAuthorizedDiscoveryRange(Long value)
	{
		if(value==null)
			this.authorizedDiscoveryRange = null;
		else
			this.authorizedDiscoveryRange = new AuthorizedDiscoveryRangeImpl(value, null, null);
	}
}