package com.mobius.software.telco.protocols.diameter.impl.primitives.s6a;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ServedPartyIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.VisitedNetworkIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServedPartyIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.VisitedNetworkIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5447.MIP6AgentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNOIReplacement;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EPSSubscribedQoSProfile;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EthernetPDNTypeIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EthernetPDNTypeIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.Interworking5GSIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.Interworking5GSIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LIPAPermission;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LIPAPermissionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPDataDeliveryMechanism;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPDataDeliveryMechanismEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPPDNTypeIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPPDNTypeIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNConnectionContinuity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNConnectionContinuityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNGWAllocationType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNGWAllocationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PreferredDataMode;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RDSIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RDSIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RestorationPriority;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SCEFRealm;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SIPTOLocalNetworkPermission;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SIPTOLocalNetworkPermissionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SIPTOPermission;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SIPTOPermissionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SpecificAPNInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VPLMNDynamicAddressAllowed;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VPLMNDynamicAddressAllowedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.WLANOffloadability;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 1430L, vendorId = KnownVendorIDs.TGPP_ID)
public class APNConfigurationImpl extends DiameterGroupedAvpImpl implements APNConfiguration
{
	private ContextIdentifier contextIdentifier;
	private List<ServedPartyIPAddress> servedPartyIPAddress;
	private PDNType pdnType;
	private ServiceSelection serviceSelection;
	private EPSSubscribedQoSProfile epsSubscribedQoSProfile;
	private VPLMNDynamicAddressAllowed vplmNDynamicAddressAllowed;
	private MIP6AgentInfo mip6AgentInfo;
	private VisitedNetworkIdentifier visitedNetworkIdentifier;
	private PDNGWAllocationType pdnGWAllocationType;
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	private AMBR ambr;
	private List<SpecificAPNInfo> specificAPNInfo;
	private APNOIReplacement apnOIReplacement;
	private SIPTOPermission sipTOPermission;
	private LIPAPermission lipaPermission;
	private RestorationPriority restorationPriority;
	private SIPTOLocalNetworkPermission sipTOLocalNetworkPermission;
	private WLANOffloadability wlanOffloadability;
	private NonIPPDNTypeIndicator nonIPPDNTypeIndicator;
	private NonIPDataDeliveryMechanism nonIPDataDeliveryMechanism;
	private SCEFID scefId;
	private SCEFRealm scefRealm;
	private PreferredDataMode preferredDataMode;
	private PDNConnectionContinuity pdnConnectionContinuity;
	private RDSIndicator rdsIndicator;
	private Interworking5GSIndicator interworking5GSIndicator;
	private EthernetPDNTypeIndicator ethernetPDNTypeIndicator;
					
	protected APNConfigurationImpl() 
	{
	}
	
	public APNConfigurationImpl(Long contextIdentifier,PDNTypeEnum pdnType,String serviceSelection)
	{
		if(contextIdentifier==null)
			throw new IllegalArgumentException("Context-Identifier is required");
		
		if(pdnType==null)
			throw new IllegalArgumentException("PDN-Type is required");
		
		if(serviceSelection==null)
			throw new IllegalArgumentException("Service-Selection is required");
		
		this.contextIdentifier = new ContextIdentifierImpl(contextIdentifier, null, null);				
		
		this.pdnType = new PDNTypeImpl(pdnType, null, null);
		
		this.serviceSelection = new ServiceSelectionImpl(serviceSelection, null, null);
	}
	
	public Long getContextIdentifier()
	{
		if(contextIdentifier==null)
			return null;
		
		return contextIdentifier.getUnsigned();
	}
	
	public void setContextIdentifier(Long value)
	{
		if(value==null)
			throw new IllegalArgumentException("Context-Identifier is required");
		
		this.contextIdentifier = new ContextIdentifierImpl(value, null, null);	
	}
	
