package com.mobius.software.telco.protocols.diameter.app.s7a;
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

import java.util.List;

import com.mobius.software.telco.protocols.diameter.commands.s7a.CancelVCSGLocationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s7a.CancelVCSGLocationRequest;
import com.mobius.software.telco.protocols.diameter.commands.s7a.DeleteSubscriberDataAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s7a.DeleteSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.s7a.InsertSubscriberDataAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s7a.InsertSubscriberDataRequest;
import com.mobius.software.telco.protocols.diameter.commands.s7a.ResetAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s7a.ResetRequest;
import com.mobius.software.telco.protocols.diameter.commands.s7a.UpdateVCSGLocationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.s7a.UpdateVCSGLocationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.CancellationTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.DSRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.UVRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.s6a.VPLMNCSGSubscriptionData;

public interface MessageFactory
{
	public CancelVCSGLocationRequest createCancelVCSGLocationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,CancellationTypeEnum cancellationType) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public CancelVCSGLocationAnswer createCancelVCSGLocationAnswer(CancelVCSGLocationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public CancelVCSGLocationAnswer createCancelVCSGLocationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public DeleteSubscriberDataRequest createDeleteSubscriberDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,DSRFlags dsrFlags) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public DeleteSubscriberDataAnswer createDeleteSubscriberDataAnswer(DeleteSubscriberDataRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public DeleteSubscriberDataAnswer createDeleteSubscriberDataAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public InsertSubscriberDataRequest createInsertSubscriberDataRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,List<VPLMNCSGSubscriptionData> vplmnCSGSubscriptionData) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public InsertSubscriberDataAnswer createInsertSubscriberDataAnswer(InsertSubscriberDataRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public InsertSubscriberDataAnswer createInsertSubscriberDataAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ResetRequest createResetRequest(String originHost,String originRealm,String destinationHost,String destinationRealm) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public ResetAnswer createResetAnswer(ResetRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ResetAnswer createResetAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public UpdateVCSGLocationRequest createUpdateVCSGLocationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UVRFlags uvrFlags) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
	
	public UpdateVCSGLocationAnswer createUpdateVCSGLocationAnswer(UpdateVCSGLocationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public UpdateVCSGLocationAnswer createUpdateVCSGLocationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
}