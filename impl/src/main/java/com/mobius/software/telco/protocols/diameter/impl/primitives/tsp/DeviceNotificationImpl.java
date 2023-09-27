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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.ExternalIDImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.SCSIdentityImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sgd.SMRPUIImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.sh.MSISDNImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.t4.MTCErrorDiagnosticImpl;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ExternalID;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.SCSIdentity;
import com.mobius.software.telco.protocols.diameter.primitives.sgd.SMRPUI;
import com.mobius.software.telco.protocols.diameter.primitives.sh.MSISDN;
import com.mobius.software.telco.protocols.diameter.primitives.t4.MTCErrorDiagnostic;
import com.mobius.software.telco.protocols.diameter.primitives.t4.MTCErrorDiagnosticEnum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ActionType;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ActionTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ApplicationPortIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.DeliveryOutcome;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.DeliveryOutcomeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.DeviceNotification;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.ReferenceNumber;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.RequestStatus;
import com.mobius.software.telco.protocols.diameter.primitives.tsp.RequestStatusEnum;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/
@DiameterAvpImplementation(code = 3002L, vendorId = KnownVendorIDs.TGPP_ID)
public class DeviceNotificationImpl extends DiameterGroupedAvpImpl implements DeviceNotification
{
	private ExternalID externalID;
	
	private MSISDN msisdn;
	
	private SCSIdentity scsIdentity;
	
	private ReferenceNumber referenceNumber;
	
	private ActionType actionType;
	
	private RequestStatus requestStatus;
	
	private MTCErrorDiagnostic mtcErrorDiagnostic;
	
	private DeliveryOutcome deliveryOutcome;
	
	private SMRPUI smRPUI;
	
	private ApplicationPortIdentifier applicationPortIdentifier;
	
	protected DeviceNotificationImpl()
	{
		super();
	}
	
	public DeviceNotificationImpl(Long  referenceNumber, ActionTypeEnum actionType)
	{
		if(referenceNumber == null)
			throw new IllegalArgumentException("Reference-Number is required");
		
		if(actionType == null)
			throw new IllegalArgumentException("Action-Type is required");
		
		this.referenceNumber = new ReferenceNumberImpl(referenceNumber, null, null);
		
		this.actionType = new ActionTypeImpl(actionType, null, null);
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
	
	public void setReferenceNumber(Long value)
	{
		if(value == null)
			throw new IllegalArgumentException("Reference-Number is required");
		
		this.referenceNumber = new ReferenceNumberImpl(value, null, null);		
	}
	
	public ActionTypeEnum getActionType()
	{
		if(actionType==null)
			return null;
		
		return actionType.getEnumerated(ActionTypeEnum.class);
	}
	
	public void setActionType(ActionTypeEnum value)
	{
		if(value == null)
			throw new IllegalArgumentException("Action-Type is required");
		
		this.actionType = new ActionTypeImpl(value, null, null);
	}
	
	public RequestStatusEnum getRequestStatus()
	{
		if(requestStatus==null)
			return null;
		
		return requestStatus.getEnumerated(RequestStatusEnum.class);
	}
	
	public void setRequestStatus(RequestStatusEnum value)
	{
		if(value==null)
			this.requestStatus = null;
		else
			this.requestStatus = new RequestStatusImpl(value, null, null);
	}
	
	public MTCErrorDiagnosticEnum getMTCErrorDiagnostic()
	{
		if(mtcErrorDiagnostic==null)
			return null;
		
		return mtcErrorDiagnostic.getEnumerated(MTCErrorDiagnosticEnum.class);
	}
	
	public void setMTCErrorDiagnostic(MTCErrorDiagnosticEnum value)
	{
		if(value==null)
			this.mtcErrorDiagnostic = null;
		else
			this.mtcErrorDiagnostic = new MTCErrorDiagnosticImpl(value, null, null);
	}
	
	public DeliveryOutcomeEnum getDeliveryOutcome()
	{
		if(deliveryOutcome==null)
			return null;
		
		return deliveryOutcome.getEnumerated(DeliveryOutcomeEnum.class);
	}
	
	public void setDeliveryOutcome(DeliveryOutcomeEnum value)
	{
		if(value==null)
			this.deliveryOutcome = null;
		else
			this.deliveryOutcome = new DeliveryOutcomeImpl(value, null, null);
	}
	
	public ByteBuf getSMRPUI()
	{
		if(smRPUI==null)
			return null;
		
		return smRPUI.getValue();
	}
	
	public void setSMRPUI(ByteBuf value)
	{
		if(value==null)
			this.smRPUI = null;
		else
			this.smRPUI = new SMRPUIImpl(value, null, null);
	}
	
	public Long getApplicationPortIdentifier()
	{
		if(applicationPortIdentifier==null)
			return null;
		
		return applicationPortIdentifier.getUnsigned();
	}
	
	public void setApplicationPortIdentifier(Long value)
	{
		if(value==null)
			this.applicationPortIdentifier = null;
		else
			this.applicationPortIdentifier = new ApplicationPortIdentifierImpl(value, null, null);
	}
	
	@DiameterValidate
	public String validate()
	{
		if(referenceNumber == null)
			return "Reference-Number is required";
		
		if(actionType == null)
			return "Action-Type is required";
		
		return null;
	}
}