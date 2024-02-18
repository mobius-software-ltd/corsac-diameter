package com.mobius.software.telco.protocols.diameter.impl.primitives.gxx;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PrecedenceImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ContentVersionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.RequiredAccessInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SharingKeyDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SharingKeyULImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gx.FlowInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.Precedence;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleName;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ContentVersion;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rx.RequiredAccessInfoEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SharingKeyDL;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SharingKeyUL;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class QoSRuleDefinitionImpl extends DiameterGroupedAvpImpl implements QoSRuleDefinition
{
	private QoSRuleName qosRuleName;
	private List<FlowInformation> flowInformation;
	private QoSInformation qoSInformation;
	private Precedence precedence;
	private List<RequiredAccessInfo> requiredAccessInfo;
	private SharingKeyDL sharingKeyDL;
	private SharingKeyUL sharingKeyUL;
	private ContentVersion contentVersion;
		
	protected QoSRuleDefinitionImpl()
	{
		
	}
	
	public QoSRuleDefinitionImpl(ByteBuf qosRuleName) throws MissingAvpException
	{
		setQoSRuleName(qosRuleName);
	}
	
	public ByteBuf getQoSRuleName()
	{
		if(qosRuleName==null)
			return null;
		
		return qosRuleName.getValue();
	}
	
	public void setQoSRuleName(ByteBuf value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("QoS-Rule-Name is required is required", Arrays.asList(new DiameterAvp[] { new QoSRuleNameImpl() }));
		
		this.qosRuleName = new QoSRuleNameImpl(value, null, null);				
	}
	
	public List<FlowInformation> getFlowInformation()
	{
		return flowInformation;
	}
	
	public void setFlowInformation(List<FlowInformation> value)
	{
		this.flowInformation = value;
	}	
	
	public QoSInformation getQoSInformation()
	{
		return qoSInformation;
	}
	
	public void setQoSInformation(QoSInformation value)
	{
		this.qoSInformation = value;
	}	
	
	public Long getPrecedence()
	{
		if(precedence==null)
			return null;
		
		return precedence.getUnsigned();
	}
	
	public void setPrecedence(Long value)
	{
		if(value==null)
			this.precedence = null;
		else
			this.precedence = new PrecedenceImpl(value, null, null);			
	}
	
	public List<RequiredAccessInfoEnum> getRequiredAccessInfo()
	{
		if(requiredAccessInfo==null || requiredAccessInfo.size()==0)
			return null;
		
		List<RequiredAccessInfoEnum> result=new ArrayList<RequiredAccessInfoEnum>();
		for(RequiredAccessInfo curr:requiredAccessInfo)
			result.add(curr.getEnumerated(RequiredAccessInfoEnum.class));
		
		return result;
	}
	
	public void setRequiredAccessInfo(List<RequiredAccessInfoEnum> value)
	{
		if(value==null || value.size()==0)
			this.requiredAccessInfo = new ArrayList<RequiredAccessInfo>();
		else
		{
			this.requiredAccessInfo = new ArrayList<RequiredAccessInfo>();
			for(RequiredAccessInfoEnum curr:value)
				this.requiredAccessInfo.add(new RequiredAccessInfoImpl(curr, null, null));
		}
	}
	
	public Long getSharingKeyDL()
	{
		if(sharingKeyDL==null)
			return null;
		
		return sharingKeyDL.getUnsigned();
	}
	
	public void setSharingKeyDL(Long value)
	{
		if(value==null)
			this.sharingKeyDL = null;
		else
			this.sharingKeyDL = new SharingKeyDLImpl(value, null, null);			
	}
	
	public Long getSharingKeyUL()
	{
		if(sharingKeyUL==null)
			return null;
		
		return sharingKeyUL.getUnsigned();
	}
	
	public void setSharingKeyUL(Long value)
	{
		if(value==null)
			this.sharingKeyUL = null;
		else
			this.sharingKeyUL = new SharingKeyULImpl(value, null, null);			
	}
	
	public Long getContentVersion()
	{
		if(contentVersion==null)
			return null;
		
		return contentVersion.getLong();
	}
	
	public void setContentVersion(Long value)
	{
		if(value==null)
			this.contentVersion = null;
		else
			this.contentVersion = new ContentVersionImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(qosRuleName==null)
			return new MissingAvpException("QoS-Rule-Name is required is required", Arrays.asList(new DiameterAvp[] { new QoSRuleNameImpl() }));
		
		return null;
	}		  
}