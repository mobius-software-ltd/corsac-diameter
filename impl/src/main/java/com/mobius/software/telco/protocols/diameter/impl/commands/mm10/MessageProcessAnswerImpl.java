package com.mobius.software.telco.protocols.diameter.impl.commands.mm10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.mm10.MessageProcessAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.VendorSpecificAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthSessionStateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.BillingInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.DeliveryReportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.ReadReplyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.mm10.SenderVisibilityImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionState;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.BillingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.DeliveryReport;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.DeliveryReportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ReadReply;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ReadReplyEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.ResultRecipientAddress;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SenderVisibility;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.SenderVisibilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.mm10.Status;

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
public class MessageProcessAnswerImpl extends VendorSpecificAnswerImpl implements MessageProcessAnswer
{
	private AuthSessionState authSessionState;
	
	private Status status;
	
	private List<ResultRecipientAddress> resultRecipientAddress;
	
	private DeliveryReport deliveryReport;
	
	private ReadReply readReply;
	
	private BillingInformation billingInformation;
	
	private SenderVisibility senderVisibility;
	
	protected List<RouteRecord> routeRecords;
	
	protected MessageProcessAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(true);
		setOriginStateIdAllowedAllowed(false);
		setUsernameAllowed(false);
	}
	
	protected MessageProcessAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		setExperimentalResultAllowed(true);
		setOriginStateIdAllowedAllowed(false);
		setUsernameAllowed(false);
		
		setAuthSessionState(authSessionState);
	}
	
	@Override
	public AuthSessionStateEnum getAuthSessionState() 
	{
		if(authSessionState==null)
			return null;
		
		return authSessionState.getEnumerated(AuthSessionStateEnum.class);
	}

	@Override
	public void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException 
	{
		if(value==null)
			throw new MissingAvpException("Auth-Session-State is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
			
		this.authSessionState = new AuthSessionStateImpl(value, null, null);
	}
	
	@Override
	public Status getStatus()
	{
		return this.status;
	}
	
	@Override
	public void setStatus(Status value)
	{
		this.status = value;
	}
	
	@Override
	public List<ResultRecipientAddress> getResultRecipientAddress()
	{
		return this.resultRecipientAddress;
	}
	
	@Override
	public void setResultRecipientAddress(List<ResultRecipientAddress> value)
	{
		this.resultRecipientAddress = value;
	}
	
	@Override
	public DeliveryReportEnum getDeliveryReport()
	{
		if(this.deliveryReport==null)
			return null;
		
		return this.deliveryReport.getEnumerated(DeliveryReportEnum.class);
	}
	
	@Override
	public void setDeliveryReport(DeliveryReportEnum value)
	{
		if(value == null)
			this.deliveryReport = null;
		else
			this.deliveryReport = new DeliveryReportImpl(value, null, null);
	}
	
	@Override
	public ReadReplyEnum getReadReply()
	{
		if(this.readReply==null)
			return null;
		
		return this.readReply.getEnumerated(ReadReplyEnum.class);
	}
	
	@Override
	public void setReadReply(ReadReplyEnum value)
	{
		if(value == null)
			this.readReply = null;
		else
			this.readReply = new ReadReplyImpl(value, null, null);
	}
	
	@Override
	public String getBillingInformation()
	{
		if(this.billingInformation==null)
			return null;
		
		return this.billingInformation.getString();
	}
	
	@Override
	public void setBillingInformation(String value)
	{
		if(value == null)
			this.billingInformation = null;
		else
			this.billingInformation = new BillingInformationImpl(value, null, null);
	}
	
	@Override
	public SenderVisibilityEnum getSenderVisibility()
	{
		if(this.senderVisibility==null)
			return null;
		
		return this.senderVisibility.getEnumerated(SenderVisibilityEnum.class);
	}
	
	@Override
	public void setSenderVisibility(SenderVisibilityEnum value)
	{
		if(value == null)
			this.senderVisibility = null;
		else
			this.senderVisibility = new SenderVisibilityImpl(value, null, null);
	}

	@Override
	public List<String> getRouteRecords() 
	{
		if(this.routeRecords==null)
			return null;
		else
		{
			List<String> result = new ArrayList<String>();
			for(RouteRecord curr:routeRecords)
				result.add(curr.getIdentity());
			
			return result;
		}
	}

	@Override
	public void setRouteRecords(List<String> value)
	{
		if(value == null || value.size()==0)
			this.routeRecords = null;
		else
		{
			this.routeRecords = new ArrayList<RouteRecord>();
			for(String curr:value)
				this.routeRecords.add(new RouteRecordImpl(curr, null, null));
		}
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(authSessionState==null)
			return new MissingAvpException("Auth-Session-State is required", Arrays.asList(new DiameterAvp[] { new AuthSessionStateImpl() }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(vendorSpecificApplicationId);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(status);
		
		if(resultRecipientAddress!=null)
			result.addAll(resultRecipientAddress);
		
		result.add(deliveryReport);
		result.add(readReply);
		result.add(billingInformation);
		result.add(senderVisibility);
		
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