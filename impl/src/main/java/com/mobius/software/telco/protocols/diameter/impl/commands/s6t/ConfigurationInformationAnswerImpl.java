package com.mobius.software.telco.protocols.diameter.impl.commands.s6t;

import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ConfigurationInformationAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nt.NumberOfUEsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.S6tHSSCauseImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.nt.NumberOfUEs;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.IMSIGroupId;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ServiceData;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPatternConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CIAFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EnhancedCoverageRestriction;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfigStatus;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventReport;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.S6tHSSCause;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SuggestedNetworkConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SupportedServices;

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
public class ConfigurationInformationAnswerImpl extends S6tAnswerImpl implements ConfigurationInformationAnswer
{
	private OCSupportedFeatures ocSupportedFeatures;
	
	private OCOLR ocOLR;
	
	private List<Load> load;
	
	private UserIdentifier userIdentifier;
	
	private ServiceData serviceData;
	
	private NumberOfUEs numberOfUEs;
	
	private List<MonitoringEventReport> monitoringEventReport;
	
	private List<MonitoringEventConfigStatus> monitoringEventConfigStatus;
	
	private List<AESECommunicationPatternConfigStatus> aesECommunicationPatternConfigStatus;
	
	private List<SupportedServices> supportedServices;
	
	private S6tHSSCause s6tHSSCause;
	
	private EnhancedCoverageRestriction enhancedCoverageRestriction;
	
	private CIAFlags ciaFlags;
	
	private List<IMSIGroupId> imsiGroupId;
	
	private SuggestedNetworkConfiguration suggestedNetworkConfiguration;
	
	protected ConfigurationInformationAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(false);
	}
	
	public ConfigurationInformationAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID,  AuthSessionStateEnum authSessionState) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID, authSessionState);
		setExperimentalResultAllowed(false);
	}
	
	@Override
	public OCSupportedFeatures getOCSupportedFeatures()
	{
		return this.ocSupportedFeatures;
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
	public List<Load> getLoad()
	{
		return this.load;
	}
	 
	@Override
	public void setLoad(List<Load> value)
	{
		this.load = value;
	}
	
	@Override
	public UserIdentifier getUserIdentifier() 
	{
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(UserIdentifier value)
	{
		this.userIdentifier = value;
	}
	
	@Override
	public ServiceData getServiceData() 
	{
		return serviceData;
	}
	
	@Override
	public void setServiceData(ServiceData value)
	{
		this.serviceData = value;
	}
	
	@Override
	public Long getNumberOfUEs()
	{
		if(numberOfUEs == null)
			return null;
		
		return numberOfUEs.getUnsigned();
	}
	
	@Override
	public void setNumberOfUEs(Long value)
	{
		if(value == null)
			this.numberOfUEs = null;
		else
			this.numberOfUEs = new NumberOfUEsImpl(value, null, null);	
	}
	
	@Override
	public List<MonitoringEventReport> getMonitoringEventReport()
	{
		return this.monitoringEventReport;
	}
	
	@Override
	public void setMonitoringEventReport(List<MonitoringEventReport> value)
	{
		this.monitoringEventReport = value;
	}
	
	@Override
	public List<MonitoringEventConfigStatus> getMonitoringEventConfigStatus()
	{
		return this.monitoringEventConfigStatus;
	}
	
	@Override
	public void setMonitoringEventConfigStatus(List<MonitoringEventConfigStatus> value)
	{
		this.monitoringEventConfigStatus = value;
	}
	
	@Override
	public List<AESECommunicationPatternConfigStatus> getAESECommunicationPatternConfigStatus()
	{
		return this.aesECommunicationPatternConfigStatus;
	}
	
	@Override
	public void setAESECommunicationPatternConfigStatus(List<AESECommunicationPatternConfigStatus> value)
	{
		this.aesECommunicationPatternConfigStatus = value;
	}
	
	@Override
	public List<SupportedServices> getSupportedServices()
	{
		return this.supportedServices;
	}
	
	@Override
	public void setSupportedServices(List<SupportedServices> value)
	{
		this.supportedServices = value;
	}
	
	@Override
	public Long getS6tHSSCause()
	{
		if(s6tHSSCause == null)
			return null;
		
		return s6tHSSCause.getUnsigned();
	}
	
	@Override
	public void setS6tHSSCause(Long value)
	{
		if(value == null)
			this.s6tHSSCause = null;
		else
			this.s6tHSSCause = new S6tHSSCauseImpl(value, null, null);	
	}
	
	@Override
	public EnhancedCoverageRestriction getEnhancedCoverageRestriction()
	{
		return this.enhancedCoverageRestriction;
	}
	
	@Override
	public void setEnhancedCoverageRestriction(EnhancedCoverageRestriction value)
	{
		this.enhancedCoverageRestriction = value;
	}
	
	@Override
	public CIAFlags getCIAFlags()
	{
		return ciaFlags;
	}
	
	@Override
	public void setCIAFlags(CIAFlags value)
	{
		this.ciaFlags = value;	
	}
	
	@Override
	public List<IMSIGroupId> getIMSIGroupId()
	{
		return this.imsiGroupId;
	}
	
	@Override
	public void setIMSIGroupId(List<IMSIGroupId> value)
	{
		this.imsiGroupId = value;
	}
	
	@Override
	public SuggestedNetworkConfiguration getSuggestedNetworkConfiguration()
	{
		return this.suggestedNetworkConfiguration;
	}
	
	@Override
	public void setSuggestedNetworkConfiguration(SuggestedNetworkConfiguration value)
	{
		this.suggestedNetworkConfiguration = value;
	}
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(resultCode);
		result.add(experimentalResult);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(ocSupportedFeatures);
		result.add(ocOLR);
		
		if(load!=null)
			result.addAll(load);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		result.add(userIdentifier);
		result.add(numberOfUEs);
		
		if(monitoringEventReport!=null)
			result.addAll(monitoringEventReport);
		
		if(monitoringEventConfigStatus!=null)
			result.addAll(monitoringEventConfigStatus);
		
		if(aesECommunicationPatternConfigStatus!=null)
			result.addAll(aesECommunicationPatternConfigStatus);
		
		if(supportedServices!=null)
			result.addAll(supportedServices);
		
		result.add(s6tHSSCause);
		result.add(enhancedCoverageRestriction);
		result.add(ciaFlags);
		
		if(imsiGroupId!=null)
			result.addAll(imsiGroupId);
		
		result.add(failedAvp);
		
		if(proxyInfo!=null)
			result.addAll(proxyInfo);
		
		if(routeRecords!=null)
			result.addAll(routeRecords);
		
		result.add(suggestedNetworkConfiguration);
		
		if(optionalAvps!=null)
		{
			for(List<DiameterUnknownAvp> curr:optionalAvps.values())
				result.addAll(curr);
		}
		
		return result;
	}
}