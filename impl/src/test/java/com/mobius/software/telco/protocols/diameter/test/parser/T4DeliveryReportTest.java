package com.mobius.software.telco.protocols.diameter.test.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerWithSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.t4.DeliveryReportRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.s6m.UserIdentifierImpl;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;
import com.mobius.software.telco.protocols.diameter.primitives.common.AuthSessionStateEnum;
import com.mobius.software.telco.protocols.diameter.primitives.s6m.UserIdentifier;
import com.mobius.software.telco.protocols.diameter.primitives.t4.SMDeliveryOutcomeT4Enum;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class T4DeliveryReportTest
{
	@Test
	public void testDeliveryReportRequest() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser(this.getClass().getClassLoader(), Arrays.asList(new Class<?>[] { DiameterErrorAnswerImpl.class , DiameterErrorAnswerWithSessionImpl.class }),Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		
		//make sure classes are loaded
		Class<?> clazz = UserIdentifier.class;
		Class<?> avpClass = DeliveryReportRequestImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerApplication(this.getClass().getClassLoader(), Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.t4"));
		
		UserIdentifier userIdentifier=new UserIdentifierImpl();
		userIdentifier.setUserName("123456");
		
		ByteBuf smea=Unpooled.wrappedBuffer(new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05});
		DeliveryReportRequestImpl drr = new DeliveryReportRequestImpl("scscf-01.ims.mnc001.mcc240.3gppnetwork.org", "ims.mnc001.mcc240.3gppnetwork.org", "pcscf-01.ims.mnc001.mcc240.3gppnetwork.org", "ims.mnc001.mcc240.3gppnetwork.org", false, "scscf-01.ims.mnc001.mcc240.3gppnetwork.org;387;479254667", AuthSessionStateEnum.NO_STATE_MAINTAINED, userIdentifier, smea, SMDeliveryOutcomeT4Enum.SUCCESSFUL_TRANSFER);
		ByteBuf encodedMessage = diameterParser.encode(drr);
		byte[] drrEncodedData = new byte[encodedMessage.readableBytes()];
		encodedMessage.readBytes(drrEncodedData);
		DiameterMessage message = diameterParser.decode(Unpooled.wrappedBuffer(drrEncodedData), true);
		assertTrue(message instanceof DeliveryReportRequestImpl);
		drr=(DeliveryReportRequestImpl)message;
		drr.setHopByHopIdentifier(new Long(0x1c90dc0dL));
		drr.setEndToEndIdentifier(new Long(0x00000000L));
		assertFalse(drr.getIsRetransmit());
		assertTrue(drr.getIsProxyable());
		assertNotNull(drr.getEndToEndIdentifier());
		assertNotNull(drr.getHopByHopIdentifier());
		assertEquals(drr.getEndToEndIdentifier(),new Long(0x00000000L));
		assertEquals(drr.getHopByHopIdentifier(),new Long(0x1c90dc0dL));
		assertNotNull(drr.getSessionId());
		assertEquals(drr.getSessionId(),"scscf-01.ims.mnc001.mcc240.3gppnetwork.org;387;479254667");
		assertNotNull(drr.getAuthSessionState());
		assertEquals(drr.getAuthSessionState(),AuthSessionStateEnum.NO_STATE_MAINTAINED);
		assertNotNull(drr.getUserIdentifier());
		assertNotNull(drr.getUserIdentifier().getUserName());
		assertEquals(drr.getUserIdentifier().getUserName(),"123456");
		assertNotNull(drr.getSMDeliveryOutcomeT4());
		assertEquals(drr.getSMDeliveryOutcomeT4(),SMDeliveryOutcomeT4Enum.SUCCESSFUL_TRANSFER);
		assertNotNull(drr.getDestinationHost());
		assertEquals(drr.getDestinationHost(),"pcscf-01.ims.mnc001.mcc240.3gppnetwork.org");
		assertNotNull(drr.getDestinationRealm());
		assertEquals(drr.getDestinationRealm(),"ims.mnc001.mcc240.3gppnetwork.org");
		assertNotNull(drr.getOriginHost());
		assertEquals(drr.getOriginHost(),"scscf-01.ims.mnc001.mcc240.3gppnetwork.org");
		assertNotNull(drr.getOriginRealm());
		assertEquals(drr.getOriginRealm(),"ims.mnc001.mcc240.3gppnetwork.org");	
		assertNotNull(drr.getSMRPSMEA());
		assertEquals(drr.getSMRPSMEA().readableBytes(),5);
	}
}