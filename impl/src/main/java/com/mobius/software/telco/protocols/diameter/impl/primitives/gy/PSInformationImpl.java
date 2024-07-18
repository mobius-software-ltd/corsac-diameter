package com.mobius.software.telco.protocols.diameter.impl.primitives.gy;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PDNConnectionChargingIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PDPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PDPAddressPrefixLengthImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPChargingIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPGPRSNegotiatedQoSProfileImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPIMSIMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPRATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSelectionModeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSessionStopIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TDFIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.PDNTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDNConnectionChargingID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PDPAddressPrefixLength;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPChargingId;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPGPRSNegotiatedQoSProfile;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPIMSIMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPRATType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSelectionMode;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSessionStopIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.gy.PSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNType;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.PDNTypeEnum;

import io.netty.buffer.ByteBuf;

public class PSInformationImpl extends DiameterAvpImpl implements PSInformation
{
	private TGPPChargingId tgppChargingId;
	private PDNConnectionChargingID pdnConnectionChargingID;
	private PDNType pdnType;
	private List<PDPAddress> pdpAddress;
	private PDPAddressPrefixLength pdpAddressPrefixLength;
	private TGPPGPRSNegotiatedQoSProfile tgppGPRSNegotiatedQoSProfile;
	private TGPPGGSNAddress tgppGGSNAddress;
	private List<TDFIPAddress> tdfIPAddress;
	private TGPPIMSIMCCMNC tgppIMSIMCCMNC;
	private TGPPGGSNMCCMNC tgppGGSNMCCMNC;
	private CalledStationId calledStationId;
	private TGPPSessionStopIndicator tgppSessionStopIndicator;
	private TGPPSelectionMode tgppSelectionMode;
	private TGPPMSTimeZone tgppMSTimeZone;
	private TGPPUserLocationInfo tgppUserLocationInfo;
	private TGPPRATType tgppRATType;
	
	public PSInformationImpl()
   	{
   		
   	}
	
	@Override
	public ByteBuf get3GPPChargingId()
	{
		if(tgppChargingId==null)
			return null;
		
		return tgppChargingId.getValue();
	}
	
	@Override
	public void set3GPPChargingId(ByteBuf value)
	{
		if(value==null)
			this.tgppChargingId = null;
		else
			this.tgppChargingId = new TGPPChargingIdImpl(value, null, null);			
	}
	
	@Override
	public Long getPDNConnectionChargingID()
	{
		if(pdnConnectionChargingID==null)
			return null;
		
		return pdnConnectionChargingID.getUnsigned();
	}
	
	@Override
	public void setPDNConnectionChargingID(Long value)
	{
		if(value==null)
			this.pdnConnectionChargingID = null;
		else
			this.pdnConnectionChargingID = new PDNConnectionChargingIDImpl(value, null, null);			
	}
	
	@Override
	public PDNTypeEnum getPDNType()
	{
		if(pdnType == null)
			return null;
		
		return pdnType.getEnumerated(PDNTypeEnum.class);
	}
	
	@Override
	public void setPDNType(PDNTypeEnum value) 
	{
		if(value==null)
			this.pdnType = null;
		else	
			this.pdnType = new PDNTypeImpl(value, null, null);
	}
	
