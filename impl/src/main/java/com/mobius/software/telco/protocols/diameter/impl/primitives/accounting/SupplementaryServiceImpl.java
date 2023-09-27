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

import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.primitives.KnownVendorIDs;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AoCInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AssociatedPartyAddress;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.CUGInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ChangeTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMTelSServiceType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.MMTelSServiceTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NumberOfDiversions;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.NumberOfParticipants;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ParticipantActionType;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ParticipantActionTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceID;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceMode;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.ServiceModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.SupplementaryService;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

/*
 * 	7.2.219	Supplementary-Service AVP
	The Supplementary-Service AVP (AVP code 2048) is of type Grouped and holds the specific supplementary service details for one MMTel supplementary service.
	It has the following ABNF grammar:

	Supplementary-Service :: =   < AVP Header: 2048>
			[ MMTel-SService-Type ]
			[ Service-Mode ]
			[ Number-Of-Diversions ]
			[ Associated-Party-Address ]
			[ Service-ID ]
			[ Change-Time ]
			[ Number-Of-Participants ]
			[ Participant-Action-Type ]
			[ CUG-Information ]
			[ AoC-Information ]
 */
@DiameterAvpImplementation(code = 2048L, vendorId = KnownVendorIDs.TGPP_ID)
public class SupplementaryServiceImpl implements SupplementaryService
{
	private MMTelSServiceType mmtelSServiceType;
	private ServiceMode serviceMode;
	private NumberOfDiversions numberOfDiversions;
	private AssociatedPartyAddress associatedPartyAddress;
	private ServiceID serviceID;
	private ChangeTime changeTime;
	private NumberOfParticipants numberOfParticipants;
	private ParticipantActionType participantActionType;
	private CUGInformation cugInformation;
	private AoCInformation aocInformation;
		
	public SupplementaryServiceImpl()
	{
		
	}
	
	public MMTelSServiceTypeEnum getMMTelSServiceType()
	{
		if(mmtelSServiceType==null)
			return null;
		
		return mmtelSServiceType.getEnumerated(MMTelSServiceTypeEnum.class);
	}
	
	public void setMMTelSServiceType(MMTelSServiceTypeEnum value)
	{
		if(value==null)
			this.mmtelSServiceType = null;
		else
			this.mmtelSServiceType = new MMTelSServiceTypeImpl(value, null, null);			
	}
	
	public ServiceModeEnum getServiceMode()
	{
		if(serviceMode==null)
			return null;
		
		return serviceMode.getEnumerated(ServiceModeEnum.class);
	}
	
	public void setServiceMode(ServiceModeEnum value)
	{
		if(value==null)
			this.serviceMode = null;
		else
			this.serviceMode = new ServiceModeImpl(value, null, null);			
	}
	
	public Long getNumberOfDiversions()
	{
		if(numberOfDiversions==null)
			return null;
		
		return numberOfDiversions.getUnsigned();
	}
	
	public void setNumberOfDiversions(Long value)
	{
		if(value==null)
			this.numberOfDiversions = null;
		else
			this.numberOfDiversions = new NumberOfDiversionsImpl(value, null, null);			
	}
	
	public String getAssociatedPartyAddress()
	{
		if(associatedPartyAddress==null)
			return null;
		
		return associatedPartyAddress.getString();
	}
	
	public void setAssociatedPartyAddress(String value)
	{
		if(value==null)
			this.associatedPartyAddress = null;
		else
			this.associatedPartyAddress = new AssociatedPartyAddressImpl(value, null, null);			
	}
	
	public String getServiceID()
	{
		if(serviceID==null)
			return null;
		
		return serviceID.getString();
	}
	
	public void setServiceID(String value)
	{
		if(value==null)
			this.serviceID = null;
		else
			this.serviceID = new ServiceIDImpl(value, null, null);			
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
	
	public Long getNumberOfParticipants()
	{
		if(numberOfParticipants==null)
			return null;
		
		return numberOfParticipants.getUnsigned();
	}
	
	public void setNumberOfParticipants(Long value)
	{
		if(value==null)
			this.numberOfParticipants = null;
		else
			this.numberOfParticipants = new NumberOfParticipantsImpl(value, null, null);			
	}
	
	public ParticipantActionTypeEnum getParticipantActionType()
	{
		if(participantActionType==null)
			return null;
		
		return participantActionType.getEnumerated(ParticipantActionTypeEnum.class);
	}
	
	public void setParticipantActionType(ParticipantActionTypeEnum value)
	{
		if(value==null)
			this.participantActionType = null;
		else
			this.participantActionType = new ParticipantActionTypeImpl(value, null, null);			
	}
	
	public ByteBuf getCUGInformation()
	{
		if(cugInformation==null)
			return null;
		
		return cugInformation.getValue();
	}
	
	public void setCUGInformation(ByteBuf value)
	{
		if(value==null)
			this.cugInformation = null;
		else
			this.cugInformation = new CUGInformationImpl(value, null, null);			
	}
	
	public AoCInformation getAoCInformation()
	{
		return this.aocInformation;
	}
	
	public void setAoCInformation(AoCInformation value)
	{
		this.aocInformation = value;
	}
}