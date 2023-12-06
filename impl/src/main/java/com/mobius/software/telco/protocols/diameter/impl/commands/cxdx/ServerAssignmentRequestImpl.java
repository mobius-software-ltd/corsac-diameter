package com.mobius.software.telco.protocols.diameter.impl.commands.cxdx;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.cxdx.ServerAssignmentRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.MultipleRegistrationIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SARFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerAssignmentTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SessionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.UserDataAlreadyAvailableImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.WildcardedPublicIdentityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.FailedPCSCF;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.MultipleRegistrationIndication;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.MultipleRegistrationIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SARFlags;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SCSCFRestorationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerAssignmentType;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerAssignmentTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerName;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriority;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserDataAlreadyAvailable;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.UserDataAlreadyAvailableEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.WildcardedPublicIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

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
@DiameterCommandImplementation(applicationId = 16777216, commandCode = 301, request = true)
public class ServerAssignmentRequestImpl extends CxDxRequestWithHostBase implements ServerAssignmentRequest
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private List<PublicIdentity> publicIdentity;
	
	private WildcardedPublicIdentity wildcardedPublicIdentity;
	
	private ServerName serverName;
	
	private ServerAssignmentType serverAssignmentType;
	
	private UserDataAlreadyAvailable userDataAlreadyAvailable;
	
	private SCSCFRestorationInfo scscfRestorationInfo;
	
	private MultipleRegistrationIndication multipleRegistrationIndication;
	
	private SessionPriority sessionPriority;
	
	private SARFlags sarFlags;
	
	private FailedPCSCF failedPCSCF;
	
	protected ServerAssignmentRequestImpl() 
	{
		super();
	}
	
	public ServerAssignmentRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, String serverName, ServerAssignmentTypeEnum serverAssignmentType,UserDataAlreadyAvailableEnum userDataAlreadyAvailable)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setServerName(serverName);
		setServerAssignmentType(serverAssignmentType);		
		setUserDataAlreadyAvailable(userDataAlreadyAvailable);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	public List<String> getPublicIdentity()
	{
		if(publicIdentity==null || publicIdentity.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(PublicIdentity curr:publicIdentity)
			result.add(curr.getString());
		
		return result;
	}
			
	public void setPublicIdentity(List<String> value)
	{
		if(value==null || value.size()==0)
			this.publicIdentity = null;
		
		this.publicIdentity = new ArrayList<PublicIdentity>();
		for(String curr:value)
			this.publicIdentity.add(new PublicIdentityImpl(curr, null, null));
	}
	
	 		
	@Override
	public String getWildcardedPublicIdentity()
	{
		if(wildcardedPublicIdentity==null)
			return null;
		
		return wildcardedPublicIdentity.getString();
	}
	 
	@Override
	public void setWildcardedPublicIdentity(String value)
	{
		if(value==null)
			this.wildcardedPublicIdentity = null;
		else
			this.wildcardedPublicIdentity = new WildcardedPublicIdentityImpl(value, null, null);
	}
	
	@Override
	public String getServerName()
	{
		if(serverName == null)
			return null;
		
		return serverName.getString();
	}
	
	@Override
	public void setServerName(String value)
	{
		if(value == null)
			throw new IllegalArgumentException("Server-Name is required");
		
		this.serverName = new ServerNameImpl(value, null, null);
	}

	@Override
	public ServerAssignmentTypeEnum getServerAssignmentType() 
	{
		if(serverAssignmentType == null)
			return null;
		
		return serverAssignmentType.getEnumerated(ServerAssignmentTypeEnum.class);
	}

	@Override
	public void setServerAssignmentType(ServerAssignmentTypeEnum value) 
	{
		if(value == null)
			throw new IllegalArgumentException("Server-Assignment-Type is required");
		
		this.serverAssignmentType = new ServerAssignmentTypeImpl(value, null, null);
	}
	
	@Override
	public UserDataAlreadyAvailableEnum getUserDataAlreadyAvailable()
	{
		if(userDataAlreadyAvailable == null)
			return null;
		
		return userDataAlreadyAvailable.getEnumerated(UserDataAlreadyAvailableEnum.class);
	}
	
	@Override
	public void setUserDataAlreadyAvailable(UserDataAlreadyAvailableEnum value)
	{
		if(value == null)
			throw new IllegalArgumentException("User-Data-Already-Available is required");
		
		this.userDataAlreadyAvailable = new UserDataAlreadyAvailableImpl(value, null, null);
	}
	
	public SCSCFRestorationInfo getSCSCFRestorationInfo()
	{
		return scscfRestorationInfo;
	}
	
	public void setSCSCFRestorationInfo(SCSCFRestorationInfo value)
	{
		this.scscfRestorationInfo = value;
	}
	
	public MultipleRegistrationIndicationEnum getMultipleRegistrationIndication()
	{
		if(multipleRegistrationIndication == null)
			return null;
		
		return multipleRegistrationIndication.getEnumerated(MultipleRegistrationIndicationEnum.class);
	}
	
	public void setMultipleRegistrationIndication(MultipleRegistrationIndicationEnum value)
	{
		if(value == null)
			this.multipleRegistrationIndication = null;
		else
			this.multipleRegistrationIndication = new MultipleRegistrationIndicationImpl(value, null, null);
	}
	
	public SessionPriorityEnum getSessionPriority()
	{
		if(sessionPriority == null)
			return null;
		
		return sessionPriority.getEnumerated(SessionPriorityEnum.class);
	}
	
	public void setSessionPriority(SessionPriorityEnum value)
	{
		if(value == null)
			this.sessionPriority = null;
		else
			this.sessionPriority = new SessionPriorityImpl(value, null, null);
	}
	
	public Long getSARFlags()
	{
		if(sarFlags == null)
			return null;
		
		return sarFlags.getUnsigned();
	}
	
	public void setSARFlags(Long value)
	{
		if(value == null)
			this.sarFlags = null;
		else
			this.sarFlags = new SARFlagsImpl(value, null, null);
	}
	
	public FailedPCSCF getFailedPCSCF()
	{
		return this.failedPCSCF;
	}
	
	public void setFailedPCSCF(FailedPCSCF value)
	{
		this.failedPCSCF = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(serverName == null)
			return "Server-Name is required";
		
		if(serverAssignmentType == null)
			return "Server-Assignment-Type is required";
		
		if(userDataAlreadyAvailable == null)
			return "User-Data-Already-Available is required";
		
		return super.validate();
	}
}