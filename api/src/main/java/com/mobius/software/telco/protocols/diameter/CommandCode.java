package com.mobius.software.telco.protocols.diameter;

import java.util.HashMap;
import java.util.Map;

/*
 * Mobius Software LTD), Open Source Cloud Communications
 * Copyright 2023), Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation), either version 3 of
 * the License), or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful),
 * but WITHOUT ANY WARRANTY), without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not), see <http://www.gnu.org/licenses/>
 */

/**
*
* @author yulian oifa
*
*/

public enum CommandCode
{
	CAPABILITIES_EXCHANGE(257),
	REAUTH(258),
	AA_MOBILE_NODE(260),
	HOME_AGENT_MIP(262),
	AAA(265),
	EAP(268),
	ACCOUNTING(271),
	CREDIT_CONTROL(272),
	ABORT_SESSION(274),
	SESSION_TERMINATION(275),
	DEVICE_WATCHDOG(280),	
	DISCONNECT_PEER(282),
	USER_AUTHORIZATION(300),
	SERVER_ASSIGNMENT(301),
	LOCATION_INFO(302),
	MULTIMEDIA_AUTH(303),
	REGISTRATION_TERMINATION(304),
	PUSH_PROFILE(305),
	USER_DATA(306),
	PROFILE_UPDATE(307),
	SUBSCRIBE_NOTIFICATION(308),
	PUSH_NOTIFICATION(309),
	MESSAGE_PROCESS(311),
	UPDATE_LOCATION(316),
	CANCEL_LOCATION(317),
	AUTHENTICATION(318),
	INSERT_SUBSCRIBER_DATA(319),
	DELETE_SUBSCRIBER_DATA(320),
	PURGE_UE(321),
	RESET(322),
	NOTIFY(323),
	ME_IDENTITY_CHECK(324),
	MIP6(325),
	
	PROVIDE_LOCATION(8388620),
	LOCATION_REPORT(8388621),
	LCS_ROUTING_INFO(8388622),
	TSSF_NOTIFCATION(8388731),
	SPENDING_LIMIT(8388635),	
	SPENDING_STATUS(8388636),	
	TDF_SESSION(8388637),
	UPDATE_VCSG_LOCATION(8388638),
	DEVICE_ACTION(8388639),
	DEVICE_NOTIFICATION(8388640),
	SUBSCRIBER_INFORMATION(8388641),
	CANCEL_VCSG_LOCATION(8388642),
	DEVICE_TRIGGER(8388643),
	DELIVERY_REPORT(8388644),
	MO_FORWARD_SHORT_MESSAGE(8388645),
	MT_FORWARD_SHORT_MESSAGE(8388646),
	SEND_ROUTING_INFO_FOR_SM(8388647),
	ALERT_SERVICE_CENTRE(8388648),
	REPORT_SM_DELIVERY_STATUS(8388649),
	TRIGGER_ESTABLIHMENT(8388656),
	GCS_ACTION(8388662),
	GCS_NOTIFICATION(8388663),	
	PROSE_SUBSCRIBER_INFORMATION(8388664),	
	UPDATE_PROSE_SUBSCRIBER_DATA(8388665),	
	PROSE_NOTIFY(8388666),	
	PROSE_AUTHORiZATION(8388668),	
	PROSE_DISCOVERY(8388669),	
	PROSE_MATCH(8388670),	
	PROSE_MATCH_REPORT_INFO(8388671),	
	PROSE_PROXIMITY(8388672),	
	PROSE_LOCATION_UPDATE(8388673),	
	PROSE_ALERT(8388674),	
	PROSE_CANCELLATION(8388675),	
	PROXIMITY_ACTION(8388676),
	PROSE_INTIIAL_LOCATION_INFORMATION(8388713),	
	CONFIGURATION_INFORMATION(8388718),
	REPORTING_INFORMATION(8388719),
	NON_AGGREGATED_RUCI_REPORT(8388720),
	AGGREGATED_RUCI_REPORT(8388721),
	MODIFY_UE_CONTEXT(8388722),
	BACKGROUND_DATA_TRANSFER(8388723),
	NIDD_INFORMATION(8388726),
	PROXIMITY_APPLICATION(8388727),
	CONNECTION_MANAGEMENT(8388732),
	MO_DATA(8388733),
	MT_DATA(8388734),
	EVENT_CONFIGURATION(8388735),
	EVENT_REPORTING(8388736),
	
	CHARGING_INTERROGATION(16777214);
	
	private static final Map<Integer, CommandCode> intToTypeMap = new HashMap<Integer, CommandCode>();
	static 
	{
	    for (CommandCode type : CommandCode.values()) 
	    {
	        intToTypeMap.put(type.value, type);
	    }
	}
	
	public static CommandCode fromInt(int i) 
	{
		return intToTypeMap.get(Integer.valueOf(i));	    
	}
	
	private int value;
	
	private CommandCode(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
