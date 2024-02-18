package com.mobius.software.telco.protocols.diameter.impl.primitives.tsp;
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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ExternalIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.ValidityTimeImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.SCSIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ExternalID;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.ValidityTime;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.SCSIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ActionType;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ActionTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.DeviceAction;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.OldReferenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ReferenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.TriggerData;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
public class DeviceActionImpl extends DiameterGroupedAvpImpl implements DeviceAction
{
	private ExternalID externalID;
	
	private MSISDN msisdn;
	
	private SCSIdentity scsIdentity;
	
	private ReferenceNumber referenceNumber;
	
	private OldReferenceNumber oldReferenceNumber;
	
	private ActionType actionType;
	
	private TriggerData triggerData;
	
	private ValidityTime validityTime;
	
	protected DeviceActionImpl()
	{
		super();
	}
	
	public DeviceActionImpl(Long  referenceNumber, ActionTypeEnum actionType) throws MissingAvpException
	{
		setReferenceNumber(referenceNumber);
		
		setActionType(actionType);
	}
	
	public String getExternalID()
	{
		if(externalID==null)
			return null;
		
		return externalID.getString();
	}
	
	public void setExternalID(String value)
	{
		if(value==null)
			this.externalID = null;
		else
			this.externalID = new ExternalIDImpl(value, null, null);
	}
	
	public String getMSISDN()
	{
		if(msisdn==null)
			return null;
		
		return msisdn.getAddress();
	}
	
	public void setMSISDN(String value)
	{
		if(value==null)
			this.msisdn = null;
		else
			this.msisdn = new MSISDNImpl(value);
	}
	
	public ByteBuf getSCSIdentity()
	{
		if(scsIdentity==null)
			return null;
		
		return scsIdentity.getValue();
	}
	
	public void setSCSIdentity(ByteBuf value)
	{
		if(value==null)
			this.scsIdentity = null;
		else
			this.scsIdentity = new SCSIdentityImpl(value, null, null);
	}
	
	public Long getReferenceNumber()
	{
		if(referenceNumber==null)
			return null;
		
		return referenceNumber.getUnsigned();
	}
	
	public void setReferenceNumber(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Reference-Number is required", Arrays.asList(new DiameterAvp[] { new ReferenceNumberImpl() }));
			
		this.referenceNumber = new ReferenceNumberImpl(value, null, null);		
	}
	
	public Long getOldReferenceNumber()
	{
		if(oldReferenceNumber==null)
			return null;
		
		return oldReferenceNumber.getUnsigned();
	}
	
	public void setOldReferenceNumber(Long value)
	{
		if(value==null)
			this.oldReferenceNumber = null;
		else
			this.oldReferenceNumber = new OldReferenceNumberImpl(value, null, null);
	}
	
	public ActionTypeEnum getActionType()
	{
		if(actionType==null)
			return null;
		
		return actionType.getEnumerated(ActionTypeEnum.class);
	}
	
	public void setActionType(ActionTypeEnum value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("Action-Type is required", Arrays.asList(new DiameterAvp[] { new ActionTypeImpl() }));
			
		this.actionType = new ActionTypeImpl(value, null, null);
	}
	
	public TriggerData getTriggerData()
	{
		return triggerData;
	}
	
	public void setTriggerData(TriggerData value)
	{
		this.triggerData = value;
	}
	
	public Long getValidityTime()
	{
		if(validityTime==null)
			return null;
		
		return validityTime.getUnsigned();
	}
	
	public void setValidityTime(Long value)
	{
		if(value==null)
			this.validityTime = null;
		else
			this.validityTime = new ValidityTimeImpl(value, null, null);
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(referenceNumber == null)
			return new MissingAvpException("Reference-Number is required", Arrays.asList(new DiameterAvp[] { new ReferenceNumberImpl() }));
		
		if(actionType == null)
			return new MissingAvpException("Action-Type is required", Arrays.asList(new DiameterAvp[] { new ActionTypeImpl() }));
		
		return null;
	}	
}