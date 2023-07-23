package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol;

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterAnswerWithSessionBase;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctMultiSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AuthApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.EventTimestampImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSessionFailoverImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSubSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctMultiSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.common.EventTimestamp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailover;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSessionFailoverEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSubSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.QoSFinalUnitIndication;

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
@DiameterCommandImplementation(applicationId = -1, commandCode = 272, request = false)
public class CreditControlAnswerImpl extends DiameterAnswerWithSessionBase implements CreditControlAnswer
{
	private AuthApplicationId authApplicationId;
	
	private CcRequestType ccRequestType;
	
	private CcRequestNumber ccRequestNumber;
	
	private CcSessionFailover ccSessionFailover;
	
	private CcSubSessionId ccSubSessionId;
	
	private AcctMultiSessionId acctMultiSessionId;
	
	private EventTimestamp eventTimestamp;
	
	private GrantedServiceUnit grantedServiceUnit;
	
	private List<MultipleServicesCreditControl> multipleServicesCreditControl;
	
	private CostInformation costInformation;
	
	private FinalUnitIndication finalUnitIndication;
	
	private QoSFinalUnitIndication qosFinalUnitIndication;
	
	protected CreditControlAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		setExperimentalResultAllowed(false);
		
		authApplicationId = new AuthApplicationIdImpl(4L, null, null);
		
		if(ccRequestType==null)
			throw new IllegalArgumentException("CC-Request-Type is required");
		
		if(ccRequestNumber==null)
			throw new IllegalArgumentException("CC-Request-Number is required");	
		
		this.ccRequestType = new CcRequestTypeImpl(ccRequestType, null, null);
		
		this.ccRequestNumber = new CcRequestNumberImpl(ccRequestNumber, null, null);
	}
	
	//for overriding with different auth application ID
	protected CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		setExperimentalResultAllowed(false);
		
		if(authApplicationId==null)			
			this.authApplicationId = new AuthApplicationIdImpl(4L, null, null);
		else
			this.authApplicationId = new AuthApplicationIdImpl(authApplicationId, null, null);
		
		if(ccRequestType==null)
			throw new IllegalArgumentException("CC-Request-Type is required");
		
		if(ccRequestNumber==null)
			throw new IllegalArgumentException("CC-Request-Number is required");	
		
		this.ccRequestType = new CcRequestTypeImpl(ccRequestType, null, null);
		
		this.ccRequestNumber = new CcRequestNumberImpl(ccRequestNumber, null, null);
	}

	@Override
	public Long getAuthApplicationId() 
	{
		if(authApplicationId==null)
			return null;
		
		return authApplicationId.getUnsigned();
	}

	@Override
	public CcRequestTypeEnum getCcRequestType() 
	{
		if(ccRequestType==null)
			return null;
		
		return ccRequestType.getEnumerated(CcRequestTypeEnum.class);
	}

	@Override
	public void setCcRequestType(CcRequestTypeEnum ccRequestType) 
	{
		if(ccRequestType==null)
			throw new IllegalArgumentException("CC-Request-Type is required");
		
		this.ccRequestType = new CcRequestTypeImpl(ccRequestType, null, null);
	}

	@Override
	public Long getCcRequestNumber() 
	{
		if(ccRequestNumber==null)
			return null;
		
		return ccRequestNumber.getUnsigned();
	}

	@Override
	public void setCcRequestNumber(Long ccRequestNumber) 
	{
		if(ccRequestNumber==null)
			throw new IllegalArgumentException("CC-Request-Number is required");	
		
		this.ccRequestNumber = new CcRequestNumberImpl(ccRequestNumber, null, null);
	}
	
	@Override
	public CcSessionFailoverEnum getCcSessionFailover() 
	{
		if(ccSessionFailover==null)
			return null;
		
		return ccSessionFailover.getEnumerated(CcSessionFailoverEnum.class);
	}

	@Override
	public void setCcSessionFailover(CcSessionFailoverEnum ccSessionFailover) 
	{
		if(ccRequestType==null)
			this.ccSessionFailover = null;
		else
			this.ccSessionFailover = new CcSessionFailoverImpl(ccSessionFailover, null, null);
	}
		    
	@Override
	public Long getCcSubSessionId() throws AvpNotSupportedException
	{
		if(this.ccSubSessionId==null)
			return null;
		
		return this.ccSubSessionId.getLong();
	}

	@Override
	public void setCcSubSessionId(Long value) throws AvpNotSupportedException
	{
		if(value == null)
			this.ccSubSessionId = null;
		else
			this.ccSubSessionId = new CcSubSessionIdImpl(value, null, null);
	}

	@Override
	public String getAcctMultiSessionId() throws AvpNotSupportedException
	{
		if(this.acctMultiSessionId == null)
			return null;
		
		return this.acctMultiSessionId.getString();
	}

	@Override
	public void setAcctMultiSessionId(String value) throws AvpNotSupportedException
	{
		if(value == null)
			this.acctMultiSessionId = null;
		else
			this.acctMultiSessionId = new AcctMultiSessionIdImpl(value, null, null);			
	}
	
	@Override
	public Date getEventTimestamp() 
	{
		if(eventTimestamp == null)
			return null;
		
		return eventTimestamp.getDateTime();
	}

	@Override
	public void setEventTimestamp(Date value) 
	{
		if(value == null)
			this.eventTimestamp = null;
		else
			this.eventTimestamp = new EventTimestampImpl(value, null, null);
	}	
	
	@Override
	public GrantedServiceUnit getGrantedServiceUnit() 
	{
		return grantedServiceUnit;
	}

	@Override
	public void setGrantedServiceUnit(GrantedServiceUnit value) 
	{
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
	public FinalUnitIndication getFinalUnitIndication() 
	{
		return finalUnitIndication;
	}

	@Override
	public void setFinalUnitIndication(FinalUnitIndication value) 
	{
		this.finalUnitIndication = value;
	}
	
	@Override
	public QoSFinalUnitIndication getQoSFinalUnitIndication() 
	{
		return qosFinalUnitIndication;
	}

	@Override
	public void setQoSFinalUnitIndication(QoSFinalUnitIndication value) 
	{
		this.qosFinalUnitIndication = value;
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
}