package com.mobius.software.telco.protocols.diameter.impl.commands.slg;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.slg.ProvideLocationRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.LCSClientTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5778.ServiceSelectionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.IMEIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSCodewordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSPriorityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSReferenceNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSServiceTypeIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.SLgLocationTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.SupportedGADShapesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.VelocityRequestedImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.GMLCAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5778.ServiceSelection;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMEI;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AreaEventInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.DeferredLocationType;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSCodeword;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSEPSClientName;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSPriority;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSPrivacyCheckNonSession;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSPrivacyCheckSession;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSQoS;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSReferenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSRequestorName;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSServiceTypeID;
import com.mobius.software.telco.protocols.diameter.primitives.slg.MotionEventInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PLRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slg.PeriodicLDRInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingPLMNList;
import com.mobius.software.telco.protocols.diameter.primitives.slg.SLgLocationType;
import com.mobius.software.telco.protocols.diameter.primitives.slg.SLgLocationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.SupportedGADShapes;
import com.mobius.software.telco.protocols.diameter.primitives.slg.VelocityRequested;
import com.mobius.software.telco.protocols.diameter.primitives.slg.VelocityRequestedEnum;
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
@DiameterCommandImplementation(applicationId = 16777255, commandCode = 8388620, request = true)
public class ProvideLocationRequestImpl extends SlgRequestImpl implements ProvideLocationRequest
{
	private SLgLocationType slgLocationType;
	
	private MSISDN msisdn;
	
	private IMEI imei;
	 
	private LCSEPSClientName lcsEPSClientName;
	
	private LCSClientType lcsClientType;
	
	private LCSRequestorName lcsRequestorName;
	
	private LCSPriority lcsPriority;
	
	private LCSQoS lcsQoS;
	
	private VelocityRequested velocityRequested;
	
	private SupportedGADShapes lcsSupportedGADShapes;
	
	private LCSServiceTypeID lcsServiceTypeID;
	
	private LCSCodeword lcsCodeword;
	
	private LCSPrivacyCheckNonSession lcsPrivacyCheckNonSession;
	
	private LCSPrivacyCheckSession LcsPrivacyCheckSession;
	
	private ServiceSelection serviceSelection;
	
	private DeferredLocationType deferredLocationType;
	
	private LCSReferenceNumber lcsReferenceNumber;
	
	private AreaEventInfo areaEventInfo;
	
	private GMLCAddress gmlcAddress;
	
	private PLRFlags plrFlags;
	
	private PeriodicLDRInfo periodicLDRInformation;
	
	private ReportingPLMNList reportingPLMNList;
	
	private MotionEventInfo motionEventInfo;
	
	protected ProvideLocationRequestImpl() 
	{
		super();
	}
	
