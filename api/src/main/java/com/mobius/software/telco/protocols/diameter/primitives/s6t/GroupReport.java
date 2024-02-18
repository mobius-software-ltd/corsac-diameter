package com.mobius.software.telco.protocols.diameter.primitives.s6t;
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
 * 	8.4.61	Group-Report
	The Group-Report AVP is of type Grouped, and it contains the information to be reported as requested by Monitoring-Event-Configuration or Suggested-Network-Configuration for a group.
	AVP format:

	Group-Report::=	<AVP header: 3165 10415>
			 { SCEF-Reference-ID }
			 [ SCEF-Reference-ID-Ext ]
			 [ SCEF-ID ]
			*[ Group-Report-Item ]
			*[AVP]

	When the "Extended Reference IDs" feature is supported by the HSS and SCEF, the SCEF-Reference-ID-Ext AVP shall be used insted of SCEF-Reference-ID; in such case, the required AVP "SCEF-Reference-ID" shall be included in the grouped AVP by the sender, but its content shall be discarded by the receiver.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.GROUP_REPORT, vendorId = VendorIDs.TGPP_ID, must = false, name = "Group-Report")
public interface GroupReport extends DiameterGroupedAvp
{
	Long getSCEFReferenceID();
	
	void setSCEFReferenceID(Long value) throws MissingAvpException;
	
	Long getSCEFReferenceIDExt();
	
	void setSCEFReferenceIDExt(Long value);
	
	String getSCEFID();
	
	void setSCEFID(String value);	
	
	List<GroupReportItem> getGroupReportItem();
	
	void setGroupReportItem(List<GroupReportItem> value);
}