package com.mobius.software.telco.protocols.diameter.impl.primitives;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.jdiameter.api.AvpSet;
import org.jdiameter.client.api.IMessage;
import org.jdiameter.client.impl.parser.ElementParser;
import org.jdiameter.client.impl.parser.MessageParser;
import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DiameterUnsigned32Test 
{
	public static final Long MAX_UINT_32_VALUE=4294967295L;
	
	@Test
	public void testUnsigned32Coding()
	{
		MessageParser messageParser = new MessageParser();
		ElementParser elementParser=new ElementParser();
		
		IMessage dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		AvpSet avpSet = dummyMessage.getAvps();
		
		Long value=0L;
		
		avpSet.addAvp(1234, value, true);
		DiameterUnsigned32Impl integer=new DiameterUnsigned32Impl(value, null, null);
		
		ByteBuf ourResult = Unpooled.buffer();
		integer.encode(ourResult);
		
		byte[] ourData = new byte[ourResult.readableBytes()];
		ourResult.readBytes(ourData);
		
		byte[] theirData = elementParser.encodeAvpSet(avpSet);
		assertEquals(theirData.length,ourData.length+8);
		//removing the header
		byte[] theirRealData=new byte[theirData.length-8];
		System.arraycopy(theirData, 8, theirRealData, 0, theirRealData.length);
		
		assertArrayEquals(theirRealData, ourData);
		
		integer=new DiameterUnsigned32Impl();
		integer.decode(Unpooled.wrappedBuffer(ourData), 4);
		assertEquals(integer.getUnsigned(),value);	
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		value=1L;
		
		avpSet.addAvp(1234, value, 2335L, true, false, true);
		integer=new DiameterUnsigned32Impl(value, null, null);
		
		ourResult = Unpooled.buffer();
		integer.encode(ourResult);
		
		ourData = new byte[ourResult.readableBytes()];
		ourResult.readBytes(ourData);
		
		theirData = elementParser.encodeAvpSet(avpSet);
		assertEquals(theirData.length,ourData.length+12);
		//removing the header with vendorId
		theirRealData=new byte[theirData.length-12];
		System.arraycopy(theirData, 12, theirRealData, 0, theirRealData.length);
		
		integer=new DiameterUnsigned32Impl();
		integer.decode(Unpooled.wrappedBuffer(ourData), 4);
		assertEquals(integer.getUnsigned(),value);	
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		assertArrayEquals(theirRealData, ourData);
		
		value=MAX_UINT_32_VALUE;
		
		avpSet.addAvp(1234, value, 2335L, true, false, true);
		integer=new DiameterUnsigned32Impl(value, null, null);
		
		ourResult = Unpooled.buffer();
		integer.encode(ourResult);
		
		ourData = new byte[ourResult.readableBytes()];
		ourResult.readBytes(ourData);
		
		theirData = elementParser.encodeAvpSet(avpSet);
		assertEquals(theirData.length,ourData.length+12);
		//removing the header with vendorId
		theirRealData=new byte[theirData.length-12];
		System.arraycopy(theirData, 12, theirRealData, 0, theirRealData.length);
		
		assertArrayEquals(theirRealData, ourData);
		
		integer=new DiameterUnsigned32Impl();
		integer.decode(Unpooled.wrappedBuffer(ourData), 4);
		assertEquals(integer.getUnsigned(),value);						
	}
}
