package com.mobius.software.telco.protocols.diameter.impl.primitives.accounting;
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

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.RatingGroupImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ServiceIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPRATTypeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gi.TGPPUserLocationInfoImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.ChargingRuleBaseNameImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.PresenceReportingAreaStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TrafficSteeringPolicyIdentifierDLImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.TrafficSteeringPolicyIdentifierULImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nas.AccountingInputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.ApplicationServiceProviderIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rx.SponsorIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sd.ADCRuleBaseNameImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AFCorrelationInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.APNRateControl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeCondition;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LocalSequenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.RelatedChangeConditionInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SGSNAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceDataContainer;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceSpecificInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPP2BSID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPPSDataOffStatus;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TGPPPSDataOffStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeFirstUsage;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeLastUsage;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeUsage;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UWANUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.UserCSGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VoLTEInformation;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RatingGroup;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ServiceIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPRATType;
import com.mobius.software.telco.protocols.diameter.primitives.gi.TGPPUserLocationInfo;
import com.mobius.software.telco.protocols.diameter.primitives.gx.ChargingRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatus;
import com.mobius.software.telco.protocols.diameter.primitives.gx.PresenceReportingAreaStatusEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSInformation;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TrafficSteeringPolicyIdentifierDL;
import com.mobius.software.telco.protocols.diameter.primitives.gx.TrafficSteeringPolicyIdentifierUL;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingInputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.nas.AccountingOutputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.rx.ApplicationServiceProviderIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.rx.SponsorIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleBaseName;
import com.mobius.software.telco.protocols.diameter.primitives.t6a.ServingPLMNRateControl;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 2040L, vendorId = KnownVendorIDs.TGPP_ID)
public class ServiceDataContainerImpl implements ServiceDataContainer
{
   	private AFCorrelationInformation afCorrelationInformation;
	private ChargingRuleBaseName chargingRuleBaseName;
	private AccountingInputOctets accountingInputOctets;
	private AccountingOutputOctets accountingOutputOctets;
	private LocalSequenceNumber localSequenceNumber;
	private QoSInformation qosInformation;
	private RatingGroup ratingGroup; 
	private ChangeTime changeTime; 
	private ServiceIdentifier serviceIdentifier; 
	private ServiceSpecificInfo serviceSpecificInfo; 
	private ADCRuleBaseName adcRuleBaseName;
   	private SGSNAddress sgsnAddress; 
   	private TimeFirstUsage timeFirstUsage;
   	private TimeLastUsage timeLastUsage;
   	private TimeUsage timeUsage;
 	private List<ChangeCondition> changeCondition;
   	private TGPPUserLocationInfo tgppUserLocationInfo;
   	private TGPP2BSID tgpp2BSID;
   	private UWANUserLocationInfo uwanUserLocationInfo; 
   	private TWANUserLocationInfo twanUserLocationInfo;
   	private SponsorIdentity sponsorIdentity;
   	private ApplicationServiceProviderIdentity applicationServiceProviderIdentity; 
 	private List<PresenceReportingAreaInformation> presenceReportingAreaInformation;
   	private PresenceReportingAreaStatus presenceReportingAreaStatus;
   	private UserCSGInformation userCSGInformation;  
	private TGPPRATType tgppRATType;
   	private RelatedChangeConditionInformation relatedChangeConditionInformation;   
   	private ServingPLMNRateControl servingPLMNRateControl;
   	private APNRateControl apnRateControl;
 	private TGPPPSDataOffStatus tgppPSDataOffStatus; 
	private TrafficSteeringPolicyIdentifierDL trafficSteeringPolicyIdentifierDL;
	private TrafficSteeringPolicyIdentifierUL trafficSteeringPolicyIdentifierUL;
	private VoLTEInformation volteInformation; 
 			
	public ServiceDataContainerImpl()
	{
		
	}
	
	public AFCorrelationInformation getAFCorrelationInformation()
	{
		return this.afCorrelationInformation;
	}
	
