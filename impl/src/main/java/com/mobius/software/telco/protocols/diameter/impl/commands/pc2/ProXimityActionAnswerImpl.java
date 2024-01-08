package com.mobius.software.telco.protocols.diameter.impl.commands.pc2;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.pc2.ProXimityActionAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.ApplicationDataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.PDUIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.ProSeFunctionIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ProSeApplicationMetadataImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetPDUIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.TargetedEPUIDImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ApplicationData;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.MonitorTarget;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.PDUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeCodeSuffixMask;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeFunctionID;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCodeSuffixRange;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeApplicationMetadata;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeRestrictedCodeSuffixRange;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetPDUID;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.TargetedEPUID;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

import io.netty.buffer.ByteBuf;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/
@DiameterCommandImplementation(applicationId = 16777350, commandCode = 8388676, request = false)
public class ProXimityActionAnswerImpl extends Pc2AnswerImpl implements ProXimityActionAnswer
{
	private TargetedEPUID targetedEPUID;
	
	private ProSeFunctionID proSeFunctionID;
	
	private List<PDUID> pduid;
	 
	private List<ProSeRestrictedCodeSuffixRange> proSeRestrictedCodeSuffixRange;
	 
	private List<ProSeAppCodeSuffixRange> proSeApplicationCodeSuffixRange;
	 
	private List<ProSeCodeSuffixMask> proSeCodeSuffixMask;
	 
	private List<MonitorTarget> monitorTarget;
	 
	private List<TargetPDUID> targetPDUID;
	 
	private ProSeApplicationMetadata proSeApplicationMetadata;
	
	private ApplicationData applicationData;
	
	private List<Load> load;
	 
	protected ProXimityActionAnswerImpl() 
	{
		super();
	}
	
	public ProXimityActionAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  Long authApplicationId, AuthSessionStateEnum authSessionState, ProSeRequestTypeEnum proSeRequestType)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authApplicationId, authSessionState, proSeRequestType);
	}
	
	@Override	
	public String getTargetedEPUID()
	{
		if(targetedEPUID == null)
			return null;
		
		return targetedEPUID.getString();
	}
	
	@Override	
	public void setTargetedEPUID(String value)
	{
		if(value == null)
			this.targetedEPUID = null;
		else
			this.targetedEPUID = new TargetedEPUIDImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getProSeFunctionID()
	{
		if(proSeFunctionID == null)
			return null;
		
		return proSeFunctionID.getValue();
	}
	
	@Override
	public void setProSeFunctionID(ByteBuf value)
	{
		if(value == null)
			this.proSeFunctionID = null;
		else
			this.proSeFunctionID = new ProSeFunctionIDImpl(value, null, null);
	}
	
	@Override
	public List<ByteBuf> getPDUID()
	{
		if(pduid==null || pduid.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(PDUID curr:pduid)
			result.add(curr.getValue());
		
		return result;
	}
	 
	@Override
	public void setPDUID(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.pduid = null;
		else
		{
			this.pduid = new ArrayList<PDUID>();
			for(ByteBuf curr:value)
				this.pduid.add(new PDUIDImpl(curr, null, null));
		}
	}
	
	@Override
	public List<ProSeRestrictedCodeSuffixRange> getProSeRestrictedCodeSuffixRange()
	{
		return this.proSeRestrictedCodeSuffixRange;
	}
	 
	@Override
	public void setProSeRestrictedCodeSuffixRange(List<ProSeRestrictedCodeSuffixRange> value)
	{
		this.proSeRestrictedCodeSuffixRange = value;
	}
	
	@Override
	public List<ProSeAppCodeSuffixRange> getProSeApplicationCodeSuffixRange()
	{
		return this.proSeApplicationCodeSuffixRange;
	}
	 
	@Override
	public void setProSeApplicationCodeSuffixRange(List<ProSeAppCodeSuffixRange> value)
	{
		this.proSeApplicationCodeSuffixRange = value;
	}
	
	@Override
	public List<ProSeCodeSuffixMask> getProSeCodeSuffixMask()
	{
		return this.proSeCodeSuffixMask;
	}
	 
	@Override
	public void setProSeCodeSuffixMask(List<ProSeCodeSuffixMask> value)
	{
		this.proSeCodeSuffixMask = value;
	}
	
	@Override
	public List<MonitorTarget> getMonitorTarget()
	{
		return this.monitorTarget;
	}
	 
	@Override
	public void setMonitorTarget(List<MonitorTarget> value)
	{
		this.monitorTarget = value;				
	}
	
	@Override
	public List<ByteBuf> getTargetPDUID()
	{
		if(targetPDUID==null || targetPDUID.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(TargetPDUID curr:targetPDUID)
			result.add(curr.getValue());
		
		return result;
	}
	 
	@Override
	public void setTargetPDUID(List<ByteBuf> value)
	{
		if(value==null || value.size()==0)
			this.targetPDUID = null;
		else
		{
			this.targetPDUID = new ArrayList<TargetPDUID>();
			for(ByteBuf curr:value)
				this.targetPDUID.add(new TargetPDUIDImpl(curr, null, null));
		}
	}
	
	@Override
	public String getProSeApplicationMetadata()
	{
		if(proSeApplicationMetadata == null)
			return null;
		
		return proSeApplicationMetadata.getString();
	}
	
	@Override
	public void setProSeApplicationMetadata(String value)
	{
		if(value == null)
			this.proSeApplicationMetadata = null;
		else
			this.proSeApplicationMetadata = new ProSeApplicationMetadataImpl(value, null, null);
	}
	
	@Override
	public String getApplicationData()
	{
		if(applicationData == null)
			return null;
		
		return applicationData.getString();
	}
	
	@Override
	public void setApplicationData(String value)
	{
		if(value == null)
			this.applicationData = null;
		else
			this.applicationData = new ApplicationDataImpl(value, null, null);
	}
	
	@Override
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(authApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(errorMessage);
		result.add(errorReportingHost);
		result.add(failedAvp);
		result.add(originStateId);
		
		if(redirectHost!=null)
			result.addAll(redirectHost);
		
		result.add(redirectHostUsage);
		result.add(redirectMaxCacheTime);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		result.add(proSeRequestType);
		result.add(targetedEPUID);
		result.add(proSeFunctionID);
		
		if(pduid!=null)
			result.addAll(pduid);
		
		if(proSeRestrictedCodeSuffixRange!=null)
			result.addAll(proSeRestrictedCodeSuffixRange);
		
		if(proSeApplicationCodeSuffixRange!=null)
			result.addAll(proSeApplicationCodeSuffixRange);
		
		if(proSeCodeSuffixMask!=null)
			result.addAll(proSeCodeSuffixMask);
		
		if(monitorTarget!=null)
			result.addAll(monitorTarget);
		
		if(targetPDUID!=null)
			result.addAll(targetPDUID);
		
		result.add(proSeApplicationMetadata);
		result.add(applicationData);
		
		if(load!=null)
			result.addAll(load);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}