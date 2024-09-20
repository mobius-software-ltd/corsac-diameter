package com.mobius.software.telco.protocols.diameter.app.cip;
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

import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
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

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public VendorSpecificApplicationId getVendorSpecificApplicationId(Long vendorId,Long authApplicationId,Long acctAppicationId) throws AvpOccursTooManyTimesException, MissingAvpException;
	
	public CostInformation getCostInformation(UnitValue unitValue,Long currencyCode) throws MissingAvpException;
	
	public SubscriberInformation getSubscriberInformation();
	
	public MultipleServicesCreditControl getMultipleServicesCreditControl();
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException;
	
	public UsedServiceUnit getUsedServiceUnit();
	
	public RequestedServiceUnit getRequestedServiceUnit();
	
	public GrantedServiceUnit getGrantedServiceUnit();
	
	public FinalUnitIndication getFinalUnitIndication();
	
	public RedirectServer getRedirectServer();
	
	public UserEquipmentInfo getUserEquipmentInfo();
	
	public AccessInformation getAccessInformation();
	
}
