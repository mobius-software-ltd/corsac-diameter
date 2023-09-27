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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.223	Tariff-Information AVP
	The Tariff-Information AVP (AVP code 2060) is of type Grouped and holds a tariff definition either from the local provider or from 3rd party provider. It contains information about the operator and the ID of the service being provided, the current tariff and possible next tariff after tariff switch time. It may also chain to tariffs provided by intermediate operators in the chain.
	It has the following ABNF grammar:

	Tariff-Information :: =  < AVP Header: 2060 >
  		{ Current-Tariff }
		[ Tariff-Time-Change ]
		[ Next-Tariff ]
 */
@DiameterAvpDefinition(code = 2060L, vendorId = KnownVendorIDs.TGPP_ID, name = "Tariff-Information")
public interface TariffInformation extends DiameterAvp
{
	CurrentTariff getCurrentTariff();
	
	void setCurrentTariff(CurrentTariff value);
	
	Date getTariffTimeChange();
	
	void setTariffTimeChange(Date value);
	
	NextTariff getNextTariff();
	
	void setNextTariff(NextTariff value);
}