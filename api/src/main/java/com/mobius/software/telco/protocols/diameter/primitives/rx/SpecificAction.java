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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterEnumerated;

/**
*
* @author yulian oifa
*
*/

/*
 * 	5.3.13	Specific-Action AVP
	The Specific-Action AVP (AVP code 513) is of type Enumerated.
	Within a PCRF initiated Re-Authorization Request, the Specific-Action AVP determines the type of the action.
	Within an initial AA request the AF may use the Specific-Action AVP to request any specific actions from the server at the bearer events and to limit the contact to such bearer events where specific action is required. If the Specific-Action AVP is omitted within the initial AA request, no notification of any of the events defined below is requested at this time.
	For one time specific actions, as identified in the value descriptions below, the AF may also provide the Specific-Action AVP with the applicable one-time-specific-action value(s) in subsequent AA-Requests. Non-one-time-specific-action value(s) may only be provided in the initial AA-Request and shall then be applicable for the entire lifetime of the Rx session.

	NOTE 1:	One time specific actions are reported once the required action is fulfilled and are not reported again unless the AF sends a new request.

	NOTE 2:	Unless otherwise stated in the definition of the specific action value, when the AF requests specific actions in the initial AA-Request, the PCRF reports that action whenever new related information is available during the lifetime of the Rx session.

	NOTE 2a:	Whether the PCRF decides to report INDICATION_OF_RELEASE_OF_BEARER (4) or INDICATION_OF_FAILED_RESOURCES_ALLOCATION (9) upon receipt of a bearer failure from the PCEF is left to the implementation.

	The following values are defined:

	Void (0)

	CHARGING_CORRELATION_EXCHANGE (1)
		Within a RAR, this value shall be used when the server reports the access network charging identifier to the AF. The Access-Network-Charging-Identifier AVP shall be included within the request. In the AAR, this value indicates that the AF requests the server to provide the access network charging identifier to the AF for each authorized flow, when the access network charging identifier becomes known at the PCRF.

	INDICATION_OF_LOSS_OF_BEARER (2)
		Within a RAR, this value shall be used when the server reports a loss of a bearer (in the case of GPRS PDP context bandwidth modification to 0 kbit for GBR bearers) to the AF. The SDFs that are deactivated as a consequence of this loss of bearer shall be provided within the Flows AVP. In the AAR, this value indicates that the AF requests the server to provide a notification at the loss of a bearer.

	INDICATION_OF_RECOVERY_OF_BEARER (3)
		Within a RAR, this value shall be used when the server reports a recovery of a bearer (in the case of 3GPP-GPRS or 3GPP-EPS when PGW interoperates with a Gn/Gp SGSN, PDP context bandwidth modification from 0 kbit to another value for GBR bearers) to the AF. The SDFs that are re-activated as a consequence of the recovery of bearer shall be provided within the Flows AVP. In the AAR, this value indicates that the AF requests the server to provide a notification at the recovery of a bearer.

	INDICATION_OF_RELEASE_OF_BEARER (4)
		Within a RAR, this value shall be used when the server reports the release of a bearer (e.g. PDP context removal for 3GPP-GPRS or bearer/PDP context removal for 3GPP-EPS) to the AF. The SDFs that are deactivated as a consequence of this release of bearer shall be provided within the Flows AVP. In the AAR, this value indicates that the AF requests the server to provide a notification at the removal of a bearer. The content version corresponding to the affected media component may be provided in the Content-Version AVP included within the Flows AVP.

	Void (5)
	
	IP-CAN_CHANGE (6)
		This value shall be used in RAR command by the PCRF to indicate a change in the IP-CAN type or RAT type (if applicable). When used in an AAR command, this value indicates that the AF is requesting subscription to IP-CAN change and RAT change notification. When used in RAR it indicates that the PCRF generated the request because of an IP-CAN or RAT change. IP-CAN-Type AVP, RAT-Type AVP (if applicable) ,AN-Trusted AVP (if applicable) and AN-GW-Address AVP (if applicable) shall be provided in the same request with the new/valid value(s).
		If an IP-CAN type or RAT type change is due to IP flow mobility and a subset of the flows within the AF session is affected, the affected service data flows shall be provided in the same request.
		If ATSSS feature is supported, and the PDU session is a MA PDU session, the PCF may include the MA-Information AVP in the RAR command with the additional/released IP-CAN type and RAT type (if applicable), with the new/valid values as described in clause E.4.

	INDICATION_OF_OUT_OF_CREDIT (7)
		Within a RAR, this value shall be used when the PCRF reports to the AF that SDFs have run out of credit, and that the termination action indicated by the corresponding Final-Unit-Action AVP applies (3GPP TS 32.240 [23] and 3GPP TS 32.299 [24]. The SDFs that are impacted as a consequence of the out of credit condition shall be provided within the Flows AVP. In the AAR, this value indicates that the AF requests the PCRF to provide a notification of SDFs for which credit is no longer available. Applicable to functionality introduced with the Rel8 feature as described in clause 5.4.1.
	
	INDICATION_OF_SUCCESSFUL_RESOURCES_ALLOCATION (8)
		Within a RAR, this value shall be used by the PCRF to indicate that the resources requested for particular service information have been successfully allocated. The SDFs corresponding to the resources successfully allocated shall be provided within the Flows AVP and the content version within the Content-Version AVP as included when the corresponding media component was provisioned.
		In the AAR, this value indicates that the AF requests the PCRF to provide a notification when the resources associated to the corresponding service information have been allocated.
		Applicable to functionality introduced with the Rel8 feature as described in clause 5.4.1.

	NOTE 3:	This value applies to applications for which the successful resource allocation notification is required for their operation since subscription to this value impacts the resource allocation signalling overhead towards the PCEF/BBERF.

	INDICATION_OF_FAILED_RESOURCES_ALLOCATION (9)
		Within a RAR, this value shall be used by the PCRF to indicate that the resources requested for a particular service information cannot be successfully allocated. The SDFs corresponding to the resources that could not be allocated shall be provided within the Flows AVP. In case of session modification failure, the status of the related service information may be reported in the Media-Component-Status AVP included within the Flows AVP and the content version within the Content-Version AVP as included when the corresponding media component was provisioned.
		In the AAR, this value indicates that the AF requests the PCRF to provide a notification when the resources associated to the corresponding service information cannot be allocated. Applicable to functionality introduced with the Rel8 feature as described in clause 5.4.1.

	NOTE 4:	This value applies to applications for which the unsuccessful resource allocation notification is required for their operation since subscription to this value impacts the resource allocation signalling overhead towards the PCEF/BBERF.

	INDICATION_OF_LIMITED_PCC_DEPLOYMENT (10)
		Within a RAR, this value shall be used when the PCRF reports the limited PCC deployment (i.e. dynamically allocated resources are not applicable) as specified at Annex K and Annex L in 3GPP TS 23.203 [2] to the AF. In the AAR, this value indicates that the AF requests the PCRF to provide a notification for the limited PCC deployment. Applicable to functionality introduced with the Rel8 feature as described in clause 5.4.1.

	USAGE_REPORT (11)
		In the RA-Request (RAR), this value shall be used by the PCRF to report accumulated usage volume and/or time of usage when the usage threshold provided by the AF has been reached.
		In the AA-Request (AAR), this value indicates that the AF requests PCRF to report accumulated usage volume and /or time of usage when it reaches the threshold.
		Applicable to functionality introduced with the SponsoredConnectivity feature for volume usage reporting and with SCTimeBased UM feature for time usage reporting as described in clause 5.4.1.
	
	ACCESS_NETWORK_INFO_REPORT (12)
		In the RA-Request (RAR), this value shall be used by the PCRF to report access network information (i.e.user location and/or user timezone information) when the PCRF receiving an Access Network Information report corresponding to the AF session from the PCEF/BBERF.
		In the AA-Request (AAR), this value indicates that the AF requests PCRF to report one time access network information when the PCRF receives the first Access Network Information report corresponding to the AF session from the PCEF/BBERF after the AF request for the access network information. The required access information is provided within the Required-Access-Info AVP. Applicable to functionality introduced with the NetLoc feature as described in clause 5.4.1.
		The Specific-Action AVP with this value indicates a one time specific action.

	INDICATION_OF_RECOVERY_FROM_LIMITED_PCC_DEPLOYMENT (13)
		Within a RAR, this value shall be used when the PCRF reports the recovery from limited PCC deployment (i.e. the UE moves from the VPLMN to the HPLMN as specified at Annex K in 3GPP TS 23.203 [2]) to the AF. In the AAR, this value indicates that the AF requests the PCRF to provide a notification for the recovery from limited PCC deployment. Applicable to functionality introduced with the Rel8 feature as described in clause 5.4.1.

	NOTE 5:	This value is optional and only applicable to the scenario where PCC is deployed in the HPLMN but	not in the VPLMN and dynamic policy provisioning only occurs in the home routed roaming cases if no BBERF is employed.

	INDICATION_OF_ACCESS_NETWORK_INFO_REPORTING_FAILURE (14)
		In the RAR, this value shall be used when the PCRF reports the access network information reporting failure. When applicable, the NetLoc-Access-Support AVP may be provided as well to indicate the reason for the access network information reporting failure. This specific action does not require to be provisioned by the AF. Applicable to functionality introduced with the NetLoc feature as described in clause 5.4.1.

	INDICATION_OF_TRANSFER_POLICY_EXPIRED (15)
		In the RAR, this value shall be used when the PCRF determines that the transfer policy has expired. This specific action does not require to be provisioned by the AF.
	
	PLMN_CHANGE (16)
		In the AA-Request (AAR), this value indicates that the AF requests PCRF to report changes of PLMN. In the RA-Request (RAR), this value shall be used by the PCRF to indicate that there was a change of PLMN. 3GPP-SGSN-MCC-MNC AVP shall be provided in the same RAR command with the new value and, if available, the NID AVP. Applicable to functionality introduced with the PLMNInfo feature as described in clause 5.4.1.
		The NID AVP is only applicable in 5GS when the serving network is an SNPN, as described in Annex E.

	EPS_FALLBACK (17)
		In the RA-Request (RAR), this value shall be used to report EPS Fallback for the resources requested for a particular service information (media type voice). 
		In the AA-Request (AAR), this value indicates that the AF requests to provide a notification when the access network initiates EPS Fallback for the requested resources associated to service information for voice media type.
		Applicable to functionality introduced with the EPSFallbackReport feature as described in clause 5.4.1.
		This value is only applicable to 5GS as described in Annex E.

	INDICATION_OF_REALLOCATION_OF_CREDIT (18)
		Within a RAR, this value shall be used to report to the AF the SDFs for which credit has been reallocated after the former out of credit indication (3GPP TS 32.240 [23] and 3GPP TS 32.299 [24]). The SDFs that are impacted as a consequence of the reallocation of credit condition shall be provided within the Flows AVP. In the AAR, this value indicates the AF requests to provide a notification of SDFs for which credit has been reallocated after the former out of credit indication. Applicable to functionality introduced with the ReallocationOfCredit feature as described in clause 5.4.1.
		This value is only applicable to 5GS as described in Annex E.

	SUCCESSFUL_QOS_UPDATE (19)
		Within a RAR, this value shall be used by the PCRF to indicate that the QoS of the default bearer has been successfully updated. 
		In the AAR, this value indicates that the AF requests the PCRF to provide a notification when the QoS of the default bearer has been successfully updated.
		Applicable to functionality introduced with the MPSforDTS feature as described in clause 5.4.1.
	
	FAILED_QOS_UPDATE (20)
		Within a RAR, this value shall be used by the PCRF to indicate that the QoS of the default bearer has failed to update. 
		In the AAR, this value indicates that the AF requests the PCRF to provide a notification when the QoS of the default bearer has failed to update.
		Applicable to functionality introduced with the MPSforDTS feature as described in clause 5.4.1.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.SPECIFIC_ACTION, vendorId = VendorIDs.TGPP_ID, name = "Specific-Action")
public interface SpecificAction extends DiameterEnumerated<SpecificActionEnum>
{
}