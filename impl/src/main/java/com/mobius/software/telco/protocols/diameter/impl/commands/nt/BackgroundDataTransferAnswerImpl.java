package com.mobius.software.telco.protocols.diameter.impl.commands.nt;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.nt.BackgroundDataTransferAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nt.ReferenceIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s9a.PCRFAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nt.ReferenceId;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferPolicy;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s9a.PCRFAddress;

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
public class BackgroundDataTransferAnswerImpl extends NtAnswerImpl implements BackgroundDataTransferAnswer
{
	private ReferenceId referenceId;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<TransferPolicy> transferPolicy;
	 
	private PCRFAddress pcrfAddress;
	
	private List<Load> load;
	 
	protected BackgroundDataTransferAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(true);
	}
	
	public BackgroundDataTransferAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(true);
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
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	
	@Override
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
	}
	
	@Override
	public List<TransferPolicy> getTransferPolicy()
	{
		return this.transferPolicy;
	}
	 
	@Override
	public void setTransferPolicy(List<TransferPolicy> value)
	{
		this.transferPolicy = value;
	}
	
	@Override
	public String getPCRFAddress()
	{
		if(pcrfAddress==null)
			return null;
		
		return this.pcrfAddress.getIdentity();
	}
	
	@Override
	public void setPCRFAddress(String value)
	{
		if(value==null)
			this.pcrfAddress = null;
		else
			this.pcrfAddress = new PCRFAddressImpl(value, null, null);
	}
	
	@Override
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
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
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(errorMessage);
		result.add(errorReportingHost);
		result.add(failedAvp);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		result.add(referenceId);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(transferPolicy!=null)
			result.addAll(transferPolicy);
		
		result.add(pcrfAddress);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(load!=null)
			result.addAll(load);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}