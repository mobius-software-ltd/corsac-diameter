package com.mobius.software.telco.protocols.diameter.impl.commands.rx;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.rx.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TWANIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NetLocAccessSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RANNASReleaseCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TCPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UDPSourcePortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.NIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TWANIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RANNASReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TCPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UDPSourcePort;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FiveGSRANNASReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.NID;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsoredConnectivityData;
import com.mobius.software.telco.protocols.diameter.primitives.rx.WirelineUserLocationInfo;

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
@DiameterCommandImplementation(applicationId = 16777236, commandCode = 275, request = false)
public class SessionTerminationAnswerImpl extends RxAnswerImpl implements SessionTerminationAnswer
{
	private SponsoredConnectivityData sponsoredConnectivityData;
	
	private TGPPUserLocationInfo tgppUserLocationInfo;
	
	private UserLocationInfoTime userLocationInfoTime;
	
	private TGPPMSTimeZone tgppMSTimeZone;
	
	private List<RANNASReleaseCause> ranNASReleaseCause;

	private List<FiveGSRANNASReleaseCause> fiveGSRANNASReleaseCause;

	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	
	private NID nid;
	
	private TWANIdentifier twanIdentifier;
	
	private TCPSourcePort tcpSourcePort;
	
	private UDPSourcePort udpSourcePort;
	
	private UELocalIPAddress ueLocalIPAddress;
	
	private NetLocAccessSupport netLocAccessSupport;
	
	private WirelineUserLocationInfo wirelineUserLocationInfo;
				
	private List<DiameterClass> diameterClass;

	private List<Load> load;
	
	protected SessionTerminationAnswerImpl() 
	{
	}
	
