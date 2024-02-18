package com.mobius.software.telco.protocols.diameter.app.rfc4740;
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

import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
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

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public SIPServerCapabilities getSIPServerCapabilities();
	
	public SIPAuthDataItem getSIPAuthDataItem(SIPAuthenticationSchemeEnum sipAuthenticationScheme) throws MissingAvpException;
	
	public SIPAccountingInformation getSIPAccountingInformation();
	
	public SIPUserData getSIPUserData(String sipUserDataType,ByteBuf sipUserDataContents) throws MissingAvpException;
	
	public SIPDeregistrationReason getSIPDeregistrationReason(SIPReasonCodeEnum sipReasonCode) throws MissingAvpException;
	
	public SIPAuthenticationInfo getSIPAuthenticationInfo();
	
	public SIPAuthorization getSIPAuthorization(String digestUsername,String digestRealm,String digestNonce,String digestURI,String digestResponse) throws MissingAvpException;
	
	public SIPAuthenticate getSIPAuthenticate(String digestRealm) throws MissingAvpException;
}
