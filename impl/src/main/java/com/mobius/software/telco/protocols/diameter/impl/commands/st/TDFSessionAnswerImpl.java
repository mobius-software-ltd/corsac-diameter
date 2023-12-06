package com.mobius.software.telco.protocols.diameter.impl.commands.st;

import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandImplementation;
import com.mobius.software.telco.protocols.diameter.commands.st.TDFSessionAnswer;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.sd.ADCRuleReport;

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
@DiameterCommandImplementation(applicationId = 16777349, commandCode = 8388637, request = false)
public class TDFSessionAnswerImpl extends StAnswerImpl implements TDFSessionAnswer
{
	private List<ADCRuleReport>  adcRuleReport;
	
	private List<SupportedFeatures> supportedFeatures;
	
	private List<Load> load;
	
	protected TDFSessionAnswerImpl() 
	{
		super();
		setExperimentalResultAllowed(true);
		setOriginStateIdAllowedAllowed(true);
		setUsernameAllowed(false);
	}
	
	protected TDFSessionAnswerImpl(String originHost,String originRealm,Boolean isRetransmit, Long resultCode, String sessionID)
	{
		super(originHost, originRealm, isRetransmit, resultCode, sessionID);
		setExperimentalResultAllowed(true);
		setOriginStateIdAllowedAllowed(true);
		setUsernameAllowed(false);
	}
	
	@Override
	public List<ADCRuleReport> getADCRuleReport()
	{
		return this.adcRuleReport;
	}
	
	@Override
	public void setADCRuleReport(List<ADCRuleReport> value)
	{
		this.adcRuleReport = value;
	}
	
	@Override
	public List<SupportedFeatures> getSupportedFeatures()
	{
		return this.supportedFeatures;
	}
	
	@Override
	public void setSupportedFeatures(List<SupportedFeatures> value)
	{
		this.supportedFeatures = value;
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
}