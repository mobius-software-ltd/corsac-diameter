package com.mobius.software.telco.protocols.diameter.app.np;
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

import com.mobius.software.telco.protocols.diameter.commands.np.AggregatedRUCIReportAnswer;
import com.mobius.software.telco.protocols.diameter.commands.np.AggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.np.ModifyUeContextAnswer;
import com.mobius.software.telco.protocols.diameter.commands.np.ModifyUeContextRequest;
import com.mobius.software.telco.protocols.diameter.commands.np.NonAggregatedRUCIReportAnswer;
import com.mobius.software.telco.protocols.diameter.commands.np.NonAggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;

public interface MessageFactory
{
	public ModifyUeContextRequest createModifyUeContextRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;	
	
	public ModifyUeContextAnswer createModifyUeContextAnswer(ModifyUeContextRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ModifyUeContextAnswer createModifyUeContextAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;
	
	public AggregatedRUCIReportRequest createAggregatedRUCIReportRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public AggregatedRUCIReportAnswer createAggregatedRUCIReportAnswer(AggregatedRUCIReportRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public AggregatedRUCIReportAnswer createAggregatedRUCIReportAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;
	
	public NonAggregatedRUCIReportRequest createNonAggregatedRUCIReportRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public NonAggregatedRUCIReportAnswer createNonAggregatedRUCIReportAnswer(NonAggregatedRUCIReportRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public NonAggregatedRUCIReportAnswer createNonAggregatedRUCIReportAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;
	
}