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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.TDAFlags;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.12	MT-Data-Answer (TDA) Command
	The MT-Data-Answer (TDA) command, indicated by the Command-Code field set to 8388734 and the "R" bit cleared in the Command Flags field, is sent from:
			-	the MME or SGSN to the SCEF;
			-	the MME or SGSN to the IWK-SCEF and
			-	the IWK-SCEF to the SCEF.

	For the T6a/b, T6ai/bi and T7 interfaces, the MT-Data-Answer command format is specified as following:
	Message Format:

	< MT-Data-Answer > ::=	< Diameter Header: 8388734, PXY, 16777346 >
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
				 [ Requested-Retransmission-Time ]
				*[ Supported-Features ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
				 [ TDA-Flags ]
				*[AVP]
 */
@DiameterCommandDefinition(applicationId = 16777346, commandCode = 8388734, request = false, proxyable = true, name="MT-Data-Answer")
public interface MTDataAnswer extends T6aAnswer
{
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);
	
	Date getRequestedRetransmissionTime();
	
	void setRequestedRetransmissionTime	(Date value);	
	
	TDAFlags getTDAFlags();
	
	void setTDAFlags(TDAFlags value);	
}