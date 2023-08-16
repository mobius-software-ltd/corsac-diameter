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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 4.1.8.18.  VLAN-ID-Range AVP

   The VLAN-ID-Range AVP (AVP Code 552) is of type Grouped and specifies
   the VLAN range to match.  VLAN identities are specified either by a
   single VLAN-ID according to [IEEE802.1Q] or by a combination of
   Customer and Service VLAN-IDs according to [IEEE802.1ad].

   The single VLAN-ID is represented by the C-VID-Start and C-VID-End
   AVPs, and the S-VID-Start and S-VID-End AVPs SHALL be omitted in this
   case.  If the VLAN-ID-Range AVP is omitted from the classifier, then
   comparison of the VLAN identity of the packet is irrelevant.

   VLAN-ID-Range ::= < AVP Header: 552 >
                     [ S-VID-Start ]
                     [ S-VID-End ]
                     [ C-VID-Start ]
                     [ C-VID-End ]
                   * [ AVP ]

   The following is the list of possible combinations of the S-VID-Start
   and S-VID-End AVPs and their inference:

   o  If S-VID-Start AVP is present but the S-VID-End AVP is absent, the
      S-VID-Start AVP value MUST equal the value of the IEEE 802.1ad
      S-VID bits specified in [IEEE802.1ad] for a successful match.

   o  If S-VID-Start AVP is absent but the S-VID-End AVP is present, the
      S-VID-End AVP value MUST equal the value of the IEEE 802.1ad S-VID
      bits for a successful match.

   o  If both S-VID-Start and S-VID-End AVPs are present and their
      values are equal, the S-VID-Start AVP value MUST equal the value
      of the IEEE 802.1ad S-VID bits for a successful match.

   o  If both S-VID-Start and S-VID-End AVPs are present and the value
      of S-VID-End AVP is greater than the value of the S-VID-Start AVP,
      the value of the IEEE 802.1ad S-VID bits MUST be greater than or
      equal to the S-VID-Start AVP value and less than or equal to the
      S-VID-End AVP value for a successful match.  If the S-VID-Start
      and S-VID-End AVPs are specified, then Ethernet packets without
      IEEE 802.1ad encapsulation MUST NOT match this classifier.

   o  If the S-VID-Start and S-VID-End AVPs are omitted, then existence
      of IEEE802.1ad encapsulation or comparison of the IEEE 802.1ad
      S-VID bits is irrelevant for this classifier.

   The following is the list of possible combinations of the C-VID-Start
   and C-VID-End AVPs and their inference:
   
      o  If C-VID-Start AVP is present but the C-VID-End AVP is absent, the
      C-VID-Start AVP value MUST equal the value of the IEEE 802.1ad
      C-VID bits specified in [IEEE802.1ad] or the IEEE 802.1Q VLAN-ID
      bits specified in [IEEE802.1Q] for a successful match.

   o  If C-VID-Start AVP is absent but the C-VID-End AVP is present, the
      C-VID-End AVP value MUST equal the value of the IEEE 802.1ad C-VID
      bits or the IEEE 802.1Q VLAN-ID bits for a successful match.

   o  If both C-VID-Start and C-VID-End AVPs are present and their
      values are equal, the C-VID-Start AVP value MUST equal the value
      of the IEEE 802.1ad C-VID bits or the IEEE 802.1Q VLAN-ID bits for
      a successful match.

   o  If both C-VID-Start and C-VID-End AVPs are present and the value
      of C-VID-End AVP is greater than the value of the C-VID-Start AVP,
      the value of the IEEE 802.1ad C-VID bits or the IEEE 802.1Q
      VLAN-ID bits MUST be greater than or equal to the C-VID-Start AVP
      value and less than or equal to the C-VID-End AVP value for a
      successful match.  If the C-VID-Start and C-VID-End AVPs are
      specified, then Ethernet packets without IEEE 802.1ad or IEEE
      802.1Q encapsulation MUST NOT match this classifier.

   o  If the C-VID-Start and C-VID-End AVPs are omitted, the comparison
      of the IEEE 802.1ad C-VID bits or IEEE 802.1Q VLAN-ID bits for
      this classifier is irrelevant.
 */
@DiameterAvpDefinition(code = 552L, vendorId = -1L, name = "VLAN-ID-Range")
public interface VLANIDRange extends DiameterGroupedAvp
{
	Long getSVIDStart();
	
	void setSVIDStart(Long value);	
	
	Long getSVIDEnd();
	
	void setSVIDEnd(Long value);
	
	Long getCVIDStart();
	
	void setCVIDStart(Long value);	
	
	Long getCVIDEnd();
	
	void setCVIDEnd(Long value);
}