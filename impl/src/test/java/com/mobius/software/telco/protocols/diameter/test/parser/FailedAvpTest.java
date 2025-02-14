package com.mobius.software.telco.protocols.diameter.test.parser;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerWithSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gx.CreditControlRequestImpl;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;

import io.netty.buffer.Unpooled;

public class FailedAvpTest
{
	String bad = "010000a8400001100100001600000004000000040000010740000018303937623233393734363061343832610000010c4000000c0000138a0000010840000017706372662e6f7261636c652e636f6d0000000128400000126f7261636c652e636f6d0000000001024000000c01000016000001a04000000c000000030000019f4000000c000000020000011740000020000001074000001830393762323339373436306134383261";

	@Test
	public void testBadAVP() throws DiameterException
	{
		Class<?> commonClass = com.mobius.software.telco.protocols.diameter.commands.commons.AbortSessionRequest.class;
		Class<?> gxClassImpl = CreditControlRequestImpl.class;
		Package commonPackage = commonClass.getPackage();
		Package gxPackageImpl = gxClassImpl.getPackage();
		Class<?> avpClass = com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterBitmask32Impl.class;
		Package avpPackage = avpClass.getPackage();
		ClassLoader defaultClassLoader = Thread.currentThread().getContextClassLoader();
		DiameterParser parser = new DiameterParser(defaultClassLoader, Arrays.asList(new Class<?>[] { DiameterErrorAnswerImpl.class, DiameterErrorAnswerWithSessionImpl.class }), avpPackage);
		parser.registerApplication(defaultClassLoader, commonPackage);
		parser.registerApplication(defaultClassLoader, gxPackageImpl);

		byte[] testPayload = hexStringToByteArray(bad);
		
		DiameterMessage message = parser.decode(Unpooled.wrappedBuffer(testPayload), false);
		assertNotNull(message);
	}

	private static byte[] hexStringToByteArray(String hex)
	{
		int len = hex.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2)
		{
			data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
		}
		return data;
	}
}
