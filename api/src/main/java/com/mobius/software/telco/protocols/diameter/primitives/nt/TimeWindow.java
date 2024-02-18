package com.mobius.software.telco.protocols.diameter.primitives.nt;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.5	Time-Window AVP
	The Time-Window AVP (AVP code 4204) is of type Grouped. It contains a Transfer-Start-Time and a Transfer-End-Time. It describes the time interval during which the SCS/AS may realize the background data transfer.
	Time-window ::= < AVP Header: 4204 >
                   { Transfer-Start-Time }
                   { Transfer-End-Time }
                  *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.NT_TIME_WINDOW, vendorId = VendorIDs.TGPP_ID, name = "Time-Window")
public interface TimeWindow extends DiameterGroupedAvp
{
	Date getTransferStartTime();
	
	void setTransferStartTime(Date value) throws MissingAvpException;
	
	Date getTransferEndTime();
	
	void setTransferEndTime(Date value) throws MissingAvpException;
}