package com.mobius.software.telco.protocols.diameter.app.slg;
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

import com.mobius.software.telco.protocols.diameter.commands.slg.LocationReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.slg.ProvideLocationRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpOccursTooManyTimesException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.LCSClientTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LCSEPSClientName;
import com.mobius.software.telco.protocols.diameter.primitives.slg.LocationEventEnum;
import com.mobius.software.telco.protocols.diameter.primitives.slg.SLgLocationTypeEnum;

public interface MessageFactory
{
	public ProvideLocationRequest createProvideLocationRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,SLgLocationTypeEnum slgLocationType,LCSEPSClientName lcsEPSClientName,LCSClientTypeEnum lcsClientType) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;			
	
	public LocationReportRequest createLocationReportRequest(String originHost,String originRealm,String destinationHost,String destinationRealm,LocationEventEnum locationEvent) throws MissingAvpException, AvpNotSupportedException, AvpOccursTooManyTimesException;
}