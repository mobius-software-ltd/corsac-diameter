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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;

/**
*
* @author yulian oifa
*
*/

/*
 * The Multiple-Services-Credit-Control AVP is defined as follows (per
   grouped-avp-def as defined in [RFC6733]):

    Multiple-Services-Credit-Control ::= < AVP Header: 456 >
                                         [ Granted-Service-Unit ]
                                         [ Requested-Service-Unit ]
                                        *[ Used-Service-Unit ]
                                         [ Tariff-Change-Usage ]
                                        *[ Service-Identifier ]
                                         [ Rating-Group ]
                                        *[ G-S-U-Pool-Reference ]
                                         [ Validity-Time ]
                                         [ Result-Code ]
                                         [ Final-Unit-Indication ]
                                         [ QoS-Final-Unit-Indication ]
                                        *[ AVP ]
 */

@DiameterAvpDefinition(code = 456L, vendorId = -1, name = "Multiple-Services-Credit-Control")
public interface MultipleServicesCreditControl extends DiameterGroupedAvp 
{
	GrantedServiceUnit getGrantedServiceUnit();
	
	void setGrantedServiceUnit(GrantedServiceUnit grantedServiceUnit);
	
	RequestedServiceUnit getRequestedServiceUnit();
	
	void setRequestedServiceUnit(RequestedServiceUnit requestedServiceUnit);
	
	List<UsedServiceUnit> getUsedServiceUnit();
	
	void setUsedServiceUnit(List<UsedServiceUnit> usedServiceUnit);
	
	TariffChangeUsageEnum getTariffChangeUsage();
	
	void setTariffChangeUsage(TariffChangeUsageEnum tariffChangeUsage);	
	
	List<Long> getServiceIdentifier();
	
	void setServiceIdentifier(List<Long> serviceIdentifier);	
	
	Long getRatingGroup();
	
	void setRatingGroup(Long ratingGroup);	
			
	List<GSUPoolReference> getGSUPoolReference();
	
	void setGSUPoolReference(List<GSUPoolReference> gsuPoolReference);	
	
	Long getValidityTime();
	
	void setValidityTime(Long validityTime);	
			
	Long getResultCode();
	
	void setResultCode(Long resultCode);	
			
	FinalUnitIndication getFinalUnitIndication();
	
	void setFinalUnitIndication(FinalUnitIndication finalUnitIndication);	

	QoSFinalUnitIndication getQoSFinalUnitIndication();
	
	void setQoSFinalUnitIndication(QoSFinalUnitIndication qosFinalUnitIndication);	        
}