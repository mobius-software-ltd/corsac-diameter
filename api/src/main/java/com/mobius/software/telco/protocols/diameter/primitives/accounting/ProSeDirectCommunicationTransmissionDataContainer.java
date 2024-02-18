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
 * 	7.2.154B	ProSe-Direct-Communication-Transmission-Data-Container AVP
	The ProSe-Direct-Communication- Transmission-Data-Container AVP (AVP code 3441) is of type Grouped. Its purpose is to allow the transmission of the container to be reported for ProSe Charging. On encountering change on ProSe charging condition, this container  identifies the volume count for transmitting within a ProSe group communication.
	It has the following ABNF grammar:
            
	ProSe-Direct-Communication- Transmission-Data-Container :: =  < AVP Header: 3441>
			[ Local-Sequence-Number ]
			[ Coverage-status ]
			[ 3GPP-User-Location-Info ]
			[ Accounting-Output-Octets ]
			[ Change-Time ]
			[ Change-Condition ]
			[ Visited-PLMN-Id ]
			[ Usage-Information-Report-Sequence-Number ] 
			[ Radio-Resources-Indicator ]
			[ Radio-Frequency ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.PROSE_DIRECT_COMMUNICATION_TRANSMISSION_DATA_CONTAINER, vendorId = VendorIDs.TGPP_ID, name = "ProSe-Direct-Communication- Transmission-Data-Container")
public interface ProSeDirectCommunicationTransmissionDataContainer extends DiameterAvp
{
	Long getLocalSequenceNumber();
	
	void setLocalSequenceNumber(Long value);
	
	CoverageStatusEnum getCoverageStatus();
	
	void setCoverageStatus(CoverageStatusEnum value);
	
	ByteBuf getTGPPUserLocationInfo();
	
	void setTGPPUserLocationInfo(ByteBuf value);
	
	Long getAccountingOutputOctets();
	
	void setAccountingOutputOctets(Long value);
	
	Date getChangeTime();
	
	void setChangeTime(Date value);
	
	Long getChangeCondition();
	
	void setChangeCondition(Long value);
	
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
	
	Integer getUsageInformationReportSequenceNumber();
	
	void setUsageInformationReportSequenceNumber(Integer value);
	
	RadioResourcesIndicatorEnum getRadioResourcesIndicator();
	
	void setRadioResourcesIndicator(RadioResourcesIndicatorEnum value);
	
	ByteBuf getRadioFrequency();
	
	void setRadioFrequency(ByteBuf value);
}