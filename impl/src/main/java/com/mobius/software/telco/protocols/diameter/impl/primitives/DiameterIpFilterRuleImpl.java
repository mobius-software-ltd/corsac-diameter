package com.mobius.software.telco.protocols.diameter.impl.primitives;
/*
 * Mobius Software LTD, Open Source Cloud Communications
 * Copyright 2023, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpAction;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterIpFilterRule;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleAddress;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleDirection;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIcmpType;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleIpOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRulePorts;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpFlag;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleTcpOption;
import com.mobius.software.telco.protocols.diameter.primitives.InternetProtocol;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class DiameterIpFilterRuleImpl extends DiameterAsciiStringImpl implements DiameterIpFilterRule
{
	private DiameterIpAction action;
	private DiameterRuleDirection direction;
	private InternetProtocol protocol;
	private DiameterRuleAddress from;
	private List<DiameterRulePorts> fromPorts;
	private DiameterRuleAddress to;
	private List<DiameterRulePorts> toPorts;
	
	private List<DiameterRuleOption> options;
	private List<DiameterRuleIpOption> ipOptions;
	private List<DiameterRuleIpOption> negativeIpOptions;
	private List<DiameterRuleTcpOption> tcpOptions;
	private List<DiameterRuleTcpOption> negativeTcpOptions;
	private List<DiameterRuleTcpFlag> tcpFlags;
	private List<DiameterRuleTcpFlag> negativeTcpFlags;
	private List<DiameterRuleIcmpType> icmpTypes;
	
	//required for parser
	protected DiameterIpFilterRuleImpl() 
	{
		super();
	}
		
	protected DiameterIpFilterRuleImpl(Integer minLength,Integer maxLength) 
	{
		super(minLength,maxLength);		
	}
		
	public DiameterIpFilterRuleImpl(String rule,Integer minLength,Integer maxLength) throws InvalidAvpValueException 
	{
		super(rule,minLength,maxLength);	
		parseRule();
	}

	public DiameterIpFilterRuleImpl(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes,Integer minLength,Integer maxLength) throws InvalidAvpValueException 
	{
		super(minLength,maxLength);
		value=buildRule(action,direction,protocol,from,fromPorts,to,toPorts,options,ipOptions,negativeIpOptions,tcpOptions,negativeTcpOptions,tcpFlags,negativeTcpFlags,icmpTypes);
		this.action=action;
		this.direction=direction;
		this.protocol=protocol;
		this.from=from;
		this.fromPorts=fromPorts;
		this.to=to;
		this.toPorts=toPorts;
		this.options=options;
		this.ipOptions=ipOptions;
		this.negativeIpOptions=negativeIpOptions;
		this.tcpOptions=tcpOptions;
		this.negativeTcpOptions=negativeTcpOptions;
		this.tcpFlags=tcpFlags;
		this.negativeTcpFlags=negativeTcpFlags;
		this.icmpTypes=icmpTypes;
	}

	public String getRule()
	{
		return this.getString();
	}
	
	public DiameterIpAction getAction() 
	{
		return action;
	}

	public DiameterRuleDirection getDirection() 
	{
		return direction;
	}

	public InternetProtocol getProtocol() 
	{
		return protocol;
	}

	public DiameterRuleAddress getFrom() 
	{
		return from;
	}

	public List<DiameterRulePorts> getFromPorts() 
	{
		return fromPorts;
	}

	public DiameterRuleAddress getTo() 
	{
		return to;
	}

	public List<DiameterRulePorts> getToPorts() 
	{
		return toPorts;
	}

	public List<DiameterRuleOption> getOptions() 
	{
		return options;
	}

	public List<DiameterRuleIpOption> getIpOptions() 
	{
		return ipOptions;
	}

	public List<DiameterRuleIpOption> getNegativeIpOptions() 
	{
		return negativeIpOptions;
	}

	public List<DiameterRuleTcpOption> getTcpOptions() 
	{
		return tcpOptions;
	}

	public List<DiameterRuleTcpOption> getNegativeTcpOptions() 
	{
		return negativeTcpOptions;
	}

	public List<DiameterRuleTcpFlag> getTcpFlags() 
	{
		return tcpFlags;
	}

	public List<DiameterRuleTcpFlag> getNegativeTcpFlags() 
	{
		return negativeTcpFlags;
	}

	public List<DiameterRuleIcmpType> getIcmpTypes() 
	{
		return icmpTypes;
	}

	@DiameterDecode
	public DiameterException decode(ByteBuf buffer,Integer length) 
	{
		super.decode(buffer, length);
		if(getString()!=null)
		{
			try
			{
				parseRule();
			}
			catch(InvalidAvpValueException ex)
			{
				return ex;
			}
		}
		
		return null;
	}
		
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getRule() == null) ? 0 : getRule().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
			
		if (getClass() != obj.getClass())
			return false;
			
		DiameterIpFilterRuleImpl other = (DiameterIpFilterRuleImpl) obj;
		if (getRule() == null) 
		{
			if (other.getRule() != null)
				return false;
		} 
		else if (!getRule().equals(other.getRule()))
			return false;
			
		return true;
	}
	
	private void parseRule() throws InvalidAvpValueException
	{
		String rule=getString();
		
		//trimming spaces near commas
		rule=rule.replace(" ,", ",");
		rule=rule.replace(", ", ",");
		
		//replacing the icmp types if any with their numeric values
		for(DiameterRuleIcmpType currType:DiameterRuleIcmpType.values())
			rule = rule.replace(currType.getValue(), String.valueOf(currType.getCode()));
		
		String[] segments = rule.split(" ");
		int errorOffset = 0;
		
		if(segments.length<8)
			throw new InvalidAvpValueException("Invalid rule " + rule + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
		
		action=DiameterIpAction.fromString(segments[0]);
		if(action==null)
			throw new InvalidAvpValueException("Invalid action " + segments[0]+ rule + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
		
		errorOffset += segments[0].length()+1;
		
		direction=DiameterRuleDirection.fromString(segments[1]);
		if(direction==null)
			throw new InvalidAvpValueException("Invalid dir " + segments[1]+ rule + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
		
		errorOffset += segments[1].length()+1;
		
		protocol=InternetProtocol.fromString(segments[2]);
		if(protocol==null)
			throw new InvalidAvpValueException("Invalid proto " + segments[2]+ rule + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
		
		errorOffset += segments[2].length()+1;
		
		if(!segments[3].equalsIgnoreCase("from"))
			throw new InvalidAvpValueException("Invalid word, expecting from " + segments[3]+ rule + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
			
		errorOffset += segments[3].length()+1;
		
		from=new DiameterRuleAddressImpl(this, segments[4]);
		errorOffset += segments[4].length()+1;
		
		Integer nextIndex=5;
		if(!segments[5].equals("to"))
		{
			String[] portSegments=segments[5].toString().split(",");
			nextIndex++;
			
			fromPorts=new ArrayList<DiameterRulePorts>();
			for(int i=0;i<portSegments.length;i++)
			{
				DiameterRulePortsImpl currPorts=new DiameterRulePortsImpl(this,portSegments[i]);
				fromPorts.add(currPorts);
			}
		}
		
		errorOffset += segments[5].length()+1;
		
		if(!segments[nextIndex].equalsIgnoreCase("to"))
			throw new InvalidAvpValueException("Invalid word, expecting from " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
			
		errorOffset += segments[nextIndex++].length()+1;
		
		to=new DiameterRuleAddressImpl(this, segments[nextIndex]);
		errorOffset += segments[nextIndex++].length()+1;
		
		if(nextIndex==segments.length)
			return;
		
		DiameterRuleOption option=DiameterRuleOption.fromString(segments[nextIndex]);
		if(option==null)
		{
			String[] portSegments=segments[nextIndex].toString().split(",");
			errorOffset += segments[nextIndex].length()+1;
			nextIndex++;
			
			toPorts=new ArrayList<DiameterRulePorts>();
			for(int i=0;i<portSegments.length;i++)
			{
				DiameterRulePortsImpl currPorts=new DiameterRulePortsImpl(this,portSegments[i]);
				toPorts.add(currPorts);
			}
		}
		
		while(nextIndex<segments.length)
		{
			option=DiameterRuleOption.fromString(segments[nextIndex]);
			if(option==null)
				throw new InvalidAvpValueException("Invalid option " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));

			errorOffset += segments[nextIndex].length()+1;
			nextIndex++;
			
			switch(option)
			{
				case IP_OPTS:
					if(nextIndex==segments.length)
						throw new InvalidAvpValueException("Invalid option " + segments[nextIndex-1] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
	
					String[] ipOptionSegments=segments[nextIndex].split(",");
					for(int i=0;i<ipOptionSegments.length;i++)
					{
						Boolean isNegative=false;
						if(ipOptionSegments[i].startsWith("!"))
						{
							isNegative=true;
							ipOptionSegments[i]=ipOptionSegments[i].substring(1);
						}
						
						DiameterRuleIpOption ipOption=DiameterRuleIpOption.fromString(ipOptionSegments[i]);
						if(ipOption==null)
							throw new InvalidAvpValueException("Invalid ip option " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
	
						if(isNegative)
						{
							if(negativeIpOptions==null)
								negativeIpOptions=new ArrayList<DiameterRuleIpOption>();
							
							negativeIpOptions.add(ipOption);
						}
						else
						{
							if(ipOptions==null)
								ipOptions=new ArrayList<DiameterRuleIpOption>();
							
							ipOptions.add(ipOption);
						}
					}
					
					errorOffset += segments[nextIndex].length()+1;
					nextIndex++;
					break;
				case TCP_OPTS:
					if(nextIndex==segments.length)
						throw new InvalidAvpValueException("Invalid option " + segments[nextIndex-1] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
	
					String[] tcpOptionSegments=segments[nextIndex].split(",");
					for(int i=0;i<tcpOptionSegments.length;i++)
					{
						Boolean isNegative=false;
						if(tcpOptionSegments[i].startsWith("!"))
						{
							isNegative=true;
							tcpOptionSegments[i]=tcpOptionSegments[i].substring(1);
						}
						
						DiameterRuleTcpOption tcpOption=DiameterRuleTcpOption.fromString(tcpOptionSegments[i]);
						if(tcpOption==null)
							throw new InvalidAvpValueException("Invalid tcp option " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
	
						if(isNegative)
						{
							if(negativeTcpOptions==null)
								negativeTcpOptions=new ArrayList<DiameterRuleTcpOption>();
							
							negativeTcpOptions.add(tcpOption);
						}
						else
						{
							if(tcpOptions==null)
								tcpOptions=new ArrayList<DiameterRuleTcpOption>();
							
							tcpOptions.add(tcpOption);
						}
					}
					
					errorOffset += segments[nextIndex].length()+1;
					nextIndex++;
					break;
				case TCP_FLAGS:
					if(nextIndex==segments.length)
						throw new InvalidAvpValueException("Invalid option " + segments[nextIndex-1] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
	
					String[] tcpFlagSegments=segments[nextIndex].split(",");
					for(int i=0;i<tcpFlagSegments.length;i++)
					{
						Boolean isNegative=false;
						if(tcpFlagSegments[i].startsWith("!"))
						{
							isNegative=true;
							tcpFlagSegments[i]=tcpFlagSegments[i].substring(1);
						}
						
						DiameterRuleTcpFlag tcpFlag=DiameterRuleTcpFlag.fromString(tcpFlagSegments[i]);
						if(tcpFlag==null)
							throw new InvalidAvpValueException("Invalid tcp flags " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
	
						if(isNegative)
						{
							if(negativeTcpFlags==null)
								negativeTcpFlags=new ArrayList<DiameterRuleTcpFlag>();
							
							negativeTcpFlags.add(tcpFlag);
						}
						else
						{
							if(tcpFlags==null)
								tcpFlags=new ArrayList<DiameterRuleTcpFlag>();
							
							tcpFlags.add(tcpFlag);
						}
					}
					
					errorOffset += segments[nextIndex].length()+1;
					nextIndex++;
					break;
				case ICMP_TYPES:
					if(nextIndex==segments.length)
						throw new InvalidAvpValueException("Invalid option " + segments[nextIndex-1] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
	
					String[] icmpTypeSegments=segments[nextIndex].split(",");
					for(int i=0;i<icmpTypeSegments.length;i++)
					{
						Integer icmpTypeValue = null;
						try
						{
							icmpTypeValue = Integer.parseInt(icmpTypeSegments[i]);
						}
						catch(NumberFormatException ex)
						{
							throw new InvalidAvpValueException("Invalid icmp types " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));							
						}
						
						DiameterRuleIcmpType icmpType=DiameterRuleIcmpType.fromInt(icmpTypeValue);
						if(icmpType==null)
							throw new InvalidAvpValueException("Invalid icmp types " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
	
						if(icmpTypes==null)
							icmpTypes=new ArrayList<DiameterRuleIcmpType>();
							
						icmpTypes.add(icmpType);
					}
					
					errorOffset += segments[nextIndex].length()+1;
					nextIndex++;
					break;
				default:
					if(options==null)
						options=new ArrayList<DiameterRuleOption>();
					
					options.add(option);
					break;
			}
		}
	}
	
	public String buildRule(DiameterIpAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,List<DiameterRuleOption> options,List<DiameterRuleIpOption> ipOptions,List<DiameterRuleIpOption> negativeIpOptions,List<DiameterRuleTcpOption> tcpOptions,List<DiameterRuleTcpOption> negativeTcpOptions,List<DiameterRuleTcpFlag> tcpFlags,List<DiameterRuleTcpFlag> negativeTcpFlags,List<DiameterRuleIcmpType> icmpTypes) throws InvalidAvpValueException
	{
		if(action==null)
			throw new InvalidAvpValueException("action can not be null", Arrays.asList(new DiameterAvp[] { this }));
		
		if(direction==null)
			throw new InvalidAvpValueException("direction can not be null", Arrays.asList(new DiameterAvp[] { this }));
		
		if(protocol==null)
			throw new InvalidAvpValueException("protocol can not be null", Arrays.asList(new DiameterAvp[] { this }));
		
		if(from==null)
			throw new InvalidAvpValueException("src can not be null", Arrays.asList(new DiameterAvp[] { this }));
		
		if(to==null)
			throw new InvalidAvpValueException("dst can not be null", Arrays.asList(new DiameterAvp[] { this }));
		
		if(options!=null && options.size()>0)
		{
			for(int i=0;i<options.size();i++)
			{
				if(options.get(i)==DiameterRuleOption.IP_OPTS || options.get(i)==DiameterRuleOption.TCP_OPTS || options.get(i)==DiameterRuleOption.TCP_FLAGS || options.get(i)==DiameterRuleOption.ICMP_TYPES)
					throw new InvalidAvpValueException("illegal option " + options.get(i), Arrays.asList(new DiameterAvp[] { this }));				
			}
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append(action.getValue());
		sb.append(" ");
		sb.append(direction.getValue());
		sb.append(" ");
		sb.append(protocol.getValue());
		sb.append(" ");
		sb.append("from");
		sb.append(" ");
		sb.append(from.getAddressAsString());
		sb.append(" ");
		
		if(fromPorts!=null && fromPorts.size()>0)
		{
			sb.append(fromPorts.get(0).getPortsAsString());
			
			for(int i=1;i<fromPorts.size();i++)
			{
				sb.append(",");
				sb.append(fromPorts.get(i).getPortsAsString());					
			}
			
			sb.append(" ");			
		}
		
		sb.append("to");
		sb.append(" ");
		sb.append(to.getAddressAsString());
		
		if(toPorts!=null && toPorts.size()>0)
		{
			sb.append(" ");
			sb.append(toPorts.get(0).getPortsAsString());
			
			for(int i=1;i<toPorts.size();i++)
			{
				sb.append(",");
				sb.append(toPorts.get(i).getPortsAsString());					
			}
		}
		
		if(options!=null && options.size()>0)
		{
			for(int i=0;i<options.size();i++)
			{
				sb.append(" ");
				sb.append(options.get(i).getValue());											
			}
		}

		if(ipOptions!=null && ipOptions.size()>0 || negativeIpOptions!=null && negativeIpOptions.size()>0)
		{
			sb.append(" ");
			sb.append(DiameterRuleOption.IP_OPTS.getValue());
			sb.append(" ");
			if(ipOptions!=null && ipOptions.size()>0)
			{
				sb.append(ipOptions.get(0).getValue());
				
				for(int i=1;i<ipOptions.size();i++)
				{
					sb.append(",");
					sb.append(ipOptions.get(i).getValue());											
				}
			}
			
			if(negativeIpOptions!=null && negativeIpOptions.size()>0)
			{
				if(ipOptions!=null && ipOptions.size()>0)
					sb.append(",");
				
				sb.append("!").append(negativeIpOptions.get(0).getValue());
				
				for(int i=1;i<negativeIpOptions.size();i++)
				{
					sb.append(",");
					sb.append("!").append(negativeIpOptions.get(i).getValue());											
				}
			}
		}
		
		if(tcpOptions!=null && tcpOptions.size()>0 || negativeTcpOptions!=null && negativeTcpOptions.size()>0)
		{
			sb.append(" ");
			sb.append(DiameterRuleOption.TCP_OPTS.getValue());
			sb.append(" ");
			if(tcpOptions!=null && tcpOptions.size()>0)
			{
				sb.append(tcpOptions.get(0).getValue());
				
				for(int i=1;i<tcpOptions.size();i++)
				{
					sb.append(",");
					sb.append(tcpOptions.get(i).getValue());											
				}
			}
			
			if(negativeTcpOptions!=null && negativeTcpOptions.size()>0)
			{
				if(negativeTcpOptions!=null && negativeTcpOptions.size()>0)
					sb.append(",");
				
				sb.append("!").append(negativeTcpOptions.get(0).getValue());
				
				for(int i=1;i<negativeTcpOptions.size();i++)
				{
					sb.append(",");
					sb.append("!").append(negativeTcpOptions.get(i).getValue());											
				}
			}
		}
		
		if(tcpFlags!=null && tcpFlags.size()>0 || negativeTcpFlags!=null && negativeTcpFlags.size()>0)
		{
			sb.append(" ");
			sb.append(DiameterRuleOption.TCP_FLAGS.getValue());
			sb.append(" ");
			if(tcpFlags!=null && tcpFlags.size()>0)
			{
				sb.append(tcpFlags.get(0).getValue());
				
				for(int i=1;i<tcpFlags.size();i++)
				{
					sb.append(",");
					sb.append(tcpFlags.get(i).getValue());											
				}
			}
			
			if(negativeTcpFlags!=null && negativeTcpFlags.size()>0)
			{
				if(negativeTcpFlags!=null && negativeTcpFlags.size()>0)
					sb.append(",");
				
				sb.append("!").append(negativeTcpFlags.get(0).getValue());
				
				for(int i=1;i<negativeTcpFlags.size();i++)
				{
					sb.append(",");
					sb.append("!").append(negativeTcpFlags.get(i).getValue());											
				}
			}
		}
		
		if(icmpTypes!=null && icmpTypes.size()>0)
		{
			sb.append(" ");
			sb.append(DiameterRuleOption.ICMP_TYPES.getValue());
			sb.append(" ");
			if(icmpTypes!=null && icmpTypes.size()>0)
			{
				sb.append(icmpTypes.get(0).getCode());
				
				for(int i=1;i<icmpTypes.size();i++)
				{
					sb.append(",");
					sb.append(icmpTypes.get(i).getCode());											
				}
			}
		}

		return sb.toString();
	}
}