package com.mobius.software.telco.protocols.diameter.app.creditcontrol.ericsson;
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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.TariffChangeUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.OtherPartyId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ericsson.OtherPartyIdTypeEnum;

import io.netty.buffer.ByteBuf;


public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public ServiceParameterInfo getServiceParameterInfo(Long serviceParameterType,ByteBuf serviceParameterValue);
	
	public MultipleServicesCreditControl getMultipleServicesCreditControl(GrantedServiceUnit grantedServiceUnit, RequestedServiceUnit requestedServiceUnit, List<UsedServiceUnit> usedServiceUnit, TariffChangeUsageEnum tariffChangeUsage, List<Long> serviceIdentifier, Long ratingGroup, List<GSUPoolReference> gsuPoolReference, Long validityTime, Long resultCode, FinalUnitIndication finalUnitIndication,QoSFinalUnitIndication qosFinalUnitIndication);
	
	public UsedServiceUnit getUsedServiceUnit(Date ccTime,CCMoney ccMoney,Long ccTotalOctets,Long ccInputOctets,Long ccOutputOctets,Long ccServiceSpecificUnits,TariffChangeUsageEnum tariffChangeUsage);
	
	public RequestedServiceUnit getRequestedServiceUnit(Date ccTime,CCMoney ccMoney,Long ccTotalOctets,Long ccInputOctets,Long ccOutputOctets,Long ccServiceSpecificUnits);
	
	public GrantedServiceUnit getGrantedServiceUnit(Date ccTime,CCMoney ccMoney,Long ccTotalOctets,Long ccInputOctets,Long ccOutputOctets,Long ccServiceSpecificUnits,TariffChangeUsageEnum tariffChangeUsage);
	
	public GSUPoolReference getGSUPoolReference(Long gsuPoolIdentifier,CcUnitTypeEnum ccUnitType,UnitValue unitValue);
	
	public CCMoney getCCMoney(UnitValue unitValue,Long currencyCode);
	
	public FinalUnitIndication getFinalUnitIndication(FinalUnitActionEnum finalUnitAction, List<RestrictionFilterRule> restrictionFilterRule, List<String> filterId, RedirectServer redirectServer);
	
	public QoSFinalUnitIndication getQoSFinalUnitIndication(FinalUnitActionEnum finalUnitAction, List<RestrictionFilterRule> restrictionFilterRule, List<String> filterId, RedirectServer redirectServer);
	
	public CostInformation getCostInformation(UnitValue unitValue,Long currencyCode,String costUnit);
	
	public UnitValue getUnitValue(Long valueDigits,Long exponent);
	
	public RestrictionFilterRule getRestrictionFilterRule(String rule) throws ParseException;
	
	public RestrictionFilterRule getRestrictionFilterRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws ParseException;
	
	public RedirectServer getRedirectServer(RedirectAddressTypeEnum redirectAddressType, String redirectServerAddress);
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData);
	
	public OtherPartyId getOtherPartyId(OtherPartyIdTypeEnum otherPartyIdType,String otherPartyIdData);		
}
