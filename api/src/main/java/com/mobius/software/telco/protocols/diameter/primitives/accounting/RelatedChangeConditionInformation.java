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

import java.net.InetAddress;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatusEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.171Aa	Related-Change-Condition-Information AVP
	The Related-Change-Condition-Information AVP (AVP code 3925) is of type Grouped. Its purpose is to allow the transmission of the change condition information that occurred on another access of a multi-access PDN connection that triggered an indirect change condition of the current access. In additional to the identification of the change condition(s) that occurred on the other access, the supplemental data for that event is also included (e.g., user location information).
	It has the following ABNF grammar:
            
	Related-Change-Condition-Information :: =  < AVP Header: 3925>
   			[ SGSN-Address ] 
 		*	[ Change-Condition]
		    [ 3GPP-User-Location-Info ]
		    [ 3GPP2-BSID ]
		    [ UWAN-User-Location-Info ]
		    [ Presence-Reporting-Area-Status ]
		    [ User-CSG-Information ]  
			[ 3GPP-RAT-Type ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RELATED_CHANGE_CONDITION_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "Related-Change-Condition-Information")
public interface RelatedChangeConditionInformation extends DiameterAvp
{
	InetAddress getSGSNAddress();
	
	void setSGSNAddress(InetAddress value);
	
	List<Long> getChangeCondition();
	
	void setChangeCondition(List<Long> value);
	
	ByteBuf get3GPPUserLocationInfo();
	
	void set3GPPUserLocationInfo(ByteBuf value);
	
	ByteBuf get3GPP2BSID();
	
	void set3GPP2BSID(ByteBuf value);
	
	UWANUserLocationInfo getUWANUserLocationInfo();
	
	void setUWANUserLocationInfo(UWANUserLocationInfo value);
	
	PresenceReportingAreaStatusEnum getPresenceReportingAreaStatus();
	
	void setPresenceReportingAreaStatus(PresenceReportingAreaStatusEnum value);
	
	UserCSGInformation getUserCSGInformation();
	
	void setUserCSGInformation(UserCSGInformation value);
	
	ByteBuf get3GPPRATType();
	
	void set3GPPRATType(ByteBuf value);		
}