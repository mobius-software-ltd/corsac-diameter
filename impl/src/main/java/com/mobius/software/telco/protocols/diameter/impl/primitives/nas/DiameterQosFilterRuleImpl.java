package com.mobius.software.telco.protocols.diameter.impl.primitives.nas;
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
import com.mobius.software.telco.protocols.diameter.annotations.DiameterPrint;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterAsciiStringImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterRuleAddressImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.DiameterRulePortsImpl;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterQosAction;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleAddress;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleDirection;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRuleOption;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterRulePorts;
import com.mobius.software.telco.protocols.diameter.primitives.InternetProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.nas.DiameterQosFilterRule;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class DiameterQosFilterRuleImpl extends DiameterAsciiStringImpl implements DiameterQosFilterRule
{
	private DiameterQosAction action;
	private DiameterRuleDirection direction;
	private InternetProtocol protocol;
	private DiameterRuleAddress from;
	private List<DiameterRulePorts> fromPorts;
	private DiameterRuleAddress to;
	private List<DiameterRulePorts> toPorts;
	
	private String dscpColor;
	private Long meteringRate;
	private String colorUnder;
	private String colorOver;
	
	//required for parser
	public DiameterQosFilterRuleImpl() 
	{
		super();
	}
		
	protected DiameterQosFilterRuleImpl(Integer minLength,Integer maxLength) 
	{
		super(minLength,maxLength);		
	}
		
	public DiameterQosFilterRuleImpl(String rule,Integer minLength,Integer maxLength) throws InvalidAvpValueException 
	{
		super(rule,minLength,maxLength);	
		parseRule();
	}

	public DiameterQosFilterRuleImpl(DiameterQosAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,String dscpColor,Long meteringRate,String colorUnder,String colorOver,Integer minLength,Integer maxLength) throws InvalidAvpValueException 
	{
		super(buildRule(action,direction,protocol,from,fromPorts,to,toPorts,dscpColor,meteringRate,colorUnder,colorOver), minLength,maxLength);
		this.action=action;
		this.direction=direction;
		this.protocol=protocol;
		this.from=from;
		this.fromPorts=fromPorts;
		this.to=to;
		this.toPorts=toPorts;
		this.dscpColor=dscpColor;
		this.meteringRate=meteringRate;
		this.colorUnder=colorUnder;
		this.colorOver=colorOver;
	}

	public String getRule()
	{
		return this.getString();
	}
	
	public DiameterQosAction getAction() 
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

	public String getDscpColor() 
	{
		return dscpColor;
	}

	public Long getMeteringRate() 
	{
		return meteringRate;
	}

	public String getColorUnder() 
	{
		return colorUnder;
	}

	public String getColorOver() 
	{
		return colorOver;
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
	
	@DiameterPrint
	public void print(StringBuilder sb) 
	{
		String rule=getRule();
		if(rule==null)
			DiameterParser.printMesage(sb, "");
		else			
			DiameterParser.printMesage(sb, rule);		 		
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
			
		DiameterQosFilterRuleImpl other = (DiameterQosFilterRuleImpl) obj;
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
		String rule=getRule();
		
		//lets first remove spaces near commans
		rule=rule.replace(" ,", ",");
		rule=rule.replace(", ", ",");
				
		String[] segments = rule.split(" ");
		int errorOffset = 0;
		
		if(segments.length<8)
			throw new InvalidAvpValueException("Invalid rule " + rule + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
		
		action=DiameterQosAction.fromString(segments[0]);
		if(action==null)
			throw new InvalidAvpValueException("Invalid action " + segments[0] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
		
		errorOffset += segments[0].length()+1;
		
		direction=DiameterRuleDirection.fromString(segments[1]);
		if(direction==null)
			throw new InvalidAvpValueException("Invalid dir " + segments[1] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
		
		errorOffset += segments[1].length()+1;
		
		protocol=InternetProtocol.fromString(segments[2]);
		if(protocol==null)
			throw new InvalidAvpValueException("Invalid proto " + segments[2] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
		
		errorOffset += segments[2].length()+1;
		
		if(!segments[3].equalsIgnoreCase("from"))
			throw new InvalidAvpValueException("Invalid word, expecting from " + segments[3] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
			
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
			switch(segments[nextIndex])
			{
				case "DSCP":
					if(nextIndex==segments.length-1)
						throw new InvalidAvpValueException("Invalid option " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
	
					errorOffset += segments[nextIndex].length()+1;
					nextIndex++;
					
					dscpColor=segments[nextIndex];
					errorOffset += segments[nextIndex].length()+1;
					nextIndex++;
					break;
				case "metering":
					if(nextIndex>=segments.length-3)
						throw new InvalidAvpValueException("Invalid option " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
	
					errorOffset += segments[nextIndex].length()+1;
					nextIndex++;
					
					try
					{
						meteringRate=Long.parseLong(segments[nextIndex]);
					}
					catch(NumberFormatException ex)
					{
						throw new InvalidAvpValueException("Invalid metering rate " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));						
					}
					
					errorOffset += segments[nextIndex].length()+1;
					nextIndex++;
					
					colorUnder = segments[nextIndex];
					errorOffset += segments[nextIndex].length()+1;
					nextIndex++;
					
					colorOver = segments[nextIndex];
					errorOffset += segments[nextIndex].length()+1;
					nextIndex++;					
					break;
				default:
					throw new InvalidAvpValueException("Invalid option " + segments[nextIndex] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));					
			}
		}
	}
	
	public static String buildRule(DiameterQosAction action,DiameterRuleDirection direction,InternetProtocol protocol,DiameterRuleAddress from,List<DiameterRulePorts> fromPorts,DiameterRuleAddress to,List<DiameterRulePorts> toPorts,String dscpColor,Long meteringRate,String colorUnder,String colorOver) throws InvalidAvpValueException
	{
		if(action==null)
			throw new InvalidAvpValueException("action can not be null", Arrays.asList(new DiameterAvp[] { }));
		
		if(direction==null)
			throw new InvalidAvpValueException("direction can not be null", Arrays.asList(new DiameterAvp[] { }));
		
		if(protocol==null)
			throw new InvalidAvpValueException("protocol can not be null", Arrays.asList(new DiameterAvp[] { }));
		
		if(from==null)
			throw new InvalidAvpValueException("src can not be null", Arrays.asList(new DiameterAvp[] { }));
		
		if(to==null)
			throw new InvalidAvpValueException("dst can not be null", Arrays.asList(new DiameterAvp[] { }));
		
		Integer meterOptions=0;
		if(meteringRate!=null)
			meterOptions++;
		
		if(colorUnder!=null)
			meterOptions++;
		
		if(colorOver!=null)
			meterOptions++;
		
		if(meterOptions>0 && meterOptions!=3)
			throw new InvalidAvpValueException("metering requires all parameters set: rate,color under and color over", Arrays.asList(new DiameterAvp[] { }));
		
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
		
		if(dscpColor!=null)
		{
			sb.append(" ");		
			sb.append("DSCP");
			sb.append(" ");
			sb.append(dscpColor);
		}

		if(meteringRate!=null)
		{
			sb.append(" ");
			sb.append("metering");
			sb.append(" ");
			sb.append(meteringRate);
			sb.append(" ");
			sb.append(colorUnder);
			sb.append(" ");
			sb.append(colorOver);
		}

		return sb.toString();
	}
}