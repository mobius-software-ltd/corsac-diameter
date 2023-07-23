package com.mobius.software.telco.protocols.diameter.impl.commands;

import java.util.List;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ErrorMessageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ErrorReportingHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.FailedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ResultCodeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvpKey;
import com.mobius.software.telco.protocols.diameter.primitives.common.ErrorMessage;
import com.mobius.software.telco.protocols.diameter.primitives.common.ErrorReportingHost;
import com.mobius.software.telco.protocols.diameter.primitives.common.ExperimentalResult;
import com.mobius.software.telco.protocols.diameter.primitives.common.FailedAvp;
import com.mobius.software.telco.protocols.diameter.primitives.common.ResultCode;

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
public abstract class DiameterAnswerBase extends DiameterMessageBase implements DiameterAnswer
{
	private Boolean isError;
	
	private ResultCode resultCode;
	
	private ErrorMessage errorMessage;
	
	private ErrorReportingHost errorReportingHost;
	
	private FailedAvp failedAvp;
	
	private ExperimentalResult experimentalResult;
	
	private boolean experimentalResultAllowed = true;
	private boolean errorReportingHostAllowed = true;
	
	protected DiameterAnswerBase() 
	{
		super();
	}
	
	public DiameterAnswerBase(String originHost,String originRealm,Boolean isRetransmit, Long resultCode)
	{
		super(originHost, originRealm, isRetransmit);
		if(resultCode==null)
			throw new IllegalArgumentException("Result-Code is required");
		
		if(resultCode>=3000)
			this.isError = true;
		
		this.resultCode = new ResultCodeImpl(resultCode, null, null);		
	}

	protected void setExperimentalResultAllowed(boolean allowed) 
	{
		this.experimentalResultAllowed = allowed;
	}

	protected void setErrorReportingHostAllowed(boolean allowed) 
	{
		this.errorReportingHostAllowed = allowed;
	}
	
	@Override
	public Boolean getIsError() 
	{
		return isError;
	}
	
	@Override
	public Long getResultCode()
	{
		if(this.resultCode==null)
			return null;
		
		return this.resultCode.getUnsigned();
	}
	
	@Override
	public void setResultCode(Long resultCode)
	{
		if(resultCode==null)
			this.resultCode = null;
		else
			this.resultCode = new ResultCodeImpl(resultCode, null, null);
	}
	
	@Override
	public Map<DiameterAvpKey, List<DiameterAvp>> getOptionalAvps() 
	{
		return optionalAvps;
	}
	
	@Override
	public String getErrorMessage()
	{
		if(errorMessage==null)
			return null;
		
		return errorMessage.getString();
	}
	
	@Override
	public void setErrorMessage(String value)
	{
		if(value==null)
			this.errorMessage = null;
		else
			this.errorMessage = new ErrorMessageImpl(value, null, null);
	}
	
	@Override
	public String getErrorReportingHost() throws AvpNotSupportedException
	{
		if(!errorReportingHostAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(errorReportingHost==null)
			return null;
		
		return errorReportingHost.getIdentity();
	}
	
	@Override
	public void setErrorReportingHost(String host) throws AvpNotSupportedException
	{
		if(!errorReportingHostAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		
		if(host==null)
			this.errorReportingHost = null;
		else
			this.errorReportingHost = new ErrorReportingHostImpl(host, null, null);
	}

	@Override
	public Map<DiameterAvpKey,List<DiameterAvp>> getFailedAvp()
	{
		if(failedAvp==null)
			return null;
		
		return failedAvp.getOptionalAvps();
	}
	
	@Override
	public void setFailedAvp(Map<DiameterAvpKey,List<DiameterAvp>> failedAvp)
	{
		if(this.failedAvp==null)
			this.failedAvp = new FailedAvpImpl();
		
		this.failedAvp.setOptionalAvps(failedAvp);
	}
	
	@Override
	public void addFailedAvp(DiameterAvpKey avpKey, DiameterAvp failedAvp)
	{
		if(this.failedAvp==null)
			this.failedAvp = new FailedAvpImpl();
		
		this.failedAvp.addOptionalAvp(avpKey, failedAvp);
	}
	
	@Override
	public ExperimentalResult getExperimentalResult() throws AvpNotSupportedException
	{
		if(!experimentalResultAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		else
			return this.experimentalResult;
	}
	
	@Override
	public void setExperimentalResult(ExperimentalResult experimentalResult) throws AvpNotSupportedException
	{
		if(!experimentalResultAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application");
		else
			this.experimentalResult = experimentalResult;
	}
	
	@DiameterValidate
	public String validate()
	{
		if(resultCode==null)
			return "Result-Code is required";
		
		return super.validate();
	}
}