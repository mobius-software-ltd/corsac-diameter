package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;

/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.236 Trigger-Type AVP
	The Trigger-Type AVP (AVP code 870) is of type Enumerated and indicates a single re-authorization event type.
	When included in the CCA command, the Trigger-Type AVP indicates the events that shall cause the Credit-Control
	client to re-authorize the associated quota. The client shall not re-authorize the quota when events which are not
	included in the Trigger AVP occur.
	When included in the CCR command indicates the specific event which caused the re-authorization request of the
	Reporting-Reason with value RATING_CONDITION_CHANGE associated.
	It has the following values:

	1 CHANGE_IN_SGSN_IP_ADDRESS
	This value is used to indicate that a change in the SGSN IP address shall cause the Credit-Control client to ask
	for a re-authorization of the associated quota.

	2 CHANGE_IN_QOS
	This value is used to indicate that a change in the end user negotiated QoS shall cause the Credit-Control client
	to ask for a re-authorization of the associated quota.
	
	NOTE 1: This should not be used in conjunction with enumerated values 10 to 23.

	3 CHANGE_IN_LOCATION
	This value is used to indicate that a change in the end user location shall cause the Credit-Control client to ask
	for a re-authorization of the associated quota.

	NOTE 2: This should not be used in conjunction with enumerated values 30 to 36.

	4 CHANGE_IN_RAT
	This value is used to indicate that a change in the radio access technology shall cause the Credit-Control client to
	ask for a re-authorization of the associated quota.

	5 CHANGE_IN_UE_TIMEZONE
	This value is used to indicate that a change in the TimeZone where the end user is located shall cause the CreditControl client to ask for a re-authorization of the associated quota.

	10 CHANGEINQOS_TRAFFIC_CLASS
	This value is used to indicate that a change in the end user negotiated traffic class shall cause the Credit-Control
	client to ask for a re-authorization of the associated quota.

	11 CHANGEINQOS_RELIABILITY_CLASS
	This value is used to indicate that a change in the end user negotiated reliability class shall cause the CreditControl client to ask for a re-authorization of the associated quota.

	12 CHANGEINQOS_DELAY_CLASS
	This value is used to indicate that a change in the end user negotiated delay class shall cause the Credit-Control
	client to ask for a re-authorization of the associated quota.

	13 CHANGEINQOS_PEAK_THROUGHPUT
	This value is used to indicate that a change in the end user negotiated peak throughput shall cause the CreditControl client to ask for a re-authorization of the associated quota.

	14 CHANGEINQOS_PRECEDENCE_CLASS
	This value is used to indicate that a change in the end user negotiated precedence class shall cause the CreditControl client to ask for a re-authorization of the associated quota. 

	15 CHANGEINQOS_MEAN_THROUGHPUT
	This value is used to indicate that a change in the end user negotiated mean throughput shall cause the CreditControl client to ask for a re-authorization of the associated quota.

	16 CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_UPLINK
	This value is used to indicate that a change in the end user negotiated uplink maximum bit rate shall cause the
	Credit-Control client to ask for a re-authorization of the associated quota.

	17 CHANGEINQOS_MAXIMUM_BIT_RATE_FOR_DOWNLINK
	This value is used to indicate that a change in the end user negotiated downlink maximum bit rate shall cause the
	Credit-Control client to ask for a re-authorization of the associated quota.

	18 CHANGEINQOS_RESIDUAL_BER
	This value is used to indicate that a change in the end user negotiated residual BER shall cause the CreditControl client to ask for a re-authorization of the associated quota.

	19 CHANGEINQOS_SDU_ERROR_RATIO
	This value is used to indicate that a change in the end user negotiated SDU error ratio shall cause the CreditControl client to ask for a re-authorization of the associated quota.

	20 CHANGEINQOS_TRANSFER_DELAY
	This value is used to indicate that a change in the end user negotiated transfer delay shall cause the CreditControl client to ask for a re-authorization of the associated quota.

	21 CHANGEINQOS_TRAFFIC_HANDLING_PRIORITY
	This value is used to indicate that a change in the end user negotiated traffic handling priority shall cause the
	Credit-Control client to ask for a re-authorization of the associated quota.

	22 CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_UPLINK
	This value is used to indicate that a change in the end user negotiated uplink guaranteed bit rate shall cause the
	Credit-Control client to ask for a re-authorization of the associated quota.

	23 CHANGEINQOS_GUARANTEED_BIT_RATE_FOR_DOWNLINK
	This value is used to indicate that a change in the end user negotiated downlink guaranteed bit rate shall cause
	the Credit-Control client to ask for a re-authorization of the associated quota.

	24 CHANGEINQOS_APN_AGGREGATE_MAXIMUM_BIT_RATE
	This value is used to indicate that a change in the APN aggregate maximum bit rate for the IP-CAN session shall
	cause the Credit-Control client to ask for a re-authorization of the associated quota. This value is only applicable
	when charging per IP-CAN session is active.

	30 CHANGEINLOCATION_MCC
	This value is used to indicate that a change in the MCC of the serving network shall cause the Credit-Control
	client to ask for a re-authorization of the associated quota.

	31 CHANGEINLOCATION_MNC
	This value is used to indicate that a change in the MNC of the serving network shall cause the Credit-Control
	client to ask for a re-authorization of the associated quota.

	32 CHANGEINLOCATION_RAC
	This value is used to indicate that a change in the RAC where the end user is located shall cause the CreditControl client to ask for a re-authorization of the associated quota.

	33 CHANGEINLOCATION_LAC
	This value is used to indicate that a change in the LAC where the end user is located shall cause the CreditControl client to ask for a re-authorization of the associated quota.

	34 CHANGEINLOCATION_CellId
	This value is used to indicate that a change in the Cell Identity where the end user is located shall cause the
	Credit-Control client to ask for a re-authorization of the associated quota. 

	35 CHANGEINLOCATION_TAC
	This value is used to indicate that a change in the TAC where the end user is located shall cause the CreditControl client to ask for a re-authorization of the associated quota. 

	36 CHANGEINLOCATION_ECGI
	This value is used to indicate that a change in the ECGI where the end user is located shall cause the CreditControl client to ask for a re-authorization of the associated quota.

	40 CHANGE_IN_MEDIA_COMPOSITION
	This value is used to indicate that a change in the media composition (as identified within SDP) for an existing
	SIP session shall cause the Credit-Control client to ask for a re-authorization of the associated quota.

	50 CHANGE_IN_PARTICIPANTS_NMB
	This value is used specifically for multi participating session to indicate that a change in the number of active
	participants within a session shall cause the Credit-Control client to ask for a re-authorization of the associated
	quota.

	51 CHANGE_IN_ THRSHLD_OF_PARTICIPANTS_NMB
	This value is used specifically to indicate that a change in the threshold of participants number within a session
	shall cause the Credit-Control client to ask for a re-authorization of the associated quota.

	NOTE 3: The threshold and the granularity of threshold are operator configurable. This should not be used in
	conjunction with value 50.

	52 CHANGE_IN_USER_PARTICIPATING_TYPE
	This value is used specifically to indicate that a change in the user participating type within a session shall cause
	the Credit-Control client to ask for a re-authorization of the associated quota.

	60 CHANGE_IN_SERVICE_CONDITION
	This value is used to indicate that a change in rating conditions associated with a service occurs.
	The description of the conditions causing a change are service specific and may be documented in middle-tier
	specifications or may be configurable. 

	61 CHANGE_IN_SERVING_NODE
	This value is used to indicate that a change in serving node shall cause the Credit-Control client to ask for a reauthorization of the associated quota.

	62 CHANGE_IN_ACCESS_FOR_A_SERVICE_DATA_FLOW
	This value is used to indicate that a change in access for a service data flow shall cause the Credit-Control client
	to ask for a re-authorization of the associated quota. This value is only applicable when charging per IP-CAN
	session is active for a multi-access PDN connection.

	70 CHANGE_IN_USER_CSG_INFORMATION
	This value is used to indicate a request of reporting the event that the user enters/leaves a CSG cell. When used
	in a CCR, at entry to a CSG cell, the User-CSG-Information AVP shall be provided with the event report. When
	used in a CCR without any User-CSG-Information AVP, it indicates the user leaves the CSG cell.

	71 CHANGE_IN_HYBRID_SUBSCRIBED_USER_CSG_INFORMATION
	This value is used to indicate a request of reporting the event that the user enters/leaves a hybrid cell that the user
	subscribes to. When used in a CCR, at entry to a hybrid cell where the user is a member, the User-CSGInformation AVP shall be provided with the event report. When used in a CCR without any User-CSGInformation AVP, it indicates the user leaves the hybrid cell he was a member of.

	72 CHANGE_IN_HYBRID_UNSUBSCRIBED_USER_CSG_INFORMATION
	This value is used to indicate a request of reporting the event that the user enters/leaves a hybrid cell that the user
	does not subscribe to. When used in a CCR, at entry to a hybrid cell where the user is not a member, the UserCSG-Information AVP shall be provided with the event report. When used in a CCR without any User-CSGInformation AVP, it indicates the user leaves the hybrid cell he was not a member of.

	73 CHANGE_OF_UE_PRESENCE_IN_PRESENCE_REPORTING_AREA
	This value is used to indicate a request from OCS of reporting the event that the user enters/leaves the area(s) as
	indicated in the Presence-Reporting-Area-Information AVP. This includes reporting the initial status at the time
	of the request. When used in a CCR, the Presence-Reporting-Area-Identifier AVP and Presence-Reporting-AreaStatus AVP shall be provided in the Presence-Reporting-Area-Information AVP with the event report. For the
	UE-dedicated presence area, the Presence-Reporting-Area-Elements-List AVP may be provided in the PresenceReporting-Area-Information AVP. When used in a CCA with a list of PRA(s) , the new list of PRA(s) shall
	supersede the previous provided list. In case this trigger is not included in Trigger-Type AVP, it indicates all
	PRAs are unsubscribed.74 CHANGE_IN_SERVING_PLMN_RATE_CONTROL 
	This value is used to indicate that a change in the Serving PLMN Rate Control shall cause the Credit-Control
	client to ask for a re-authorization of the associated quota.

	75 CHANGE_IN_APN_RATE_CONTROL
	This value is used to indicate that a change in the APN Rate Control shall cause the Credit-Control client to ask
	for a re-authorization of the associated quota.

	76 CHANGE_IN_3GPP_PS_DATA_OFF
 	This value is used to indicate that a change in the 3GPP_PS_DATA_OFF shall cause the Credit-Control client to
	ask for a re-authorization of the associated quota. 
*/
@DiameterAvpDefinition(code = 870L, vendorId = KnownVendorIDs.TGPP_ID, name = "Trigger-Type")
public interface TriggerType extends DiameterEnumerated<TriggerTypeEnum>
{
}