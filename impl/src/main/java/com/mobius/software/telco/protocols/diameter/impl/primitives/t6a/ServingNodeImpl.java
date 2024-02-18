package com.mobius.software.telco.protocols.diameter.impl.primitives.t6a;
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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.MMENumberForMTSMSImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6a.SGSNNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSF3GPPNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSF3GPPNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSF3GPPRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSFNon3GPPNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSFNon3GPPNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMSFNon3GPPRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.IPSMGWNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.IPSMGWNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.IPSMGWRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.MMENameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.MMERealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.MSCNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.SGSNNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.SGSNRealmImpl;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.MMENumberForMTSMS;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.SGSNNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPName;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSF3GPPRealm;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPName;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMSFNon3GPPRealm;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.IPSMGWName;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.IPSMGWNumber;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.IPSMGWRealm;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MMEName;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MMERealm;
import com.mobius.software.telco.protocols.diameter.primitives.slh.MSCNumber;
import com.mobius.software.telco.protocols.diameter.primitives.slh.SGSNName;
import com.mobius.software.telco.protocols.diameter.primitives.slh.SGSNRealm;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingNode;

/**
*
* @author yulian oifa
*
*/
public class ServingNodeImpl extends DiameterGroupedAvpImpl implements ServingNode
{
	private SMSF3GPPName smsf3GPPName;
	
	private SMSF3GPPRealm smsf3GPPRealm;
	
	private SMSF3GPPNumber smsf3GPPNumber;
	
	private SMSFNon3GPPName smsfNon3GPPName;
	
	private SMSFNon3GPPRealm smsfNon3GPPRealm;
	
	private SMSFNon3GPPNumber smsfNon3GPPNumber;
	
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
	
	@Override
	public String getSMSF3GPPName()
	{
		if(smsf3GPPName == null)
			return null;
		
		return smsf3GPPName.getIdentity();
	}
	
	@Override
	public void setSMSF3GPPName(String value)
	{
		if(value == null)
			this.smsf3GPPName = null;
		else
			this.smsf3GPPName = new SMSF3GPPNameImpl(value, null, null);
	}
	
	@Override
	public String getSMSF3GPPRealm()
	{
		if(smsf3GPPRealm == null)
			return null;
		
		return smsf3GPPRealm.getIdentity();
	}
	
	@Override
	public void setSMSF3GPPRealm(String value)
	{
		if(value == null)
			this.smsf3GPPRealm = null;
		else
			this.smsf3GPPRealm = new SMSF3GPPRealmImpl(value, null, null);
	}
	
	@Override
	public String getSMSF3GPPNumber()
	{
		if(smsf3GPPNumber == null)
			return null;
		
		return smsf3GPPNumber.getAddress();
	}
	
	@Override
	public void setSMSF3GPPNumber(String value)
	{
		if(value == null)
			this.smsf3GPPNumber = null;
		else
			this.smsf3GPPNumber = new SMSF3GPPNumberImpl(value);
	}
	
	@Override
	public String getSMSFNon3GPPName()
	{
		if(smsfNon3GPPName == null)
			return null;
		
		return smsfNon3GPPName.getIdentity();
	}
	
	@Override
	public void setSMSFNon3GPPName(String value)
	{
		if(value == null)
			this.smsfNon3GPPName = null;
		else
			this.smsfNon3GPPName = new SMSFNon3GPPNameImpl(value, null, null);
	}
	
	@Override
	public String getSMSFNon3GPPRealm()
	{
		if(smsfNon3GPPRealm == null)
			return null;
		
		return smsfNon3GPPRealm.getIdentity();
	}
	
	@Override
	public void setSMSFNon3GPPRealm(String value)
	{
		if(value == null)
			this.smsfNon3GPPRealm = null;
		else
			this.smsfNon3GPPRealm = new SMSFNon3GPPRealmImpl(value, null, null);
	}
	
	@Override
	public String getSMSFNon3GPPNumber()
	{
		if(smsfNon3GPPNumber == null)
			return null;
		
		return smsfNon3GPPNumber.getAddress();
	}
	
