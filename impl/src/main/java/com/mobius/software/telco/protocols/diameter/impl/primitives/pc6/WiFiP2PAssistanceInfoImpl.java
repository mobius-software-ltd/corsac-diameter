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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.eap.EAPMasterSessionKeyImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sta.SSIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.eap.EAPMasterSessionKey;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.AssistanceInfoValidityTimer;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.OperatingChannel;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.P2PFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WLANLinkLayerIdList;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.WiFiP2PAssistanceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sta.SSID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3819L, vendorId = KnownVendorIDs.TGPP_ID)
public class WiFiP2PAssistanceInfoImpl extends DiameterGroupedAvpImpl implements WiFiP2PAssistanceInfo
{
	private SSID ssid;
	private EAPMasterSessionKey eapMasterSessionKey;
	private P2PFeatures p2pFeatures;
	private WLANLinkLayerIdList wlanLinkLayerIdList;
	private OperatingChannel operatingChannel;
	private AssistanceInfoValidityTimer assistanceInfoValidityTimer;
		
	public WiFiP2PAssistanceInfoImpl()
	{
		
	}
	
	public String getSSID()
	{
		if(ssid==null)
			return null;
		
		return ssid.getString();
	}
	
	public void setSSID(String value)
	{
		if(value==null)
			this.ssid = null;
		else
			this.ssid = new SSIDImpl(value, null, null);			
	}
	
	public ByteBuf getEAPMasterSessionKey()
	{
		if(eapMasterSessionKey==null)
			return null;
		
		return eapMasterSessionKey.getValue();
	}
	
	public void setEAPMasterSessionKey(ByteBuf value)
	{
		if(value==null)
			this.eapMasterSessionKey = null;
		else
			this.eapMasterSessionKey = new EAPMasterSessionKeyImpl(value, null, null);			
	}
	
	public Long getP2PFeatures()
	{
		if(p2pFeatures==null)
			return null;
		
		return p2pFeatures.getUnsigned();
	}
	
	public void setP2PFeatures(Long value)
	{
		if(value==null)
			this.p2pFeatures = null;
		else
			this.p2pFeatures = new P2PFeaturesImpl(value, null, null);			
	}
	
	public WLANLinkLayerIdList getWLANLinkLayerIdList()
	{
		return wlanLinkLayerIdList;
	}
	
	public void setWLANLinkLayerIdList(WLANLinkLayerIdList value)
	{
		this.wlanLinkLayerIdList = value;
	}
	
	public Long getOperatingChannel()
	{
		if(operatingChannel==null)
			return null;
		
		return operatingChannel.getUnsigned();
	}
	
	public void setOperatingChannel(Long value)
	{
		if(value==null)
			this.operatingChannel = null;
		else
			this.operatingChannel = new OperatingChannelImpl(value, null, null);			
	}
	
	public Long getAssistanceInfoValidityTimer()
	{
		if(assistanceInfoValidityTimer==null)
			return null;
		
		return assistanceInfoValidityTimer.getUnsigned();
	}
	
	public void setAssistanceInfoValidityTimer(Long value)
	{
		if(value==null)
			this.assistanceInfoValidityTimer = null;
		else
			this.assistanceInfoValidityTimer = new AssistanceInfoValidityTimerImpl(value, null, null);			
	}
}