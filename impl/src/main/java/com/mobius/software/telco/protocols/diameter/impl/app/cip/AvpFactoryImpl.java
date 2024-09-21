package com.mobius.software.telco.protocols.diameter.impl.app.cip;
/*
 * Mobius Software LTD
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

import com.mobius.software.telco.protocols.diameter.app.cip.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cip.AccessInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cip.MultipleServicesCreditControlImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cip.SubscriberInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.VendorSpecificApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CostInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.FinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GrantedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RedirectServerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RequestedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UsedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UserEquipmentInfoImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cip.AccessInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cip.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.cip.SubscriberInformation;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public VendorSpecificApplicationId getVendorSpecificApplicationId(Long vendorId,Long authApplicationId,Long acctAppicationId) throws AvpOccursTooManyTimesException, MissingAvpException
	{
		return new VendorSpecificApplicationIdImpl(vendorId, authApplicationId, acctAppicationId);
	}
	
	public CostInformation getCostInformation(UnitValue unitValue,Long currencyCode) throws MissingAvpException
	{
		return new CostInformationImpl(unitValue,currencyCode);
	}
	
	public SubscriberInformation getSubscriberInformation()
	{
		return new SubscriberInformationImpl();
	}
	
	public MultipleServicesCreditControl getMultipleServicesCreditControl()
	{
		return new MultipleServicesCreditControlImpl();
	}
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public UsedServiceUnit getUsedServiceUnit()
	{
		return new UsedServiceUnitImpl();
	}
	
	public RequestedServiceUnit getRequestedServiceUnit()
	{
		return new RequestedServiceUnitImpl();
	}
	
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return new GrantedServiceUnitImpl();
	}
	
	public FinalUnitIndication getFinalUnitIndication() 
	{
		return new FinalUnitIndicationImpl();
	}
	
	public RedirectServer getRedirectServer()
	{
		return new RedirectServerImpl();
	}
	
	public UserEquipmentInfo getUserEquipmentInfo()
	{
		return new UserEquipmentInfoImpl();
	}
	
	public AccessInformation getAccessInformation()
	{
		return new AccessInformationImpl();
	}
}
