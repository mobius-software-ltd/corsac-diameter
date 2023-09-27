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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InterOperatorIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OriginatingIOI;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TerminatingIOI;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 838L, vendorId = KnownVendorIDs.TGPP_ID)
public class InterOperatorIdentifierImpl implements InterOperatorIdentifier
{
	private OriginatingIOI originatingIOI;
	private TerminatingIOI terminatingIOI;
			
	public InterOperatorIdentifierImpl()
	{
		
	}
	
	public String getOriginatingIOI()
	{
		if(originatingIOI==null)
			return null;
		
		return originatingIOI.getString();
	}
	
	public void setOriginatingIOI(String value)
	{
		if(value==null)
			this.originatingIOI = null;
		else
			this.originatingIOI = new OriginatingIOIImpl(value, null, null);			
	}
	
	public String getTerminatingIOI()
	{
		if(terminatingIOI==null)
			return null;
		
		return terminatingIOI.getString();
	}
	
	public void setTerminatingIOI(String value)
	{
		if(value==null)
			this.terminatingIOI = null;
		else
			this.terminatingIOI = new TerminatingIOIImpl(value, null, null);			
	}
}