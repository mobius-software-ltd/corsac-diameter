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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.MultipleServicesCreditControl;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.121	Offline-Charging AVP
	The Offline-Charging AVP (AVP code 1278) is a grouped AVP, which is used to set the parameters required to control offline charging. 
	It has the following ABNF grammar:

	Offline-Charging ::=     < AVP Header:1278 >	
			[ Quota-Consumption-Time ]
			[ Time-Quota-Mechanism ]
			[ Envelope-Reporting ]
		*	[ Multiple-Services-Credit-Control ]	
		*	[ AVP ]

	At most one of Quota-Consumption-Time AVP or Time-Quota-Mechanism AVP shall be present, if individual instances are not included within the Multiple-Services-Credit-Control AVP. 
	The Multiple-Services-Credit-Control AVPs, if present, shall contain the Rating-Group AVP to identify the category, optionally one of Quota-Consumption-Time AVP and Time-Quota-Mechanism AVP, and optionally the Envelope-Reporting AVP. 
	Any values specified in the Offline-Charging AVP take precedence over the configured defaults. The values of the parameters specified at Multiple-Services-Credit-Control level take precedence over the values specified directly at Offline-Charging level. If neither Quota-Consumption-Time AVP nor Time-Quota-Mechanism AVP is included in the Multiple-Services-Credit-Control AVP, then the general reporting requirements dictated by the Quota-Consumption-Time AVP or Time-Quota-Mechanism AVP and Envelope-Reporting AVP directly within the Offline-Charging AVP shall apply.
 */
@DiameterAvpDefinition(code = 1278L, vendorId = KnownVendorIDs.TGPP_ID, name = "Offline-Charging")
public interface OfflineCharging extends DiameterGroupedAvp
{
	Long getQuotaConsumptionTime();
	
	void setQuotaConsumptionTime(Long value);
	
	TimeQuotaMechanism getTimeQuotaMechanism();
	
	void setTimeQuotaMechanism(TimeQuotaMechanism value);
	
	EnvelopeReportingEnum getEnvelopeReporting();
	
	void setEnvelopeReporting(EnvelopeReportingEnum value);
	
	List<MultipleServicesCreditControl> getMultipleServicesCreditControl();
	
	void setMultipleServicesCreditControl(List<MultipleServicesCreditControl> value);
}