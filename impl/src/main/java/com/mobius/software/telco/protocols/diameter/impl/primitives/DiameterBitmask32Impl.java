package com.mobius.software.telco.protocols.diameter.impl.primitives;

import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask32;
/**
*
* @author yulian oifa
*
*/
public class DiameterBitmask32Impl extends DiameterInteger32Impl implements DiameterBitmask32
{
	private static final int[] masks= {0x00000001, 0x00000002, 0x00000004, 0x00000008, 0x00000010, 0x00000020, 0x00000040, 0x00000080, 
									   0x00000100, 0x00000200, 0x00000400, 0x00000800, 0x00001000, 0x00002000, 0x00004000, 0x00008000,
									   0x00010000, 0x00020000, 0x00040000, 0x00080000, 0x00100000, 0x00200000, 0x00400000, 0x00800000, 
									   0x01000000, 0x02000000, 0x04000000, 0x08000000, 0x10000000, 0x20000000, 0x40000000, 0x80000000 };
	//required for parser
	protected DiameterBitmask32Impl() 
	{
		
	}
	
	protected DiameterBitmask32Impl(Integer value)
	{
		super(value, null, null);
	}
	
	public DiameterBitmask32Impl(List<Integer> bitsToSet) throws InvalidAvpValueException 
	{
		Integer value=0;
		if(bitsToSet!=null && bitsToSet.size()>0)
		{
			for(Integer curr:bitsToSet)
			{
				if(curr>=masks.length)
					throw new InvalidAvpValueException("Invalid bit index(should be 0 to 63)", Arrays.asList(new DiameterAvp[] { this }));
				
				value|=masks[curr];
			}
		}
		
		setInteger(value);
	}

	@Override
	public Boolean getBit(int bit)
	{
		Integer value=getInteger();
		if(value==null)
			return false;
		
		return (value & masks[bit])!=0;
	}

	@Override
	public void setBit(int bit,boolean isOn) throws InvalidAvpValueException
	{
		if(bit>=masks.length)
			throw new InvalidAvpValueException("Invalid bit index(should be 0 to 31", Arrays.asList(new DiameterAvp[] { this }));
		
		setBitUnchecked(bit, false);
	}
	
	protected void setBitUnchecked(int bit,boolean isOn)
	{
		Integer value=getInteger();
		if(value==null)
			value=0;
		
		if(getBit(bit)) 
		{
			if(!isOn)
				value-=masks[bit];
		}
		else
		{
			if(isOn)
				value|=masks[bit];
		}
		
		setInteger(value);
	}
}