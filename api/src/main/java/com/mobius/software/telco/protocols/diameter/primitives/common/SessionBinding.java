package com.mobius.software.telco.protocols.diameter.primitives.common;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;

/**
*
* @author yulian oifa
*
*/
/*
 * 8.17.  Session-Binding AVP

   The Session-Binding AVP (AVP Code 270) is of type Unsigned32, and it
   MAY be present in application-specific authorization answer messages.
   If present, this AVP MAY inform the Diameter client that all future
   application-specific re-auth and Session-Termination-Request messages
   for this session MUST be sent to the same authorization server.
   
   This field is a bit mask, and the following bits have been defined:

   RE_AUTH 1

      When set, future re-auth messages for this session MUST NOT
      include the Destination-Host AVP.  When cleared, the default
      value, the Destination-Host AVP MUST be present in all re-auth
      messages for this session.

   STR 2

      When set, the STR message for this session MUST NOT include the
      Destination-Host AVP.  When cleared, the default value, the
      Destination-Host AVP MUST be present in the STR message for this
      session.

   ACCOUNTING 4

      When set, all accounting messages for this session MUST NOT
      include the Destination-Host AVP.  When cleared, the default
      value, the Destination-Host AVP, if known, MUST be present in all
      accounting messages for this session.   
*/
@DiameterAvpDefinition(code = AvpCodes.SESSION_BINDING, vendorId = -1L, name = "Session-Binding")
public interface SessionBinding extends DiameterBitmask32
{
	public static final Integer RE_AUTH_BIT = 0;
	public static final Integer STR_BIT = 1;
	public static final Integer ACCOUNTING_BIT = 2;	
	
	public void setReauthBit(boolean isOn);
	
	public boolean isReauthBitSet();
	
	public void setSTRBit(boolean isOn);
	
	public boolean isSTRBitSet();
	
	public void setAccountingBit(boolean isOn);
	
	public boolean isAccountingBitSet();
}