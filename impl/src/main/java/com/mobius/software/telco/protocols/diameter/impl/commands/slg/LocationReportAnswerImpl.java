package com.mobius.software.telco.protocols.diameter.impl.commands.slg;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.slg.LocationReportAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LCSReferenceNumberImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slg.LRAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.slh.GMLCAddressImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSReferenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LRAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.slg.ReportingPLMNList;
import com.mobius.software.telco.protocols.diameter.primitives.slh.GMLCAddress;

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
@DiameterCommandImplementation(applicationId = 16777255, commandCode = 8388621, request = false)
public class LocationReportAnswerImpl extends SlgAnswerImpl implements LocationReportAnswer
{
	private GMLCAddress gmlcAddress;
	
	private LRAFlags lraFlags;
	
	private ReportingPLMNList reportingPLMNList;
	
	private LCSReferenceNumber lcsReferenceNumber;
	
	protected LocationReportAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public LocationReportAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
		
	@Override
	public InetAddress getGMLCAddress()
	{
		if(gmlcAddress == null)
			return null;
		
		return gmlcAddress.getAddress();
	}
	
	@Override
	public void setGMLCAddress(InetAddress value)
	{
		if(value == null)
			this.gmlcAddress = null;
		else
			this.gmlcAddress = new GMLCAddressImpl(value, null, null);
	}
	
	@Override
	public Long getLRAFlags()
	{
		if(lraFlags == null)
			return null;
		
		return lraFlags.getUnsigned();
	}
	
	@Override
	public void setLRAFlags(Long value)
	{
		if(value == null)
			this.lraFlags = null;
		else
			this.lraFlags = new LRAFlagsImpl(value, null, null);
	}
	
	@Override
	public ReportingPLMNList getReportingPLMNList()
	{
		return this.reportingPLMNList;
	}
	
	@Override
	public void setReportingPLMNList(ReportingPLMNList value)
	{
		this.reportingPLMNList = value;
	}
	
	@Override
	public ByteBuf getLCSReferenceNumber()
	{
		if(lcsReferenceNumber == null)
			return null;
		
		return lcsReferenceNumber.getValue();
	}
	
	@Override
	public void setLCSReferenceNumber(ByteBuf value)
	{
		if(value == null)
			this.lcsReferenceNumber = null;
		else
			this.lcsReferenceNumber = new LCSReferenceNumberImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(gmlcAddress);
		result.add(lraFlags);
		result.add(reportingPLMNList);
		result.add(lcsReferenceNumber);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		return result;
	}
}