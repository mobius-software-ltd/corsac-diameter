package com.mobius.software.telco.protocols.diameter.impl.commands.rf;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.rf.AccountingRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceContextIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceContextId;

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
@DiameterCommandImplementation(applicationId = 3, commandCode = 271, request = true)
public class AccountingRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AccountingRequestImpl implements AccountingRequest
{
	private ServiceContextId serviceContextId;
	
	private ServiceInformation serviceInformation;
	
	protected AccountingRequestImpl() 
	{
		super();
		setVendorSpecificApplicationIdAllowed(false);
		setAccountingSubSessionIdAllowed(false);
		setAcctSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setAccountingRealtimeRequiredAllowed(false);			
	}
	
	public AccountingRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, accountingRecordType, accountingRecordNumber);
		setVendorSpecificApplicationIdAllowed(false);
		setAccountingSubSessionIdAllowed(false);
		setAcctSessionIdAllowed(false);
		setAcctMultiSessionIdAllowed(false);
		setAccountingRealtimeRequiredAllowed(false);		
	}

	@Override
	public String getServiceContextId()
	{
		if(this.serviceContextId==null)
			return null;
		
		return serviceContextId.getString();
	}
	
	@Override
	public void setServiceContextId(String serviceContextId)
	{
		if(serviceContextId==null)
			this.serviceContextId = null;
		else
			this.serviceContextId = new ServiceContextIdImpl(serviceContextId, null, null);
	}
	
	@Override
	public ServiceInformation getServiceInformation() 
	{
		return this.serviceInformation;
	}

	@Override
	public void setServiceInformation(ServiceInformation serviceInformation) 
	{
		this.serviceInformation = serviceInformation;
	}
}