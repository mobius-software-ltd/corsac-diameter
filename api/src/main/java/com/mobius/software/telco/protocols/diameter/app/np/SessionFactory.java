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

import com.mobius.software.telco.protocols.diameter.commands.np.NonAggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.np.AggregatedRUCIReportRequest;
import com.mobius.software.telco.protocols.diameter.commands.np.ModifyUeContextRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.AvpNotSupportedException;

public interface SessionFactory
{
	public NonAggregatedRUCIReportClientSession createClientSession(NonAggregatedRUCIReportRequest request) throws AvpNotSupportedException;	
	
	public NonAggregatedRUCIReportServerSession createServerSession(NonAggregatedRUCIReportRequest request) throws AvpNotSupportedException;	
	
	public AggregatedRUCIReportClientSession createClientSession(AggregatedRUCIReportRequest request) throws AvpNotSupportedException;	
	
	public AggregatedRUCIReportServerSession createServerSession(AggregatedRUCIReportRequest request) throws AvpNotSupportedException;
	
    public ModifyUeContextClientSession createClientSession( ModifyUeContextRequest request) throws AvpNotSupportedException;	
	
	public ModifyUeContextServerSession createServerSession(ModifyUeContextRequest request) throws AvpNotSupportedException;
}
