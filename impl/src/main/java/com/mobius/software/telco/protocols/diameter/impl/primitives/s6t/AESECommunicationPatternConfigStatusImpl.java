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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPatternConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESEErrorReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceID;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFReferenceIDExt;

/**
*
* @author yulian oifa
*
*/
public class AESECommunicationPatternConfigStatusImpl extends DiameterGroupedAvpImpl implements AESECommunicationPatternConfigStatus
{
	private SCEFReferenceID scefReferenceID;
	private SCEFReferenceIDExt scefReferenceIDExt;
	private SCEFID scefID;
	private AESEErrorReport aesEErrorReport;
	
	protected AESECommunicationPatternConfigStatusImpl() 
	{
	}
	
	public AESECommunicationPatternConfigStatusImpl(Long scefReferenceID) throws MissingAvpException
	{
		setSCEFReferenceID(scefReferenceID);
	}
	
	public Long getSCEFReferenceID()
	{
		if(scefReferenceID == null)
			return null;
		
		return scefReferenceID.getUnsigned();
	}
	
	public void setSCEFReferenceID(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("SCEF-Reference-ID is required", Arrays.asList(new DiameterAvp[] { new SCEFReferenceIDImpl() }));
		
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
	
	public void setSCEFID(String value)
	{
		if(value == null)
			this.scefID = null;
		else
			this.scefID = new SCEFIDImpl(value, null, null);
	}	
	
	public AESEErrorReport getAESEErrorReport()
	{
		return aesEErrorReport;
	}
	
	public void setAESEErrorReport(AESEErrorReport value)
	{
		this.aesEErrorReport = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(scefReferenceID==null)
			return new MissingAvpException("SCEF-Reference-ID is required", Arrays.asList(new DiameterAvp[] { new SCEFReferenceIDImpl() }));
		
		return null;
	}	
}