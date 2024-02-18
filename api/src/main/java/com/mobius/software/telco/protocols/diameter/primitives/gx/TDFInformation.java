package com.mobius.software.telco.protocols.diameter.primitives.gx;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.78	TDF-Information AVP
	The TDF-Information AVP (AVP code 1087) is of type Grouped and may be sent from the PCEF to the PCRF in a Gx CCR with CC-Request-Type set to INITIAL-REQUEST. This AVP contains the information about the TDF that shall handle the application detection and reporting for that IP-CAN Session. The PCRF shall create the TDF session with that TDF.
	The TDF-Information AVP shall include either the TDF-Destination-Realm and TDF-Destination-Host AVP, or the TDF-IP-Address AVP.
	
	NOTE:	The TDF-Information AVP may also be pre-provisioned in the PCRF. In case the TDF-Information AVP pre-provisioned at the PCRF and not received from the PCEF, it is being handled e.g. by configuration that PCEF routes the traffic to the same TDF. In case the TDF-Information is pre-provisioned in the PCRF and also the value is received in CC-Request from the PCEF, the value received in CC-Request takes precedence over pre-provisioned value.

	AVP Format:
	TDF-Information::= < AVP Header: 1087 >
		[ TDF-Destination-Realm ]
		[ TDF-Destination-Host ]
		[ TDF-IP-Address ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.TDF_INFORMATION, vendorId = VendorIDs.TGPP_ID, must=false, name = "TDF-Information")
public interface TDFInformation extends DiameterAvp
{
	String getTDFDestinationRealm();
	
	void setTDFDestinationRealm(String value);	
	
	String getTDFDestinationHost();
	
	void setTDFDestinationHost(String value);	
	
	InetAddress getTDFIPAddress();
	
	void setTDFIPAddress(InetAddress value);
}