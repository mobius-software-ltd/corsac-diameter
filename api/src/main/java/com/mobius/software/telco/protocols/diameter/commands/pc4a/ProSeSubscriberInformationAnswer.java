package com.mobius.software.telco.protocols.diameter.commands.pc4a;
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

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc4a.ProSeSubscriptionData;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	6.2.4	ProSe-Subscriber-Information-Answer (PIA) Command
	The ProSe-Subscriber-Information-Answer (PIA) command, indicated by the Command-Code field set to 8388664 and the "R" bit cleared in the Command Flags field, is sent from the HSS to the ProSe Function. 
	Message Format

	< ProSe-Subscriber-Information-Answer > ::=	< Diameter Header: 8388664, PXY, 16777336 >
			 < Session-Id >
			 [ DRMP ] 
			 [ Vendor-Specific-Application-Id ]
			 [ Result-Code ]
			 [ Experimental-Result ]
			 { Auth-Session-State }
			 { Origin-Host }
			 { Origin-Realm }
			 [ ProSe-Subscription-Data ]
			 [ MSISDN ]
			 [ Visited-PLMN-Id ]
			*[ Supported-Features ]
			 [ OC-Supported-Features ]
			 [ OC-OLR ]
			*[ Load ]
			*[ AVP ]
			*[ Reset-ID ]
			 [ Failed-AVP ]
			*[ Proxy-Info ]
			*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.PC4A, commandCode = CommandCodes.PROSE_SUBSCRIBER_INFORMATION, request = false, proxyable = true, name="ProSe-Subscriber-Information-Answer")
public interface ProSeSubscriberInformationAnswer extends Pc4aAnswer
{
	public AuthSessionStateEnum getAuthSessionState();
	
	void setAuthSessionState(AuthSessionStateEnum value) throws MissingAvpException;

	ProSeSubscriptionData getProSeSubscriptionData();
	 
	void setProSeSubscriptionData(ProSeSubscriptionData value);
	 		
	String getMSISDN();
	 
	void setMSISDN(String value);
	 		
	ByteBuf getVisitedPLMNId();
	
	void setVisitedPLMNId(ByteBuf value);
	
	public OCSupportedFeatures getOCSupportedFeatures();
	 
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);
	
	List<Load> getLoad();
	 
	void setLoad(List<Load> value);

	List<ByteBuf> getResetID();
	 
	void setResetID(List<ByteBuf> value);
}