	public void setAFCorrelationInformation(AFCorrelationInformation value)
	{
		this.afCorrelationInformation = value;
	}
	
	public String getChargingRuleBaseName()
	{
		if(chargingRuleBaseName==null)
			return null;
		
		return chargingRuleBaseName.getString();
	}
	
	public void setChargingRuleBaseName(String value)
	{
		if(value==null)
			this.chargingRuleBaseName = null;
		else
			this.chargingRuleBaseName = new ChargingRuleBaseNameImpl(value, null, null);			
	}
	
	public Long getAccountingInputOctets()
	{
		if(accountingInputOctets==null)
			return null;
		
		return accountingInputOctets.getLong();
	}
	
	public void setAccountingInputOctets(Long value)
	{
		if(value==null)
			this.accountingInputOctets = null;
		else
			this.accountingInputOctets = new AccountingInputOctetsImpl(value, null, null);			
	}
	
	public Long getAccountingOutputOctets()
	{
		if(accountingOutputOctets==null)
			return null;
		
		return accountingOutputOctets.getLong();
	}
	
	public void setAccountingOutputOctets(Long value)
	{
		if(value==null)
			this.accountingInputOctets = null;
		else
			this.accountingInputOctets = new AccountingInputOctetsImpl(value, null, null);			
	}
	
	public Long getLocalSequenceNumber()
	{
		if(localSequenceNumber==null)
			return null;
		
		return localSequenceNumber.getUnsigned();
	}
	
	public void setLocalSequenceNumber(Long value)
	{
		if(value==null)
			this.localSequenceNumber = null;
		else
			this.localSequenceNumber = new LocalSequenceNumberImpl(value, null, null);			
	}
	
	public QoSInformation getQoSInformation()
	{
		return qosInformation;
	}
	
	public void setQoSInformation(QoSInformation value)
	{
		this.qosInformation = value;
	}
	
	public Long getRatingGroup()
	{
		if(ratingGroup==null)
			return null;
		
		return ratingGroup.getUnsigned();
	}
	
	public void setRatingGroup(Long value)
	{
		if(value==null)
			this.ratingGroup = null;
		else
			this.ratingGroup = new RatingGroupImpl(value, null, null);			
	}
	
	public Date getChangeTime()
	{
		if(changeTime==null)
			return null;
		
		return changeTime.getDateTime();
	}
	
	public void setChangeTime(Date value)
	{
		if(value==null)
			this.changeTime = null;
		else
			this.changeTime = new ChangeTimeImpl(value, null, null);			
	}
	
	public Long getServiceIdentifier()
	{
		if(serviceIdentifier==null)
			return null;
		
		return serviceIdentifier.getUnsigned();
	}
	
	public void setServiceIdentifier(Long value)
	{
		if(value==null)
			this.serviceIdentifier = null;
		else
			this.serviceIdentifier = new ServiceIdentifierImpl(value, null, null);			
	}
	
	public ServiceSpecificInfo getServiceSpecificInfo()
	{
		return this.serviceSpecificInfo;
	}
	
	public void setServiceSpecificInfo(ServiceSpecificInfo value)
	{
		this.serviceSpecificInfo = value;
	}
	
	public String getADCRuleBaseName()
	{
		if(adcRuleBaseName==null)
			return null;
		
		return adcRuleBaseName.getString();
	}
	
	public void setADCRuleBaseName(String value)
	{
		if(value==null)
			this.adcRuleBaseName = null;
		else
			this.adcRuleBaseName = new ADCRuleBaseNameImpl(value, null, null);			
	}
	
	public InetAddress getSGSNAddress()
	{
		if(sgsnAddress==null)
			return null;
		
		return sgsnAddress.getAddress();
	}
	
	public void setSGSNAddress(InetAddress value)
	{
		if(value==null)
			this.sgsnAddress = null;
		else
			this.sgsnAddress = new SGSNAddressImpl(value, null, null);			
	}
	
