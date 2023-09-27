package com.mobius.software.telco.protocols.diameter.impl.primitives.s6m;
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
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MMENumberForMTSMSImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SGSNNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.MMENameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.MMERealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.MSCNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.SGSNNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.SGSNRealmImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MMENumberForMTSMS;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SGSNNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.IPSMGWName;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.IPSMGWNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.IPSMGWRealm;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServingNode;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MMEName;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MMERealm;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MSCNumber;
import com.mobius.software.telco.protocols.diameter.primitives.slh.SGSNName;
import com.mobius.software.telco.protocols.diameter.primitives.slh.SGSNRealm;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2401L, vendorId = KnownVendorIDs.TGPP_ID)
public class ServingNodeImpl extends DiameterGroupedAvpImpl implements ServingNode
{
	private SGSNName sgsnName;
	
	private SGSNRealm sgsnRealm;
	
	private SGSNNumber sgsnNumber;
	
	private MMEName mmeName;
	
	private MMERealm mmeRealm;
	
	private MMENumberForMTSMS mmeNumberForMTSMS;
	
	private MSCNumber mscNumber;
	
	private IPSMGWNumber ipSMGWNumber;
	
	private IPSMGWName ipSMGWName;
	
	private IPSMGWRealm ipSMGWRealm;
	
	public ServingNodeImpl()
	{
		
	}
	
	public String getSGSNName()
	{
		if(sgsnName == null)
			return null;
		
		return sgsnName.getIdentity();
	}
	
	public void setSGSNName(String value)
	{
		if(value == null)
			this.sgsnName = null;
		else
			this.sgsnName = new SGSNNameImpl(value, null, null);
	}
	
	public String getSGSNRealm()
	{
		if(sgsnRealm == null)
			return null;
		
		return sgsnRealm.getIdentity();
	}
	
	public void setSGSNRealm(String value)
	{
		if(value == null)
			this.sgsnRealm = null;
		else
			this.sgsnRealm = new SGSNRealmImpl(value, null, null);
	}
	
	public String getSGSNNumber()
	{
		if(sgsnNumber == null)
			return null;
		
		return sgsnNumber.getAddress();
	}
	
	public void setSGSNNumber(String value)
	{
		if(value == null)
			this.sgsnNumber = null;
		else
			this.sgsnNumber = new SGSNNumberImpl(value);
	}
	
	public String getMMEName()
	{
		if(mmeName == null)
			return null;
		
		return mmeName.getIdentity();
	}
	
	public void setMMEName(String value)
	{
		if(value == null)
			this.mmeName = null;
		else
			this.mmeName = new MMENameImpl(value, null, null);
	}
	
	public String getMMERealm()
	{
		if(mmeRealm == null)
			return null;
		
		return mmeRealm.getIdentity();
	}
	
	public void setMMERealm(String value)
	{
		if(value == null)
			this.mmeRealm = null;
		else
			this.mmeRealm = new MMERealmImpl(value, null, null);
	}
	
	public String getMMENumberForMTSMS()
	{
		if(mmeNumberForMTSMS == null)
			return null;
		
		return mmeNumberForMTSMS.getAddress();
	}
	
	public void setMMENumberForMTSMS(String value)
	{
		if(value == null)
			this.mmeNumberForMTSMS = null;
		else
			this.mmeNumberForMTSMS = new MMENumberForMTSMSImpl(value);
	}
	
	public String getMSCNumber()
	{
		if(mscNumber == null)
			return null;
		
		return mscNumber.getAddress();
	}
	
	public void setMSCNumber(String value)
	{
		if(value == null)
			this.mscNumber = null;
		else
			this.mscNumber = new MSCNumberImpl(value);
	}
	
	public String getIPSMGWNumber()
	{
		if(ipSMGWNumber == null)
			return null;
		
		return ipSMGWNumber.getAddress();
	}
	
	public void setIPSMGWNumber(String value)
	{
		if(value == null)
			this.ipSMGWNumber = null;
		else
			this.ipSMGWNumber = new IPSMGWNumberImpl(value);
	}
	
	public String getIPSMGWName()
	{
		if(ipSMGWName == null)
			return null;
		
		return ipSMGWName.getIdentity();
	}
	
	public void setIPSMGWName(String value)
	{
		if(value == null)
			this.ipSMGWName = null;
		else
			this.ipSMGWName = new IPSMGWNameImpl(value, null, null);
	}
	
	public String getIPSMGWRealm()
	{
		if(ipSMGWRealm == null)
			return null;
		
		return ipSMGWRealm.getIdentity();
	}
	
	public void setIPSMGWRealm(String value)
	{
		if(value == null)
			this.ipSMGWRealm = null;
		else
			this.ipSMGWRealm = new IPSMGWRealmImpl(value, null, null);
	}
}