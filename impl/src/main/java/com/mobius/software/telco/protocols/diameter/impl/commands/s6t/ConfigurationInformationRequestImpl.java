package com.mobius.software.telco.protocols.diameter.impl.commands.s6t;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterOrder;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ConfigurationInformationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.GroupReportingGuardTimerImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.UserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPattern;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AdditionalIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EnhancedCoverageRestriction;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupReportingGuardTimer;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SuggestedNetworkConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.UserIdentifier;

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
public class ConfigurationInformationRequestImpl extends S6tRequestImpl implements ConfigurationInformationRequest
{
	private UserIdentifier userIdentifier;
	
	private OCSupportedFeatures ocSupportedFeatures;
	
	private List<MonitoringEventConfiguration> monitoringEventConfiguration;
	
	private CIRFlags cirFlags;
	
	private List<AESECommunicationPattern> aesECommunicationPattern;
	
	private EnhancedCoverageRestriction enhancedCoverageRestriction;
	
	private GroupReportingGuardTimer groupReportingGuardTimer;
	
	private AdditionalIdentifiers additionalIdentifiers;	
	
	private SuggestedNetworkConfiguration suggestedNetworkConfiguration;
	
	protected ConfigurationInformationRequestImpl() 
	{
		super();
	}
	
	public ConfigurationInformationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier) throws MissingAvpException, AvpNotSupportedException
	{
		super(originHost, originRealm, destinationHost, destinationRealm, isRetransmit, sessionID, authSessionState);
		
		setUserIdentifier(userIdentifier);
	}
	
	@Override
	public UserIdentifier getUserIdentifier()
	{
		if(userIdentifier == null)
			return null;
		
		return userIdentifier;
	}
	
	@Override
	public void setUserIdentifier(UserIdentifier value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("User-Identifier is required", Arrays.asList(new DiameterAvp[] { new UserIdentifierImpl() }));
			
		this.userIdentifier = value;
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
	public List<MonitoringEventConfiguration> getMonitoringEventConfiguration()
	{
		return this.monitoringEventConfiguration;
	}
	
	@Override
	public void setMonitoringEventConfiguration(List<MonitoringEventConfiguration> value)
	{
		this.monitoringEventConfiguration = value;
	}
	
	@Override
	public CIRFlags getCIRFlags()
	{
		return cirFlags;
	}
	
	@Override
	public void setCIRFlags(CIRFlags value)
	{
		this.cirFlags = value;	
	}
	
	@Override
	public List<AESECommunicationPattern> getAESECommunicationPattern()
	{
		return this.aesECommunicationPattern;
	}
	
	@Override
	public void setAESECommunicationPattern(List<AESECommunicationPattern> value)
	{
		this.aesECommunicationPattern = value;
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
	public Long getGroupReportingGuardTimer()
	{
		if(groupReportingGuardTimer == null)
			return null;
		
		return groupReportingGuardTimer.getUnsigned();
	}
	 
	@Override
	public void setGroupReportingGuardTimer(Long value)
	{
		if(value == null)
			this.groupReportingGuardTimer = null;
		else
			this.groupReportingGuardTimer = new GroupReportingGuardTimerImpl(value, null, null);
	}	
	
	@Override
	public AdditionalIdentifiers getAdditionalIdentifiers()
	{
		return this.additionalIdentifiers;
	}
	
	@Override
	public void setAdditionalIdentifiers(AdditionalIdentifiers value)	
	{
		this.additionalIdentifiers = value;
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
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(userIdentifier == null)
			return new MissingAvpException("User-Identifier is required", Arrays.asList(new DiameterAvp[] { new UserIdentifierImpl() }));
		
		return super.validate();
	}			
	
	@DiameterOrder
	public List<DiameterAvp> getOrderedAVPs()
	{
		List<DiameterAvp> result=new ArrayList<DiameterAvp>();
		result.add(sessionId);
		result.add(drmp);
		result.add(authSessionState);
		result.add(originHost);
		result.add(originRealm);
		result.add(destinationHost);
		result.add(destinationRealm);
		result.add(userIdentifier);
		result.add(ocSupportedFeatures);
		
		if(supportedFeatures!=null)
			result.addAll(supportedFeatures);
		
		if(monitoringEventConfiguration!=null)
			result.addAll(monitoringEventConfiguration);
		
		result.add(cirFlags);
		
		if(aesECommunicationPattern!=null)
			result.addAll(aesECommunicationPattern);
		
		result.add(enhancedCoverageRestriction);
		result.add(groupReportingGuardTimer);
		result.add(additionalIdentifiers);
		
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