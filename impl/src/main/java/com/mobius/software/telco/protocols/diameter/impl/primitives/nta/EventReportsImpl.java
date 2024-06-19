package com.mobius.software.telco.protocols.diameter.impl.primitives.nta;

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;

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

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.nta.AccessNetworkReports;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventReportingResults;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventReports;
import com.mobius.software.telco.protocols.diameter.primitives.nta.ExtendedSCEFReferenceID;



public class EventReportsImpl extends DiameterGroupedAvpImpl implements EventReports
{

	private EventReportingResults eventReportingResults;
	
	private ExtendedSCEFReferenceID extendedSCEFReferenceID;
	
	private AccessNetworkReports accessNetworkReports;
	
	public EventReportsImpl()
	{
		
	}
	
	public EventReportsImpl( Long eventReportingResults,Long extendedSCEFReferenceID) throws MissingAvpException
	{
		setEventReportingResults(eventReportingResults);
		
		setExtendedSCEFReferenceID(extendedSCEFReferenceID);
		
	}
	
	@Override
	public Long getEventReportingResults()
	{
		if( eventReportingResults == null)
			return null;
		
		return eventReportingResults.getUnsigned();
	}
	 
	@Override
	public void setEventReportingResults(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("EventReportingResults is required", Arrays.asList(new DiameterAvp[] { new EventReportingResultsImpl() }));
			
		this.eventReportingResults = new EventReportingResultsImpl(value, null, null);
	}
	
	@Override
	public Long getExtendedSCEFReferenceID()
	{
		if( extendedSCEFReferenceID == null)
			return null;
		
		return extendedSCEFReferenceID.getLong();
	}
	 
	@Override
	public void setExtendedSCEFReferenceID(Long value) throws MissingAvpException
	{
		if(value == null)
			throw new MissingAvpException("ExtendedSCEFReferenceID is required", Arrays.asList(new DiameterAvp[] { new ExtendedSCEFReferenceIDImpl() }));
			
		this.extendedSCEFReferenceID = new ExtendedSCEFReferenceIDImpl(value, null, null);
	}
	
	@Override
	public AccessNetworkReports getAccessNetworkReports()
	{
		return this.accessNetworkReports;
	}
	
	@Override
	public void setAccessNetworkReports(AccessNetworkReports value)
	{
		this.accessNetworkReports = value;
	}
	
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(eventReportingResults==null)
			return new MissingAvpException("EventReportingResults is required", Arrays.asList(new DiameterAvp[] { new EventReportingResultsImpl() }));
		
		if(extendedSCEFReferenceID==null)
			return new MissingAvpException("ExtendedSCEFReferenceID is required", Arrays.asList(new DiameterAvp[] { new ExtendedSCEFReferenceIDImpl() }));
		
		return null;
	}

}
	
