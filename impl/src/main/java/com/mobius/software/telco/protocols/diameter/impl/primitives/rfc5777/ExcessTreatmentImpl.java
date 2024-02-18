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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ExcessTreatment;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSParameters;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSProfileTemplate;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TreatmentAction;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TreatmentActionEnum;

/**
*
* @author yulian oifa
*
*/
public class ExcessTreatmentImpl extends DiameterGroupedAvpImpl implements ExcessTreatment
{
	private TreatmentAction treatmentAction;
	
	private QoSProfileTemplate qosProfileTemplate;
	
	private QoSParameters qoSParameters;
	
	protected ExcessTreatmentImpl()
	{
		
	}
	
	public ExcessTreatmentImpl(TreatmentActionEnum treatmentAction) throws MissingAvpException
	{
		setTreatmentAction(treatmentAction);
	}
	
	public TreatmentActionEnum getTreatmentAction()
	{
		if(treatmentAction == null)
			return null;
		
		return treatmentAction.getEnumerated(TreatmentActionEnum.class);
	}
	
	public void setTreatmentAction(TreatmentActionEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Treatment-Action is required", Arrays.asList(new DiameterAvp[] { new TreatmentActionImpl() }));
			
		this.treatmentAction = new TreatmentActionImpl(value, null, null);	
	}
	
	public QoSProfileTemplate getQoSProfileTemplate()
	{
		return qosProfileTemplate;
	}
	
	public void setQoSProfileTemplate(QoSProfileTemplate value)
	{
		this.qosProfileTemplate = value;
	}
	
	public QoSParameters getQoSParameters()
	{
		return qoSParameters;
	}
	
	public void setQoSParameters(QoSParameters value)
	{
		this.qoSParameters = value;
	}	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(treatmentAction==null)
			return new MissingAvpException("Treatment-Action is required", Arrays.asList(new DiameterAvp[] { new TreatmentActionImpl() }));
		
		return null;
	}
}