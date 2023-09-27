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

import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpDefinition;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.1A	Access-Transfer-Information AVP
	The Access-Transfer-Information AVP (AVP code 2709) is of type Grouped and provides information on access transfer for IMS service continuity.
	It has the following ABNF grammar:
    
	Access-Transfer-Information :: =  < AVP Header: 2709>
				[ Access-Transfer-Type ]
		    *	[ Access-Network-Information ] 
				[ Cellular-Network-Information ]
				[ Inter-UE-Transfer ]
				[ User-Equipment-Info ]
				[ Instance-Id ]
				[ Related-IMS-Charging-Identifier ]
				[ Related-IMS-Charging-Identifier-Node ]
				[ Change-Time ]
 */
@DiameterAvpDefinition(code = 2709L, vendorId = KnownVendorIDs.TGPP_ID, name = "Access-Transfer-Information")
public interface AccessTransferInformation extends DiameterAvp
{
	AccessTransferTypeEnum getAccessTransferType();
	
	void setAccessTransferType(AccessTransferTypeEnum value);
	
	List<ByteBuf> getAccessNetworkInformation();
	
	void setAccessNetworkInformation(List<ByteBuf> value);	
	
	ByteBuf getCellularNetworkInformation();
	
	void setCellularNetworkInformation(ByteBuf value);
	
	InterUETransferEnum getInterUETransfer();
	
	void setInterUETransfer(InterUETransferEnum value);
	
	UserEquipmentInfo getUserEquipmentInfo();
	
	void setUserEquipmentInfo(UserEquipmentInfo value);
	
	String getInstanceId();
	
	void setInstanceId(String value);
	
	String getRelatedIMSChargingIdentifier();
	
	void setRelatedIMSChargingIdentifier(String value);
	
	RelatedIMSChargingIdentifierNode getRelatedIMSChargingIdentifierNode();
	
	void setRelatedIMSChargingIdentifierNode(RelatedIMSChargingIdentifierNode value);
	
	Date getChangeTime();
	
	void setChangeTime(Date value);
}