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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CPDTInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.IMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.M2MInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MBMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMTelInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.oma.DCDInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.IMInformation;
import com.mobius.software.telco.protocols.diameter.primitives.oma.ServiceGenericInformation;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 873L, vendorId = KnownVendorIDs.TGPP_ID)
public class ServiceInformationImpl implements ServiceInformation
{
	private List<SubscriptionId> subscriptionId;
	private AoCInformation aocInformation;
	private PSInformation psInformation;
	private IMSInformation imsInformation;
	private MMSInformation mmsInformation;
	private LCSInformation lcsInformation;
	private PoCInformation pocInformation;
	private MBMSInformation mbmsInformation;
	private SMSInformation smsInformation;
	private VCSInformation vcsInformation;
	private MMTelInformation mmtelInformation;
	private ProSeInformation proSeInformation;
	private ServiceGenericInformation serviceGenericInformation;
	private IMInformation imInformation;
	private DCDInformation dcdInformation;
	private M2MInformation m2mInformation;
 	private CPDTInformation cpdtInformation; 
 					 
	protected ServiceInformationImpl()
	{
		
	}
	
	public ServiceInformationImpl(List<SubscriptionId> subscriptionId)
	{
		this.subscriptionId = subscriptionId;		
	}

	@Override
	public List<SubscriptionId> getSubscriptionId() 
	{
		return this.subscriptionId;
	}

	@Override
	public void setSubscriptionId(List<SubscriptionId> value) 
	{
		this.subscriptionId = value;
	}
	
	public AoCInformation getAoCInformation()
	{
		return this.aocInformation;
	}
	
	public void setAoCInformation(AoCInformation value)
	{
		this.aocInformation = value;
	}
	
	public PSInformation getPSInformation()
	{
		return this.psInformation;
	}
	
	public void setPSInformation(PSInformation value)
	{
		this.psInformation = value;
	}
	
	public IMSInformation getIMSInformation()
	{
		return this.imsInformation;
	}
	
	public void setIMSInformation(IMSInformation value)
	{
		this.imsInformation = value;
	}
	
	public MMSInformation getMMSInformation()
	{
		return this.mmsInformation;
	}
	
	public void setMMSInformation(MMSInformation value)
	{
		this.mmsInformation = value;
	}
	
	public LCSInformation getLCSInformation()
	{
		return this.lcsInformation;
	}
	
	public void setLCSInformation(LCSInformation value)
	{
		this.lcsInformation = value;
	}
	
	public PoCInformation getPoCInformation()
	{
		return this.pocInformation;
	}
	
	public void setPoCInformation(PoCInformation value)
	{
		this.pocInformation = value;
	}
	
	public MBMSInformation getMBMSInformation()
	{
		return this.mbmsInformation;
	}
	
	public void setMBMSInformation(MBMSInformation value)
	{
		this.mbmsInformation = value;
	}
	
	public SMSInformation getSMSInformation()
	{
		return this.smsInformation;
	}
	
	public void setSMSInformation(SMSInformation value)
	{
		this.smsInformation = value;
	}

	public VCSInformation getVCSInformation()
	{
		return this.vcsInformation;
	}
	
	public void setVCSInformation(VCSInformation value)
	{
		this.vcsInformation = value;
	}
	
	public MMTelInformation getMMTelInformation()
	{
		return mmtelInformation;
	}
	
	public void setMMTelInformation(MMTelInformation value)
	{
		this.mmtelInformation = value;
	}
	
	public ProSeInformation getProSeInformation()
	{
		return this.proSeInformation;
	}
	
	public void setProSeInformation(ProSeInformation value)
	{
		this.proSeInformation = value;
	}
	
	public ServiceGenericInformation getServiceGenericInformation()
	{
		return serviceGenericInformation;
	}
	
	public void setServiceGenericInformation(ServiceGenericInformation value)
	{
		this.serviceGenericInformation = value;
	}
	
	public IMInformation getIMInformation()
	{
		return imInformation;
	}
	
	public void setIMInformation(IMInformation value)
	{
		this.imInformation = value;
	}
	
	public DCDInformation getDCDInformation()
	{
		return this.dcdInformation;
	}
	
	public void setDCDInformation(DCDInformation value)
	{
		this.dcdInformation = value;
	}
	
	public M2MInformation getM2MInformation()
	{
		return m2mInformation;
	}
	
	public void setM2MInformation(M2MInformation value)
	{
		this.m2mInformation = value;
	}
	
	public CPDTInformation getCPDTInformation()
	{
		return cpdtInformation;
	}
	
	public void setCPDTInformation(CPDTInformation value)
	{
		this.cpdtInformation = value;
	}
}