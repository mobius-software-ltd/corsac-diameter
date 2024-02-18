package com.mobius.software.telco.protocols.diameter.impl.commands.gmb;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.gmb.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.CNIPMulticastDistributionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMS2G3GIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSBMSCSSMIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSBMSCSSMIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSCountingInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSFlowIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSHCIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSRequiredQoSImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSServiceAreaImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSServiceTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSSessionDurationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSSessionIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSSessionRepetitionNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSStartStopIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSTimeToDataTransferImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSUserDataModeIndicationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.TMGIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedInterfaceIdImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.CNIPMulticastDistribution;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.CNIPMulticastDistributionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMS2G3GIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMS2G3GIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSBMSCSSMIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSBMSCSSMIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSCountingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSCountingInformationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSFlowIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSHCIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSHCIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSRequiredQoS;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSServiceArea;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSSessionDuration;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSSessionIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSSessionRepetitionNumber;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSTimeToDataTransfer;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSUserDataModeIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSUserDataModeIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.TMGI;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedInterfaceId;

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
public class ReAuthRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthRequestmpl implements ReAuthRequest
{
	private CalledStationId calledStationId;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private FramedInterfaceId framedInterfaceId;
	
	private MBMSStartStopIndication mbmsStartStopIndication;
	
	private MBMSServiceArea mbmsServiceArea;
	
	private MBMSRequiredQoS mbmsRequiredQoS;
	
	private MBMSSessionDuration mbmsSessionDuration;
	
	private MBMSServiceType mbmsServiceType;
	
	private MBMSCountingInformation mbmsCountingInformation;
	
	private MBMSSessionIdentity mbmsSessionIdentity;
	
	private MBMSSessionRepetitionNumber mbmsSessionRepetitionNumber;
	
	private TMGI tmgi;	
	
	private List<TGPPSGSNAddress> tgppSGSNAddress;
	
	private List<TGPPSGSNIPv6Address> tgppSGSNIPV6Address;
	
	private MBMS2G3GIndicator mbms2G3GIndicator;	
	
	private MBMSTimeToDataTransfer mbmsTimeToDataTransfer;	
	
	private MBMSUserDataModeIndication mbmsUserDataModeIndication;	
	
	private MBMSBMSCSSMIPAddress mbmsBMSCSSMIPAddress;	
	
	private MBMSBMSCSSMIPv6Address mbmsBMSCSSMIPv6Address;	
	
	private MBMSFlowIdentifier mbmsFlowIdentifier;	
	
	private CNIPMulticastDistribution cnIPMulticastDistribution;	
	
	private MBMSHCIndicator mbmsHCIndicator;	
	
	protected ReAuthRequestImpl() 
	{
		super();
	}
		
