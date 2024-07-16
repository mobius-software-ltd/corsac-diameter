package com.mobius.software.telco.protocols.diameter.test.parser;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.commons.DeviceWatchdogAnswer;
import com.mobius.software.telco.protocols.diameter.commands.commons.DeviceWatchdogRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerWithSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.CapabilitiesExchangeRequestmpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DeviceWatchdogTest
{
	private ByteBuf deviceWatchdogRequestMessage = Unpooled.wrappedBuffer(new byte[] {0x01, 0x00, 0x00, 0x44, (byte)0x80, 0x00, 0x01, 0x18, 0x00, 0x00, 0x00, 0x00, 0x1c, 0x7e, 0x1e, 0x61, 0x1c, 0x7e, 0x1e, 0x61, 0x00, 0x00, 0x01, 0x08, 0x40, 0x00, 0x00, 0x15, 0x31, 0x37, 0x32, 0x2e, 0x33, 0x30, 0x2e, 0x32, 0x37, 0x2e, 0x31, 0x37, 0x36, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x28, 0x40, 0x00, 0x00, 0x18, 0x74, 0x61, 0x69, 0x77, 0x61, 0x6e, 0x6d, 0x6f, 0x62, 0x69, 0x6c, 0x65, 0x2e, 0x63, 0x6f, 0x6d }); 
	private ByteBuf deviceWatchdogAnswerMessage = Unpooled.wrappedBuffer(new byte[] {0x01, 0x00, 0x00, 0x68, 0x00, 0x00, 0x01, 0x18, 0x00, 0x00, 0x00, 0x00, 0x1c, 0x7e, 0x1e, 0x61, 0x1c, 0x7e, 0x1e, 0x61, 0x00, 0x00, 0x01, 0x0c, 0x40, 0x00, 0x00, 0x0c, 0x00, 0x00, 0x07, (byte)0xd1, 0x00, 0x00, 0x01, 0x08, 0x40, 0x00, 0x00, 0x28, 0x53, 0x49, 0x54, 0x43, 0x53, 0x41, 0x50, 0x43, 0x30, 0x31, 0x2e, 0x73, 0x61, 0x70, 0x63, 0x2e, 0x74, 0x61, 0x69, 0x77, 0x61, 0x6e, 0x6d, 0x6f, 0x62, 0x69, 0x6c, 0x65, 0x2e, 0x63, 0x6f, 0x6d, 0x00, 0x00, 0x01, 0x28, 0x40, 0x00, 0x00, 0x1d, 0x73, 0x61, 0x70, 0x63, 0x2e, 0x74, 0x61, 0x69, 0x77, 0x61, 0x6e, 0x6d, 0x6f, 0x62, 0x69, 0x6c, 0x65, 0x2e, 0x63, 0x6f, 0x6d, 0x00, 0x00, 0x00});

	@Test
	public void testDeviceWatchdog() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser(Arrays.asList(new Class<?>[] { DiameterErrorAnswerImpl.class , DiameterErrorAnswerWithSessionImpl.class }),Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		
		//make sure classes are loaded
		Class<?> clazz = CapabilitiesExchangeRequestmpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.common"));
		
		deviceWatchdogRequestMessage.resetReaderIndex();
		DiameterMessage decodeMessage = diameterParser.decode(deviceWatchdogRequestMessage, false);
		assertNotNull(decodeMessage);
		assertTrue(decodeMessage instanceof DeviceWatchdogRequest);
		DeviceWatchdogRequest dwr = (DeviceWatchdogRequest)decodeMessage;
		assertFalse(dwr.getIsRetransmit());
		assertFalse(dwr.getIsProxyable());
		assertNotNull(dwr.getEndToEndIdentifier());
		assertNotNull(dwr.getHopByHopIdentifier());
		assertEquals(dwr.getEndToEndIdentifier(),new Long(0x1c7e1e61L));
		assertEquals(dwr.getHopByHopIdentifier(),new Long(0x1c7e1e61L));
		assertNotNull(dwr.getOriginHost());
		assertEquals(dwr.getOriginHost(),"172.30.27.176");
		assertNotNull(dwr.getOriginRealm());
		assertEquals(dwr.getOriginRealm(),"taiwanmobile.com");
		
		ByteBuf encodedMessage = diameterParser.encode(dwr);
		byte[] dwrEncodedData = new byte[encodedMessage.readableBytes()];
		encodedMessage.readBytes(dwrEncodedData);
		deviceWatchdogRequestMessage.setIndex(0,deviceWatchdogRequestMessage.writerIndex());
		byte[] dwrData = new byte[deviceWatchdogRequestMessage.readableBytes()];
		deviceWatchdogRequestMessage.readBytes(dwrData);
		assertArrayEquals(dwrEncodedData, dwrData);
		
		deviceWatchdogAnswerMessage.resetReaderIndex();
		decodeMessage = diameterParser.decode(deviceWatchdogAnswerMessage, false);
		assertNotNull(decodeMessage);
		assertTrue(decodeMessage instanceof DeviceWatchdogAnswer);
		DeviceWatchdogAnswer dwa = (DeviceWatchdogAnswer)decodeMessage;
		assertFalse(dwa.getIsError());
		assertFalse(dwa.getIsProxyable());
		assertFalse(dwa.getIsRetransmit());
		assertNotNull(dwa.getEndToEndIdentifier());
		assertNotNull(dwa.getHopByHopIdentifier());
		assertEquals(dwa.getEndToEndIdentifier(),new Long(0x1c7e1e61L));
		assertEquals(dwa.getHopByHopIdentifier(),new Long(0x1c7e1e61L));
		assertNotNull(dwa.getResultCode());
		assertEquals(dwa.getResultCode(),new Long(ResultCodes.DIAMETER_SUCCESS));
		assertNotNull(dwa.getOriginHost());
		assertEquals(dwa.getOriginHost(),"SITCSAPC01.sapc.taiwanmobile.com");
		assertNotNull(dwa.getOriginRealm());
		assertEquals(dwa.getOriginRealm(),"sapc.taiwanmobile.com");
		
		encodedMessage = diameterParser.encode(dwa);
		byte[] dwaEncodedData = new byte[encodedMessage.readableBytes()];
		encodedMessage.readBytes(dwaEncodedData);
		deviceWatchdogAnswerMessage.setIndex(0,deviceWatchdogAnswerMessage.writerIndex());
		byte[] dwaData = new byte[deviceWatchdogAnswerMessage.readableBytes()];
		deviceWatchdogAnswerMessage.readBytes(dwaData);
		assertArrayEquals(dwaEncodedData, dwaData);
	}
}