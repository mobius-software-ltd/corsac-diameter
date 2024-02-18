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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.59	Envelope AVP
	The Envelope AVP (AVP code 1266) is a grouped AVP which reports the start and end time of one time envelope using the Envelope-Start-Time and Envelope-End-Time AVPs. Further details of its usage are described in clause 6.5.6 and clause 6.5.7.
	
	Envelope :: = < AVP Header: 1266> 
		{ Envelope-Start-Time }
		[ Envelope-End-Time ]
		[ CC-Total-Octets ]
		[ CC-Input-Octets ]
		[ CC-Output-Octets ]
		[ CC-Service-Specific-Units ]

	If an envelope has not been closed at the time of the usage report, then the Envelope-End-Time AVP shall be absent. If an envelope was started before the reporting interval then the Envelope-Start-Time is nevertheless present and contains the same time as previously reported, i.e. the actual time of the start of the envelope. The client shall include the volume reports (the CC-xxxxx-Octets AVPs) or events (CC-Service-Specific-Units AVP) if these were requested in the corresponding Envelope-Reporting AVP. The reported volume is always the volume from the beginning of the time envelope.
	In circumstances, in which an envelope is retrospectively deemed to have been closed, e.g. with Quota-Consumption-Time changes in a CCA, then the client shall include the Envelope AVP for the envelope in the next usage report.
	Multiple occurrences of this AVP shall be in chronological order, i.e. the first envelope is listed first in CCR.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.ENVELOPE, vendorId = VendorIDs.TGPP_ID, name = "Envelope")
public interface Envelope extends DiameterAvp
{
	Date getEnvelopeStartTime();
	
	void setEnvelopeStartTime(Date value) throws MissingAvpException;
	
	Date getEnvelopeEndTime();
	
	void setEnvelopeEndTime(Date value);
	
	Long getCcTotalOctets();
	
	void setCcTotalOctets(Long value);
	
	Long getCcInputOctets();
	
	void setCcInputOctets(Long value);
	
	Long getCcOutputOctets();
	
	void setCcOutputOctets(Long value);
	
	Long getCcServiceSpecificUnits();
	
	void setCcServiceSpecificUnits(Long value);
}