	@Override
	public List<InetAddress> getPDPAddress()
	{
		if(pdpAddress==null || pdpAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(PDPAddress curr:pdpAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	@Override
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
	
	@Override
	public Long getPDPAddressPrefixLength()
	{
		if(pdpAddressPrefixLength==null)
			return null;
		
		return pdpAddressPrefixLength.getUnsigned();
	}
	
	@Override
	public void setPDPAddressPrefixLength(Long value)
	{
		if(value==null)
			this.pdpAddressPrefixLength = null;
		else
			this.pdpAddressPrefixLength = new PDPAddressPrefixLengthImpl(value, null, null);			
	}
	
	@Override
	public String getTGPPGPRSNegotiatedQoSProfile() 
	{
		if(tgppGPRSNegotiatedQoSProfile==null)
			return null;
		
		return tgppGPRSNegotiatedQoSProfile.getString();
	}

	@Override
	public void setTGPPGPRSNegotiatedQoSProfile(String value) 
	{
		if(value == null)
			this.tgppGPRSNegotiatedQoSProfile = null;
		else
			this.tgppGPRSNegotiatedQoSProfile = new TGPPGPRSNegotiatedQoSProfileImpl(value, null, null);
	}

	@Override
	public ByteBuf getTGPPGGSNAddress() 
	{
		if(tgppGGSNAddress==null)
			return null;
		
		return tgppGGSNAddress.getValue();
	}

	@Override
	public void setTGPPGGSNAddress(ByteBuf value) 
	{
		if(value == null)
			this.tgppGGSNAddress = null;
		else
			this.tgppGGSNAddress = new TGPPGGSNAddressImpl(value, null, null);
	}
	
	@Override
	public List<InetAddress> getTDFIPAddress()
	{
		if(tdfIPAddress==null || tdfIPAddress.size()==0)
			return null;
		
		List<InetAddress> result = new ArrayList<InetAddress>();
		for(TDFIPAddress curr:tdfIPAddress)
			result.add(curr.getAddress());
		
		return result;
	}
	
	@Override
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

	@Override
	public String getTGPPIMSIMCCMNC()
	{
		if(tgppIMSIMCCMNC==null)
			return null;
		
		return tgppIMSIMCCMNC.getString();
	}
	
	@Override
	public void setTGPPIMSIMCCMNC(String value)
	{
		if(value==null)
			this.tgppIMSIMCCMNC = null;
		else
			this.tgppIMSIMCCMNC = new TGPPIMSIMCCMNCImpl(value, null, null);
	}
	
	@Override
	public String getTGPPGGSNMCCMNC()
	{
		if(tgppGGSNMCCMNC==null)
			return null;
		
		return tgppGGSNMCCMNC.getString();
	}
	
	@Override
	public void setTGPPGGSNMCCMNC(String value)
	{
		if(value==null)
			this.tgppGGSNMCCMNC = null;
		else
			this.tgppGGSNMCCMNC = new TGPPGGSNMCCMNCImpl(value, null, null);			
	}
	
	@Override
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
	
	@Override
	public ByteBuf getTGPPSessionStopIndicator()
	{
		if(tgppSessionStopIndicator==null)
			return null;
		
		return tgppSessionStopIndicator.getValue();
	}
	
	@Override
	public void setTGPPSessionStopIndicator(ByteBuf value)
	{
		if(value==null)
			this.tgppSessionStopIndicator = null;
		else
			this.tgppSessionStopIndicator = new TGPPSessionStopIndicatorImpl(value, null, null);			
	}
	
	@Override
	public String getTGPPSelectionMode()
	{
		if(tgppSelectionMode==null)
			return null;
		
		return tgppSelectionMode.getString();
	}
	
	@Override
	public void setTGPPSelectionMode(String value)
	{
		if(value==null)
			this.tgppSelectionMode = null;
		else
			this.tgppSelectionMode = new TGPPSelectionModeImpl(value, null, null);			
	}
	
	@Override
	public ByteBuf getTGPPMSTimeZone()
	{
		if(tgppMSTimeZone==null)
			return null;
		
		return tgppMSTimeZone.getValue();
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
	public ByteBuf get3GPPUserLocationInfo()
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}
	
	@Override
	public void set3GPPUserLocationInfo(ByteBuf value)
	{
		if(value==null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);			
	}
	
	@Override
	public ByteBuf getTGPPRATType()
	{
		if(tgppRATType==null)
			return null;
		
		return tgppRATType.getValue();
	}
	
	@Override
	public void setTGPPRATType(ByteBuf value)
	{
		if(value==null)
			this.tgppRATType = null;
		else
			this.tgppRATType = new TGPPRATTypeImpl(value, null, null);			
	}
	
}