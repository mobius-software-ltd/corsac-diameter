package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777;
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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSCapability;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSProfileTemplate;

/**
*
* @author yulian oifa
*
*/

public class QoSCapabilityImpl extends DiameterGroupedAvpImpl implements QoSCapability
{
	private List<QoSProfileTemplate> qoSProfileTemplate;
	
	protected QoSCapabilityImpl()
	{
		
	}
	
	public QoSCapabilityImpl(List<QoSProfileTemplate> qoSProfileTemplate) throws MissingAvpException
	{
		setQoSProfileTemplate(qoSProfileTemplate);
	}
	
	public List<QoSProfileTemplate> getQoSProfileTemplate()
	{
		return qoSProfileTemplate;
	}
	
	public void setQoSProfileTemplate(List<QoSProfileTemplate> value) throws MissingAvpException
	{
		if(qoSProfileTemplate == null || qoSProfileTemplate.size()==0)
			throw new MissingAvpException("QoS-Profile-Template is required is required", Arrays.asList(new DiameterAvp[] { new QoSProfileTemplateImpl() }));
		
		this.qoSProfileTemplate = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(qoSProfileTemplate == null || qoSProfileTemplate.size()==0)
			return new MissingAvpException("QoS-Profile-Template is required is required", Arrays.asList(new DiameterAvp[] { new QoSProfileTemplateImpl() }));
		
		return null;
	}	
}