	@Override
	public void setSMSFNon3GPPNumber(String value)
	{
		if(value == null)
			this.smsfNon3GPPNumber = null;
		else
			this.smsfNon3GPPNumber = new SMSFNon3GPPNumberImpl(value);
	}
	
	@Override
	public String getSGSNName()
	{
		if(sgsnName == null)
			return null;
		
		return sgsnName.getIdentity();
	}
	
	@Override
	public void setSGSNName(String value)
	{
		if(value == null)
			this.sgsnName = null;
		else
			this.sgsnName = new SGSNNameImpl(value, null, null);
	}
	
	@Override
	public String getSGSNRealm()
	{
		if(sgsnRealm == null)
			return null;
		
		return sgsnRealm.getIdentity();
	}
	
	@Override
	public void setSGSNRealm(String value)
	{
		if(value == null)
			this.sgsnRealm = null;
		else
			this.sgsnRealm = new SGSNRealmImpl(value, null, null);
	}
	
	@Override
	public String getSGSNNumber()
	{
		if(sgsnNumber == null)
			return null;
		
		return sgsnNumber.getAddress();
	}
	
	@Override
	public void setSGSNNumber(String value)
	{
		if(value == null)
			this.sgsnNumber = null;
		else
			this.sgsnNumber = new SGSNNumberImpl(value);
	}
	
	@Override
	public String getMMEName()
	{
		if(mmeName == null)
			return null;
		
		return mmeName.getIdentity();
	}
	
	@Override
	public void setMMEName(String value)
	{
		if(value == null)
			this.mmeName = null;
		else
			this.mmeName = new MMENameImpl(value, null, null);
	}
	
	@Override
	public String getMMERealm()
	{
		if(mmeRealm == null)
			return null;
		
		return mmeRealm.getIdentity();
	}
	
	@Override
	public void setMMERealm(String value)
	{
		if(value == null)
			this.mmeRealm = null;
		else
			this.mmeRealm = new MMERealmImpl(value, null, null);
	}
	
	@Override
	public String getMMENumberForMTSMS()
	{
		if(mmeNumberForMTSMS == null)
			return null;
		
		return mmeNumberForMTSMS.getAddress();
	}
	
	@Override
	public void setMMENumberForMTSMS(String value)
	{
		if(value == null)
			this.mmeNumberForMTSMS = null;
		else
			this.mmeNumberForMTSMS = new MMENumberForMTSMSImpl(value);
	}
	
	@Override
	public String getMSCNumber()
	{
		if(mscNumber == null)
			return null;
		
		return mscNumber.getAddress();
	}
	
	@Override
	public void setMSCNumber(String value)
	{
		if(value == null)
			this.mscNumber = null;
		else
			this.mscNumber = new MSCNumberImpl(value);
	}
	
	@Override
	public String getIPSMGWNumber()
	{
		if(ipSMGWNumber == null)
			return null;
		
		return ipSMGWNumber.getAddress();
	}
	
	@Override
	public void setIPSMGWNumber(String value)
	{
		if(value == null)
			this.ipSMGWNumber = null;
		else
			this.ipSMGWNumber = new IPSMGWNumberImpl(value);
	}
	
	@Override
	public String getIPSMGWName()
	{
		if(ipSMGWName == null)
			return null;
		
		return ipSMGWName.getIdentity();
	}
	
	@Override
	public void setIPSMGWName(String value)
	{
		if(value == null)
			this.ipSMGWName = null;
		else
			this.ipSMGWName = new IPSMGWNameImpl(value, null, null);
	}
	
	@Override
	public String getIPSMGWRealm()
	{
		if(ipSMGWRealm == null)
			return null;
		
		return ipSMGWRealm.getIdentity();
	}
	
	@Override
	public void setIPSMGWRealm(String value)
	{
		if(value == null)
			this.ipSMGWRealm = null;
		else
			this.ipSMGWRealm = new IPSMGWRealmImpl(value, null, null);
	}
}