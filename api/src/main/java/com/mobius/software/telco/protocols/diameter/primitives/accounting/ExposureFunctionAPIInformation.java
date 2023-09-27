package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.66aA	Exposure-Function-API-Information AVP
	The Exposure-Function-API-Information AVP (AVP code 1316) is of type Grouped. Its purpose is to allow the transmission of additional Exposure Function API Information specific information elements. 
	It has the following ABNF grammar:
	
	Exposure-Function-API-Information :: = 	< AVP Header: 1316>
		* 	[ Supported-Features ]
			[ API-Content ]
			[ API-Direction ]
			[ API-Identifier ]
			[ API-Invocation-Timestamp ]
			[ API-Network-Service-Node ]
			[ API-Result-Code ]
			[ API-Size ]
			[ Network-Element ] --- can not find this one
			[ SCEF-Address ]
			[ SCS-AS-Address ]
			[ TLTRI ] 
 */
@DiameterAvpDefinition(code = 1316L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Exposure-Function-API-Information")
public interface ExposureFunctionAPIInformation extends DiameterAvp
{
	List<SupportedFeatures> getSupportedFeatures();
	
	void setSupportedFeatures(List<SupportedFeatures> value);
	
	String getAPIContent();
	
	void setAPIContent(String value);
	
	APIDirectionEnum getAPIDirection();
	
	void setAPIDirection(APIDirectionEnum value);
	
	ByteBuf getAPIIdentifier();
	
	void setAPIIdentifier(ByteBuf value);
	
	Date getAPIInvocationTimestamp();
	
	void setAPIInvocationTimestamp(Date value);
	
	APINetworkServiceNodeEnum getAPINetworkServiceNode();
	
	void setAPINetworkServiceNode(APINetworkServiceNodeEnum value);
	
	Long getAPIResultCode();
	
	void setAPIResultCode(Long value);
	
	Long getAPISize();
	
	void setAPISize(Long value);
	
	InetAddress getSCEFAddress();
	
	void setSCEFAddress(InetAddress value);
	
	SCSASAddress getSCSASAddress();
	
	void setSCSASAddress(SCSASAddress value);
	
	Long getTLTRI();
	
	void setTLTRI(Long value);
}