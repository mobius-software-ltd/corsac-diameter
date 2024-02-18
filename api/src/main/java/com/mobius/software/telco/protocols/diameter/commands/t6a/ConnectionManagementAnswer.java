package com.mobius.software.telco.protocols.diameter.commands.t6a;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.APNRateControlStatus;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.8	Connection-Management-Answer (CMA) Command
	The Connection-Management-Answer (CMA) command, indicated by the Command-Code field set to 8388732 and the "R" bit cleared in the Command Flags field, is sent from:
			-	the SCEF to the MME or SGSN;
			-	the SCEF to the MME or SGSN via the IWK-SCEF for roaming cases;
			-	the MME or SGSN to the SCEF;
			-	the MME or SGSN to the SCEF via the IWK-SCEF for roaming cases.

	For the T6a/b, T6ai/bi and T7 interfaces, the Connection-Management-Answer command format is specified as following:
	Message Format:
	
	< Connection-Management-Answer > ::=	< Diameter Header: 8388732, PXY, 16777346 >
				 < Session-Id >
				 [ DRMP ]
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				*[ Load ]
				*[ Supported-Features ]
				 [ PDN-Connection-Charging-Id ]
				 [ Extended-PCO ]
				 [ APN-Rate-Control-Status ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				*[AVP]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.T6A, commandCode = CommandCodes.CONNECTION_MANAGEMENT, request = false, proxyable = true, name="Connection-Management-Answer")
public interface ConnectionManagementAnswer extends T6aAnswer
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);
	 
	Long getPDNConnectionChargingID();
	 
	void setPDNConnectionChargingID(Long value);	
	
	ByteBuf getExtendedPCO();
	 
	void setExtendedPCO(ByteBuf value);
	
	APNRateControlStatus getAPNRateControlStatus();
	
	void setAPNRateControlStatus(APNRateControlStatus value);
}