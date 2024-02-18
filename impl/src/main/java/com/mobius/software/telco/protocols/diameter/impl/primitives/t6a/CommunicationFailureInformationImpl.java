package com.mobius.software.telco.protocols.diameter.impl.primitives.t6a;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.BSSGPCause;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.CauseType;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.CauseTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.CommunicationFailureInformation;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.GMMCause;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.RANAPCause;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.S1APCause;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.SMCause;

/**
*
* @author yulian oifa
*
*/
public class CommunicationFailureInformationImpl extends DiameterGroupedAvpImpl implements CommunicationFailureInformation
{
	private CauseType causeType;
	
	private S1APCause s1APCause;
	
	private RANAPCause ranapCause;
	
	private BSSGPCause bssgpCause;
	
	private GMMCause gmmCause;
	
	private SMCause smCause;
	
	public CommunicationFailureInformationImpl()
	{
		
	}
	
	public CauseTypeEnum getCauseType()
	{
		if(causeType == null)
			return null;
		
		return causeType.getEnumerated(CauseTypeEnum.class);
	}
	
	public void setCauseType(CauseTypeEnum value)
	{
		if(value==null)
			this.causeType = null;
		else
			this.causeType = new CauseTypeImpl(value, null, null);						
	}
	
	public Long getS1APCause()
	{
		if(s1APCause == null)
			return null;
		
		return s1APCause.getUnsigned();
	}
	
	public void setS1APCause(Long value)
	{
		if(value==null)
			this.s1APCause = null;
		else
			this.s1APCause = new S1APCauseImpl(value, null, null);						
	}
	
	public Long getRANAPCause()
	{
		if(ranapCause == null)
			return null;
		
		return ranapCause.getUnsigned();
	}
	
	public void setRANAPCause(Long value)
	{
		if(value==null)
			this.ranapCause = null;
		else
			this.ranapCause = new RANAPCauseImpl(value, null, null);						
	}
	
	public Long getBSSGPCause()
	{
		if(bssgpCause == null)
			return null;
		
		return bssgpCause.getUnsigned();
	}
	
	public void setBSSGPCause(Long value)
	{
		if(value==null)
			this.bssgpCause = null;
		else
			this.bssgpCause = new BSSGPCauseImpl(value, null, null);						
	}
	
	public Long getGMMCause()
	{
		if(gmmCause == null)
			return null;
		
		return gmmCause.getUnsigned();
	}
	
	public void setGMMCause(Long value)
	{
		if(value==null)
			this.gmmCause = null;
		else
			this.gmmCause = new GMMCauseImpl(value, null, null);						
	}
	
	public Long getSMCause()
	{
		if(smCause == null)
			return null;
		
		return smCause.getUnsigned();
	}
	
	public void setSMCause(Long value)
	{
		if(value==null)
			this.smCause = null;
		else
			this.smCause = new SMCauseImpl(value, null, null);						
	}
}