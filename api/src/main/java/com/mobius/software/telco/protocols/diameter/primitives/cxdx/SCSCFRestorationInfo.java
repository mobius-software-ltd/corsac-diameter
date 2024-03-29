package com.mobius.software.telco.protocols.diameter.primitives.cxdx;
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
 * 	6.3.46	SCSCF-Restoration-Info AVP
	The SCSCF-Restoration-Info AVP is of type Grouped and it contains the information required for an S-CSCF to handle the requests for a user.
	AVP format
	
		SCSCF-Restoration-Info ::= < AVP Header: 639, 10415>
			  { User-Name }
			1*{ Restoration-Info }
			  [ Registration-Time-Out ]
			  [ SIP-Authentication-Scheme ]
			 *[ AVP ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SCSCF_RESTORATION_INFO, vendorId = VendorIDs.TGPP_ID, must = false, name = "SCSCF-Restoration-Info")
public interface SCSCFRestorationInfo extends DiameterGroupedAvp
{
	String getUserName();
	
	void setUserName(String value) throws MissingAvpException;
	
	List<RestorationInfo> getRestorationInfo();
	
	void setRestorationInfo(List<RestorationInfo> value) throws MissingAvpException;
	
	Date getRegistrationTimeOut();
	
	void setRegistrationTimeOut(Date value);
	
	String getSIPAuthenticationScheme();
	
	void setSIPAuthenticationScheme(String value);
}