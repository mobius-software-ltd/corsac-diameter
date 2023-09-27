package com.mobius.software.telco.protocols.diameter.primitives.accounting;

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
 * 	7.2.175 Reporting-Reason AVP
	The Reporting-Reason AVP (AVP code 872) is of type Enumerated and specifies the reason for usage reporting for one
	or more types of quota for a particular category. It can occur directly in the Multiple-Services-Credit-Control AVP, or
	in the Used-Service-Units AVP within a CCR command reporting credit usage. It shall not be used at command level. It
	shall always and shall only be sent when usage is being reported. The following values are defined for the ReportingReason AVP:

	0 THRESHOLD

	This value is used to indicate that the reason for usage reporting of the particular quota type indicated in the
	Used-Service-Units AVP where it appears is that the threshold has been reached.

	1 QHT

	This value is used to indicate that the reason for usage reporting of all quota types of the Multiple-ServiceCredit-Control AVP where its appears is that the quota holding time specified in a previous CCA command has
	been hit (i.e. the quota has been unused for that period of time).

	2 FINAL

	This value is used to indicate that the reason for usage reporting of all quota types of the Multiple-ServiceCredit-Control AVP where its appears is that a service termination has happened, e.g. PDP context, IP CAN
	bearer termination or service data flow termination.

	3 QUOTA_EXHAUSTED

	This value is used to indicate that the reason for usage reporting of the particular quota type indicated in the
	Used-Service-Units AVP where it appears is that the quota has been exhausted.

	4 VALIDITY_TIME
	
	This value is used to indicate that the reason for usage reporting of all quota types of the Multiple-ServiceCredit-Control AVP where its appears is that the credit authorization lifetime provided in the Validity-Time
	AVP has expired.

	5 OTHER_QUOTA_TYPE

	This value is used to indicate that the reason for usage reporting of the particular quota type indicated in the
	Used-Service-Units AVP where it appears is that, for a multi-dimensional quota, one reached a trigger condition
	and the other quota is being reported.

	6 RATING_CONDITION_CHANGE

	This value is used to indicate that the reason for usage reporting of all quota types of the Multiple-ServiceCredit-Control AVP where its appears is that a change has happened in some of the rating conditions that were
	previously armed (through the Trigger AVP, e.g. QoS, Radio Access Technology,…). The specific conditions
	that have changed are indicated in an associated Trigger AVP.

	7 FORCED_REAUTHORISATION
	
	This value is used to indicate that the reason for usage reporting of all quota types of the Multiple-ServiceCredit-Control AVP where its appears is that it is there has been a Server initiated re-authorization procedure,
	i.e. receipt of RAR command

	8 POOL_EXHAUSTED

	This value is used to indicate that the reason for usage reporting of the particular quota type indicated in the
	Used-Service-Units AVP where it appears is that granted units are still available in the pool but are not sufficient
	for a rating group using the pool.

	9 UNUSED_QUOTA_TIMER

	This value is used to indicate that the reason for usage reporting of all quota types of the Multiple-ServiceCredit-Control AVP where its appears is that the unused quota timer has expired. 

	The values QHT, FINAL, VALIDITY_TIME, FORCED_REAUTHORISATION, RATING_CONDITION_CHANGE,
	UNUSED_QUOTA_TIMER apply for all quota types and are used directly in the Multiple-Services-Credit-Control
	AVP, whereas the values THRESHOLD, QUOTA_EXHAUSTED and OTHER_QUOTA_TYPE apply to one
	particular quota type and shall occur only in the Used-Service-Units AVP. The value POOL_EXHAUSTED apply to all
	quota types using the credit pool and occurs in the Used-Service-Units AVP. It may optionally occur in the MultipleServices-Credit-Control AVP if all quota types use the same pool. 
 */
public enum ReportingReasonEnum implements IntegerEnum
{
	THRESHOLD(0),QHT(1),FINAL(2),QUOTA_EXHAUSTED(3),VALIDITY_TIME(4),OTHER_QUOTA_TYPE(5),RATING_CONDITION_CHANGE(6),FORCED_REAUTHORISATION(7),POOL_EXHAUSTED(8),UNUSED_QUOTA_TIMER(9);

	private static final Map<Integer, ReportingReasonEnum> intToTypeMap = new HashMap<Integer, ReportingReasonEnum>();
	static 
	{
	    for (ReportingReasonEnum type : ReportingReasonEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ReportingReasonEnum fromInt(Integer value) 
	{
		ReportingReasonEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ReportingReasonEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
