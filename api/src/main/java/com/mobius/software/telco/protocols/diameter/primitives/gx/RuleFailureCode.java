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
 * 	5.3.38 Rule-Failure-Code AVP (All access types)
	The Rule-Failure-Code AVP (AVP code 1031) is of type Enumerated. It is sent by the PCEF to the PCRF within a
	Charging-Rule-Report AVP to identify the reason a PCC Rule is being reported.
	The following values are defined:

	UNKNOWN_RULE_NAME (1)
		This value is used to indicate that the pre-provisioned PCC rule could not be successfully activated because the
		Charging-Rule-Name or Charging-Rule-Base-Name is unknown to the PCEF.
	RATING_GROUP_ERROR (2)
 		This value is used to indicate that the PCC rule could not be successfully installed or enforced because the
		Rating-Group specified within the Charging-Rule-Definition AVP by the PCRF is unknown or, invalid.
	SERVICE_IDENTIFIER_ERROR (3)
 		This value is used to indicate that the PCC rule could not be successfully installed or enforced because the
		Service-Identifier specified within the Charging-Rule-Definition AVP by the PCRF is invalid, unknown, or not
		applicable to the service being charged.
	GW/PCEF_MALFUNCTION (4)
 		This value is used to indicate that the PCC rule could not be successfully installed (for those provisioned from
		the PCRF) or activated (for those pre-provisioned in PCEF) or enforced (for those already successfully installed)
		due to GW/PCEF malfunction.
	RESOURCES_LIMITATION (5)
 		This value is used to indicate that the PCC rule could not be successfully installed (for those provisioned from
		PCRF) or activated (for those pre-provisioned in PCEF) or enforced (for those already successfully installed) due
		to a limitation of resources at the PCEF.
	MAX_NR_BEARERS_REACHED (6)
 		This value is used to indicate that the PCC rule could not be successfully installed (for those provisioned from
		PCRF) or activated (for those pre-provisioned in PCEF) or enforced (for those already successfully installed) due
		to the fact that the maximum number of bearers has been reached for the IP-CAN session.
	UNKNOWN_BEARER_ID (7)
 		This value is used to indicate that the PCC rule could not be successfully installed or enforced at the PCEF
		because the Bearer-Id specified within the Charging-Rule-Install AVP by the PCRF is unknown or invalid.
		Applicable only for GPRS in the case the PCRF performs the bearer binding.
	MISSING_BEARER_ID (8)
 		This value is used to indicate that the PCC rule could not be successfully installed or enforced at the PCEF
		because the Bearer-Id is not specified within the Charging-Rule-Install AVP by the PCRF. Applicable only for
		GPRS in the case the PCRF performs the bearer binding.
	MISSING_FLOW_INFORMATION (9)
 		This value is used to indicate that the PCC rule could not be successfully installed or enforced because neither
		the Flow-Information AVP nor TDF-Application-Identifier AVP is specified within the Charging-RuleDefinition AVP by the PCRF during the first install request of the PCC rule. 
	RESOURCE_ALLOCATION_FAILURE (10)
 		This value is used to indicate that the PCC rule could not be successfully installed or maintained since the bearer
		establishment/modification failed, or the bearer was released.
	UNSUCCESSFUL_QOS_VALIDATION (11)
 		This value is used to:
			- indicate that the QoS validation has failed or,
			- Indicate when Guaranteed Bandwidth > Max-Requested-Bandwidth.
	INCORRECT_FLOW_INFORMATION (12)
		This value is used to indicate that the PCC rule could not be successfully installed or modified at the PCEF
		because the provided flow information is not supported by the network (e.g. the provided IP address(es) or Ipv6
		prefix(es) do not correspond to an IP version applicable for the IP-CAN session).
	PS_TO_CS_HANDOVER (13)
 		This value is used to indicate that the PCC rule could not be maintained because of PS to CS handover. This
		value is only applicable for 3GPP-GPRS and 3GPP-EPS. Applicable to functionality introduced with the Rel9
		feature as described in subclause 5.4.1.
	TDF_APPLICATION_IDENTIFIER_ERROR (14)
 		This value is used to indicate that the rule could not be successfully installed or enforced because the TDFApplication-Identifier is invalid, unknown, or not applicable to the application required for detection.
	NO_BEARER_BOUND (15)
 		This value is used to indicate that there is no IP-CAN bearer which the PCEF can bind the PCC rule(s) to.
	FILTER_RESTRICTIONS (16)
 		This value is used to indicate that the Flow-Description AVP(s) cannot be handled by the PCEF because any of
		the restrictions specified in subclause 5.4.2 was not met.
	AN_GW_FAILED (17)
 		This value is used to indicate that the AN-Gateway has failed and that the PCRF should refrain from sending
		policy decisions to the PCEF until it is informed that the S-GW has been recovered. This value shall not be used
		if the IP-CAN Session Modification procedure is initiated for PCC rule removal only.
	MISSING_REDIRECT_SERVER_ADDRESS (18)
 		This value is used to indicate that the PCC rule could not be successfully installed or enforced at the PCEF
		because there is no valid Redirect_Server_Address within the Redirect-Server-Address AVP provided by the
		PCRF and no preconfigured redirection address for this PCC rule at the PCEF.
	CM_END_USER_SERVICE_DENIED (19)
 		This value is used to indicate that the charging system denied the service request due to service restrictions (e.g.
		terminate rating group) or limitations related to the end-user, for example the end-user's account could not cover
		the requested service. When used over Sd reference point, it is applicable to functionality introduced with the
		ABC feature as described in subclause 5b.4.1.
	CM_CREDIT_CONTROL_NOT_APPLICABLE (20)
 		This value is used to indicate that the charging system determined that the service can be granted to the end user
		but no further credit control is needed for the service (e.g. service is free of charge or is treated for offline
		charging). When used over Sd reference point, it is applicable to functionality introduced with the ABC feature
		as described in subclause 5b.4.1.
	CM_AUTHORIZATION_REJECTED (21)
 		This value is used to indicate that the charging system denied the service request in order to terminate the service
		for which credit is requested. When used over Sd reference point, it is applicable to functionality introduced with
		the ABC feature as described in subclause 5b.4.1.
	CM_USER_UNKNOWN (22)
 		This value is used to indicate that the specified end user could not be found in the charging system. When used
		over Sd reference point, it is applicable to functionality introduced with the ABC feature as described in
		subclause 5b.4.1. 
	CM_RATING_FAILED (23)
 		This value is used to inform the PCRF that the charging system cannot rate the service request due to insufficient
		rating input, incorrect AVP combination or due to an AVP or an AVP value that is not recognized or supported
		in the rating. When used over Sd reference point, it is applicable to functionality introduced with the ABC
		feature as described in subclause 5b.4.1.
	ROUTING_RULE_REJECTION (24)
 		This value is used to inform the PCRF that the PCC rule cannot be enforced due to the corresponding NBIFOM
		routing rule is rejected by the UE because of the unspecified reason. Applicable to functionality introduced with
		the NBIFOM feature as described in subclause 5.4.1.
	UNKNOWN_ROUTING_ACCESS_INFORMATION (25)
 		This value is used to inform the PCRF that the PCC rule cannot be enforced due to the corresponding NBIFOM
		routing rule is rejected by the UE because of the access information indicated in the PCC rule is unknown for the
		UE. Applicable to functionality introduced with the NBIFOM feature as described in subclause 5.4.1.
	NO_NBIFOM_SUPPORT (26)
 		This value is used to inform the PCRF that the PCEF has discovered that NBIFOM is not supported. Applicable
		to functionality introduced with the NBIFOM feature as described in subclause 5.4.1.
	UE_STATE_SUSPEND (27)
 		This value is used to inform the PCRF that the PCEF has discovered that the UE is in suspend state. Applicable
		to functionality introduced with the UE-Status-Change feature as described in subclause 5.4.1.
	TRAFFIC_STEERING_ERROR (28)
 		This value is used to inform the PCRF that the steering of traffic to the Gi-LAN failed, or the dynamic PCC rule
		could not be successfully installed because e.g. the provided traffic steering identifier(s) are invalid. Applicable
		when the functionality introduced with the TSC feature described in subclause 5.4.1 applies, and, when used
		over Sd reference point, when the TSC feature as described in subclause 5b.4.1 applies.
	SAME_TIME_ERROR (29)
 		This value is used to inform the PCRF that the the PCC rule cannot be enforced because the Rule-ActivationTime and Rule-Deactivation-Time are specified with the same time.
 */
@DiameterAvpDefinition(code = TgppAvpCodes.RULE_FAILURE_CODE, vendorId = VendorIDs.TGPP_ID, name = "Rule-Failure-Code")
public interface RuleFailureCode extends DiameterEnumerated<RuleFailureCodeEnum>
{
}