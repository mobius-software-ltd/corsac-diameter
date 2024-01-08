package com.mobius.software.telco.protocols.diameter.impl.commands.gxx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.gxx.ReAuthAnswer;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.TGPP2BSIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPMSTimeZoneImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPSGSNMCCMNCImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gmb.RAIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.NetLocAccessSupportImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.RATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.UserLocationInfoTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7944.DRMPImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPP2BSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPMSTimeZone;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPSGSNMCCMNC;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gmb.RAI;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupport;
import com.mobius.software.telco.protocols.diameter.primitives.gx.NetLocAccessSupportEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATType;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.UserLocationInfoTime;
import com.mobius.software.telco.protocols.diameter.primitives.gxx.QoSRuleReport;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMP;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7944.DRMPEnum;

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
@DiameterCommandImplementation(applicationId = 16777266, commandCode = 258, request = false)
public class ReAuthAnswerImpl extends com.mobius.software.telco.protocols.diameter.impl.commands.common.ReAuthAnswerImpl implements ReAuthAnswer
{
	private DRMP drmp;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	 
	private RATType ratType;
	
	private TGPPSGSNMCCMNC tgppSGSNMCCMNC;
	
	private RAI rai;
	
	private TGPPUserLocationInfo tgppUserLocationInfo;
	
	private UserLocationInfoTime userLocationInfoTime;
	
	private NetLocAccessSupport netLocAccessSupport;
	
	private UserCSGInformation userCSGInformation;
	
	private TGPPMSTimeZone tgppMSTimeZone;
	
	private TGPP2BSID tgpp2BSID;
	
	private List<QoSRuleReport> qosRuleReport;
	
	protected ReAuthAnswerImpl() 
	{
	}
	
	public ReAuthAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);		
	}
	
	@Override
	public DRMPEnum getDRMP() 
	{
		if(drmp==null)
			return null;
		
		return drmp.getEnumerated(DRMPEnum.class);
	}

	@Override
	public void setDRMP(DRMPEnum value) 
	{
		if(value==null)
			this.drmp = null;
		else
			this.drmp = new DRMPImpl(value, null, null);
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return ocSupportedFeatures;
	}
	
	@Override
	public void setOCSupportedFeatures(OCSupportedFeatures value)
	{
		this.ocSupportedFeatures = value;
	}
	
	@Override
	public OCOLR getOCOLR()
	{
		return this.ocOLR;
	}
	
	@Override
	public void setOCOLR(OCOLR value)
	{
		this.ocOLR = value;
	}
	
	@Override
	public RATTypeEnum getRATType()
	{
		if(ratType==null)
			return null;
		
		return this.ratType.getEnumerated(RATTypeEnum.class);
	}
	
	@Override
	public void setRATType(RATTypeEnum value)
	{
		if(value==null)
			this.ratType = null;
		else
			this.ratType = new RATTypeImpl(value, null, null);
	}
	
	@Override
	public String getTGPPSGSNMCCMNC() 
	{
		if(tgppSGSNMCCMNC==null)
			return null;
		
		return tgppSGSNMCCMNC.getString();
	}

	@Override
	public void setTGPPSGSNMCCMNC(String value) 
	{
		if(value == null)
			this.tgppSGSNMCCMNC = null;
		else
			this.tgppSGSNMCCMNC = new TGPPSGSNMCCMNCImpl(value, null, null);
	}
	
	@Override
	public String getRAI()
	{
		if(rai==null)
			return null;
		
		return rai.getString();
	}
	
	@Override
	public void setRAI(String value)
	{
		if(value==null)
			this.rai = null;
		else
			this.rai = new RAIImpl(value, null, null);			
	}
	
	@Override
	public ByteBuf getTGPPUserLocationInfo() 
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}

	@Override
	public void setTGPPUserLocationInfo(ByteBuf value) 
	{
		if(value == null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);
	}
	
	@Override
	public Date getUserLocationInfoTime()
	{
		if(userLocationInfoTime==null)
			return null;
		
		return this.userLocationInfoTime.getDateTime();
	}
	
	@Override
	public void setUserLocationInfoTime(Date value)
	{
		if(value==null)
			this.userLocationInfoTime = null;
		else
			this.userLocationInfoTime = new UserLocationInfoTimeImpl(value, null, null);
	}	
	
	@Override
	public NetLocAccessSupportEnum getNetLocAccessSupport()
	{
		if(netLocAccessSupport==null)
			return null;
		
		return this.netLocAccessSupport.getEnumerated(NetLocAccessSupportEnum.class);
	}
	
	@Override
	public void setNetLocAccessSupport(NetLocAccessSupportEnum value)
	{
		if(value == null)
			this.netLocAccessSupport = null;
		else
			this.netLocAccessSupport = new NetLocAccessSupportImpl(value, null, null);
	}
	
	@Override
	public UserCSGInformation getUserCSGInformation()
	{
		return this.userCSGInformation;
	}
	
	@Override
	public void setUserCSGInformation(UserCSGInformation value)
	{
		this.userCSGInformation = value;
	}
	
	@Override
	public ByteBuf getTGPPMSTimeZone() 
	{
		if(tgppMSTimeZone==null)
			return null;
		
		return tgppMSTimeZone.getValue();
	}

	@Override
	public void setTGPPMSTimeZone(ByteBuf value) 
	{
		if(value == null)
			this.tgppMSTimeZone = null;
		else
			this.tgppMSTimeZone = new TGPPMSTimeZoneImpl(value, null, null);
	}
	
	@Override
	public ByteBuf getTGPP2BSID() 
	{
		if(tgpp2BSID==null)
			return null;
		
		return tgpp2BSID.getValue();
	}
	
	@Override
	public void setTGPP2BSID(ByteBuf value) 
	{
		if(value == null)
			this.tgpp2BSID = null;
		else
			this.tgpp2BSID = new TGPP2BSIDImpl(value, null, null);
	}
	
	@Override
	public List<QoSRuleReport> getQoSRuleReport()
	{
		return this.qosRuleReport;
	}
	
	@Override
	public void setQoSRuleReport(List<QoSRuleReport> value)
	{
		this.qosRuleReport = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(originHost);
		result.add(originRealm);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(originStateId);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		result.add(ratType);
		result.add(tgppSGSNMCCMNC);
		result.add(rai);
		result.add(tgppUserLocationInfo);
		result.add(userLocationInfoTime);
		result.add(netLocAccessSupport);
		result.add(userCSGInformation);
		result.add(tgppMSTimeZone);
		result.add(tgpp2BSID);
		
		if(qosRuleReport!=null)
			result.addAll(qosRuleReport);
		
		result.add(errorMessage);
		result.add(errorReportingHost);
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}