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

/**
*
* @author yulian oifa
*
*/

public class CommandCodes
{
	public static final int CAPABILITIES_EXCHANGE = 257;
	public static final int REAUTH = 258;
	public static final int AA_MOBILE_NODE = 260;
	public static final int HOME_AGENT_MIP = 262;
	public static final int AAA = 265;
	public static final int EAP = 268;
	public static final int ACCOUNTING = 271;
	public static final int CREDIT_CONTROL = 272;
	public static final int ABORT_SESSION = 274;
	public static final int SESSION_TERMINATION = 275;
	public static final int DEVICE_WATCHDOG = 280;	
	public static final int DISCONNECT_PEER = 282;
	public static final int USER_AUTHORIZATION = 300;
	public static final int SERVER_ASSIGNMENT = 301;
	public static final int LOCATION_INFO = 302;
	public static final int MULTIMEDIA_AUTH = 303;
	public static final int REGISTRATION_TERMINATION = 304;
	public static final int PUSH_PROFILE = 305;
	public static final int USER_DATA = 306;
	public static final int PROFILE_UPDATE = 307;
	public static final int SUBSCRIBE_NOTIFICATION = 308;
	public static final int PUSH_NOTIFICATION = 309;
	public static final int MESSAGE_PROCESS = 311;
	public static final int UPDATE_LOCATION = 316;
	public static final int CANCEL_LOCATION = 317;
	public static final int AUTHENTICATION = 318;
	public static final int INSERT_SUBSCRIBER_DATA = 319;
	public static final int DELETE_SUBSCRIBER_DATA = 320;
	public static final int PURGE_UE = 321;
	public static final int RESET = 322;
	public static final int NOTIFY = 323;
	public static final int ME_IDENTITY_CHECK = 324;
	public static final int MIP6 = 325;
		
	public static final int PROVIDE_LOCATION = 8388620;
	public static final int LOCATION_REPORT = 8388621;
	public static final int LCS_ROUTING_INFO = 8388622;
	public static final int TSSF_NOTIFCATION = 8388731;
	public static final int SPENDING_LIMIT = 8388635;	
	public static final int SPENDING_STATUS = 8388636;	
	public static final int TDF_SESSION = 8388637;
	public static final int UPDATE_VCSG_LOCATION = 8388638;
	public static final int DEVICE_ACTION = 8388639;
	public static final int DEVICE_NOTIFICATION = 8388640;
	public static final int SUBSCRIBER_INFORMATION = 8388641;
	public static final int CANCEL_VCSG_LOCATION = 8388642;
	public static final int DEVICE_TRIGGER = 8388643;
	public static final int DELIVERY_REPORT = 8388644;
	public static final int MO_FORWARD_SHORT_MESSAGE = 8388645;
	public static final int MT_FORWARD_SHORT_MESSAGE = 8388646;
	public static final int SEND_ROUTING_INFO_FOR_SM = 8388647;
	public static final int ALERT_SERVICE_CENTRE = 8388648;
	public static final int REPORT_SM_DELIVERY_STATUS = 8388649;
	public static final int TRIGGER_ESTABLIHMENT = 8388656;
	public static final int GCS_ACTION = 8388662;
	public static final int GCS_NOTIFICATION = 8388663;	
	public static final int PROSE_SUBSCRIBER_INFORMATION = 8388664;	
	public static final int UPDATE_PROSE_SUBSCRIBER_DATA = 8388665;	
	public static final int PROSE_NOTIFY = 8388666;	
	public static final int PROSE_AUTHORiZATION = 8388668;	
	public static final int PROSE_DISCOVERY = 8388669;	
	public static final int PROSE_MATCH = 8388670;	
	public static final int PROSE_MATCH_REPORT_INFO = 8388671;	
	public static final int PROSE_PROXIMITY = 8388672;	
	public static final int PROSE_LOCATION_UPDATE = 8388673;	
	public static final int PROSE_ALERT = 8388674;	
	public static final int PROSE_CANCELLATION = 8388675;	
	public static final int PROXIMITY_ACTION = 8388676;
	public static final int PROSE_INTIIAL_LOCATION_INFORMATION = 8388713;	
	public static final int CONFIGURATION_INFORMATION = 8388718;
	public static final int REPORTING_INFORMATION = 8388719;
	public static final int NON_AGGREGATED_RUCI_REPORT = 8388720;
	public static final int AGGREGATED_RUCI_REPORT = 8388721;
	public static final int MODIFY_UE_CONTEXT = 8388722;
	public static final int BACKGROUND_DATA_TRANSFER = 8388723;
	public static final int NIDD_INFORMATION = 8388726;
	public static final int PROXIMITY_APPLICATION = 8388727;
	public static final int CONNECTION_MANAGEMENT = 8388732;
	public static final int MO_DATA = 8388733;
	public static final int MT_DATA = 8388734;
	public static final int EVENT_CONFIGURATION = 8388735;
	public static final int EVENT_REPORTING = 8388736;
	
	public static final int CHARGING_INTERROGATION = 16777214;
}