	public ReAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID, ReAuthRequestTypeEnum reAuthRequestType) throws MissingAvpException, AvpNotSupportedException
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID, reAuthRequestType);
	}
	
	@Override
	public String getCalledStationId() 
	{
		if(calledStationId==null)
			return null;
		
		return calledStationId.getString();
	}	
	
	@Override
	public void setCalledStationId(String value)
	{
		if(value == null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(value, null, null);
	}
	
	@Override
	public InetAddress getFramedIPAddress() 
	{
		if(framedIPAddress==null)
			return null;
		
		return framedIPAddress.getAddress();
	}

	@Override
	public void setFramedIPAddress(Inet4Address value) 
	{
		if(value == null)
			this.framedIPAddress = null;
		else
			this.framedIPAddress = new FramedIPAddressImpl(value);
	}

	@Override
	public ByteBuf getFramedIPv6Prefix() 
	{
		if(framedIPv6Prefix==null)
			return null;
		
		return framedIPv6Prefix.getValue();
	}

	@Override
	public void setFramedIPv6Prefix(ByteBuf value) 
	{
		if(value == null)
			this.framedIPv6Prefix = null;
		else
			this.framedIPv6Prefix = new FramedIPv6PrefixImpl(value, null, null);		
	}
	
	@Override
	public Long getFramedInterfaceId() 
	{
		if(framedInterfaceId==null)
			return null;
		
		return framedInterfaceId.getLong();
	}

	@Override
	public void setFramedInterfaceId(Long value) 
	{
		if(value == null)
			this.framedInterfaceId = null;
		else
			this.framedInterfaceId = new FramedInterfaceIdImpl(value, null, null);
	}
	
	@Override
	public MBMSStartStopIndicationEnum getMBMSStartStopIndication() 
	{
		if(mbmsStartStopIndication==null)
			return null;
		
		return mbmsStartStopIndication.getEnumerated(MBMSStartStopIndicationEnum.class);
	}	
	
	@Override
	public void setMBMSStartStopIndication(MBMSStartStopIndicationEnum value) 
	{
		if(value == null)
			this.mbmsStartStopIndication = null;
		else
			this.mbmsStartStopIndication = new MBMSStartStopIndicationImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getMBMSServiceArea() 
	{
		if(mbmsServiceArea==null)
			return null;
		
		return mbmsServiceArea.getValue();
	}	
	
	@Override
	public void setMBMSServiceArea(ByteBuf value) 
	{
		if(value == null)
			this.mbmsServiceArea = null;
		else
			this.mbmsServiceArea = new MBMSServiceAreaImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getMBMSRequiredQoS() 
	{
		if(mbmsRequiredQoS==null)
			return null;
		
		return mbmsRequiredQoS.getValue();
	}	
	
	@Override
	public void setMBMSRequiredQoS(ByteBuf value) 
	{
		if(value == null)
			this.mbmsRequiredQoS = null;
		else
			this.mbmsRequiredQoS = new MBMSRequiredQoSImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getMBMSSessionDuration() 
	{
		if(mbmsSessionDuration==null)
			return null;
		
		return mbmsSessionDuration.getValue();
	}	
	
	@Override
	public void setMBMSSessionDuration(ByteBuf value) 
	{
		if(value == null)
			this.mbmsSessionDuration = null;
		else
			this.mbmsSessionDuration = new MBMSSessionDurationImpl(value, null, null);
	}
	
	@Override
	public MBMSServiceTypeEnum getMBMSServiceType() 
	{
		if(mbmsServiceType==null)
			return null;
		
		return mbmsServiceType.getEnumerated(MBMSServiceTypeEnum.class);
	}	
	
	@Override
	public void setMBMSServiceType(MBMSServiceTypeEnum value) 
	{
		if(value == null)
			this.mbmsServiceType = null;
		else
			this.mbmsServiceType = new MBMSServiceTypeImpl(value, null, null);
	}
	
	@Override
	public MBMSCountingInformationEnum getMBMSCountingInformation() 
	{
		if(mbmsCountingInformation==null)
			return null;
		
		return mbmsCountingInformation.getEnumerated(MBMSCountingInformationEnum.class);
	}	
	
	@Override
	public void setMBMSCountingInformation(MBMSCountingInformationEnum value) 
	{
		if(value == null)
			this.mbmsCountingInformation = null;
		else
			this.mbmsCountingInformation = new MBMSCountingInformationImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getMBMSSessionIdentity() 
	{
		if(mbmsSessionIdentity==null)
			return null;
		
		return mbmsSessionIdentity.getValue();
	}	
	
	@Override
	public void setMBMSSessionIdentity(ByteBuf value) 
	{
		if(value == null)
			this.mbmsSessionIdentity = null;
		else
			this.mbmsSessionIdentity = new MBMSSessionIdentityImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getMBMSSessionRepetitionNumber() 
	{
		if(mbmsSessionRepetitionNumber==null)
			return null;
		
		return mbmsSessionRepetitionNumber.getValue();
	}	
	
	@Override
	public void setMBMSSessionRepetitionNumber(ByteBuf value) 
	{
		if(value == null)
			this.mbmsSessionRepetitionNumber = null;
		else
			this.mbmsSessionRepetitionNumber = new MBMSSessionRepetitionNumberImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTMGI() 
	{
		if(tmgi==null)
			return null;
		
		return tmgi.getValue();
	}	
	
	@Override
	public void setTMGI(ByteBuf value) 
	{
		if(value == null)
			this.tmgi = null;
		else
			this.tmgi = new TMGIImpl(value, null, null);
	}
	
	@Override
	public List<ByteBuf> getTGPPSGSNAddress() 
	{
		if(tgppSGSNAddress==null || tgppSGSNAddress.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(TGPPSGSNAddress curr:tgppSGSNAddress)
			result.add(curr.getValue());
		
		return result;
	}
	
	@Override
	public void setTGPPSGSNAddress(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.tgppSGSNAddress = null;
		else
		{
			this.tgppSGSNAddress = new ArrayList<TGPPSGSNAddress>();
			for(ByteBuf curr:value)
				this.tgppSGSNAddress.add(new TGPPSGSNAddressImpl(curr, null, null));
		}
	}	

	@Override
	public List<ByteBuf> getTGPPSGSNIPv6Address() 
	{
		if(tgppSGSNIPV6Address==null || tgppSGSNIPV6Address.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(TGPPSGSNIPv6Address curr:tgppSGSNIPV6Address)
			result.add(curr.getValue());
		
		return result;
	}
	
	@Override
	public void setTGPPSGSNIPv6Address(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.tgppSGSNIPV6Address = null;
		else
		{
			this.tgppSGSNIPV6Address = new ArrayList<TGPPSGSNIPv6Address>();
			for(ByteBuf curr:value)
				this.tgppSGSNIPV6Address.add(new TGPPSGSNIPv6AddressImpl(curr, null, null));
		}
	}
	
	@Override
	public MBMS2G3GIndicatorEnum getMBMS2G3GIndicator() 
	{
		if(mbms2G3GIndicator==null)
			return null;
		
		return mbms2G3GIndicator.getEnumerated(MBMS2G3GIndicatorEnum.class);
	}	
	
	@Override
	public void setMBMS2G3GIndicator(MBMS2G3GIndicatorEnum value) 
	{
		if(value == null)
			this.mbms2G3GIndicator = null;
		else
			this.mbms2G3GIndicator = new MBMS2G3GIndicatorImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getMBMSTimeToDataTransfer() 
	{
		if(mbmsTimeToDataTransfer==null)
			return null;
		
		return mbmsTimeToDataTransfer.getValue();
	}
	
	@Override
	public void setMBMSTimeToDataTransfer(ByteBuf value) 
	{
		if(value == null)
			this.mbmsTimeToDataTransfer = null;
		else
			this.mbmsTimeToDataTransfer = new MBMSTimeToDataTransferImpl(value, null, null);
	}
	
	@Override
	public MBMSUserDataModeIndicationEnum getMBMSUserDataModeIndication() 
	{
		if(mbmsUserDataModeIndication==null)
			return null;
		
		return mbmsUserDataModeIndication.getEnumerated(MBMSUserDataModeIndicationEnum.class);
	}	
	
	@Override
	public void setMBMSUserDataModeIndication(MBMSUserDataModeIndicationEnum value) 
	{
		if(value == null)
			this.mbmsUserDataModeIndication = null;
		else
			this.mbmsUserDataModeIndication = new MBMSUserDataModeIndicationImpl(value, null, null);
	}
	
	@Override
	public Inet4Address getMBMSBMSCSSMIPAddress() 
	{
		if(mbmsBMSCSSMIPAddress==null)
			return null;
		
		return mbmsBMSCSSMIPAddress.getAddress();
	}	
	
	@Override
	public void setMBMSBMSCSSMIPAddress(Inet4Address value) 
	{
		if(value == null)
			this.mbmsBMSCSSMIPAddress = null;
		else
			this.mbmsBMSCSSMIPAddress = new MBMSBMSCSSMIPAddressImpl(value);
	}
	
	@Override
	public Inet6Address getMBMSBMSCSSMIPv6Address() 
	{
		if(mbmsBMSCSSMIPv6Address==null)
			return null;
		
		return mbmsBMSCSSMIPv6Address.getAddress();
	}	
	
	@Override
	public void setMBMSBMSCSSMIPv6Address(Inet6Address value) 
	{
		if(value == null)
			this.mbmsBMSCSSMIPv6Address = null;
		else
			this.mbmsBMSCSSMIPv6Address = new MBMSBMSCSSMIPv6AddressImpl(value);
	}
	
	@Override
	public ByteBuf getMBMSFlowIdentifier() 
	{
		if(mbmsFlowIdentifier==null)
			return null;
		
		return mbmsFlowIdentifier.getValue();
	}
	
	@Override
	public void setMBMSFlowIdentifier(ByteBuf value) 
	{
		if(value == null)
			this.mbmsFlowIdentifier = null;
		else
			this.mbmsFlowIdentifier = new MBMSFlowIdentifierImpl(value, null, null);
	}
	
	@Override
	public CNIPMulticastDistributionEnum getCNIPMulticastDistribution() 
	{
		if(cnIPMulticastDistribution==null)
			return null;
		
		return cnIPMulticastDistribution.getEnumerated(CNIPMulticastDistributionEnum.class);
	}	
	
	@Override
	public void setCNIPMulticastDistribution(CNIPMulticastDistributionEnum value) 
	{
		if(value == null)
			this.cnIPMulticastDistribution = null;
		else
			this.cnIPMulticastDistribution = new CNIPMulticastDistributionImpl(value, null, null);
	}
	
	@Override
	public MBMSHCIndicatorEnum getMBMSHCIndicator() 
	{
		if(mbmsHCIndicator==null)
			return null;
		
		return mbmsHCIndicator.getEnumerated(MBMSHCIndicatorEnum.class);
	}	
	
	@Override
	public void setMBMSHCIndicator(MBMSHCIndicatorEnum value) 
	{
		if(value == null)
			this.mbmsHCIndicator = null;
		else
			this.mbmsHCIndicator = new MBMSHCIndicatorImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(destinationHost);
		result.add(authApplicationId);
		result.add(reAuthRequestType);
		result.add(calledStationId);
		result.add(framedIPAddress);
		result.add(framedIPv6Prefix);
		result.add(framedInterfaceId);
		result.add(mbmsStartStopIndication);
		result.add(mbmsServiceArea);
		result.add(mbmsRequiredQoS);
		result.add(mbmsSessionDuration);
		result.add(mbmsServiceType);
		result.add(mbmsCountingInformation);
		result.add(mbmsSessionIdentity);
		result.add(mbmsSessionRepetitionNumber);
		result.add(tmgi);
		
		if(tgppSGSNAddress!=null)
			result.addAll(tgppSGSNAddress);
		
		if(tgppSGSNIPV6Address!=null)
			result.addAll(tgppSGSNIPV6Address);
		
		result.add(mbms2G3GIndicator);
		result.add(mbmsTimeToDataTransfer);
		result.add(mbmsUserDataModeIndication);
		result.add(mbmsBMSCSSMIPAddress);
		result.add(mbmsBMSCSSMIPv6Address);
		result.add(mbmsFlowIdentifier);
		result.add(cnIPMulticastDistribution);
		result.add(mbmsHCIndicator);
		result.add(originStateId);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		return result;
	}
}