package com.mobius.software.telco.protocols.diameter.impl.app.pc2;
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

import com.mobius.software.telco.protocols.diameter.app.pc2.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.BannedUserTargetImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.MonitorTargetImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc2.ProSeCodeSuffixMaskImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ProSeAppCodeSuffixRangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.pc6.ProSeRestrictedCodeSuffixRangeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.BannedUserTarget;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.MonitorTarget;
import com.mobius.software.telco.protocols.diameter.primitives.pc2.ProSeCodeSuffixMask;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeAppCodeSuffixRange;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.ProSeRestrictedCodeSuffixRange;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public Load getLoad()
	{
		return new LoadImpl();
	}
	
	public MonitorTarget getMonitorTarget(String targetRPAUID,ByteBuf pduid) throws MissingAvpException
	{
		return new MonitorTargetImpl(targetRPAUID, pduid);
	}
	
	public ProSeCodeSuffixMask getProSeCodeSuffixMask(ByteBuf suffixCode,List<ByteBuf> suffixMask) throws MissingAvpException
	{
		return new ProSeCodeSuffixMaskImpl(suffixCode, suffixMask);
	}
	
	public ProSeAppCodeSuffixRange getProSeAppCodeSuffixRange(ByteBuf beginningSuffix) throws MissingAvpException
	{
		return new ProSeAppCodeSuffixRangeImpl(beginningSuffix);
	}
	
	public ProSeRestrictedCodeSuffixRange getProSeRestrictedCodeSuffixRange(ByteBuf beginningSuffix) throws MissingAvpException
	{
		return new ProSeRestrictedCodeSuffixRangeImpl(beginningSuffix);
	}
	
	public BannedUserTarget getBannedUserTarget(String targetRPAUID,ByteBuf targetPDUID) throws MissingAvpException
	{
		return new BannedUserTargetImpl(targetRPAUID, targetPDUID);
	}
}