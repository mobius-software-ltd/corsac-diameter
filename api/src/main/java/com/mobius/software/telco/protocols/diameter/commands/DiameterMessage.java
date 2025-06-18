package com.mobius.software.telco.protocols.diameter.commands;
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

import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterGroupedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyInfo;

import io.netty.buffer.ByteBuf;

/**
 *
 * @author yulian oifa
 *
 */
public interface DiameterMessage extends DiameterGroupedAvp
{
	public ByteBuf getBuffer();

	void setBuffer(ByteBuf value);

	void retain();

	void release();

	public Boolean getIsRetransmit();

	public Boolean getIsProxyable();

	public Long getHopByHopIdentifier();

	public Long getEndToEndIdentifier();

	void setIsRetransmit(Boolean value);

	void setIsProxyable(Boolean value);

	void setHopByHopIdentifier(Long value);

	void setEndToEndIdentifier(Long value);

	public String getOriginHost();

	void setOriginHost(String value) throws MissingAvpException;

	public String getOriginRealm();

	void setOriginRealm(String value) throws MissingAvpException;

	public String getSessionId() throws AvpNotSupportedException;

	void setSessionId(String value) throws AvpNotSupportedException, MissingAvpException;

	public Long getOriginStateId() throws AvpNotSupportedException;

	void setOriginStateId(Long value) throws AvpNotSupportedException;

	public String getUsername() throws AvpNotSupportedException;

	void setUsername(String value) throws AvpNotSupportedException, MissingAvpException;

	public List<ProxyInfo> getProxyInfo() throws AvpNotSupportedException;

	void setProxyInfo(List<ProxyInfo> value) throws AvpNotSupportedException;

	void addProxyInfo(ProxyInfo proxyInfo) throws AvpNotSupportedException;
}