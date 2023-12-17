package com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.huawei;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.MessageIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MessageID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.BearerProtocolType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.BearerType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ChargingID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ContentID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.PSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.RecipientAmount;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SPId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceId;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceLevel;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 865L, vendorId = KnownVendorIDs.TGPP_ID)
public class PSInformationImpl extends com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.PSInformationImpl implements PSInformation 
{
	private SPId spId;
	
	private ServiceId serviceId;
	
	private BearerType bearerType;
	
	private MessageID messageID;
	
	private ContentID contentID;
	
	private BearerProtocolType bearerProtocolType;
	
	private ServiceLevel serviceLevel;
	
	private RecipientAmount recipientAmount;
	
	private ChargingID chargingID;
	
	public PSInformationImpl()
	{
		
	}
	
	@Override
	public String getSPId()
	{
		if(spId==null)
			return null;
		
		return spId.getString();
	}
	
	@Override
	public void setSPId(String value)
	{
		if(value==null)
			this.spId = null;
		else
			this.spId = new SPIdImpl(value);
	}
	
	@Override
	public String getServiceId()
	{
		if(serviceId==null)
			return null;
		
		return serviceId.getString();
	}
	
	@Override
	public void setServiceId(String value)
	{
		if(value==null)
			this.serviceId = null;
		else
			this.serviceId = new ServiceIdImpl(value);
	}
	
	@Override
	public Long getBearerType()
	{
		if(bearerType==null)
			return null;
		
		return bearerType.getUnsigned();
	}
	
	@Override
	public void setBearerType(Long value)
	{
		if(value==null)
			this.bearerType = null;
		else
			this.bearerType = new BearerTypeImpl(value, null, null);
	}
	
	@Override
	public String getMessageID()
	{
		if(messageID==null)
			return null;
		
		return messageID.getString();
	}
	
	@Override
	public void setMessageID(String value)
	{
		if(value==null)
			this.messageID = null;
		else
			this.messageID = new MessageIDImpl(value, null, null);
	}	
	
	@Override
	public String getContentID()
	{
		if(contentID==null)
			return null;
		
		return contentID.getString();
	}
	
	@Override
	public void setContentId(String value)
	{
		if(value==null)
			this.contentID = null;
		else
			this.contentID = new ContentIDImpl(value);
	}	
	
	@Override
	public Long getBearerProtocolType()
	{
		if(bearerProtocolType==null)
			return null;
		
		return bearerProtocolType.getUnsigned();
	}
	
	@Override
	public void setBearerProtocolType(Long value)
	{
		if(value==null)
			this.bearerProtocolType = null;
		else
			this.bearerProtocolType = new BearerProtocolTypeImpl(value, null, null);
	}	
	
	@Override
	public Long getServiceLevel()
	{
		if(serviceLevel==null)
			return null;
		
		return serviceLevel.getUnsigned();
	}
	
	@Override
	public void setServiceLevel(Long value)
	{
		if(value==null)
			this.serviceLevel = null;
		else
			this.serviceLevel = new ServiceLevelImpl(value, null, null);
	}	
	
	@Override
	public Long getRecipientAmount()
	{
		if(recipientAmount==null)
			return null;
		
		return recipientAmount.getUnsigned();
	}
	
	@Override
	public void setRecipientAmount(Long value)
	{
		if(value==null)
			this.recipientAmount = null;
		else
			this.recipientAmount = new RecipientAmountImpl(value, null, null);
	}
	
	@Override
	public String getChargingID()
	{
		if(chargingID==null)
			return null;
		
		return chargingID.getString();
	}
	
	@Override
	public void setChargingID(String value)
	{
		if(value==null)
			this.chargingID = null;
		else
			this.chargingID = new ChargingIDImpl(value);
	}
}