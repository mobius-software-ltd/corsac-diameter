package com.mobius.software.telco.protocols.diameter.primitives.accounting;
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

import com.mobius.software.telco.protocols.diameter.TgppAvpCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.CNIPMulticastDistributionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMS2G3GIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSServiceTypeEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.99	MBMS-Information AVP
	The MBMS-Information AVP (AVP code 880) is of type Grouped. Its purpose is to allow the transmission of additional MBMS service specific information elements. 
	It has the following ABNF grammar:

	MBMS-Information :: = 	< AVP Header: 880>
				[ TMGI ]
				[ MBMS-Service-Type ]
				[ MBMS-User-Service-Type ]
				[ File-Repair-Supported ]
				[ Required-MBMS-Bearer-Capabilities ]
				[ MBMS-2G-3G-Indicator ]
				[ RAI ]
 			* 	[ MBMS-Service-Area ]
				[ MBMS-Session-Identity ]
				[ CN-IP-Multicast-Distribution ]
				[ MBMS-GW-Address ]
				[ MBMS-Charged-Party ]
 			* 	[ MSISDN ]
				[ MBMS-Data-Transfer-Start ]
				[ MBMS-Data-Transfer-Stop ]
 */
@DiameterAvpDefinition(code = TgppAvpCodes.MBMS_INFORMATION, vendorId = VendorIDs.TGPP_ID, name = "MBMS-Information")
public interface MBMSInformation extends DiameterAvp
{
	ByteBuf getTMGI();
	
	void setTMGI(ByteBuf value);
	
	MBMSServiceTypeEnum getMBMSServiceType();
	
	void setMBMSServiceType(MBMSServiceTypeEnum value);
	
	MBMSUserServiceTypeEnum getMBMSUserServiceType();
	
	void setMBMSUserServiceType(MBMSUserServiceTypeEnum value);
	
	FileRepairSupportedEnum getFileRepairSupported();
	
	void setFileRepairSupported(FileRepairSupportedEnum value);
	
	String getRequiredMBMSBearerCapabilities();
	
	void setRequiredMBMSBearerCapabilities(String value);
	
	MBMS2G3GIndicatorEnum getMBMS2G3GIndicator();
	
	void setMBMS2G3GIndicator(MBMS2G3GIndicatorEnum value);
	
	String getRAI();
	
	void setRAI(String value);
	
	List<ByteBuf> getMBMSServiceArea();
	
	void setMBMSServiceArea(List<ByteBuf> value);
	
	ByteBuf getMBMSSessionIdentity();
	
	void setMBMSSessionIdentity(ByteBuf value);
	
	CNIPMulticastDistributionEnum getCNIPMulticastDistribution();
	
	void setCNIPMulticastDistribution(CNIPMulticastDistributionEnum value);
	
	InetAddress getMBMSGWAddress();
	
	void setMBMSGWAddress(InetAddress value);
	
	MBMSChargedPartyEnum getMBMSChargedParty();
	
	void setMBMSChargedParty(MBMSChargedPartyEnum value);
	
	List<String> getMSISDN();
	
	void setMSISDN(List<String> value);
	
	Long getMBMSDataTransferStart();
	
	void setMBMSDataTransferStart(Long value);
	
	Long getMBMSDataTransferStop();
	
	void setMBMSDataTransferStop(Long value);
}