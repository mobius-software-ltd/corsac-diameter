package com.mobius.software.telco.protocols.diameter.impl.commands.s6a;

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6a.UpdateLocationRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.CoupledNodeDiameterIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.HomogeneousSupportOfIMSVoiceOverPSSessionsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MMENumberForMTSMSImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SGSNNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SGsMMEIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SMSRegisterRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UESRVCCCapabilityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.ULRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.VisitedPLMNIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.GMLCAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ActiveAPN;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.AdjacentPLMNs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CoupledNodeDiameterID;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.EquivalentPLMNList;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.HomogeneousSupportOfIMSVoiceOverPSSessions;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.HomogeneousSupportOfIMSVoiceOverPSSessionsEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MMENumberForMTSMS;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SGSNNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SGsMMEIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SMSRegisterRequest;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SMSRegisterRequestEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.TerminalInformation;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UESRVCCCapability;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UESRVCCCapabilityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ULRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VisitedPLMNId;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;
import com.mobius.software.telco.protocols.diameter.primitives.slh.GMLCAddress;

import io.netty.buffer.ByteBuf;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
@DiameterCommandImplementation(applicationId = 16777251, commandCode = 316, request = true)
public class UpdateLocationRequestImpl extends S6aRequestImpl implements UpdateLocationRequest
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private TerminalInformation terminalInformation;
	
	private RATType ratType;
	
	private ULRFlags ulrFlags;
	
	private UESRVCCCapability ueSRVCCCapability;
	
	private VisitedPLMNId visitedPLMNId;
	
	private SGSNNumber sgsnNumber;
	
	private HomogeneousSupportOfIMSVoiceOverPSSessions homogeneousSupportOfIMSVoiceOverPSSessions;
	
	private GMLCAddress gmlcAddress;
	
	private List<ActiveAPN> activeAPN;
	
	private EquivalentPLMNList equivalentPLMNList;
	
	private MMENumberForMTSMS mmeNumberForMTSMS;
	
	private SMSRegisterRequest smsRegisterRequest;
	
	private SGsMMEIdentity sgsMMEIdentity;
	
	private CoupledNodeDiameterID coupledNodeDiameterID;
	
	private AdjacentPLMNs adjacentPLMNs;
	
	private SupportedServices supportedServices;
	
	protected UpdateLocationRequestImpl() 
	{
		super();
	}
	
	public UpdateLocationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,RATTypeEnum ratType,Long ulrFlags,ByteBuf visitedPLMNId)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setRATType(ratType);
		
		setULRFlags(ulrFlags);
		
		setVisitedPLMNId(visitedPLMNId);
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	 
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public TerminalInformation getTerminalInformation()
	{
		return this.terminalInformation;
	}
	 
	@Override
	public void setTerminalInformation(TerminalInformation value)
	{
		this.terminalInformation = value;
	}
	
	@Override
	public RATTypeEnum getRATType()
	{
		if(ratType == null)
			return null;
		
		return ratType.getEnumerated(RATTypeEnum.class);
	}
	
	@Override
	public void setRATType(RATTypeEnum value)
	{
		if(value == null)
			throw new IllegalArgumentException("RAT-Type is required");
		
		this.ratType = new RATTypeImpl(value, null, null);
	}
	
	@Override
	public Long getULRFlags()
	{
		if(ulrFlags == null)
			return null;
		
		return ulrFlags.getUnsigned();
	}
	
	@Override
	public void setULRFlags(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("ULR-Flags is required");
		
		this.ulrFlags = new ULRFlagsImpl(value, null, null);
	}
	
	@Override
	public UESRVCCCapabilityEnum getUESRVCCCapability()
	{
		if(ueSRVCCCapability == null)
			return null;
		
		return ueSRVCCCapability.getEnumerated(UESRVCCCapabilityEnum.class);
	}
	
	@Override
	public void setUESRVCCCapability(UESRVCCCapabilityEnum value)
	{
		if(value == null)
			this.ueSRVCCCapability = null;
		else
			this.ueSRVCCCapability = new UESRVCCCapabilityImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getVisitedPLMNId()
	{
		if(visitedPLMNId == null)
			return null;
		
		return visitedPLMNId.getValue();
	}
	 
	@Override
	public void setVisitedPLMNId(ByteBuf value)
	{
		if(value == null)
			throw new IllegalArgumentException("Visited-PLMN-Id is required");
		
		this.visitedPLMNId = new VisitedPLMNIdImpl(value, null, null);
	}
		
	@Override
	public String getSGSNNumber()
	{
		if(sgsnNumber == null)
			return null;
		
		return sgsnNumber.getAddress();
	}
	
	@Override
	public void setSGSNNumber(String value)
	{
		if(value == null)
			this.sgsnNumber = null;
		else
			this.sgsnNumber = new SGSNNumberImpl(value);
	}	
	
	@Override
	public HomogeneousSupportOfIMSVoiceOverPSSessionsEnum getHomogeneousSupportOfIMSVoiceOverPSSessions()
	{
		if(homogeneousSupportOfIMSVoiceOverPSSessions == null)
			return null;
		
		return homogeneousSupportOfIMSVoiceOverPSSessions.getEnumerated(HomogeneousSupportOfIMSVoiceOverPSSessionsEnum.class);
	}
	
	@Override
	public void setHomogeneousSupportOfIMSVoiceOverPSSessions(HomogeneousSupportOfIMSVoiceOverPSSessionsEnum value)
	{
		if(value == null)
			this.homogeneousSupportOfIMSVoiceOverPSSessions = null;
		else
			this.homogeneousSupportOfIMSVoiceOverPSSessions = new HomogeneousSupportOfIMSVoiceOverPSSessionsImpl(value, null, null);
	}	
	
	@Override
	public InetAddress getGMLCAddress()
	{
		if(gmlcAddress == null)
			return null;
		
		return gmlcAddress.getAddress();
	}
	
	@Override
	public void setGMLCAddress(InetAddress value)
	{
		if(value == null)
			this.gmlcAddress = null;
		else
			this.gmlcAddress = new GMLCAddressImpl(value, null, null);
	}
	
	@Override
	public List<ActiveAPN> getActiveAPN()
	{
		return this.activeAPN;
	}
	
	@Override
	public void setActiveAPN(List<ActiveAPN> value)
	{
		this.activeAPN = value;
	}
	
	@Override
	public EquivalentPLMNList getEquivalentPLMNList()
	{
		return this.equivalentPLMNList;
	}
	
	@Override
	public void setEquivalentPLMNList(EquivalentPLMNList value)
	{
		this.equivalentPLMNList = value;
	}	
	
	@Override
	public String getMMENumberForMTSMS()
	{
		if(mmeNumberForMTSMS == null)
			return null;
		
		return mmeNumberForMTSMS.getAddress();
	}
	
	@Override
	public void setMMENumberForMTSMS(String value)
	{
		if(value == null)
			this.mmeNumberForMTSMS = null;
		else
			this.mmeNumberForMTSMS = new MMENumberForMTSMSImpl(value);
	}
	
	@Override
	public SMSRegisterRequestEnum getSMSRegisterRequest()
	{
		if(smsRegisterRequest == null)
			return null;
		
		return smsRegisterRequest.getEnumerated(SMSRegisterRequestEnum.class);
	}
	
	@Override
	public void setSMSRegisterRequest(SMSRegisterRequestEnum value)
	{
		if(value == null)
			this.smsRegisterRequest = null;
		else
			this.smsRegisterRequest = new SMSRegisterRequestImpl(value, null, null);
	}		
	
	@Override
	public String getSGsMMEIdentity()
	{
		if(sgsMMEIdentity == null)
			return null;
		
		return sgsMMEIdentity.getString();
	}
	
	@Override
	public void setSGsMMEIdentity(String value)
	{
		if(value == null)
			this.sgsMMEIdentity = null;
		else
			this.sgsMMEIdentity = new SGsMMEIdentityImpl(value, null, null);
	}
	
	@Override
	public String getCoupledNodeDiameterID()
	{
		if(coupledNodeDiameterID == null)
			return null;
		
		return coupledNodeDiameterID.getIdentity();
	}
	
	@Override
	public void setCoupledNodeDiameterID(String value)
	{
		if(value == null)
			this.coupledNodeDiameterID = null;
		else
			this.coupledNodeDiameterID = new CoupledNodeDiameterIDImpl(value, null, null);
	}
	
	@Override
	public AdjacentPLMNs getAdjacentPLMNs()
	{
		return this.adjacentPLMNs;
	}
	
	@Override
	public void setAdjacentPLMNs(AdjacentPLMNs value)
	{
		this.adjacentPLMNs = value;
	}	
	
	@Override
	public SupportedServices getSupportedServices()
	{
		return this.supportedServices;
	}
	
	@Override
	public void setSupportedServices(SupportedServices value)
	{
		this.supportedServices = value;
	}		
	
	@DiameterValidate
	public String validate()
	{
		if(ratType == null)
			return "RAT-Type is required";
		
		if(ulrFlags == null)
			return "ULR-Flags is required";
		
		if(visitedPLMNId == null)
			return "Visited-PLMN-Id is required";
		
		return super.validate();
	}	
}