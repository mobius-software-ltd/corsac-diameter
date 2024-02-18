package com.mobius.software.telco.protocols.diameter.impl.primitives.s6c;
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

import com.mobius.software.telco.protocols.diameter.primitives.s6c.AbsentUserDiagnosticSM;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.MSCSMDeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryCause;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryCauseEnum;

/**
*
* @author yulian oifa
*
*/
public class MSCSMDeliveryOutcomeImpl implements MSCSMDeliveryOutcome
{
	private SMDeliveryCause smDeliveryCause;
	
	private AbsentUserDiagnosticSM absentUserDiagnosticSM;
	
	public MSCSMDeliveryOutcomeImpl()
	{
	}
	
	public SMDeliveryCauseEnum getSMDeliveryCause()
	{
		if(smDeliveryCause==null)
			return null;
		
		return smDeliveryCause.getEnumerated(SMDeliveryCauseEnum.class);
	}
	
	public void setSMDeliveryCause(SMDeliveryCauseEnum value)
	{
		if(value==null)
			this.smDeliveryCause = null;
		else
			this.smDeliveryCause = new SMDeliveryCauseImpl(value, null, null);
	}
	
	public Long getAbsentUserDiagnosticSM()
	{
		if(absentUserDiagnosticSM==null)
			return null;
		
		return absentUserDiagnosticSM.getUnsigned();
	}
	
	public void setAbsentUserDiagnosticSM(Long value)
	{
		if(value==null)
			this.absentUserDiagnosticSM = null;
		else
			this.absentUserDiagnosticSM = new AbsentUserDiagnosticSMImpl(value, null, null);
	}
}