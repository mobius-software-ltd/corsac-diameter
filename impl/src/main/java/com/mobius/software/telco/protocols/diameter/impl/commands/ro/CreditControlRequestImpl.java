package com.mobius.software.telco.protocols.diameter.impl.commands.ro;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.ro.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.AoCRequestTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCRequestType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCRequestTypeEnum;
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
@DiameterCommandImplementation(applicationId = 4, commandCode = 272, request = true)
public class CreditControlRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.CreditControlRequestImpl implements CreditControlRequest
{
	private AoCRequestType aocRequestType;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private ServiceInformation serviceInformation;
	
	protected CreditControlRequestImpl() 
	{
		super();
		
		setCCSubSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setSubscriptionIdExtensionAllowed(false);
		setServiceIdentifierAllowed(false);
		setRequestedServiceUnitAllowed(false);
		setUsedServiceUnitAllowed(false);
		setServiceParameterInfoAllowed(false);
		setUserEquipmentInfoExtensionAllowed(false);
	}
	
	public CreditControlRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, String serviceContextId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, serviceContextId, ccRequestType, ccRequestNumber);
		
		setCCSubSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setSubscriptionIdExtensionAllowed(false);
		setServiceIdentifierAllowed(false);
		setRequestedServiceUnitAllowed(false);
		setUsedServiceUnitAllowed(false);
		setServiceParameterInfoAllowed(false);
		setUserEquipmentInfoExtensionAllowed(false);	
	}

	protected CreditControlRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, String serviceContextId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId, serviceContextId, ccRequestType, ccRequestNumber);
		
		setCCSubSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setSubscriptionIdExtensionAllowed(false);
		setServiceIdentifierAllowed(false);
		setRequestedServiceUnitAllowed(false);
		setUsedServiceUnitAllowed(false);
		setServiceParameterInfoAllowed(false);
		setUserEquipmentInfoExtensionAllowed(false);
	}
	
	@Override
	public AoCRequestTypeEnum getAoCRequestType()
	{
		if(this.aocRequestType==null)
			return null;
		
		return aocRequestType.getEnumerated(AoCRequestTypeEnum.class);
	}
	
	@Override
	public void setAoCRequestType(AoCRequestTypeEnum value)
	{
		if(value==null)
			this.aocRequestType = null;
		else
			this.aocRequestType = new AoCRequestTypeImpl(value, null, null);
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return ocSupportedFeatures;
	}
	
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public ServiceInformation getServiceInformation() 
	{
		return this.serviceInformation;
	}

	@Override
	public void setServiceInformation(ServiceInformation value) 
	{
		this.serviceInformation = value;
	}
}