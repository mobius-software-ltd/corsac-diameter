package com.mobius.software.telco.protocols.diameter.impl.commands.s6c;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s6c.SendRoutingInfoForSMRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMDeliveryNotIntendedImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMRPMTIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6c.SMRPSMEAImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.SCAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryNotIntended;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMDeliveryNotIntendedEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMRPMTI;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMRPMTIEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SMRPSMEA;
import com.mobius.software.telco.protocols.diameter.primitives.s6c.SRRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SCAddress;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMSMICorrelationID;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;

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
public class SendRoutingInfoForSMRequestImpl extends S6cRequestImpl implements SendRoutingInfoForSMRequest
{
	private MSISDN msisdn;
	
	private SMSMICorrelationID smSMICorrelationID;
	
	private SCAddress scAddress;
	
	private SMRPMTI smRPMTI;
	
	private SMRPSMEA smRPSMEA;
	
	private SRRFlags srrFlags;
	
	private SMDeliveryNotIntended smDeliveryNotIntended;
	
	protected SendRoutingInfoForSMRequestImpl() 
	{
		super();
	}
	
	public SendRoutingInfoForSMRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);		
	}
	
	@Override
	public String getMSISDN()
	{
		if(msisdn == null)
			return null;
		
		return msisdn.getAddress();
	}
	
	@Override
	public void setMSISDN(String value)
	{
		if(value == null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);
	}
	
	@Override
	public SMSMICorrelationID getSMSMICorrelationID()
	{
		return this.smSMICorrelationID;
	}
	 
	@Override
	public void setSMSMICorrelationID(SMSMICorrelationID value)
	{
		this.smSMICorrelationID = value;
	}	
	
	@Override
	public String getSCAddress()
	{
		if(scAddress == null)
			return null;
		
		return scAddress.getAddress();
	}
	
	@Override
	public void setSCAddress(String value)
	{
		if(value == null)
			this.scAddress = null;
		else
			this.scAddress = new SCAddressImpl(value);
	}	
	
	@Override
	public SMRPMTIEnum getSMRPMTI()
	{
		if(smRPMTI == null)
			return null;
		
		return smRPMTI.getEnumerated(SMRPMTIEnum.class);
	}
	
	@Override
	public void setSMRPMTI(SMRPMTIEnum value)
	{
		if(value == null)
			this.smRPMTI = null;
		else
			this.smRPMTI = new SMRPMTIImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getSMRPSMEA()
	{
		if(smRPSMEA == null)
			return null;
		
		return smRPSMEA.getValue();
	}
	
	@Override
	public void setSMRPSMEA(ByteBuf value)
	{
		if(value == null)
			this.smRPSMEA = null;
		else
			this.smRPSMEA = new SMRPSMEAImpl(value, null, null);
	}
	
	@Override
	public SRRFlags getSRRFlags()
	{
		return srrFlags;
	}
	
	@Override
	public void setSRRFlags(SRRFlags value)
	{
		this.srrFlags = value;
	}
	
	@Override
	public SMDeliveryNotIntendedEnum getSMDeliveryNotIntended()
	{
		if(smDeliveryNotIntended == null)
			return null;
		
		return smDeliveryNotIntended.getEnumerated(SMDeliveryNotIntendedEnum.class);
	}
	
	@Override
	public void setSMDeliveryNotIntended(SMDeliveryNotIntendedEnum value)
	{
		if(value == null)
			this.smDeliveryNotIntended = null;
		else
			this.smDeliveryNotIntended = new SMDeliveryNotIntendedImpl(value, null, null);
	}	
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(vendorSpecificApplicationId);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(msisdn);
		result.add(username);
		result.add(smSMICorrelationID);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(scAddress);
		result.add(smRPMTI);
		result.add(smRPSMEA);
		result.add(srrFlags);
		result.add(smDeliveryNotIntended);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		return result;
	}
}