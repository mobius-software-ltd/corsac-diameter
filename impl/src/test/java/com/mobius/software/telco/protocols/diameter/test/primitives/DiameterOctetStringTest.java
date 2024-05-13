package com.mobius.software.telco.protocols.diameter.test.primitives;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.jdiameter.api.AvpSet;
import org.jdiameter.client.api.IMessage;
import org.jdiameter.client.impl.parser.ElementParser;
import org.jdiameter.client.impl.parser.MessageParser;
import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterOctetStringImpl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DiameterOctetStringTest 
{
	@Test
	public void testOctetStringCoding()
	{
		MessageParser messageParser = new MessageParser();
		ElementParser elementParser=new ElementParser();
		
		IMessage dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		AvpSet avpSet = dummyMessage.getAvps();
		
		byte[] data=new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05};
		
		avpSet.addAvp(1234, data);
		DiameterOctetStringImpl octetString=new DiameterOctetStringImpl(Unpooled.wrappedBuffer(data), null, null);
		
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
		
		octetString=new DiameterOctetStringImpl();
		ByteBuf encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 5);
		ByteBuf decodedValue = octetString.getValue();
		byte[] decodedData=new byte[decodedValue.readableBytes()];
		decodedValue.readBytes(decodedData);
		
		assertArrayEquals(decodedData, data);
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		data=new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06};
		
		avpSet.addAvp(1234, data, 2335L, true, false);
		octetString=new DiameterOctetStringImpl(Unpooled.wrappedBuffer(data), null, null);
		
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
		
		octetString=new DiameterOctetStringImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 6);
		decodedValue = octetString.getValue();
		decodedData=new byte[decodedValue.readableBytes()];
		decodedValue.readBytes(decodedData);
		
		assertArrayEquals(decodedData, data);
	}
}
