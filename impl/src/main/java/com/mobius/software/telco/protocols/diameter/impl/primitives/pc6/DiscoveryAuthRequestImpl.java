package com.mobius.software.telco.protocols.diameter.impl.primitives.pc6;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.AppIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.BannedPDUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.BannedRPAUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryAuthRequest;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryType;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PC5Tech;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCode;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCodeSuffixRange;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppId;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeRestrictedCode;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeRestrictedCodeSuffixRange;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeValidityTimer;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.RequestingRPAUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetPDUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetRPAUID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.ServiceResult;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3854L, vendorId = KnownVendorIDs.TGPP_ID)
public class DiscoveryAuthRequestImpl extends DiameterGroupedAvpImpl implements DiscoveryAuthRequest
{
	private DiscoveryType discoveryType;
	private UserIdentity userIdentity;
	private ProSeAppId proSeAppID;
	private ProSeAppCode proSeAppCode;
	private ProSeAppCodeSuffixRange proSeAppCodeSuffixRange;
	private ProSeValidityTimer proSeValidityTimer;
	private AppIdentifier appIdentifier;
	private RequestingRPAUID requestingRPAUID;
	private TargetRPAUID targetRPAUID;
	private TargetPDUID targetPDUID;
	private ProSeRestrictedCode proSeRestrictedCode; 	 
	private List<ProSeRestrictedCodeSuffixRange> proSeRestrictedCodeSuffixRange;
	private BannedRPAUID bannedRPAUID;
	private BannedPDUID bannedPDUID;
	private ServiceResult serviceResult;
	private PC5Tech pc5Tech;
			 
	protected DiscoveryAuthRequestImpl() 
	{
	}
	
	public DiscoveryAuthRequestImpl(DiscoveryTypeEnum discoveryType)
	{
		if(discoveryType==null)
			throw new IllegalArgumentException("Discovery-Type is required");
		
		this.discoveryType = new DiscoveryTypeImpl(discoveryType, null, null);						
	}
	
	public DiscoveryTypeEnum getDiscoveryType()
	{
		if(discoveryType==null)
			return null;
		
		return discoveryType.getEnumerated(DiscoveryTypeEnum.class);
	}
	
	public void setDiscoveryType(DiscoveryTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("Discovery-Type is required");
		
		this.discoveryType = new DiscoveryTypeImpl(value, null, null);						
	}
	
	public UserIdentity getUserIdentity()
	{
		return userIdentity;
	}
	
	public void setUserIdentity(UserIdentity value)
	{
		this.userIdentity = value;
	}
	
	public String getProSeAppId()
	{
		if(proSeAppID==null)
			return null;
		
		return proSeAppID.getString();
	}
	
	
	public void setProSeAppId(String value)
	{
		if(value==null)
			this.proSeAppID = null;
		else
			this.proSeAppID = new ProSeAppIdImpl(value, null, null);			
	}
	
	public ByteBuf getProSeAppCode()
	{
		if(proSeAppCode==null)
			return null;
		
		return proSeAppCode.getValue();
	}
	
	public void setProSeAppCode(ByteBuf value)
	{
		if(value==null)
			this.proSeAppCode = null;
		else
			this.proSeAppCode = new ProSeAppCodeImpl(value, null, null);			
	}
	
	public ProSeAppCodeSuffixRange getProSeAppCodeSuffixRange()
	{
		return proSeAppCodeSuffixRange;
	}
	
	public void setProSeAppCodeSuffixRange(ProSeAppCodeSuffixRange value)
	{
		this.proSeAppCodeSuffixRange = value;
	}
	
	public Long getProSeValidityTimer()
	{
		if(proSeValidityTimer==null)
			return null;
		
		return proSeValidityTimer.getUnsigned();
	}
	
	public void setProSeValidityTimer(Long value)
	{
		if(value==null)
			this.proSeValidityTimer = null;
		else
			this.proSeValidityTimer = new ProSeValidityTimerImpl(value, null, null);			
	}
	
	public AppIdentifier getAppIdentifier()
	{
		return appIdentifier;
	}
	
	public void setAppIdentifier(AppIdentifier value)
	{
		this.appIdentifier = value;
	}
	
	public String getRequestingRPAUID()
	{
		if(requestingRPAUID==null)
			return null;
		
		return requestingRPAUID.getString();
	}
	
	public void setRequestingRPAUID(String value)
	{
		if(value==null)
			this.requestingRPAUID = null;
		else
			this.requestingRPAUID = new RequestingRPAUIDImpl(value, null, null);			
	}
	
	public String getTargetRPAUID()
	{
		if(targetRPAUID==null)
			return null;
		
		return targetRPAUID.getString();
	}
	
	public void setTargetRPAUID(String value)
	{
		if(value==null)
			this.targetRPAUID = null;
		else
			this.targetRPAUID = new TargetRPAUIDImpl(value, null, null);			
	}
	
	public ByteBuf getTargetPDUID()
	{
		if(targetPDUID==null)
			return null;
		
		return targetPDUID.getValue();
	}
	
	public void setTargetPDUID(ByteBuf value)
	{
		if(value==null)
			this.targetPDUID = null;
		else
			this.targetPDUID = new TargetPDUIDImpl(value, null, null);			
	}
	
	public ByteBuf getProSeRestrictedCode()
	{
		if(proSeRestrictedCode==null)
			return null;
		
		return proSeRestrictedCode.getValue();
	}
	
	public void setProSeRestrictedCode(ByteBuf value)
	{
		if(value==null)
			this.proSeRestrictedCode = null;
		else
			this.proSeRestrictedCode = new ProSeRestrictedCodeImpl(value, null, null);			
	}
	
	public List<ProSeRestrictedCodeSuffixRange> getProSeRestrictedCodeSuffixRange()
	{
		return this.proSeRestrictedCodeSuffixRange;
	}
	
	public void setProSeRestrictedCodeSuffixRange(List<ProSeRestrictedCodeSuffixRange> value)
	{
		this.proSeRestrictedCodeSuffixRange = value;
	}
	
	public String getBannedRPAUID()
	{
		if(bannedRPAUID==null)
			return null;
		
		return bannedRPAUID.getString();
	}
	
	public void setBannedRPAUID(String value)
	{
		if(value==null)
			this.bannedRPAUID = null;
		else
			this.bannedRPAUID = new BannedRPAUIDImpl(value, null, null);			
	}
	
	public ByteBuf getBannedPDUID()
	{
		if(bannedPDUID==null)
			return null;
		
		return bannedPDUID.getValue();
	}
	
	public void setBannedPDUID(ByteBuf value)
	{
		if(value==null)
			this.bannedPDUID = null;
		else
			this.bannedPDUID = new BannedPDUIDImpl(value, null, null);			
	}
	
	public ServiceResult getServiceResult()
	{
		return serviceResult;
	}
	
	public void setServiceResult(ServiceResult value)
	{
		this.serviceResult = value;
	}
	
	public ByteBuf getPC5Tech()
	{
		if(pc5Tech==null)
			return null;
		
		return pc5Tech.getValue();
	}
	
	public void setPC5Tech(ByteBuf value)
	{
		if(value==null)
			this.pc5Tech = null;
		else
			this.pc5Tech = new PC5TechImpl(value, null, null);			
	}
	
	@DiameterValidate
	public String validate()
	{
		if(discoveryType==null)
			return "Discovery-Type is required";
		
		return null;
	}
}