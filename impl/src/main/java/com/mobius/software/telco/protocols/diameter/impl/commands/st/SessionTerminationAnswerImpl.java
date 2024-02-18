package com.mobius.software.telco.protocols.diameter.impl.commands.st;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.st.SessionTerminationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.AuthenticationAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

import io.netty.buffer.ByteBuf;

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
public class SessionTerminationAnswerImpl extends AuthenticationAnswerImpl implements SessionTerminationAnswer
{
	private DRMP drmp;
	
	protected List<DiameterClass> diameterClass;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	protected SessionTerminationAnswerImpl() 
	{
		super();
	}
	
	public SessionTerminationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
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
	public List<ByteBuf> getDiameterClass() 
	{
		if(this.diameterClass==null)
			return null;
		
		List<ByteBuf> result=new ArrayList<ByteBuf>();
		for(DiameterClass currClass: this.diameterClass)
			result.add(currClass.getValue());
		
		return result;
	}

	@Override
	public void setDiameterClass(List<ByteBuf> value) 
	{
		if(value==null || value.size()==0)
			this.diameterClass = null;
		else
		{
			this.diameterClass = new ArrayList<DiameterClass>();
			for(ByteBuf curr:value)
				this.diameterClass.add(new DiameterClassImpl(curr, null, null));
		}
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
	public List<Load> getLoad()
	{
		return this.load;
	}
	
	
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(originHost);
		result.add(originRealm);
		result.add(resultCode);
		result.add(errorMessage);
		result.add(errorReportingHost);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		result.add(failedAvp);
		result.add(originStateId);
		
		if(diameterClass!=null)
			result.addAll(diameterClass);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(load!=null)
			result.addAll(load);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}	
}