package com.mobius.software.telco.protocols.diameter.commands.nt;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TimeWindow;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.2	Background-Data-Transfer-Request (BTR) command
	The BTR command, indicated by the Command-Code field set to 8388723 and the 'R' bit set in the Command Flags field, is sent by the SCEF to the PCRF as part of Negotiation for future background data transfer procedure.
	Message Format:

	<BT-Request> ::= <Diameter Header: 8388723, REQ, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Vendor-Specific-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm }
                 { Destination-Realm }
                 { Transfer-Request-Type }
                 [ Destination-Host ]
                 [ OC-Supported-Features ]
                 [ Application-Service-Provider-Identity ]
                 [ CC-Output-Octets ]
                 [ CC-Input-Octets ]
                 [ CC-Total-Octets ]
                 [ Number-Of-UEs ]
                 [ Time-Window ]
                 [ Network-Area-Info-List ]
                 [ Reference-Id ]
                 [ Transfer-Policy-Id ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ Supported-Features ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777348, commandCode = 8388723, request = true, proxyable = true, name="Background-Data-Transfer-Request")
public interface BackgroundDataTransferRequest extends NtRequest
{
	TransferRequestTypeEnum getTransferRequestType();
	
	void setTransferRequestType(TransferRequestTypeEnum value);	
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 	
	String getApplicationServiceProviderIdentity();
	
	void setApplicationServiceProviderIdentity(String value);
	
	Long getCCOutputOctets();
	
	void setCCOutputOctets(Long value);	
	
	Long getCCInputOctets();
	
	void setCCInputOctets(Long value);	
	
	Long getCCTotalOctets();
	
	void setCCTotalOctets(Long value);	
	
	Long getNumberOfUEs();
	
	void setNumberOfUEs(Long value);
	
	TimeWindow getTimeWindow();
	
	void setTimeWindow(TimeWindow value);
	
	ByteBuf getNetworkAreaInfoList();
	
	void setNetworkAreaInfoList(ByteBuf value);
						
	ByteBuf getReferenceId();
    
    void setReferenceId(ByteBuf value);
    
    Long getTransferPolicyId();
    
    void setTransferPolicyId(Long value);
}