	public Date getTimeFirstUsage()
	{
		if(timeFirstUsage==null)
			return null;
		
		return timeFirstUsage.getDateTime();
	}
	
	public void setTimeFirstUsage(Date value)
	{
		if(value==null)
			this.timeFirstUsage = null;
		else
			this.timeFirstUsage = new TimeFirstUsageImpl(value, null, null);			
	}
	
	public Date getTimeLastUsage()
	{
		if(timeLastUsage==null)
			return null;
		
		return timeLastUsage.getDateTime();
	}
	
	public void setTimeLastUsage(Date value)
	{
		if(value==null)
			this.timeLastUsage = null;
		else
			this.timeLastUsage = new TimeLastUsageImpl(value, null, null);			
	}
	
	public Long getTimeUsage()
	{
		if(timeUsage==null)
			return null;
		
		return timeUsage.getUnsigned();
	}
	
	public void setTimeUsage(Long value)
	{
		if(value==null)
			this.timeUsage = null;
		else
			this.timeUsage = new TimeUsageImpl(value, null, null);			
	}
	
	public List<Long> getChangeCondition()
	{
		if(changeCondition==null || changeCondition.size()==0)
			return null;
		
		List<Long> result = new ArrayList<Long>();
		for(ChangeCondition curr:changeCondition)
			result.add(curr.getUnsigned());
		
		return result;
	}
	
	public void setChangeCondition(List<Long> value)
	{
		if(value==null || value.size()==0)
			this.changeCondition = null;
		else
		{
			this.changeCondition = new ArrayList<ChangeCondition>();
			for(Long curr:value)
				this.changeCondition.add(new ChangeConditionImpl(curr, null, null));
		}
	}
	
	public ByteBuf get3GPPUserLocationInfo()
	{
		if(tgppUserLocationInfo==null)
			return null;
		
		return tgppUserLocationInfo.getValue();
	}
	
	public void set3GPPUserLocationInfo(ByteBuf value)
	{
		if(value==null)
			this.tgppUserLocationInfo = null;
		else
			this.tgppUserLocationInfo = new TGPPUserLocationInfoImpl(value, null, null);			
	}
	
	public ByteBuf get3GPP2BSID()
	{
		if(tgpp2BSID==null)
			return null;
		
		return tgpp2BSID.getValue();
	}
	
	public void set3GPP2BSID(ByteBuf value)
	{
		if(value==null)
			this.tgpp2BSID = null;
		else
			this.tgpp2BSID = new TGPP2BSIDImpl(value, null, null);			
	}
	
	public UWANUserLocationInfo getUWANUserLocationInfo()
	{
		return this.uwanUserLocationInfo;
	}
	
	public void setUWANUserLocationInfo(UWANUserLocationInfo value)
	{
		this.uwanUserLocationInfo = value;
	}
	
	public TWANUserLocationInfo getTWANUserLocationInfo()
	{
		return this.twanUserLocationInfo;
	}
	
	public void setTWANUserLocationInfo(TWANUserLocationInfo value)
	{
		this.twanUserLocationInfo = value;
	}
	
	public String getSponsorIdentity()
	{
		if(sponsorIdentity==null)
			return null;
		
		return sponsorIdentity.getString();
	}
	
	public void setSponsorIdentity(String value)
	{
		if(value==null)
			this.sponsorIdentity = null;
		else
			this.sponsorIdentity = new SponsorIdentityImpl(value, null, null);			
	}
	
	public String getApplicationServiceProviderIdentity()
	{
		if(applicationServiceProviderIdentity==null)
			return null;
		
		return applicationServiceProviderIdentity.getString();
	}
	
	public void setApplicationServiceProviderIdentity(String value)
	{
		if(value==null)
			this.applicationServiceProviderIdentity = null;
		else
			this.applicationServiceProviderIdentity = new ApplicationServiceProviderIdentityImpl(value, null, null);			
	}
	
	public List<PresenceReportingAreaInformation> getPresenceReportingAreaInformation()
	{
		return this.presenceReportingAreaInformation;
	}
	
