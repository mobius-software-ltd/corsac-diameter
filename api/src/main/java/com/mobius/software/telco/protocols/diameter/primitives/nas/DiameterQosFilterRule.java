package com.mobius.software.telco.protocols.diameter.primitives.nas;
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

import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterQosAction;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleAddress;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleDirection;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRulePorts;
import com.mobius.software.telco.protocols.diameter.primitives.InternetProtocol;

/**
*
* @author yulian oifa
*
*/

public interface DiameterQosFilterRule extends DiameterAvp 
{
	public String getRule();
	
	public DiameterQosAction getAction();

	public DiameterRuleDirection getDirection();

	public InternetProtocol getProtocol();

	public DiameterRuleAddress getFrom();

	public List<DiameterRulePorts> getFromPorts();

	public DiameterRuleAddress getTo();

	public List<DiameterRulePorts> getToPorts();

	public String getDscpColor();

	public Long getMeteringRate();

	public String getColorUnder();

	public String getColorOver();
}