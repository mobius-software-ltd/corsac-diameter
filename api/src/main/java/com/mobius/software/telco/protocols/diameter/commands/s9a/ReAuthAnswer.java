package com.mobius.software.telco.protocols.diameter.commands.s9a;
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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

/**
*
* @author yulian oifa
*
*/

/*
 * 	A.7.6.5	Re-Authorization-Answer (RAA) Command
	The RAA command, indicated by the Command-Code field set to 258 and the 'R' bit cleared in the Command Flags field, is sent by the BPCF to the PCRF in response to the RAR command.
	Message Format:

	<RA-Answer> ::=  < Diameter Header: 258, PXY >
                < Session-Id >
                [ DRMP ]
                { Origin-Host }
                { Origin-Realm }
                [ Result-Code ]
                [ Experimental-Result ]
                [ Origin-State-Id ]
                [ OC-Supported-Features ]
                [ OC-OLR ]
                [ QoS-Information ]
               *[ QoS-Rule-Report ]
                [ Error-Message ]
                [ Error-Reporting-Host ]
                [ Failed-AVP ]
               *[ Proxy-Info ]
               *[ Load ]
               *[ AVP ]
 */
@DiameterCommandDefinition(applicationId = ApplicationIDs.S9A, commandCode = CommandCodes.REAUTH, request = false, proxyable = true, name="Re-Auth-Answer")
public interface ReAuthAnswer extends com.mobius.software.telco.protocols.diameter.commands.commons.ReAuthAnswer
{
	DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
	OCOLR getOCOLR();
	 
	void setOCOLR(OCOLR value);		
	
	public QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);
	
	List<QoSRuleReport> getQoSRuleReport();
	
	void setQoSRuleReport(List<QoSRuleReport> value);
	
	List<Load> getLoad();
	
	void setLoad(List<Load> value);			
}