	public SessionTerminationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, Long authApplicationId)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId);
	}
	
	@Override
	public SponsoredConnectivityData getSponsoredConnectivityData()
	{
		return this.sponsoredConnectivityData;
	}
	
	@Override
	public void setSponsoredConnectivityData(SponsoredConnectivityData value)
	{
		this.sponsoredConnectivityData = value;
	}
	
	@Override
	public ByteBuf getTGPPUserLocationInfo()
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return this.tgppUserLocationInfo.getValue();
	}
	
	@Override
	public void setTGPPUserLocationInfo(ByteBuf value)
	{
		if(value==null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);
	}
	
	@Override
	public Date getUserLocationInfoTime()
	{
		if(userLocationInfoTime==null)
			return null;
		
		return this.userLocationInfoTime.getDateTime();
	}
	
	@Override
	public void setUserLocationInfoTime(Date value)
	{
		if(value==null)
			this.userLocationInfoTime = null;
		else
			this.userLocationInfoTime = new UserLocationInfoTimeImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getTGPPMSTimeZone()
	{
		if(tgppMSTimeZone==null)
			return null;
		
		return this.tgppMSTimeZone.getValue();
	}
	
	@Override
	public void setTGPPMSTimeZone(ByteBuf value)
	{
		if(value==null)
			this.tgppMSTimeZone = null;
		else
			this.tgppMSTimeZone = new TGPPMSTimeZoneImpl(value, null, null);
	}	

	@Override
	public List<ByteBuf> getRANNASReleaseCause()
	{
		if(ranNASReleaseCause==null || ranNASReleaseCause.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(RANNASReleaseCause curr:ranNASReleaseCause)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setRANNASReleaseCause(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.ranNASReleaseCause = null;
		else
		{
			this.ranNASReleaseCause = new ArrayList<RANNASReleaseCause>();
			for(ByteBuf curr:value)
				this.ranNASReleaseCause.add(new RANNASReleaseCauseImpl(curr, null, null));
		}
	}
	
	@Override
	public List<FiveGSRANNASReleaseCause> getFiveGSRANNASReleaseCause()
	{
		return this.fiveGSRANNASReleaseCause;
	}

	@Override
	public void setFiveGSRANNASReleaseCause(List<FiveGSRANNASReleaseCause> value)
	{
		this.fiveGSRANNASReleaseCause = value;
	}
	
	@Override
	public String get3GPPSGSNMCCMNC()
	{
		if(tgppSGSNMCCMNC==null)
			return null;
		
		return this.tgppSGSNMCCMNC.getString();
	}
	
	@Override
	public void set3GPPSGSNMCCMNC(String value)
	{
		if(value==null)
			this.tgppSGSNMCCMNC = null;
		else
			this.tgppSGSNMCCMNC = new TGPPSGSNMCCMNCImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getNID()
	{
		if(nid==null)
			return null;
		
		return this.nid.getValue();
	}
	
	@Override
	public void setNID(ByteBuf value)
	{
		if(value==null)
			this.nid = null;
		else
			this.nid = new NIDImpl(value, null, null);
	}	
	
	@Override
	public ByteBuf getTWANIdentifier()
	{
		if(twanIdentifier==null)
			return null;
		
		return this.twanIdentifier.getValue();
	}
	
	@Override
	public void setTWANIdentifier(ByteBuf value)
	{
		if(value==null)
			this.twanIdentifier = null;
		else
			this.twanIdentifier = new TWANIdentifierImpl(value, null, null);
	}	
	
	@Override
	public Long getTCPSourcePort()
	{
		if(tcpSourcePort==null)
			return null;
		
		return this.tcpSourcePort.getUnsigned();
	}
	
	@Override
	public void setTCPSourcePort(Long value)
	{
		if(value==null)
			this.tcpSourcePort = null;
		else
			this.tcpSourcePort = new TCPSourcePortImpl(value, null, null);
	}	
	
	@Override
	public Long getUDPSourcePort()
	{
		if(udpSourcePort==null)
			return null;
		
		return this.udpSourcePort.getUnsigned();
	}
	
	@Override
	public void setUDPSourcePort(Long value)
	{
		if(value==null)
			this.udpSourcePort = null;
		else
			this.udpSourcePort = new UDPSourcePortImpl(value, null, null);
	}	
	
	@Override
	public InetAddress getUELocalIPAddress()
	{
		if(ueLocalIPAddress==null)
			return null;
		
		return this.ueLocalIPAddress.getAddress();
	}
	
	@Override
	public void setUELocalIPAddress(InetAddress value)
	{
		if(value==null)
			this.ueLocalIPAddress = null;
		else
			this.ueLocalIPAddress = new UELocalIPAddressImpl(value, null, null);
	}	
	
	@Override
	public NetLocAccessSupportEnum getNetLocAccessSupport()
	{
		if(netLocAccessSupport==null)
			return null;
		
		return this.netLocAccessSupport.getEnumerated(NetLocAccessSupportEnum.class);
	}
	
	@Override
	public void setNetLocAccessSupport(NetLocAccessSupportEnum value)
	{
		if(value==null)
			this.netLocAccessSupport = null;
		else
			this.netLocAccessSupport = new NetLocAccessSupportImpl(value, null, null);
	}	
				
	@Override
	public WirelineUserLocationInfo getWirelineUserLocationInfo()
	{
		return this.wirelineUserLocationInfo;
	}
				
	@Override
	public void setWirelineUserLocationInfo(WirelineUserLocationInfo value)
	{
		this.wirelineUserLocationInfo = value;
	}
				
	@Override
	public List<ByteBuf> getDiameterClass()
	{
		if(diameterClass==null || diameterClass.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(DiameterClass curr:diameterClass)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setDiameterClass(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.diameterClass = null;
		else
		{
			this.diameterClass = new ArrayList<DiameterClass>();
			for(ByteBuf curr:value)
				this.diameterClass.add(new DiameterClassImpl(curr, null, null));
		}
	}
		
	@Override
	public List<Load> getLoad()
	{
		return this.load;
	}
	
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(originHost);
		result.add(originRealm);
		result.add(resultCode);
		result.add(errorMessage);
		result.add(errorReportingHost);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		result.add(failedAvp);
		result.add(sponsoredConnectivityData);
		result.add(originStateId);
		result.add(tgppUserLocationInfo);
		result.add(userLocationInfoTime);
		result.add(tgppMSTimeZone);
		
		if(ranNASReleaseCause!=null)
			result.addAll(ranNASReleaseCause);
		
		if(fiveGSRANNASReleaseCause!=null)
			result.addAll(fiveGSRANNASReleaseCause);
		
		result.add(tgppSGSNMCCMNC);
		result.add(nid);
		result.add(twanIdentifier);
		result.add(tcpSourcePort);
		result.add(udpSourcePort);
		result.add(ueLocalIPAddress);
		result.add(netLocAccessSupport);
		result.add(wirelineUserLocationInfo);
		
		if(diameterClass!=null)
			result.addAll(diameterClass);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(load!=null)
			result.addAll(load);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}