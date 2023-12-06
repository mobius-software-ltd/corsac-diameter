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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.nt.TransferPolicy;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.6.3	Background-Data-Transfer-Answer (BTA) command
	The BTA command, indicated by the Command-Code field set to 8388723 and the 'R' bit cleared in the Command Flags field, is sent by the PCRF to the SCEF as part of Negotiation for future background data transfer procedure.
	Message Format:

	<BT-Answer> ::= <Diameter Header: 8388723, PXY >
                 < Session-Id >
                 [ DRMP ]
                 { Vendor-Specific-Application-Id }
                 { Auth-Session-State }
                 { Origin-Host }
                 { Origin-Realm}
                 [ Result-Code ]
                 [ Experimental-Result ]
                 [ Error-Message ]
                 [ Error-Reporting-Host ]
                 [ Failed-AVP ]
                *[ Redirect-Host ]
                 [ Redirect-Host-Usage ]
                 [ Redirect-Max-Cache-Time ]
                 [ Reference-Id ]
                 [ OC-Supported-Features ]
                 [ OC-OLR ]
                *[ Transfer-Policy ]
                 [ PCRF-Address ]
                *[ Proxy-Info ]
                *[ Route-Record ]
                *[ Supported-Features ]
                *[ Load ]
                *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = 16777348, commandCode = 8388723, request = false, proxyable = true, name="Server-Assignment-Answer")
public interface BackgroundDataTransferAnswer extends NtAnswer
{
	ByteBuf getReferenceId();
	 
	void setReferenceId(ByteBuf value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<TransferPolicy> getTransferPolicy();
	
	void setTransferPolicy(List<TransferPolicy> value);
					 
	String getPCRFAddress();
	
	void setPCRFAddress(String value);
					 
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);	 			
}