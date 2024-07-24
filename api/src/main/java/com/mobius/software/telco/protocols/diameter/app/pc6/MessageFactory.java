package com.mobius.software.telco.protocols.diameter.app.pc6;
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

import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeAlertAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeAlertRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeAuthorizationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeCancellationAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeCancellationRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeDiscoveryAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeDiscoveryRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeLocationUpdateAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeLocationUpdateRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeMatchAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeMatchReportInfoAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeMatchReportInfoRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeMatchRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeProximityAnswer;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeProximityRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.DiscoveryAuthRequest;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MatchReportInfo;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.MatchRequest;
import com.mobius.software.telco.protocols.diameter.primitives.pc6.PRRFlags;
import com.mobius.software.telco.protocols.diameter.primitives.sh.UserIdentity;

import io.netty.buffer.ByteBuf;

public interface MessageFactory
{
	public ProSeAlertRequest createProSeAlertRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String appLayerUserId,String targetedEPUID) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;		

	public ProSeAlertAnswer createProSeAlertAnswer(ProSeAlertRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeAlertAnswer createProSeAlertAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeAuthorizationRequest createProSeAuthorizationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,UserIdentity userIdentity,ByteBuf visitedPLMNId) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public ProSeAuthorizationAnswer createProSeAuthorizationAnswer(ProSeAuthorizationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeAuthorizationAnswer createProSeAuthorizationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeCancellationRequest createProSeCancellationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String requestingEPUID,String targetedEPUID) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public ProSeCancellationAnswer createProSeCancellationAnswer(ProSeCancellationRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeCancellationAnswer createProSeCancellationAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeDiscoveryRequest createProSeDiscoveryRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,DiscoveryAuthRequest discoveryAuthRequest) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public ProSeDiscoveryAnswer createProSeDiscoveryAnswer(ProSeDiscoveryRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeDiscoveryAnswer createProSeDiscoveryAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeLocationUpdateRequest createProSeLocationUpdateRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,String targetedEPUID,ByteBuf locationEstimate) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public ProSeLocationUpdateAnswer createProSeLocationUpdateAnswer(ProSeLocationUpdateRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeLocationUpdateAnswer createProSeLocationUpdateAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeMatchReportInfoRequest createProSeMatchReportInfoRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,MatchReportInfo matchReportInfo) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public ProSeMatchReportInfoAnswer createProSeMatchReportInfoAnswer(ProSeMatchReportInfoRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeMatchReportInfoAnswer createProSeMatchReportInfoAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeMatchRequest createProSeMatchRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,MatchRequest matchRequest) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public ProSeMatchAnswer createProSeMatchAnswer(ProSeMatchRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeMatchAnswer createProSeMatchAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeProximityRequest createProSeProximityRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,PRRFlags prrFlags,String requestingEPUID,String targetedEPUID,Long timeWindow,ByteBuf locationEstimate) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;

	public ProSeProximityAnswer createProSeProximityAnswer(ProSeProximityRequest request, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
	public ProSeProximityAnswer createProSeProximityAnswer(String originHost,String originRealm, Long hopByHopIdentifier, Long endToEndIdentifier,Long resultCode, String sessionID) throws AvpOccursTooManyTimesException, MissingAvpException, AvpNotSupportedException;	
	
}