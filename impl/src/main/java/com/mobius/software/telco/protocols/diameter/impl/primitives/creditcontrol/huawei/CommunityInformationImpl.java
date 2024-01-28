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
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.CommunityInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.MemberScreenClass;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCalledGroupNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCalledHuntingMainNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCalledLongNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCalledNumberType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCalledPBXDisplayNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCalledTopGroupNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCalledVPNPhoneFlags;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCallerGroupNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCallerHuntingMainNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCallerNumberType;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCallerPBXDisplayNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCallerShortNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCallerTopGroupNumber;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SCallerVPNPhoneFlags;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ScreenZoneID;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 21204L, vendorId = KnownVendorIDs.HUAWEI_ID)
public class CommunityInformationImpl implements CommunityInformation
{
	private SCallerNumberType sCallerNumberType;
	
	private SCallerVPNPhoneFlags sCallerVPNPhoneFlags;
	
	private SCallerPBXDisplayNumber sCallerPBXDisplayNumber;
	
	private SCallerHuntingMainNumber sCallerHuntingMainNumber;
	
	private SCalledNumberType sCalledNumberType;
	
	private SCalledVPNPhoneFlags sCalledVPNPhoneFlags;
	
	private SCalledPBXDisplayNumber sCalledPBXDisplayNumber;
	
	private SCalledHuntingMainNumber sCalledHuntingMainNumber;
	
	private SCallerGroupNumber sCallerGroupNumber;
	
	private SCallerTopGroupNumber sCallerTopGroupNumber;
	
	private SCallerShortNumber sCallerShortNumber;
	
	private SCalledGroupNumber sCalledGroupNumber;
	
	private SCalledTopGroupNumber sCalledTopGroupNumber;
	
	private SCalledLongNumber sCalledLongNumber;
	
	private MemberScreenClass memberScreenClass;
	
	private ScreenZoneID screenZoneID;
	
	public CommunityInformationImpl()
	{
		
	}
	
	@Override
	public ByteBuf getSCallerNumberType()
	{
		if(sCallerNumberType==null)
			return null;
		
		return sCallerNumberType.getValue();
	}
	
	@Override
	public void setSCallerNumberType(ByteBuf value)
	{
		if(value==null)
			this.sCallerNumberType = null;
		else
			this.sCallerNumberType = new SCallerNumberTypeImpl(value);
	}	
	
	@Override
	public ByteBuf getSCallerVPNPhoneFlags()
	{
		if(sCallerVPNPhoneFlags==null)
			return null;
		
		return sCallerVPNPhoneFlags.getValue();
	}
	
	@Override
	public void setSCallerVPNPhoneFlags(ByteBuf value)
	{
		if(value==null)
			this.sCallerVPNPhoneFlags = null;
		else
			this.sCallerVPNPhoneFlags = new SCallerVPNPhoneFlagsImpl(value);
	}
	
	@Override
	public ByteBuf getSCallerPBXDisplayNumber()
	{
		if(sCallerPBXDisplayNumber==null)
			return null;
		
		return sCallerPBXDisplayNumber.getValue();
	}
	
	@Override
	public void setSCallerPBXDisplayNumber(ByteBuf value)
	{
		if(value==null)
			this.sCallerPBXDisplayNumber = null;
		else
			this.sCallerPBXDisplayNumber = new SCallerPBXDisplayNumberImpl(value);
	}		
	
	@Override
	public ByteBuf getSCallerHuntingMainNumber()
	{
		if(sCallerHuntingMainNumber==null)
			return null;
		
		return sCallerHuntingMainNumber.getValue();
	}
	
	@Override
	public void setSCallerHuntingMainNumber(ByteBuf value)
	{
		if(value==null)
			this.sCallerHuntingMainNumber = null;
		else
			this.sCallerHuntingMainNumber = new SCallerHuntingMainNumberImpl(value);
	}		
	
	@Override
	public ByteBuf getSCalledNumberType()
	{
		if(sCalledNumberType==null)
			return null;
		
		return sCalledNumberType.getValue();
	}
	
	@Override
	public void setSCalledNumberType(ByteBuf value)
	{
		if(value==null)
			this.sCalledNumberType = null;
		else
			this.sCalledNumberType = new SCalledNumberTypeImpl(value);
	}				
	
	@Override
	public ByteBuf getSCalledVPNPhoneFlags()
	{
		if(sCalledVPNPhoneFlags==null)
			return null;
		
		return sCalledVPNPhoneFlags.getValue();
	}
	
