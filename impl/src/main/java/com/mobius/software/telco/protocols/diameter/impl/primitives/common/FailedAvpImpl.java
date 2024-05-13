package com.mobius.software.telco.protocols.diameter.impl.primitives.common;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvpKey;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.FailedAvp;

/**
*
* @author yulian oifa
*
*/
public class FailedAvpImpl extends DiameterGroupedAvpImpl implements FailedAvp
{
	public Map<DiameterAvpKey,List<DiameterAvp>> knownAvps=new ConcurrentHashMap<DiameterAvpKey,List<DiameterAvp>>();
	
	public FailedAvpImpl() 
	{
		super();
	}
	
	@Override
	public Map<DiameterAvpKey, List<DiameterAvp>> getKnownAvps() 
	{
		return knownAvps;
	}

	@Override
	public List<DiameterAvp> getKnownAvps(DiameterAvpKey avpKey) 
	{
		return knownAvps.get(avpKey);
	}

	@Override
	public void addKnownAvp(DiameterAvpKey avpKey, DiameterAvp avp) 
	{
		List<DiameterAvp> currList = knownAvps.get(avpKey);
		if(currList==null)
		{
			currList=new ArrayList<DiameterAvp>();
			List<DiameterAvp> oldAvps=knownAvps.putIfAbsent(avpKey, currList);
			if(oldAvps!=null)
				currList = oldAvps;
		}
		
		currList.add(avp);
	}
	
	@Override
	public void setKnownAvps(Map<DiameterAvpKey,List<DiameterAvp>> avps)
	{
		this.knownAvps = avps;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		if(knownAvps!=null)
		{
			for(List<DiameterAvp> curr:knownAvps.values())
				result.addAll(curr);
		}
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}