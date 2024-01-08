package com.mobius.software.telco.protocols.diameter.impl.commands.sh;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.sh.ProfileUpdateRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.DataReferenceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.UserDataImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReference;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReferenceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserData;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

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
@DiameterCommandImplementation(applicationId = 16777217, commandCode = 307, request = true)
public class ProfileUpdateRequestImpl extends ShRequestImpl implements ProfileUpdateRequest
{
	private List<DataReference> dataReference;
	 
	private UserData userData;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	protected ProfileUpdateRequestImpl() 
	{
		super();
	}
	
	public ProfileUpdateRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, UserIdentity userIdentity, ByteBuf userData,List<DataReferenceEnum> dataReference)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState, userIdentity);		
		
		setUserData(userData);
		setDataReference(dataReference);
	}
	
	public List<DataReferenceEnum> getDataReference()
	{
		if(dataReference==null || dataReference.size()==0)
			return null;
		
		List<DataReferenceEnum> result=new ArrayList<DataReferenceEnum>();
		for(DataReference curr:dataReference)
			result.add(curr.getEnumerated(DataReferenceEnum.class));
		
		return result;
	}
	 
	public void setDataReference(List<DataReferenceEnum> value)
	{
		if(value==null || value.size()==0)
			throw new IllegalArgumentException("Data-Reference is required");
			
		this.dataReference = new ArrayList<DataReference>();
		for(DataReferenceEnum curr:value)
			this.dataReference.add(new DataReferenceImpl(curr, null, null));
	}
	
	public ByteBuf getUserData()
	{
		if(userData==null)
			return null;
		
		return userData.getValue();
	}
	
	public void setUserData(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("User-Data is required");
			
		this.userData = new UserDataImpl(value, null, null);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(userData == null)
			return "User-Data is required";
		
		if(dataReference == null || dataReference.size()==0)
			return "Data-Reference is required";
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(userIdentity);
		result.add(wildcardedPublicIdentity);
		result.add(wildcardedIMPU);
		result.add(username);
		
		if(dataReference!=null)
			result.addAll(dataReference);
		
		result.add(userData);
		result.add(ocSupportedFeatures);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}
}