package com.mobius.software.telco.protocols.diameter.impl.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginRealmImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.OriginStateIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ProxyInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.SessionIdImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.UserNameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvpKey;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginRealm;
import com.mobius.software.telco.protocols.diameter.primitives.common.OriginStateId;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyInfo;
import com.mobius.software.telco.protocols.diameter.primitives.common.SessionId;
import com.mobius.software.telco.protocols.diameter.primitives.common.UserName;

import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCountUtil;

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
public abstract class DiameterMessageBase extends DiameterGroupedAvpImpl implements DiameterMessage
{
	private Boolean isRetransmit;
	private Boolean isProxyable;
	private Long hopByHopIdentifier;
	private Long endToEndIdentifier;
	private ByteBuf buffer;
	private Boolean isCountable;
	
	protected SessionId sessionId;

	protected OriginHost originHost;

	protected OriginRealm originRealm;

	protected OriginStateId originStateId;

	protected UserName username;

	protected List<ProxyInfo> proxyInfo;

	private boolean sessionIdAllowed = true;
	private boolean proxyInfoAllowed = true;
	private boolean originStateIdAllowed = true;
	private boolean usernameAllowed = true;

	protected DiameterMessageBase()
	{
	}

	public DiameterMessageBase(String originHost, String originRealm, Boolean isRetransmit) throws MissingAvpException
	{
		this.isRetransmit = isRetransmit;

		setOriginHost(originHost);

		setOriginRealm(originRealm);
	}

	protected void setSessionIdAllowed(boolean allowed)
	{
		this.sessionIdAllowed = allowed;
	}

	protected void setProxyInfoAllowed(boolean allowed)
	{
		this.proxyInfoAllowed = allowed;
	}

	protected void setUsernameAllowed(boolean allowed)
	{
		this.usernameAllowed = allowed;
	}

	protected void setOriginStateIdAllowed(boolean allowed)
	{
		this.originStateIdAllowed = allowed;
	}

	@Override
	public Map<DiameterAvpKey, List<DiameterUnknownAvp>> getOptionalAvps()
	{
		return optionalAvps;
	}

	@Override
	public List<DiameterUnknownAvp> getOptionalAvps(DiameterAvpKey avpKey)
	{
		return optionalAvps.get(avpKey);
	}

	@Override
	public void addOptionalAvp(DiameterAvpKey avpKey, DiameterUnknownAvp avp)
	{
		List<DiameterUnknownAvp> currList = optionalAvps.get(avpKey);
		if (currList == null)
		{
			currList = new ArrayList<DiameterUnknownAvp>();
			List<DiameterUnknownAvp> oldAvps = optionalAvps.putIfAbsent(avpKey, currList);
			if (oldAvps != null)
				currList = oldAvps;
		}

		currList.add(avp);
	}

	@Override
	public ByteBuf getBuffer()
	{
		return this.buffer;
	}

	@Override
	public void setBuffer(ByteBuf buffer, Boolean isCountable)
	{
		this.buffer = buffer;
	}

	@Override
	public void retain()
	{
		if (buffer != null && isCountable)
			ReferenceCountUtil.retain(buffer);		
	}

	@Override
	public void release()
	{
		if (buffer != null && isCountable)
			ReferenceCountUtil.release(buffer);		
	}

	@Override
	public Boolean getIsRetransmit()
	{
		return isRetransmit;
	}

	@Override
	public Boolean getIsProxyable()
	{
		return isProxyable;
	}

	@Override
	public Long getHopByHopIdentifier()
	{
		return hopByHopIdentifier;
	}

	@Override
	public Long getEndToEndIdentifier()
	{
		return endToEndIdentifier;
	}

	@Override
	public void setIsRetransmit(Boolean value)
	{
		this.isRetransmit = value;
	}

	@Override
	public void setIsProxyable(Boolean value)
	{
		this.isProxyable = value;
	}

	@Override
	public void setHopByHopIdentifier(Long value)
	{
		this.hopByHopIdentifier = value;
	}

	@Override
	public void setEndToEndIdentifier(Long value)
	{
		this.endToEndIdentifier = value;
	}

	@Override
	public String getOriginHost()
	{
		if (originHost == null)
			return null;

		return originHost.getIdentity();
	}

	@Override
	public void setOriginHost(String value) throws MissingAvpException
	{
		if (value == null)
			throw new MissingAvpException("Origin-Host is required", Arrays.asList(new DiameterAvp[] { new OriginHostImpl() }));

		this.originHost = new OriginHostImpl(value, null, null);
	}

	@Override
	public String getOriginRealm()
	{
		if (originRealm == null)
			return null;

		return originRealm.getIdentity();
	}

	@Override
	public void setOriginRealm(String value) throws MissingAvpException
	{
		if (value == null)
			throw new MissingAvpException("Origin-Realm is required", Arrays.asList(new DiameterAvp[] { new OriginRealmImpl() }));

		this.originRealm = new OriginRealmImpl(value, null, null);
	}

