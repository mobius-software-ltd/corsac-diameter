package com.mobius.software.telco.protocols.diameter.primitives.gx;
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
 * 	5.3.7 Event-Trigger AVP (All access types)
	The Event-Trigger AVP (AVP code 1006) is of type Enumerated. When sent from the PCRF to the PCEF the EventTrigger AVP indicates an event that shall cause a re-request of PCC rules. When sent from the PCEF to the PCRF the
	Event-Trigger AVP indicates that the corresponding event has occurred at the gateway.
	NOTE 1: An exception to the above is the Event Trigger AVP set to NO_EVENT_TRIGGERS that indicates that
	PCEF shall not notify PCRF of any event that requires to be provisioned.
	NOTE 2: There are events that do not require to be provisioned by the PCRF, according to the value definition
	included in this subclause. These events will always be reported by the PCEF even though the PCRF has
	not provisioned them in a RAR or CCA command.
	Whenever the PCRF subscribes to one or more event triggers by using the RAR command, unless otherwise specified in
	an event trigger's value definition, the PCEF shall send the corresponding currently applicable values (e.g. 3GPPSGSN-Address AVP or 3GPP-SGSN-Ipv6-Address AVP, RAT-Type, 3GPP-User-Location-Info, etc.) to the PCRF in
	the RAA if available, and in this case, the Event-Trigger AVPs shall not be included.
	Whenever one of these events occurs, the PCEF shall send the related AVP that has changed together with the event
	trigger indication.
	Unless stated for a specific value, the Event-Trigger AVP applies to all access types.
	The values 8, 9, 10, 38 and 41 are obsolete and shall not be used.
	The following values are defined:
	
	SGSN_CHANGE (0)
		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon the change of the
		serving SGSN PCC rules shall be requested. When used in a CCR command, this value indicates that the PCEF
		generated the request because the serving SGSN changed. The new value of the serving SGSN shall be indicated
		in either 3GPP-SGSN-Address AVP or 3GPP-SGSN-Ipv6-Address AVP. Applicable only to 3GPP-GPRS
		access types and 3GPP-EPS access types with access to the P-GW using Gn/Gp.
	QOS_CHANGE (1)
		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon any QoS change (even
		within the limits of the current authorization) at bearer or APN level PCC rules shall be requested. When used in
		a CCR command, this value indicates that the PCEF generated the request because there has been a change in the
		requested QoS for a specific bearer (e.g. the previously maximum authorized QoS has been exceeded) or APN.
		When applicable to 3GPP-GPRS and if the PCRF performs bearer binding, the Bearer-Identifier AVP shall be
		provided to indicate the affected bearer. QoS-Information AVP is required to be provided in the same request
		with the new value. When applicable at APN level, this event trigger shall be reported when the corresponding
		event occurs, even if the event trigger is not provisioned by the PCRF. Not applicable for FBA.
	RAT_CHANGE (2)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a RAT change PCC
		rules shall be requested. When used in a CCR command, this value indicates that the PCEF generated the request
		because of a RAT change. The new RAT type shall be provided in the RAT-Type AVP and AN-Trusted AVP if
		applicable. Not applicable for FBA.
	TFT_CHANGE (3)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a TFT change at bearer
		level PCC rules shall be requested. When used in a CCR command, this value indicates that the PCEF generated
		the request because of a change in the TFT. The Bearer-Identifier AVP shall be provided to indicate the affected
		bearer. All the TFT filter definitions for this bearer, including the requested changes, but excluding the TFT
		filters created with NW-initiated procedures, shall be provided in TFT-Packet-Filter-Information AVP. This
		event trigger shall be provisioned by the PCRF at the PCEF. Applicable only to 3GPP-GPRS.
	PLMN_CHANGE (4)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a PLMN change PCC
		rules shall be requested. When used in a CCR command, this value indicates that the PCEF generated the request
		because there was a change of PLMN. 3GPP-SGSN-MCC-MNC AVP shall be provided in the same request with
		the new value. Not applicable for FBA.
	LOSS_OF_BEARER (5)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon loss of bearer, GW
		should inform PCRF. When used in a CCR command, this value indicates that the PCEF generated the request
		because the bearer associated with the PCC rules indicated by the corresponding Charging-Rule-Report AVP
		was lost. The PCC-Rule-Status AVP within the Charging-Rule-Report AVP shall indicate that these PCC rules
		are temporarily inactive. Applicable to GPRS and 3GPP-EPS when PGW interoperates with a Gn/Gp SGSN.
		The mechanism of indicating loss of bearer to the GW is IP-CAN access type specific. For GPRS, this is
		indicated by a PDP context modification request with Maximum Bit Rate (MBR) in QoS profile changed to 0
		kbps.
		When the PCRF performs the bearer binding, the PCEF shall provide the Bearer-Identifier AVP to indicate the
		bearer that has been lost.
	RECOVERY_OF_BEARER (6)
 		This value shall be in CCA and RAR commands by the PCRF used to indicate that upon recovery of bearer, GW
		should inform PCRF. When used in a CCR command, this value indicates that the PCEF generated the request
		because the bearer associated with the PCC rules indicated by the corresponding Charging-Rule-Report AVP
		was recovered. The PCC-Rule-Status AVP within the Charging-Rule-Report AVP shall indicate that these rules
		are active again. Applicable to GPRS and 3GPP-EPS when PGW interoperates with a Gn/Gp SGSN.
		The mechanism for indicating recovery of bearer to the GW is IP-CAN access type specific. For GPRS, this is
		indicated by a PDP context modification request with Maximum Bit Rate (MBR) in QoS profile changed from 0
		kbps to a valid value.
		When the PCRF performs the bearer binding, the PCEF shall provide the Bearer-Identifier AVP to indicate the
		bearer that has been recovered. 
	IP-CAN_CHANGE (7)
		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a change in the IP-CAN
		type PCC rules shall be requested. When used in a CCR command, this value indicates that the PCEF generated
		the request because there was a change of IP-CAN type. IP-CAN-Type AVP shall be provided in the same 
		request with the new value. The RAT-Type AVP, AN-Trusted AVP and AN-GW-Address AVP shall also be
		provided when applicable to the specific IP-CAN Type. Not applicable for FBA.
	QOS_CHANGE_EXCEEDING_AUTHORIZATION (11)
		This value shall be used in CCA and RAR commands by the PCRF to indicate that only upon a requested QoS
		change beyond the current authorized value(s) at bearer level PCC rules shall be requested. When used in a CCR
		command, this value indicates that the PCEF generated the request because there has been a change in the
		requested QoS beyond the authorized value(s) for a specific bearer. The Bearer-Identifier AVP shall be provided
		to indicate the affected bearer. QoS-Information AVP is required to be provided in the same request with the
		new value. Applicable only to 3GPP-GPRS.
	RAI_CHANGE (12)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a change in the RAI,
		PCEF shall inform the PCRF. When used in a CCR command, this value indicates that the PCEF generated the
		request because there has been a change in the RAI. The new RAI value shall be provided in the RAI AVP. If
		the user location has been changed but the PCEF can not get the detail location information (e.g. handover from
		3G to 2G network), the PCEF shall send the RAI AVP to the PCRF by setting the LAC of the RAI to value
		0x0000. Applicable only to 3GPP-GPRS and 3GPP-EPS access types.
	USER_LOCATION_CHANGE (13)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a change in the user
		location (i.e. applicable for CGI/SAI/RAI/TAI/ECGI/Macro eNB ID), PCEF shall inform the PCRF. When used
		in a CCR command, this value indicates that the PCEF generated the request because there has been a change in
		the user location. The new location value shall be provided in the 3GPP-User-Location-Info AVP. If the user
		location has been changed but the PCEF can not get the detail location information (e.g. handover from 3G to 2G
		network), the PCEF shall send the 3GPP-User-Location-Info AVP to the PCRF by setting the LAC of the
		CGI/SAI to value 0x0000, LAC of the RAI to value 0x0000 for GPRS access, and setting the TAC of the TAI to
		value 0x0000, setting the ECI of the ECGI to value 0x0000, setting the Macro eNB ID to values 0x0000 for the
		EPS access.
		NOTE: The access network may be configured to report location changes only when transmission resources are
		established in the radio access network.
		 Applicable only to 3GPP-GPRS and 3GPP-EPS access types.
	NO_EVENT_TRIGGERS (14)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that PCRF does not require any
		Event Trigger notification except for those events that do not require subscription and are always provisioned.
	OUT_OF_CREDIT (15)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that the PCEF shall inform the
		PCRF about the PCC rules for which credit is no longer available, together with the applied termination action.
		When used in a CCR command, this value indicates that the PCEF generated the request because the PCC rules
		indicated by the corresponding Charging-Rule-Report AVP have run out of credit, and that the termination
		action indicated by the corresponding Final-Unit-Indication AVP applies (3GPP TS 32.240 [21] and
		3GPP TS 32.299 [19]).
	REALLOCATION_OF_CREDIT (16)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that the PCEF shall inform the
		PCRF about the PCC rules for which credit has been reallocated after the former out of credit indication. When
		used in a CCR command, this value indicates that the PCEF generated the request because the PCC rules
		indicated by the corresponding Charging-Rule-Report AVP have been reallocated credit after the former out of
		credit indication (3GPP TS 32.240 [21] and 3GPP TS 32.299 [19]). 
	REVALIDATION_TIMEOUT (17)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon revalidation timeout,
		the PCEF shall inform the PCRF. In order for the PCEF to report this event, it is required that the PCRF provides
		a revalidation time in the Revalidation-Time AVP. When used in a CCR command, this value indicates that the
		PCEF generated the request because there has been a PCC revalidation timeout.
	UE_IP_ADDRESS_ALLOCATE (18)
 		When used in a CCR command, this value indicates that the PCEF generated the request because a UE Ipv4
		address is allocated. The Framed-IP-Address AVP shall be provided in the same request. This event trigger does
		not require to be provisioned by the PCRF. This event trigger shall be reported when the corresponding event
		occurs, even if the event trigger is not provisioned by the PCRF. Applicable to functionality introduced with the
		Rel8 feature as described in subclause 5.4.1. Not applicable for FBA.
	UE_IP_ADDRESS_RELEASE (19)
 		When used in a CCR command, this value indicates that the PCEF generated the request because a UE Ipv4
		address is released. The Framed-IP-Address AVP shall be provided in the same request. This event trigger does
		not require to be provisioned by the PCRF. This event trigger shall be reported when the corresponding event
		occurs, even if the event trigger is not provisioned by the PCRF. Applicable to functionality introduced with the
		Rel8 feature as described in subclause 5.4.1. Not applicable for FBA.
	DEFAULT_EPS_BEARER_QOS_CHANGE (20)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a change in the default
		EPS Bearer QoS, PCEF shall inform the PCRF. When used in a CCR command, this value indicates that the
		PCEF generated the request because there has been a change in the default EPS Bearer QoS. The new value shall
		be provided in the Default-EPS-Bearer-QoS AVP. This event trigger shall be reported when the corresponding
		event occurs, even if the event trigger is not provisioned by the PCRF. Not applicable for 3GPP-GPRS and FBA
		access types. Applicable to functionality introduced with the Rel8 feature as described in subclause 5.4.1.
	AN_GW_CHANGE (21)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon the change of the
		serving Access Node Gateway, PCC rules shall be requested. When used in a CCR command, this value
		indicates that the PCEF generated the request because the serving Access Node gateway changed. The new value
		of the serving Access Node gateway shall be indicated in the AN-GW-Address AVP. Applicable to functionality
		introduced with the Rel8 feature as described in subclause 5.4.1. Not applicable for FBA.
	SUCCESSFUL_RESOURCE_ALLOCATION (22)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that the PCEF can inform the
		PCRF of successful resource allocation for those rules that requires so.
		 When used in a CCR command, this value indicates that the PCEF informs the PCRF that the resources for a rule
		have been successfully allocated. The affected rules are indicated within the Charging-Rule-Report AVP with
		the PCC-Rule-Status AVP set to the value ACTIVE (0). Applicable to functionality introduced with the Rel8
		feature as described in subclause 5.4.1. The PCEF may also indicate the Content-Version AVP(s) related to the
		affected PCC rule(s) within the Charging-Rule-Report. Not applicable for FBA.
	RESOURCE_MODIFICATION_REQUEST (23)
 		This value shall be used in a CCR command to indicate that PCC rules are requested for a resource modification
		request initiated by the UE. The Packet-Filter-Operation and Packet-Filter-Information AVPs shall be provided
		in the same request. This event trigger does not require to be provisioned by the PCRF. It shall be reported by the
		PCEF when the corresponding event occurs even if the event trigger is not provisioned by the PCRF. Applicable
		to functionality introduced with the Rel8 feature as described in subclause 5.4.1. Not applicable for FBA.
	PGW_TRACE_CONTROL (24)
 		This value indicates that the command contains a trace activation or deactivation request for the P-GW. Trace
		activation is indicated with the presence of the Trace-Data AVP with the relevant trace parameters. Trace
		deactivation is indicated with the presence of the Trace-Reference AVP. This event trigger needs no
		subscription. Applicable to functionality introduced with the Rel8 feature as described in subclause 5.4.1. Not
		applicable for FBA.
	UE_TIME_ZONE_CHANGE (25) 
		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a change to the time
		zone the UE is currently located in, PCC rules shall be requested. When used in a CCR command, this value
		indicates that the PCEF generated the request because the time zone the UE is currently located in has changed.
		The new value of the UE's time zone shall be indicated in the 3GPP-MS-TimeZone AVP. Not applicable for
		FBA.
	TAI_CHANGE (26)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a change in the TAI,
		PCEF shall inform the PCRF. When used in a CCR command, this value indicates that the PCEF generated the
		request because there has been a change in the TAI. The new TAI value shall be provided in the 3GPP-UserLocation-Info AVP. If the user tracking area location has been changed but the PCEF can not get the detail
		location information, the PCEF shall send the 3GPP-User-Location-Info AVP to the PCRF by setting the TAC
		of the TAI to value 0x0000. Applicable only to 3GPP-EPS access type and to functionality introduced with the
		Rel8 feature as described in subclause 5.4.1.
	ECGI_CHANGE (27)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a change in the ECGI,
		PCEF shall inform the PCRF. When used in a CCR command, this value indicates that the PCEF generated the
		request because there has been a change in the ECGI. The new ECGI value shall be provided in the 3GPP-UserLocation-Info AVP. If the ECGI has been changed but the PCEF can not get the detail location information, the
		PCEF shall send the 3GPP-User-Location-Info AVP to the PCRF by setting the ECI of the ECGI to value
		0x0000. Applicable only to 3GPP-EPS access type and to functionality introduced with the Rel8 feature as
		described in subclause 5.4.1.
	CHARGING_CORRELATION_EXCHANGE (28)
 		The PCRF shall use this value in CCA and RAR commands to indicate that the PCEF shall report the access
		network charging identifier associated to one or more dynamic PCC Rules within the Access-Network-ChargingIdentifier-Gx AVP. In order for the PCEF to report this event, it is required that the Charging-CorrelationIndicator AVP with value CHARGING_IDENTIFIER_REQUIRED is provided. Not applicable for FBA.
 		When used in a CCR command, this value indicates that an access network charging identifier has been
		assigned. The actual value shall be reported with the Access-Network-Charging-Identifier-Gx AVP. Applicable
		to functionality introduced with the Rel8 feature as described in subclause 5.4.1.
	APN-AMBR_MODIFICATION_FAILURE (29)
 		The PCEF shall use this value to indicate to the PCRF that APN-AMBR modifications have failed. The PCEF
		shall use this value in a new CCR command that indicates the failure of either a PUSH initiated modification or a
		PULL initiated modification. This event trigger needs no subscription. Applicable to functionality introduced
		with the Rel8 feature as described in subclause 5.4.1. Not applicable for FBA.
	USER_CSG_INFORMATION_CHANGE (30)
 		The PCRF shall use this value to indicate a request of reporting the event that the user enters/leaves a CSG cell.
 		When the user enters a CSG cell, the User-CSG-Information AVP shall also be provided with the event report in
		the CCR command. Applicable to functionality introduced with the Rel9 feature as described in subclause 5.4.1.
		Not applicable for FBA. 
	USAGE_REPORT (33)
 		This value shall be used in a CCA and RAR commands by the PCRF when requesting usage monitoring at the
		PCEF. In order for the PCEF to report this event, it is required that the PCRF provides in a CCA or RAR
		command the Usage-Monitoring-Information AVP(s) including the Monitoring-Key AVP and the GrantedService-Unit AVP.
 		When used in a CCR command, this value indicates that the PCEF generated the request to report the
		accumulated usage for one or more monitoring keys. The PCEF shall also provide the accumulated usage
		volume and/or time using the Usage-Monitoring-Information AVP(s) including the Monitoring-Key AVP and
		the Used-Service-Unit AVP. Applicable to functionality introduced with the Rel9 feature for volume usage
		reporting, with the ADC feature and with the TimeBasedUM feature for time usage reporting, as described in
		subclause 5.4.1. 
	DEFAULT-EPS-BEARER-QOS_MODIFICATION_FAILURE (34)
 		The PCEF shall use this value to indicate to the PCRF that Default EPS Bearer QoS modifications have failed.
		The PCEF shall use this value in a new CCR command that indicates the failure of either a PUSH initiated
		modification or a PULL initiated modification. This event trigger needs no subscription. Applicable to
		functionality introduced with the Rel8 feature as described in subclause 5.4.1. Not applicable for FBA.
	USER_CSG_HYBRID_SUBSCRIBED_INFORMATION_CHANGE (35)
 		The PCRF shall use this value to indicate a request of reporting the event that the user enters/leaves a hybrid cell
		that the user subscribes to.
 		When the user enters a hybrid cell where the user is a member, the User-CSG-Information AVP shall also be
		provided with the event report in the CCR command. Applicable to functionality introduced with the Rel9
		feature as described in subclause 5.4.1. Not applicable for FBA.
	USER_CSG_ HYBRID_UNSUBSCRIBED_INFORMATION_CHANGE (36)
 		The PCRF shall use this value to indicate a request of reporting the event that the user enters/leaves a hybrid cell
		that the user does not subscribe to.
 		When the user enters a hybrid cell where the user is not a member, the User-CSG-Information AVP shall be
		provided with the event report in the CCR command. Applicable to functionality introduced with the Rel9
		feature as described in subclause 5.4.1. Not applicable for FBA.
	ROUTING_RULE_CHANGE (37)
 		When used in a CCR command, this value indicates that the PCEF generated the request because there has been
		a change in the IP flow mobility routing rules for s2c based IP flow mobility (installation/modification/removal
		of the IP flow mobility routing rule) or a change in the NBIFOM routing rules for NBIFOM
		(installation/modification/removal of the NBIFOM routing rule). The new IP flow mobility/NBIFOM routing
		rule information shall be provided in the Routing-Rule-Definition AVP within the same CCR command. This
		event trigger needs no subscription. Applicable only to IPFlowMobility functionality feature (IFOM) or
		NBIFOM functionality feature as described in subclause 5.4.1. Not applicable for FBA.
	APPLICATION_START (39)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that the PCEF shall inform the
		PCRF when the start of the application's traffic for the application, required for detection, has been identified,
		unless a request to mute such a notification (Mute-Notification AVP) is part of the corresponding ChargingRule-Definition AVP.
 		When used in a CCR command, this value indicates that the PCEF identified the start of the corresponding
		application's traffic for an applicationidentified by a TDF-Application-Identifier AVP.The detected
		application(s) shall be identified by the Application-Detection-Information AVP(s). Applicable to functionality
		introduced with the ADC feature as described in subclause 5.4.1.
 		For unsolicited application reporting, APPLICATION_START Event Trigger is always set and does not need to
		be subscribed by the PCRF.

		NOTE 1: For solicited application reporting, APPLICATION_START is always provided together with
		APPLICATION_STOP, when used by the PCRF in CCA and RAR commands sent to the PCEF.

	APPLICATION_STOP (40)
 		This value shall be used in a CCA and RAR commands by the PCRF to indicate that the PCEF shall inform the
		PCRF when the stop of the application's traffic for the application, required for detection, has been identified,
		unless a request to mute such a notification (Mute-Notification AVP) is part of the corresponding ChargingRule-Definition AVP.
 		When used in a CCR command, this value indicates that the PCEF identified the stop of the corresponding
		application's traffic for an applicationidentified by a TDF-Application-Identifier AVP . The detected
		application(s) shall be identified by the Application-Detection-Information AVP(s). Applicable to functionality
		introduced with the ADC feature as described in subclause 5.4.1. 
		For unsolicited application reporting, APPLICATION_STOP Event Trigger is always set and does not need to
		be subscribed by the PCRF.
	CS_TO_PS_HANDOVER (42)
 		This value shall be used in CCA and RAR command by the PCRF to indicate that upon a CS to PS Handover,
		the PCEF shall inform the PCRF. When used in a CCR command, this value indicates that the PCEF generated
		the request because there is a CS to PS handover. Applicable only to CS to PS SRVCC functionality feature
		(rSRVCC) as described in subclause 5.4.1.
	UE_LOCAL_IP_ADDRESS_CHANGE (43)
 		When used in a CCR command, this value indicates that the PCEF generated the request because the UE Local
		IP Address or the UDP source port number or both assigned by the Fixed Broadband Access have changed. The
		UE-Local-IP-Address AVP and/or the UDP-Source-Port AVP shall be provided in the same request. This event
		trigger does not require to be provisioned by the PCRF. Applicable to functionality introduced with the EPCrouted feature as described in subclause 5.4.1.
		H(E)NB_LOCAL_IP_ADDRESS_CHANGE (44)
 		When used in a CCR command, this value indicates that the PCEF generated the request because the H(e)NB
		Local IP Address or the UDP source port number or both assigned by the Fixed Broadband Access have
		changed. The HeNB-Local-IP-Address AVP and/or the UDP-Source-Port AVP shall be provided in the same
		request. Applicable to functionality introduced with the EPC-routed feature as described in subclause 5.4.1.
	ACCESS_NETWORK_INFO_REPORT (45)
 		This value shall be used in CCA and RAR commands by the PCRF to request access network information from
		the PCEF as defined in clause 4.5.22. When used in a CCR command, this value indicates that the PCEF
		generated the request because the PCEF reports the corresponding access network information to the PCRF as
		requested. The PCEF shall not provide the requested access network information in an RAA command solely
		based on the fact that the PCRF provisioned this Event-Trigger in an RAR command. Instead, procedures
		defined in subclause 4.5.22 shall be followed. Applicable to functionality introduced with the NetLoc feature as
		described in subclause 5.4.1.
	CREDIT_MANAGEMENT_SESSION_FAILURE (46)
 		When used in a CCR command, this value indicates that a transient/permanent failure has been detected in the
		OCS. If the failure does not apply to all PCC Rules, the affected PCC Rules are indicated within the ChargingRule-Report AVP, with the PCC-Rule-Status set to value ACTIVE and the Rule-Failure-Code AVP set to the
		corresponding value as reported by the OCS. If the failure applies to the session, the Credit-Management-Status
		shall be set to the corresponding value as reported by the OCS. When used over Sd reference point, it is
		applicable to functionality introduced with the ABC features as described in subclause 5.4.1.
		
		NOTE 2: For the PCEF, CREDIT_MANAGEMENT_SESSION_FAILURE event trigger only applies to the
		situation that the IP-CAN session is not terminated by the PCEF due to the credit management session failure.

	DEFAULT_QOS_CHANGE (47)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon any Default QoS
		change PCEF shall inform the PCRF. When used in a CCR command, this value indicates that the PCEF
		generated the request because there has been a change in the Default QoS. The new value shall be provided in
		the Default-QoS-Information AVP. Applicable only to FBA access type and to functionality introduced with the
		FBAC feature as described in subclause 5.4.1.
		CHANGE_OF_UE_PRESENCE_IN_PRESENCE_REPORTING_AREA_REPORT (48)
 		This value shall be used in CCA or RAR commands by the PCRF to indicate that the PCEF shall report the event
		when the user enters/leaves the area as indicated in the Presence-Reporting-Area-Information AVP. This
		includes reporting the initial status at the time the request for reports is initiated.
 		When used in a CCR command, this value indicates whether the UE is within or outside the requested presence
		reporting area. Presence-Reporting-Area-Identifier AVP and Presence-Reporting-Area-Status AVP shall be
		provided in the same request included in Presence-Reporting-Area-Information AVP. Applicable only to 3GPP-
		EPS access type and to functionality introduced with the CNO-ULI or Multiple-PRA feature as described in
		subclause 5.4.1.
	ADDITION_OF_ACCESS (49)
 		When used in a CCR command, this value indicates that the PCEF generated the request because an access is
		added in the NBIFOM scenario. The new IP-CAN type of the new accessis provided within the same CCR
		command. This event trigger needs no subscription. Applicable only to NBIFOM functionality feature as
		described in subclause 5.4.1. Not applicable for FBA.
	REMOVAL_OF_ACCESS (50)
 		When used in a CCR command, this value indicates that the PCEF generated the request because an access is
		removed in the NBIFOM scenario. The IP-CAN type of the removed access is provided within the same CCR
		command. This event trigger needs no subscription. Applicable only to NBIFOM functionality feature as
		described in subclause 5.4.1. Not applicable for FBA.
	UNAVAILABLITY_OF_ACCESS (51)
 		When used in a CCR command, this value indicates that the PCEF generated the request because an access is not
		available in the NBIFOM scenario. The IP-CAN type of the unavailable access within the IP-CAN-Type AVP
		and the reason causing the access to be unavailable within the Access-Availability-Change-Reason AVP are
		provided within the same CCR command. This event trigger needs no subscription. Applicable only to NBIFOM
		functionality feature as described in subclause 5.4.1. Not applicable for FBA.
	AVAILABLITY_OF_ACCESS (52)
 		When used in a CCR command, this value indicates that the PCEF generated the request because an access is
		available again in the NBIFOM scenario or PCEF receives an Access stratum indication as defined in
		3GPP TS 29.274 [22]. The IP-CAN type of the available access within the IP-CAN-Type AVP and the reason
		causing the access to be available within the Access-Availability-Change-Reason AVP are provided within the
		same CCR command. When the PCEF receives the move-to-wlan or move-from-wlan indication, the IP-CAN
		type of the WLAN or 3GPP access within the IP-CAN-Type AVP and the reason of Access stratum indication
		within the Access-Availability-Change-Reason AVP are provided within the same CCR command. This event
		trigger needs no subscription. Applicable only to NBIFOM functionality feature as described in subclause 5.4.1.
		Not applicable for FBA.
	RESOURCE_RELEASE (53)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that the PCEF can inform the
		PCRF of the outcome of the release of resources for those rules that require so.
 		When used in a CCR command, this value indicates that the PCEF informs the PCRF about the outcome of the
		resource release for a rule that has been removed. The affected rules are indicated within the Charging-RuleReport AVP with the PCC-Rule-Status AVP set to the value INACTIVE (1). If the PCEF receives from the
		access network some RAN/NAS release cause(s), TWAN release cause(s) or untrusted WLAN release cause(s),
		the PCEF shall also provide the received cause(s) in the Charging-Rule-Report AVP. Applicable to functionality
		introduced with the Enh-RAN-NAS-Cause feature as described in subclause 5.4.1. Not applicable for FBA.
	ENODEB_CHANGE (54)
 		This value shall be used in CCA and RAR commands by the PCRF to indicate that upon a change in the user
		location of eNB change granularity, PCEF shall inform the PCRF. When used in a CCR command, this value
		indicates that the PCEF generated the request because there has been a change in the user location of eNB
		change granularity, the new eNB ID value shall be provided in the 3GPP-User-Location-Info AVP. Applicable
		only to 3GPP-EPS access type and to functionality introduced with the ENB-Change feature as described in
		subclause 5.4.1. 
	3GPP_PS_DATA_OFF_CHANGE (55)
 		This value shall be used in CCR command by the PCEF to indicate that the PCEF generated the request because
		there has been a change of 3GPP PS Data Off status indicated by the UE, with the status of 3GPP PS Data Off in
		the 3GPP-PS-Data-Off-Status AVP. This event trigger needs no subscription. Applicable only to 3GPP-EPS
		access type and to functionality introduced with the 3GPP-PS-Data-Off feature as described in subclause 5.4.1.
	UE_STATUS_RESUME (56)
 		This value shall be used in RAR and CCA commands by the PCRF to indicate that the PCEF shall report the
		event when the user’s status is changed from suspend to resume. When used in a CCR command by the PCEF,
		this value indicates that the UE’s status is resumed. Applicable only to 3GPP-EPS access type and to
		functionality introduced with the UE-Status-Change feature as described in subclause 5.4.1.
	SUCCESSFUL_QOS_UPDATE (57)
 		This value shall be used in the RAR command by the PCRF to indicate that the PCEF shall inform the PCRF
		when resources for the MPS for DTS invocation/revocation are successfully allocated for MPS for DTS, as
		described in subclause 4.5.19.1.4.
 		When used in a CCR command by the PCEF, this value indicates that the requested resources for the MPS for
		DTS invocation/revocation have been successfully allocated. Applicable only to 3GPP-EPS access type and to
		functionality introduced with the MPSforDTS feature as described in clause 5.4.1.
 */
@DiameterAvpDefinition(code = 1006L, vendorId = KnownVendorIDs.TGPP_ID, name = "Event-Trigger")
public interface EventTrigger extends DiameterEnumerated<EventTriggerEnum>
{
}