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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoExtension;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AcceptableServiceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.AccessNetworkChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MAInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ServiceAuthorizationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sta.ANTrustedEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 *  5.6.2	AA-Answer (AAA) command
	The AAA command, indicated by the Command-Code field set to 265 and the ‘R’ bit cleared in the Command Flags field, is sent by the PCRF to the AF in response to the AAR command.
	Message Format:
	
	<AA-Answer> ::=  < Diameter Header: 265, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Result-Code ]
				 [ Experimental-Result ]
				 [ Auth-Session-State ]
				*[ Access-Network-Charging-Identifier ]
				 [ Access-Network-Charging-Address ]
				 [ Acceptable-Service-Info ]
			  0*2[ AN-GW-Address ]
				 [ AN-Trusted ]
				 [ Service-Authorization-Info ]
				 [ IP-CAN-Type ]
				 [ MA-Information ]
				 [ NetLoc-Access-Support ]
				 [ RAT-Type ]
				*[ Flows ]
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				*[ Supported-Features ]
				*[ Subscription-Id ]
				 [ User-Equipment-Info ]
				 [ User-Equipment-Info-Extension ]
				 [ 3GPP-SGSN-MCC-MNC ]
				 [ NID ]
				*[ Class ]
				 [ Error-Message ]
				 [ Error-Reporting-Host ]
				 [ Failed-AVP ]
				 [ Retry-Interval ]
				 [ Origin-State-Id ]
				*[ Redirect-Host ]
				 [ Redirect-Host-Usage ]
				 [ Redirect-Max-Cache-Time ]
				*[ Proxy-Info ]
				*[ Load ]
				*[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777236, commandCode = 265, request = false, proxyable = true, name="AA-Answer")
public interface AAAnswer extends RxAnswer
{
	public AuthSessionStateEnum getAuthSessionState();
	
	public void setAuthSessionState(AuthSessionStateEnum value);	
	
	List<AccessNetworkChargingIdentifier> getAccessNetworkChargingIdentifier();
	
	void setAccessNetworkChargingIdentifier(List<AccessNetworkChargingIdentifier> value);	

	InetAddress getAccessNetworkChargingAddress();
	
	void setAccessNetworkChargingAddress(InetAddress value);	
	
	AcceptableServiceInfo getAcceptableServiceInfo();
	
	void setAcceptableServiceInfo(AcceptableServiceInfo value);	
	
	List<InetAddress> getANGWAddress();
	
	void setANGWAddress(List<InetAddress> value);
	
	ANTrustedEnum getANTrusted();
	
	void setANTrusted(ANTrustedEnum value);		
	
	ServiceAuthorizationInfo getServiceAuthorizationInfo();
	
	void setServiceAuthorizationInfo(ServiceAuthorizationInfo value);		
	
	IPCANTypeEnum getIPCANType();
	
	void setIPCANType(IPCANTypeEnum value);
	
	MAInformation getMAInformation();
	
	void setMAInformation(MAInformation value);
	
	NetLocAccessSupportEnum getNetLocAccessSupport();
	
	void setNetLocAccessSupport(NetLocAccessSupportEnum value);
	
	RATTypeEnum getRATType();
	
	void setRATType(RATTypeEnum value);
	
	public List<Flows> getFlows();
	
	void setFlows(List<Flows> value);
	
	public List<SupportedFeatures> getSupportedFeatures();
	
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	public List<SubscriptionId> getSubscriptionId();
	
	void setSubscriptionId(List<SubscriptionId> value);
	
	public UserEquipmentInfo getUserEquipmentInfo();
	
	void setUserEquipmentInfo(UserEquipmentInfo value);

	public UserEquipmentInfoExtension getUserEquipmentInfoExtension();
	
	void setUserEquipmentInfoExtension(UserEquipmentInfoExtension value);
	
	public String get3GPPSGSNMCCMNC();
	
	void set3GPPSGSNMCCMNC(String value);
	
	public ByteBuf getNID();
	
	void setNID(ByteBuf value);	
	
	List<ByteBuf> getDiameterClass();	
	
	void setDiameterClass(List<ByteBuf> value);
	
	public Long getRetryInterval();
	
	void setRetryInterval(Long value);
	
	public List<Load> getLoad();
	
	void setLoad(List<Load> value);
}