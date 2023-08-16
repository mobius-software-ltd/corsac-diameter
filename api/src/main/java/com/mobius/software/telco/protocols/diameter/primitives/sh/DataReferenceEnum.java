package com.mobius.software.telco.protocols.diameter.primitives.sh;

import java.util.HashMap;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.primitives.IntegerEnum;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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
/**
*
* @author yulian oifa
*
*/

/*
 * 6.3.4 Data-Reference AVP
	The Data-Reference AVP is of type Enumerated, and indicates the type of the requested user data in the operation UDR
	and SNR. Its exact values and meaning is defined in 3GPP TS 29.328 [1]. The following values are defined (more
	details are given in 3GPP TS 29.328 [1]):

	RepositoryData (0)
	IMSPublicIdentity (10)
	IMSUserState (11)
	S-CSCFName (12)
	InitialFilterCriteria (13)
		This value is used to request initial filter criteria relevant to the requesting AS
	
	LocationInformation (14)
	UserState (15)
	ChargingInformation (16)
	MSISDN (17)
	PSIActivation (18)
	DSAI (19)
	ServiceLevelTraceInfo (21)
	IPAddressSecureBindingInformation (22)
	ServicePriorityLevel (23)
	SMSRegistrationInfo (24)
	UEReachabilityForIP (25)
	TADSinformation (26)
	STN-SR (27)
	UE-SRVCC-Capability (28)
	ExtendedPriority (29)
	CSRN (30)
	ReferenceLocationInformation (31)
	IMSI (32)
	IMSPrivateUserIdentity (33)
	IMEISV (34)
	UE-5G-SRVCC-Capability (35)
	
	NOTE: Value 20 is reserved. 
 */
public enum DataReferenceEnum implements IntegerEnum
{
	REPOSITORY_DATA(0),IMS_PUBLIC_IDENTITY(10),IMS_USER_STATE(11),SCSCF_NAME(12),INITIAL_FILTER_CRITERIA(13),
	LOCATION_INFORMATION(14),USER_STATE(15),CHARGING_INFORMATION(16),MSISDN(17),PSI_ACTIVATION(18),DSAI(19),
	SERVICE_LEVEL_TRACE_INFO(21),IP_ADDRESS_SECURE_BINDING_INFORMATION(22),SERVICE_PRIORITY_LEVEL(23),
	SMS_REGISTRATION_INFO(24),UE_REACHABILITY_FOR_IP(25),TADS_INFORMATION(26),STN_SR(27),UE_SERVCC_CAPABILITY(28),
	EXTENDED_PRIORITY(29),CSRN(30),REFERENCE_LOCATION_INFORMATION(31),IMSI(32),IMS_PRIVATE_USER_IDENTITY(33),
	IMEISV(34),UE_5G_SRVCC_CAPABILITY(35);

	private static final Map<Integer, DataReferenceEnum> intToTypeMap = new HashMap<Integer, DataReferenceEnum>();
	static
	{
	    for (DataReferenceEnum type : DataReferenceEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static DataReferenceEnum fromInt(Integer value) 
	{
		DataReferenceEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private DataReferenceEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
