package com.mobius.software.telco.protocols.diameter.commands.slg;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.slg.AccuracyFulfilmentIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ESMLCCellInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.GERANPositioningInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slg.UTRANPositioningInfo;
import com.mobius.software.telco.protocols.diameter.primitives.slh.ServingNode;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.3.2	Provide-Location-Answer (PLA) Command
	The Provide-Location-Answer (PLA) command, indicated by the Command-Code field set to 8388620 and the 'R' bit cleared in the Command Flags field, is sent by the MME or SGSN to the GMLC in response to the Provide-Location-Request command.
	Message Format
	
	< Provide-Location-Answer > ::=	< Diameter Header: 8388620, PXY, 16777255 >
					 < Session-Id >
					 [ DRMP ]
					 [ Vendor-Specific-Application-Id ]
					 [ Result-Code ]
					 [ Experimental-Result ]
					 { Auth-Session-State }
					 { Origin-Host }
					 { Origin-Realm }
					 [ Location-Estimate ]
					 [ Accuracy-Fulfilment-Indicator ]
					 [ Age-Of-Location-Estimate]
					 [ Velocity-Estimate ]
					 [ EUTRAN-Positioning-Data]
					 [ ECGI ]
					 [ GERAN-Positioning-Info ]
					 [ Cell-Global-Identity ]
					 [ UTRAN-Positioning-Info ]
					 [ Service-Area-Identity ]
					 [ Serving-Node ]
					 [ PLA-Flags ]
					 [ ESMLC-Cell-Info ]
					 [ Civic-Address ]
					 [ Barometric-Pressure ]
					*[ Supported-Features ]
					*[ AVP ]
					 [ Failed-AVP ]
					*[ Proxy-Info ]
					*[ Route-Record ]
 */
@DiameterCommandDefinition(applicationId = 16777255, commandCode = 8388620, request = false, proxyable = true, name="Provide-Location-Answer")
public interface ProvideLocationAnswer extends SlgAnswer
{
	ByteBuf getLocationEstimate();
	 
	void setLocationEstimate(ByteBuf value);
	
	AccuracyFulfilmentIndicatorEnum getAccuracyFulfilmentIndicator();
	 
	void setAccuracyFulfilmentIndicator(AccuracyFulfilmentIndicatorEnum value);
	 		
	Long getAgeOfLocationEstimate();
	 
	void setAgeOfLocationEstimate(Long value);
	
	ByteBuf getVelocityEstimate();
	 
	void setVelocityEstimate(ByteBuf value);
	 		
	ByteBuf getEUTRANPositioningData();
	
	void setEUTRANPositioningData(ByteBuf value);
	
	ByteBuf getECGI();
	 
	void setECGI(ByteBuf value);
		
	GERANPositioningInfo getGERANPositioningInfo();
	 
	void setGERANPositioningInfo(GERANPositioningInfo value);
	
	ByteBuf getCellGlobalIdentity();
	 
	void setCellGlobalIdentity(ByteBuf value);
	
	UTRANPositioningInfo getUTRANPositioningInfo();
	 
	void setUTRANPositioningInfo(UTRANPositioningInfo value);
	
	ByteBuf getServiceAreaIdentity();
	 
	void setServiceAreaIdentity(ByteBuf value);
	
	ServingNode getServingNode();
	 
	void setServingNode(ServingNode value);
	
	Long getPLAFlags();
	 
	void setPLAFlags(Long value);
	
	ESMLCCellInfo getESMLCCellInfo();
	 
	void setESMLCCellInfo(ESMLCCellInfo value);
	
	String getCivicAddress();
	 
	void setCivicAddress(String value);
	
	Long getBarometricPressure();
	 
	void setBarometricPressure(Long value);
}