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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.46aaA	Coverage-Info AVP
	The Coverage-Info AVP (AVP code 3459) is of type Grouped and provides information on the coverage status (i.e., whether the UE is served by E-UTRAN or not) and the time when the coverage status changed to its current state. When in E-UTRAN coverage, additionally includes a list of location changes (i.e., ECGI change) and associated time for each change.
	It has the following ABNF grammar:

	Coverage-Info :: = < AVP Header: 3459>	
			[ Coverage-Status ]
			[ Change-Time ]
 		*  	[ Location-Info ]
 */
@DiameterAvpDefinition(code = 3459L, vendorId = KnownVendorIDs.TGPP_ID, name = "Coverage-Info")
public interface CoverageInfo extends DiameterAvp
{
	CoverageStatusEnum getCoverageStatus();
	
	void setCoverageStatus(CoverageStatusEnum value);
	
	Date getChangeTime();
	
	void setChangeTime(Date value);
	
	List<LocationInfo> getLocationInfo();
	
	void setLocationInfo(List<LocationInfo> value);
}