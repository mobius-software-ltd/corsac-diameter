package com.mobius.software.telco.protocols.diameter.impl;
/*
 * Mobius Software LTD
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

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.restcomm.cluster.ClusteredID;
import org.restcomm.cluster.IDGenerator;

import com.mobius.software.common.dal.timers.WorkerPool;
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.NetworkManager;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.creditcontrol.CreditControlProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.cxdx.CxDxProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gi.GiProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gy.GyProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.mm10.MM10ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.nta.NtaProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.rf.RfProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.ro.RoProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s15.S15ProviderImpl;

/**
*
* @author yulian oifa
*
*/
public class DiameterStackImpl implements DiameterStack
{
	public static final Long DEFAULT_RESPONSE_TIMEOUT = 60000L;
	public static final Long DEFAULT_IDLE_TIMEOUT = 120000L;
	
	private ConcurrentHashMap<Long,DiameterProvider<?, ?, ?, ?, ?>> registeredProviders=new ConcurrentHashMap<Long,DiameterProvider<?, ?, ?, ?, ?>>();
	private ConcurrentHashMap<String,DiameterProvider<?, ?, ?, ?, ?>> registeredProvidersByPackage=new ConcurrentHashMap<String,DiameterProvider<?, ?, ?, ?, ?>>();
	
	private Long responseTimeout = DEFAULT_RESPONSE_TIMEOUT;
	private Long idleTimeout = DEFAULT_IDLE_TIMEOUT;
	
	private WorkerPool workerPool;
	private IDGenerator<?> idGenerator;
	
	private AtomicLong sessionCounter=new AtomicLong();
	private String localHost;
	
	private ClusteredID<?> stackID;
	
	private NetworkManager networkManager;
	
	private String productName;
	private Long vendorId;
	private AtomicLong hopByHopCounter=new AtomicLong(System.currentTimeMillis());
	private Long originalStateId = hopByHopCounter.get();
	private Long firmwareRevision;
	
	public DiameterStackImpl(IDGenerator<?> idGenerator,WorkerPool workerPool,int workerThreads,String localHost, String productName, Long vendorId,Long firmwareRevision, Long idleTimeout, Long responseTimeout, Long reconnectTimeout) throws Exception
	{
		this.idGenerator = idGenerator;
		this.workerPool = workerPool;
		this.localHost = localHost;
		this.productName = productName;
		this.vendorId = vendorId;
		this.firmwareRevision = firmwareRevision;
		
		if(responseTimeout !=null)
			this.responseTimeout = responseTimeout;
		
		this.networkManager = new NetworkManagerImpl(this, workerThreads, idleTimeout, this.responseTimeout, reconnectTimeout);
		this.stackID = idGenerator.generateID();
	}
	
