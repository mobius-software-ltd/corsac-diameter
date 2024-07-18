package com.mobius.software.telco.protocols.diameter.impl.commands.s9atag;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s9atag.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UELocalIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s9atag.UELocalIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionId;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TDFInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UELocalIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s9atag.UELocalIPv6Prefix;

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
public class CreditControlRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.CreditControlRequestImpl implements CreditControlRequest
{
	private DRMP drmp;
	
	private SubscriptionId subscriptionId;
	
	private CalledStationId calledStationId;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private List<ChargingRuleReport> chargingRuleReport;
	
	private UELocalIPAddress ueLocalIPAddress;
	
	private UELocalIPv6Prefix ueLocalIPv6Prefix;
	
	private QoSInformation qosInformation;
	
	private TDFInformation tdfInformation;
	
	private TerminationCause terminationCause;
	
	protected CreditControlRequestImpl() 
	{
		super();
	}
	
	public CreditControlRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, Long.valueOf(ApplicationIDs.S9ATAG), ccRequestType, ccRequestNumber);
	}

	public CreditControlRequestImpl(String originHost,String originRealm,String destinationHost, String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationId, CcRequestTypeEnum ccRequestType, Long ccRequestNumber) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationId, ccRequestType, ccRequestNumber);
	}

	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
	}
	
	@Override
	public SubscriptionId getSubscriptionId() 
	{
		return subscriptionId;
	}

	@Override
	public void setSubscriptionId(SubscriptionId value) 
	{
		this.subscriptionId = value;
	}
	
	@Override
	public String getCalledStationId() 
	{
		if(calledStationId == null)
			return null;
		
		return calledStationId.getString();
	}

	@Override
	public void setCalledStationId(String value) 
	{
		if(value == null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(value, null, null);
	}

	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return ocSupportedFeatures;
	}
	
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;
	}
	
	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
	}
	
	@Override
	public List<ChargingRuleReport> getChargingRuleReport()
	{
		return this.chargingRuleReport;
	}
	
	@Override
	public void setChargingRuleReport(List<ChargingRuleReport> value)
	{
		this.chargingRuleReport = value;
	}
	
	@Override
	public InetAddress getUELocalIPAddress()
	{
		if(ueLocalIPAddress==null)
			return null;
		
		return ueLocalIPAddress.getAddress();
	}
	
	@Override
	public void setUELocalIPAddress(InetAddress value)
	{
		if(value==null)
			this.ueLocalIPAddress = null;
		else
			this.ueLocalIPAddress = new UELocalIPAddressImpl(value, null, null);			
	}
	
	@Override
	public ByteBuf getUELocalIPv6Prefix()
	{
		if(ueLocalIPv6Prefix==null)
			return null;
		
		return ueLocalIPv6Prefix.getValue();
	}
	
	@Override
	public void setUELocalIPv6Prefix(ByteBuf value)
	{
		if(value==null)
			this.ueLocalIPv6Prefix = null;
		else
			this.ueLocalIPv6Prefix = new UELocalIPv6PrefixImpl(value, null, null);			
	}
	
	@Override
	public QoSInformation getQoSInformation()
	{
		return this.qosInformation;
	}
	
	@Override
	public void setQoSInformation(QoSInformation value)
	{
		this.qosInformation = value;
	}
	
	@Override
	public void setTDFInformation(TDFInformation value)
	{
		this.tdfInformation = value;
	}
	
	@Override
	public TDFInformation getTDFInformation()
	{
		return this.tdfInformation;
	}
	
	@Override
	public TerminationCauseEnum getTerminationCause() 
	{
		if(terminationCause == null)
			return null;
		
		return terminationCause.getEnumerated(TerminationCauseEnum.class);
	}

	@Override
	public void setTerminationCause(TerminationCauseEnum value) 
	{
		if(value == null)
			this.terminationCause = null;
		else
			this.terminationCause = new TerminationCauseImpl(value, null, null);
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authApplicationId);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationRealm);
		result.add(ccRequestType);
		result.add(ccRequestNumber);
		result.add(destinationHost);
		result.add(originStateId);
		result.add(subscriptionId);
		result.add(calledStationId);
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(chargingRuleReport!=null)
			result.addAll(chargingRuleReport);
		
		result.add(ueLocalIPAddress);
		result.add(ueLocalIPv6Prefix);
		result.add(qosInformation);
		result.add(tdfInformation);
		result.add(terminationCause);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
				
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}