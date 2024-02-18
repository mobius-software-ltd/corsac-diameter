package com.mobius.software.telco.protocols.diameter.impl.primitives;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.jdiameter.api.AvpSet;
import org.jdiameter.client.api.IMessage;
import org.jdiameter.client.impl.parser.ElementParser;
import org.jdiameter.client.impl.parser.MessageParser;
import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpAction;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleDirection;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIcmpType;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIpOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRulePorts;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpFlag;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpOption;
import com.mobius.software.telco.protocols.diameter.primitives.InternetProtocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class DiameterIpFilterRuleTest 
{
	@Test
	public void testIpFilterRuleCoding() throws IllegalArgumentException, UnknownHostException, InvalidAvpValueException
	{
		MessageParser messageParser = new MessageParser();
		ElementParser elementParser=new ElementParser();
		
		IMessage dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		AvpSet avpSet = dummyMessage.getAvps();
		
		DiameterIpAction action=DiameterIpAction.PERMIT;
		DiameterRuleDirection direction=DiameterRuleDirection.IN;
		InternetProtocol protocol=InternetProtocol.TCP;
		DiameterRuleAddressImpl fromAddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.254.0"), 24, false);
		List<DiameterRulePorts> fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5061)});
		DiameterRuleAddressImpl toddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.0.0"), 24, false);
		List<DiameterRulePorts> toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5060)});
		
		avpSet.addAvp(1234, "permit in 6 from 10.98.254.0/24 5061 to 10.98.0.0/24 5060", false);
		DiameterIpFilterRuleImpl octetString=new DiameterIpFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,null,null,null,null,null,null,null,null,null,null);
		
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
		
		octetString=new DiameterIpFilterRuleImpl();
		ByteBuf encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 57);
		
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
		assertNull(octetString.getOptions());
		assertNull(octetString.getIcmpTypes());
		assertNull(octetString.getIpOptions());
		assertNull(octetString.getNegativeIpOptions());
		assertNull(octetString.getTcpOptions());
		assertNull(octetString.getNegativeTcpOptions());
		assertNull(octetString.getTcpFlags());
		assertNull(octetString.getNegativeTcpFlags());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		action=DiameterIpAction.PERMIT;
		direction=DiameterRuleDirection.OUT;
		protocol=InternetProtocol.TCP;
		fromAddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.254.0"), 24, false);
		fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5060)});
		toddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.0.0"), 24, false);
		toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5061)});
		List<DiameterRuleOption> options=Arrays.asList(new DiameterRuleOption[] { DiameterRuleOption.FRAGMENT, DiameterRuleOption.SETUP});
		avpSet.addAvp(1234, "permit out 6 from 10.98.254.0/24 5060 to 10.98.0.0/24 5061 frag setup", false);
		octetString=new DiameterIpFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,options,null,null,null,null,null,null,null,null,null);
		
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
		
		octetString=new DiameterIpFilterRuleImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 69);
		
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
		assertNotNull(octetString.getOptions());
		assertEquals(octetString.getOptions().size(), 2);
		assertEquals(octetString.getOptions().get(0), DiameterRuleOption.FRAGMENT);
		assertEquals(octetString.getOptions().get(1), DiameterRuleOption.SETUP);
		assertNull(octetString.getIcmpTypes());
		assertNull(octetString.getIpOptions());
		assertNull(octetString.getNegativeIpOptions());
		assertNull(octetString.getTcpOptions());
		assertNull(octetString.getNegativeTcpOptions());
		assertNull(octetString.getTcpFlags());
		assertNull(octetString.getNegativeTcpFlags());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		action=DiameterIpAction.DENY;
		direction=DiameterRuleDirection.IN;
		protocol=InternetProtocol.TCP;
		fromAddress=new DiameterRuleAddressImpl(false, true, false);
		fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(80)});
		toddress=new DiameterRuleAddressImpl(InetAddress.getByName("172.16.1.1"), null, false);
		toPorts=Arrays.asList(new DiameterRulePorts[] { new DiameterRulePortsImpl(80)});
		options=Arrays.asList(new DiameterRuleOption[] { DiameterRuleOption.ESTABLISHED });
		List<DiameterRuleTcpOption> tcpOptions=Arrays.asList(new DiameterRuleTcpOption[] { DiameterRuleTcpOption.MSS, DiameterRuleTcpOption.SACK});
		List<DiameterRuleTcpOption> negativeTcpOptions=Arrays.asList(new DiameterRuleTcpOption[] { DiameterRuleTcpOption.CC});
		avpSet.addAvp(1234, "deny in 6 from any 80 to 172.16.1.1 80 established tcpoptions mss,sack,!cc", false);
		octetString=new DiameterIpFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,options,null,null,tcpOptions,negativeTcpOptions,null,null,null,null,null);
		
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
		
		octetString=new DiameterIpFilterRuleImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 74);
		
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
		assertNotNull(octetString.getOptions());
		assertEquals(octetString.getOptions().size(), 1);
		assertEquals(octetString.getOptions().get(0), DiameterRuleOption.ESTABLISHED);
		assertNull(octetString.getIcmpTypes());
		assertNull(octetString.getIpOptions());
		assertNull(octetString.getNegativeIpOptions());
		assertNotNull(octetString.getTcpOptions());
		assertEquals(octetString.getTcpOptions().size(), 2);
		assertEquals(octetString.getTcpOptions().get(0), DiameterRuleTcpOption.MSS);
		assertEquals(octetString.getTcpOptions().get(1), DiameterRuleTcpOption.SACK);
		assertNotNull(octetString.getNegativeTcpOptions());
		assertEquals(octetString.getNegativeTcpOptions().size(), 1);
		assertEquals(octetString.getNegativeTcpOptions().get(0), DiameterRuleTcpOption.CC);
		assertNull(octetString.getTcpFlags());
		assertNull(octetString.getNegativeTcpFlags());
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		action=DiameterIpAction.PERMIT;
		direction=DiameterRuleDirection.OUT;
		protocol=InternetProtocol.TCP;
		fromAddress=new DiameterRuleAddressImpl(InetAddress.getByName("172.16.1.1"), null, false);
		fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(80)});
		toddress=new DiameterRuleAddressImpl(false,true,false);
		toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(80)});
		options=Arrays.asList(new DiameterRuleOption[] { DiameterRuleOption.SETUP });
		tcpOptions=null;
		negativeTcpOptions=null;
		List<DiameterRuleTcpFlag> tcpFlags=Arrays.asList(new DiameterRuleTcpFlag[] { DiameterRuleTcpFlag.FIN, DiameterRuleTcpFlag.RST });
		List<DiameterRuleTcpFlag> negativeTcpFlags=Arrays.asList(new DiameterRuleTcpFlag[] { DiameterRuleTcpFlag.SYN, DiameterRuleTcpFlag.PSH });
		avpSet.addAvp(1234, "permit out 6 from 172.16.1.1 80 to any 80 setup tcpflags fin,rst,!syn,!psh", false);
		octetString=new DiameterIpFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,options,null,null,null,null,tcpFlags,negativeTcpFlags,null,null,null);
		
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
		
		octetString=new DiameterIpFilterRuleImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 74);
		
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
		assertNotNull(octetString.getOptions());
		assertEquals(octetString.getOptions().size(), 1);
		assertEquals(octetString.getOptions().get(0), DiameterRuleOption.SETUP);
		assertNull(octetString.getIcmpTypes());
		assertNull(octetString.getIpOptions());
		assertNull(octetString.getNegativeIpOptions());
		assertNull(octetString.getTcpOptions());
		assertNull(octetString.getNegativeTcpOptions());
		assertNotNull(octetString.getTcpFlags());
		assertEquals(octetString.getTcpFlags().size(), 2);
		assertEquals(octetString.getTcpFlags().get(0), DiameterRuleTcpFlag.FIN);
		assertEquals(octetString.getTcpFlags().get(1), DiameterRuleTcpFlag.RST);
		assertNotNull(octetString.getNegativeTcpFlags());
		assertEquals(octetString.getNegativeTcpFlags().size(), 2);
		assertEquals(octetString.getNegativeTcpFlags().get(0), DiameterRuleTcpFlag.SYN);
		assertEquals(octetString.getNegativeTcpFlags().get(1), DiameterRuleTcpFlag.PSH);
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		action=DiameterIpAction.PERMIT;
		direction=DiameterRuleDirection.IN;
		protocol=InternetProtocol.UDP;
		fromAddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.254.0"), 24, false);
		fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(50000,60100)});
		toddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.0.0"), 24, false);
		toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(50000,60100)});
		options=Arrays.asList(new DiameterRuleOption[] { DiameterRuleOption.ESTABLISHED });
		tcpOptions=null;
		negativeTcpOptions=null;
		tcpFlags=null;
		negativeTcpFlags=null;
		List<DiameterRuleIcmpType> icmpTypes=Arrays.asList(new DiameterRuleIcmpType[] { DiameterRuleIcmpType.TIMESTAMP_REQUEST,DiameterRuleIcmpType.ADDRESS_MASK_REPLY ,DiameterRuleIcmpType.REDIRECT, DiameterRuleIcmpType.IP_HEADER_BAD });
		avpSet.addAvp(1234, "permit in 17 from 10.98.254.0/24 50000-60100 to 10.98.0.0/24 50000-60100 established icmptypes 13,18,5,12", false);
		octetString=new DiameterIpFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,options,null,null,null,null,null,null,icmpTypes,null,null);
		
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
		
		octetString=new DiameterIpFilterRuleImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		byte[] data = "permit in 17 from 10.98.254.0/24 50000-60100 to 10.98.0.0/24 50000-60100 icmptypes timestamp request,address mask reply ,5, 12 established".getBytes();		
		octetString.decode(Unpooled.wrappedBuffer(data), 138);
		
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
		assertNotNull(octetString.getOptions());
		assertEquals(octetString.getOptions().size(), 1);
		assertEquals(octetString.getOptions().get(0), DiameterRuleOption.ESTABLISHED);
		assertNull(octetString.getIpOptions());
		assertNull(octetString.getNegativeIpOptions());
		assertNull(octetString.getTcpOptions());
		assertNull(octetString.getNegativeTcpOptions());
		assertNull(octetString.getTcpFlags());
		assertNull(octetString.getNegativeTcpFlags());		
		assertNotNull(octetString.getIcmpTypes());
		assertEquals(octetString.getIcmpTypes().size(), 4);
		assertEquals(octetString.getIcmpTypes().get(0), icmpTypes.get(0));
		assertEquals(octetString.getIcmpTypes().get(1), icmpTypes.get(1));
		assertEquals(octetString.getIcmpTypes().get(2), icmpTypes.get(2));
		assertEquals(octetString.getIcmpTypes().get(3), icmpTypes.get(3));
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		action=DiameterIpAction.DENY;
		direction=DiameterRuleDirection.OUT;
		protocol=InternetProtocol.UDP;
		fromAddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.254.0"), 24, false);
		fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(50000,60100)});
		toddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.0.0"), 24, false);
		toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(50000,60100)});
		options=null;
		List<DiameterRuleIpOption> ipOptions=Arrays.asList(new DiameterRuleIpOption[] { DiameterRuleIpOption.SSSRR});
		List<DiameterRuleIpOption> negativeIpOptions=Arrays.asList(new DiameterRuleIpOption[] { DiameterRuleIpOption.RR});
		tcpOptions=null;
		negativeTcpOptions=null;
		tcpFlags=null;
		negativeTcpFlags=null;
		icmpTypes=null;
		avpSet.addAvp(1234, "deny out 17 from 10.98.254.0/24 50000-60100 to 10.98.0.0/24 50000-60100 ipoptions ssrr,!rr", false);
		octetString=new DiameterIpFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,null,ipOptions,negativeIpOptions,null,null,null,null,null,null,null);
		
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
		
		octetString=new DiameterIpFilterRuleImpl();
		encodedValue = Unpooled.wrappedBuffer(ourData);
		octetString.decode(encodedValue, 90);
		
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
		assertNull(octetString.getOptions());
		assertNotNull(octetString.getIpOptions());
		assertEquals(octetString.getIpOptions().size(), 1);
		assertEquals(octetString.getIpOptions().get(0), DiameterRuleIpOption.SSSRR);
		assertNotNull(octetString.getNegativeIpOptions());
		assertEquals(octetString.getNegativeIpOptions().size(), 1);
		assertEquals(octetString.getNegativeIpOptions().get(0), DiameterRuleIpOption.RR);
		assertNull(octetString.getTcpOptions());
		assertNull(octetString.getNegativeTcpOptions());
		assertNull(octetString.getTcpFlags());
		assertNull(octetString.getNegativeTcpFlags());		
		assertNull(octetString.getIcmpTypes());		
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		action=DiameterIpAction.PERMIT;
		direction=DiameterRuleDirection.IN;
		protocol=InternetProtocol.UDP;
		fromAddress=new DiameterRuleAddressImpl(false,true,true);
		fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5061),new DiameterRulePortsImpl(5064)});
		toddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.0.0"), 24, false);
		toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(50000,60100),new DiameterRulePortsImpl(5061),new DiameterRulePortsImpl(5064)});
		options=null;
		ipOptions=null;
		negativeIpOptions=null;
		tcpOptions=null;
		negativeTcpOptions=null;
		tcpFlags=null;
		negativeTcpFlags=null;
		icmpTypes=null;
		avpSet.addAvp(1234, "permit in 17 from !any 5061,5064 to 10.98.0.0/24 50000-60100,5061,5064", false);
		octetString=new DiameterIpFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,null,ipOptions,negativeIpOptions,null,null,null,null,null,null,null);
		
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
		
		octetString=new DiameterIpFilterRuleImpl();
		octetString.decode(Unpooled.wrappedBuffer("permit in 17 from !any 5061, 5064 to 10.98.0.0/24 50000-60100 ,5061, 5064".getBytes()), 73);
		
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
		assertNull(octetString.getOptions());
		assertNull(octetString.getIpOptions());
		assertNull(octetString.getNegativeIpOptions());
		assertNull(octetString.getTcpOptions());
		assertNull(octetString.getNegativeTcpOptions());
		assertNull(octetString.getTcpFlags());
		assertNull(octetString.getNegativeTcpFlags());		
		assertNull(octetString.getIcmpTypes());		
		
		dummyMessage = messageParser.createEmptyMessage(-1,-1L);
		avpSet = dummyMessage.getAvps();
		
		action=DiameterIpAction.PERMIT;
		direction=DiameterRuleDirection.OUT;
		protocol=InternetProtocol.UDP;
		fromAddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.254.0"), 24, false);
		fromPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(5061),new DiameterRulePortsImpl(5064)});
		toddress=new DiameterRuleAddressImpl(InetAddress.getByName("10.98.0.0"), 24, false);
		toPorts=Arrays.asList(new DiameterRulePortsImpl[] { new DiameterRulePortsImpl(50000,60100),new DiameterRulePortsImpl(5061),new DiameterRulePortsImpl(5064)});
		options=null;
		ipOptions=null;
		negativeIpOptions=null;
		tcpOptions=null;
		negativeTcpOptions=null;
		tcpFlags=null;
		negativeTcpFlags=null;
		icmpTypes=null;
		avpSet.addAvp(1234, "permit out 17 from 10.98.254.0/24 5061,5064 to 10.98.0.0/24 50000-60100,5061,5064", false);
		octetString=new DiameterIpFilterRuleImpl(action,direction,protocol,fromAddress,fromPorts,toddress,toPorts,null,ipOptions,negativeIpOptions,null,null,null,null,null,null,null);
		
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
		
		octetString=new DiameterIpFilterRuleImpl();
		octetString.decode(Unpooled.wrappedBuffer("permit out 17 from 10.98.254.0/24 5061, 5064 to 10.98.0.0/24 50000-60100 ,5061 ,5064".getBytes()), 84);
		
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
		assertNull(octetString.getOptions());
		assertNull(octetString.getIpOptions());
		assertNull(octetString.getNegativeIpOptions());
		assertNull(octetString.getTcpOptions());
		assertNull(octetString.getNegativeTcpOptions());
		assertNull(octetString.getTcpFlags());
		assertNull(octetString.getNegativeTcpFlags());		
		assertNull(octetString.getIcmpTypes());		
	}
}
