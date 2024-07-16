package com.mobius.software.telco.protocols.diameter.impl.primitives.gy;
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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.MissingAvpException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAvpImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.creditcontrol.FinalUnitActionImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitAction;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.FinalUnitActionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.RedirectServer;
import com.mobius.software.telco.protocols.diameter.primitives.gy.FinalUnitIndication;

public class FinalUnitIndicationImpl extends DiameterAvpImpl implements FinalUnitIndication
{
	private FinalUnitAction finalUnitAction;
	
	private RedirectServer redirectServer;
	
	public FinalUnitIndicationImpl()
	{
		
	}
	
	
	public FinalUnitIndicationImpl(FinalUnitActionEnum finalUnitAction) throws MissingAvpException
	{
		setFinalUnitAction(finalUnitAction);
	}
	
	public FinalUnitActionEnum getFinalUnitAction()
	{
		if(finalUnitAction==null)
			return null;
		
		return finalUnitAction.getEnumerated(FinalUnitActionEnum.class);
	}
	
	public void setFinalUnitAction(FinalUnitActionEnum value) throws MissingAvpException
	{
		if(value==null)
			throw new MissingAvpException("Final-Unit-Action is required", Arrays.asList(new DiameterAvp[] { new FinalUnitActionImpl() }));
			
		this.finalUnitAction = new FinalUnitActionImpl(value, null, null);
	}
	
	public RedirectServer getRedirectServer()
	{
		return redirectServer;
	}
	
	public void setRedirectServer(RedirectServer value)
	{
		this.redirectServer = value;
	}
	
	@DiameterValidate
	public DiameterException validate()
	{
		if(finalUnitAction==null)
			return new MissingAvpException("Final-Unit-Action is required", Arrays.asList(new DiameterAvp[] { new FinalUnitActionImpl() }));
		
		return null;
	}

}