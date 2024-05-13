package com.mobius.software.telco.protocols.diameter.test.primitives;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.jdiameter.api.AvpSet;
import org.jdiameter.client.api.IMessage;
import org.jdiameter.client.impl.parser.ElementParser;
import org.jdiameter.client.impl.parser.MessageParser;
import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterUriImpl;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTransport;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DiameterUriTest 
{
	@Test
	public void testUriCoding()
	{
		MessageParser messageParser = new MessageParser();
		ElementParser elementParser=new ElementParser();
		
		IMessage dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		AvpSet avpSet = dummyMessage.getAvps();
		
		String host="host.example.com";
		DiameterTransport transport=DiameterTransport.TCP;
		DiameterProtocol protocol=DiameterProtocol.DIAMETER;
		Integer port=6666;
		DiameterTransport transport2=DiameterTransport.UDP;
		DiameterProtocol protocol2=DiameterProtocol.RADIUS;
		Integer port2=1813;
		
		avpSet.addAvp(1234, "aaa://host.example.com;transport=tcp", false);
		DiameterUriImpl octetString=new DiameterUriImpl(host,null,false,transport, null, null, null);
		
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
		
		octetString=new DiameterUriImpl();
		ByteBuf encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 36);
		
		assertEquals(octetString.getHost(), host);
		assertNull(octetString.getPort());
		assertFalse(octetString.getIsSecure());
		assertEquals(octetString.getTransport(), transport);
		assertNull(octetString.getProtocol());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		avpSet.addAvp(1234, "aaa://host.example.com:6666;transport=tcp", 2335L, true, false, false);
		octetString=new DiameterUriImpl(host,port,false,transport, null, null, null);
		
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
		
		octetString=new DiameterUriImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 41);
		
		assertEquals(octetString.getHost(), host);
		assertEquals(octetString.getPort(),port);
		assertFalse(octetString.getIsSecure());
		assertEquals(octetString.getTransport(), transport);
		assertNull(octetString.getProtocol());	
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		avpSet.addAvp(1234, "aaas://host.example.com:6666;transport=tcp", 2335L, true, false, false);
		octetString=new DiameterUriImpl(host,port,true,transport, null, null, null);
		
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
		
		octetString=new DiameterUriImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 42);
		
		assertEquals(octetString.getHost(), host);
		assertEquals(octetString.getPort(),port);
		assertTrue(octetString.getIsSecure());
		assertEquals(octetString.getTransport(), transport);
		assertNull(octetString.getProtocol());	
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		avpSet.addAvp(1234, "aaa://host.example.com;protocol=diameter", 2335L, true, false, false);
		octetString=new DiameterUriImpl(host,null,false,null, protocol, null, null);
		
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
		
		octetString=new DiameterUriImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 40);
		
		assertEquals(octetString.getHost(), host);
		assertNull(octetString.getPort());
		assertFalse(octetString.getIsSecure());
		assertNull(octetString.getTransport());
		assertEquals(octetString.getProtocol(), protocol);		
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		avpSet.addAvp(1234, "aaa://host.example.com:6666;protocol=diameter", 2335L, true, false, false);
		octetString=new DiameterUriImpl(host,port,false,null, protocol, null, null);
		
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
		
		octetString=new DiameterUriImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 45);
		
		assertEquals(octetString.getHost(), host);
		assertEquals(octetString.getPort(),port);
		assertFalse(octetString.getIsSecure());
		assertNull(octetString.getTransport());
		assertEquals(octetString.getProtocol(), protocol);	
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		avpSet.addAvp(1234, "aaa://host.example.com:6666;transport=tcp;protocol=diameter", 2335L, true, false, false);
		octetString=new DiameterUriImpl(host,port,false,transport, protocol, null, null);
		
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
		
		octetString=new DiameterUriImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 59);
		
		assertEquals(octetString.getHost(), host);
		assertEquals(octetString.getPort(),port);
		assertFalse(octetString.getIsSecure());
		assertEquals(octetString.getTransport(), transport);
		assertEquals(octetString.getProtocol(), protocol);	
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		avpSet.addAvp(1234, "aaas://host.example.com:6666;transport=tcp;protocol=diameter", 2335L, true, false, false);
		octetString=new DiameterUriImpl(host,port,true,transport, protocol, null, null);
		
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
		
		octetString=new DiameterUriImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 60);
		
		assertEquals(octetString.getHost(), host);
		assertEquals(octetString.getPort(),port);
		assertTrue(octetString.getIsSecure());
		assertEquals(octetString.getTransport(), transport);
		assertEquals(octetString.getProtocol(), protocol);	
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		avpSet.addAvp(1234, "aaa://host.example.com:1813;transport=udp;protocol=radius", 2335L, true, false, false);
		octetString=new DiameterUriImpl(host,port2,false,transport2, protocol2, null, null);
		
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
		
		octetString=new DiameterUriImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 57);
		
		assertEquals(octetString.getHost(), host);
		assertEquals(octetString.getPort(),port2);
		assertFalse(octetString.getIsSecure());
		assertEquals(octetString.getTransport(), transport2);
		assertEquals(octetString.getProtocol(), protocol2);	
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		avpSet.addAvp(1234, "aaas://host.example.com:1813;transport=udp;protocol=radius", 2335L, true, false, false);
		octetString=new DiameterUriImpl(host,port2,true,transport2, protocol2, null, null);
		
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
		
		octetString=new DiameterUriImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 58);
		
		assertEquals(octetString.getHost(), host);
		assertEquals(octetString.getPort(),port2);
		assertTrue(octetString.getIsSecure());
		assertEquals(octetString.getTransport(), transport2);
		assertEquals(octetString.getProtocol(), protocol2);	
	}
}
