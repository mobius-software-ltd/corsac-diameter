package com.mobius.software.telco.protocols.diameter.primitives.creditcontrol;
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

/**
*
* @author yulian oifa
*
*/
/*
 * 
 * The Final-Unit-Indication AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

         Final-Unit-Indication ::= < AVP Header: 430 >
                                   { Final-Unit-Action }
                                  *[ Restriction-Filter-Rule ]
                                  *[ Filter-Id ]
                                   [ Redirect-Server ]
 *
 */
@DiameterAvpDefinition(code = 430L, vendorId = -1, name = "Final-Unit-Indication")
public interface FinalUnitIndication extends DiameterAvp 
{
	FinalUnitActionEnum getFinalUnitAction();
	
	void setFinalUnitAction(FinalUnitActionEnum finalUnitAction);
	
	List<RestrictionFilterRule> getRestrictionFilterRule();
	
	void setRestrictionFilterRule(List<RestrictionFilterRule> restrictionFilterRule);	
	
	List<String> getFilterId();
	
	void setFilterId(List<String> filterId);	
	
	RedirectServer getRedirectServer();
	
	void setRedirectServer(RedirectServer redirectServer);	
}