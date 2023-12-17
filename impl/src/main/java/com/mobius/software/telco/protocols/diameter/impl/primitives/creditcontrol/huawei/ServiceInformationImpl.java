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
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CPDTInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.M2MInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MBMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMTelInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PoCInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ProSeInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VCSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.IMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.INInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.P2PSMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.PSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.SMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.huawei.ServiceInformation;
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
	private PSInformation psInformation;
	
	private INInformation inInformation;
	
	private P2PSMSInformation p2SMSInformation;
	
	private IMSInformation imsInformation;
	
	private MMSInformation mmsInformation;
	      	
	private LCSInformation lcsInformation;
	
	private PoCInformation pocInformation;
	
	private MBMSInformation mbmsInformation;
	
	private SMSInformation smsInformation;
	
	private VCSInformation vcsInformation;
	
	private MMTelInformation mmTelInformation;
	
	private ProSeInformation proSeInformation;
	
	private ServiceGenericInformation serviceGenericInformation;
	
	private IMInformation imInformation;
	
	private DCDInformation dcDInformation;
	
	private M2MInformation m2mInformation;
	
	private CPDTInformation cpdtInformation;
	
	public ServiceInformationImpl()
	{
		
	}
	
	@Override
	public PSInformation getPSInformation()
	{
		return this.psInformation;
	}
	
	@Override
	public void setPSInformation(PSInformation value)
	{
		this.psInformation = value;
	}
	
	@Override
	public INInformation getINInformation()
	{
		return this.inInformation;
	}
	
	@Override
	public void setINInformation(INInformation value)
	{
		this.inInformation = value;
	}
	
	@Override
	public P2PSMSInformation getP2PSMSInformation()
	{
		return this.p2SMSInformation;
	}
	
	@Override
	public void setP2PSMSInformation(P2PSMSInformation value)
	{
		this.p2SMSInformation = value;
	}
	
	@Override
	public IMSInformation getIMSInformation()
	{
		return imsInformation;
	}
	
	@Override
	public void setIMSInformation(IMSInformation value)
	{
		this.imsInformation = value;
	}
	
	@Override
	public MMSInformation getMMSInformation()
	{
		return this.mmsInformation;
	}
	      	
	@Override
	public void setMMSInformation(MMSInformation value)
	{
		this.mmsInformation = value;
	}
	      	
	@Override
	public LCSInformation getLCSInformation()
	{
		return this.lcsInformation;
	}
	
	@Override
	public void setLCSInformation(LCSInformation value)
	{
		this.lcsInformation = value;
	}
	
	@Override
	public PoCInformation getPoCInformation()
	{
		return pocInformation;
	}
	
	@Override
	public void setPoCInformation(PoCInformation value)
	{
		this.pocInformation = value;	
	}
	
	@Override
	public MBMSInformation getMBMSInformation()
	{
		return this.mbmsInformation;
	}
	
	@Override
	public void setMBMSInformation(MBMSInformation value)
	{
		this.mbmsInformation = value;
	}
	
	@Override
	public SMSInformation getSMSInformation()
	{
		return this.smsInformation;
	}
	
	@Override
	public void setSMSInformation(SMSInformation value)
	{
		this.smsInformation = value;
	}

	@Override
	public VCSInformation getVCSInformation()
	{
		return this.vcsInformation;
	}
	
	@Override
	public void setVCSInformation(VCSInformation value)
	{
		this.vcsInformation = value;
	}
	
	@Override
	public MMTelInformation getMMTelInformation()
	{
		return mmTelInformation;
	}
	
	@Override
	public void setMMTelInformation(MMTelInformation value)
	{
		this.mmTelInformation = value;
	}
	
	@Override
	public ProSeInformation getProSeInformation()
	{
		return this.proSeInformation;
	}
	
	@Override
	public void setProSeInformation(ProSeInformation value)
	{
		this.proSeInformation = value;
	}
	
	@Override
	public ServiceGenericInformation getServiceGenericInformation()
	{
		return this.serviceGenericInformation;
	}
	
	@Override
	public void setServiceGenericInformation(ServiceGenericInformation value)
	{
		this.serviceGenericInformation = value;
	}
	
	@Override
	public IMInformation getIMInformation()
	{
		return imInformation;
	}
	
	@Override
	public void setIMInformation(IMInformation value)
	{
		this.imInformation = value;
	}
	
	@Override
	public DCDInformation getDCDInformation()
	{
		return this.dcDInformation;
	}
	
	@Override
	public void setDCDInformation(DCDInformation value)
	{
		this.dcDInformation = value;
	}
	
	@Override
	public M2MInformation getM2MInformation()
	{
		return this.m2mInformation;
	}
	
	@Override
	public void setM2MInformation(M2MInformation value)
	{
		this.m2mInformation = value;
	}
	
	@Override
	public CPDTInformation getCPDTInformation()
	{
		return this.cpdtInformation;
	}
	
	@Override
	public void setCPDTInformation(CPDTInformation value)	
	{
		this.cpdtInformation = value;
	}
}