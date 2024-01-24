package com.mobius.software.telco.protocols.diameter.commands.slg;
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
 * MERCHANTABILITY or FITNESS FOR A PARTICLRAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

import java.net.InetAddress;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LRAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingPLMNList;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.4	Location-Report-Answer (LRA) Command
	The Location-Report-Answer (LRA) command, indicated by the Command-Code field set to 8388621 and the 'R' bit cleared in the Command Flags field, is sent by the GMLC to the MME or SGSN in response to the Location-Report-Request command.
	Message Format

	< Location-Report-Answer > ::=	< Diameter Header: 8388621, PXY, 16777255>
				 < Session-Id >
				 [ DRMP ]
				 [ Vendor-Specific-Application-Id ]
				 [ Result-Code ]
				 [ Experimental-Result ]
				 { Auth-Session-State }
				 { Origin-Host }
				 { Origin-Realm }
				 [ GMLC-Address ]
				 [ LRA-Flags ]
				 [ Reporting-PLMN-List ]
				 [ LCS-Reference-Number ]
				*[ Supported-Features ]
				*[ AVP ]
				 [ Failed-AVP ]
				*[ Proxy-Info ]
				*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777255, commandCode = 8388621, request = false, proxyable = true, name="Location-Report-Answer")
public interface LocationReportAnswer extends SlgAnswer
{
	InetAddress getGMLCAddress();
	
	void setGMLCAddress(InetAddress value);
	
	LRAFlags getLRAFlags();
	
	void setLRAFlags(LRAFlags value);
	
	ReportingPLMNList getReportingPLMNList();
	
	void setReportingPLMNList(ReportingPLMNList value);
	
	ByteBuf getLCSReferenceNumber();
	
	void setLCSReferenceNumber(ByteBuf value);
}