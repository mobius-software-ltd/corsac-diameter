package com.mobius.software.telco.protocols.diameter.impl.commands.nt;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.nt.BackgroundDataTransferRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcInputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcOutputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcTotalOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nt.NetworkAreaInfoListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nt.NumberOfUEsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nt.ReferenceIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nt.TransferPolicyIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nt.TransferRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ApplicationServiceProviderIdentityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcInputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcOutputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcTotalOctets;
import com.mobius.software.telco.protocols.diameter.primitives.nt.NetworkAreaInfoList;
import com.mobius.software.telco.protocols.diameter.primitives.nt.NumberOfUEs;
import com.mobius.software.telco.protocols.diameter.primitives.nt.ReferenceId;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TimeWindow;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferPolicyId;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ApplicationServiceProviderIdentity;

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
@DiameterCommandImplementation(applicationId = 16777348, commandCode = 8388723, request = true)
public class BackgroundDataTransferRequestImpl extends NtRequestImpl implements BackgroundDataTransferRequest
{
	private TransferRequestType transferRequestType;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private ApplicationServiceProviderIdentity applicationServiceProviderIdentity;
    
	private CcOutputOctets ccOutputOctets;
	
	private CcInputOctets ccInputOctets;
	
	private CcTotalOctets ccTotalOctets;
	
	private NumberOfUEs numberOfUEs;
	
	private TimeWindow timeWindow;
	
	private NetworkAreaInfoList networkAreaInfoList;
	
	private ReferenceId referenceId;
	
	private TransferPolicyId transferPolicyId;
	
	protected BackgroundDataTransferRequestImpl() 
	{
		super();
	}
	
	public BackgroundDataTransferRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AuthSessionStateEnum authSessionState, TransferRequestTypeEnum transferRequestType)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setTransferRequestType(transferRequestType);
	}
	
	@Override
	public TransferRequestTypeEnum getTransferRequestType() 
	{
		if(transferRequestType == null)
			return null;
		
		return transferRequestType.getEnumerated(TransferRequestTypeEnum.class);
	}

	@Override
	public void setTransferRequestType(TransferRequestTypeEnum value) 
	{
		if(value == null)
			throw new IllegalArgumentException("Transfer-Request-Type is required");
		
		this.transferRequestType = new TransferRequestTypeImpl(value, null, null);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}

	@Override
	public String getApplicationServiceProviderIdentity() 
	{
		if(applicationServiceProviderIdentity == null)
			return null;
		
		return applicationServiceProviderIdentity.getString();
	}

	@Override
	public void setApplicationServiceProviderIdentity(String value) 
	{
		if(value == null)
			this.applicationServiceProviderIdentity = null;
		else
			this.applicationServiceProviderIdentity = new ApplicationServiceProviderIdentityImpl(value, null, null);
	}

	@Override
	public Long getCCOutputOctets()
	{
		if(ccOutputOctets==null)
			return null;
		
		return ccOutputOctets.getLong();
	}
	
	@Override
	public void setCCOutputOctets(Long value)
	{
		if(value == null)
			this.ccOutputOctets = null;
		else
			this.ccOutputOctets = new CcOutputOctetsImpl(value, null, null);
	}

	@Override
	public Long getCCInputOctets()
	{
		if(ccInputOctets==null)
			return null;
		
		return ccInputOctets.getLong();
	}
	
	@Override
	public void setCCInputOctets(Long value)
	{
		if(value == null)
			this.ccInputOctets = null;
		else
			this.ccInputOctets = new CcInputOctetsImpl(value, null, null);
	}

	@Override
	public Long getCCTotalOctets()
	{
		if(ccTotalOctets==null)
			return null;
		
		return ccTotalOctets.getLong();
	}
	
	@Override
	public void setCCTotalOctets(Long value)
	{
		if(value == null)
			this.ccTotalOctets = null;
		else
			this.ccTotalOctets = new CcTotalOctetsImpl(value, null, null);
	}
	 
	@Override
	public Long getNumberOfUEs()
	{
		if(numberOfUEs==null)
			return null;

		return numberOfUEs.getUnsigned();
	}

	@Override
	public void setNumberOfUEs(Long value)
	{
		if(value == null)
			this.numberOfUEs = null;
		else
			this.numberOfUEs = new NumberOfUEsImpl(value, null, null);
	}
	
	@Override
	public TimeWindow getTimeWindow()
	{
		return this.timeWindow;
	}
	
	@Override
	public void setTimeWindow(TimeWindow value)
	{
		this.timeWindow = value;
	}
	
	@Override
	public ByteBuf getNetworkAreaInfoList() 
	{
		if(networkAreaInfoList==null)
			return null;
		
		return networkAreaInfoList.getValue();
	}
	
	@Override
	public void setNetworkAreaInfoList(ByteBuf value)
	{
		if(value == null)
			this.networkAreaInfoList = null;
		else
			this.networkAreaInfoList = new NetworkAreaInfoListImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getReferenceId() 
	{
		if(referenceId==null)
			return null;
		
		return referenceId.getValue();
	}
	
	@Override
	public void setReferenceId(ByteBuf value)
	{
		if(value == null)
			this.referenceId = null;
		else
			this.referenceId = new ReferenceIdImpl(value, null, null);
	}
	 
	@Override
	public Long getTransferPolicyId()
	{
		if(transferPolicyId==null)
			return null;

		return transferPolicyId.getUnsigned();
	}

	@Override
	public void setTransferPolicyId(Long value)
	{
		if(value == null)
			this.transferPolicyId = null;
		else
			this.transferPolicyId = new TransferPolicyIdImpl(value, null, null);
	}
    
	@DiameterValidate
	public String validate()
	{
		if(transferRequestType == null)
			return "Transfer-Request-Type is required";
		
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
		result.add(destinationRealm);
		result.add(transferRequestType);
		result.add(destinationHost);
		result.add(ocSupportedFeatures);
		result.add(applicationServiceProviderIdentity);
		result.add(ccOutputOctets);
		result.add(ccInputOctets);
		result.add(ccTotalOctets);
		result.add(numberOfUEs);
		result.add(timeWindow);
		result.add(networkAreaInfoList);
		result.add(referenceId);
		result.add(transferPolicyId);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}