	public void setPresenceReportingAreaInformation(List<PresenceReportingAreaInformation> value)
	{
		this.presenceReportingAreaInformation = value;
	}
	
	public PresenceReportingAreaStatusEnum getPresenceReportingAreaStatus()
	{
		if(presenceReportingAreaStatus==null)
			return null;
		
		return presenceReportingAreaStatus.getEnumerated(PresenceReportingAreaStatusEnum.class);
	}
	
	public void setPresenceReportingAreaStatus(PresenceReportingAreaStatusEnum value)
	{
		if(value==null)
			this.presenceReportingAreaStatus = null;
		else
			this.presenceReportingAreaStatus = new PresenceReportingAreaStatusImpl(value, null, null);			
	}
	
	public UserCSGInformation getUserCSGInformation()
	{
		return this.userCSGInformation;
	}
	
	public void setUserCSGInformation(UserCSGInformation value)
	{
		this.userCSGInformation = value;
	}
	
	public ByteBuf get3GPPRATType()
	{
		if(tgppRATType==null)
			return null;
		
		return tgppRATType.getValue();
	}
	
	public void set3GPPRATType(ByteBuf value)
	{
		if(value==null)
			this.tgppRATType = null;
		else
			this.tgppRATType = new TGPPRATTypeImpl(value, null, null);			
	}
	
	public RelatedChangeConditionInformation getRelatedChangeConditionInformation()
	{
		return this.relatedChangeConditionInformation;
	}
	
	public void setRelatedChangeConditionInformation(RelatedChangeConditionInformation value)
	{
		this.relatedChangeConditionInformation = value;
	}
	
	public ServingPLMNRateControl getServingPLMNRateControl()
	{
		return this.servingPLMNRateControl;
	}
	
	public void setServingPLMNRateControl(ServingPLMNRateControl value)
	{
		this.servingPLMNRateControl = value;
	}
	
	public APNRateControl getAPNRateControl()
	{
		return this.apnRateControl;
	}
	
	public void setAPNRateControl(APNRateControl value)
	{
		this.apnRateControl = value;
	}
	
	public TGPPPSDataOffStatusEnum get3GPPPSDataOffStatus()
	{
		if(tgppPSDataOffStatus==null)
			return null;
		
		return tgppPSDataOffStatus.getEnumerated(TGPPPSDataOffStatusEnum.class);
	}
	
	public void set3GPPPSDataOffStatus(TGPPPSDataOffStatusEnum value)
	{
		if(value==null)
			this.tgppPSDataOffStatus = null;
		else
			this.tgppPSDataOffStatus = new TGPPPSDataOffStatusImpl(value, null, null);			
	}
	
	public ByteBuf getTrafficSteeringPolicyIdentifierDL()
	{
		if(trafficSteeringPolicyIdentifierDL==null)
			return null;
		
		return trafficSteeringPolicyIdentifierDL.getValue();
	}
	
	public void setTrafficSteeringPolicyIdentifierDL(ByteBuf value)
	{
		if(value==null)
			this.trafficSteeringPolicyIdentifierDL = null;
		else
			this.trafficSteeringPolicyIdentifierDL = new TrafficSteeringPolicyIdentifierDLImpl(value, null, null);			
	}
	
	public ByteBuf getTrafficSteeringPolicyIdentifierUL()
	{
		if(trafficSteeringPolicyIdentifierUL==null)
			return null;
		
		return trafficSteeringPolicyIdentifierUL.getValue();
	}
	
	public void setTrafficSteeringPolicyIdentifierUL(ByteBuf value)
	{
		if(value==null)
			this.trafficSteeringPolicyIdentifierUL = null;
		else
			this.trafficSteeringPolicyIdentifierUL = new TrafficSteeringPolicyIdentifierULImpl(value, null, null);			
	}
	
	public VoLTEInformation getVoLTEInformation()
	{
		return this.volteInformation;
	}
	
	public void setVoLTEInformation(VoLTEInformation value)
	{
		this.volteInformation = value;
	}
}