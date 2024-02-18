package com.mobius.software.telco.protocols.diameter.impl.primitives.s6t;
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
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPattern;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CommunicationPatternSet;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MTCProviderInfo;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDExt;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDForDeletion;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDForDeletionExt;

/**
*
* @author yulian oifa
*
*/
public class AESECommunicationPatternImpl extends DiameterGroupedAvpImpl implements AESECommunicationPattern
{
	private SCEFReferenceID scefReferenceID;
	private SCEFReferenceIDExt scefReferenceIDExt;
	private SCEFID scefID;
	private List<SCEFReferenceIDForDeletion> scefReferenceIDForDeletion;
	private List<SCEFReferenceIDForDeletionExt> scefReferenceIDForDeletionExt;
	private List<CommunicationPatternSet> communicationPatternSet;
	private MTCProviderInfo mtcProviderInfo;
	
	protected AESECommunicationPatternImpl()
	{
		
	}
	
	public AESECommunicationPatternImpl(String scefID) throws MissingAvpException
	{
		setSCEFID(scefID);
	}
	
	public Long getSCEFReferenceID()
	{
		if(scefReferenceID == null)
			return null;
		
		return scefReferenceID.getUnsigned();
	}
	
	public void setSCEFReferenceID(Long value)
	{
		if(value==null)
			this.scefReferenceID = null;
		else
			this.scefReferenceID = new SCEFReferenceIDImpl(value, null, null);						
	}
	
	public Long getSCEFReferenceIDExt()
	{
		if(scefReferenceIDExt == null)
			return null;
		
		return scefReferenceIDExt.getLong();
	}
	
	public void setSCEFReferenceIDExt(Long value)
	{
		if(value == null)
			this.scefReferenceIDExt = null;
		else
			this.scefReferenceIDExt = new SCEFReferenceIDExtImpl(value, null, null);
	}
	
	public String getSCEFID()
	{
		if(scefID == null)
			return null;
		
		return scefID.getIdentity();
	}
	
	public void setSCEFID(String value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("SCEF-ID is required", Arrays.asList(new DiameterAvp[] { new SCEFIDImpl() }));
		
		this.scefID = new SCEFIDImpl(value, null, null);
	}
	
	public List<Long> getSCEFReferenceIDForDeletion()
	{
		if(scefReferenceIDForDeletion == null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(SCEFReferenceIDForDeletion curr:scefReferenceIDForDeletion)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setSCEFReferenceIDForDeletion(List<Long> value)
	{
		if(value == null)
			this.scefReferenceIDForDeletion = null;
		else
		{
			this.scefReferenceIDForDeletion = new ArrayList<SCEFReferenceIDForDeletion>();
			for(Long curr:value)
				this.scefReferenceIDForDeletion.add(new SCEFReferenceIDForDeletionImpl(curr, null, null));			
		}
	}
	
	public List<Long> getSCEFReferenceIDForDeletionExt()
	{
		if(scefReferenceIDForDeletionExt == null)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(SCEFReferenceIDForDeletionExt curr:scefReferenceIDForDeletionExt)
			result.add(curr.getLong());
		
		return result;
	}
	
	public void setSCEFReferenceIDForDeletionExt(List<Long> value)
	{
		if(value == null)
			this.scefReferenceIDForDeletionExt = null;
		else
		{
			this.scefReferenceIDForDeletionExt = new ArrayList<SCEFReferenceIDForDeletionExt>();
			for(Long curr:value)
				this.scefReferenceIDForDeletionExt.add(new SCEFReferenceIDForDeletionExtImpl(curr, null, null));			
		}
	}
	
	public List<CommunicationPatternSet> getCommunicationPatternSet()
	{
		return this.communicationPatternSet;
	}
	
	public void setCommunicationPatternSet(List<CommunicationPatternSet> value)
	{
		this.communicationPatternSet = value;
	}
	
	public MTCProviderInfo getMTCProviderInfo()
	{
		return this.mtcProviderInfo;
	}
	
	public void setMTCProviderInfo(MTCProviderInfo value)
	{
		this.mtcProviderInfo = value;
	}
		
	@DiameterValidate
	public DiameterException validate()
	{
		if(scefID==null)
			return new MissingAvpException("SCEF-ID is required", Arrays.asList(new DiameterAvp[] { new SCEFIDImpl() }));
		
		return null;
	}
}