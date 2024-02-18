package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSubSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GSUPoolIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RatingGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcSubSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.GSUPoolIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RatingGroup;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;

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
public class ReAuthAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthAnswerImpl implements ReAuthAnswer
{
	private CcSubSessionId ccSubSessionId;
	
	private GSUPoolIdentifier gsuPoolIdentifier;
	
	private ServiceIdentifier serviceIdentifier;
	
	private RatingGroup ratingGroup;
	
	private boolean ccSubSessionIdAllowed = true;
	private boolean gsuPoolIdentifierAllowed = true;
	private boolean serviceIdentifierAllowed = true;
	private boolean ratingGroupAllowed = true;
	
	protected ReAuthAnswerImpl() 
	{
	}
	
	public ReAuthAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
	}
	
	protected void setCCSubSessionIdAllowed(boolean allowed) 
	{
		this.ccSubSessionIdAllowed = allowed;
	}
	
	protected void setGSUPoolIdentifierAllowed(boolean allowed) 
	{
		this.gsuPoolIdentifierAllowed = allowed;
	}
	
	protected void setServiceIdentifierAllowed(boolean allowed) 
	{
		this.serviceIdentifierAllowed = allowed;
	}
	
	protected void setRatingGroupAllowed(boolean allowed) 
	{
		this.ratingGroupAllowed = allowed;
	}
	
	public Long getCCSubSessionId() throws AvpNotSupportedException
	{
		if(!ccSubSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new CcSubSessionIdImpl() } ));
		
		if(ccSubSessionId==null)
			return null;
		
		return ccSubSessionId.getLong();
	}
	
	public void setCCSubSessionId(Long value) throws AvpNotSupportedException
	{
		if(!ccSubSessionIdAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new CcSubSessionIdImpl(value, null, null) } ));
		
		if(value==null)
			this.ccSubSessionId = null;
		else
			this.ccSubSessionId = new CcSubSessionIdImpl(value, null, null);
	}
	
	public Long getGSUPoolIdentifier() throws AvpNotSupportedException
	{
		if(!gsuPoolIdentifierAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new GSUPoolIdentifierImpl() } ));
		
		if(gsuPoolIdentifier==null)
			return null;
		
		return gsuPoolIdentifier.getUnsigned();
	}
	
	public void setGSUPoolIdentifier(Long value) throws AvpNotSupportedException
	{
		if(!gsuPoolIdentifierAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new GSUPoolIdentifierImpl(value, null, null) } ));
		
		if(value==null)
			this.gsuPoolIdentifier = null;
		else
			this.gsuPoolIdentifier = new GSUPoolIdentifierImpl(value, null, null);
	}
	
	public Long getServiceIdentifier() throws AvpNotSupportedException
	{
		if(!serviceIdentifierAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new ServiceIdentifierImpl() } ));
		
		if(serviceIdentifier==null)
			return null;
		
		return serviceIdentifier.getUnsigned();
	}
	
	public void setServiceIdentifier(Long value) throws AvpNotSupportedException
	{
		if(!serviceIdentifierAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new ServiceIdentifierImpl(value, null, null) } ));
		
		if(value==null)
			this.serviceIdentifier = null;
		else
			this.serviceIdentifier = new ServiceIdentifierImpl(value, null, null);
	}

	public Long getRatingGroup() throws AvpNotSupportedException
	{
		if(!ratingGroupAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new RatingGroupImpl() } ));
		
		if(ratingGroup==null)
			return null;
		
		return ratingGroup.getUnsigned();
	}
	
	public void setRatingGroup(Long value) throws AvpNotSupportedException
	{
		if(!ratingGroupAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new RatingGroupImpl(value, null, null) }));
		
		if(value==null)
			this.ratingGroup = null;
		else
			this.ratingGroup = new RatingGroupImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(!ccSubSessionIdAllowed && ccSubSessionId!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { ccSubSessionId } ));
		
		if(!gsuPoolIdentifierAllowed && gsuPoolIdentifier!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { gsuPoolIdentifier } ));
		
		if(!serviceIdentifierAllowed && serviceIdentifier!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { serviceIdentifier } ));
		
		if(!ratingGroupAllowed && ratingGroup!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { ratingGroup }));
		
		return super.validate();
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(resultCode);
		result.add(originHost);
		result.add(originRealm);
		result.add(username);
		result.add(originStateId);
		result.add(errorMessage);
		result.add(errorReportingHost);
		result.add(failedAvp);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		result.add(ccSubSessionId);
		result.add(gsuPoolIdentifier);
		result.add(serviceIdentifier);
		result.add(ratingGroup);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}	