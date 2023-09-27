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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.CNIPMulticastDistributionImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMS2G3GIndicatorImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSServiceAreaImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSServiceTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.MBMSSessionIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.RAIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.RequiredMBMSBearerCapabilitiesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.TMGIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSDataTransferStartImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgmb.MBMSDataTransferStopImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.FileRepairSupported;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.FileRepairSupportedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MBMSChargedParty;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MBMSChargedPartyEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MBMSGWAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MBMSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MBMSUserServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MBMSUserServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.CNIPMulticastDistribution;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.CNIPMulticastDistributionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMS2G3GIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMS2G3GIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSServiceArea;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.MBMSSessionIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.RAI;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.RequiredMBMSBearerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.TMGI;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSDataTransferStart;
import com.mobius.software.telco.protocols.diameter.primitives.sgmb.MBMSDataTransferStop;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 880L, vendorId = KnownVendorIDs.TGPP_ID)
public class MBMSInformationImpl implements MBMSInformation
{
	private TMGI tmgi;
	private MBMSServiceType mbmsServiceType;
	private MBMSUserServiceType mbmsUserServiceType;
	private FileRepairSupported fileRepairSupported;
	private RequiredMBMSBearerCapabilities requiredMBMSBearerCapabilities;
	private MBMS2G3GIndicator mbms2G3GIndicator;
	private RAI rai;
	private List<MBMSServiceArea> mbmsServiceArea;
	private MBMSSessionIdentity mbmsSessionIdentity;
	private CNIPMulticastDistribution cnIPMulticastDistribution;
	private MBMSGWAddress mbmsGWAddress;
	private MBMSChargedParty mbmsChargedParty;
	private List<MSISDN> msisdn;
	private MBMSDataTransferStart mbmsDataTransferStart;
	private MBMSDataTransferStop mbmsDataTransferStop;
	
	public MBMSInformationImpl()
	{
		
	}

	public ByteBuf getTMGI()
	{
		if(tmgi==null)
			return null;
		
		return tmgi.getValue();
	}
	
	public void setTMGI(ByteBuf value)
	{
		if(value==null)
			this.tmgi = null;
		else
			this.tmgi = new TMGIImpl(value, null, null);			
	}
	
	public MBMSServiceTypeEnum getMBMSServiceType()
	{
		if(mbmsServiceType==null)
			return null;
		
		return mbmsServiceType.getEnumerated(MBMSServiceTypeEnum.class);
	}
	
	public void setMBMSServiceType(MBMSServiceTypeEnum value)
	{
		if(value==null)
			this.mbmsServiceType = null;
		else
			this.mbmsServiceType = new MBMSServiceTypeImpl(value, null, null);			
	}
	
	public MBMSUserServiceTypeEnum getMBMSUserServiceType()
	{
		if(mbmsUserServiceType==null)
			return null;
		
		return mbmsUserServiceType.getEnumerated(MBMSUserServiceTypeEnum.class);
	}
	
	public void setMBMSUserServiceType(MBMSUserServiceTypeEnum value)
	{
		if(value==null)
			this.mbmsUserServiceType = null;
		else
			this.mbmsUserServiceType = new MBMSUserServiceTypeImpl(value, null, null);			
	}
	
	public FileRepairSupportedEnum getFileRepairSupported()
	{
		if(fileRepairSupported==null)
			return null;
		
		return fileRepairSupported.getEnumerated(FileRepairSupportedEnum.class);
	}
	
	public void setFileRepairSupported(FileRepairSupportedEnum value)
	{
		if(value==null)
			this.fileRepairSupported = null;
		else
			this.fileRepairSupported = new FileRepairSupportedImpl(value, null, null);			
	}
	
	public String getRequiredMBMSBearerCapabilities()
	{
		if(requiredMBMSBearerCapabilities==null)
			return null;
		
		return requiredMBMSBearerCapabilities.getString();
	}
	
	public void setRequiredMBMSBearerCapabilities(String value)
	{
		if(value==null)
			this.requiredMBMSBearerCapabilities = null;
		else
			this.requiredMBMSBearerCapabilities = new RequiredMBMSBearerCapabilitiesImpl(value, null, null);			
	}
	
	public MBMS2G3GIndicatorEnum getMBMS2G3GIndicator()
	{
		if(mbms2G3GIndicator==null)
			return null;
		
		return mbms2G3GIndicator.getEnumerated(MBMS2G3GIndicatorEnum.class);
	}
	
