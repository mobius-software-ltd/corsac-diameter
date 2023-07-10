package com.mobius.software.telco.protocols.diameter.impl.primitives;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.jdiameter.api.AvpSet;
import org.jdiameter.client.api.IMessage;
import org.jdiameter.client.impl.parser.ElementParser;
import org.jdiameter.client.impl.parser.MessageParser;
import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DiameterAddressTest 
{
	@Test
	public void testAddressCoding() throws UnknownHostException
	{
		MessageParser messageParser = new MessageParser();
		ElementParser elementParser=new ElementParser();
		
		IMessage dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		AvpSet avpSet = dummyMessage.getAvps();
		
		String address="127.0.0.1";
		InetAddress inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress);
		DiameterAddressImpl octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 6);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="::1";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 18);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="1.2.3.4";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 6);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="01.102.103.104";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 6);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="10.102.103.104";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 6);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="2001:db8:3333:4444:5555:6666:7777:8888";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 18);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="2001:db8:3333:4444:CCCC:DDDD:EEEE:FFFF";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 18);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="::";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 18);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="2001:db8::";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 18);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="::1234:5678";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 18);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="2001:db8::1234:5678";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 18);
		assertEquals(inetAddress, octetString.getAddress());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		address="2001:0db8:0001:0000:0000:0ab9:C0A8:0102";
		inetAddress=InetAddress.getByName(address);
		
		avpSet.addAvp(1234, inetAddress, 2335L, true, false);
		octetString=new DiameterAddressImpl(inetAddress, null, null);
		
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
		
		octetString=new DiameterAddressImpl();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 18);
		assertEquals(inetAddress, octetString.getAddress());				
	}
}
