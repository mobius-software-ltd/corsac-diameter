package com.mobius.software.telco.protocols.diameter.impl.commands.nas;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.nas.AccountingAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.TerminationCauseImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.OriginAAAProtocolImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ServiceTypeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AccountingRecordTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCause;
import com.mobius.software.telco.protocols.diameter.primitives.common.TerminationCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPort;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;

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
@DiameterCommandImplementation(applicationId = 1, commandCode = 271, request = false)
public class AccountingAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.AccountingAnswerImpl implements AccountingAnswer
{
	private OriginAAAProtocol originAAAProtocol;
	
	private NASIdentifier nasIdentifier;
	
	private NASIPAddress nasIPAddress;
	
	private NASIPv6Address nasIPv6Address;
	
	private NASPort nasPort;
	
	private NASPortId nasPortId;
	
	private NASPortType nasPortType;
	
	private ServiceType serviceType;
	
	private TerminationCause terminationCause;
	
	private List<DiameterClass> diameterClass;
	
	protected AccountingAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(true);
		setVendorSpecificApplicationIdAllowed(false);
	}
	
	public AccountingAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID, AccountingRecordTypeEnum accountingRecordType, Long accountingRecordNumber, Long acctApplicationId)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, accountingRecordType, accountingRecordNumber);
		setExperimentalResultAllowed(true);
		setVendorSpecificApplicationIdAllowed(false);
		
		setAcctApplicationId(acctApplicationId);
	}

	@Override
	public void setAcctApplicationId(Long value) 
	{
		if(value==null)
			throw new IllegalArgumentException("Acct-Application-Id is required");	
		
		super.setAcctApplicationId(value);
	}

	@Override
	public OriginAAAProtocolEnum getOriginAAAProtocol() 
	{
		if(originAAAProtocol == null)
			return null;
		
		return originAAAProtocol.getEnumerated(OriginAAAProtocolEnum.class);
	}

	@Override
	public void setOriginAAAProtocol(OriginAAAProtocolEnum originAAAProtocol) 
	{
		if(originAAAProtocol == null)
			this.originAAAProtocol = null;
		else
			this.originAAAProtocol = new OriginAAAProtocolImpl(originAAAProtocol, null, null);
	}

	@Override
	public String getNASIdentifier() 
	{
		if(nasIdentifier == null)
			return null;
		
		return nasIdentifier.getString();
	}

	@Override
	public void setNASIdentifier(String nasIdentifier) 
	{
		if(nasIdentifier == null)
			this.nasIdentifier = null;
		else
			this.nasIdentifier = new NASIdentifierImpl(nasIdentifier, null, null);
	}

	@Override
	public InetAddress getNASIPAddress() 
	{
		if(nasIPAddress == null)
			return null;
		
		return nasIPAddress.getAddress();
	}

	@Override
	public void setNASIPAddress(Inet4Address nasIPAddress) 
	{
		if(nasIPAddress == null)
			this.nasIPAddress = null;
		else
			this.nasIPAddress = new NASIPAddressImpl(nasIPAddress);
	}

	@Override
	public InetAddress getNASIPv6Address() 
	{
		if(nasIPv6Address == null)
			return null;
		
		return nasIPv6Address.getAddress();
	}

	@Override
	public void setNASIPv6Address(Inet6Address nasIPv6Address) 
	{
		if(nasIPv6Address == null)
			this.nasIPv6Address = null;
		else
			this.nasIPv6Address = new NASIPv6AddressImpl(nasIPv6Address);
	}

	@Override
	public Long getNASPort() 
	{
		if(nasPort == null)
			return null;
		
		return nasPort.getUnsigned();
	}

	@Override
	public void setNASPort(Long nasPort) 
	{
		if(nasPort == null)
			this.nasPort = null;
		else
			this.nasPort = new NASPortImpl(nasPort, null, null);
	}

	@Override
	public String getNASPortId() 
	{
		if(nasPortId == null)
			return null;
		
		return nasPortId.getString();
	}

	@Override
	public void setNASPortId(String nasPortId) 
	{
		if(nasPortId == null)
			this.nasPortId = null;
		else
			this.nasPortId = new NASPortIdImpl(nasPortId, null, null);
	}

	@Override
	public NASPortTypeEnum getNASPortType() 
	{
		if(nasPortType == null)
			return null;
		
		return nasPortType.getEnumerated(NASPortTypeEnum.class);
	}

	@Override
	public void setNASPortType(NASPortTypeEnum nasPortType) 
	{
		if(nasPortType == null)
			this.nasPortType = null;
		else
			this.nasPortType = new NASPortTypeImpl(nasPortType, null, null);
	}

	@Override
	public ServiceTypeEnum getServiceType() 
	{
		if(serviceType == null)
			return null;
		
		return serviceType.getEnumerated(ServiceTypeEnum.class);
	}

	@Override
	public void setServiceType(ServiceTypeEnum serviceType) 
	{
		if(serviceType == null)
			this.serviceType = null;
		else
			this.serviceType = new ServiceTypeImpl(serviceType, null, null);
	}

	@Override
	public TerminationCauseEnum getTerminationCause() 
	{
		if(terminationCause == null)
			return null;
		
		return terminationCause.getEnumerated(TerminationCauseEnum.class);
	}

	@Override
	public void setTerminationCause(TerminationCauseEnum terminationCauseEnum) 
	{
		if(terminationCauseEnum == null)
			this.terminationCause = null;
		else
			this.terminationCause = new TerminationCauseImpl(terminationCauseEnum, null, null);
	}

	@Override
	public List<ByteBuf> getDiameterClass() 
	{
		if(diameterClass == null || diameterClass.size()==0)
			return null;
		
		List<ByteBuf> result = new ArrayList<ByteBuf>();
		for(DiameterClass curr: diameterClass)
			result.add(curr.getValue());
		
		return result;
	}

	@Override
	public void setDiameterClass(List<ByteBuf> diameterClass) 
	{
		if(diameterClass == null || diameterClass.size()==0)
			this.diameterClass = null;
		else
		{
			this.diameterClass = new ArrayList<DiameterClass>();
			for(ByteBuf curr:diameterClass)
				this.diameterClass.add(new DiameterClassImpl(curr, null, null));
		}
	}
}