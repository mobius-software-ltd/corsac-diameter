package com.mobius.software.telco.protocols.diameter.primitives.rfc5624;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * 3.1.  TMOD-1 AVP

   The TMOD-1 AVP is obtained from [RFC2210] and [RFC2215].  The
   structure of the AVP is as follows:

     TMOD-1  ::= < AVP Header: 495 >
                 { Token-Rate }
                 { Bucket-Depth }
                 { Peak-Traffic-Rate }
                 { Minimum-Policed-Unit }
                 { Maximum-Packet-Size }
 */
@DiameterAvpDefinition(code = 495L, vendorId = -1L, name = "TMOD-1")
public interface TMOD1 extends DiameterAvp
{
	Float getTokenRate();
	
	void setTokenRate(Float value);	
	
	Float getBucketDepth();
	
	void setBucketDepth(Float value);
	
	Float getPeakTrafficRate();
	
	void setPeakTrafficRate(Float value);
	
	Long getMinimumPolicedUnit();
	
	void setMinimumPolicedUnit(Long value);	
	
	Long getMaximumPacketSize();	
	
	void setMaximumPacketSize(Long value);	
}