package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctMultiSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSessionFailoverImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSubSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CheckBalanceResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CreditControlFailureHandlingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.DirectDebitingFailureHandlingImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ValidityTimeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctMultiSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestType;
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
@DiameterCommandImplementation(applicationId = 4, commandCode = 272, request = false)
public class CreditControlAnswerImpl extends AuthenticationAnswerImpl implements CreditControlAnswer
{
	protected CcRequestType ccRequestType;
	
	protected CcRequestNumber ccRequestNumber;
	
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
	
	public CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, 4L);
		setExperimentalResultAllowed(false);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);
	}
	
	//for overriding with different auth application ID
	protected CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
		setExperimentalResultAllowed(false);
		
		setCcRequestType(ccRequestType);
		
		setCcRequestNumber(ccRequestNumber);
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
	public CcRequestTypeEnum getCcRequestType() 
	{
		if(ccRequestType==null)
			return null;
		
		return ccRequestType.getEnumerated(CcRequestTypeEnum.class);
	}

	@Override
	public void setCcRequestType(CcRequestTypeEnum value) 
	{
		if(value==null)
			throw new IllegalArgumentException("CC-Request-Type is required");
		
		this.ccRequestType = new CcRequestTypeImpl(value, null, null);
	}

	@Override
	public Long getCcRequestNumber() 
	{
		if(ccRequestNumber==null)
			return null;
		
		return ccRequestNumber.getUnsigned();
	}

	@Override
	public void setCcRequestNumber(Long value) 
	{
		if(value==null)
			throw new IllegalArgumentException("CC-Request-Number is required");	
		
		this.ccRequestNumber = new CcRequestNumberImpl(value, null, null);
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
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(this.ccSubSessionId==null)
			return null;
		
		return this.ccSubSessionId.getLong();
	}

	@Override
	public void setCcSubSessionId(Long value) throws AvpNotSupportedException
	{
		if(!ccSubSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value == null)
			this.ccSubSessionId = null;
		else
			this.ccSubSessionId = new CcSubSessionIdImpl(value, null, null);
	}

	@Override
	public String getAcctMultiSessionId() throws AvpNotSupportedException
	{
		if(!acctMultiSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(this.acctMultiSessionId == null)
			return null;
		
		return this.acctMultiSessionId.getString();
	}

	@Override
	public void setAcctMultiSessionId(String value) throws AvpNotSupportedException
	{
		if(!acctMultiSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value == null)
			this.acctMultiSessionId = null;
		else
			this.acctMultiSessionId = new AcctMultiSessionIdImpl(value, null, null);			
	}
	
	@Override
	public Date getEventTimestamp() throws AvpNotSupportedException
	{
		if(!eventTimestampAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(eventTimestamp == null)
			return null;
		
		return eventTimestamp.getDateTime();
	}

	@Override
	public void setEventTimestamp(Date value) throws AvpNotSupportedException 
	{
		if(!eventTimestampAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value == null)
			this.eventTimestamp = null;
		else
			this.eventTimestamp = new EventTimestampImpl(value, null, null);
	}	
	
	@Override
	public GrantedServiceUnit getGrantedServiceUnit() throws AvpNotSupportedException
	{
		if(!grantedServiceUnitAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		return grantedServiceUnit;
	}

	@Override
	public void setGrantedServiceUnit(GrantedServiceUnit value) throws AvpNotSupportedException 
	{
		if(!grantedServiceUnitAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
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
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		return finalUnitIndication;
	}

	@Override
	public void setFinalUnitIndication(FinalUnitIndication value) throws AvpNotSupportedException
	{
		if(!finalUnitIndicationAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		this.finalUnitIndication = value;
	}
	
	@Override
	public QoSFinalUnitIndication getQosFinalUnitIndication() throws AvpNotSupportedException
	{
		if(!qosFinalUnitIndicationAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		return qosFinalUnitIndication;
	}

	@Override
	public void setQosFinalUnitIndication(QoSFinalUnitIndication value) throws AvpNotSupportedException
	{
		if(!qosFinalUnitIndicationAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		this.qosFinalUnitIndication = value;
	}
	
	@Override
	public CheckBalanceResultEnum getCheckBalanceResult() throws AvpNotSupportedException 
	{
		if(!checkBalanceResultAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(checkBalanceResult==null)
			return null;
		
		return checkBalanceResult.getEnumerated(CheckBalanceResultEnum.class);
	}

	@Override
	public void setCheckBalanceResult(CheckBalanceResultEnum value) throws AvpNotSupportedException 
	{
		if(!checkBalanceResultAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
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

	@Override
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

	@Override
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
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(validityTime == null)
			return null;
		
		return validityTime.getUnsigned();
	}

	@Override
	public void setValidityTime(Long value) throws AvpNotSupportedException
	{
		if(!validityTimeAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value == null)
			this.validityTime = null;
		else
			this.validityTime = new ValidityTimeImpl(value, null, null);
	}

	@Override
	public List<String> getRouteRecords() throws AvpNotSupportedException 
	{
		if(!routeRecordsAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
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
		if(!routeRecordsAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
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
	public String validate()
	{
		if(ccRequestType==null)
			return "CC-Request-Type is required";
		
		if(ccRequestNumber==null)
			return "CC-Request-Number is required";
		
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
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}