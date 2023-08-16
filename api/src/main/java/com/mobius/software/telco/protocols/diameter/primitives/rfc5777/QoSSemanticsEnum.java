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
 * 5.4.  QoS-Semantics

   The QoS-Semantics AVP (AVP Code 575) is of type Enumerated and
   provides the semantics for the QoS-Profile-Template and QoS-
   Parameters AVPs in the Filter-Rule AVP.

   This document defines the following values:

    (0): QoS-Desired
    (1): QoS-Available
    (2): QoS-Delivered
    (3): Minimum-QoS
    (4): QoS-Authorized

   The semantics of the QoS parameters depend on the information
   provided in the list above.  The semantics of the different values
   are as follows:

   Object Type    Direction   Semantic
   ---------------------------------------------------------------------
   QoS-Desired     C->S       Client requests authorization of the
                              indicated QoS.
   QoS-Desired     C<-S       NA
   QoS-Available   C->S       Admission Control at client indicates
                              that this QoS is available. (note 1)
   QoS-Available   C<-S       Admission Control at server indicates
                              that this QoS is available. (note 2)
   QoS-Delivered   C->S       Client is reporting the actual QoS
                              delivered to the terminal.
   QoS-Delivered   C<-S       NA
   Minimum-QoS     C->S       Client is not interested in authorizing
                              QoS that is lower than the indicated QoS.
   Minimum-QoS     C<-S       Client must not provide QoS guarantees
                              lower than the indicated QoS.
   QoS-Authorized  C->S       NA
   QoS-Authorized  C<-S       Server authorizes the indicated QoS.

   Legend:

     C: Diameter client
     S: Diameter server
     NA: Not applicable to this document;
         no semantic defined in this specification
         
     Notes:

     (1) QoS-Available in this direction indicates to the server that
         any QoS-Authorized or Minimum-QoS must be less than this
         indicated QoS.

     (2) QoS-Available in this direction is only useful when the AAA
         server performs admission control and knows about the resources
         in the network.
 */
public enum QoSSemanticsEnum implements IntegerEnum
{
	QOS_DESIRED(0),QOS_AVAILABLE(1),QOS_DELIVERED(2),MINIMUM_QOS(4),QOS_AUTHORIZED(5);

	private static final Map<Integer, QoSSemanticsEnum> intToTypeMap = new HashMap<Integer, QoSSemanticsEnum>();
	static
	{
	    for (QoSSemanticsEnum type : QoSSemanticsEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static QoSSemanticsEnum fromInt(Integer value) 
	{
		QoSSemanticsEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private QoSSemanticsEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
