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

public class DiameterIdentityTest 
{
	@Test
	public void testIdentityCoding()
	{
		MessageParser messageParser = new MessageParser();
		ElementParser elementParser=new ElementParser();
		
		IMessage dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		AvpSet avpSet = dummyMessage.getAvps();
		
		String data="a.google.com";
		
		avpSet.addAvp(1234, data, false);
		DiameterIdentityImpl octetString=new DiameterIdentityImpl(data, null, null);
		
		ByteBuf ourResult = Unpooled.buffer();
		octetString.encode(ourResult);
		
		byte[] ourData = new byte[ourResult.readableBytes()];
		ourResult.readBytes(ourData);
		
		byte[] theirData = elementParser.encodeAvpSet(avpSet);
		assertEquals(theirData.length,ourData.length+8);
		//removing the header
		byte[] theirRealData=new byte[theirData.length-8];
		System.arraycopy(theirData, 8, theirRealData, 0, theirRealData.length);
		
		assertArrayEquals(theirRealData, ourData);
		
		octetString=new DiameterIdentityImpl();
		ByteBuf encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 12);
		assertEquals(octetString.getIdentity(), data);
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		data="mobius-software.com";
		
		avpSet.addAvp(1234, data, 2335L, true, false, false);
		octetString=new DiameterIdentityImpl(data, null, null);
		
		ourResult = Unpooled.buffer();
		octetString.encode(ourResult);
		
		ourData = new byte[ourResult.readableBytes()];
		ourResult.readBytes(ourData);
		
		theirData = elementParser.encodeAvpSet(avpSet);
		assertEquals(theirData.length,ourData.length+12);
		//removing the header with vendorId
		theirRealData=new byte[theirData.length-12];
		System.arraycopy(theirData, 12, theirRealData, 0, theirRealData.length);
		
		assertArrayEquals(theirRealData, ourData);
		
		octetString=new DiameterIdentityImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 19);
		assertEquals(octetString.getIdentity(), data);
	}
}
