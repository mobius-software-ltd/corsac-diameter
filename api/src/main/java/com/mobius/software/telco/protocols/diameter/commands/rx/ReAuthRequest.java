package com.mobius.software.telco.protocols.diameter.commands.rx;
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
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AbortCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FiveGSRANNASReleaseCause;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SpecificActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsoredConnectivityData;
import com.mobius.software.telco.protocols.diameter.primitives.rx.WirelineUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.3	Re-Auth-Request (RAR) command
	The RAR command, indicated by the Command-Code field set to 258 and the ‘R’ bit set in the Command Flags field, is sent by the PCRF to the AF in order to indicate an Rx specific action.
	Message Format:

	<RA-Request> ::= < Diameter Header: 258, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Origin-Host }
				 { Origin-Realm }
				 { Destination-Realm }
				 { Destination-Host }
				 { Auth-Application-Id }
				*{ Specific-Action }
				 [ OC-Supported-Features ]
				*[ Access-Network-Charging-Identifier ]
				 [ Access-Network-Charging-Address ]
			  0*2[ AN-GW-Address ]
				 [ AN-Trusted ]
				*[ Flows ]
				*[ Subscription-Id ]
				 [ Abort-Cause ]
				 [ IP-CAN-Type ]
				 [ MA-Information ]
				 [ NetLoc-Access-Support ]
				 [ RAT-Type ]
				 [ Sponsored-Connectivity-Data ]
				 [ 3GPP-User-Location-Info ]
				 [ User-Location-Info-Time ]
				 [ 3GPP-MS-TimeZone ]
				*[ RAN-NAS-Release-Cause ]
				*[ 5GS-RAN-NAS-Release-Cause ]
				 [ 3GPP-SGSN-MCC-MNC ]
				 [ NID ]
				 [ TWAN-Identifier ]
				 [ TCP-Source-Port ]
				 [ UDP-Source-Port ]
				 [ UE-Local-IP-Address ]
				 [ Wireline-User-Location-Info ]
				 [ Origin-State-Id ]
				*[ Class ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777236, commandCode = 258, request = true, proxyable = true, name="Re-Auth-Request")
public interface ReAuthRequest extends RxRequest
{
	public List<SpecificActionEnum> getSpecificAction();
	
	void setSpecificAction(List<SpecificActionEnum> value);
	
	List<AccessNetworkChargingIdentifier> getAccessNetworkChargingIdentifier();
	
	void setAccessNetworkChargingIdentifier(List<AccessNetworkChargingIdentifier> value);	

	InetAddress getAccessNetworkChargingAddress();
	
	void setAccessNetworkChargingAddress(InetAddress value);	
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value);
	
	ANTrustedEnum getANTrusted();
	
	void setANTrusted(ANTrustedEnum value);		
	
	public List<Flows> getFlows();
	
	void setFlows(List<Flows> value);
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);
	
	AbortCauseEnum getAbortCause();
	
	void setAbortCause(AbortCauseEnum value);	
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
	
	MAInformation getMAInformation();
	
	void setMAInformation(MAInformation value);
	
	NetLocAccessSupportEnum getNetLocAccessSupport();
	
	void setNetLocAccessSupport(NetLocAccessSupportEnum value);
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
	SponsoredConnectivityData getSponsoredConnectivityData();
	
	void setSponsoredConnectivityData(SponsoredConnectivityData value);	
	
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);	
	
	Date getUserLocationInfoTime();
	
	void setUserLocationInfoTime(Date value);	
	
	ByteBuf getTGPPMSTimeZone();
	
	void setTGPPMSTimeZone(ByteBuf value);	
	
	List<ByteBuf> getRANNASReleaseCause();

	void setRANNASReleaseCause(List<ByteBuf> value);
	
	List<FiveGSRANNASReleaseCause> getFiveGSRANNASReleaseCause();

	void setFiveGSRANNASReleaseCause(List<FiveGSRANNASReleaseCause> value);
	
	public String get3GPPSGSNMCCMNC();
	
	void set3GPPSGSNMCCMNC(String value);
	
	public ByteBuf getNID();
	
	void setNID(ByteBuf value);	
	
	public ByteBuf getTWANIdentifier();
	
	void setTWANIdentifier(ByteBuf value);	
	
	public Long getTCPSourcePort();
	
	void setTCPSourcePort(Long value);	
	
	public Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);	
	
	public InetAddress getUELocalIPAddress();
	
	void setUELocalIPAddress(InetAddress value);	
	
	public WirelineUserLocationInfo getWirelineUserLocationInfo();
	
	void setWirelineUserLocationInfo(WirelineUserLocationInfo value);	
	
	List<ByteBuf> getDiameterClass();

	void setDiameterClass(List<ByteBuf> value);	
}