package com.mobius.software.telco.protocols.diameter.impl.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.FinalUnitActionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitAction;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ContentVersion;
import com.mobius.software.telco.protocols.diameter.primitives.rx.FlowNumber;
import com.mobius.software.telco.protocols.diameter.primitives.rx.Flows;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentNumber;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentStatus;
import com.mobius.software.telco.protocols.diameter.primitives.rx.MediaComponentStatusEnum;

/**
*
* @author yulian oifa
*
*/
public class FlowsImpl extends DiameterGroupedAvpImpl implements Flows
{
	private MediaComponentNumber mediaComponentNumber;
	
	private List<FlowNumber> flowNumber;
	
	private List<ContentVersion> contentVersion;
	
	private FinalUnitAction finalUnitAction;
	
	private MediaComponentStatus mediaComponentStatus;
	
	public FlowsImpl()
	{
		
	}
	
	public FlowsImpl(Long mediaComponentNumber) throws MissingAvpException
	{
		setMediaComponentNumber(mediaComponentNumber);
	}
	
	public Long getMediaComponentNumber()
	{
		if(mediaComponentNumber == null)
			return null;
		
		return mediaComponentNumber.getUnsigned();
	}
	
	public void setMediaComponentNumber(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Media-Component-Number is required", Arrays.asList(new DiameterAvp[] { new MediaComponentNumberImpl() }));
			
		this.mediaComponentNumber = new MediaComponentNumberImpl(value, null, null);	
	}
	
	public List<Long> getFlowNumber()
	{
		if(flowNumber == null || flowNumber.size()==0)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(FlowNumber curr:flowNumber)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setFlowNumber(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.flowNumber = null;
		else
		{
			this.flowNumber = new ArrayList<FlowNumber>();
			for(Long curr:value)
				this.flowNumber.add(new FlowNumberImpl(curr, null, null));
		}
	}
	
	public List<Long> getContentVersion()
	{
		if(contentVersion == null || contentVersion.size()==0)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(ContentVersion curr:contentVersion)
			result.add(curr.getLong());
		
		return result;
	}
	
	public void setContentVersion(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.contentVersion = null;
		else
		{
			this.contentVersion = new ArrayList<ContentVersion>();
			for(Long curr:value)
				this.contentVersion.add(new ContentVersionImpl(curr, null, null));
		}
	}
	
	public FinalUnitActionEnum getFinalUnitAction()
	{
		if(finalUnitAction == null)
			return null;
		
		return finalUnitAction.getEnumerated(FinalUnitActionEnum.class);
	}
	
	public void setFinalUnitAction(FinalUnitActionEnum value)
	{
		if(value==null)
			this.finalUnitAction = null;
		else
			this.finalUnitAction = new FinalUnitActionImpl(value, null, null);
	}					
	
	public MediaComponentStatusEnum getMediaComponentStatus()
	{
		if(mediaComponentStatus == null)
			return null;
		
		return mediaComponentStatus.getEnumerated(MediaComponentStatusEnum.class);
	}
	
	public void setMediaComponentStatus(MediaComponentStatusEnum value)
	{
		if(value==null)
			this.mediaComponentStatus = null;
		else
			this.mediaComponentStatus = new MediaComponentStatusImpl(value, null, null);
	}				
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(mediaComponentNumber==null)
			return new MissingAvpException("Media-Component-Number is required", Arrays.asList(new DiameterAvp[] { new MediaComponentNumberImpl() }));
		
		return null;
	}
}