	@Override
	public void setSCalledVPNPhoneFlags(ByteBuf value)
	{
		if(value==null)
			this.sCalledVPNPhoneFlags = null;
		else
			this.sCalledVPNPhoneFlags = new SCalledVPNPhoneFlagsImpl(value);
	}		
	
	@Override
	public ByteBuf getSCalledPBXDisplayNumber()
	{
		if(sCalledPBXDisplayNumber==null)
			return null;
		
		return sCalledPBXDisplayNumber.getValue();
	}
	
	@Override
	public void setSCalledPBXDisplayNumber(ByteBuf value)
	{
		if(value==null)
			this.sCalledPBXDisplayNumber = null;
		else
			this.sCalledPBXDisplayNumber = new SCalledPBXDisplayNumberImpl(value);
	}		
	
	@Override
	public ByteBuf getSCalledHuntingMainNumber()
	{
		if(sCalledHuntingMainNumber==null)
			return null;
		
		return sCalledHuntingMainNumber.getValue();
	}
	
	@Override
	public void setSCalledHuntingMainNumber(ByteBuf value)
	{
		if(value==null)
			this.sCalledHuntingMainNumber = null;
		else
			this.sCalledHuntingMainNumber = new SCalledHuntingMainNumberImpl(value);
	}			
	
	@Override
	public ByteBuf getSCallerGroupNumber()
	{
		if(sCallerGroupNumber==null)
			return null;
		
		return sCallerGroupNumber.getValue();
	}
	
	@Override
	public void setSCallerGroupNumber(ByteBuf value)
	{
		if(value==null)
			this.sCallerGroupNumber = null;
		else
			this.sCallerGroupNumber = new SCallerGroupNumberImpl(value);
	}					
	
	@Override
	public ByteBuf getSCallerTopGroupNumber()
	{
		if(sCallerTopGroupNumber==null)
			return null;
		
		return sCallerTopGroupNumber.getValue();
	}
	
	@Override
	public void setSCallerTopGroupNumber(ByteBuf value)
	{
		if(value==null)
			this.sCallerTopGroupNumber = null;
		else
			this.sCallerTopGroupNumber = new SCallerTopGroupNumberImpl(value);
	}							
	
	@Override
	public ByteBuf getSCallerShortNumber()
	{
		if(sCallerShortNumber==null)
			return null;
		
		return sCallerShortNumber.getValue();
	}
	
	@Override
	public void setSCallerShortNumber(ByteBuf value)
	{
		if(value==null)
			this.sCallerShortNumber = null;
		else
			this.sCallerShortNumber = new SCallerShortNumberImpl(value);
	}							
	
	@Override
	public ByteBuf getSCalledGroupNumber()
	{
		if(sCalledGroupNumber==null)
			return null;
		
		return sCalledGroupNumber.getValue();
	}
	
	@Override
	public void setSCalledGroupNumber(ByteBuf value)
	{
		if(value==null)
			this.sCalledGroupNumber = null;
		else
			this.sCalledGroupNumber = new SCalledGroupNumberImpl(value);
	}									
	
	@Override
	public ByteBuf getSCalledTopGroupNumber()
	{
		if(sCalledTopGroupNumber==null)
			return null;
		
		return sCalledTopGroupNumber.getValue();
	}
	
	@Override
	public void setSCalledTopGroupNumber(ByteBuf value)
	{
		if(value==null)
			this.sCalledTopGroupNumber = null;
		else
			this.sCalledTopGroupNumber = new SCalledTopGroupNumberImpl(value);
	}											
	
	@Override
	public ByteBuf getSCalledLongNumber()
	{
		if(sCalledLongNumber==null)
			return null;
		
		return sCalledLongNumber.getValue();
	}
	
	@Override
	public void setSCalledLongNumber(ByteBuf value)
	{
		if(value==null)
			this.sCalledLongNumber = null;
		else
			this.sCalledLongNumber = new SCalledLongNumberImpl(value);
	}											
	
	@Override
	public String getMemberScreenClass()
	{
		if(memberScreenClass==null)
			return null;
		
		return memberScreenClass.getString();
	}
	
	@Override
	public void setMemberScreenClass(String value)
	{
		if(value==null)
			this.memberScreenClass = null;
		else
			this.memberScreenClass = new MemberScreenClassImpl(value, null, null);
	}										
	
	@Override
	public Integer getScreenZoneID()
	{
		if(screenZoneID==null)
			return null;
		
		return screenZoneID.getInteger();
	}
	
	@Override
	public void setScreenZoneID(Integer value)
	{
		if(value==null)
			this.screenZoneID = null;
		else
			this.screenZoneID = new ScreenZoneIDImpl(value, null, null);
	}										
}