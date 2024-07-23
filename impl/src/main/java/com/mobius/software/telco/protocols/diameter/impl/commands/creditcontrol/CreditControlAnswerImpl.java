package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctMultiSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSessionFailoverImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSubSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CheckBalanceResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CreditControlFailureHandlingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.DirectDebitingFailureHandlingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.FinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GrantedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.QoSFinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ValidityTimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctMultiSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailover;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailoverEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSubSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CheckBalanceResult;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CheckBalanceResultEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandling;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CreditControlFailureHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.DirectDebitingFailureHandling;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.DirectDebitingFailureHandlingEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.QoSFinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ValidityTime;

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
public class CreditControlAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.CreditControlAnswerImpl implements CreditControlAnswer
{
	protected CcSessionFailover ccSessionFailover;
	
	protected CcSubSessionId ccSubSessionId;
	
	protected AcctMultiSessionId acctMultiSessionId;
	
	protected EventTimestamp eventTimestamp;
	
	protected GrantedServiceUnit grantedServiceUnit;
	
	protected List<MultipleServicesCreditControl> multipleServicesCreditControl;
	
	protected CostInformation costInformation;
	
	protected FinalUnitIndication finalUnitIndication;
	
	protected QoSFinalUnitIndication qosFinalUnitIndication;
	
	protected CheckBalanceResult checkBalanceResult;
	
	protected CreditControlFailureHandling creditControlFailureHandling;
	
	protected DirectDebitingFailureHandling directDebitingFailureHandling;
    
	protected ValidityTime validityTime;
	
	protected List<RouteRecord> routeRecords;
	
	private boolean ccSubSessionIdAllowed = true;
	private boolean acctMultiSessionIdAllowed = true;
	private boolean eventTimestampAllowed = true;
	private boolean grantedServiceUnitAllowed = true;
	private boolean finalUnitIndicationAllowed = true;
	private boolean qosFinalUnitIndicationAllowed = true;
	private boolean checkBalanceResultAllowed = true;
	private boolean validityTimeAllowed = true;
	private boolean routeRecordsAllowed = true;
	
