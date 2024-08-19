package com.mobius.software.telco.protocols.diameter.test.parser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.CommandCodes;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerWithSessionImpl;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;

import io.netty.buffer.ByteBuf;

public class DiameterErrorTest
{
	@Test
	public void testError() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser(this.getClass().getClassLoader(), Arrays.asList(new Class<?>[] { DiameterErrorAnswerImpl.class , DiameterErrorAnswerWithSessionImpl.class }),Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		
		//make sure classes are loaded
		Class<?> clazz = DiameterErrorAnswerWithSessionImpl.class;
		assertNotNull(clazz);
		
		DiameterErrorAnswerWithSessionImpl errorMessage = new DiameterErrorAnswerWithSessionImpl(Long.valueOf(ApplicationIDs.ACCOUNTING), CommandCodes.CREDIT_CONTROL, "a.localhost.com", "localhost.com", false, ResultCodes.DIAMETER_AVP_UNSUPPORTED, "12345");
		assertNotNull(errorMessage);
		
		ByteBuf encodedMessage = diameterParser.encode(errorMessage);
		byte[] errorEncodedData = new byte[encodedMessage.readableBytes()];
		encodedMessage.readBytes(errorEncodedData);
		assertNotNull(errorEncodedData);
		assertEquals(errorEncodedData.length,96);
	}
}