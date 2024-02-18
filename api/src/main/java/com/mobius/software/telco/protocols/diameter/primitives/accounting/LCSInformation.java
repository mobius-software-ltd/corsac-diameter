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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.89	LCS-Information AVP
	The LCS-Information AVP (AVP code 878) is of type Grouped. Its purpose is to allow the transmission of additional LCS service specific information elements. 
	It has the following ABNF grammar:

	LCS-Information :: = < AVP Header: 878>
		[ LCS-Client-ID ]
		[ Location-Type ]
		[ Location-Estimate ]
		[ Positioning-Data ]
		[ 3GPP-IMSI ]
		[ MSISDN ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.LCS_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "LCS-Information")
public interface LCSInformation extends DiameterAvp
{
	LCSClientID getLCSClientID();
	
	void setLCSClientID(LCSClientID value);
	
	LocationType getLocationType();
	
	void setLocationType(LocationType value);
	
	ByteBuf getLocationEstimate();
	
	void setLocationEstimate(ByteBuf value);
	
	String getPositioningData();
	
	void setPositioningData(String value);
	
	String getTGPPIMSI();
	
	void setTGPPIMSI(String value);
	
	String getMSISDN();
	
	void setMSISDN(String value);
}