package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMSIMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPNSAPIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPPDPTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPRATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSelectionModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSessionStopIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleBaseNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NBIFOMModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NBIFOMSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TDFIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MMENumberForMTSMSImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sd.ADCRuleBaseNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.MMENameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.MMERealmImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APNRateControl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CGAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CNOperatorSelectionEntity;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CNOperatorSelectionEntityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CPCIoTEPSOptimisationIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CPCIoTEPSOptimisationIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeCondition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChargingCharacteristicsSelectionMode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChargingCharacteristicsSelectionModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChargingPerIPCANSessionIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChargingPerIPCANSessionIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Diagnostics;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlag;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagExtension;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.DynamicAddressFlagExtensionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EPDGAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EnhancedDiagnostics;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.GGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSIUnauthenticatedFlag;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSIUnauthenticatedFlagEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LogicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LowPriorityIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LowPriorityIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NodeId;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OfflineCharging;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDNConnectionChargingID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDPAddressPrefixLength;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDPContextType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDPContextTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSCellInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSFurnishChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PhysicalAccessID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RANSecondaryRATUsageReport;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SCSASAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SGWAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SGWChange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SGWChangeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SGiPtPTunnellingMethod;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SGiPtPTunnellingMethodEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceDataContainer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServingNodeType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServingNodeTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.StartTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.StopTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPP2BSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPPSDataOffStatus;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPPSDataOffStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TWAGAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TrafficDataVolumes;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UNIPDUCPOnlyFlag;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UNIPDUCPOnlyFlagEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UnusedQuotaTimer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingId;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMSIMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPNSAPI;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPPDPType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPPDPTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPRATType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSelectionMode;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSessionStopIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FixedUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMMode;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NBIFOMSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MMENumberForMTSMS;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MMEName;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MMERealm;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.RRCCauseCounter;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingPLMNRateControl;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class PSInformationImpl extends DiameterAvpImpl implements PSInformation
{
	private List<SupportedFeatures> supportedFeatures;
 	private TGPPChargingId tgppChargingId;
	private PDNConnectionChargingID pdnConnectionChargingID;
   	private NodeId nodeId;
   	private TGPPPDPType tgppPDPType;
 	private List<PDPAddress> pdpAddress;
	private PDPAddressPrefixLength pdpAddressPrefixLength;
	private DynamicAddressFlag dynamicAddressFlag;
	private DynamicAddressFlagExtension dynamicAddressFlagExtension;
	private QoSInformation qosInformation;
	private List<SGSNAddress> sgsnAddress;
	private List<GGSNAddress> ggsnAddress; 
	private List<TDFIPAddress> tdfIPAddress;
	private List<SGWAddress> sgwAddress; 
	private List<EPDGAddress> epdgAddress; 
	private List<TWAGAddress> twagAddress;
   	private CGAddress cgAddress;
   	private ServingNodeType servingNodeType;
	private SGWChange sgwChange;
	private TGPPIMSIMCCMNC tgppIMSIMCCMNC;
	private IMSIUnauthenticatedFlag imsiUnauthenticatedFlag;
	private TGPPGGSNMCCMNC tgppGGSNMCCMNC;
	private TGPPNSAPI tgppNSAPI;
	private CalledStationId calledStationId;
	private TGPPSessionStopIndicator tgppSessionStopIndicator;
	private TGPPSelectionMode tgppSelectionMode;
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	private ChargingCharacteristicsSelectionMode chargingCharacteristicsSelectionMode;
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	private TGPPMSTimeZone tgppMSTimeZone;
	private ChargingRuleBaseName chargingRuleBaseName; 
	private ADCRuleBaseName adcRuleBaseName; 
	private TGPPUserLocationInfo tgppUserLocationInfo;
	private UserLocationInfoTime userLocationInfoTime;
	private UserCSGInformation userCSGInformation;
 	private List<PresenceReportingAreaInformation> presenceReportingAreaInformation;
   	private TGPP2BSID tgpp2BSID; 
	private TWANUserLocationInfo twanUserLocationInfo;
	private UWANUserLocationInfo uwanUserLocationInfo;
   	private TGPPRATType tgppRATType;
   	private PSFurnishChargingInformation psFurnishChargingInformation;
	private PDPContextType pdpContextType; 
	private OfflineCharging offlineCharging;
	private List<TrafficDataVolumes> trafficDataVolumes;
	private List<ServiceDataContainer> serviceDataContainer;
	private UserEquipmentInfo userEquipmentInfo;
	private TerminalInformation terminalInformation;
	private StartTime startTime;
	private StopTime stopTime;
	private ChangeCondition changeCondition;
	private Diagnostics diagnostics;
	private LowPriorityIndicator lowPriorityIndicator; 
	private NBIFOMMode nbifomMode;
	private NBIFOMSupport nbifomSupport;
	private MMENumberForMTSMS mmeNumberForMTSMS;
	private MMEName mmeName;
	private MMERealm mmeRealm; 
	private LogicalAccessID logicalAccessID;
	private PhysicalAccessID physicalAccessID;
	private FixedUserLocationInfo fixedUserLocationInfo;
	private CNOperatorSelectionEntity cnOperatorSelectionEntity;
	private EnhancedDiagnostics enhancedDiagnostics;
	private SGiPtPTunnellingMethod sgiPtPTunnellingMethod;
	private CPCIoTEPSOptimisationIndicator cpcIoTEPSOptimisationIndicator;
	private UNIPDUCPOnlyFlag uniPDUCPOnlyFlag;
	private ServingPLMNRateControl servingPLMNRateControl;
	private APNRateControl apnRateControl;
	private ChargingPerIPCANSessionIndicator chargingPerIPCANSessionIndicator;
	private RRCCauseCounter rrcCauseCounter;
   	private TGPPPSDataOffStatus tgppPSDataOffStatus;
	private SCSASAddress scsASAddress;
   	private UnusedQuotaTimer unusedQuotaTimer;
 	private List<RANSecondaryRATUsageReport> ranSecondaryRATUsageReport;
   	private PSCellInfo psCellInfo;
   				
   	public PSInformationImpl()
   	{
   		
   	}
   	
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;
	}
	
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}
	
	public ByteBuf get3GPPChargingId()
	{
		if(tgppChargingId==null)
			return null;
		
		return tgppChargingId.getValue();
	}
	
	public void set3GPPChargingId(ByteBuf value)
	{
		if(value==null)
			this.tgppChargingId = null;
		else
			this.tgppChargingId = new TGPPChargingIdImpl(value, null, null);			
	}
	
	public Long getPDNConnectionChargingID()
	{
		if(pdnConnectionChargingID==null)
			return null;
		
		return pdnConnectionChargingID.getUnsigned();
	}
	
	public void setPDNConnectionChargingID(Long value)
	{
		if(value==null)
			this.pdnConnectionChargingID = null;
		else
			this.pdnConnectionChargingID = new PDNConnectionChargingIDImpl(value, null, null);			
	}
	
	public String getNodeId()
	{
		if(nodeId==null)
			return null;
		
		return nodeId.getString();
	}
	
	public void setNodeId(String value)
	{
		if(value==null)
			this.nodeId = null;
		else
			this.nodeId = new NodeIdImpl(value, null, null);			
	}
	
	public TGPPPDPTypeEnum get3GPPPDPType()
	{
		if(tgppPDPType==null)
			return null;
		
		return tgppPDPType.getEnumerated(TGPPPDPTypeEnum.class);
	}
	
	public void get3GPPPDPType(TGPPPDPTypeEnum value)
	{
		if(value==null)
			this.tgppPDPType = null;
		else
			this.tgppPDPType = new TGPPPDPTypeImpl(value, null, null);			
	}
	
	public List<InetAddress> getPDPAddress()
	{
		if(pdpAddress==null || pdpAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(PDPAddress curr:pdpAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setPDPAddress(List<InetAddress> value)
	{
		if(value==null || value.size()==0)
			this.pdpAddress = null;
		else
		{
			this.pdpAddress = new ArrayList<PDPAddress>();
			for(InetAddress curr: value)
				this.pdpAddress.add(new PDPAddressImpl(curr, null, null));			
		}
	}
	
	public Long getPDPAddressPrefixLength()
	{
		if(pdpAddressPrefixLength==null)
			return null;
		
		return pdpAddressPrefixLength.getUnsigned();
	}
	
	public void setPDPAddressPrefixLength(Long value)
	{
		if(value==null)
			this.pdpAddressPrefixLength = null;
		else
			this.pdpAddressPrefixLength = new PDPAddressPrefixLengthImpl(value, null, null);			
	}
	
	public DynamicAddressFlagEnum getDynamicAddressFlag()
	{
		if(dynamicAddressFlag==null)
			return null;
		
		return dynamicAddressFlag.getEnumerated(DynamicAddressFlagEnum.class);
	}
	
	public void setDynamicAddressFlag(DynamicAddressFlagEnum value)
	{
		if(value==null)
			this.dynamicAddressFlag = null;
		else
			this.dynamicAddressFlag = new DynamicAddressFlagImpl(value, null, null);			
	}
	
	public DynamicAddressFlagExtensionEnum getDynamicAddressFlagExtension()
	{
		if(dynamicAddressFlagExtension==null)
			return null;
		
		return dynamicAddressFlagExtension.getEnumerated(DynamicAddressFlagExtensionEnum.class);
	}
	
	public void setDynamicAddressFlagExtension(DynamicAddressFlagExtensionEnum value)
	{
		if(value==null)
			this.dynamicAddressFlagExtension = null;
		else
			this.dynamicAddressFlagExtension = new DynamicAddressFlagExtensionImpl(value, null, null);			
	}
	
	public QoSInformation getQoSInformation()
	{
		return this.qosInformation;
	}
	
	public void setQoSInformation(QoSInformation value)
	{
		this.qosInformation = value;
	}
	
	public List<InetAddress> getSGSNAddress()
	{
		if(sgsnAddress==null || sgsnAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(SGSNAddress curr:sgsnAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setSGSNAddress(List<InetAddress> value)
	{
		if(value==null || value.size()==0)
			this.sgsnAddress = null;
		else
		{
			this.sgsnAddress = new ArrayList<SGSNAddress>();
			for(InetAddress curr: value)
				this.sgsnAddress.add(new SGSNAddressImpl(curr, null, null));			
		}
	}
	
	public List<InetAddress> getGGSNAddress()
	{
		if(ggsnAddress==null || ggsnAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(GGSNAddress curr:ggsnAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setGGSNAddress(List<InetAddress> value)
	{
		if(value==null || value.size()==0)
			this.ggsnAddress = null;
		else
		{
			this.ggsnAddress = new ArrayList<GGSNAddress>();
			for(InetAddress curr: value)
				this.ggsnAddress.add(new GGSNAddressImpl(curr, null, null));			
		}
	}
	
	public List<InetAddress> getTDFIPAddress()
	{
		if(tdfIPAddress==null || tdfIPAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(TDFIPAddress curr:tdfIPAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setTDFIPAddress(List<InetAddress> value)
	{
		if(value==null || value.size()==0)
			this.tdfIPAddress = null;
		else
		{
			this.tdfIPAddress = new ArrayList<TDFIPAddress>();
			for(InetAddress curr: value)
				this.tdfIPAddress.add(new TDFIPAddressImpl(curr, null, null));			
		}
	}
	
	public List<InetAddress> getSGWAddress()
	{
		if(sgwAddress==null || sgwAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(SGWAddress curr:sgwAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setSGWAddress(List<InetAddress> value)
	{
		if(value==null || value.size()==0)
			this.sgwAddress = null;
		else
		{
			this.sgwAddress = new ArrayList<SGWAddress>();
			for(InetAddress curr: value)
				this.sgwAddress.add(new SGWAddressImpl(curr, null, null));			
		}
	}
	
	public List<InetAddress> getEPDGAddress()
	{
		if(epdgAddress==null || epdgAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(EPDGAddress curr:epdgAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setEPDGAddress(List<InetAddress> value)
	{
		if(value==null || value.size()==0)
			this.epdgAddress = null;
		else
		{
			this.epdgAddress = new ArrayList<EPDGAddress>();
			for(InetAddress curr: value)
				this.epdgAddress.add(new EPDGAddressImpl(curr, null, null));			
		}
	}
	
	public List<InetAddress> getTWAGAddress()
	{
		if(twagAddress==null || twagAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(TWAGAddress curr:twagAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setTWAGAddress(List<InetAddress> value)
	{
		if(value==null || value.size()==0)
			this.twagAddress = null;
		else
		{
			this.twagAddress = new ArrayList<TWAGAddress>();
			for(InetAddress curr: value)
				this.twagAddress.add(new TWAGAddressImpl(curr, null, null));			
		}
	}
	
	public InetAddress getCGAddress()
	{
		if(cgAddress==null)
			return null;
		
		return cgAddress.getAddress();
	}
	
	public void setCGAddress(InetAddress value)
	{
		if(value==null)
			this.cgAddress = null;
		else
			this.cgAddress = new CGAddressImpl(value, null, null);			
	}
	
	public ServingNodeTypeEnum getServingNodeType()
	{
		if(servingNodeType==null)
			return null;
		
		return servingNodeType.getEnumerated(ServingNodeTypeEnum.class);
	}
	
	public void setServingNodeType(ServingNodeTypeEnum value)
	{
		if(value==null)
			this.servingNodeType = null;
		else
			this.servingNodeType = new ServingNodeTypeImpl(value, null, null);			
	}
	
	public SGWChangeEnum getSGWChange()
	{
		if(sgwChange==null)
			return null;
		
		return sgwChange.getEnumerated(SGWChangeEnum.class);
	}
	
	public void setSGWChange(SGWChangeEnum value)
	{
		if(value==null)
			this.sgwChange = null;
		else
			this.sgwChange = new SGWChangeImpl(value, null, null);			
	}
	
	public String get3GPPIMSIMCCMNC()
	{
		if(tgppIMSIMCCMNC==null)
			return null;
		
		return tgppIMSIMCCMNC.getString();
	}
	
	public void set3GPPIMSIMCCMNC(String value)
	{
		if(value==null)
			this.tgppIMSIMCCMNC = null;
		else
			this.tgppIMSIMCCMNC = new TGPPIMSIMCCMNCImpl(value, null, null);			
	}
	
	public IMSIUnauthenticatedFlagEnum getIMSIUnauthenticatedFlag()
	{
		if(imsiUnauthenticatedFlag==null)
			return null;
		
		return imsiUnauthenticatedFlag.getEnumerated(IMSIUnauthenticatedFlagEnum.class);
	}
	
	public void setIMSIUnauthenticatedFlag(IMSIUnauthenticatedFlagEnum value)
	{
		if(value==null)
			this.imsiUnauthenticatedFlag = null;
		else
			this.imsiUnauthenticatedFlag = new IMSIUnauthenticatedFlagImpl(value, null, null);			
	}	
	
	public String get3GPPGGSNMCCMNC()
	{
		if(tgppGGSNMCCMNC==null)
			return null;
		
		return tgppGGSNMCCMNC.getString();
	}
	
	public void set3GPPGGSNMCCMNC(String value)
	{
		if(value==null)
			this.tgppGGSNMCCMNC = null;
		else
			this.tgppGGSNMCCMNC = new TGPPGGSNMCCMNCImpl(value, null, null);			
	}
	
	public ByteBuf get3GPPNSAPI()
	{
		if(tgppNSAPI==null)
			return null;
		
		return tgppNSAPI.getValue();
	}
	
	public void set3GPPNSAPI(ByteBuf value)
	{
		if(value==null)
			this.tgppNSAPI = null;
		else
			this.tgppNSAPI = new TGPPNSAPIImpl(value, null, null);			
	}
	
	public String getCalledStationId()
	{
		if(calledStationId==null)
			return null;
		
		return calledStationId.getString();
	}
	
	public void setCalledStationId(String value)
	{
		if(value==null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(value, null, null);			
	}
	
	public ByteBuf get3GPPSessionStopIndicator()
	{
		if(tgppSessionStopIndicator==null)
			return null;
		
		return tgppSessionStopIndicator.getValue();
	}
	
	public void set3GPPSessionStopIndicator(ByteBuf value)
	{
		if(value==null)
			this.tgppSessionStopIndicator = null;
		else
			this.tgppSessionStopIndicator = new TGPPSessionStopIndicatorImpl(value, null, null);			
	}
	
	public String get3GPPSelectionMode()
	{
		if(tgppSelectionMode==null)
			return null;
		
		return tgppSelectionMode.getString();
	}
	
	public void set3GPPSelectionMode(String value)
	{
		if(value==null)
			this.tgppSelectionMode = null;
		else
			this.tgppSelectionMode = new TGPPSelectionModeImpl(value, null, null);			
	}
	
	public String getTGPPChargingCharacteristics()
	{
		if(tgppChargingCharacteristics==null)
			return null;
		
		return tgppChargingCharacteristics.getString();
	}
	
	public void setTGPPChargingCharacteristics(String value)
	{
		if(value==null)
			this.tgppChargingCharacteristics = null;
		else
			this.tgppChargingCharacteristics = new TGPPChargingCharacteristicsImpl(value, null, null);			
	}	
	
	public ChargingCharacteristicsSelectionModeEnum getChargingCharacteristicsSelectionMode()
	{
		if(chargingCharacteristicsSelectionMode==null)
			return null;
		
		return chargingCharacteristicsSelectionMode.getEnumerated(ChargingCharacteristicsSelectionModeEnum.class);
	}
	
	public void setChargingCharacteristicsSelectionMode(ChargingCharacteristicsSelectionModeEnum value)
	{
		if(value==null)
			this.chargingCharacteristicsSelectionMode = null;
		else
			this.chargingCharacteristicsSelectionMode = new ChargingCharacteristicsSelectionModeImpl(value, null, null);			
	}	
	
	public String get3GPPSGSNMCCMNC()
	{
		if(tgppSGSNMCCMNC==null)
			return null;
		
		return tgppSGSNMCCMNC.getString();
	}
	
	public void set3GPPSGSNMCCMNC(String value)
	{
		if(value==null)
			this.tgppSGSNMCCMNC = null;
		else
			this.tgppSGSNMCCMNC = new TGPPSGSNMCCMNCImpl(value, null, null);			
	}
	
	public ByteBuf get3GPPMSTimeZone()
	{
		if(tgppMSTimeZone==null)
			return null;
		
		return tgppMSTimeZone.getValue();
	}
	
	public void set3GPPMSTimeZone(ByteBuf value)
	{
		if(value==null)
			this.tgppMSTimeZone = null;
		else
			this.tgppMSTimeZone = new TGPPMSTimeZoneImpl(value, null, null);			
	}
	
	public String getChargingRuleBaseName()
	{
		if(chargingRuleBaseName==null)
			return null;
		
		return chargingRuleBaseName.getString();
	}
	
	public void setChargingRuleBaseName(String value)
	{
		if(value==null)
			this.chargingRuleBaseName = null;
		else
			this.chargingRuleBaseName = new ChargingRuleBaseNameImpl(value, null, null);			
	}
	
	public String getADCRuleBaseName()
	{
		if(adcRuleBaseName==null)
			return null;
		
		return adcRuleBaseName.getString();
	}
	
	public void setADCRuleBaseName(String value)
	{
		if(value==null)
			this.adcRuleBaseName = null;
		else
			this.adcRuleBaseName = new ADCRuleBaseNameImpl(value, null, null);			
	}	
	
	public ByteBuf get3GPPUserLocationInfo()
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}
	
	public void set3GPPUserLocationInfo(ByteBuf value)
	{
		if(value==null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);			
	}
	
	public Date getUserLocationInfoTime()
	{
		if(userLocationInfoTime==null)
			return null;
		
		return userLocationInfoTime.getDateTime();
	}
	
	public void setUserLocationInfoTime(Date value)
	{
		if(value==null)
			this.userLocationInfoTime = null;
		else
			this.userLocationInfoTime = new UserLocationInfoTimeImpl(value, null, null);			
	}

	public UserCSGInformation getUserCSGInformation()
	{
		return this.userCSGInformation;
	}
	
	public void setUserCSGInformation(UserCSGInformation value)
	{
		this.userCSGInformation = value;
	}
	
	public List<PresenceReportingAreaInformation> getPresenceReportingAreaInformation()
	{
		return this.presenceReportingAreaInformation;
	}
	
	public void setPresenceReportingAreaInformation(List<PresenceReportingAreaInformation> value)
	{
		this.presenceReportingAreaInformation = value;
	}
	
	public ByteBuf get3GPP2BSID()
	{
		if(tgpp2BSID==null)
			return null;
		
		return tgpp2BSID.getValue();
	}
	
	public void set3GPP2BSID(ByteBuf value)
	{
		if(value==null)
			this.tgpp2BSID = null;
		else
			this.tgpp2BSID = new TGPP2BSIDImpl(value, null, null);			
	}
	
	public TWANUserLocationInfo getTWANUserLocationInfo()
	{
		return this.twanUserLocationInfo;
	}
	
	public void setTWANUserLocationInfo(TWANUserLocationInfo value)
	{
		this.twanUserLocationInfo = value;
	}
	
	public UWANUserLocationInfo getUWANUserLocationInfo()
	{
		return this.uwanUserLocationInfo;
	}
	
	public void setUWANUserLocationInfo(UWANUserLocationInfo value)
	{
		this.uwanUserLocationInfo = value;
	}
	
	public ByteBuf get3GPPRATType()
	{
		if(tgppRATType==null)
			return null;
		
		return tgppRATType.getValue();
	}
	
	public void set3GPPRATType(ByteBuf value)
	{
		if(value==null)
			this.tgppRATType = null;
		else
			this.tgppRATType = new TGPPRATTypeImpl(value, null, null);			
	}
	
	public PSFurnishChargingInformation getPSFurnishChargingInformation()
	{
		return this.psFurnishChargingInformation;
	}
	
	public void setPSFurnishChargingInformation(PSFurnishChargingInformation value)
	{
		this.psFurnishChargingInformation = value;
	}
	
	public PDPContextTypeEnum getPDPContextType()
	{
		if(pdpContextType==null)
			return null;
		
		return pdpContextType.getEnumerated(PDPContextTypeEnum.class);
	}
	
	public void setPDPContextType(PDPContextTypeEnum value)
	{
		if(value==null)
			this.pdpContextType = null;
		else
			this.pdpContextType = new PDPContextTypeImpl(value, null, null);			
	}
	
	public OfflineCharging getOfflineCharging()
	{
		return this.offlineCharging;
	}
	
	public void setOfflineCharging(OfflineCharging value)
	{
		this.offlineCharging = value;
	}
	
	public List<TrafficDataVolumes> getTrafficDataVolumes()
	{
		return this.trafficDataVolumes;
	}
	
	public void setTrafficDataVolumes(List<TrafficDataVolumes> value)
	{
		this.trafficDataVolumes = value;
	}
	
	public List<ServiceDataContainer> getServiceDataContainer()
	{
		return this.serviceDataContainer;
	}
	
	public void setServiceDataContainer(List<ServiceDataContainer> value)
	{
		this.serviceDataContainer = value;
	}
	
	public UserEquipmentInfo getUserEquipmentInfo()
	{
		return this.userEquipmentInfo;
	}
	
	public void setUserEquipmentInfo(UserEquipmentInfo value)
	{
		this.userEquipmentInfo = value;
	}
	
	public TerminalInformation getTerminalInformation()
	{
		return this.terminalInformation;
	}
	
	public void setTerminalInformation(TerminalInformation value)
	{
		this.terminalInformation = value;
	}
	
	public Date getStartTime()
	{
		if(startTime==null)
			return null;
		
		return startTime.getDateTime();
	}
	
	public void setStartTime(Date value)
	{
		if(value==null)
			this.startTime = null;
		else
			this.startTime = new StartTimeImpl(value, null, null);			
	}
	
	public Date getStopTime()
	{
		if(stopTime==null)
			return null;
		
		return stopTime.getDateTime();
	}
	
	public void setStopTime(Date value)
	{
		if(value==null)
			this.stopTime = null;
		else
			this.stopTime = new StopTimeImpl(value, null, null);			
	}
	
	public Long getChangeCondition()
	{
		if(changeCondition==null)
			return null;
		
		return changeCondition.getUnsigned();
	}
	
	public void setChangeCondition(Long value)
	{
		if(value==null)
			this.changeCondition = null;
		else
			this.changeCondition = new ChangeConditionImpl(value, null, null);			
	}
	
	public Integer getDiagnostics()
	{
		if(diagnostics==null)
			return null;
		
		return diagnostics.getInteger();
	}
	
	public void setDiagnostics(Integer value)
	{
		if(value==null)
			this.diagnostics = null;
		else
			this.diagnostics = new DiagnosticsImpl(value, null, null);			
	}
	
	public LowPriorityIndicatorEnum getLowPriorityIndicator()
	{
		if(lowPriorityIndicator==null)
			return null;
		
		return lowPriorityIndicator.getEnumerated(LowPriorityIndicatorEnum.class);
	}
	
	public void setLowPriorityIndicator(LowPriorityIndicatorEnum value)
	{
		if(value==null)
			this.lowPriorityIndicator = null;
		else
			this.lowPriorityIndicator = new LowPriorityIndicatorImpl(value, null, null);			
	}
	
	public NBIFOMModeEnum getNBIFOMMode()
	{
		if(nbifomMode==null)
			return null;
		
		return nbifomMode.getEnumerated(NBIFOMModeEnum.class);
	}
	
	public void setNBIFOMMode(NBIFOMModeEnum value)
	{
		if(value==null)
			this.nbifomMode = null;
		else
			this.nbifomMode = new NBIFOMModeImpl(value, null, null);			
	}
	
	public NBIFOMSupportEnum getNBIFOMSupport()
	{
		if(nbifomSupport==null)
			return null;
		
		return nbifomSupport.getEnumerated(NBIFOMSupportEnum.class);
	}
	
	public void setNBIFOMSupport(NBIFOMSupportEnum value)
	{
		if(value==null)
			this.nbifomSupport = null;
		else
			this.nbifomSupport = new NBIFOMSupportImpl(value, null, null);			
	}
	
	public String getMMENumberForMTSMS()
	{
		if(mmeNumberForMTSMS==null)
			return null;
		
		return mmeNumberForMTSMS.getAddress();
	}
	
	public void setMMENumberForMTSMS(String value)
	{
		if(value==null)
			this.mmeNumberForMTSMS = null;
		else
			this.mmeNumberForMTSMS = new MMENumberForMTSMSImpl(value);			
	}
	
	public String getMMEName()
	{
		if(mmeName==null)
			return null;
		
		return mmeName.getIdentity();
	}
	
	public void setMMEName(String value)
	{
		if(value==null)
			this.mmeName = null;
		else
			this.mmeName = new MMENameImpl(value, null, null);			
	}
	
	public String getMMERealm()
	{
		if(mmeRealm==null)
			return null;
		
		return mmeRealm.getIdentity();
	}
	
	public void setMMERealm(String value)
	{
		if(value==null)
			this.mmeRealm = null;
		else
			this.mmeRealm = new MMERealmImpl(value, null, null);			
	}
	
	public ByteBuf getLogicalAccessID()
	{
		if(logicalAccessID==null)
			return null;
		
		return logicalAccessID.getValue();
	}
	
	public void setLogicalAccessID(ByteBuf value)
	{
		if(value==null)
			this.logicalAccessID = null;
		else
			this.logicalAccessID = new LogicalAccessIDImpl(value, null, null);			
	}
	
	public String getPhysicalAccessID()
	{
		if(physicalAccessID==null)
			return null;
		
		return physicalAccessID.getString();
	}
	
	public void setPhysicalAccessID(String value)
	{
		if(value==null)
			this.physicalAccessID = null;
		else
			this.physicalAccessID = new PhysicalAccessIDImpl(value, null, null);			
	}
	
	public FixedUserLocationInfo getFixedUserLocationInfo()
	{
		return this.fixedUserLocationInfo;
	}
	
	public void setFixedUserLocationInfo(FixedUserLocationInfo value)
	{
		this.fixedUserLocationInfo = value;
	}
	
	public CNOperatorSelectionEntityEnum getCNOperatorSelectionEntity()
	{
		if(cnOperatorSelectionEntity==null)
			return null;
		
		return cnOperatorSelectionEntity.getEnumerated(CNOperatorSelectionEntityEnum.class);
	}
	
	public void setCNOperatorSelectionEntity(CNOperatorSelectionEntityEnum value)
	{
		if(value==null)
			this.cnOperatorSelectionEntity = null;
		else
			this.cnOperatorSelectionEntity = new CNOperatorSelectionEntityImpl(value, null, null);			
	}
	
	public EnhancedDiagnostics getEnhancedDiagnostics()
	{
		return this.enhancedDiagnostics;
	}
	
	public void setEnhancedDiagnostics(EnhancedDiagnostics value)
	{
		this.enhancedDiagnostics = value;
	}
	
	public SGiPtPTunnellingMethodEnum getSGiPtPTunnellingMethod()
	{
		if(sgiPtPTunnellingMethod==null)
			return null;
		
		return sgiPtPTunnellingMethod.getEnumerated(SGiPtPTunnellingMethodEnum.class);
	}
	
	public void setSGiPtPTunnellingMethod(SGiPtPTunnellingMethodEnum value)
	{
		if(value==null)
			this.sgiPtPTunnellingMethod = null;
		else
			this.sgiPtPTunnellingMethod = new SGiPtPTunnellingMethodImpl(value, null, null);			
	}
	
	public CPCIoTEPSOptimisationIndicatorEnum getCPCIoTEPSOptimisationIndicator()
	{
		if(cpcIoTEPSOptimisationIndicator==null)
			return null;
		
		return cpcIoTEPSOptimisationIndicator.getEnumerated(CPCIoTEPSOptimisationIndicatorEnum.class);
	}
	
	public void setCPCIoTEPSOptimisationIndicator(CPCIoTEPSOptimisationIndicatorEnum value)
	{
		if(value==null)
			this.cpcIoTEPSOptimisationIndicator = null;
		else
			this.cpcIoTEPSOptimisationIndicator = new CPCIoTEPSOptimisationIndicatorImpl(value, null, null);			
	}
	
	public UNIPDUCPOnlyFlagEnum getUNIPDUCPOnlyFlag()
	{
		if(uniPDUCPOnlyFlag==null)
			return null;
		
		return uniPDUCPOnlyFlag.getEnumerated(UNIPDUCPOnlyFlagEnum.class);
	}
	
	public void setUNIPDUCPOnlyFlag(UNIPDUCPOnlyFlagEnum value)
	{
		if(value==null)
			this.uniPDUCPOnlyFlag = null;
		else
			this.uniPDUCPOnlyFlag = new UNIPDUCPOnlyFlagImpl(value, null, null);			
	}
	
	public ServingPLMNRateControl getServingPLMNRateControl()
	{
		return this.servingPLMNRateControl;
	}
	
	public void setServingPLMNRateControl(ServingPLMNRateControl value)
	{
		this.servingPLMNRateControl = value;
	}
	
	public APNRateControl getAPNRateControl()
	{
		return this.apnRateControl;
	}
	
	public void setAPNRateControl(APNRateControl value)
	{
		this.apnRateControl = value;
	}
	
	public ChargingPerIPCANSessionIndicatorEnum getChargingPerIPCANSessionIndicator()
	{
		if(chargingPerIPCANSessionIndicator==null)
			return null;
		
		return chargingPerIPCANSessionIndicator.getEnumerated(ChargingPerIPCANSessionIndicatorEnum.class);
	}
	
	public void setChargingPerIPCANSessionIndicator(ChargingPerIPCANSessionIndicatorEnum value)
	{
		if(value==null)
			this.chargingPerIPCANSessionIndicator = null;
		else
			this.chargingPerIPCANSessionIndicator = new ChargingPerIPCANSessionIndicatorImpl(value, null, null);			
	}
	
	public RRCCauseCounter getRRCCauseCounter()
	{
		return this.rrcCauseCounter;
	}
	
	public void setRRCCauseCounter(RRCCauseCounter value)
	{
		this.rrcCauseCounter = value;
	}
	
	public TGPPPSDataOffStatusEnum get3GPPPSDataOffStatus()
	{
		if(tgppPSDataOffStatus==null)
			return null;
		
		return tgppPSDataOffStatus.getEnumerated(TGPPPSDataOffStatusEnum.class);
	}
	
	public void set3GPPPSDataOffStatus(TGPPPSDataOffStatusEnum value)
	{
		if(value==null)
			this.tgppPSDataOffStatus = null;
		else
			this.tgppPSDataOffStatus = new TGPPPSDataOffStatusImpl(value, null, null);			
	}
	
	public SCSASAddress getSCSASAddress()
	{
		return this.scsASAddress;
	}
	
	public void setSCSASAddress(SCSASAddress value)
	{
		this.scsASAddress = value;
	}
	
	public Long getUnusedQuotaTimer()
	{
		if(unusedQuotaTimer==null)
			return null;
		
		return unusedQuotaTimer.getUnsigned();
	}
	
	public void setUnusedQuotaTimer(Long value)
	{
		if(value==null)
			this.unusedQuotaTimer = null;
		else
			this.unusedQuotaTimer = new UnusedQuotaTimerImpl(value, null, null);			
	}
	
	public List<RANSecondaryRATUsageReport> getRANSecondaryRATUsageReport()
	{
		return this.ranSecondaryRATUsageReport;
	}
	
	public void setRANSecondaryRATUsageReport(List<RANSecondaryRATUsageReport> value)
	{
		this.ranSecondaryRATUsageReport = value;
	}
	
	public PSCellInfo getPSCellInfo()
	{
		return this.psCellInfo;
	}
	
	public void setPSCellInfo(PSCellInfo value)
	{
		this.psCellInfo = value;
	}
}