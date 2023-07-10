package com.mobius.software.telco.protocols.diameter.impl.primitives;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvpKey;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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
public abstract class DiameterGroupedAvpImpl implements DiameterGroupedAvp
{
	public Map<DiameterAvpKey,List<DiameterAvp>> optionalAvps=new ConcurrentHashMap<DiameterAvpKey,List<DiameterAvp>>();
	
	protected DiameterGroupedAvpImpl() 
	{
	}
	
	@Override
	public Map<DiameterAvpKey, List<DiameterAvp>> getOptionalAvps() 
	{
		return optionalAvps;
	}

	@Override
	public List<DiameterAvp> getOptionalAvps(DiameterAvpKey avpKey) 
	{
		return optionalAvps.get(avpKey);
	}

	@Override
	public void addOptionalAvp(DiameterAvpKey avpKey, DiameterAvp avp) 
	{
		List<DiameterAvp> currList = optionalAvps.get(avpKey);
		if(currList==null)
		{
			currList=new ArrayList<DiameterAvp>();
			List<DiameterAvp> oldAvps=optionalAvps.putIfAbsent(avpKey, currList);
			if(oldAvps!=null)
				currList = oldAvps;
		}
		
		currList.add(avp);
	}
	
	@Override
	public void setOptionalAvps(Map<DiameterAvpKey,List<DiameterAvp>> avps)
	{
		this.optionalAvps = avps;
	}
}