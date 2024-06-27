package com.mobius.software.telco.protocols.diameter.impl.primitives.s15;

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
import java.util.List;
import io.netty.buffer.ByteBuf;


import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceResourceReport;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceQoSRequestIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceResourceResultOperation;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceResourceResultOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceResourceFailureCause;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceResourceFailureCauseEnum;

public class CSServiceResourceReportImpl extends DiameterAvpImpl implements CSServiceResourceReport
{
	private List<CSServiceQoSRequestIdentifier> csServiceQoSRequestIdentifier;
	private CSServiceResourceResultOperation csServiceResourceResultOperation;
	private CSServiceResourceFailureCause csServiceResourceFailureCause;

	public CSServiceResourceReportImpl()
	{
		
	}
	
	public List<ByteBuf> getCSServiceQoSRequestIdentifier()
	{
		if(csServiceQoSRequestIdentifier==null || csServiceQoSRequestIdentifier.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(CSServiceQoSRequestIdentifier curr:csServiceQoSRequestIdentifier)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setCSServiceQoSRequestIdentifier (List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.csServiceQoSRequestIdentifier = null;
		else
		{
			this.csServiceQoSRequestIdentifier = new ArrayList<CSServiceQoSRequestIdentifier>();
			for(ByteBuf curr:value)
				this.csServiceQoSRequestIdentifier.add(new CSServiceQoSRequestIdentifierImpl(curr, null, null));
		}
	
	
	}
	
	
	  public CSServiceResourceResultOperationEnum getCSServiceResourceResultOperation()
	{
		if(csServiceResourceResultOperation==null)
			return null;
		
		return csServiceResourceResultOperation.getEnumerated(CSServiceResourceResultOperationEnum.class);
	}
	
	
	public void setCSServiceResourceResultOperation(CSServiceResourceResultOperationEnum value)
	{
		if(value==null)
			this.csServiceResourceResultOperation = null;
		else
			this.csServiceResourceResultOperation = new CSServiceResourceResultOperationImpl(value, null, null);			
	}
	
	
	  public CSServiceResourceFailureCauseEnum getCSServiceResourceFailureCause()
	{
		if(csServiceResourceFailureCause==null)
			return null;
		
		return csServiceResourceFailureCause.getEnumerated(CSServiceResourceFailureCauseEnum.class);
	}
	
	
	public void setCSServiceResourceFailureCause(CSServiceResourceFailureCauseEnum value)
	{
		if(value==null)
			this.csServiceResourceFailureCause = null;
		else
			this.csServiceResourceFailureCause = new CSServiceResourceFailureCauseImpl(value, null, null);			
	}
	
    }
