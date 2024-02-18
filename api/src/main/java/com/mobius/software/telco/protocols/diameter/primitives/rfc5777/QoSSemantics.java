package com.mobius.software.telco.protocols.diameter.primitives.rfc5777;
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

import com.mobius.software.telco.protocols.diameter.AvpCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

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
@DiameterAvpDefinition(code = AvpCodes.QOS_SEMANTICS, vendorId = -1L, name = "QoS-Semantics")
public interface QoSSemantics extends DiameterEnumerated<QoSSemanticsEnum>
{
}