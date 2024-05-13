package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessNetworkInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessTransferInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessTransferType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AccessTransferTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CellularNetworkInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InstanceId;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InterUETransfer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.InterUETransferEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelatedIMSChargingIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelatedIMSChargingIdentifierNode;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfo;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class AccessTransferInformationImpl extends DiameterAvpImpl implements AccessTransferInformation
{
	private AccessTransferType accessTransferType;
	private List<AccessNetworkInformation> accessNetworkInformation; 
	private CellularNetworkInformation cellularNetworkInformation;
	private InterUETransfer interUETransfer;
	private UserEquipmentInfo userEquipmentInfo;
	private InstanceId instanceId;
	private RelatedIMSChargingIdentifier relatedIMSChargingIdentifier;
	private RelatedIMSChargingIdentifierNode relatedIMSChargingIdentifierNode;
	private ChangeTime changeTime;
		
	public AccessTransferInformationImpl()
	{
		
	}
	
	public AccessTransferTypeEnum getAccessTransferType()
	{
		if(accessTransferType==null)
			return null;
		
		return accessTransferType.getEnumerated(AccessTransferTypeEnum.class);
	}
	
	public void setAccessTransferType(AccessTransferTypeEnum value)
	{
		if(value==null)
			this.accessTransferType = null;
		else
			this.accessTransferType = new AccessTransferTypeImpl(value, null, null);			
	}
	
	public List<ByteBuf> getAccessNetworkInformation()
	{
		if(accessNetworkInformation==null || accessNetworkInformation.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(AccessNetworkInformation curr:accessNetworkInformation)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setAccessNetworkInformation(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.accessNetworkInformation = null;
		else
		{
			this.accessNetworkInformation = new ArrayList<AccessNetworkInformation>();
			for(ByteBuf curr:value)
				this.accessNetworkInformation.add(new AccessNetworkInformationImpl(curr, null, null));
		}
	}	
	
	public ByteBuf getCellularNetworkInformation()
	{
		if(cellularNetworkInformation==null)
			return null;
		
		return cellularNetworkInformation.getValue();
	}
	
	public void setCellularNetworkInformation(ByteBuf value)
	{
		if(value==null)
			this.cellularNetworkInformation = null;
		else
			this.cellularNetworkInformation = new CellularNetworkInformationImpl(value, null, null);			
	}
	
	public InterUETransferEnum getInterUETransfer()
	{
		if(interUETransfer==null)
			return null;
		
		return interUETransfer.getEnumerated(InterUETransferEnum.class);
	}
	
	public void setInterUETransfer(InterUETransferEnum value)
	{
		if(value==null)
			this.interUETransfer = null;
		else
			this.interUETransfer = new InterUETransferImpl(value, null, null);			
	}
	
	public UserEquipmentInfo getUserEquipmentInfo()
	{
		return userEquipmentInfo;
	}
	
	public void setUserEquipmentInfo(UserEquipmentInfo value)
	{
		this.userEquipmentInfo = value;		
	}
	
	public String getInstanceId()
	{
		if(instanceId==null)
			return null;
		
		return instanceId.getString();
	}
	
	public void setInstanceId(String value)
	{
		if(value==null)
			this.instanceId = null;
		else
			this.instanceId = new InstanceIdImpl(value, null, null);			
	}
	
	public String getRelatedIMSChargingIdentifier()
	{
		if(relatedIMSChargingIdentifier==null)
			return null;
		
		return relatedIMSChargingIdentifier.getString();
	}
	
	public void setRelatedIMSChargingIdentifier(String value)
	{
		if(value==null)
			this.relatedIMSChargingIdentifier = null;
		else
			this.relatedIMSChargingIdentifier = new RelatedIMSChargingIdentifierImpl(value, null, null);			
	}
	
	public RelatedIMSChargingIdentifierNode getRelatedIMSChargingIdentifierNode()
	{
		return relatedIMSChargingIdentifierNode;
	}
	
	public void setRelatedIMSChargingIdentifierNode(RelatedIMSChargingIdentifierNode value)
	{
		this.relatedIMSChargingIdentifierNode = value;		
	}
	
	public Date getChangeTime()
	{
		if(changeTime==null)
			return null;
		
		return changeTime.getDateTime();
	}
	
	public void setChangeTime(Date value)
	{
		if(value==null)
			this.changeTime = null;
		else
			this.changeTime = new ChangeTimeImpl(value, null, null);			
	}
}