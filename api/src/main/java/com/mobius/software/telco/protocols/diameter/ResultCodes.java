package com.mobius.software.telco.protocols.diameter;
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

public class ResultCodes
{
	public static final long DIAMETER_MULTI_ROUND_AUTH = 1001L;
	
	public static final long DIAMETER_SUCCESS = 2001L;
	public static final long DIAMETER_LIMITED_SUCCESS = 2002L;

	public static final long DIAMETER_COMMAND_UNSUPPORTED = 3001L;
	public static final long DIAMETER_UNABLE_TO_DELIVER = 3002L;
	public static final long DIAMETER_REALM_NOT_SERVED = 3003L;
	public static final long DIAMETER_TOO_BUSY = 3004L;
	public static final long DIAMETER_LOOP_DETECTED = 3005L;
	public static final long DIAMETER_REDIRECT_INDICATION = 3006L;
	public static final long DIAMETER_APPLICATION_UNSUPPORTED = 3007L;
	public static final long DIAMETER_INVALID_HDR_BITS = 3008L;
	public static final long DIAMETER_INVALID_AVP_BITS = 3009L;
	public static final long DIAMETER_UNKNOWN_PEER = 3010L;
	
	public static final long DIAMETER_AUTHENTICATION_REJECTED = 4001L;
	public static final long DIAMETER_OUT_OF_SPACE = 4002L;
	public static final long ELECTION_LOST = 4003L;
	
	public static final long DIAMETER_AVP_UNSUPPORTED = 5001L;
	public static final long DIAMETER_UNKNOWN_SESSION_ID = 5002L;
	public static final long DIAMETER_AUTHORIZATION_REJECTED = 5003L;
	public static final long DIAMETER_INVALID_AVP_VALUE = 5004L;
	public static final long DIAMETER_MISSING_AVP = 5005L;
	public static final long DIAMETER_RESOURCES_EXCEEDED = 5006L;
	public static final long DIAMETER_CONTRADICTING_AVPS = 5007L;
	public static final long DIAMETER_AVP_NOT_ALLOWED = 5008L;
	public static final long DIAMETER_AVP_OCCURS_TOO_MANY_TIMES = 5009L;
	public static final long DIAMETER_NO_COMMON_APPLICATION = 5010L;
	public static final long DIAMETER_UNSUPPORTED_VERSION = 5011L;
	public static final long DIAMETER_UNABLE_TO_COMPLY = 5012L;
	public static final long DIAMETER_INVALID_BIT_IN_HEADER = 5013L;
	public static final long DIAMETER_INVALID_AVP_LENGTH = 5014L;
	public static final long DIAMETER_INVALID_MESSAGE_LENGTH = 5015L;
	public static final long DIAMETER_INVALID_AVP_BIT_COMBO = 5016L;
	public static final long DIAMETER_NO_COMMON_SECURITY = 5017L;	
	
	//application specific codes
	public static final long DIAMETER_SESSION_TIMEOUT = -1000L;	
	public static final long DIAMETER_REQUEST_TIMEOUT = -1001L;		
}