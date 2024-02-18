package com.mobius.software.telco.protocols.diameter.impl.commands.st;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.commands.st.StAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.VendorSpecificAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.RouteRecordImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.RouteRecord;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

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
public abstract class StAnswerImpl extends VendorSpecificAnswerImpl implements StAnswer
{
	protected DRMP drmp;
	
	protected OCSupportedFeatures ocSupportedFeatures;
	
	protected OCOLR ocOLR;
	
	protected List<RouteRecord> routeRecords;
	
	protected StAnswerImpl() 
	{
		super();
	}
	
	public StAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
	}

	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
	}

	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
	}
	
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	
	@Override
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
	}

	@Override
	public List<String> getRouteRecords() 
	{
		if(this.routeRecords==null)
			return null;
		else
		{
			List<String> result = new ArrayList<String>();
			for(RouteRecord curr:routeRecords)
				result.add(curr.getIdentity());
			
			return result;
		}
	}

	@Override
	public void setRouteRecords(List<String> value)
	{
		if(value == null || value.size()==0)
			this.routeRecords = null;
		else
		{
			this.routeRecords = new ArrayList<RouteRecord>();
			for(String curr:value)
				this.routeRecords.add(new RouteRecordImpl(curr, null, null));
		}
	}
}