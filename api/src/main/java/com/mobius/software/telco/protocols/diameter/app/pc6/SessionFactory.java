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
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeAlertRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeAuthorizationRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeCancellationRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeDiscoveryRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeLocationUpdateRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeMatchReportInfoRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeMatchRequest;
import com.mobius.software.telco.protocols.diameter.commands.pc6.ProSeProximityRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public interface SessionFactory
{
	public PC6ClientSession createClientSession(ProSeAlertRequest request) throws AvpNotSupportedException;	
	
	public PC6ServerSession createServerSession(ProSeAlertRequest request) throws AvpNotSupportedException;	
	
	public PC6ClientSession createClientSession(ProSeAuthorizationRequest request) throws AvpNotSupportedException;	
	
	public PC6ServerSession createServerSession(ProSeAuthorizationRequest request) throws AvpNotSupportedException;
	
	public PC6ClientSession createClientSession(ProSeCancellationRequest request) throws AvpNotSupportedException;	
	
	public PC6ServerSession createServerSession(ProSeCancellationRequest request) throws AvpNotSupportedException;	
	
	public PC6ClientSession createClientSession(ProSeDiscoveryRequest request) throws AvpNotSupportedException;	
	
	public PC6ServerSession createServerSession(ProSeDiscoveryRequest request) throws AvpNotSupportedException;
	
	public PC6ClientSession createClientSession(ProSeLocationUpdateRequest request) throws AvpNotSupportedException;	
	
	public PC6ServerSession createServerSession(ProSeLocationUpdateRequest request) throws AvpNotSupportedException;	
	
	public PC6ClientSession createClientSession(ProSeMatchReportInfoRequest request) throws AvpNotSupportedException;	
	
	public PC6ServerSession createServerSession(ProSeMatchReportInfoRequest request) throws AvpNotSupportedException;
	
	public PC6ClientSession createClientSession(ProSeMatchRequest request) throws AvpNotSupportedException;	
	
	public PC6ServerSession createServerSession(ProSeMatchRequest request) throws AvpNotSupportedException;	
	
	public PC6ClientSession createClientSession(ProSeProximityRequest request) throws AvpNotSupportedException;	
	
	public PC6ServerSession createServerSession(ProSeProximityRequest request) throws AvpNotSupportedException;	
}