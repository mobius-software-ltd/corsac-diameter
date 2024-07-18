package com.mobius.software.telco.protocols.diameter.primitives.gy;
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
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;

/*
 * 
 		4.2.3 Diameter Gy CCA – Final-Unit-Indication grouped AVP
	Grouped AVP format as defined in RFC 4006: Strikethrough formatted AVPs should not appear or are ignored in CCA.

         Final-Unit-Indication ::= < AVP Header: 430 >
                                   { Final-Unit-Action }
                                   [ Redirect-Server ]
 *
 */
@DiameterAvpDefinition(code = AvpCodes.FINAL_UNIT_INDICATION, vendorId = -1, name = "Final-Unit-Indication")
public interface FinalUnitIndication extends DiameterAvp 
{
	FinalUnitActionEnum getFinalUnitAction();
	
	void setFinalUnitAction(FinalUnitActionEnum finalUnitAction) throws MissingAvpException;
	
	RedirectServer getRedirectServer();
	
	void setRedirectServer(RedirectServer redirectServer);	
}