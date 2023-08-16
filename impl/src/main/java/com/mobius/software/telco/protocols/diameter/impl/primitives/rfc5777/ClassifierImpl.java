package com.mobius.software.telco.protocols.diameter.impl.primitives.rfc5777;
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

import com.mobius.software.telco.protocols.diameter.annotations.DiameterAvpImplementation;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterValidate;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterGroupedAvpImpl;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.Classifier;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ClassifierID;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DiffServCodePoint;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DiffServCodePointEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.Direction;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.DirectionEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ETHOption;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.FragmentationFlag;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.FragmentationFlagEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.FromSpec;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ICMPType;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.IPOption;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.Protocol;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ProtocolEnum;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TCPFlags;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.TCPOption;
import com.mobius.software.telco.protocols.diameter.primitives.rfc5777.ToSpec;

import io.netty.buffer.ByteBuf;

/**
*
* @author yulian oifa
*
*/

@DiameterAvpImplementation(code = 511L, vendorId = -1L)
public class ClassifierImpl extends DiameterGroupedAvpImpl implements Classifier
{
	private ClassifierID classifierID;
	
	private Protocol protocol;
	
	private Direction direction;
	
	private List<FromSpec> fromSpec;
	
	private List<ToSpec> toSpec;
	
	private DiffServCodePoint diffServCodePoint;
	
	private FragmentationFlag fragmentationFlag;
	
	private List<IPOption> ipOption;
	
	private List<TCPOption> tcpOption;
	
	private List<TCPFlags> tcpFlags;
	
	private List<ICMPType> icmpType;
	
	private List<ETHOption> ethOption;
	
	protected ClassifierImpl() 
	{
	}
	
	public ClassifierImpl(ByteBuf classifierID)
	{
		if(classifierID==null)
			throw new IllegalArgumentException("Classifier-ID is required");
		
		this.classifierID = new ClassifierIDImpl(classifierID, null, null);				
	}
	
	public ByteBuf getClassifierID()
	{
		if(this.classifierID==null)
			return null;
		
		return this.classifierID.getValue();
	}
	
	public void setClassifierID(ByteBuf value)
	{
		if(value==null)
			throw new IllegalArgumentException("Classifier-ID is required");
		
		this.classifierID = new ClassifierIDImpl(value, null, null);	
	}
	
	public ProtocolEnum getProtocol()
	{
		if(protocol==null)
			return null;
		
		return this.protocol.getEnumerated(ProtocolEnum.class);
	}
	
	public void setProtocol(ProtocolEnum value)
	{
		if(value==null)
			this.protocol = null;
		else
			this.protocol = new ProtocolImpl(value, null, null);
	}
	
	public DirectionEnum getDirection()
	{
		if(direction==null)
			return null;
		
		return this.direction.getEnumerated(DirectionEnum.class);
	}
	
	public void setDirection(DirectionEnum value)
	{
		if(value==null)
			this.direction = null;
		else
			this.direction = new DirectionImpl(value, null, null);
	}
	
	public List<FromSpec> getFromSpec()
	{
		return this.fromSpec;
	}
	
	public void setFromSpec(List<FromSpec> value)
	{
		this.fromSpec = value;
	}
	
	public List<ToSpec> getToSpec()
	{
		return this.toSpec;
	}
	
	public void setToSpec(List<ToSpec> value)
	{
		this.toSpec = value;
	}
	
	public DiffServCodePointEnum getDiffServCodePoint()
	{
		if(diffServCodePoint==null)
			return null;
		
		return this.diffServCodePoint.getEnumerated(DiffServCodePointEnum.class);
	}
	
	public void setDiffServCodePoint(DiffServCodePointEnum value)
	{
		if(value==null)
			this.diffServCodePoint = null;
		else
			this.diffServCodePoint = new DiffServCodePointImpl(value, null, null);
	}
	
	public FragmentationFlagEnum getFragmentationFlag()
	{
		if(fragmentationFlag==null)
			return null;
		
		return this.fragmentationFlag.getEnumerated(FragmentationFlagEnum.class);
	}
	
	public void setFragmentationFlag(FragmentationFlagEnum value)
	{
		if(value==null)
			this.fragmentationFlag = null;
		else
			this.fragmentationFlag = new FragmentationFlagImpl(value, null, null);
	}
	
	public List<IPOption> getIPOption()
	{
		return this.ipOption;
	}
	
	public void setIPOption(List<IPOption> value)
	{
		this.ipOption = value;
	}
	
	public List<TCPOption> getTCPOption()
	{
		return this.tcpOption;
	}
	
	public void setTCPOption(List<TCPOption> value)
	{
		this.tcpOption = value;
	}
	
	public List<TCPFlags> getTCPFlags()
	{
		return this.tcpFlags;
	}
	
	public void setTCPFlags(List<TCPFlags> value)
	{
		this.tcpFlags = value;
	}
	
	public List<ICMPType> getICMPType()
	{
		return icmpType;
	}
	
	public void setICMPType(List<ICMPType> value)
	{
		this.icmpType = value;
	}
	
	public List<ETHOption> getETHOption()
	{
		return ethOption;
	}
	
	public void setETHOption(List<ETHOption> value)
	{
		this.ethOption = value;
	}	
	
	@DiameterValidate
	public String validate()
	{
		if(classifierID==null)
			return "Classifier-ID is required";
		
		return null;
	}
}