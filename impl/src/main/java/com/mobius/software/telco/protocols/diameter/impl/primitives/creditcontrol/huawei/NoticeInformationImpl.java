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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MessageContent1;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MessageContent2;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MessageContent3;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MessageContent4;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MessageContent5;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MessageContent6;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MessageCount;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.NoticeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ReceiveMessageAddr;

/**
*
* @author yulian oifa
*
*/
public class NoticeInformationImpl extends DiameterAvpImpl implements NoticeInformation
{
	private MessageCount messageCount;
	
	private MessageContent1 messageContent1;
	
	private MessageContent2 messageContent2;
	
	private MessageContent3 messageContent3;
	
	private MessageContent4 messageContent4;
	
	private MessageContent5 messageContent5;
	
	private MessageContent6 messageContent6;
	
	private ReceiveMessageAddr receiveMessageAddr;
	
	public NoticeInformationImpl()
	{
		
	}
	
	@Override
	public Long getMessageCount()
	{
		if(messageCount==null)
			return null;
		
		return messageCount.getUnsigned();
	}
	
	@Override
	public void setMessageCount(Long value)
	{
		if(value==null)
			this.messageCount = null;
		else
			this.messageCount = new MessageCountImpl(value, null, null);
	}
	
	@Override
	public String getMessageContent1()
	{
		if(messageContent1==null)
			return null;
		
		return messageContent1.getString();
	}
	
	@Override
	public void setMessageContent1(String value)
	{
		if(value==null)
			this.messageContent1 = null;
		else
			this.messageContent1 = new MessageContent1Impl(value);
	}
	
	@Override
	public String getMessageContent2()
	{
		if(messageContent2==null)
			return null;
		
		return messageContent2.getString();
	}
	
	@Override
	public void setMessageContent2(String value)
	{
		if(value==null)
			this.messageContent2 = null;
		else
			this.messageContent2 = new MessageContent2Impl(value);
	}
	
	@Override
	public String getMessageContent3()
	{
		if(messageContent3==null)
			return null;
		
		return messageContent3.getString();
	}
	
	@Override
	public void setMessageContent3(String value)
	{
		if(value==null)
			this.messageContent3 = null;
		else
			this.messageContent3 = new MessageContent3Impl(value);
	}
	
	@Override
	public String getMessageContent4()
	{
		if(messageContent4==null)
			return null;
		
		return messageContent4.getString();
	}
	
	@Override
	public void setMessageContent4(String value)
	{
		if(value==null)
			this.messageContent4 = null;
		else
			this.messageContent4 = new MessageContent4Impl(value);
	}
	
	@Override
	public String getMessageContent5()
	{
		if(messageContent5==null)
			return null;
		
		return messageContent5.getString();
	}
	
	@Override
	public void setMessageContent5(String value)
	{
		if(value==null)
			this.messageContent5 = null;
		else
			this.messageContent5 = new MessageContent5Impl(value);
	}
	
	@Override
	public String getMessageContent6()
	{
		if(messageContent6==null)
			return null;
		
		return messageContent6.getString();
	}
	
	@Override
	public void setMessageContent6(String value)
	{
		if(value==null)
			this.messageContent6 = null;
		else
			this.messageContent6 = new MessageContent6Impl(value);
	}
	
	@Override
	public String getReceiveMessageAddr()
	{
		if(receiveMessageAddr==null)
			return null;
		
		return receiveMessageAddr.getString();
	}
	
	@Override
	public void setReceiveMessageAddr(String value)
	{
		if(value==null)
			this.receiveMessageAddr = null;
		else
			this.receiveMessageAddr = new ReceiveMessageAddrImpl(value);
	}
}