	public List<InetAddress> getServedPartyIPAddress()
	{
		if(servedPartyIPAddress==null || servedPartyIPAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(ServedPartyIPAddress curr:servedPartyIPAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setServedPartyIPAddress(List<InetAddress> value)
	{
		if(value!=null && value.size()>2)
			throw new IllegalArgumentException("Up to 2 Served-Party-IP-Address allowed");	
		
		if(value==null || value.size()==0)
			this.servedPartyIPAddress = null;
		else
		{
			this.servedPartyIPAddress = new ArrayList<ServedPartyIPAddress>();
			for(InetAddress curr:value)
				this.servedPartyIPAddress.add(new ServedPartyIPAddressImpl(curr, null, null));
		}
	}
	
	public PDNTypeEnum getPDNType()
	{
		if(pdnType == null)
			return null;
		
		return pdnType.getEnumerated(PDNTypeEnum.class);
	}
	
	public void setPDNType(PDNTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("PDN-Type is required");
		
		this.pdnType = new PDNTypeImpl(value, null, null);
	}
	
	public String getServiceSelection()
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}
	
	public void setServiceSelection(String value)
	{
		if(value==null)
			throw new IllegalArgumentException("Service-Selection is required");
		
		this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}
	
	public EPSSubscribedQoSProfile getEPSSubscribedQoSProfile()
	{
		return epsSubscribedQoSProfile;
	}
	
	public void setEPSSubscribedQoSProfile(EPSSubscribedQoSProfile value)
	{
		this.epsSubscribedQoSProfile = value;
	}
	
	public VPLMNDynamicAddressAllowedEnum getVPLMNDynamicAddressAllowed()
	{
		if(vplmNDynamicAddressAllowed == null)
			return null;
		
		return vplmNDynamicAddressAllowed.getEnumerated(VPLMNDynamicAddressAllowedEnum.class);
	}
	
	public void setVPLMNDynamicAddressAllowed(VPLMNDynamicAddressAllowedEnum value)
	{
		if(value==null)
			this.vplmNDynamicAddressAllowed = null;
		else
			this.vplmNDynamicAddressAllowed = new VPLMNDynamicAddressAllowedImpl(value, null, null);			
	}
	
	public MIP6AgentInfo getMIP6AgentInfo()
	{
		return mip6AgentInfo;
	}
	
	public void setMIP6AgentInfo(MIP6AgentInfo value)
	{
		this.mip6AgentInfo = value;
	}
	
	public ByteBuf getVisitedNetworkIdentifier()
	{
		if(visitedNetworkIdentifier == null)
			return null;
		
		return visitedNetworkIdentifier.getValue();
	}
	
	public void setVisitedNetworkIdentifier(ByteBuf value)
	{
		if(value==null)
			this.visitedNetworkIdentifier = null;
		else
			this.visitedNetworkIdentifier = new VisitedNetworkIdentifierImpl(value, null, null);			
	}
	
	public PDNGWAllocationTypeEnum getPDNGWAllocationType()
	{
		if(pdnGWAllocationType == null)
			return null;
		
		return pdnGWAllocationType.getEnumerated(PDNGWAllocationTypeEnum.class);
	}
	
	public void setPDNGWAllocationType(PDNGWAllocationTypeEnum value)
	{
		if(value==null)
			this.pdnGWAllocationType = null;
		else
			this.pdnGWAllocationType = new PDNGWAllocationTypeImpl(value, null, null);			
	}
	
	public String getTGPPChargingCharacteristics()
	{
		if(tgppChargingCharacteristics == null)
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
	
	public AMBR getAMBR()
	{
		return ambr;
	}
	
	public void setAMBR(AMBR value)
	{
		this.ambr = value;
	}
	
	public List<SpecificAPNInfo> getSpecificAPNInfo()
	{
		return specificAPNInfo;
	}
	
	public void setSpecificAPNInfo(List<SpecificAPNInfo> value)
	{
		this.specificAPNInfo = value;
	}
	
	public String getAPNOIReplacement()
	{
		if(apnOIReplacement == null)
			return null;
		
		return apnOIReplacement.getString();
	}
	
	public void setAPNOIReplacement(String value)
	{
		if(value==null)
			this.apnOIReplacement = null;
		else
			this.apnOIReplacement = new APNOIReplacementImpl(value, null, null);			
	}
	
	public SIPTOPermissionEnum getSIPTOPermission()
	{
		if(sipTOPermission == null)
			return null;
		
		return sipTOPermission.getEnumerated(SIPTOPermissionEnum.class);
	}
	
	public void setSIPTOPermission(SIPTOPermissionEnum value)
	{
		if(value==null)
			this.sipTOPermission = null;
		else
			this.sipTOPermission = new SIPTOPermissionImpl(value, null, null);			
	}
	
	public LIPAPermissionEnum getLIPAPermission()
	{
		if(lipaPermission == null)
			return null;
		
		return lipaPermission.getEnumerated(LIPAPermissionEnum.class);
	}
	
	public void setLIPAPermission(LIPAPermissionEnum value)
	{
		if(value==null)
			this.lipaPermission = null;
		else
			this.lipaPermission = new LIPAPermissionImpl(value, null, null);			
	}
	
	public Long getRestorationPriority()
	{
		if(restorationPriority == null)
			return null;
		
		return restorationPriority.getUnsigned();
	}
	
	public void setRestorationPriority(Long value)
	{
		if(value==null)
			this.restorationPriority = null;
		else
			this.restorationPriority = new RestorationPriorityImpl(value, null, null);			
	}
	
	public SIPTOLocalNetworkPermissionEnum getSIPTOLocalNetworkPermission()
	{
		if(sipTOLocalNetworkPermission == null)
			return null;
		
		return sipTOLocalNetworkPermission.getEnumerated(SIPTOLocalNetworkPermissionEnum.class);
	}
	
	public void setSIPTOLocalNetworkPermission(SIPTOLocalNetworkPermissionEnum value)
	{
		if(value==null)
			this.sipTOLocalNetworkPermission = null;
		else
			this.sipTOLocalNetworkPermission = new SIPTOLocalNetworkPermissionImpl(value, null, null);			
	}
	
	public WLANOffloadability getWLANOffloadability()
	{
		return wlanOffloadability;
	}
	
	public void setWLANOffloadability(WLANOffloadability value)
	{
		this.wlanOffloadability = value;			
	}
	
	public NonIPPDNTypeIndicatorEnum getNonIPPDNTypeIndicator()
	{
		if(nonIPPDNTypeIndicator == null)
			return null;
		
		return nonIPPDNTypeIndicator.getEnumerated(NonIPPDNTypeIndicatorEnum.class);
	}
	
	public void setNonIPPDNTypeIndicator(NonIPPDNTypeIndicatorEnum value)
	{
		if(value==null)
			this.nonIPPDNTypeIndicator = null;
		else
			this.nonIPPDNTypeIndicator = new NonIPPDNTypeIndicatorImpl(value, null, null);			
	}
	
	public NonIPDataDeliveryMechanismEnum getNonIPDataDeliveryMechanism()
	{
		if(nonIPDataDeliveryMechanism == null)
			return null;
		
		return nonIPDataDeliveryMechanism.getEnumerated(NonIPDataDeliveryMechanismEnum.class);
	}
	
	public void setNonIPDataDeliveryMechanism(NonIPDataDeliveryMechanismEnum value)
	{
		if(value==null)
			this.nonIPDataDeliveryMechanism = null;
		else
			this.nonIPDataDeliveryMechanism = new NonIPDataDeliveryMechanismImpl(value, null, null);			
	}
	
	public String getSCEFID()
	{
		if(scefId == null)
			return null;
		
		return scefId.getIdentity();
	}
	
	public void setSCEFID(String value)
	{
		if(value==null)
			this.scefId = null;
		else
			this.scefId = new SCEFIDImpl(value, null, null);			
	}
	
	public String getSCEFRealm()
	{
		if(scefRealm == null)
			return null;
		
		return scefRealm.getIdentity();
	}
	
	public void setSCEFRealm(String value)
	{
		if(value==null)
			this.scefRealm = null;
		else
			this.scefRealm = new SCEFRealmImpl(value, null, null);			
	}
	
	public Long getPreferredDataMode()
	{
		if(preferredDataMode == null)
			return null;
		
		return preferredDataMode.getUnsigned();
	}
	
	public void setPreferredDataMode(Long value)
	{
		if(value==null)
			this.preferredDataMode = null;
		else
			this.preferredDataMode = new PreferredDataModeImpl(value, null, null);			
	}
	
	public PDNConnectionContinuityEnum getPDNConnectionContinuity()
	{
		if(pdnConnectionContinuity == null)
			return null;
		
		return pdnConnectionContinuity.getEnumerated(PDNConnectionContinuityEnum.class);
	}
	
	public void setPDNConnectionContinuity(PDNConnectionContinuityEnum value)
	{
		if(value==null)
			this.pdnConnectionContinuity = null;
		else
			this.pdnConnectionContinuity = new PDNConnectionContinuityImpl(value, null, null);			
	}
	
	public RDSIndicatorEnum getRDSIndicator()
	{
		if(rdsIndicator == null)
			return null;
		
		return rdsIndicator.getEnumerated(RDSIndicatorEnum.class);
	}
	
	public void setRDSIndicator(RDSIndicatorEnum value)
	{
		if(value==null)
			this.rdsIndicator = null;
		else
			this.rdsIndicator = new RDSIndicatorImpl(value, null, null);			
	}
	
	public Interworking5GSIndicatorEnum getInterworking5GSIndicator()
	{
		if(interworking5GSIndicator == null)
			return null;
		
		return interworking5GSIndicator.getEnumerated(Interworking5GSIndicatorEnum.class);
	}
	
	public void setInterworking5GSIndicator(Interworking5GSIndicatorEnum value)
	{
		if(value==null)
			this.interworking5GSIndicator = null;
		else
			this.interworking5GSIndicator = new Interworking5GSIndicatorImpl(value, null, null);			
	}
	
	public EthernetPDNTypeIndicatorEnum getEthernetPDNTypeIndicator()
	{
		if(ethernetPDNTypeIndicator == null)
			return null;
		
		return ethernetPDNTypeIndicator.getEnumerated(EthernetPDNTypeIndicatorEnum.class);
	}
	
	public void setEthernetPDNTypeIndicator(EthernetPDNTypeIndicatorEnum value)
	{
		if(value==null)
			this.ethernetPDNTypeIndicator = null;
		else
			this.ethernetPDNTypeIndicator = new EthernetPDNTypeIndicatorImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(contextIdentifier==null)
			return "Context-Identifier is required";
		
		if(servedPartyIPAddress!=null && servedPartyIPAddress.size()>2)
			return "Up to 2 Served-Party-IP-Address allowed";
		
		if(pdnType==null)
			return "PDN-Type is required";
		
		if(serviceSelection==null)
			return "Service-Selection is required";
		
		return null;
	}
}