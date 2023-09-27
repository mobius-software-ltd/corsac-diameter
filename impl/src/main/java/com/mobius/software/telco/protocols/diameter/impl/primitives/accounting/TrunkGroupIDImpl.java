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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IncomingTrunkGroupID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OutgoingTrunkGroupID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TrunkGroupID;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 851L, vendorId = KnownVendorIDs.TGPP_ID)
public class TrunkGroupIDImpl implements TrunkGroupID
{
	private IncomingTrunkGroupID incomingTrunkGroupID;
	private OutgoingTrunkGroupID outgoingTrunkGroupID;
		
	public TrunkGroupIDImpl()
	{
		
	}
	
	public String getIncomingTrunkGroupID()
	{
		if(incomingTrunkGroupID==null)
			return null;
		
		return incomingTrunkGroupID.getString();
	}
	
	public void setIncomingTrunkGroupID(String value)
	{
		if(value==null)
			this.incomingTrunkGroupID = null;
		else
			this.incomingTrunkGroupID = new IncomingTrunkGroupIDImpl(value, null, null);			
	}
	
	public String getOutgoingTrunkGroupID()
	{
		if(outgoingTrunkGroupID==null)
			return null;
		
		return outgoingTrunkGroupID.getString();
	}
	
	public void setOutgoingTrunkGroupID(String value)
	{
		if(value==null)
			this.outgoingTrunkGroupID = null;
		else
			this.outgoingTrunkGroupID = new OutgoingTrunkGroupIDImpl(value, null, null);			
	}
}