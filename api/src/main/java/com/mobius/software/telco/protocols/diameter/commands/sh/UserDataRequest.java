package com.mobius.software.telco.protocols.diameter.commands.sh;
import java.util.List;

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
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SessionPriorityEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.sh.CallReferenceInfo;
import com.mobius.software.telco.protocols.diameter.primitives.sh.CurrentLocationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.DataReferenceEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.IdentitySetEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.LocalTimeZoneIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.PrePagingSupportedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.RequestedDomainEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.RequestedNodes;
import com.mobius.software.telco.protocols.diameter.primitives.sh.ServingNodeIndicationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UDRFlags;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.1.1	User-Data-Request (UDR) Command
	The User-Data-Request (UDR) command, indicated by the Command-Code field set to 306 and the 'R' bit set in the Command Flags field, is sent by a Diameter client to a Diameter server in order to request user data.
	Message Format

	< User-Data -Request> ::=	< Diameter Header: 306, REQ, PXY, 16777217 >
				 < Session-Id >
				 [ DRMP ]
				 { Vendor-Specific-Application-Id }
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ Destination-Host ]
				 { Destination-Realm }
				*[ Supported-Features ]
				 { User-Identity }
				 [ Wildcarded-Public-Identity ]
				 [ Wildcarded-IMPU ]
				 [ Server-Name ]
				*[ Service-Indication ]
				*{ Data-Reference }
				*[ Identity-Set ]
				 [ Requested-Domain ]
				 [ Current-Location ]
				*[ DSAI-Tag ]
				 [ Session-Priority ]
				 [ User-Name ]
				 [ Requested-Nodes ]
				 [ Serving-Node-Indication ]
				 [ Pre-paging-Supported ]
				 [ Local-Time-Zone-Indication ]
				 [ UDR-Flags ]
				 [ Call-Reference-Info ]
				 [ OC-Supported-Features ]
				*[ AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777217, commandCode = 306, request = true, proxyable = true, name="User-Data-Request")
public interface UserDataRequest extends ShRequest
{
	String getServerName();
	
	void setServerName(String value);
	
	public List<ByteBuf> getServiceIndication();
	 
	void setServiceIndication(List<ByteBuf> value);
	
	public List<DataReferenceEnum> getDataReference();
	 
	void setDataReference(List<DataReferenceEnum> value);
	
	public List<IdentitySetEnum> getIdentitySet();
	 
	void setIdentitySet(List<IdentitySetEnum> value);
	
	RequestedDomainEnum getRequestedDomain();
	
	void setRequestedDomain(RequestedDomainEnum value);
	
	CurrentLocationEnum getCurrentLocation();
	
	void setCurrentLocation(CurrentLocationEnum value);
	
	List<ByteBuf> getDSAITag();
	
	void setDSAITag(List<ByteBuf> value);
	
	SessionPriorityEnum getSessionPriority();
	
	void setSessionPriority(SessionPriorityEnum value);
	
	RequestedNodes getRequestedNodes();
	
	void setRequestedNodes(RequestedNodes value);
	
	ServingNodeIndicationEnum getServingNodeIndication();
	
	void setServingNodeIndication(ServingNodeIndicationEnum value);
	
	PrePagingSupportedEnum getPrePagingSupported();
	
	void setPrePagingSupported(PrePagingSupportedEnum value);
	
	LocalTimeZoneIndicationEnum getLocalTimeZoneIndication();
	
	void setLocalTimeZoneIndication(LocalTimeZoneIndicationEnum value);
			
	UDRFlags getUDRFlags();
	
	void setUDRFlags(UDRFlags value);	
					 
	CallReferenceInfo getCallReferenceInfo();
	
	void setCallReferenceInfo(CallReferenceInfo value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);	
}