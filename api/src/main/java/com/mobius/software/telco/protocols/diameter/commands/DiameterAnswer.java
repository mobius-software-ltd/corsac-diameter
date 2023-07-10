package com.mobius.software.telco.protocols.diameter.commands;

import java.util.List;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvpKey;
import com.mobius.software.telco.protocols.diameter.primitives.common.ExperimentalResult;
import com.mobius.software.telco.protocols.diameter.primitives.common.ProxyInfo;

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
/**
*
* @author yulian oifa
*
*/
public interface DiameterAnswer extends DiameterMessage
{
	public Boolean getIsError();
	
	public Long getResultCode();
	
	void setResultCode(Long resultCode);
	
	public Long getOriginStateId();
	
	void setOriginStateId(Long originStateId);	
	
	public String getErrorMessage();
	
	void setErrorMessage(String value);
	
	public String getErrorReportingHost();
	
	void setErrorReportingHost(String host);

	public Map<DiameterAvpKey,List<DiameterAvp>> getFailedAvp();
	
	void addFailedAvp(DiameterAvpKey avpKey, DiameterAvp failedAvp);
	
	void setFailedAvp(Map<DiameterAvpKey,List<DiameterAvp>> failedAvp);
	
	public ExperimentalResult getExperimentalResult();
	
	void setExperimentalResult(ExperimentalResult experimentalResult);
	
	public List<ProxyInfo> getProxyInfo();
	
	void setProxyInfo(List<ProxyInfo> proxyInfo);	
	
	void addProxyInfo(ProxyInfo proxyInfo);
}