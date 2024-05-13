package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.SCEFIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CPDTInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NIDDSubmission;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SGWChange;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SGWChangeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServingNodeIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SCEFID;

/**
*
* @author yulian oifa
*
*/
public class CPDTInformationImpl extends DiameterAvpImpl implements CPDTInformation
{
	private ExternalIdentifier externalIdentifier;
	private SCEFID scefID;
	private ServingNodeIdentity servingNodeIdentity; 
	private SGWChange sgwChange;
	private NIDDSubmission niddSubmission;
		
	public CPDTInformationImpl()
	{
		
	}
	
	public String getExternalIdentifier()
	{
		if(externalIdentifier==null)
			return null;
		
		return externalIdentifier.getString();
	}
	
	public void setExternalIdentifier(String value)
	{
		if(value==null)
			this.externalIdentifier = null;
		else
			this.externalIdentifier = new ExternalIdentifierImpl(value, null, null);			
	}
	
	public String getSCEFID()
	{
		if(scefID==null)
			return null;
		
		return scefID.getIdentity();
	}
	
	public void setSCEFID(String value)
	{
		if(value==null)
			this.scefID = null;
		else
			this.scefID = new SCEFIDImpl(value, null, null);			
	}
	
	public String getServingNodeIdentity()
	{
		if(servingNodeIdentity==null)
			return null;
		
		return servingNodeIdentity.getString();
	}
	
	public void setServingNodeIdentity(String value)
	{
		if(value==null)
			this.servingNodeIdentity = null;
		else
			this.servingNodeIdentity = new ServingNodeIdentityImpl(value, null, null);			
	}
	
	public SGWChangeEnum getSGWChange()
	{
		if(sgwChange==null)
			return null;
		
		return sgwChange.getEnumerated(SGWChangeEnum.class);
	}
	
	public void setSGWChange(SGWChangeEnum value)
	{
		if(value==null)
			this.sgwChange = null;
		else
			this.sgwChange = new SGWChangeImpl(value, null, null);			
	}
	
	public NIDDSubmission getNIDDSubmission()
	{
		return niddSubmission;
	}
	
	public void setNIDDSubmission(NIDDSubmission value)
	{
		this.niddSubmission = value;
	}
}