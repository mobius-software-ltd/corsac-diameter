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

import java.util.Arrays;

import com.mobius.software.telco.protocols.diameter.annotations.DiameterDecode;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.exceptions.InvalidAvpValueException;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterAvp;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterProtocol;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterTransport;
import com.mobius.software.telco.protocols.diameter.primitives.DiameterUri;

import io.netty.buffer.ByteBuf;
/**
*
* @author yulian oifa
*
*/
public class DiameterUriImpl extends DiameterAsciiStringImpl implements DiameterUri
{
	private String host;
	private Integer port;
	private Boolean isSecure;
	private DiameterTransport transport;
	private DiameterProtocol protocol;
	
	//required for parser
	protected DiameterUriImpl() 
	{
		super();
	}
		
	protected DiameterUriImpl(Integer minLength,Integer maxLength) 
	{
		super(minLength,maxLength);		
	}
		
	public DiameterUriImpl(String uri,Integer minLength,Integer maxLength) throws InvalidAvpValueException 
	{
		super(uri,minLength,maxLength);	
		parseUri();
	}
	
	public DiameterUriImpl(String host,Integer port,Boolean isSecure,DiameterTransport transport, DiameterProtocol protocol,Integer minLength,Integer maxLength)
	{
		super(buildUri(host,port,isSecure,transport, protocol),minLength,maxLength);
		this.host=host;
		this.port=port;
		this.isSecure=isSecure;
		this.transport=transport;
		this.protocol=protocol;
	}
	
	public String getUri() 
	{
		return getString();
	}

	public String getHost() 
	{
		return host;
	}

	public Integer getPort() 
	{
		return port;
	}

	public Boolean getIsSecure() 
	{
		return isSecure;
	}

	public DiameterTransport getTransport() 
	{
		return transport;
	}

	public DiameterProtocol getProtocol() 
	{
		return protocol;
	}

	@DiameterDecode
	public DiameterException decode(ByteBuf buffer,Integer length) 
	{
		super.decode(buffer, length);
		if(getString()!=null)
		{
			try
			{
				parseUri();
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
		result = prime * result + ((getUri() == null) ? 0 : getUri().hashCode());
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
			
		DiameterUriImpl other = (DiameterUriImpl) obj;
		if (getUri() == null) 
		{
			if (other.getUri() != null)
				return false;
		} 
		else if (!getUri().equals(other.getUri()))
			return false;
			
		return true;
	}
	
	private void parseUri() throws InvalidAvpValueException
	{
		String remaining=getUri();
		Integer errorOffset=0;
		if(remaining.startsWith("aaa://"))
		{
			isSecure=false;
			remaining=remaining.substring(6);
			errorOffset+=6;
		}
		else if(remaining.startsWith("aaas://"))
		{
			isSecure=true;
			remaining=remaining.substring(7);
			errorOffset+=6;
		}
		else
			throw new InvalidAvpValueException("Invalid scheme" + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
		
		if(remaining.indexOf(";")>0)
		{
			Integer initialOffset=errorOffset;
			String[] segments=remaining.split(";");
			errorOffset+=segments[0].length();
			
			for(int i=1;i<segments.length;i++)
			{
				if(segments[i].length()>0)
				{
					String[] subSegments=segments[i].split("=");
					if(subSegments.length!=2)
						throw new InvalidAvpValueException("Invalid uri parameter " + segments[i] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
					
					switch (subSegments[0].toLowerCase()) 
					{
						case "transport":
							transport=DiameterTransport.fromString(subSegments[1]);
							if(transport==null)
								throw new InvalidAvpValueException("Invalid transport " + subSegments[1] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
							
							break;
						case "protocol":							
							protocol=DiameterProtocol.fromString(subSegments[1]);
							if(protocol==null)
								throw new InvalidAvpValueException("Invalid protocol " + subSegments[1] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
							
							break;	
						default:
							throw new InvalidAvpValueException("Invalid uri parameter " + segments[i] + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));							
					}
				}
				
				errorOffset+=segments[i].length();
			}
			
			errorOffset=initialOffset;
			remaining=segments[0];
		}
		
		if(remaining.indexOf(":")>0)
		{
			String[] segments = remaining.split(":");
			if(segments.length!=2)
				throw new InvalidAvpValueException("Invalid host/port " + remaining + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));
			
			host=segments[0];
			if(segments[1].length()>0)
			{
				try 
				{
					port = Integer.parseInt(segments[1]);
				}
				catch(NumberFormatException ex)
				{
					throw new InvalidAvpValueException("Invalid host/port " + remaining + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));					
				}
				
				if(port<=0 || port>65535)
					throw new InvalidAvpValueException("Invalid host/port " + remaining + " at offset " + errorOffset, Arrays.asList(new DiameterAvp[] { this }));				
			}
		}
		else
			host = remaining;		
	}
	
	public static String buildUri(String host,Integer port,Boolean isSecure,DiameterTransport transport, DiameterProtocol protocol)
	{
		StringBuilder sb=new StringBuilder();
		if(isSecure)
			sb.append("aaas://");
		else
			sb.append("aaa://");
		
		sb.append(host);
		if(port!=null)
			sb.append(":").append(port);
		
		if(transport!=null)
			sb.append(";transport=").append(transport.getValue());
		
		if(protocol!=null)
			sb.append(";protocol=").append(protocol.getValue());
		
		return sb.toString();
	}
}
