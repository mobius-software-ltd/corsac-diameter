package com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.creditcontrol.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcSubSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.GSUPoolIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RatingGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
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
@DiameterCommandImplementation(applicationId = 4, commandCode = 258, request = false)
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
	
	public ReAuthAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID)
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
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(ccSubSessionId==null)
			return null;
		
		return ccSubSessionId.getLong();
	}
	
	public void setCCSubSessionId(Long value) throws AvpNotSupportedException
	{
		if(!ccSubSessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value==null)
			this.ccSubSessionId = null;
		else
			this.ccSubSessionId = new CcSubSessionIdImpl(value, null, null);
	}
	
	public Long getGSUPoolIdentifier() throws AvpNotSupportedException
	{
		if(!gsuPoolIdentifierAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(gsuPoolIdentifier==null)
			return null;
		
		return gsuPoolIdentifier.getUnsigned();
	}
	
	public void setGSUPoolIdentifier(Long value) throws AvpNotSupportedException
	{
		if(!gsuPoolIdentifierAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value==null)
			this.gsuPoolIdentifier = null;
		else
			this.gsuPoolIdentifier = new GSUPoolIdentifierImpl(value, null, null);
	}
	
	public Long getServiceIdentifier() throws AvpNotSupportedException
	{
		if(!serviceIdentifierAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(serviceIdentifier==null)
			return null;
		
		return serviceIdentifier.getUnsigned();
	}
	
	public void setServiceIdentifier(Long value) throws AvpNotSupportedException
	{
		if(!serviceIdentifierAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value==null)
			this.serviceIdentifier = null;
		else
			this.serviceIdentifier = new ServiceIdentifierImpl(value, null, null);
	}

	public Long getRatingGroup() throws AvpNotSupportedException
	{
		if(!ratingGroupAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(ratingGroup==null)
			return null;
		
		return ratingGroup.getUnsigned();
	}
	
	public void setRatingGroup(Long value) throws AvpNotSupportedException
	{
		if(!ratingGroupAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(value==null)
			this.ratingGroup = null;
		else
			this.ratingGroup = new RatingGroupImpl(value, null, null);
	}
}	