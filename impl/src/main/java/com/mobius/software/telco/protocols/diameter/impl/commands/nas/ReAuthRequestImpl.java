package com.mobius.software.telco.protocols.diameter.impl.commands.nas;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.nas.ReAuthRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctMultiSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctSessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.DiameterClassImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CalledStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.CallingStationIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedIPv6PrefixImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.FramedInterfaceIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIPv6AddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.NASPortTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.OriginAAAProtocolImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.OriginatingLineInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ReplyMessageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.ServiceTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.StateImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctMultiSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.AcctSessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.DiameterClass;
import com.mobius.software.telco.protocols.diameter.primitives.common.ReAuthRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CalledStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.CallingStationId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedIPv6Prefix;
import com.mobius.software.telco.protocols.diameter.primitives.nas.FramedInterfaceId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPAddress;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIPv6Address;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPort;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortId;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.NASPortTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginAAAProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.OriginatingLineInfo;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ReplyMessage;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.nas.ServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nas.State;

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
@DiameterCommandImplementation(applicationId = 1, commandCode = 258, request = true)
public class ReAuthRequestImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthRequestmpl implements ReAuthRequest
{
	private OriginAAAProtocol originAAAProtocol;
	
	private NASIdentifier nasIdentifier;
	
	private NASIPAddress nasIPAddress;
	
	private NASIPv6Address nasIPv6Address;
	
	private NASPort nasPort;
	
	private NASPortId nasPortId;
	
	private NASPortType nasPortType;
	
	private ServiceType serviceType;
	
	private FramedIPAddress framedIPAddress;
	
	private FramedIPv6Prefix framedIPv6Prefix;
	
	private FramedInterfaceId framedInterfaceId;
	
	private CalledStationId calledStationId;
	
	private CallingStationId callingStationId;
	
	private OriginatingLineInfo originatingLineInfo;
	
	private AcctSessionId acctSessionId;
	
	private AcctMultiSessionId acctMultiSessionId;
	
	private State state;
	
	private List<DiameterClass> diameterClass;
	
	private List<ReplyMessage> replyMessage;
	
	protected ReAuthRequestImpl() 
	{
		super();
	}
		
	public ReAuthRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID, Long authApplicationID, ReAuthRequestTypeEnum reAuthRequestType)
	{		
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authApplicationID, reAuthRequestType);
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
	public InetAddress getFramedIPAddress() 
	{
		if(framedIPAddress==null)
			return null;
		
		return framedIPAddress.getAddress();
	}

	@Override
	public void setFramedIPAddress(Inet4Address framedIPAddress) 
	{
		if(framedIPAddress == null)
			this.framedIPAddress = null;
		else
			this.framedIPAddress = new FramedIPAddressImpl(framedIPAddress);
	}

	@Override
	public ByteBuf getFramedIPv6Prefix() 
	{
		if(framedIPv6Prefix==null)
			return null;
		
		return framedIPv6Prefix.getValue();
	}

	@Override
	public void setFramedIPv6Prefix(ByteBuf framedIPv6Prefix) 
	{
		if(framedIPv6Prefix == null)
			this.framedIPv6Prefix = null;
		else
			this.framedIPv6Prefix = new FramedIPv6PrefixImpl(framedIPv6Prefix, null, null);
	}
	
	@Override
	public Long getFramedInterfaceId() 
	{
		if(framedInterfaceId==null)
			return null;
		
		return framedInterfaceId.getLong();
	}

	@Override
	public void setFramedInterfaceId(Long framedInterfaceId) 
	{
		if(framedInterfaceId == null)
			this.framedInterfaceId = null;
		else
			this.framedInterfaceId = new FramedInterfaceIdImpl(framedInterfaceId, null, null);
	}

	@Override
	public String getCalledStationId() 
	{
		if(calledStationId == null)
			return null;
		
		return calledStationId.getString();
	}

	@Override
	public void setCalledStationId(String calledStationId) 
	{
		if(calledStationId == null)
			this.calledStationId = null;
		else
			this.calledStationId = new CalledStationIdImpl(calledStationId, null, null);
	}

	@Override
	public String getCallingStationId() 
	{
		if(callingStationId == null)
			return null;
		
		return callingStationId.getString();
	}

	@Override
	public void setCallingStationId(String callingStationId) 
	{
		if(callingStationId == null)
			this.callingStationId = null;
		else
			this.callingStationId = new CallingStationIdImpl(callingStationId, null, null);
	}

	@Override
	public void setOriginatingLineInfo(ByteBuf originatingLineInfo) 
	{
		if(originatingLineInfo == null)
			this.originatingLineInfo = null;
		else
			this.originatingLineInfo = new OriginatingLineInfoImpl(originatingLineInfo, null, null);
	}

	@Override
	public ByteBuf getOriginatingLineInfo() 
	{
		if(originatingLineInfo == null)
			return null;
		
		return originatingLineInfo.getValue();
	}

	@Override
	public ByteBuf getAcctSessionId() 
	{
		if(this.acctSessionId==null)
			return null;
		
		return this.acctSessionId.getValue();
	}

	@Override
	public void setAcctSessionId(ByteBuf value) 
	{
		if(value == null)
			this.acctSessionId = null;
		else
			this.acctSessionId = new AcctSessionIdImpl(value, null, null);			
	}

	@Override
	public String getAcctMultiSessionId()
	{
		if(this.acctMultiSessionId == null)
			return null;
		
		return this.acctMultiSessionId.getString();
	}

	@Override
	public void setAcctMultiSessionId(String value)
	{
		if(value == null)
			this.acctMultiSessionId = null;
		else
			this.acctMultiSessionId = new AcctMultiSessionIdImpl(value, null, null);			
	}

	@Override
	public ByteBuf getState() 
	{
		if(state == null)
			return null;
		
		return state.getValue();
	}

	@Override
	public void setState(ByteBuf state) 
	{
		if(state == null)
			this.state = null;
		else
			this.state = new StateImpl(state, null, null);
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

	@Override
	public List<String> getReplyMessage() 
	{
		if(replyMessage == null || replyMessage.size()==0)
			return null;
		
		List<String> result = new ArrayList<String>();
		for(ReplyMessage curr: replyMessage)
			result.add(curr.getString());
		
		return result;
	}

	@Override
	public void setReplyMessage(List<String> replyMessage) 
	{
		if(replyMessage == null || replyMessage.size()==0)
			this.replyMessage = null;
		else
		{
			this.replyMessage = new ArrayList<ReplyMessage>();
			for(String curr:replyMessage)
				this.replyMessage.add(new ReplyMessageImpl(curr, null, null));
		}
	}
}