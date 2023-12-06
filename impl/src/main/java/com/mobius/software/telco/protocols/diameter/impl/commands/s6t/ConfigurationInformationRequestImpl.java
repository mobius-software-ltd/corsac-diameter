package com.mobius.software.telco.protocols.diameter.impl.commands.s6t;

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.s6t.ConfigurationInformationRequest;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.CIRFlagsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.GroupReportingGuardTimerImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AESECommunicationPattern;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.AdditionalIdentifiers;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.CIRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.EnhancedCoverageRestriction;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupReportingGuardTimer;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.MonitoringEventConfiguration;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.SuggestedNetworkConfiguration;

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
@DiameterCommandImplementation(applicationId = 16777345, commandCode = 8388718, request = true)
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
	
	public ConfigurationInformationRequestImpl(String originHost,String originRealm,String destinationHost,String destinationRealm,Boolean isRetransmit, String sessionID,AuthSessionStateEnum authSessionState,UserIdentifier userIdentifier)
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
	public void setUserIdentifier(UserIdentifier value)
	{
		if(value == null)
			throw new IllegalArgumentException("User-Identifier is required");
		
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
	public Long getCIRFlags()
	{
		if(cirFlags == null)
			return null;
		
		return cirFlags.getUnsigned();
	}
	
	@Override
	public void setCIRFlags(Long value)
	{
		if(value == null)
			this.cirFlags = null;
		else
			this.cirFlags = new CIRFlagsImpl(value, null, null);	
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
	public String validate()
	{
		if(userIdentifier == null)
			return "User-Identifier is required";
		
		return super.validate();
	}	
}