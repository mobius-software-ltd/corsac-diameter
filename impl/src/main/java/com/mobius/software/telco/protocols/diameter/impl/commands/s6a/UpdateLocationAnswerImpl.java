package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s6a.UpdateLocationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ErrorDiagnosticImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ResetIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ErrorDiagnostic;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ErrorDiagnosticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ResetID;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ULAFlags;

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
public class UpdateLocationAnswerImpl extends S6aAnswerImpl implements UpdateLocationAnswer
{
	private ErrorDiagnostic errorDiagnostic;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	private ULAFlags ulaFlags;
	
	private SubscriptionData subscriptionData;
	
	private List<ResetID> resetID;
	
	protected UpdateLocationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public UpdateLocationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
		
	@Override
	public ErrorDiagnosticEnum getErrorDiagnostic()
	{
		if(errorDiagnostic==null)
			return null;
	
		return errorDiagnostic.getEnumerated(ErrorDiagnosticEnum.class);
	}
	
	@Override
	public void setErrorDiagnostic(ErrorDiagnosticEnum value)
	{
		if(value==null)
			this.errorDiagnostic = null;
		else
			this.errorDiagnostic = new ErrorDiagnosticImpl(value, null, null);
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
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@Override
	public ULAFlags getULAFlags()
	{
		return ulaFlags;
	}
	
	@Override
	public void setULAFlags(ULAFlags value)
	{
		this.ulaFlags = value;
	}
	
	@Override
	public SubscriptionData getSubscriptionData() 
	{
		return subscriptionData;
	}
	
	@Override
	public void setSubscriptionData(SubscriptionData value)
	{
		this.subscriptionData = value;
	}
	 		
	@Override
	public List<ByteBuf> getResetID()
	{
		if(resetID==null || resetID.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(ResetID curr: resetID)
			result.add(curr.getValue());
		
		return result;
	}
	 
	@Override
	public void setResetID(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.resetID = null;
		else
		{	
			this.resetID = new ArrayList<ResetID>();
			for(ByteBuf curr:value)
				this.resetID.add(new ResetIDImpl(curr, null, null));
		}
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(errorDiagnostic);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(load!=null)
			result.addAll(load);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(ulaFlags);
		result.add(subscriptionData);
		
		if(resetID!=null)
			result.addAll(resetID);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		return result;
	}
}