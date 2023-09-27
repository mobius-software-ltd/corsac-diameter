package com.mobius.software.telco.protocols.diameter.primitives.gq;
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
 * 	7.3.3 Binding-Output-List AVP
	The Binding-Output-List AVP (AVP code 452) is of type Grouped and contains a list of transport addresses which is
	the result of the binding operation performed by the transport plane functions.
	The rules for how to populate the Binding-Output-List AVP are the same rules as for how to populate the BindingInput-list AVP given in clause 7.3.2 provided that Binding-Input-List AVP is replaced by Binding-Output-List AVP.
	AVP format:

	Binding-Output-List ::= < AVP Header: 452 13019>
		 *[ V6-Transport-Address ]
		 *[ V4-Transport-Address ] 
*/
@DiameterAvpDefinition(code = 452L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Binding-Output-List")
public interface BindingOutputList extends DiameterAvp
{
	List<V6TransportAddress> getV6TransportAddress();
	
	void setV6TransportAddress(List<V6TransportAddress> value);	
	
	List<V4TransportAddress> getV4TransportAddress();
	
	void setV4TransportAddress(List<V4TransportAddress> value);	
}