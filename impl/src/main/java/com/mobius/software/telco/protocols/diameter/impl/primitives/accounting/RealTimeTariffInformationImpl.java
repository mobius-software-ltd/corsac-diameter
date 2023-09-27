package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RealTimeTariffInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TariffInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TariffXML;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.164	Real-Time-Tariff-Information AVP
	The Real-Time-Tariff-Information AVP (AVP code 2305) is of type Grouped and holds the tariff information received in real time according to TS 29.658 [222] in the SIP signalling.
	It has the following ABNF grammar:
	
	< Real-Time-Tariff-Information > :: =  < AVP Header: 2305 >
			 [ Tariff-Information ]
			 [ Tariff-XML ]
 */
@DiameterAvpImplementation(code = 2305L, vendorId = KnownVendorIDs.TGPP_ID)
public class RealTimeTariffInformationImpl implements RealTimeTariffInformation
{
	private TariffInformation tariffInformation;
	private TariffXML tariffXML;
		
	public RealTimeTariffInformationImpl()
	{
		
	}
	
	public TariffInformation getTariffInformation()
	{
		return this.tariffInformation;
	}
	
	public void setTariffInformation(TariffInformation value)
	{
		this.tariffInformation = value;
	}
	
	public String getTariffXML()
	{
		if(tariffXML==null)
			return null;
		
		return tariffXML.getString();
	}
	
	public void setTariffXML(String value)
	{
		if(value==null)
			this.tariffXML = null;
		else
			this.tariffXML = new TariffXMLImpl(value, null, null);			
	}
}