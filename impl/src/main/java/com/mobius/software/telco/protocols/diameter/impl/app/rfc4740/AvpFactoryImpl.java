package com.mobius.software.telco.protocols.diameter.impl.app.rfc4740;
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

import com.mobius.software.telco.protocols.diameter.app.rfc4740.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPAccountingInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPAuthDataItemImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPAuthenticateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPAuthenticationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPAuthorizationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPDeregistrationReasonImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPServerCapabilitiesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc4740.SIPUserDataImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAccountingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthenticate;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthenticationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthenticationSchemeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPAuthorization;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPDeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPReasonCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPServerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.rfc4740.SIPUserData;

import io.netty.buffer.ByteBuf;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public SIPServerCapabilities getSIPServerCapabilities()
	{
		return new SIPServerCapabilitiesImpl();
	}
	
	public SIPAuthDataItem getSIPAuthDataItem(SIPAuthenticationSchemeEnum sipAuthenticationScheme) throws MissingAvpException
	{
		return new SIPAuthDataItemImpl(sipAuthenticationScheme);
	}
	
	public SIPAccountingInformation getSIPAccountingInformation()
	{
		return new SIPAccountingInformationImpl();
	}
	
	public SIPUserData getSIPUserData(String sipUserDataType,ByteBuf sipUserDataContents) throws MissingAvpException
	{
		return new SIPUserDataImpl(sipUserDataType, sipUserDataContents);
	}
	
	public SIPDeregistrationReason getSIPDeregistrationReason(SIPReasonCodeEnum sipReasonCode) throws MissingAvpException
	{
		return new SIPDeregistrationReasonImpl(sipReasonCode);
	}
	
	public SIPAuthenticationInfo getSIPAuthenticationInfo()
	{
		return new SIPAuthenticationInfoImpl();
	}
	
	public SIPAuthorization getSIPAuthorization(String digestUsername,String digestRealm,String digestNonce,String digestURI,String digestResponse) throws MissingAvpException
	{
		return new SIPAuthorizationImpl(digestUsername, digestRealm, digestNonce, digestURI, digestResponse);
	}
	
	public SIPAuthenticate getSIPAuthenticate(String digestRealm) throws MissingAvpException
	{
		return new SIPAuthenticateImpl(digestRealm);
	}
}
