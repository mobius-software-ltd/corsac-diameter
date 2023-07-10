package com.mobius.software.telco.protocols.diameter.impl.primitives;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.jdiameter.api.AvpSet;
import org.jdiameter.client.api.IMessage;
import org.jdiameter.client.impl.parser.ElementParser;
import org.jdiameter.client.impl.parser.MessageParser;
import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.primitives.DiameterQosAction;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleDirection;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRulePorts;
import com.mobius.software.telco.protocols.diameter.primitives.InternetProtocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DiameterQosFilterRuleTest 
{
	/**
	 * @throws IllegalArgumentException
	 * @throws UnknownHostException
	 * @throws ParseException
	 */
	@Test
	public void testIpFilterRuleCoding() throws IllegalArgumentException, UnknownHostException, ParseException
	{
		MessageParser messageParser = new MessageParser();
		ElementParser elementParser=new ElementParser();
		
		IMessage dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		AvpSet avpSet = dummyMessage.getAvps();
		
		DiameterQosAction action=DiameterQosAction.METER;
		DiameterRuleDirection direction=DiameterRuleDirection.IN;
		InternetProtocol protocol=InternetProtocol.TCP;
		DiameterRuleAddressImpl fromAddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.254.0"), 24, false);
		List<DiameterRulePorts> fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5061)});
		DiameterRuleAddressImpl toddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.0.0"), 24, false);
		List<DiameterRulePorts> toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5060)});
		
		avpSet.addAvp(1234, "meter in 6 from 10.98.254.0/24 5061 to 10.98.0.0/24 5060", false);
		DiameterQosFilterRuleImpl octetString=new DiameterQosFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,null,null,null,null,null,null);
		
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
		
		octetString=new DiameterQosFilterRuleImpl();
		ByteBuf encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 56);
		
		assertEquals(octetString.getAction(), action);
		assertEquals(octetString.getDirection(), direction);
		assertEquals(octetString.getProtocol(), protocol);
		assertEquals(octetString.getFrom(), fromAddress);
		assertNotNull(octetString.getFromPorts());
		assertEquals(octetString.getFromPorts().size(), 1);
		assertEquals(octetString.getFromPorts().get(0).getMin(), fromPorts.get(0).getMin());
		assertEquals(octetString.getFromPorts().get(0).getMax(), fromPorts.get(0).getMax());
		assertEquals(octetString.getTo(), toddress);
		assertNotNull(octetString.getFromPorts());
		assertEquals(octetString.getToPorts().size(), 1);
		assertEquals(octetString.getToPorts().get(0).getMin(), toPorts.get(0).getMin());
		assertEquals(octetString.getToPorts().get(0).getMax(), toPorts.get(0).getMax());
		assertNull(octetString.getDscpColor());
		assertNull(octetString.getColorOver());
		assertNull(octetString.getColorUnder());
		assertNull(octetString.getMeteringRate());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		action=DiameterQosAction.METER;
		direction=DiameterRuleDirection.OUT;
		protocol=InternetProtocol.TCP;
		Long meteringRate=1000L;
		String colorUnder="red";
		String colorOver="green";
		fromAddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.254.0"), 24, false);
		fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5060)});
		toddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.0.0"), 24, false);
		toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5061)});
		avpSet.addAvp(1234, "meter out 6 from 10.98.254.0/24 5060 to 10.98.0.0/24 5061 metering 1000 red green", false);
		octetString=new DiameterQosFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,null,meteringRate,colorUnder,colorOver,null,null);
		
		ourResult = Unpooled.buffer();
		octetString.encode(ourResult);
		
		ourData = new byte[ourResult.readableBytes()];
		ourResult.readBytes(ourData);
		
		theirData = elementParser.encodeAvpSet(avpSet);
		assertEquals(theirData.length,ourData.length+8);
		//removing the header
		theirRealData=new byte[theirData.length-8];
		System.arraycopy(theirData, 8, theirRealData, 0, theirRealData.length);
		
		assertArrayEquals(theirRealData, ourData);
		
		octetString=new DiameterQosFilterRuleImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 81);
		
		assertEquals(octetString.getAction(), action);
		assertEquals(octetString.getDirection(), direction);
		assertEquals(octetString.getProtocol(), protocol);
		assertEquals(octetString.getFrom(), fromAddress);
		assertNotNull(octetString.getFromPorts());
		assertEquals(octetString.getFromPorts().size(), 1);
		assertEquals(octetString.getFromPorts().get(0).getMin(), fromPorts.get(0).getMin());
		assertEquals(octetString.getFromPorts().get(0).getMax(), fromPorts.get(0).getMax());
		assertEquals(octetString.getTo(), toddress);
		assertNotNull(octetString.getFromPorts());
		assertEquals(octetString.getToPorts().size(), 1);
		assertEquals(octetString.getToPorts().get(0).getMin(), toPorts.get(0).getMin());
		assertEquals(octetString.getToPorts().get(0).getMax(), toPorts.get(0).getMax());
		assertNull(octetString.getDscpColor());
		assertEquals(octetString.getColorOver(),colorOver);
		assertEquals(octetString.getColorUnder(),colorUnder);
		assertEquals(octetString.getMeteringRate(),meteringRate);
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		action=DiameterQosAction.METER;
		direction=DiameterRuleDirection.IN;
		protocol=InternetProtocol.TCP;
		fromAddress=new DiameterRuleAddressImpl(false, true, false);
		fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(80)});
		toddress=new DiameterRuleAddressImpl(InetAddress.getByName("172.16.1.1"), null, false);
		toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(80)});
		meteringRate=null;
		colorUnder=null;
		colorOver=null;
		String dscpColor="red";
		avpSet.addAvp(1234, "meter in 6 from any 80 to 172.16.1.1 80 DSCP red", false);
		octetString=new DiameterQosFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,dscpColor,null,null,null,null,null);
		
		ourResult = Unpooled.buffer();
		octetString.encode(ourResult);
		
		ourData = new byte[ourResult.readableBytes()];
		ourResult.readBytes(ourData);
		
		theirData = elementParser.encodeAvpSet(avpSet);
		assertEquals(theirData.length,ourData.length+8);
		//removing the header
		theirRealData=new byte[theirData.length-8];
		System.arraycopy(theirData, 8, theirRealData, 0, theirRealData.length);
		
		assertArrayEquals(theirRealData, ourData);
		
		octetString=new DiameterQosFilterRuleImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 48);
		
		assertEquals(octetString.getAction(), action);
		assertEquals(octetString.getDirection(), direction);
		assertEquals(octetString.getProtocol(), protocol);
		assertEquals(octetString.getFrom(), fromAddress);
		assertNotNull(octetString.getFromPorts());
		assertEquals(octetString.getFromPorts().size(), 1);
		assertEquals(octetString.getFromPorts().get(0).getMin(), fromPorts.get(0).getMin());
		assertEquals(octetString.getFromPorts().get(0).getMax(), fromPorts.get(0).getMax());
		assertEquals(octetString.getTo(), toddress);
		assertNotNull(octetString.getFromPorts());
		assertEquals(octetString.getToPorts().size(), 1);
		assertEquals(octetString.getToPorts().get(0).getMin(), toPorts.get(0).getMin());
		assertEquals(octetString.getToPorts().get(0).getMax(), toPorts.get(0).getMax());
		assertEquals(octetString.getDscpColor(),dscpColor);
		assertNull(octetString.getColorOver());
		assertNull(octetString.getColorUnder());
		assertNull(octetString.getMeteringRate());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		action=DiameterQosAction.TAG;
		direction=DiameterRuleDirection.OUT;
		protocol=InternetProtocol.UDP;
		fromAddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.254.0"), 24, false);
		fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5061),new DiameterRulePortsImpl(5064)});
		toddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.0.0"), 24, false);
		toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(50000,60100),new DiameterRulePortsImpl(5061),new DiameterRulePortsImpl(5064)});
		avpSet.addAvp(1234, "tag out 17 from 10.98.254.0/24 5061,5064 to 10.98.0.0/24 50000-60100,5061,5064", false);
		octetString=new DiameterQosFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,null,null,null,null,null,null);
		
		ourResult = Unpooled.buffer();
		octetString.encode(ourResult);
		
		ourData = new byte[ourResult.readableBytes()];
		ourResult.readBytes(ourData);
		
		theirData = elementParser.encodeAvpSet(avpSet);
		assertEquals(theirData.length,ourData.length+8);
		//removing the header
		theirRealData=new byte[theirData.length-8];
		System.arraycopy(theirData, 8, theirRealData, 0, theirRealData.length);
		
		assertArrayEquals(theirRealData, ourData);
		
		octetString=new DiameterQosFilterRuleImpl();
		octetString.decode(Unpooled.wrappedBuffer("tag out 17 from 10.98.254.0/24 5061, 5064 to 10.98.0.0/24 50000-60100 ,5061 ,5064".getBytes()), 81);
		
		assertEquals(octetString.getAction(), action);
		assertEquals(octetString.getDirection(), direction);
		assertEquals(octetString.getProtocol(), protocol);
		assertEquals(octetString.getFrom(), fromAddress);
		assertNotNull(octetString.getFromPorts());
		assertEquals(octetString.getFromPorts().size(), 2);
		assertEquals(octetString.getFromPorts().get(0).getMin(), fromPorts.get(0).getMin());
		assertEquals(octetString.getFromPorts().get(0).getMax(), fromPorts.get(0).getMax());
		assertEquals(octetString.getFromPorts().get(1).getMin(), fromPorts.get(1).getMin());
		assertEquals(octetString.getFromPorts().get(1).getMax(), fromPorts.get(1).getMax());
		assertEquals(octetString.getTo(), toddress);
		assertNotNull(octetString.getFromPorts());
		assertEquals(octetString.getToPorts().size(), 3);
		assertEquals(octetString.getToPorts().get(0).getMin(), toPorts.get(0).getMin());
		assertEquals(octetString.getToPorts().get(0).getMax(), toPorts.get(0).getMax());
		assertEquals(octetString.getToPorts().get(1).getMin(), toPorts.get(1).getMin());
		assertEquals(octetString.getToPorts().get(1).getMax(), toPorts.get(1).getMax());
		assertEquals(octetString.getToPorts().get(2).getMin(), toPorts.get(2).getMin());
		assertEquals(octetString.getToPorts().get(2).getMax(), toPorts.get(2).getMax());
		assertNull(octetString.getDscpColor());
		assertNull(octetString.getColorOver());
		assertNull(octetString.getColorUnder());
		assertNull(octetString.getMeteringRate());			
	}
}
