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

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPRATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PresenceReportingAreaStatusImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeCondition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelatedChangeConditionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPP2BSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPRATType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatusEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class RelatedChangeConditionInformationImpl extends DiameterAvpImpl implements RelatedChangeConditionInformation
{
	private SGSNAddress sgsnAddress; 
	private List<ChangeCondition> changeCondition;
	private TGPPUserLocationInfo tgppUserLocationInfo;
	private TGPP2BSID tgpp2BSID;
	private UWANUserLocationInfo uwanUserLocationInfo;
	private PresenceReportingAreaStatus presenceReportingAreaStatus;
	private UserCSGInformation userCSGInformation;  
	private TGPPRATType tgppRATType;
			
	public RelatedChangeConditionInformationImpl()
	{
		
	}
	
	public InetAddress getSGSNAddress()
	{
		if(sgsnAddress==null)
			return null;
		
		return sgsnAddress.getAddress();
	}
	
	public void setSGSNAddress(InetAddress value)
	{
		if(value==null)
			this.sgsnAddress = null;
		else
			this.sgsnAddress = new SGSNAddressImpl(value, null, null);			
	}
	
	public List<Long> getChangeCondition()
	{
		if(changeCondition==null || changeCondition.size()==0)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(ChangeCondition curr:changeCondition)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setChangeCondition(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.changeCondition = null;
		else
		{
			this.changeCondition = new ArrayList<ChangeCondition>();
			for(Long curr: value)
				this.changeCondition.add(new ChangeConditionImpl(curr, null, null));			
		}
	}
	
	public ByteBuf get3GPPUserLocationInfo()
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}
	
	public void set3GPPUserLocationInfo(ByteBuf value)
	{
		if(value==null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);			
	}
	
	public ByteBuf get3GPP2BSID()
	{
		if(tgpp2BSID==null)
			return null;
		
		return tgpp2BSID.getValue();
	}
	
	public void set3GPP2BSID(ByteBuf value)
	{
		if(value==null)
			this.tgpp2BSID = null;
		else
			this.tgpp2BSID = new TGPP2BSIDImpl(value, null, null);			
	}
	
	public UWANUserLocationInfo getUWANUserLocationInfo()
	{
		return uwanUserLocationInfo;
	}
	
	public void setUWANUserLocationInfo(UWANUserLocationInfo value)
	{
		this.uwanUserLocationInfo = value;
	}
	
	public PresenceReportingAreaStatusEnum getPresenceReportingAreaStatus()
	{
		if(presenceReportingAreaStatus==null)
			return null;
		
		return presenceReportingAreaStatus.getEnumerated(PresenceReportingAreaStatusEnum.class);
	}
	
	public void setPresenceReportingAreaStatus(PresenceReportingAreaStatusEnum value)
	{
		if(value==null)
			this.presenceReportingAreaStatus = null;
		else
			this.presenceReportingAreaStatus = new PresenceReportingAreaStatusImpl(value, null, null);			
	}
	
	public UserCSGInformation getUserCSGInformation()
	{
		return this.userCSGInformation;
	}
	
	public void setUserCSGInformation(UserCSGInformation value)
	{
		this.userCSGInformation = value;
	}
	
	public ByteBuf get3GPPRATType()
	{
		if(tgppRATType==null)
			return null;
		
		return tgppRATType.getValue();
	}
	
	public void set3GPPRATType(ByteBuf value)
	{
		if(value==null)
			this.tgppRATType = null;
		else
			this.tgppRATType = new TGPPRATTypeImpl(value, null, null);			
	}
}