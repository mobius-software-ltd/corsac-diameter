package com.mobius.software.telco.protocols.diameter.impl.commands;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ErrorMessageImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ErrorReportingHostImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ExperimentalResultImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.FailedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.ResultCodeImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvpKey;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUnknownAvp;
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
	
	protected ResultCode resultCode;
	
	protected ErrorMessage errorMessage;
	
	protected ErrorReportingHost errorReportingHost;
	
	protected FailedAvp failedAvp;
	
	protected ExperimentalResult experimentalResult;
	
	private boolean experimentalResultAllowed = true;
	private boolean errorReportingHostAllowed = true;
	
	protected DiameterAnswerBase() 
	{
		super();
	}
	
	public DiameterAnswerBase(String originHost,String originRealm,Boolean isRetransmit, Long resultCode) throws MissingAvpException
	{
		super(originHost, originRealm, isRetransmit);
		
		setResultCode(resultCode);
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
		if(isError==null && resultCode!=null)
		{
			try
			{
				setResultCode(getResultCode());
			}
			catch(MissingAvpException ex)
			{
				
			}
		}
		
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
	public void setResultCode(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Result-Code is required", Arrays.asList(new DiameterAvp[] {new ResultCodeImpl() }));
		
		if(value>=3000)
			this.isError = true;
		else
			this.isError = false;
		
		this.resultCode = new ResultCodeImpl(value, null, null);
	}
	
	@Override
	public Map<DiameterAvpKey, List<DiameterUnknownAvp>> getOptionalAvps() 
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
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new ErrorReportingHostImpl() }));
		
		if(errorReportingHost==null)
			return null;
		
		return errorReportingHost.getIdentity();
	}
	
	@Override
	public void setErrorReportingHost(String value) throws AvpNotSupportedException
	{
		if(!errorReportingHostAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new ErrorReportingHostImpl(value, null, null) }));
		
		if(value==null)
			this.errorReportingHost = null;
		else
			this.errorReportingHost = new ErrorReportingHostImpl(value, null, null);
	}

	@Override
	public Map<DiameterAvpKey,List<DiameterUnknownAvp>> getFailedAvp()
	{
		if(failedAvp==null)
			return null;
		
		return failedAvp.getOptionalAvps();
	}
	
	@Override
	public void setFailedAvp(Map<DiameterAvpKey,List<DiameterUnknownAvp>> failedAvp)
	{
		if(this.failedAvp==null)
			this.failedAvp = new FailedAvpImpl();
		
		this.failedAvp.setOptionalAvps(failedAvp);
	}
	
	@Override
	public void addFailedAvp(DiameterAvpKey avpKey, DiameterUnknownAvp failedAvp)
	{
		if(this.failedAvp==null)
			this.failedAvp = new FailedAvpImpl();
		
		this.failedAvp.addOptionalAvp(avpKey, failedAvp);
	}
	
	@Override
	public ExperimentalResult getExperimentalResult() throws AvpNotSupportedException
	{
		if(!experimentalResultAllowed)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { new ExperimentalResultImpl() }));
		else
			return this.experimentalResult;
	}
	
	@Override
	public void setExperimentalResult(ExperimentalResult value) throws AvpNotSupportedException
	{
		if(!experimentalResultAllowed && value!=null)
			throw new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { value }));
		
		this.experimentalResult = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(resultCode==null)
			return new MissingAvpException("Result-Code is required", Arrays.asList(new DiameterAvp[] {new ResultCodeImpl() }));
		
		if(!errorReportingHostAllowed && errorReportingHost!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { errorReportingHost }));
		
		if(!experimentalResultAllowed && experimentalResult!=null)
			return new AvpNotSupportedException("This AVP is not supported for select command/application", Arrays.asList(new DiameterAvp[] { experimentalResult }));
		
		return super.validate();
	}
}