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
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AnnouncementIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AnnouncementInformation;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.AnnouncementOrder;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.Language;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PlayAlternative;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PlayAlternativeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PrivacyIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.PrivacyIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.QuotaIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.QuotaIndicatorEnum;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.TimeIndicator;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.VariablePart;

/**
*
* @author yulian oifa
*
*/
public class AnnouncementInformationImpl implements AnnouncementInformation
{
	private AnnouncementIdentifier announcementIdentifier;
	private List<VariablePart> variablePart;
	private TimeIndicator timeIndicator;
	private QuotaIndicator quotaIndicator;
	private AnnouncementOrder announcementOrder;
	private PlayAlternative playAlternative;
	private PrivacyIndicator privacyIndicator;
	private Language language;
	 	
	protected AnnouncementInformationImpl() 
	{
	}
	
	public AnnouncementInformationImpl(Long announcementIdentifier) throws MissingAvpException
	{
		setAnnouncementIdentifier(announcementIdentifier);
	}
	
	public Long getAnnouncementIdentifier()
	{
		if(announcementIdentifier==null)
			return null;
		
		return announcementIdentifier.getUnsigned();
	}
	
	public void setAnnouncementIdentifier(Long value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Announcement-Identifier is required", Arrays.asList(new DiameterAvp[] { new AnnouncementIdentifierImpl() }));
			
		this.announcementIdentifier = new AnnouncementIdentifierImpl(value, null, null);				
	}
	
	public List<VariablePart> getVariablePart()
	{
		return variablePart;
	}
	
	public void setVariablePart(List<VariablePart> value)
	{
		this.variablePart = value;
	}
	
	public Long getTimeIndicator()
	{
		if(timeIndicator==null)
			return null;
		
		return timeIndicator.getUnsigned();
	}
	
	public void setTimeIndicator(Long value)
	{
		if(value==null)
			this.timeIndicator = null;
		else
			this.timeIndicator = new TimeIndicatorImpl(value, null, null);			
	}
	
	public QuotaIndicatorEnum getQuotaIndicator()
	{
		if(quotaIndicator==null)
			return null;
		
		return quotaIndicator.getEnumerated(QuotaIndicatorEnum.class);
	}
	
	public void setQuotaIndicator(QuotaIndicatorEnum value)
	{
		if(value==null)
			this.quotaIndicator = null;
		else
			this.quotaIndicator = new QuotaIndicatorImpl(value, null, null);			
	}
	
	public Long getAnnouncementOrder()
	{
		if(announcementOrder==null)
			return null;
		
		return announcementOrder.getUnsigned();
	}
	
	public void setAnnouncementOrder(Long value)
	{
		if(value==null)
			this.announcementOrder = null;
		else
			this.announcementOrder = new AnnouncementOrderImpl(value, null, null);			
	}
	
	public PlayAlternativeEnum getPlayAlternative()
	{
		if(playAlternative==null)
			return null;
		
		return playAlternative.getEnumerated(PlayAlternativeEnum.class);
	}
	
	public void setPlayAlternative(PlayAlternativeEnum value)
	{
		if(value==null)
			this.playAlternative = null;
		else
			this.playAlternative = new PlayAlternativeImpl(value, null, null);			
	}
	
	public PrivacyIndicatorEnum getPrivacyIndicator()
	{
		if(privacyIndicator==null)
			return null;
		
		return privacyIndicator.getEnumerated(PrivacyIndicatorEnum.class);
	}
	
	public void setPrivacyIndicator(PrivacyIndicatorEnum value)
	{
		if(value==null)
			this.privacyIndicator = null;
		else
			this.privacyIndicator = new PrivacyIndicatorImpl(value, null, null);			
	}
	
	public String getLanguage()
	{
		if(language==null)
			return null;
		
		return language.getString();
	}
	
	public void setLanguage(String value)
	{
		if(value==null)
			this.language = null;
		else
			this.language = new LanguageImpl(value, null, null);			
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(announcementIdentifier==null)
			return new MissingAvpException("Announcement-Identifier is required", Arrays.asList(new DiameterAvp[] { new AnnouncementIdentifierImpl() }));
		
		return null;
	}
}