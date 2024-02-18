package com.mobius.software.telco.protocols.diameter.impl.commands.s7a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s7a.UpdateVCSGLocationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SGSNNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.UVRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SGSNNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UVRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;

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
public class UpdateVCSGLocationRequestImpl extends S7aRequestImpl implements UpdateVCSGLocationRequest
{
	private MSISDN msisdn;
	
	private SGSNNumber sgsnNumber;
	
	private UVRFlags uvrFlags;
	
	protected UpdateVCSGLocationRequestImpl() 
	{
		super();
	}
	
	public UpdateVCSGLocationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UVRFlags uvrFlags) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUVRFlags(uvrFlags);
	}
	
	@Override
	public String getMSISDN()
	{
		if(msisdn == null)
			return null;
		
		return msisdn.getAddress();
	}
	 
	@Override
	public void setMSISDN(String value)
	{
		if(value == null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);
	}
		
	@Override
	public String getSGSNNumber()
	{
		if(sgsnNumber == null)
			return null;
		
		return sgsnNumber.getAddress();
	}
	
	@Override
	public void setSGSNNumber(String value)
	{
		if(value == null)
			this.sgsnNumber = null;
		else
			this.sgsnNumber = new SGSNNumberImpl(value);
	}	
	
	@Override
	public UVRFlags getUVRFlags()
	{
		return uvrFlags;
	}
	
	@Override
	public void setUVRFlags(UVRFlags value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("ULR-Flags is required is required", Arrays.asList(new DiameterAvp[] { new UVRFlagsImpl() }));
		
		this.uvrFlags = value;
	}				
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(uvrFlags == null)
			return new MissingAvpException("ULR-Flags is required is required", Arrays.asList(new DiameterAvp[] { new UVRFlagsImpl() }));
		
		return super.validate();
	}		
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(username);
		result.add(msisdn);
		result.add(sgsnNumber);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(uvrFlags);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}	
}