package com.mobius.software.telco.protocols.diameter.app.cxdx;
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

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public Load getLoad();
	
	public OCOLR getOCOLR(Long ocSequenceNumber, OCReportTypeEnum ocReportType);
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public SupportedFeatures getSupportedFeatures(Long vendorId, Long featureListID, Long featureList);
	
	public ServerCapabilities getServerCapabilities();
	
	public FailedPCSCF getFailedPCSCF();
	
	public SCSCFRestorationInfo getSCSCFRestorationInfo(String username,List<RestorationInfo> restorationInfo);
	
	public AllowedWAFWWSFIdentities getAllowedWAFWWSFIdentities();
	
	public AssociatedRegisteredIdentities getAssociatedRegisteredIdentities();
	
	public AssociatedIdentities getAssociatedIdentities();
	
	public ChargingInformation getChargingInformation();
	
	public DeregistrationReason getDeregistrationReason(ReasonCodeEnum reasonCode);
	
	public SIPAuthDataItem getSIPAuthDataItem();
	
	public SIPDigestAuthenticate getSIPDigestAuthenticate(String digestRealm);
	
	public RestorationInfo getRestorationInfo(ByteBuf path,ByteBuf contact);
	
	public SubscriptionInfo getSubscriptionInfo(ByteBuf callIDSIPHeader,ByteBuf fromSIPHeader,ByteBuf toSIPHeader,ByteBuf recordRoute,ByteBuf contact);
	
	public PCSCFSubscriptionInfo getPCSCFSubscriptionInfo(ByteBuf callIDSIPHeader,ByteBuf fromSIPHeader,ByteBuf toSIPHeader,ByteBuf contact);
	
	public SARFlags getSARFlags();
	
	public RTRFlags getRTRFlags();
	
	public LIAFlags getLIAFlags();		
}
