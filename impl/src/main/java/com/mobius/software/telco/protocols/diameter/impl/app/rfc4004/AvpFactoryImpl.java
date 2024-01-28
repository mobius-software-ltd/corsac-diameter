package com.mobius.software.telco.protocols.diameter.impl.app.rfc4004;
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

import java.text.ParseException;

import com.mobius.software.telco.protocols.diameter.app.rfc4004.AvpFactory;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPFAtoHAMSAImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPFAtoMNMSAImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPFilterRuleImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHAtoFAMSAImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHAtoMNMSAImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPHomeAgentHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMNAAAAuthImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMNtoFAMSAImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPMNtoHAMSAImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4004.MIPOriginatingForeignAAAImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPAlgorithmTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHAtoMNMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPHomeAgentHost;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNAAAAuth;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoFAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPMNtoHAMSA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPOriginatingForeignAAA;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4004.MIPReplayModeEnum;

import io.netty.buffer.ByteBuf;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public MIPMNAAAAuth getMIPMNAAAAuth(Long mipMNAAASPI,Long mipAuthInputDataLength,Long mipAuthenticatorLength,Long mipAuthenticatorOffset)
	{
		return new MIPMNAAAAuthImpl(mipMNAAASPI, mipAuthInputDataLength, mipAuthenticatorLength, mipAuthenticatorOffset);
	}
	
	public MIPHomeAgentHost getMIPHomeAgentHost(String destinationHost,String destinationRealm)
	{
		return new MIPHomeAgentHostImpl(destinationHost, destinationRealm);
	}
	
	public MIPFAtoMNMSA getMIPFAtoMNMSA(Long mipFAtoMNSPI,MIPAlgorithmTypeEnum mipAlgorithmType,ByteBuf mipSessionKey)
	{
		return new MIPFAtoMNMSAImpl(mipFAtoMNSPI, mipAlgorithmType, mipSessionKey);
	}
	
	public MIPFAtoHAMSA getMIPFAtoHAMSA(Long mipFAtoHASPI,MIPAlgorithmTypeEnum mipAlgorithmType,ByteBuf mipSessionKey)
	{
		return new MIPFAtoHAMSAImpl(mipFAtoHASPI, mipAlgorithmType, mipSessionKey);
	}
	
	public MIPMNtoFAMSA getMIPMNtoFAMSA(Long mipMNtoFASPI,MIPAlgorithmTypeEnum mipAlgorithmType,ByteBuf mipNonce)
	{
		return new MIPMNtoFAMSAImpl(mipMNtoFASPI, mipAlgorithmType, mipNonce);
	}
	
	public MIPMNtoHAMSA getMIPMNtoHAMSA(Long mipMNtoHASPI,MIPAlgorithmTypeEnum mipAlgorithmType,MIPReplayModeEnum mipReplayMode, ByteBuf mipNonce)
	{
		return new MIPMNtoHAMSAImpl(mipMNtoHASPI, mipAlgorithmType, mipReplayMode, mipNonce);
	}
	
	public MIPHAtoMNMSA getMIPHAtoMNMSA(Long mipHAtoMNSPI,MIPAlgorithmTypeEnum mipAlgorithmType,MIPReplayModeEnum mipReplayMode, ByteBuf mipSessionKey)
	{
		return new MIPHAtoMNMSAImpl(mipHAtoMNSPI, mipAlgorithmType, mipReplayMode, mipSessionKey);
	}
	
	public MIPHAtoFAMSA getMIPHAtoFAMSA(Long mipHAtoFASPI,MIPAlgorithmTypeEnum mipAlgorithmType,ByteBuf mipSessionKey)
	{
		return new MIPHAtoFAMSAImpl(mipHAtoFASPI, mipAlgorithmType, mipSessionKey);
	}
	
	public MIPOriginatingForeignAAA getMIPOriginatingForeignAAA(String originHost,String originRealm)
	{
		return new MIPOriginatingForeignAAAImpl(originHost, originRealm);
	}
	
	public MIPFilterRule getMIPFilterRule(String rule) throws ParseException
	{
		return new MIPFilterRuleImpl(rule, null, null);
	}		
}