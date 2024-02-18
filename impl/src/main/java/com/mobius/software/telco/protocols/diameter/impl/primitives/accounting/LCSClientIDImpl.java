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

import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSAPN;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientDialedByMS;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientExternalID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientName;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSRequestorID;

/**
*
* @author yulian oifa
*
*/
public class LCSClientIDImpl implements LCSClientID
{
	private LCSClientType lcsClientType;
	private LCSClientExternalID lcsClientExternalID;
	private LCSClientDialedByMS lcsClientDialedByMS;
	private LCSClientName lcsClientName;
	private LCSAPN lcsAPN;
	private LCSRequestorID lcsRequestorID;
			
	public LCSClientIDImpl()
	{
		
	}
	
	public LCSClientTypeEnum getLCSClientType()
	{
		if(lcsClientType==null)
			return null;
		
		return lcsClientType.getEnumerated(LCSClientTypeEnum.class);
	}
	
	public void setLCSClientType(LCSClientTypeEnum value)
	{
		if(value==null)
			this.lcsClientType = null;
		else
			this.lcsClientType = new LCSClientTypeImpl(value, null, null);			
	}
	
	public String getLCSClientExternalID()
	{
		if(lcsClientExternalID==null)
			return null;
		
		return lcsClientExternalID.getString();
	}
	
	public void setLCSClientExternalID(String value)
	{
		if(value==null)
			this.lcsClientExternalID = null;
		else
			this.lcsClientExternalID = new LCSClientExternalIDImpl(value, null, null);			
	}
	
	public String getLCSClientDialedByMS()
	{
		if(lcsClientDialedByMS==null)
			return null;
		
		return lcsClientDialedByMS.getString();
	}
	
	public void setLCSClientDialedByMS(String value)
	{
		if(value==null)
			this.lcsClientDialedByMS = null;
		else
			this.lcsClientDialedByMS = new LCSClientDialedByMSImpl(value, null, null);			
	}
	
	public LCSClientName getLCSClientName()
	{
		return lcsClientName;
	}
	
	public void setLCSClientName(LCSClientName value)
	{
		this.lcsClientName = value;
	}
	
	public String getLCSAPN()
	{
		if(lcsAPN==null)
			return null;
		
		return lcsAPN.getString();
	}
	
	public void setLCSAPN(String value)
	{
		if(value==null)
			this.lcsAPN = null;
		else
			this.lcsAPN = new LCSAPNImpl(value, null, null);			
	}
	
	public LCSRequestorID getLCSRequestorID()
	{
		return lcsRequestorID;
	}
	
	public void setLCSRequestorID(LCSRequestorID value)
	{
		this.lcsRequestorID = value;		
	}
}