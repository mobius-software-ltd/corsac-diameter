package com.mobius.software.telco.protocols.diameter.impl.app.cxdx;
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

import com.mobius.software.telco.protocols.diameter.app.cxdx.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.AllowedWAFWWSFIdentitiesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.AssociatedIdentitiesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.AssociatedRegisteredIdentitiesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ChargingInformationImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.DeregistrationReasonImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.FailedPCSCFImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.LIAFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.PCSCFSubscriptionInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.RTRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.RestorationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SARFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SCSCFRestorationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SIPAuthDataItemImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SIPDigestAuthenticateImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.ServerCapabilitiesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SubscriptionInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AllowedWAFWWSFIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.AssociatedRegisteredIdentities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ChargingInformation;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.DeregistrationReason;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.FailedPCSCF;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.LIAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.PCSCFSubscriptionInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.RTRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ReasonCodeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.RestorationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SARFlags;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SCSCFRestorationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPAuthDataItem;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SIPDigestAuthenticate;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.ServerCapabilities;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SubscriptionInfo;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCReportTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;

import io.netty.buffer.ByteBuf;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{
	public Load getLoad()
	{
		return new LoadImpl();
	}
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType) throws MissingAvpException
	{
		return new OCOLRImpl(ocSequenceNumber, ocReportType);
	}
	
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return new OCSupportedFeaturesImpl();
	}
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList) throws MissingAvpException
	{
		return new SupportedFeaturesImpl(vendorId, featureListID, featureList);
	}
	
	public ServerCapabilities getServerCapabilities()
	{
		return new ServerCapabilitiesImpl();
	}
	
	public FailedPCSCF getFailedPCSCF()
	{
		return new FailedPCSCFImpl();
	}
	
	public SCSCFRestorationInfo getSCSCFRestorationInfo(String username,List<RestorationInfo> restorationInfo) throws MissingAvpException
	{
		return new SCSCFRestorationInfoImpl(username, restorationInfo);
	}
	
	public AllowedWAFWWSFIdentities getAllowedWAFWWSFIdentities()
	{
		return new AllowedWAFWWSFIdentitiesImpl();
	}
	
	public AssociatedRegisteredIdentities getAssociatedRegisteredIdentities()
	{
		return new AssociatedRegisteredIdentitiesImpl();
	}
	
	public AssociatedIdentities getAssociatedIdentities()
	{
		return new AssociatedIdentitiesImpl();
	}
	
	public ChargingInformation getChargingInformation()
	{
		return new ChargingInformationImpl();
	}
	
	public DeregistrationReason getDeregistrationReason(ReasonCodeEnum reasonCode) throws MissingAvpException
	{
		return new DeregistrationReasonImpl(reasonCode);
	}
	
	public SIPAuthDataItem getSIPAuthDataItem()
	{
		return new SIPAuthDataItemImpl();
	}
	
	public SIPDigestAuthenticate getSIPDigestAuthenticate(String digestRealm) throws MissingAvpException
	{
		return new SIPDigestAuthenticateImpl(digestRealm);
	}
	
	public RestorationInfo getRestorationInfo(ByteBuf path,ByteBuf contact) throws MissingAvpException
	{
		return new RestorationInfoImpl(path, contact);
	}
	
	public SubscriptionInfo getSubscriptionInfo(ByteBuf callIDSIPHeader,ByteBuf fromSIPHeader,ByteBuf toSIPHeader,ByteBuf recordRoute,ByteBuf contact) throws MissingAvpException
	{
		return new SubscriptionInfoImpl(callIDSIPHeader, fromSIPHeader, toSIPHeader, recordRoute, contact);
	}
	
	public PCSCFSubscriptionInfo getPCSCFSubscriptionInfo(ByteBuf callIDSIPHeader,ByteBuf fromSIPHeader,ByteBuf toSIPHeader,ByteBuf contact) throws MissingAvpException
	{
		return new PCSCFSubscriptionInfoImpl(callIDSIPHeader, fromSIPHeader, toSIPHeader, contact);
	}
	
	public SARFlags getSARFlags()
	{
		return new SARFlagsImpl();
	}
	
	public RTRFlags getRTRFlags()
	{
		return new RTRFlagsImpl();
	}
	
	public LIAFlags getLIAFlags()
	{
		return new LIAFlagsImpl();
	}		
}
