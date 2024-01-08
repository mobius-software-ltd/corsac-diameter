package com.mobius.software.telco.protocols.diameter.impl.commands.sgmb;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.sgmb.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.CNIPMulticastDistributionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSBMSCSSMIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSBMSCSSMIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSFlowIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSHCIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSServiceAreaImpl;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSAccessIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSBMSCSSMUDPPortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSCellListImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSDataTransferStartImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSDataTransferStopImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSGWSSMIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSGWSSMIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSGWUDPPortIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.RestartCounterImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.CNIPMulticastDistribution;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.CNIPMulticastDistributionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSBMSCSSMIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSBMSCSSMIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSFlowIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSHCIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSHCIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSServiceArea;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSSessionDuration;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSSessionIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSSessionRepetitionNumber;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSStartStopIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSTimeToDataTransfer;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSUserDataModeIndication;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSUserDataModeIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.TMGI;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.mb2c.LocalM1Information;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedInterfaceId;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSAccessIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSAccessIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSBMSCSSMUDPPort;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSCellList;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSDataTransferStart;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSDataTransferStop;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSGWSSMIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSGWSSMIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSGWUDPPortIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSGWUDPPortIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.RestartCounter;

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
@DiameterCommandImplementation(applicationId = 16777292, commandCode = 258, request = true)
public class ReAuthRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthRequestmpl implements ReAuthRequest
{
	private CalledStationId calledStationId;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private FramedInterfaceId framedInterfaceId;
	
	private MBMSAccessIndicator mbmsAccessIndicator;
	
	private MBMSStartStopIndication mbmsStartStopIndication;
	
	private MBMSServiceArea mbmsServiceArea;
	
	private QoSInformation qosInformation;
	
	private MBMSSessionDuration mbmsSessionDuration;
	
	private MBMSSessionIdentity mbmsSessionIdentity;
	
	private MBMSSessionRepetitionNumber mbmsSessionRepetitionNumber;
	
	private TMGI tmgi;	
	
	private List<TGPPSGSNAddress> tgppSGSNAddress;
	
	private List<TGPPSGSNIPv6Address> tgppSGSNIPv6Address;
	
	private MBMSTimeToDataTransfer mbmsTimeToDataTransfer;	
	
	private MBMSDataTransferStart mbmsDataTransferStart;
	
	private MBMSDataTransferStop mbmsDataTransferStop;
	
	private MBMSFlags mbmsFlags;
	
	private MBMSUserDataModeIndication mbmsUserDataModeIndication;	
	
	private MBMSBMSCSSMIPAddress mbmsBMSCSSMIPAddress;	
	
	private MBMSBMSCSSMIPv6Address mbmsBMSCSSMIPv6Address;	
	
	private MBMSFlowIdentifier mbmsFlowIdentifier;	
	
	private CNIPMulticastDistribution cnIPMulticastDistribution;	
	
	private MBMSHCIndicator mbmsHCIndicator;	
	
	private MBMSGWUDPPortIndicator mbmsGWUDPPortIndicator;
	
	private MBMSGWSSMIPAddress mbmsGWSSMIPAddress;
	
	private MBMSGWSSMIPv6Address mbmsGWSSMIPv6Address;
	
	private MBMSBMSCSSMUDPPort mbmsBMSCSSMUDPPort;
	
	private MBMSCellList mbmsCellList;
	
	private LocalM1Information localM1Information;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private RestartCounter restartCounter;
	
	protected ReAuthRequestImpl() 
	{
		super();
	}
		
