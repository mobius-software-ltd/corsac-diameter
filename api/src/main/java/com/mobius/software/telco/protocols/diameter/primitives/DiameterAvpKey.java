package com.mobius.software.telco.protocols.diameter.primitives;
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
/**
*
* @author yulian oifa
*
*/
public class DiameterAvpKey
{
	private Long vendorID;
	private Long avpID;
	
	public DiameterAvpKey(Long avpID) 
	{
		this.avpID = avpID;
	}

	public DiameterAvpKey(Long vendorID, Long avpID) 
	{
		this.vendorID = vendorID;
		this.avpID = avpID;
	}

	public Long getVendorID() 
	{
		return vendorID;
	}
	
	public void setVendorID(Long vendorID) 
	{
		this.vendorID = vendorID;
	}
	
	public Long getAvpID() 
	{
		return avpID;
	}
	
	public void setAvpID(Long avpID) 
	{
		this.avpID = avpID;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avpID == null) ? 0 : avpID.hashCode());
		result = prime * result + ((vendorID == null) ? 0 : vendorID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
	
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		DiameterAvpKey other = (DiameterAvpKey) obj;
		if (avpID == null) 
		{
			if (other.avpID != null)
				return false;
		}
		else if (!avpID.equals(other.avpID))
			return false;
		
		if (vendorID == null) 
		{
			if (other.vendorID != null)
				return false;
		} 
		else if (!vendorID.equals(other.vendorID))
			return false;
		
		return true;
	}	
}