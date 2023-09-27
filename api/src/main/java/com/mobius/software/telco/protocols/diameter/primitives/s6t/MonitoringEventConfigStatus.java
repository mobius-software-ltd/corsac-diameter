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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	8.4.24	Monitoring-Event-Config-Status
	The Monitoring-Event-Config-Status AVP is of type Grouped, and it contains the details of the result of the handling of the Requested action for the Monitoring event.
	AVP format:

	Monitoring-Event-Config-Status::=	<AVP header: 3142 10415>
			*[ Service-Report ]
			 { SCEF-Reference-ID }
			 [ SCEF-Reference-ID-Ext ]
			 [ SCEF-ID ]
			*[AVP]

	When the "Extended Reference IDs" feature is supported by the HSS and SCEF, the SCEF-Reference-ID-Ext AVP shall be used insted of SCEF-Reference-ID; in such case, the required AVP "SCEF-Reference-ID" shall be included in the grouped AVP by the sender, but its content shall be discarded by the receiver.
 */
@DiameterAvpDefinition(code = 3142L, vendorId = KnownVendorIDs.TGPP_ID, name = "Monitoring-Event-Config-Status")
public interface MonitoringEventConfigStatus extends DiameterGroupedAvp
{
	List<ServiceReport> getServiceReport();
	
	void setServiceReport(List<ServiceReport> value);
	
	Long getSCEFReferenceID();
	
	void setSCEFReferenceID(Long value);
	
	Long getSCEFReferenceIDExt();
	
	void setSCEFReferenceIDExt(Long value);
	
	String getSCEFID();
	
	void setSCEFID(String value);		
}