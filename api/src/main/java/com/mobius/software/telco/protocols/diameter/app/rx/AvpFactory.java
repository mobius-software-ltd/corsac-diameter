package com.mobius.software.telco.protocols.diameter.app.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GrantedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.TariffChangeUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UnitValue;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UsedServiceUnit;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RedirectInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AFRequestedData;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AcceptableServiceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.CalleeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FiveGSRANNASReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentDescription;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaSubComponent;
import com.mobius.software.telco.protocols.diameter.primitives.rx.NGAPCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.PreEmptionControlInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ServiceAuthorizationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsoredConnectivityData;
import com.mobius.software.telco.protocols.diameter.primitives.rx.WirelineUserLocationInfo;

import io.netty.buffer.ByteBuf;

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public Load getLoad();
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType);
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList);
	
	public UserEquipmentInfoExtension getUserEquipmentInfoExtension(ByteBuf imeiSV,ByteBuf mac,ByteBuf eui64,ByteBuf modifiedEUI64,ByteBuf imei);
	
	public UserEquipmentInfo getUserEquipmentInfo(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue);
	
	public WirelineUserLocationInfo getWirelineUserLocationInfo();
	
	public FiveGSRANNASReleaseCause getFiveGSRANNASReleaseCause();
	
	public NGAPCause getNGAPCause(Long ngapGroup,Long ngapValue);
	
	public SponsoredConnectivityData getSponsoredConnectivityData();
	
	public UsedServiceUnit getUsedServiceUnit(Date ccTime,CCMoney ccMoney,Long ccTotalOctets,Long ccInputOctets,Long ccOutputOctets,Long ccServiceSpecificUnits,TariffChangeUsageEnum tariffChangeUsage);
	
	public GrantedServiceUnit getGrantedServiceUnit(Date ccTime,CCMoney ccMoney,Long ccTotalOctets,Long ccInputOctets,Long ccOutputOctets,Long ccServiceSpecificUnits,TariffChangeUsageEnum tariffChangeUsage);
	
	public CCMoney getCCMoney(UnitValue unitValue,Long currencyCode);
	
	public UnitValue getUnitValue(Long valueDigits,Long exponent);
	
	public MAInformation getMAInformation();
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData);
	
	public Flows getFlows(Long mediaComponentNumber);
	
	public RedirectInformation getRedirectInformation();
	
	public AccessNetworkChargingIdentifier getAccessNetworkChargingIdentifier(ByteBuf accessNetworkChargingIdentifierValue);
	
	public MediaComponentDescription getMediaComponentDescription(Long mediaComponentNumber);
	
	public MediaSubComponent getMediaSubComponent(Long flowNumber);
	
	public FlowDescription getFlowDescription(String rule) throws ParseException;
	
	public FlowDescription getFlowDescription(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws ParseException;
	
	public PreEmptionControlInfo getPreEmptionControlInfo();
	
	public AFRequestedData getAFRequestedData();
	
	public CalleeInformation getCalleeInformation();
	
	public ServiceAuthorizationInfo getServiceAuthorizationInfo();
	
	public AcceptableServiceInfo getAcceptableServiceInfo();
}