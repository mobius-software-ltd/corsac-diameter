package com.mobius.software.telco.protocols.diameter.impl.commands.ro;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.ro.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LowBalanceIndicationImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LowBalanceIndication;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LowBalanceIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RemainingBalance;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
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
@DiameterCommandImplementation(applicationId = 4, commandCode = 272, request = false)
public class CreditControlAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.CreditControlAnswerImpl implements CreditControlAnswer
{
	private LowBalanceIndication lowBalanceIndication;
	
	private RemainingBalance remainingBalance;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private ServiceInformation serviceInformation;
	
	protected CreditControlAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(true);
		setOriginStateIdAllowedAllowed(false);
		
		setCCSubSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setEventTimestampAllowed(false);
		setGrantedServiceUnitAllowed(false);	
		setFinalUnitIndicationAllowed(false);
		setQosFinalUnitIndicationAllowedAllowed(false);
		setCheckBalanceResultAllowed(false);
		setValidityTimeAllowed(false);
		
		setUsernameAllowed(false);
	}
	
	public CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, ccRequestType, ccRequestNumber);
		setExperimentalResultAllowed(true);
		setOriginStateIdAllowedAllowed(false);
		
		setCCSubSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setEventTimestampAllowed(false);
		setGrantedServiceUnitAllowed(false);	
		setFinalUnitIndicationAllowed(false);
		setQosFinalUnitIndicationAllowedAllowed(false);
		setCheckBalanceResultAllowed(false);
		setValidityTimeAllowed(false);
		
		setUsernameAllowed(false);
	}
	
	protected CreditControlAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId, ccRequestType, ccRequestNumber);
		setExperimentalResultAllowed(true);
		setOriginStateIdAllowedAllowed(false);
		
		setCCSubSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setEventTimestampAllowed(false);
		setGrantedServiceUnitAllowed(false);	
		setFinalUnitIndicationAllowed(false);
		setQosFinalUnitIndicationAllowedAllowed(false);
		setCheckBalanceResultAllowed(false);
		setValidityTimeAllowed(false);
		
		setUsernameAllowed(false);
	}
	
	public LowBalanceIndicationEnum getLowBalanceIndication()
	{
		if(lowBalanceIndication==null)
			return null;
		
		return lowBalanceIndication.getEnumerated(LowBalanceIndicationEnum.class);
	}
	
	public void setLowBalanceIndication(LowBalanceIndicationEnum value)
	{
		if(value==null)
			this.lowBalanceIndication = null;
		else
			this.lowBalanceIndication = new LowBalanceIndicationImpl(value, null, null);
	}
	
	public RemainingBalance getRemainingBalance()
	{
		return this.remainingBalance;
	}
	
	public void setRemainingBalance(RemainingBalance value)
	{
		this.remainingBalance = value;
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
	}
	
	public ServiceInformation getServiceInformation()
	{
		return this.serviceInformation;
	}
	
	public void setServiceInformation(ServiceInformation value)
	{
		this.serviceInformation = value;
	}
}