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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.1 Binding-information AVP
	The Binding-Information AVP (AVP code 450) is of type Grouped and is sent between the AF and the SPDF in order to
	convey binding information required for NA(P)T, hosted NA(P)T and NA(P)T-PT control.
	AVP format:

	Binding-information ::= < AVP Header: 450 13019>
		 { Binding-Input-List } ;
		 [ Binding-Output-List ]
*/
@DiameterAvpDefinition(code = 450L, vendorId = KnownVendorIDs.TGPP_ID, must = false, name = "Binding-Information")
public interface BindingInformation extends DiameterAvp
{
	BindingInputList getBindingInputList();
	
	void setBindingInputList(BindingInputList value);	
	
	BindingOutputList getBindingOutputList();
	
	void setBindingOutputList(BindingOutputList value);	
}