	//its not required to create the providers from here, they may be created as needed
	@Override
	public DiameterProvider<?, ?, ?, ?, ?> getProvider(Long applicationID, Package parentPackage)
	{
		if(parentPackage==null)
		{
			DiameterProvider<?, ?, ?, ?, ?> provider = registeredProviders.get(applicationID);
			if(provider != null)
				return provider;		
		}
		else
		{
			DiameterProvider<?, ?, ?, ?, ?> provider = registeredProvidersByPackage.get(parentPackage.getName());
			if(provider != null)
				return provider;
		}
		
		//TODO:create providers when exists
		
		switch(applicationID.intValue())
		{
			case ApplicationIDs.COMMON:
				break;
			case ApplicationIDs.NASREQ:
				if(parentPackage!=null && parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.gi"))
				{
					GiProviderImpl giProvider=new GiProviderImpl(this);
					registeredProvidersByPackage.put(parentPackage.getName(), giProvider);
					return giProvider;
				}
				break;
			case ApplicationIDs.MOBILE_IPV4:
				break;
			case ApplicationIDs.ACCOUNTING:
				if(parentPackage==null || parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.rf"))
				{
					RfProviderImpl rfProvider=new RfProviderImpl(this);
					if(parentPackage!=null)
						registeredProvidersByPackage.put(parentPackage.getName(), rfProvider);
					else
						registeredProviders.put(applicationID, rfProvider);
					
					return rfProvider;
				}
				break;
			case ApplicationIDs.CREDIT_CONTROL:
				if(parentPackage==null || parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.ro"))
				{
					RoProviderImpl roProvider=new RoProviderImpl(this);
					if(parentPackage!=null)
						registeredProvidersByPackage.put(parentPackage.getName(), roProvider);
					else
						registeredProviders.put(applicationID, roProvider);
					
					
					return roProvider;
					
				}
				else if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.gy"))
				{
					GyProviderImpl gyProvider=new GyProviderImpl(this);
					registeredProvidersByPackage.put(parentPackage.getName(), gyProvider);
					return gyProvider;
				}
				else if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.creditcontrol"))
				{
					CreditControlProviderImpl creditControlProvider=new CreditControlProviderImpl(this);
					registeredProvidersByPackage.put(parentPackage.getName(), creditControlProvider);
					return creditControlProvider;
				}
				break;
			case ApplicationIDs.EAP:
				break;
			case ApplicationIDs.SIP_APPLICATION:
				break;
			case ApplicationIDs.MIP6I:
				break;
			case ApplicationIDs.MIP6A:
				break;		
			case ApplicationIDs.CX_DX:
				CxDxProviderImpl cxDxProvider=new CxDxProviderImpl(this);
				if(parentPackage!=null)
					registeredProvidersByPackage.put(parentPackage.getName(), cxDxProvider);
				else
					registeredProviders.put(applicationID, cxDxProvider);
				
				return cxDxProvider;				
			case ApplicationIDs.SH:
				break;
			case ApplicationIDs.GQ:
				break;
			case ApplicationIDs.GMB:
				break;
			case ApplicationIDs.MM10:
				MM10ProviderImpl mm10Provider=new MM10ProviderImpl(this);
				if(parentPackage!=null)
					registeredProvidersByPackage.put(parentPackage.getName(), mm10Provider);
				else
					registeredProviders.put(applicationID, mm10Provider);
				
				return mm10Provider;
			case ApplicationIDs.E4:
				break;
			case ApplicationIDs.MB2C:
				break;
			case ApplicationIDs.RX:
				break;
			case ApplicationIDs.GX:
				break;
			case ApplicationIDs.STA:
				break;
			case ApplicationIDs.S6A:
				break;
			case ApplicationIDs.S13:
				break;
			case ApplicationIDs.S15:
				S15ProviderImpl s15Provider=new S15ProviderImpl(this);
				if(parentPackage!=null)
					registeredProvidersByPackage.put(parentPackage.getName(), s15Provider);
				else
					registeredProviders.put(applicationID, s15Provider);
				
				return s15Provider;	
			case ApplicationIDs.SLG:
				break;
			case ApplicationIDs.SWM:
				break;
			case ApplicationIDs.SWX:
				break;
			case ApplicationIDs.GXX:
				break;
			case ApplicationIDs.S9:
				break;
			case ApplicationIDs.S6B:
				break;
			case ApplicationIDs.SLH:
				break;
			case ApplicationIDs.SGMB:
				break;
			case ApplicationIDs.SY:
				break;
			case ApplicationIDs.SD:
				break;
			case ApplicationIDs.S7A:
				break;
			case ApplicationIDs.TSP:
				break;
			case ApplicationIDs.S6M:
				break;
			case ApplicationIDs.T4:
				break;
			case ApplicationIDs.S6C:
				break;
			case ApplicationIDs.SGD:
				break;
			case ApplicationIDs.S9A:
				break;
			case ApplicationIDs.S9ATAG:
				break;
			case ApplicationIDs.PC4A:
				break;
			case ApplicationIDs.PC6:
				break;
			case ApplicationIDs.NP:
				break;
			case ApplicationIDs.S6T:
				break;
			case ApplicationIDs.T6A:
				break;
			case ApplicationIDs.NT:
				break;
			case ApplicationIDs.NTA:
				NtaProviderImpl ntaProvider=new NtaProviderImpl(this);
				if(parentPackage!=null)
					registeredProvidersByPackage.put(parentPackage.getName(), ntaProvider);
				else
					registeredProviders.put(applicationID, ntaProvider);
				
				return ntaProvider;	
			case ApplicationIDs.ST:
				break;
			case ApplicationIDs.PC2:
				break;
		}
		
		return null;
	}

	@Override
	public void sendRequestToNetwork(DiameterRequest message, AsyncCallback callback)
	{
		networkManager.sendRequest(message, callback);
	}

	@Override
	public void sendAnswerToNetwork(DiameterAnswer message, String destinationHost, String destinationRealm, AsyncCallback callback)
	{
		networkManager.sendAnswer(message, destinationHost, destinationRealm, callback);	
	}

	@Override
	public WorkerPool getWorkerPool()
	{
		return workerPool;
	}

	@Override
	public Long getResponseTimeout()
	{
		return responseTimeout;
	}

	@Override
	public Long getIdleTimeout()
	{
		return idleTimeout;
	}

	@Override
	public void setIdleTimeout(Long value)
	{
		if(value==null)
			idleTimeout = DEFAULT_IDLE_TIMEOUT;
		else
			idleTimeout = value;
	}

	@Override
	public IDGenerator<?> getIDGenerator()
	{
		return idGenerator;
	}

	@Override
	public String generateNewSessionID()
	{
		Long currNumber=sessionCounter.incrementAndGet();
		StringBuilder sb=new StringBuilder();
		sb.append(localHost);
		sb.append(";");
		sb.append((currNumber >> 32) & 0x0FFFFFFFFL);
		sb.append(";");
		sb.append(currNumber & 0x0FFFFFFFFL);
		sb.append(";");
		sb.append(stackID.getValue());
		return sb.toString();
	}

	@Override
	public NetworkManager getNetworkManager()
	{
		return networkManager;
	}

	@Override
	public Long getOriginalStateId()
	{
		return originalStateId;
	}

	@Override
	public Long getNextHopByHopIdentifier()
	{
		return hopByHopCounter.incrementAndGet();
	}

	@Override
	public String getProductName()
	{
		return productName;
	}

	@Override
	public Long getVendorID()
	{
		return vendorId;
	}

	@Override
	public Long getFirmwareRevision()
	{
		return firmwareRevision;
	}

	@Override
	public void stop()
	{
		networkManager.stop();
	}
}