	public ProvideLocationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,SLgLocationTypeEnum slgLocationType,LCSEPSClientName lcsEPSClientName,LCSClientTypeEnum lcsClientType)
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setSLgLocationType(slgLocationType);
		
		setLCSEPSClientName(lcsEPSClientName);
		
		setLCSClientType(lcsClientType);
	}
	
	@Override
	public SLgLocationTypeEnum getSLgLocationType()
	{
		if(slgLocationType == null)
			return null;
		
		return slgLocationType.getEnumerated(SLgLocationTypeEnum.class);
	}
	
	@Override
	public void setSLgLocationType(SLgLocationTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("SLg-Location-Type is required");
			
		this.slgLocationType = new SLgLocationTypeImpl(value, null, null);
	}
	
	@Override
	public String getMSISDN()
	{
		if(msisdn == null)
			return null;
		
		return msisdn.getAddress();
	}
	
	@Override
	public void setMSISDN(String value)
	{
		if(value == null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);
	}
	
	@Override
	public String getIMEI()
	{
		if(imei == null)
			return null;
		
		return imei.getString();
	}
	 
	@Override
	public void setIMEI(String value)
	{
		if(value == null)
			this.imei = null;
		else
			this.imei = new IMEIImpl(value, null, null);
	}
	 		
	@Override
	public LCSEPSClientName getLCSEPSClientName()
	{
		return this.lcsEPSClientName;
	}
	
	@Override
	public void setLCSEPSClientName(LCSEPSClientName value)
	{
		if(value==null)
			throw new IllegalArgumentException("LCS-EPS-Client-Name is required");
			
		this.lcsEPSClientName = value;
	}
	
	@Override
	public LCSClientTypeEnum getLCSClientType()
	{
		if(lcsClientType == null)
			return null;
		
		return lcsClientType.getEnumerated(LCSClientTypeEnum.class);
	}
	
	@Override
	public void setLCSClientType(LCSClientTypeEnum value)
	{
		if(value==null)
			throw new IllegalArgumentException("LCS-Client-Type is required");
			
		this.lcsClientType = new LCSClientTypeImpl(value, null, null);
	}
	
	@Override
	public LCSRequestorName getLCSRequestorName()
	{
		return this.lcsRequestorName;
	}
	
	@Override
	public void setLCSRequestorName(LCSRequestorName value)
	{
		this.lcsRequestorName = value;
	}	
	
	@Override
	public Long getLCSPriority()
	{
		if(lcsPriority == null)
			return null;
		
		return lcsPriority.getUnsigned();
	}
	
	@Override
	public void setLCSPriority(Long value)
	{
		if(value == null)
			this.lcsPriority = null;
		else
			this.lcsPriority = new LCSPriorityImpl(value, null, null);
	}
	
	@Override
	public LCSQoS getLCSQoS()
	{
		return this.lcsQoS;
	}
	
	@Override
	public void setLCSQoS(LCSQoS value)
	{
		this.lcsQoS = value;
	}
	
	@Override
	public VelocityRequestedEnum getVelocityRequested()
	{
		if(velocityRequested == null)
			return null;
		
		return velocityRequested.getEnumerated(VelocityRequestedEnum.class);
	}
	
	@Override
	public void setVelocityRequested(VelocityRequestedEnum value)
	{
		if(value == null)
			this.velocityRequested = null;
		else
			this.velocityRequested = new VelocityRequestedImpl(value, null, null);
	}
	
	@Override
	public Long getLCSSupportedGADShapes()
	{
		if(lcsSupportedGADShapes == null)
			return null;
		
		return lcsSupportedGADShapes.getUnsigned();
	}
	
	@Override
	public void setLCSSupportedGADShapes(Long value)
	{
		if(value == null)
			this.lcsSupportedGADShapes = null;
		else
			this.lcsSupportedGADShapes = new SupportedGADShapesImpl(value, null, null);
	}
	
	@Override
	public Long getLCSServiceTypeID()
	{
		if(lcsServiceTypeID == null)
			return null;
		
		return lcsServiceTypeID.getUnsigned();
	}
	
	@Override
	public void setLCSServiceTypeID(Long value)
	{
		if(value == null)
			this.lcsServiceTypeID = null;
		else
			this.lcsServiceTypeID = new LCSServiceTypeIDImpl(value, null, null);
	}	
	
	@Override
	public String getLCSCodeword()
	{
		if(lcsCodeword == null)
			return null;
		
		return lcsCodeword.getString();
	}
	
	@Override
	public void setLCSCodeword(String value)
	{
		if(value == null)
			this.lcsCodeword = null;
		else
			this.lcsCodeword = new LCSCodewordImpl(value, null, null);
	}
	
	@Override
	public LCSPrivacyCheckNonSession getLCSPrivacyCheckNonSession()
	{
		return this.lcsPrivacyCheckNonSession;
	}
	
	@Override
	public void setLCSPrivacyCheckNonSession(LCSPrivacyCheckNonSession value)
	{
		this.lcsPrivacyCheckNonSession = value;
	}
	
	@Override
	public LCSPrivacyCheckSession getLCSPrivacyCheckSession()
	{
		return this.LcsPrivacyCheckSession;
	}
	
	@Override
	public void setLCSPrivacyCheckSession(LCSPrivacyCheckSession value)
	{
		this.LcsPrivacyCheckSession = value;
	}
	
	@Override
	public String getServiceSelection()
	{
		if(serviceSelection == null)
			return null;
		
		return serviceSelection.getString();
	}
	
	@Override
	public void setServiceSelection(String value)
	{
		if(value == null)
			this.serviceSelection = null;
		else
			this.serviceSelection = new ServiceSelectionImpl(value, null, null);
	}
	
	@Override
	public DeferredLocationType getDeferredLocationType()
	{
		return deferredLocationType;
	}
	
	@Override
	public void setDeferredLocationType(DeferredLocationType value)
	{
		this.deferredLocationType = value;
	}	
	
	@Override
	public ByteBuf getLCSReferenceNumber()
	{
		if(lcsReferenceNumber == null)
			return null;
		
		return lcsReferenceNumber.getValue();
	}
	
	@Override
	public void setLCSReferenceNumber(ByteBuf value)
	{
		if(value == null)
			this.lcsReferenceNumber = null;
		else
			this.lcsReferenceNumber = new LCSReferenceNumberImpl(value, null, null);
	}
	
	@Override
	public AreaEventInfo getAreaEventInfo()
	{
		return this.areaEventInfo;
	}
	
	@Override
	public void setAreaEventInfo(AreaEventInfo value)
	{
		this.areaEventInfo = value;				
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
	public PLRFlags getPLRFlags()
	{
		return plrFlags;
	}
	
	@Override
	public void setPLRFlags(PLRFlags value)
	{
		this.plrFlags = value;
	}
	
	@Override
	public PeriodicLDRInfo getPeriodicLDRInformation()
	{
		return this.periodicLDRInformation;
	}
	
	@Override
	public void setPeriodicLDRInformation(PeriodicLDRInfo value)
	{
		this.periodicLDRInformation = value;
	}
	
	@Override
	public ReportingPLMNList getReportingPLMNList()
	{
		return this.reportingPLMNList;
	}
	
	@Override
	public void setReportingPLMNList(ReportingPLMNList value)
	{
		this.reportingPLMNList = value;
	}
	
	@Override
	public MotionEventInfo getMotionEventInfo()
	{
		return this.motionEventInfo;
	}
	
	@Override
	public void setMotionEventInfo(MotionEventInfo value)
	{
		this.motionEventInfo = value;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(slgLocationType == null)
			return "SLg-Location-Type is required";
		
		if(lcsEPSClientName == null)
			return "LCS-EPS-Client-Name is required";
		
		if(lcsClientType == null)
			return "LCS-Client-Type is required";
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(slgLocationType);
		result.add(username);
		result.add(msisdn);
		result.add(imei);
		result.add(lcsEPSClientName);
		result.add(lcsClientType);
		result.add(lcsRequestorName);
		result.add(lcsPriority);
		result.add(lcsQoS);
		result.add(velocityRequested);
		result.add(lcsSupportedGADShapes);
		result.add(lcsServiceTypeID);
		result.add(lcsCodeword);
		result.add(lcsPrivacyCheckNonSession);
		result.add(LcsPrivacyCheckSession);
		result.add(serviceSelection);
		result.add(deferredLocationType);
		result.add(lcsReferenceNumber);
		result.add(areaEventInfo);
		result.add(gmlcAddress);
		result.add(plrFlags);
		result.add(periodicLDRInformation);
		result.add(reportingPLMNList);
		result.add(motionEventInfo);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);				
		
		return result;
	}	
}