	protected CreditControlAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, 4L, ccRequestType, ccRequestNumber);
		setExperimentalResultAllowed(false);
	}
	
	//for overriding with different auth application ID
	public CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId, ccRequestType, ccRequestNumber);
		setExperimentalResultAllowed(false);
	}

	protected void setCCSubSessionIdAllowed(boolean allowed) 
	{
		this.ccSubSessionIdAllowed = allowed;
	}
	
	protected void setAcctMultiSessionIdAllowed(boolean allowed) 
	{
		this.acctMultiSessionIdAllowed = allowed;
	}
	
	protected void setEventTimestampAllowed(boolean allowed) 
	{
		this.eventTimestampAllowed = allowed;
	}
	
	protected void setGrantedServiceUnitAllowed(boolean allowed) 
	{
		this.grantedServiceUnitAllowed = allowed;
	}
	
	protected void setFinalUnitIndicationAllowed(boolean allowed) 
	{
		this.finalUnitIndicationAllowed = allowed;
	}
	
	protected void setQosFinalUnitIndicationAllowedAllowed(boolean allowed) 
	{
		this.qosFinalUnitIndicationAllowed = allowed;
	}
	
	protected void setCheckBalanceResultAllowed(boolean allowed) 
	{
		this.checkBalanceResultAllowed = allowed;
	}
	
	protected void setValidityTimeAllowed(boolean allowed) 
	{
		this.validityTimeAllowed = allowed;
	}
	
	protected void setRouteRecordsAllowed(boolean allowed) 
	{
		this.routeRecordsAllowed = allowed;
	}
	
	@Override
	public CcSessionFailoverEnum getCcSessionFailover() 
	{
		if(ccSessionFailover==null)
			return null;
		
		return ccSessionFailover.getEnumerated(CcSessionFailoverEnum.class);
	}

	@Override
	public void setCcSessionFailover(CcSessionFailoverEnum value) 
	{
		if(value==null)
			this.ccSessionFailover = null;
		else
			this.ccSessionFailover = new CcSessionFailoverImpl(value, null, null);
	}
		    
	@Override
	public Long getCcSubSessionId() throws AvpNotSupportedException
	{
		if(!ccSubSessionIdAllowed)
			throw new AvpNotSupportedException("CC-Request-Number is required", Arrays.asList(new DiameterAvp[] { new CcSubSessionIdImpl() } ));
		
		if(this.ccSubSessionId==null)
			return null;
		
		return this.ccSubSessionId.getLong();
	}

	@Override
	public void setCcSubSessionId(Long value) throws AvpNotSupportedException
	{
		if(!ccSubSessionIdAllowed && value != null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new CcSubSessionIdImpl(value, null, null) } ));
		
		if(value == null)
			this.ccSubSessionId = null;
		else
			this.ccSubSessionId = new CcSubSessionIdImpl(value, null, null);
	}

	@Override
	public String getAcctMultiSessionId() throws AvpNotSupportedException
	{
		if(!acctMultiSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AcctMultiSessionIdImpl() } ));
			
		if(this.acctMultiSessionId == null)
			return null;
		
		return this.acctMultiSessionId.getString();
	}

	@Override
	public void setAcctMultiSessionId(String value) throws AvpNotSupportedException
	{
		if(!acctMultiSessionIdAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new AcctMultiSessionIdImpl(value, null, null) } ));
			
		if(value == null)
			this.acctMultiSessionId = null;
		else
			this.acctMultiSessionId = new AcctMultiSessionIdImpl(value, null, null);			
	}
	
	@Override
	public Date getEventTimestamp() throws AvpNotSupportedException
	{
		if(!eventTimestampAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new EventTimestampImpl() } ));
		
		if(eventTimestamp == null)
			return null;
		
		return eventTimestamp.getDateTime();
	}

	@Override
	public void setEventTimestamp(Date value) throws AvpNotSupportedException 
	{
		if(!eventTimestampAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new EventTimestampImpl(value, null, null) } ));			
		
		if(value == null)
			this.eventTimestamp = null;
		else
			this.eventTimestamp = new EventTimestampImpl(value, null, null);
	}	
	
	@Override
	public GrantedServiceUnit getGrantedServiceUnit() throws AvpNotSupportedException
	{
		if(!grantedServiceUnitAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new GrantedServiceUnitImpl() } ));
		
		return grantedServiceUnit;
	}

	@Override
	public void setGrantedServiceUnit(GrantedServiceUnit value) throws AvpNotSupportedException 
	{
		if(!grantedServiceUnitAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { value } ));			
		
		this.grantedServiceUnit = value;
	}	
	
	@Override
	public List<MultipleServicesCreditControl> getMultipleServicesCreditControl() 
	{
		return multipleServicesCreditControl;
	}

	@Override
	public void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> value) 
	{
		this.multipleServicesCreditControl = value;
	}
	
	@Override
	public CostInformation getCostInformation() 
	{
		return costInformation;
	}

	@Override
	public void setCostInformation(CostInformation value) 
	{
		this.costInformation = value;
	}
	
	@Override
	public FinalUnitIndication getFinalUnitIndication() throws AvpNotSupportedException
	{
		if(!finalUnitIndicationAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new FinalUnitIndicationImpl() } ));
		
		return finalUnitIndication;
	}

	@Override
	public void setFinalUnitIndication(FinalUnitIndication value) throws AvpNotSupportedException
	{
		if(!finalUnitIndicationAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { value } ));			
		
		this.finalUnitIndication = value;
	}
	
	@Override
	public QoSFinalUnitIndication getQosFinalUnitIndication() throws AvpNotSupportedException
	{
		if(!qosFinalUnitIndicationAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new QoSFinalUnitIndicationImpl() } ));
		
		return qosFinalUnitIndication;
	}

	@Override
	public void setQosFinalUnitIndication(QoSFinalUnitIndication value) throws AvpNotSupportedException
	{
		if(!qosFinalUnitIndicationAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { value } ));			
		
		this.qosFinalUnitIndication = value;
	}
	
	@Override
	public CheckBalanceResultEnum getCheckBalanceResult() throws AvpNotSupportedException 
	{
		if(!checkBalanceResultAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new CheckBalanceResultImpl() } ));
		
		if(checkBalanceResult==null)
			return null;
		
		return checkBalanceResult.getEnumerated(CheckBalanceResultEnum.class);
	}

	@Override
	public void setCheckBalanceResult(CheckBalanceResultEnum value) throws AvpNotSupportedException 
	{
		if(!checkBalanceResultAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new CheckBalanceResultImpl(value, null, null) } ));			
		
		if(value==null)
			this.checkBalanceResult = null;
		else
			this.checkBalanceResult = new CheckBalanceResultImpl(value, null, null);
	}
	
	@Override
	public CreditControlFailureHandlingEnum getCreditControlFailureHandling() 
	{
		if(creditControlFailureHandling==null)
			return null;
		
		return creditControlFailureHandling.getEnumerated(CreditControlFailureHandlingEnum.class);
	}

	
	
	public void setCreditControlFailureHandling(CreditControlFailureHandlingEnum value) 
	{
		if(value==null)
			this.creditControlFailureHandling = null;
		else
			this.creditControlFailureHandling = new CreditControlFailureHandlingImpl(value, null, null);
	}
	
	@Override
	public DirectDebitingFailureHandlingEnum getDirectDebitingFailureHandling() 
	{
		if(directDebitingFailureHandling==null)
			return null;
		
		return directDebitingFailureHandling.getEnumerated(DirectDebitingFailureHandlingEnum.class);
	}

	
	public void setDirectDebitingFailureHandling(DirectDebitingFailureHandlingEnum value) 
	{
		if(value==null)
			this.directDebitingFailureHandling = null;
		else
			this.directDebitingFailureHandling = new DirectDebitingFailureHandlingImpl(value, null, null);
	}
	
	@Override
	public Long getValidityTime() throws AvpNotSupportedException
	{
		if(!validityTimeAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new ValidityTimeImpl() } ));
		
		if(validityTime == null)
			return null;
		
		return validityTime.getUnsigned();
	}

	@Override
	public void setValidityTime(Long value) throws AvpNotSupportedException
	{
		if(!validityTimeAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new ValidityTimeImpl(value, null, null) } ));			
		
		if(value == null)
			this.validityTime = null;
		else
			this.validityTime = new ValidityTimeImpl(value, null, null);
	}

	@Override
	public List<String> getRouteRecords() throws AvpNotSupportedException 
	{
		if(!routeRecordsAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new RouteRecordImpl() } ));
		
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
	public void setRouteRecords(List<String> value) throws AvpNotSupportedException
	{
		if(!routeRecordsAllowed && value!=null && value.size()>0)
		{
			List<DiameterAvp> routeRecords = new ArrayList<DiameterAvp>();
			for(String curr:value)
				routeRecords.add(new RouteRecordImpl(curr, null, null));
				
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", routeRecords );
		}
		
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
		if(!ccSubSessionIdAllowed && ccSubSessionId != null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { ccSubSessionId } ));
		
		if(!acctMultiSessionIdAllowed && acctMultiSessionId!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { acctMultiSessionId } ));
		
		if(!eventTimestampAllowed && eventTimestamp!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { eventTimestamp } ));			
		
		if(!grantedServiceUnitAllowed && grantedServiceUnit!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { grantedServiceUnit } ));			
		
		if(!finalUnitIndicationAllowed && finalUnitIndication!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { finalUnitIndication } ));			
		
		if(!qosFinalUnitIndicationAllowed && qosFinalUnitIndication!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { qosFinalUnitIndication } ));			
		
		if(!checkBalanceResultAllowed && checkBalanceResult!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { checkBalanceResult } ));			
		
		if(!validityTimeAllowed && validityTime!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { validityTime } ));			
		
		if(!routeRecordsAllowed && routeRecords!=null && routeRecords.size()>0)
		{
			List<DiameterAvp> avps=new ArrayList<DiameterAvp>();
			for(RouteRecord curr:routeRecords)
				avps.add(curr);
			
			return new AvpNotSupportedException("This AVP is not supported for select command/application", avps );
		}
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(resultCode);
		result.add(originHost);
		result.add(originRealm);
		result.add(authApplicationId);
		result.add(ccRequestType);
		result.add(ccRequestNumber);
		
		result.add(username);
		result.add(ccSessionFailover);
		result.add(ccSubSessionId);
		result.add(acctMultiSessionId);
		result.add(originStateId);
		result.add(eventTimestamp);
		
		result.add(grantedServiceUnit);
		
		if(multipleServicesCreditControl!=null)
			result.addAll(multipleServicesCreditControl);
		
		result.add(costInformation);
		result.add(finalUnitIndication);
		result.add(qosFinalUnitIndication);
		result.add(checkBalanceResult);
		result.add(creditControlFailureHandling);
		result.add(directDebitingFailureHandling);
		result.add(validityTime);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		result.add(failedAvp);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}