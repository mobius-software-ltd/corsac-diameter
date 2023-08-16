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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.Classifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ExcessTreatment;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.FilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.FilterRulePrecedence;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSParameters;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSProfileTemplate;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.QoSSemantics;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TimeOfDayCondition;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TreatmentAction;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TreatmentActionEnum;

/**
*
* @author yulian oifa
*
*/

@DiameterAvpDefinition(code = 509L, vendorId = -1L, name = "Filter-Rule")
public class FilterRuleImpl extends DiameterGroupedAvpImpl implements FilterRule
{
	private FilterRulePrecedence filterRulePrecedence;
	
	private Classifier classifier;
	
	private List<TimeOfDayCondition> timeOfDayCondition;
	
	private TreatmentAction treatmentAction;
	
	private QoSSemantics qosSemantics;
	
	private QoSProfileTemplate qosProfileTemplate;
	
	private QoSParameters qosParameters;
	
	private ExcessTreatment excessTreatment;
	
	public FilterRuleImpl()
	{
		
	}
	
	public Long getFilterRulePrecedence()
	{
		if(filterRulePrecedence == null)
			return null;
		
		return filterRulePrecedence.getUnsigned();
	}
	
	public void setFilterRulePrecedence(Long value)
	{
		if(value == null)
			this.filterRulePrecedence = null;
		else
			this.filterRulePrecedence = new FilterRulePrecedenceImpl(value, null, null);
	}
	
	public Classifier getClassifier()
	{
		return this.classifier;
	}
	
	public void setClassifier(Classifier value)
	{
		this.classifier = value;
	}
	
	public List<TimeOfDayCondition> getTimeOfDayCondition()
	{
		return this.timeOfDayCondition;
	}
	
	public void setTimeOfDayCondition(List<TimeOfDayCondition> value)
	{
		this.timeOfDayCondition = value;
	}
	
	public TreatmentActionEnum getTreatmentAction()
	{
		if(treatmentAction == null)
			return null;
		
		return treatmentAction.getEnumerated(TreatmentActionEnum.class);
	}
	
	public void setTreatmentAction(TreatmentActionEnum value)
	{
		if(value == null)
			this.treatmentAction = null;
		else
			this.treatmentAction = new TreatmentActionImpl(value, null, null);
	}
	
	public QoSSemantics getQoSSemantics()
	{
		return this.qosSemantics;
	}
	
	public void setQoSSemantics(QoSSemantics value)
	{
		this.qosSemantics = value;
	}
	
	public QoSProfileTemplate getQoSProfileTemplate()
	{
		return this.qosProfileTemplate;
	}
	
	public void seQoSProfileTemplate(QoSProfileTemplate value)
	{
		this.qosProfileTemplate = value;
	}
	
	public QoSParameters getQoSParameters()
	{
		return this.qosParameters;
	}
	
	public void setQoSParameters(QoSParameters value)
	{
		this.qosParameters = value;
	}
	
	public ExcessTreatment getExcessTreatment()
	{
		return this.excessTreatment;
	}
	
	public void setExcessTreatment(ExcessTreatment value)
	{
		this.excessTreatment = value;
	}
}