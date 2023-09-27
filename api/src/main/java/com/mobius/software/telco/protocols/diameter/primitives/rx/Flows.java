package com.mobius.software.telco.protocols.diameter.primitives.rx;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;

/**
*
* @author yulian oifa
*
*/

/*
 *	5.3.10	Flows AVP
	The Flows AVP (AVP code 510) is of type Grouped, and it indicates IP flows via their flow identifiers.
	When reporting an out of credit condition, the Final-Unit-Action AVP indicates the termination action applied to the impacted flows.
	If no Flow-Number AVP(s) are supplied, the Flows AVP refers to all Flows matching the media component number.
	When reporting a resource allocation failure related to the modification of session information, the Media-Component-Status AVP may be included to report the status of the PCC/QoS rules related to the media component.
	The Content-Version AVP(s) shall be included if it was included in the Media-Component-Description AVP when the corresponding media component was provisioned.
	AVP Format:
		
			Flows::= < AVP Header: 510 >
	       		 {Media-Component-Number}
	      		*[Flow-Number]
	      		*[ Content-Version ]
	       		 [Final-Unit-Action] 
	       		 [Media-Component-Status]
	      		*[AVP]
 */
@DiameterAvpDefinition(code = 510L, vendorId = KnownVendorIDs.TGPP_ID, name = "Flows")
public interface Flows extends DiameterGroupedAvp
{
	Long getMediaComponentNumber();
	
	void setMediaComponentNumber(Long value);
	
	List<Long> getFlowNumber();
	
	void setFlowNumber(List<Long> value);
	
	List<Long> getContentVersion();
	
	void setContentVersion(List<Long> value);
	
	FinalUnitActionEnum getFinalUnitAction();
	
	void setFinalUnitAction(FinalUnitActionEnum value);	
	
	MediaComponentStatusEnum getMediaComponentStatus();
	
	void setMediaComponentStatus(MediaComponentStatusEnum value);	
}