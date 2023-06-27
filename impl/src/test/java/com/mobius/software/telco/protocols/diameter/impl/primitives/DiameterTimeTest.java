package com.mobius.software.telco.protocols.diameter.impl.primitives;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.jdiameter.api.AvpSet;
import org.jdiameter.client.api.IMessage;
import org.jdiameter.client.impl.parser.ElementParser;
import org.jdiameter.client.impl.parser.MessageParser;
import org.junit.Test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DiameterTimeTest 
{
	SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	@Test
	public void dateBoundariesTest()
	{
		sf.setTimeZone(TimeZone.getTimeZone("UTC"));
	    
		Calendar calendar=GregorianCalendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
		calendar.set(2036, Calendar.FEBRUARY, 7, 6, 28, 16);
		calendar.set(Calendar.MILLISECOND, 0);
		Long timestamp1=calendar.getTimeInMillis();
		Long dateTimeValue=DiameterTime.fromDate(calendar.getTime());
		assertEquals(dateTimeValue,new Long(0L));
	
		calendar.set(2036, Calendar.FEBRUARY, 7, 6, 28, 15);
		calendar.set(Calendar.MILLISECOND, 0);
		Long timestamp2=calendar.getTimeInMillis();
		dateTimeValue=DiameterTime.fromDate(calendar.getTime());
		assertEquals(dateTimeValue,new Long(4294967295L));
		
		calendar.set(2147, Calendar.SEPTEMBER, 3, 6, 28, 15);
		calendar.set(Calendar.MILLISECOND, 0);
		Long timestamp3=calendar.getTimeInMillis();
		dateTimeValue=DiameterTime.fromDate(calendar.getTime());		
		assertEquals(dateTimeValue,new Long(3520799999L));
		
		calendar.set(2011, Calendar.JULY, 28, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Long timestamp4=calendar.getTimeInMillis();
		dateTimeValue=DiameterTime.fromDate(calendar.getTime());
		assertEquals(dateTimeValue,new Long(3520800000L));
		
		DiameterTime dateTime=new DiameterTime();
		byte[] data=new byte[8];
		ByteBuf buffer=Unpooled.wrappedBuffer(data);
		buffer.resetWriterIndex();
		buffer.writeInt(Long.valueOf(0L).intValue());
		dateTime.decode(Unpooled.wrappedBuffer(data), 8);
		assertEquals(sf.format(dateTime.getRealValue()),"07/02/2036 06:28:16");
		assertEquals(new Long(dateTime.getRealValue().getTime()),timestamp1);
		
		dateTime=new DiameterTime();
		data=new byte[8];
		buffer=Unpooled.wrappedBuffer(data);
		buffer.resetWriterIndex();
		buffer.writeInt(Long.valueOf(4294967295L).intValue());
		dateTime.decode(Unpooled.wrappedBuffer(data), 8);
		assertEquals(sf.format(dateTime.getRealValue()),"07/02/2036 06:28:15");
		assertEquals(new Long(dateTime.getRealValue().getTime()),timestamp2);
		
		dateTime=new DiameterTime();
		data=new byte[8];
		buffer=Unpooled.wrappedBuffer(data);
		buffer.resetWriterIndex();
		buffer.writeInt(Long.valueOf(3520799999L).intValue());
		dateTime.decode(Unpooled.wrappedBuffer(data), 8);
		assertEquals(sf.format(dateTime.getRealValue()),"03/09/2147 06:28:15");
		assertEquals(new Long(dateTime.getRealValue().getTime()),timestamp3);
		
		dateTime=new DiameterTime();
		data=new byte[8];
		buffer=Unpooled.wrappedBuffer(data);
		buffer.resetWriterIndex();
		buffer.writeInt(Long.valueOf(3520800000L).intValue());
		dateTime.decode(Unpooled.wrappedBuffer(data), 8);
		assertEquals(sf.format(dateTime.getRealValue()),"28/07/2011 00:00:00");
		assertEquals(new Long(dateTime.getRealValue().getTime()),timestamp4);
	}
	
	@Test
	public void testDateCoding() throws UnknownHostException
	{
		MessageParser messageParser = new MessageParser();
		ElementParser elementParser=new ElementParser();
		
		IMessage dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		AvpSet avpSet = dummyMessage.getAvps();
		
		Calendar calendar=GregorianCalendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
		calendar.set(2036, Calendar.FEBRUARY, 7, 6, 28, 16);
		calendar.set(Calendar.MILLISECOND, 0);
		
		avpSet.addAvp(1234, calendar.getTime());
		DiameterTime octetString=new DiameterTime(calendar.getTime(), null, null);
		
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
		
		octetString=new DiameterTime();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 4);
		assertEquals(new Long(calendar.getTimeInMillis()), new Long(octetString.getRealValue().getTime()));
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		calendar.set(2036, Calendar.FEBRUARY, 7, 6, 28, 15);
		calendar.set(Calendar.MILLISECOND, 0);
		
		avpSet.addAvp(1234, calendar.getTime(), 2335L, true, false);
		octetString=new DiameterTime(calendar.getTime(), null, null);
		
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
		
		octetString=new DiameterTime();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 4);
		assertEquals(calendar.getTimeInMillis(), octetString.getRealValue().getTime());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		calendar.set(2147, Calendar.SEPTEMBER, 3, 6, 28, 15);
		calendar.set(Calendar.MILLISECOND, 0);
		
		avpSet.addAvp(1234, calendar.getTime(), 2335L, true, false);
		octetString=new DiameterTime(calendar.getTime(), null, null);
		
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
		
		octetString=new DiameterTime();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 4);
		assertEquals(calendar.getTimeInMillis(), octetString.getRealValue().getTime());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		calendar.set(2011, Calendar.JULY, 28, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		avpSet.addAvp(1234, calendar.getTime(), 2335L, true, false);
		octetString=new DiameterTime(calendar.getTime(), null, null);
		
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
		
		octetString=new DiameterTime();
		octetString.decode(Unpooled.wrappedBuffer(ourData), 4);
		assertEquals(calendar.getTimeInMillis(), octetString.getRealValue().getTime());				
	}
}