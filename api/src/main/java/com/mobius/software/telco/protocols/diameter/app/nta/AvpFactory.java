package com.mobius.software.telco.protocols.diameter.app.nta;

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


import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventConfigurationStatus;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventReports;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupReportingGuardTimer;

public interface AvpFactory extends com.mobius.software.telco.protocols.diameter.app.commons.AvpFactory
{
	public EventReports getEventReports();
	
	public EventConfigurationStatus getEventConfigurationStatus();
	
	public SupportedFeatures getSupportedFeatures();
	
	public GroupReportingGuardTimer getGroupReportingGuardTimer();
	
	public ExternalIdentifier  getExternalIdentifier() throws MissingAvpException;
	
	public OCSupportedFeatures getOCSupportedFeatures();
	
	public OCOLR getOCOLR();
	
	public Load getLoad();
	
}