	public void setMBMS2G3GIndicator(MBMS2G3GIndicatorEnum value)
	{
		if(value==null)
			this.mbms2G3GIndicator = null;
		else
			this.mbms2G3GIndicator = new MBMS2G3GIndicatorImpl(value, null, null);			
	}
	
	public String getRAI()
	{
		if(rai==null)
			return null;
		
		return rai.getString();
	}
	
	public void setRAI(String value)
	{
		if(value==null)
			this.rai = null;
		else
			this.rai = new RAIImpl(value, null, null);			
	}
	
	public List<ByteBuf> getMBMSServiceArea()
	{
		if(mbmsServiceArea==null || mbmsServiceArea.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(MBMSServiceArea curr:mbmsServiceArea)
			result.add(curr.getValue());
		
		return result;
	}
	
	public void setMBMSServiceArea(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.mbmsServiceArea = null;
		else
		{
			this.mbmsServiceArea = new ArrayList<MBMSServiceArea>();
			for(ByteBuf curr:value)
				this.mbmsServiceArea.add(new MBMSServiceAreaImpl(curr, null, null));
		}
	}
	
	public ByteBuf getMBMSSessionIdentity()
	{
		if(mbmsSessionIdentity==null)
			return null;
		
		return mbmsSessionIdentity.getValue();
	}
	
	public void setMBMSSessionIdentity(ByteBuf value)
	{
		if(value==null)
			this.mbmsSessionIdentity = null;
		else
			this.mbmsSessionIdentity = new MBMSSessionIdentityImpl(value, null, null);			
	}
	
	public CNIPMulticastDistributionEnum getCNIPMulticastDistribution()
	{
		if(cnIPMulticastDistribution==null)
			return null;
		
		return cnIPMulticastDistribution.getEnumerated(CNIPMulticastDistributionEnum.class);
	}
	
	public void setCNIPMulticastDistribution(CNIPMulticastDistributionEnum value)
	{
		if(value==null)
			this.cnIPMulticastDistribution = null;
		else
			this.cnIPMulticastDistribution = new CNIPMulticastDistributionImpl(value, null, null);			
	}
	
	public InetAddress getMBMSGWAddress()
	{
		if(mbmsGWAddress==null)
			return null;
		
		return mbmsGWAddress.getAddress();
	}
	
	public void setMBMSGWAddress(InetAddress value)
	{
		if(value==null)
			this.mbmsGWAddress = null;
		else
			this.mbmsGWAddress = new MBMSGWAddressImpl(value, null, null);			
	}
	
	public MBMSChargedPartyEnum getMBMSChargedParty()
	{
		if(mbmsChargedParty==null)
			return null;
		
		return mbmsChargedParty.getEnumerated(MBMSChargedPartyEnum.class);
	}
	
	public void setMBMSChargedParty(MBMSChargedPartyEnum value)
	{
		if(value==null)
			this.mbmsChargedParty = null;
		else
			this.mbmsChargedParty = new MBMSChargedPartyImpl(value, null, null);			
	}
	
	public List<String> getMSISDN()
	{
		if(msisdn==null || msisdn.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(MSISDN curr:msisdn)
			result.add(curr.getAddress());
		
		return result;
	}
	
	public void setMSISDN(List<String> value)
	{
		if(value==null || value.size()==0)
			this.msisdn = null;
		else
		{
			this.msisdn = new ArrayList<MSISDN>();
			for(String curr:value)
				this.msisdn.add(new MSISDNImpl(curr));
		}
	}
	
	public Long getMBMSDataTransferStart()
	{
		if(mbmsDataTransferStart==null)
			return null;
		
		return mbmsDataTransferStart.getLong();
	}
	
	public void setMBMSDataTransferStart(Long value)
	{
		if(value==null)
			this.mbmsDataTransferStart = null;
		else
			this.mbmsDataTransferStart = new MBMSDataTransferStartImpl(value, null, null);			
	}
	
	public Long getMBMSDataTransferStop()
	{
		if(mbmsDataTransferStop==null)
			return null;
		
		return mbmsDataTransferStop.getLong();
	}
	
	public void setMBMSDataTransferStop(Long value)
	{
		if(value==null)
			this.mbmsDataTransferStop = null;
		else
			this.mbmsDataTransferStop = new MBMSDataTransferStopImpl(value, null, null);			
	}
}