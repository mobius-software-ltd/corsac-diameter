package com.mobius.software.telco.protocols.diameter.impl.commands.pc4a;

import java.util.List;

import com.mobius.software.telco.protocols.diameter.commands.pc4a.Pc4aRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.VendorSpecificRequestmpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
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
public abstract class Pc4aRequestImpl extends VendorSpecificRequestmpl implements Pc4aRequest
{
	protected DRMP drmp;
	
	protected List<SupportedFeatures> supportedFeatures;
	
	protected Pc4aRequestImpl() 
	{
		super();
		setDestinationHostAllowed(true);
	}
		
	public Pc4aRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessonID)
	{
		super(originHost, originRealm,destinationRealm, isRetransmit, sessonID);
		setDestinationHostAllowed(true);
		try 
		{
			setDestinationHost(destinationHost);
		}
		catch(AvpNotSupportedException ex) 
		{
			
		}
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
	public List<SupportedFeatures> getSupportedFeatures() 
	{
		return supportedFeatures;
	}

	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value) 
	{
		this.supportedFeatures = value;
	}
}