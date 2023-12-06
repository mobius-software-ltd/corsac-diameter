package com.mobius.software.telco.protocols.diameter.commands.st;
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
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5c.6.5	Session-Termination-Answer (STA) command
	The STA command, indicated by the Command-Code field set to 275 and the ‘R’ bit cleared in the Command Flags field, is sent by the TSSF to the PCRF in response to the STR command.
	Message Format:

	<ST-Answer>  ::= < Diameter Header: 275, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Origin-Host }
				 { Origin-Realm }
				 [ Result-Code ]
				 [ Error-Message ]
				 [ Error-Reporting-Host ]	
				 [ OC-Supported-Features ]
				 [ OC-OLR ]
				 [ Failed-AVP ]
				 [ Origin-State-Id ]
				*[ Class ]
				*[ Redirect-Host ]
				 [ Redirect-Host-Usage ]
				 [ Redirect-Max-Cache-Time ]
				*[ Proxy-Info ]
				*[ Load ]
				*[ AVP ]

 */
@DiameterCommandDefinition(applicationId = 16777349, commandCode = 275, request = false, proxyable = true, name="Session-Termination-Answer")
public interface SessionTerminationAnswer extends AuthenticationAnswer
{
	public DRMPEnum getDRMP();
	 
	void setDRMP(DRMPEnum value);

	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	
	void setLoad(List<Load> value);
}