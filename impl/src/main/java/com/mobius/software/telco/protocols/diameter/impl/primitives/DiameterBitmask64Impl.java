package com.mobius.software.telco.protocols.diameter.impl.primitives;

import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterBitmask64;
/**
*
* @author yulian oifa
*
*/
public class DiameterBitmask64Impl extends DiameterUnsigned64Impl implements DiameterBitmask64
{
	private static final long[] masks= {0x0000000000000001L, 0x0000000000000002L, 0x0000000000000004L, 0x0000000000000008L, 0x0000000000000010L, 0x0000000000000020L, 0x0000000000000040L, 0x0000000000000080L, 
									    0x0000000000000100L, 0x0000000000000200L, 0x0000000000000400L, 0x0000000000000800L, 0x0000000000001000L, 0x0000000000002000L, 0x0000000000004000L, 0x0000000000008000L,
									    0x0000000000010000L, 0x0000000000020000L, 0x0000000000040000L, 0x0000000000080000L, 0x0000000000100000L, 0x0000000000200000L, 0x0000000000400000L, 0x0000000000800000L, 
									    0x0000000001000000L, 0x0000000002000000L, 0x0000000004000000L, 0x0000000008000000L, 0x0000000010000000L, 0x0000000020000000L, 0x0000000040000000L, 0x0000000080000000L,
									    0x0000000100000000L, 0x0000000200000000L, 0x0000000400000000L, 0x0000000800000000L, 0x0000001000000000L, 0x0000002000000000L, 0x0000004000000000L, 0x0000008000000000L, 
									    0x0000010000000000L, 0x0000020000000000L, 0x0000040000000000L, 0x0000080000000000L, 0x0000100000000000L, 0x0000200000000000L, 0x0000400000000000L, 0x0000800000000000L,
									    0x0001000000000000L, 0x0002000000000000L, 0x0004000000000000L, 0x0008000000000000L, 0x0010000000000000L, 0x0020000000000000L, 0x0040000000000000L, 0x0080000000000000L, 
									    0x0100000000000000L, 0x0200000000000000L, 0x0400000000000000L, 0x0800000000000000L, 0x1000000000000000L, 0x2000000000000000L, 0x4000000000000000L, 0x8000000000000000L,
									    };
	//required for parser
	protected DiameterBitmask64Impl() 
	{
		
	}
	
	protected DiameterBitmask64Impl(Long value)
	{
		super(value, null, null);
	}
	
	public DiameterBitmask64Impl(List<Integer> bitsToSet) throws InvalidAvpValueException 
	{
		Long value=0L;
		if(bitsToSet!=null && bitsToSet.size()>0)
		{
			for(Integer curr:bitsToSet)
			{
				if(curr>=masks.length)
					throw new InvalidAvpValueException("Invalid bit index(should be 0 to 63)", Arrays.asList(new DiameterAvp[] { this }));
				
				value|=masks[curr];
			}
		}
		
		setLong(value);
	}

	@Override
	public Boolean getBit(int bit)
	{
		Long value=getLong();
		if(value==null)
			return false;
		
		return (value & masks[bit])!=0;
	}

	@Override
	public void setBit(int bit,boolean isOn) throws InvalidAvpValueException
	{
		if(bit>=masks.length)
			throw new InvalidAvpValueException("Invalid bit index(should be 0 to 63", Arrays.asList(new DiameterAvp[] { this }));
		
		setBitUnchecked(bit, isOn);
	}
	
	protected void setBitUnchecked(int bit,boolean isOn)
	{
		Long value=getLong();
		if(value==null)
			value=0L;
		
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
		
		setLong(value);
	}
}