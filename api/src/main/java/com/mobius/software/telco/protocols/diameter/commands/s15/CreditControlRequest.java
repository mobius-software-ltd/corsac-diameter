package com.mobius.software.telco.protocols.diameter.commands.s15;

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

import java.net.InetAddress;
import java.util.List;
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.commons.AuthenticationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceQoSRequestIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s15.CSServiceQoSRequestOperationEnum;


/*E.6.6.2	CC-Request (CCR) Command
The CCR command, indicated by the Command-Code field set to 272 and the 'R' bit set in the Command Flags field, is sent by the HNB GW to the PCRF in order to initiate an S15 session establishment or request resource for the CS service. The CCR command is also sent by the HNB GW to the PCRF in order to indicate the termination of the S15 session.
Message Format:
<CC-Request> ::= < Diameter Header: 272, REQ, PXY >
				 < Session-Id >
				 [ DRMP ]
				 { Auth-Application-Id }
				 { Origin-Host }
				 { Origin-Realm }
                 { Destination-Realm }
                 { CC-Request-Type }
                 { CC-Request-Number }
                 [ OC-Supported-Features ]
                 [ CS-Service-QoS-Request-Identifier ]
                 [ CS-Service-QoS-Request-Operation ]
                 [ Destination-Host ]
                 [ HeNB-Local-IP-Address ]
                 [ Origin-State-Id ]
                 [ QoS-Information ]
                 [ UDP-Source-Port ]
                *[ Proxy-Info ]
                *[ Route-Record ] 
                *[ AVP ]
*/

@DiameterCommandDefinition(applicationId = ApplicationIDs.S15, commandCode = CommandCodes.CREDIT_CONTROL, request = true, proxyable = true, name="Credit-Control-Request")
public interface CreditControlRequest extends AuthenticationRequest
{
    DRMPEnum getDRMP();
	
	void setDRMP(DRMPEnum value);
	
    CcRequestTypeEnum getCcRequestType();
	
	void setCcRequestType(CcRequestTypeEnum value) throws MissingAvpException;
	
	Long getCcRequestNumber();
	
	void setCcRequestNumber(Long value) throws MissingAvpException;

	OCSupportedFeatures getOCSupportedFeatures();
	
	void setOCSupportedFeatures(OCSupportedFeatures value);
	
    List<CSServiceQoSRequestIdentifier> getCSServiceQoSRequestIdentifier();
	
	void setCSServiceQoSRequestIdentifier(List<CSServiceQoSRequestIdentifier> value);
	
	CSServiceQoSRequestOperationEnum getCSServiceQoSRequestOperation();
	
	void setCSServiceQoSRequestOperation(CSServiceQoSRequestOperationEnum value);

	InetAddress getHeNBLocalIPAddress();
	
	void setHeNBLocalIPAddress(InetAddress value);
	
    public QoSInformation getQoSInformation();
	
	void setQoSInformation(QoSInformation value);

	Long getUDPSourcePort();
	
	void setUDPSourcePort(Long value);	
}

