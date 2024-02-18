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

import java.util.Date;

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
 * 	7.2.160Db	RAN-Secondary-RAT-Usage-Report AVP
	The RAN-Secondary-RAT-Usage-Report AVP (AVP code 1302) is of type Grouped. This contains the volume count as reported by the RAN for the secondary RAT (separated for uplink and downlink) for the bearer including the time of the report. The 3GPP-Charging-Id AVP associated to this IP-CAN bearer is included when charging per IP-CAN session is active.
	It has the following ABNF grammar:

	RAN-Secondary-RAT-Usage-Report :: = 	  < AVP Header: 1302>
		   [Secondary-RAT-Type ]
		   [ RAN-Start-Timestamp ]
		   [ RAN-End-Timestamp ]
		   [ Accounting-Input-Octets ]
		   [ Accounting-Output-Octets ] 
		   [ 3GPP-Charging-Id ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RAN_SECONDARY_RAT_USAGE_REPORT, vendorId = VendorIDs.TGPP_ID, must = false, name = "RAN-Secondary-RAT-Usage-Report")
public interface RANSecondaryRATUsageReport extends DiameterAvp
{
	ByteBuf getSecondaryRATType();
	
	void setSecondaryRATType(ByteBuf value);
	
	Date getRANStartTimestamp();
	
	void setRANStartTimestamp(Date value);
	
	Date getRANEndTimestamp();
	
	void setRANEndTimestamp(Date value);
	
	Long getAccountingInputOctets();
	
	void setAccountingInputOctets(Long value);
	
	Long getAccountingOutputOctets();
	
	void setAccountingOutputOctets(Long value);
	
	ByteBuf get3GPPChargingId();
	
	void set3GPPChargingId(ByteBuf value);
}