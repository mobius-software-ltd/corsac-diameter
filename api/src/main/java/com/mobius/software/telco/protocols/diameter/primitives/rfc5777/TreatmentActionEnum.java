package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;

import java.util.HashMap;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.primitives.IntegerEnum;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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
/**
*
* @author yulian oifa
*
*/

/*
 * 5.1.  Treatment-Action AVP

   The Treatment-Action AVP (AVP Code 572) is of type Enumerated and
   lists the actions that are associated with the condition part of a
   rule.  The following actions are defined in this document:

      0: drop
      1: shape
      2: mark
      3: permit

   drop:

      This action indicates that the respective traffic MUST be dropped.

   shape:

      [RFC2475] describes shaping as "the process of delaying packets
      within a traffic stream to cause it to conform to some defined
      traffic profile".  When the action is set to 'shape', the QoS-
      Parameters AVP SHALL contain QoS information AVPs, such as the
      TMOD-1 and Bandwidth AVPs [RFC5624], that indicate how to shape
      the traffic described by the condition part of the rule.
      
   mark:

      [RFC2475] describes marking as "the process of setting the DS
      codepoint in a packet based on defined rules".  When the action is
      set to 'mark', the QoS-Parameters AVP SHALL contain QoS
      information AVPs, such as the PHB-Class AVP [RFC5624], that
      indicate the Diffserv marking to be applied to the traffic
      described by the condition part of the rule.

   permit:

      The 'permit' action is the counterpart to the 'drop' action used
      to allow traffic that matches the condition part of a rule to
      bypass.

   [RFC2475] also describes an action called 'policing' as "the process
   of discarding packets (by a dropper) within a traffic stream in
   accordance with the state of a corresponding meter enforcing a
   traffic profile".  This behavior is modeled in the Filter-Rule
   through the inclusion of the Excess-Treatment AVP containing a
   Treatment-Action AVP set to 'drop'.

   Further action values can be registered, as described in
   Section 10.3.
 */
public enum TreatmentActionEnum implements IntegerEnum
{
	DROP(0),SHAPE(1),MARK(2),PERMIT(3);

	private static final Map<Integer, TreatmentActionEnum> intToTypeMap = new HashMap<Integer, TreatmentActionEnum>();
	static
	{
	    for (TreatmentActionEnum type : TreatmentActionEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static TreatmentActionEnum fromInt(Integer value) 
	{
		TreatmentActionEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private TreatmentActionEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
