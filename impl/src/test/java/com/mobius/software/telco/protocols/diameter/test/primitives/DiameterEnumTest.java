package com.mobius.software.telco.protocols.diameter.test.primitives;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.jdiameter.api.AvpSet;
import org.jdiameter.client.api.IMessage;
import org.jdiameter.client.impl.parser.ElementParser;
import org.jdiameter.client.impl.parser.MessageParser;
import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterEnumeratedImpl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DiameterEnumTest 
{
	@Test
	public void testEnumCoding()
	{
		MessageParser messageParser = new MessageParser();
		ElementParser elementParser=new ElementParser();
		
		IMessage dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		AvpSet avpSet = dummyMessage.getAvps();
		
		Integer value=DiameterTestingEnum.ONE.getValue();
		
		avpSet.addAvp(1234, value);
		DiameterEnumeratedImpl<DiameterTestingEnum> integer=new DiameterEnumeratedImpl<DiameterTestingEnum>(DiameterTestingEnum.ONE, null, null);
		
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
		
		integer=new DiameterEnumeratedImpl<DiameterTestingEnum>();
		integer.decode(Unpooled.wrappedBuffer(ourData), 4);
		assertEquals(integer.getEnumerated(DiameterTestingEnum.class),DiameterTestingEnum.ONE);
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		value=DiameterTestingEnum.TWO.getValue();
		
		avpSet.addAvp(1234, value, 2335L, true, false);
		integer=new DiameterEnumeratedImpl<DiameterTestingEnum>(DiameterTestingEnum.TWO, null, null);
		
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
		
		integer=new DiameterEnumeratedImpl<DiameterTestingEnum>();
		integer.decode(Unpooled.wrappedBuffer(ourData), 4);
		assertEquals(integer.getEnumerated(DiameterTestingEnum.class),DiameterTestingEnum.TWO);				
	}
}
