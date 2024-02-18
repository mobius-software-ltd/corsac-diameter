package com.mobius.software.telco.protocols.diameter.exceptions;

import java.util.List;

import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;

/*
 * Mobius Software LTD, Open Source Cloud Communications
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

/**
*
* @author yulian oifa
*
*/

public class DiameterException extends Exception 
{
	private static final long serialVersionUID = 1L;

	private Long vendorID;
	private Long errorCode;
	private List<DiameterAvp> failedAVPs;
	
	public DiameterException(String message, Long vendorID, Long errorCode, List<DiameterAvp>failedAVPs) 
	{
		super(message);
		this.vendorID = vendorID;
		this.errorCode = errorCode;
		this.failedAVPs = failedAVPs;
	}

	public Long getVendorID()
	{
		return vendorID;
	}

	public Long getErrorCode()
	{
		return errorCode;
	}
	
	public List<DiameterAvp> getFailedAVPs()
	{
		return failedAVPs;
	}	
}