package com.mobius.software.telco.protocols.diameter.impl.primitives.slh;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SGSNNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.swx.TGPPAAAServerNameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SGSNNumber;
import com.mobius.software.telco.protocols.diameter.primitives.slh.GMLCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.slh.LCSCapabilitiesSets;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MMEName;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MMERealm;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MSCNumber;
import com.mobius.software.telco.protocols.diameter.primitives.slh.SGSNName;
import com.mobius.software.telco.protocols.diameter.primitives.slh.SGSNRealm;
import com.mobius.software.telco.protocols.diameter.primitives.slh.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.swx.TGPPAAAServerName;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2401L, vendorId = KnownVendorIDs.TGPP_ID)
public class ServingNodeImpl extends DiameterGroupedAvpImpl implements ServingNode
{
	private SGSNNumber sgsnNumber;
	
	private SGSNName sgsnName;
	
	private SGSNRealm sgsnRealm;
	
	private MMEName mmeName;
	
	private MMERealm mmeRealm;
	
	private MSCNumber mscNumber;
	
	private TGPPAAAServerName tgppAAAServerName;
	
	private LCSCapabilitiesSets lcsCapabilitiesSets;
	
	private GMLCAddress gmlcAddress;
		
	public ServingNodeImpl()
	{
		
	}
	
	public String getSGSNNumber()
	{
		if(sgsnNumber == null)
			return null;
		
		return sgsnNumber.getAddress();
	}
	
	public void setSGSNNumber(String value)
	{
		if(value==null)
			this.sgsnNumber = null;
		else 
			this.sgsnNumber = new SGSNNumberImpl(value);
	}
	
	public String getSGSNName()
	{
		if(sgsnName == null)
			return null;
		
		return sgsnName.getIdentity();
	}
	
	public void setSGSNName(String value)
	{
		if(value==null)
			this.sgsnName = null;
		else 
			this.sgsnName = new SGSNNameImpl(value, null ,null);
	}
	
	public String getSGSNRealm()
	{
		if(sgsnRealm == null)
			return null;
		
		return sgsnRealm.getIdentity();
	}
	
	public void setSGSNRealm(String value)
	{
		if(value==null)
			this.sgsnRealm = null;
		else 
			this.sgsnRealm = new SGSNRealmImpl(value, null ,null);
	}
	
	public String getMMEName()
	{
		if(mmeName == null)
			return null;
		
		return mmeName.getIdentity();
	}
	
	public void setMMEName(String value)
	{
		if(value==null)
			this.mmeName = null;
		else 
			this.mmeName = new MMENameImpl(value, null ,null);
	}
	
	public String getMMERealm()
	{
		if(mmeRealm == null)
			return null;
		
		return mmeRealm.getIdentity();
	}
	
	public void setMMERealm(String value)
	{
		if(value==null)
			this.mmeRealm = null;
		else 
			this.mmeRealm = new MMERealmImpl(value, null ,null);
	}
	
	public String getMSCNumber()
	{
		if(mscNumber == null)
			return null;
		
		return mscNumber.getAddress();
	}
	
	public void setMSCNumber(String value)
	{
		if(value==null)
			this.mscNumber = null;
		else 
			this.mscNumber = new MSCNumberImpl(value);
	}
	
	public String get3GPPAAAServerName()
	{
		if(tgppAAAServerName == null)
			return null;
		
		return tgppAAAServerName.getIdentity();
	}
	
	public void set3GPPAAAServerName(String value)
	{
		if(value==null)
			this.tgppAAAServerName = null;
		else 
			this.tgppAAAServerName = new TGPPAAAServerNameImpl(value, null ,null);
	}
	
	public LCSCapabilitiesSets getLCSCapabilitiesSets()
	{
		return lcsCapabilitiesSets;
	}
	
	public void setLCSCapabilitiesSets(LCSCapabilitiesSets value)
	{
		this.lcsCapabilitiesSets = value;
	}
	
	public InetAddress getGMLCAddress()
	{
		if(gmlcAddress == null)
			return null;
		
		return gmlcAddress.getAddress();
	}
	
	public void setGMLCAddress(InetAddress value)
	{
		if(value==null)
			this.gmlcAddress = null;
		else 
			this.gmlcAddress = new GMLCAddressImpl(value, null ,null);
	}
}