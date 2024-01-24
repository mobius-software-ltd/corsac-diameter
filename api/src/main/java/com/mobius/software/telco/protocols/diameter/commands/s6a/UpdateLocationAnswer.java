package com.mobius.software.telco.protocols.diameter.commands.s6a;
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
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ErrorDiagnosticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.ULAFlags;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.4	Update-Location-Answer (ULA) Command
	The Update-Location-Answer (ULA) command, indicated by the Command-Code field set to 316 and the 'R' bit cleared in the Command Flags field, is sent from HSS to MME or SGSN.
	Message Format

	< Update-Location-Answer> ::=	< Diameter Header: 316, PXY, 16777251 >
					 < Session-Id >
					 [ DRMP ]
					 [ Vendor-Specific-Application-Id ]
					 [ Result-Code ]
					 [ Experimental-Result ]
					 [ Error-Diagnostic ]
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					 [ OC-Supported-Features ]
					 [ OC-OLR ]
					*[ Load ]
					*[ Supported-Features ]
					 [ ULA-Flags ]
					 [ Subscription-Data ]
					*[ Reset-ID ]
					*[ AVP ]
					 [ Failed-AVP ]
					*[ Proxy-Info ]
					*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777251, commandCode = 316, request = false, proxyable = true, name="Update-Location-Answer")
public interface UpdateLocationAnswer extends S6aAnswer
{
	ErrorDiagnosticEnum getErrorDiagnostic();
	 
	void setErrorDiagnostic(ErrorDiagnosticEnum value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	 		
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);
	 		
	ULAFlags getULAFlags();
	
	void setULAFlags(ULAFlags value);
	
	SubscriptionData getSubscriptionData();
	 
	void setSubscriptionData(SubscriptionData value);
		
	List<ByteBuf> getResetID();
	 
	void setResetID(List<ByteBuf> value);
}