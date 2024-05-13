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

import java.util.Arrays;
import java.util.Date;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcInputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcOutputOctetsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcServiceSpecificUnitsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.CcTotalOctetsImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Envelope;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EnvelopeEndTime;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.EnvelopeStartTime;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcInputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcOutputOctets;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcServiceSpecificUnits;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcTotalOctets;

/**
*
* @author yulian oifa
*
*/
public class EnvelopeImpl extends DiameterAvpImpl implements Envelope
{
	private EnvelopeStartTime envelopeStartTime;
	private EnvelopeEndTime envelopeEndTime;
	private CcTotalOctets ccTotalOctets;
	private CcInputOctets ccInputOctets;
	private CcOutputOctets ccOutputOctets;
	private CcServiceSpecificUnits ccServiceSpecificUnits;
	
	protected EnvelopeImpl() 
	{
	}
	
	public EnvelopeImpl(Date envelopeStartTime) throws MissingAvpException
	{
		setEnvelopeStartTime(envelopeStartTime);
	}
	
	public Date getEnvelopeStartTime()
	{
		if(envelopeStartTime==null)
			return null;
		
		return envelopeStartTime.getDateTime();
	}
	
	public void setEnvelopeStartTime(Date value) throws MissingAvpException	
	{
		if(value==null)
			throw new MissingAvpException("Envelope-Start-Time is required", Arrays.asList(new DiameterAvp[] { new EnvelopeStartTimeImpl() }));
			
		this.envelopeStartTime = new EnvelopeStartTimeImpl(value, null, null);				
	}
	
	public Date getEnvelopeEndTime()
	{
		if(envelopeEndTime==null)
			return null;
		
		return envelopeEndTime.getDateTime();
	}
	
	public void setEnvelopeEndTime(Date value)
	{
		if(value==null)
			this.envelopeEndTime = null;
		else
			this.envelopeEndTime = new EnvelopeEndTimeImpl(value, null, null);			
	}
	
	public Long getCcTotalOctets()
	{
		if(ccTotalOctets==null)
			return null;
		
		return ccTotalOctets.getLong();
	}
	
	public void setCcTotalOctets(Long value)
	{
		if(value==null)
			this.ccTotalOctets = null;
		else
			this.ccTotalOctets = new CcTotalOctetsImpl(value, null, null);			
	}
	
	public Long getCcInputOctets()
	{
		if(ccInputOctets==null)
			return null;
		
		return ccInputOctets.getLong();
	}
	
	public void setCcInputOctets(Long value)
	{
		if(value==null)
			this.ccInputOctets = null;
		else
			this.ccInputOctets = new CcInputOctetsImpl(value, null, null);			
	}
	
	public Long getCcOutputOctets()
	{
		if(ccOutputOctets==null)
			return null;
		
		return ccOutputOctets.getLong();
	}
	
	public void setCcOutputOctets(Long value)
	{
		if(value==null)
			this.ccOutputOctets = null;
		else
			this.ccOutputOctets = new CcOutputOctetsImpl(value, null, null);			
	}
	
	public Long getCcServiceSpecificUnits()
	{
		if(ccServiceSpecificUnits==null)
			return null;
		
		return ccServiceSpecificUnits.getLong();
	}
	
	public void setCcServiceSpecificUnits(Long value)
	{
		if(value==null)
			this.ccServiceSpecificUnits = null;
		else
			this.ccServiceSpecificUnits = new CcServiceSpecificUnitsImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(envelopeStartTime==null)
			return new MissingAvpException("Envelope-Start-Time is required", Arrays.asList(new DiameterAvp[] { new EnvelopeStartTimeImpl() }));
		
		return null;
	}
}