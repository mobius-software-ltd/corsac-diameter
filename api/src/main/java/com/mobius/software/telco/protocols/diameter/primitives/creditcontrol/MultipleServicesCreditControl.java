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
 * 8.16.  Multiple-Services-Credit-Control AVP

   The Multiple-Services-Credit-Control AVP (AVP Code 456) is of type
   Grouped and contains the AVPs related to the independent
   credit-control of multiple services.  Note that each instance of this
   AVP carries units related to one or more services or related to a
   single rating-group.

   The Service-Identifier AVP and the Rating-Group AVP are used to
   associate the granted units to a given service or rating-group.  If
   both the Service-Identifier AVP and the Rating-Group AVP are
   included, the target of the service units is always the service(s)
   indicated by the value of the Service-Identifier AVP(s).  If only the
   
   Rating-Group AVP is present, the Multiple-Services-Credit-Control AVP
   relates to all the services that belong to the specified
   rating-group.

   The G-S-U-Pool-Reference AVP allows the server to specify a
   G-S-U-Pool-Identifier identifying a credit pool within which the
   units of the specified type are considered pooled.  If a G-S-U-Pool-
   Reference AVP is present, then actual service units of the specified
   type MUST also be present.  For example, if the G-S-U-Pool-Reference
   AVP specifies a CC-Unit-Type value of TIME (Section 8.32), then the
   CC-Time AVP MUST be present.

   The Requested-Service-Unit AVP MAY contain the amount of requested
   service units or the requested monetary value.  It MUST be present in
   the initial interrogation and within the intermediate interrogations
   in which a new quota is requested.  If the credit-control client does
   not include the Requested-Service-Unit AVP in a request command --
   because, for instance, it has determined that the end user terminated
   the service -- the server MUST debit the used amount from the user's
   account but MUST NOT return a new quota in the corresponding answer.
   The Validity-Time, Result-Code, and Final-Unit-Indication or
   QoS-Final-Unit-Indication AVPs MAY be present in a Credit-Control-
   Answer command as defined in Sections 5.1.2 and 5.6 for graceful
   service termination.

   When both the Tariff-Time-Change AVP and the Tariff-Change-Usage AVP
   are present, the server MUST include two separate instances of the
   Multiple-Services-Credit-Control AVP with the Granted-Service-Unit
   AVP associated to the same service-identifier and/or rating-group.
   Where the two quotas are associated to the same pool or to different
   pools, the credit-pooling mechanism defined in Section 5.1.2 applies.
   When the client is reporting used units before and after the tariff
   time change, it MUST use the Tariff-Change-Usage AVP inside the
   Used-Service-Unit AVP.

   A server not implementing the independent credit-control of multiple
   services MUST treat the Multiple-Services-Credit-Control AVP as an
   invalid AVP.
   
   The Multiple-Services-Credit-Control AVP is defined as follows (per
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