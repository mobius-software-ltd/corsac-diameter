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
 * 	7.3.2 Binding-Input-List AVP
	The Binding-Input-List AVP (AVP code 451) is of type Grouped and contains a list transport addresses for which a
	binding is requested. The AF constructs the Binding-Input-List using SDI information.
	The Binding-Input-List AVP is populated with an even number of V4-Transport-Address AVP or V6-TransportAddress list elements. The first list element in each pair of list elements applies to the access side and the second
	element applies to the core side. In case one of the V4-Transport-Address AVP or V6-Transport-Address AVP is such
	pair is unknown, an even number of list elements shall be still provided with the unknown V4-Transport-Address AVP
	or V6-Transport-Address AVP wild-carded.
	The above-given rules applies to the P-CSCF but is also valid for the IBCF provided that "access side" is replaced by
	"local core side" and "core side" by "peer core side".
	It shall be one pair of V4-Transport-Address AVP or V6-Transport-Address list elements in the Binding-Input-List
	AVP for each single Media-Component-Description AVP in an AAR. The list of such pairs shall be given in the same
	order as the list of Media-Component-Description AVPs. This provides an explicit coupling between each
	Media-Component-Description AVP, each pair of list elements in the Binding-Input-List AVP, and each pair of
	terminations in the BGF.
	AVP format:

	Binding-Input-List ::= < AVP Header: 451 13019>
		 *[ V6-Transport-Address ] ;
		 *[ V4-Transport-Address ]
*/
@DiameterAvpDefinition(code = 451L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Binding-Input-List")
public interface BindingInputList extends DiameterAvp
{
	List<V6TransportAddress> getV6TransportAddress();
	
	void setV6TransportAddress(List<V6TransportAddress> value);	
	
	List<V4TransportAddress> getV4TransportAddress();
	
	void setV4TransportAddress(List<V4TransportAddress> value);	
}