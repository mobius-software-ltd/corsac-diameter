package com.mobius.software.telco.protocols.diameter.impl.app.nta;

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

import com.mobius.software.telco.protocols.diameter.app.nta.AvpFactory;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.accounting.OCOLRImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.cxdx.SupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nta.EventConfigurationStatusImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.nta.EventReportsImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc7683.OCSupportedFeaturesImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.rfc8583.LoadImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.ExternalIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6t.GroupReportingGuardTimerImpl;
import com.mobius.software.telco.protocols.diameter.primitives.accounting.OCOLR;
import com.mobius.software.telco.protocols.diameter.primitives.cxdx.SupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventConfigurationStatus;
import com.mobius.software.telco.protocols.diameter.primitives.nta.EventReports;
import com.mobius.software.telco.protocols.diameter.primitives.rfc7683.OCSupportedFeatures;
import com.mobius.software.telco.protocols.diameter.primitives.rfc8583.Load;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.ExternalIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.s6t.GroupReportingGuardTimer;

public class AvpFactoryImpl extends com.mobius.software.telco.protocols.diameter.impl.app.commons.AvpFactoryImpl implements AvpFactory
{

	@Override
	public EventReports getEventReports() 
	{
		return new EventReportsImpl();
	}

	@Override
	public EventConfigurationStatus getEventConfigurationStatus() 
	{
		return new EventConfigurationStatusImpl();
	}

	@Override
	public SupportedFeatures getSupportedFeatures ()
	{
		return new SupportedFeaturesImpl();
	}

	@Override
	public GroupReportingGuardTimer getGroupReportingGuardTimer() 
	{
	    return new  GroupReportingGuardTimerImpl();
	}

	@Override
	public ExternalIdentifier getExternalIdentifier() throws MissingAvpException 
	{
		return new ExternalIdentifierImpl();
	}

	@Override
	public OCSupportedFeatures getOCSupportedFeatures() 
	{
		return new OCSupportedFeaturesImpl();
	}

	@Override
	public OCOLR getOCOLR()
	{
		return new OCOLRImpl();
	}

	@Override
	public Load getLoad() 
	{
		return new LoadImpl();
	}
	
}