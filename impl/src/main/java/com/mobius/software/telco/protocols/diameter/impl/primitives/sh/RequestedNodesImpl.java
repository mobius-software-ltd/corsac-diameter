package com.mobius.software.telco.protocols.diameter.impl.primitives.sh;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl;
import com.mobius.software.telco.protocols.diameter.primitives.sh.RequestedNodes;

/**
*
* @author yulian oifa
*
*/
public class RequestedNodesImpl extends DiameterBitmask32Impl implements RequestedNodes
{
	public RequestedNodesImpl() 
	{
		super();
	}
	
	public RequestedNodesImpl(Integer value) 
	{
		super(value);
	}

	@Override
	public void setMMEBit(boolean isOn)
	{
		setBitUnchecked(MME_BIT, isOn);
	}

	@Override
	public boolean isMMEBitSet()
	{
		return getBit(MME_BIT);				
	}

	@Override
	public void setSGSNBit(boolean isOn)
	{
		setBitUnchecked(SGSN_BIT, isOn);
	}

	@Override
	public boolean isSGSNBitSet()
	{
		return getBit(SGSN_BIT);
	}

	@Override
	public void set3GPPAAASERVERTWANBit(boolean isOn)
	{
		setBitUnchecked(TGPP_AAASERVER_TWAN_BIT, isOn);
	}

	@Override
	public boolean is3GPPAAASERVERTWANBitSet()
	{
		return getBit(TGPP_AAASERVER_TWAN_BIT);
	}

	@Override
	public void setAMFBit(boolean isOn)
	{
		setBitUnchecked(AMF_BIT, isOn);
	}

	@Override
	public boolean isAMFBitSet()
	{
		return getBit(AMF_BIT);
	}
}