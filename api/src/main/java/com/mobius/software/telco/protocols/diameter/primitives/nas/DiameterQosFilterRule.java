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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
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
/*
 * 4.1.1.  QoSFilterRule

   The QosFilterRule format is derived from the OctetString AVP Base
   Format.  It uses the US-ASCII charset.  Packets may be marked or
   metered based on the following information:

   o  Direction (in or out)

   o  Source and destination IP address (possibly masked)

   o  Protocol

   o  Source and destination port (lists or ranges)

   o  Differentiated Services Code Point (DSCP) values (no mask or
      range)

   Rules for the appropriate direction are evaluated in order; the first
   matched rule terminates the evaluation.  Each packet is evaluated
   once.  If no rule matches, the packet is treated as best effort.  An
   access device unable to interpret or apply a QoS rule SHOULD NOT
   terminate the session.
   
   QoSFilterRule filters MUST follow the following format:

      action dir proto from src to dst [options]

      where

      action

                  tag  Mark packet with a specific DSCP [RFC2474]

                  meter  Meter traffic


      dir         The format is as described under IPFilterRule
                  [RFC6733]


      proto       The format is as described under IPFilterRule
                  [RFC6733]


      src and dst The format is as described under IPFilterRule
                  [RFC6733]


   The options are described in Section 4.4.9.

   The rule syntax is a modified subset of ipfw(8) from FreeBSD, and the
   ipfw.c code may provide a useful base for implementations.
*/
/*
   4.4.9.  QoS-Filter-Rule AVP

   The QoS-Filter-Rule AVP (AVP Code 407) is of type QoSFilterRule
   (Section 4.1.1) and provides QoS filter rules that need to be
   configured on the NAS for the user.  One or more such AVPs MAY be
   present in an authorization response.

   The use of this AVP is NOT RECOMMENDED; the AVPs defined by [RFC5777]
   SHOULD be used instead.

   The following options are defined for the QoSFilterRule filters:
   
   DSCP <color>

         If action is set to tag (Section 4.1.1), this option MUST be
         included in the rule.

         Color values are defined in [RFC2474].  Exact matching of DSCP
         values is required (no masks or ranges).

   metering <rate> <color_under> <color_over>

         The metering option provides Assured Forwarding, as defined in
         [RFC2597].  and MUST be present if the action is set to meter
         (Section 4.1.1) The rate option is the throughput, in bits per
         second, used by the access device to mark packets.  Traffic
         over the rate is marked with the color_over codepoint, and
         traffic under the rate is marked with the color_under
         codepoint.  The color_under and color_over options contain the
         drop preferences and MUST conform to the recommended codepoint
         keywords described in [RFC2597] (e.g., AF13).

         The metering option also supports the strict limit on traffic
         required by Expedited Forwarding, as defined in [RFC3246].  The
         color_over option may contain the keyword "drop" to prevent
         forwarding of traffic that exceeds the rate parameter.
 */
@DiameterAvpDefinition(code = 407L, vendorId = -1L, name = "QoS-Filter-Rule")
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