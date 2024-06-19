package com.mobius.software.telco.protocols.diameter.impl.app.rx;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.app.rx.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CCMoneyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GrantedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.SubscriptionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UnitValueImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UsedServiceUnitImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UserEquipmentInfoExtensionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.UserEquipmentInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RedirectInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AFRequestedDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AcceptableServiceInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.AccessNetworkChargingIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.CalleeInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FiveGSRANNASReleaseCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowDescriptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.FlowsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MAInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MediaComponentDescriptionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.MediaSubComponentImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.NGAPCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.PreEmptionControlInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ServiceAuthorizationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SponsoredConnectivityDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.WirelineUserLocationInfoImpl;
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
/**
*
* @author yulian oifa
*
*/
public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public Load getLoad()
	{
		return new LoadImpl();
	}
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException
	{
		return new OCOLRImpl(ocSequenceNumber, ocReportType);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return new OCSupportedFeaturesImpl();
	}
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public UserEquipmentInfoExtension getUserEquipmentInfoExtension(ByteBuf imeiSV,ByteBuf mac,ByteBuf eui64,ByteBuf modifiedEUI64,ByteBuf imei) throws MissingAvpException, AvpOccursTooManyTimesException
	{
		return new UserEquipmentInfoExtensionImpl(imeiSV, mac, eui64, modifiedEUI64, imei);
	}
	
	public UserEquipmentInfo getUserEquipmentInfo(UserEquipmentInfoTypeEnum userEquipmentInfoType,ByteBuf userEquipmentInfoValue) throws MissingAvpException
	{
		return new UserEquipmentInfoImpl(userEquipmentInfoType, userEquipmentInfoValue);
	}
	
	public WirelineUserLocationInfo getWirelineUserLocationInfo()
	{
		return new WirelineUserLocationInfoImpl();
	}
	
	public FiveGSRANNASReleaseCause getFiveGSRANNASReleaseCause()
	{
		return new FiveGSRANNASReleaseCauseImpl();
	}
	
	public NGAPCause getNGAPCause(Long ngapGroup,Long ngapValue) throws MissingAvpException
	{
		return new NGAPCauseImpl(ngapGroup, ngapValue);
	}
	
	public SponsoredConnectivityData getSponsoredConnectivityData()
	{
		return new SponsoredConnectivityDataImpl();
	}
	
	public UsedServiceUnit getUsedServiceUnit()
	{
		return new UsedServiceUnitImpl();
	}
	
	public GrantedServiceUnit getGrantedServiceUnit()
	{
		return new GrantedServiceUnitImpl();
	}
	
	public CCMoney getCCMoney(UnitValue unitValue) throws MissingAvpException
	{
		return new CCMoneyImpl(unitValue);
	}
	
	public UnitValue getUnitValue(Long valueDigits) throws MissingAvpException
	{
		return new UnitValueImpl(valueDigits);
	}
	
	public MAInformation getMAInformation()
	{
		return new MAInformationImpl();
	}
	
	public SubscriptionId getSubscriptionId(SubscriptionIdTypeEnum subscriptionIdType,String subscriptionIdData) throws MissingAvpException
	{
		return new SubscriptionIdImpl(subscriptionIdType, subscriptionIdData);
	}
	
	public Flows getFlows(Long mediaComponentNumber) throws MissingAvpException
	{
		return new FlowsImpl(mediaComponentNumber);
	}
	
	public RedirectInformation getRedirectInformation()
	{
		return new RedirectInformationImpl();
	}
	
	public AccessNetworkChargingIdentifier getAccessNetworkChargingIdentifier(ByteBuf accessNetworkChargingIdentifierValue) throws MissingAvpException
	{
		return new AccessNetworkChargingIdentifierImpl(accessNetworkChargingIdentifierValue);
	}
	
	public MediaComponentDescription getMediaComponentDescription(Long mediaComponentNumber) throws MissingAvpException
	{
		return new MediaComponentDescriptionImpl(mediaComponentNumber);
	}
	
	public MediaSubComponent getMediaSubComponent(Long flowNumber) throws MissingAvpException
	{
		return new MediaSubComponentImpl(flowNumber);
	}
	
	public FlowDescription getFlowDescription(String rule) throws InvalidAvpValueException
	{
		return new FlowDescriptionImpl(rule, null, null);
	}
	
	public FlowDescription getFlowDescription(DiameterIpAction action, DiameterRuleDirection direction, InternetProtocol protocol, DiameterRuleAddress from, List<DiameterRulePorts> fromPorts, DiameterRuleAddress to,
			List<DiameterRulePorts> toPorts, List<DiameterRuleOption> options, List<DiameterRuleIpOption> ipOptions, List<DiameterRuleIpOption> negativeIpOptions,
			List<DiameterRuleTcpOption> tcpOptions, List<DiameterRuleTcpOption> negativeTcpOptions, List<DiameterRuleTcpFlag> tcpFlags, List<DiameterRuleTcpFlag> negativeTcpFlags,
			List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		return new FlowDescriptionImpl(action, direction, protocol, from, fromPorts, to, toPorts, options, ipOptions, negativeIpOptions, tcpOptions, negativeTcpOptions, tcpFlags, negativeTcpFlags, icmpTypes, null, null);
	}
	
	public PreEmptionControlInfo getPreEmptionControlInfo()
	{
		return new PreEmptionControlInfoImpl();
	}
	
	public AFRequestedData getAFRequestedData()
	{
		return new AFRequestedDataImpl();
	}
	
	public CalleeInformation getCalleeInformation()
	{
		return new CalleeInformationImpl();
	}
	
	public ServiceAuthorizationInfo getServiceAuthorizationInfo()
	{
		return new ServiceAuthorizationInfoImpl();
	}
	
	public AcceptableServiceInfo getAcceptableServiceInfo()
	{
		return new AcceptableServiceInfoImpl();
	}
}