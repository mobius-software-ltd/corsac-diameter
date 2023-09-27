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
 * 	7.2.12aB	Announcement-Information AVP
	The Announcement-Information AVP (AVP code 3904) is of type Grouped and holds the Announcement service parameters. Each Announcement-Information AVP specifies a single announcement to be played to the specified user.
	The Announcement-Order AVP contains the order in which announcements should be connected for playback when there are multiple Announcement-Information AVPs provided in a single message with the same timing indicator.
	It has the following ABNF grammar:

	Announcement-Information:: =  < AVP Header: 3904 >
			{ Announcement-Identifier }
		*	[ Variable-Part ]
			[ Time-Indicator ]
			[ Quota-Indicator ]
			[ Announcement-Order ]
			[ Play-Alternative ]
			[ Privacy-Indicator ]
		 	[ Language ]
 */
@DiameterAvpDefinition(code = 3904L, vendorId = KnownVendorIDs.TGPP_ID, name = "Announcement-Information")
public interface AnnouncementInformation extends DiameterAvp
{
	Long getAnnouncementIdentifier();
	
	void setAnnouncementIdentifier(Long value);
	
	List<VariablePart> getVariablePart();
	
	void setVariablePart(List<VariablePart> value);
	
	Long getTimeIndicator();
	
	void setTimeIndicator(Long value);
	
	QuotaIndicatorEnum getQuotaIndicator();
	
	void setQuotaIndicator(QuotaIndicatorEnum value);
	
	Long getAnnouncementOrder();
	
	void setAnnouncementOrder(Long value);
	
	PlayAlternativeEnum getPlayAlternative();
	
	void setPlayAlternative(PlayAlternativeEnum value);
	
	PrivacyIndicatorEnum getPrivacyIndicator();
	
	void setPrivacyIndicator(PrivacyIndicatorEnum value);
	
	String getLanguage();
	
	void setLanguage(String value);
}