	public ReAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID, ReAuthRequestTypeEnum reAuthRequestType)
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
	public MBMSAccessIndicatorEnum getMBMSAccessIndicator() 
	{
		if(mbmsAccessIndicator==null)
			return null;
		
		return mbmsAccessIndicator.getEnumerated(MBMSAccessIndicatorEnum.class);
	}	
	
	@Override
	public void setMBMSAccessIndicator(MBMSAccessIndicatorEnum value) 
	{
		if(value == null)
			this.mbmsAccessIndicator = null;
		else
			this.mbmsAccessIndicator = new MBMSAccessIndicatorImpl(value, null, null);
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
	public QoSInformation getQoSInformation()
	{
		return this.qosInformation;
	}
	
	@Override
	public void setQoSInformation(QoSInformation value)
	{
		this.qosInformation = value;
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
		if(tgppSGSNIPv6Address==null || tgppSGSNIPv6Address.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(TGPPSGSNIPv6Address curr:tgppSGSNIPv6Address)
			result.add(curr.getValue());
		
		return result;
	}
	
	@Override
	public void setTGPPSGSNIPv6Address(List<ByteBuf> value)
	{
		if(value == null || value.size()==0)
			this.tgppSGSNIPv6Address = null;
		else
		{
			this.tgppSGSNIPv6Address = new ArrayList<TGPPSGSNIPv6Address>();
			for(ByteBuf curr:value)
				this.tgppSGSNIPv6Address.add(new TGPPSGSNIPv6AddressImpl(curr, null, null));
		}
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
	public Long getMBMSDataTransferStart()
	{
		if(mbmsDataTransferStart==null)
			return null;
		
		return mbmsDataTransferStart.getLong();
	}
	
	@Override
	public void setMBMSDataTransferStart(Long value)
	{
		if(value==null)
			this.mbmsDataTransferStart = null;
		else
			this.mbmsDataTransferStart = new MBMSDataTransferStartImpl(value, null, null);			
	}
	
	@Override
	public Long getMBMSDataTransferStop()
	{
		if(mbmsDataTransferStop==null)
			return null;
		
		return mbmsDataTransferStop.getLong();
	}
	
	@Override
	public void setMBMSDataTransferStop(Long value)
	{
		if(value==null)
			this.mbmsDataTransferStop = null;
		else
			this.mbmsDataTransferStop = new MBMSDataTransferStopImpl(value, null, null);			
	}
	
	@Override
	public Long getMBMSFlags()
	{
		if(mbmsFlags==null)
			return null;
		
		return mbmsFlags.getUnsigned();
	}
	
	@Override
	public void setMBMSFlags(Long value)
	{
		if(value==null)
			this.mbmsFlags = null;
		else
			this.mbmsFlags = new MBMSFlagsImpl(value, null, null);			
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
	
	@Override
	public MBMSGWUDPPortIndicatorEnum getMBMSGWUDPPortIndicator() 
	{
		if(mbmsGWUDPPortIndicator==null)
			return null;
		
		return mbmsGWUDPPortIndicator.getEnumerated(MBMSGWUDPPortIndicatorEnum.class);
	}
	
	@Override
	public void setMBMSGWUDPPortIndicator(MBMSGWUDPPortIndicatorEnum value)
	{
		if(value == null)
			this.mbmsGWUDPPortIndicator = null;
		else
			this.mbmsGWUDPPortIndicator = new MBMSGWUDPPortIndicatorImpl(value, null, null);
	}	
	
	@Override
	public Inet4Address getMBMSGWSSMIPAddress() 
	{
		if(mbmsGWSSMIPAddress==null)
			return null;
		
		return mbmsGWSSMIPAddress.getAddress();
	}
	
	@Override
	public void setMBMSGWSSMIPAddress(Inet4Address value)
	{
		if(value == null)
			this.mbmsGWSSMIPAddress = null;
		else
			this.mbmsGWSSMIPAddress = new MBMSGWSSMIPAddressImpl(value);
	}
	
	@Override
	public Inet6Address getMBMSGWSSMIPv6Address() 
	{
		if(mbmsGWSSMIPv6Address==null)
			return null;
		
		return mbmsGWSSMIPv6Address.getAddress();
	}
	
	@Override
	public void setMBMSGWSSMIPv6Address(Inet6Address value)
	{
		if(value == null)
			this.mbmsGWSSMIPv6Address = null;
		else
			this.mbmsGWSSMIPv6Address = new MBMSGWSSMIPv6AddressImpl(value);
	}
	
	@Override
	public ByteBuf getMBMSBMSCSSMUDPPort() 
	{
		if(mbmsBMSCSSMUDPPort==null)
			return null;
		
		return mbmsBMSCSSMUDPPort.getValue();
	}
	
	@Override
	public void setMBMSBMSCSSMUDPPort(ByteBuf value)
	{
		if(value == null)
			this.mbmsBMSCSSMUDPPort = null;
		else
			this.mbmsBMSCSSMUDPPort = new MBMSBMSCSSMUDPPortImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getMBMSCellList() 
	{
		if(mbmsCellList==null)
			return null;
		
		return mbmsCellList.getValue();
	}
	
	@Override
	public void setMBMSCellList(ByteBuf value)
	{
		if(value == null)
			this.mbmsCellList = null;
		else
			this.mbmsCellList = new MBMSCellListImpl(value, null, null);
	}
	
	@Override
	public LocalM1Information getLocalM1Information()
	{
		return this.localM1Information;
	}
	
	@Override
	public void setLocalM1Information(LocalM1Information value)
	{
		this.localM1Information = value;
	}
	
	@Override
	public List<SupportedFeatures> getSupportedFeatures() 
	{
		return supportedFeatures;
	}

	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value) 
	{
		this.supportedFeatures = value;
	}
	
	@Override
	public Long getRestartCounter()
	{
		if(restartCounter==null)
			return null;
		
		return restartCounter.getUnsigned();
	}
	
	@Override
	public void setRestartCounter(Long value)
	{
		if(value==null)
			this.restartCounter = null;
		else
			this.restartCounter = new RestartCounterImpl(value, null, null);
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
		result.add(mbmsAccessIndicator);
		result.add(mbmsStartStopIndication);
		result.add(mbmsServiceArea);
		result.add(qosInformation);
		result.add(mbmsSessionDuration);
		result.add(mbmsSessionIdentity);
		result.add(mbmsSessionRepetitionNumber);
		result.add(tmgi);
		
		if(tgppSGSNAddress!=null)
			result.addAll(tgppSGSNAddress);
			
		if(tgppSGSNIPv6Address!=null)
			result.addAll(tgppSGSNIPv6Address);
			
		result.add(mbmsTimeToDataTransfer);
		result.add(mbmsDataTransferStart);
		result.add(mbmsDataTransferStop);
		result.add(mbmsFlags);
		result.add(mbmsUserDataModeIndication);
		result.add(mbmsBMSCSSMIPAddress);
		result.add(mbmsBMSCSSMIPv6Address);
		result.add(mbmsFlowIdentifier);
		result.add(cnIPMulticastDistribution);
		
		result.add(mbmsHCIndicator);
		result.add(mbmsGWUDPPortIndicator);
		result.add(mbmsGWSSMIPAddress);
		result.add(mbmsGWSSMIPv6Address);
		result.add(mbmsBMSCSSMUDPPort);
		result.add(mbmsCellList);
		result.add(localM1Information);
		result.add(originStateId);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(restartCounter);
		
		return result;
	}
}