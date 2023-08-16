package com.mobius.software.telco.protocols.diameter.primitives.common;

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
 * 9.8.1.  Accounting-Record-Type AVP

   The Accounting-Record-Type AVP (AVP Code 480) is of type Enumerated
   and contains the type of accounting record being sent.  The following
   values are currently defined for the Accounting-Record-Type AVP:

   EVENT_RECORD 1

      An Accounting Event Record is used to indicate that a one-time
      event has occurred (meaning that the start and end of the event
      are simultaneous).  This record contains all information relevant
      to the service, and it is the only record of the service.
      
   START_RECORD 2

      Accounting Start, Interim, and Stop Records are used to indicate
      that a service of a measurable length has been given.  An
      Accounting Start Record is used to initiate an accounting session
      and contains accounting information that is relevant to the
      initiation of the session.

   INTERIM_RECORD 3

      An Interim Accounting Record contains cumulative accounting
      information for an existing accounting session.  Interim
      Accounting Records SHOULD be sent every time a re-authentication
      or re-authorization occurs.  Further, additional interim record
      triggers MAY be defined by application-specific Diameter
      applications.  The selection of whether to use INTERIM_RECORD
      records is done by the Acct-Interim-Interval AVP.

   STOP_RECORD 4

      An Accounting Stop Record is sent to terminate an accounting
      session and contains cumulative accounting information relevant to
      the existing session.
 */
public enum AccountingRecordTypeEnum implements IntegerEnum
{
	EVENT_RECORD(1),START_RECORD(2),INTERIM_RECORD(3),STOP_RECORD(4);

	private static final Map<Integer, AccountingRecordTypeEnum> intToTypeMap = new HashMap<Integer, AccountingRecordTypeEnum>();
	static 
	{
	    for (AccountingRecordTypeEnum type : AccountingRecordTypeEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static AccountingRecordTypeEnum fromInt(Integer value) 
	{
		AccountingRecordTypeEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private AccountingRecordTypeEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
