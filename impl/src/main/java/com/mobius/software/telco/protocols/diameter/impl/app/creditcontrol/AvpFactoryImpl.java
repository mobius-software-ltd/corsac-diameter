package com.mobius.software.telco.protocols.diameter.impl.app.creditcontrol;
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

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.app.creditcontrol.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CCMoneyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CostInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.FinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GSUPoolReferenceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GrantedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.MultipleServicesCreditControlImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.QoSFinalUnitIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RedirectServerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RequestedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RestrictionFilterRuleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceParameterInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdExtensionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UnitValueImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UsedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UserEquipmentInfoExtensionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UserEquipmentInfoImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpAction;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleAddress;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleDirection;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIcmpType;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIpOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRulePorts;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpFlag;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpOption;
import com.mobius.software.telco.protocols.diameter.primitives.InternetProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CCMoney;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcUnitTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CostInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GSUPoolReference;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.QoSFinalUnitIndication;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectAddressTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RequestedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RestrictionFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceParameterInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdExtension;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.TariffChangeUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoTypeEnum;

import io.netty.buffer.ByteBuf;


public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public UserEquipmentInfoExtension getUserEquipmentInfoExtension(ByteBuf imeiSV,ByteBuf mac,ByteBuf eui64,ByteBuf modifiedEUI64,ByteBuf imei)
	{
		return new UserEquipmentInfoExtensionImpl(imeiSV, mac, eui64, modifiedEUI64, imei);
	}
	
	public UserEquipmentInfo getUserEquipmentInfo(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue)
	{
		return new UserEquipmentInfoImpl(userEquipmentInfoType, userEquipmentInfoValue);
	}
	
	public ServiceParameterInfo getServiceParameterInfo(Long serviceParameterType,ByteBuf serviceParameterValue)
	{
		return new ServiceParameterInfoImpl(serviceParameterType, serviceParameterValue);
	}
	
	public MultipleServicesCreditControl getMultipleServicesCreditControl(GrantedServiceUnit grantedServiceUnit, RequestedServiceUnit requestedServiceUnit, List<UsedServiceUnit> usedServiceUnit, TariffChangeUsageEnum tariffChangeUsage, List<Long> serviceIdentifier, Long ratingGroup, List<GSUPoolReference> gsuPoolReference, Long validityTime, Long resultCode, FinalUnitIndication finalUnitIndication,QoSFinalUnitIndication qosFinalUnitIndication)
	{
		return new MultipleServicesCreditControlImpl(grantedServiceUnit, requestedServiceUnit, usedServiceUnit, tariffChangeUsage, serviceIdentifier, ratingGroup, gsuPoolReference, validityTime, resultCode, finalUnitIndication, qosFinalUnitIndication);
	}
	
	public UsedServiceUnit getUsedServiceUnit(Date ccTime,CCMoney ccMoney,Long ccTotalOctets,Long ccInputOctets,Long ccOutputOctets,Long ccServiceSpecificUnits,TariffChangeUsageEnum tariffChangeUsage)
	{
		return new UsedServiceUnitImpl(ccTime, ccMoney, ccTotalOctets, ccInputOctets, ccOutputOctets, ccServiceSpecificUnits, tariffChangeUsage);
	}
	
	public RequestedServiceUnit getRequestedServiceUnit(Date ccTime,CCMoney ccMoney,Long ccTotalOctets,Long ccInputOctets,Long ccOutputOctets,Long ccServiceSpecificUnits)
	{
		return new RequestedServiceUnitImpl(ccTime, ccMoney, ccTotalOctets, ccInputOctets, ccOutputOctets, ccServiceSpecificUnits);
	}
	
	public GrantedServiceUnit getGrantedServiceUnit(Date ccTime,CCMoney ccMoney,Long ccTotalOctets,Long ccInputOctets,Long ccOutputOctets,Long ccServiceSpecificUnits,TariffChangeUsageEnum tariffChangeUsage)
	{
		return new GrantedServiceUnitImpl(ccTime, ccMoney, ccTotalOctets, ccInputOctets, ccOutputOctets, ccServiceSpecificUnits, tariffChangeUsage);
	}
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData)
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public SubscriptionIdExtension getSubscriptionIdExtension(String e164,String imsi,String sipURI,String nai,String uePrivate)
	{
		return new SubscriptionIdExtensionImpl(e164, imsi, sipURI, nai, uePrivate);
	}
	
	public FinalUnitIndication getFinalUnitIndication(FinalUnitActionEnum finalUnitAction, List<RestrictionFilterRule> restrictionFilterRule, List<String> filterId, RedirectServer redirectServer)
	{
		return new FinalUnitIndicationImpl(finalUnitAction, restrictionFilterRule, filterId, redirectServer);
	}
	
	public QoSFinalUnitIndication getQoSFinalUnitIndication(FinalUnitActionEnum finalUnitAction, List<RestrictionFilterRule> restrictionFilterRule, List<String> filterId, RedirectServer redirectServer)
	{
		return new QoSFinalUnitIndicationImpl(finalUnitAction, restrictionFilterRule, filterId, redirectServer);
	}
	
	public CostInformation getCostInformation(UnitValue unitValue,Long currencyCode,String costUnit)
	{
		return new CostInformationImpl(unitValue, currencyCode, costUnit);
	}
	
	public GSUPoolReference getGSUPoolReference(Long gsuPoolIdentifier,CcUnitTypeEnum ccUnitType,UnitValue unitValue)
	{
		return new GSUPoolReferenceImpl(gsuPoolIdentifier, ccUnitType, unitValue);
	}
	
	public CCMoney getCCMoney(UnitValue unitValue,Long currencyCode)
	{
		return new CCMoneyImpl(unitValue, currencyCode);
	}
	
	public UnitValue getUnitValue(Long valueDigits,Long exponent)
	{
		return new UnitValueImpl(valueDigits, exponent);
	}
	
	public RestrictionFilterRule getRestrictionFilterRule(String rule) throws ParseException
	{
		return new RestrictionFilterRuleImpl(rule, null, null);
	}
	
	public RestrictionFilterRule getRestrictionFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws ParseException
	{
		return new RestrictionFilterRuleImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public RedirectServer getRedirectServer(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress)
	{
		return new RedirectServerImpl(redirectAddressType, redirectServerAddress);
	}
}
