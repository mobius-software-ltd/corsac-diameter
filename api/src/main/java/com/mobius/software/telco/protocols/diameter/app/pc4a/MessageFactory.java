package com.mobius.software.telco.protocols.diameter.app.pc4a;
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

import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeInitialLocationInformationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeInitialLocationInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeNotifyAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeNotifyRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeSubscriberInformationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ProSeSubscriberInformationRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ResetAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.ResetRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.UpdateProSeSubscriberDataAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc4a.UpdateProSeSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;

public interface MessageFactory
{
	public ProSeInitialLocationInformationRequest createProSeInitialLocationInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;		

	public ProSeInitialLocationInformationAnswer createProSeInitialLocationInformationAnswer(ProSeInitialLocationInformationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeInitialLocationInformationAnswer createProSeInitialLocationInformationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeNotifyRequest createProSeNotifyRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public ProSeNotifyAnswer createProSeNotifyAnswer(ProSeNotifyRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeNotifyAnswer createProSeNotifyAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeSubscriberInformationRequest createProSeSubscriberInformationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public ProSeSubscriberInformationAnswer createProSeSubscriberInformationAnswer(ProSeSubscriberInformationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeSubscriberInformationAnswer createProSeSubscriberInformationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ResetRequest createResetRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws AvpNotSupportedException, MissingAvpException, AvpOccursTooManyTimesException;

	public ResetAnswer createResetAnswer(ResetRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ResetAnswer createResetAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public UpdateProSeSubscriberDataRequest createUpdateProSeSubscriberDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public UpdateProSeSubscriberDataAnswer createUpdateProSeSubscriberDataAnswer(UpdateProSeSubscriberDataRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public UpdateProSeSubscriberDataAnswer createUpdateProSeSubscriberDataAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
}