	@Override
	public String getSessionId() throws AvpNotSupportedException
	{
		if (!sessionIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new SessionIdImpl() }));

		if (sessionId == null)
			return null;

		return sessionId.getString();
	}

	@Override
	public void setSessionId(String value) throws AvpNotSupportedException, MissingAvpException
	{
		if (!sessionIdAllowed && value != null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new SessionIdImpl(value, null, null) }));

		if (value == null)
			this.sessionId = null;
		else
			this.sessionId = new SessionIdImpl(value, null, null);
	}

	@Override
	public Long getOriginStateId() throws AvpNotSupportedException
	{
		if (!originStateIdAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new OriginStateIdImpl() }));

		if (originStateId == null)
			return null;

		return originStateId.getUnsigned();
	}

	@Override
	public void setOriginStateId(Long value) throws AvpNotSupportedException
	{
		if (!originStateIdAllowed && value != null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new OriginStateIdImpl(value, null, null) }));

		if (value == null)
			this.originStateId = null;
		else
			this.originStateId = new OriginStateIdImpl(value, null, null);
	}

	@Override
	public String getUsername() throws AvpNotSupportedException
	{
		if (!usernameAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new UserNameImpl() }));

		if (this.username == null)
			return null;

		return this.username.getString();
	}

	@Override
	public void setUsername(String value) throws AvpNotSupportedException, MissingAvpException
	{
		if (!usernameAllowed && value != null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new UserNameImpl(value, null, null) }));

		if (value == null)
			this.username = null;
		else
			this.username = new UserNameImpl(value, null, null);
	}

	@Override
	public List<ProxyInfo> getProxyInfo() throws AvpNotSupportedException
	{
		if (!proxyInfoAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new ProxyInfoImpl() }));

		return proxyInfo;
	}

	@Override
	public void setProxyInfo(List<ProxyInfo> value) throws AvpNotSupportedException
	{
		if (!proxyInfoAllowed && value != null && value.size() > 0)
		{
			List<DiameterAvp> avps = new ArrayList<DiameterAvp>();
			for (ProxyInfo curr : value)
				avps.add(curr);

			throw new AvpNotSupportedException("This AVP is not supported for select command/application", avps);
		}

		this.proxyInfo = value;
	}

	@Override
	public void addProxyInfo(ProxyInfo value) throws AvpNotSupportedException
	{
		if (!proxyInfoAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new ProxyInfoImpl() }));

		if (this.proxyInfo == null)
			this.proxyInfo = new ArrayList<ProxyInfo>();

		this.proxyInfo.add(value);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endToEndIdentifier == null) ? 0 : endToEndIdentifier.hashCode());
		result = prime * result + ((hopByHopIdentifier == null) ? 0 : hopByHopIdentifier.hashCode());
		result = prime * result + ((isRetransmit == null) ? 0 : isRetransmit.hashCode());
		result = prime * result + ((optionalAvps == null) ? 0 : optionalAvps.hashCode());
		result = prime * result + ((originHost == null) ? 0 : originHost.hashCode());
		result = prime * result + ((originRealm == null) ? 0 : originRealm.hashCode());
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		DiameterMessageBase other = (DiameterMessageBase) obj;
		if (endToEndIdentifier == null)
		{
			if (other.endToEndIdentifier != null)
				return false;
		}
		else if (!endToEndIdentifier.equals(other.endToEndIdentifier))
			return false;

		if (hopByHopIdentifier == null)
		{
			if (other.hopByHopIdentifier != null)
				return false;
		}
		else if (!hopByHopIdentifier.equals(other.hopByHopIdentifier))
			return false;

		if (isRetransmit == null)
		{
			if (other.isRetransmit != null)
				return false;
		}
		else if (!isRetransmit.equals(other.isRetransmit))
			return false;

		if (optionalAvps == null)
		{
			if (other.optionalAvps != null)
				return false;
		}
		else if (!optionalAvps.equals(other.optionalAvps))
			return false;

		if (originHost == null)
		{
			if (other.originHost != null)
				return false;
		}
		else if (!originHost.equals(other.originHost))
			return false;

		if (originRealm == null)
		{
			if (other.originRealm != null)
				return false;
		}
		else if (!originRealm.equals(other.originRealm))
			return false;

		if (sessionId == null)
		{
			if (other.sessionId != null)
				return false;
		}
		else if (!sessionId.equals(other.sessionId))
			return false;

		return true;
	}

	@DiameterValidate
	public DiameterException validate()
	{
		if (hopByHopIdentifier == null)
			return new DiameterException("Hop by hop identifier not set", null, ResultCodes.DIAMETER_INVALID_HDR_BITS, null);

		if (endToEndIdentifier == null)
			return new DiameterException("End to end identifier not set", null, ResultCodes.DIAMETER_INVALID_HDR_BITS, null);

		if (originHost == null)
			return new MissingAvpException("Origin-Host is required", Arrays.asList(new DiameterAvp[] { new OriginHostImpl() }));

		if (originRealm == null)
			return new MissingAvpException("Origin-Realm is required", Arrays.asList(new DiameterAvp[] { new OriginRealmImpl() }));

		if (!sessionIdAllowed && sessionId != null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { sessionId }));

		if (!proxyInfoAllowed && proxyInfo != null && proxyInfo.size() > 0)
		{
			List<DiameterAvp> avps = new ArrayList<DiameterAvp>();
			for (ProxyInfo curr : proxyInfo)
				avps.add(curr);

			return new AvpNotSupportedException("This AVP is not supported for select command/application", avps);
		}

		if (!originStateIdAllowed && originStateId != null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { originStateId }));

		if (!usernameAllowed && username != null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { username }));

		return null;
	}
}