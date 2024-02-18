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
import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PDPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingCharacteristicsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingCharacteristics;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AMBR;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.APNOIReplacement;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ContextIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ExtPDPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ExtPDPType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LIPAPermission;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.LIPAPermissionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPDataDeliveryMechanism;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.NonIPDataDeliveryMechanismEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDPContext;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDPType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.QoSSubscribed;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.RestorationPriority;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SIPTOLocalNetworkPermission;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SIPTOLocalNetworkPermissionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SIPTOPermission;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SIPTOPermissionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VPLMNDynamicAddressAllowed;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VPLMNDynamicAddressAllowedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class PDPContextImpl extends DiameterGroupedAvpImpl implements PDPContext
{
	private ContextIdentifier contextIdentifier;
	private PDPType pdpType;
	private PDPAddress pdpAddress;
	private QoSSubscribed qoSSubscribed;
	private VPLMNDynamicAddressAllowed vplmNDynamicAddressAllowed;
	private ServiceSelection serviceSelection;
	private TGPPChargingCharacteristics tgppChargingCharacteristics;
	private ExtPDPType extPDPType;
	private ExtPDPAddress extPDPAddress;
	private AMBR ambr;
	private APNOIReplacement apnOIReplacement;
	private SIPTOPermission sipTOPermission;
	private LIPAPermission lipaPermission;
	private RestorationPriority restorationPriority;
	private SIPTOLocalNetworkPermission sipTOLocalNetworkPermission;
	private NonIPDataDeliveryMechanism nonIPDataDeliveryMechanism;
	private SCEFID scefId;
			
	protected PDPContextImpl() 
	{
	}
	
	public PDPContextImpl(Long contextIdentifier,ByteBuf qoSSubscribed ,String serviceSelection) throws MissingAvpException
	{
		setContextIdentifier(contextIdentifier);
		
		setQoSSubscribed(qoSSubscribed);
		
		setServiceSelection(serviceSelection);
	}
	
	public Long getContextIdentifier()
	{
		if(contextIdentifier==null)
			return null;
		
		return contextIdentifier.getUnsigned();
	}
	
	public void setContextIdentifier(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Context-Identifier is required", Arrays.asList(new DiameterAvp[] { new ContextIdentifierImpl() }));
		
		this.contextIdentifier = new ContextIdentifierImpl(value, null, null);	
	}	
	
	public ByteBuf getPDPType()
	{
		if(pdpType==null)
			return null;
		
		return pdpType.getValue();
	}
	
	public void setPDPType(ByteBuf value)
	{
		if(value==null)
			this.pdpType = null;
		else
			this.pdpType = new PDPTypeImpl(value, null, null);			
	}
	
	public InetAddress getPDPAddress()
	{
		if(pdpAddress==null)
			return null;
		
		return pdpAddress.getAddress();
	}
	
	public void setPDPAddress(InetAddress value)
	{
		if(value==null)
			this.pdpAddress = null;
		else
			this.pdpAddress = new PDPAddressImpl(value, null, null);			
	}
	
	public ByteBuf getQoSSubscribed()
	{
		if(qoSSubscribed==null)
			return null;
		
		return qoSSubscribed.getValue();
	}
	
	public void setQoSSubscribed(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("QoS-Subscribed is required", Arrays.asList(new DiameterAvp[] { new QoSSubscribedImpl() }));
		
		this.qoSSubscribed = new QoSSubscribedImpl(value, null, null);	
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
	
	public String getServiceSelection()
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}
	
	public void setServiceSelection(String value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Service-Selection is required", Arrays.asList(new DiameterAvp[] { new ServiceSelectionImpl() }));
		
		this.serviceSelection = new ServiceSelectionImpl(value, null, null);
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
	
	public ByteBuf getExtPDPType()
	{
		if(extPDPType==null)
			return null;
		
		return extPDPType.getValue();
	}
	
	public void setExtPDPType(ByteBuf value)
	{
		if(value==null)
			this.extPDPType = null;
		else
			this.extPDPType = new ExtPDPTypeImpl(value, null, null);			
	}
	
	public InetAddress getExtPDPAddress()
	{
		if(extPDPAddress==null)
			return null;
		
		return extPDPAddress.getAddress();
	}
	
	public void setExtPDPAddress(InetAddress value)
	{
		if(value==null)
			this.extPDPAddress = null;
		else
			this.extPDPAddress = new ExtPDPAddressImpl(value, null, null);			
	}
	
	public AMBR getAMBR()
	{
		return ambr;
	}
	
	public void setAMBR(AMBR value)
	{
		this.ambr = value;
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
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(contextIdentifier==null)
			return new MissingAvpException("Context-Identifier is required", Arrays.asList(new DiameterAvp[] { new ContextIdentifierImpl() }));
		
		if(qoSSubscribed==null)
			return new MissingAvpException("QoS-Subscribed is required", Arrays.asList(new DiameterAvp[] { new QoSSubscribedImpl() }));
		
		if(serviceSelection==null)
			return new MissingAvpException("Service-Selection is required", Arrays.asList(new DiameterAvp[] { new ServiceSelectionImpl() }));
		
		return null;
	}
}