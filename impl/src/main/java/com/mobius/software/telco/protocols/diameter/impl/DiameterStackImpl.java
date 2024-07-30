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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.restcomm.cluster.ClusteredID;
import org.restcomm.cluster.IDGenerator;

import com.mobius.software.common.dal.timers.WorkerPool;
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.DiameterSessionStorage;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.IncomingRequestsStorage;
import com.mobius.software.telco.protocols.diameter.NetworkManager;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.impl.app.creditcontrol.CreditControlProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.cxdx.CxDxProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.e4.E4ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.eap.EAPProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gi.GiProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gxx.GxxProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gq.GqProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gmb.GMBProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gy.GyProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.mb2c.Mb2cProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.mm10.MM10ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.nta.NtaProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.rf.RfProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.ro.RoProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s15.S15ProviderImpl;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;

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
	
	private ConcurrentHashMap<Integer, AtomicLong> messagesSentByType = new ConcurrentHashMap<Integer, AtomicLong>();
	private ConcurrentHashMap<Integer, AtomicLong> messagesReceivedByType = new ConcurrentHashMap<Integer, AtomicLong>();
	private ConcurrentHashMap<Long, AtomicLong> errorsSentByType = new ConcurrentHashMap<Long, AtomicLong>();
	private ConcurrentHashMap<Long, AtomicLong> errorsReceivedByType = new ConcurrentHashMap<Long, AtomicLong>();
	private ConcurrentHashMap<Long, AtomicLong> outgoingSessionsByApplication = new ConcurrentHashMap<Long, AtomicLong>();
	private ConcurrentHashMap<Long, AtomicLong> incomingSessionsByApplication = new ConcurrentHashMap<Long, AtomicLong>();
	
	private ConcurrentHashMap<Long, AtomicLong> sessionsEndedByResultCode = new ConcurrentHashMap<Long, AtomicLong>();
	private ConcurrentHashMap<Long, ConcurrentHashMap<Long, AtomicLong>> sessionsEndedByResultCodeAndApplication = new ConcurrentHashMap<Long, ConcurrentHashMap<Long, AtomicLong>>();
		
	private ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>> messagesSentByTypeAndApplication=new ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>>();
	private ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>> messagesReceivedByTypeAndApplication=new ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>>();
	private ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>> errorsSentByTypeAndApplication=new ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>>();
	private ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>> errorsReceivedByTypeAndApplication=new ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>>();
    
	private ConcurrentHashMap<String,ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>>> messagesSentByLinkTypeAndApplication=new ConcurrentHashMap<String,ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>>>();
	private ConcurrentHashMap<String,ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>>> messagesReceivedByLinkTypeAndApplication=new ConcurrentHashMap<String,ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>>>();
	private ConcurrentHashMap<String,ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>>> errorsSentByLinkTypeAndApplication=new ConcurrentHashMap<String,ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>>>();
	private ConcurrentHashMap<String,ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>>> errorsReceivedByLinkTypeAndApplication=new ConcurrentHashMap<String,ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>>>();
    
	private DiameterSessionStorage sessionStorage = new LocalDiameterSessionStorageImpl(this);
	private IncomingRequestsStorage incomingRequestsStorage;
	
	private Long responseTimeout = DEFAULT_RESPONSE_TIMEOUT;
	private Long idleTimeout = DEFAULT_IDLE_TIMEOUT;
	private Long duplicateTimeout = 0L;
	private Long duplicatesCheckPeriod = 0L;
	
	private WorkerPool workerPool;
	private IDGenerator<?> idGenerator;
	
	private AtomicLong sessionCounter=new AtomicLong();
	private String localHost;
	
	private ClusteredID<?> stackID;
	
	private NetworkManager networkManager;
	
	private String productName;
	private Long vendorId;
	private AtomicLong hopByHopCounter=new AtomicLong(System.currentTimeMillis());
	private Long originalStateId = hopByHopCounter.get() % 0x100000000L;
	private Long firmwareRevision;
	
	public DiameterStackImpl(IDGenerator<?> idGenerator,WorkerPool workerPool,int workerThreads,String localHost, String productName, Long vendorId,Long firmwareRevision, Long idleTimeout, Long responseTimeout, Long reconnectTimeout, Long duplicateTimeout, Long duplicatesCheckPeriod) throws Exception
	{
		this.idGenerator = idGenerator;
		this.workerPool = workerPool;
		this.localHost = localHost;
		this.productName = productName;
		this.vendorId = vendorId;
		this.firmwareRevision = firmwareRevision;
		
		if(idleTimeout!=null)
			this.idleTimeout = idleTimeout;
		
		if(responseTimeout !=null)
			this.responseTimeout = responseTimeout;
		
		if(duplicatesCheckPeriod!=null)
			this.duplicatesCheckPeriod = duplicatesCheckPeriod;
		
		if(this.duplicateTimeout!=null)
			this.duplicateTimeout = duplicateTimeout;
		
		this.incomingRequestsStorage = new LocalIncomingRequestsStorageImpl(this);
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
				
				if(parentPackage==null || parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.eap"))
				{
					EAPProviderImpl eapProvider=new EAPProviderImpl(this);
					if(parentPackage!=null)
						registeredProvidersByPackage.put(parentPackage.getName(), eapProvider);
					else
						registeredProviders.put(applicationID, eapProvider);
					
					
					return eapProvider;
				}
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
				if(parentPackage!=null && parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.gq"))
				{
					GqProviderImpl gqProvider=new GqProviderImpl(this);
					registeredProvidersByPackage.put(parentPackage.getName(), gqProvider);
					return gqProvider;
				}
				break;
			case ApplicationIDs.GMB:
				if(parentPackage!=null && parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.gmb"))
				{
					GMBProviderImpl gmbProvider=new GMBProviderImpl(this);
					registeredProvidersByPackage.put(parentPackage.getName(), gmbProvider);
					return gmbProvider;
				}
				break;
			case ApplicationIDs.MM10:
				MM10ProviderImpl mm10Provider=new MM10ProviderImpl(this);
				if(parentPackage!=null)
					registeredProvidersByPackage.put(parentPackage.getName(), mm10Provider);
				else
					registeredProviders.put(applicationID, mm10Provider);
				
				return mm10Provider;
			case ApplicationIDs.E4:
				E4ProviderImpl e4Provider=new E4ProviderImpl(this);
				if(parentPackage!=null)
					registeredProvidersByPackage.put(parentPackage.getName(), e4Provider);
				else
					registeredProviders.put(applicationID, e4Provider);
				
				return e4Provider;
			case ApplicationIDs.MB2C:
				Mb2cProviderImpl mb2cProvider=new Mb2cProviderImpl(this);
				if(parentPackage!=null)
					registeredProvidersByPackage.put(parentPackage.getName(), mb2cProvider);
				else
					registeredProviders.put(applicationID, mb2cProvider);
				
				return mb2cProvider;
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
				if(parentPackage==null || parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.gxx"))
				{
					GxxProviderImpl gxxProvider=new GxxProviderImpl(this);
					if(parentPackage!=null)
						registeredProvidersByPackage.put(parentPackage.getName(), gxxProvider);
					else
						registeredProviders.put(applicationID, gxxProvider);
					
					
					return gxxProvider;
				}
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
	public void sendRequest(DiameterRequest message, AsyncCallback callback)
	{
		networkManager.sendRequest(message, callback);
	}

	@Override
	public void sendAnswer(DiameterAnswer message, String destinationHost, String destinationRealm, AsyncCallback callback)
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
		return hopByHopCounter.incrementAndGet() % 0x100000000L;
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

	@Override
	public DiameterSessionStorage getSessionStorage()
	{
		return sessionStorage;
	}

	@Override
	public Long getDuplicatesTimeout()
	{
		return this.duplicateTimeout;
	}

	@Override
	public Long getDuplicatesCheckPeriod()
	{
		return this.duplicatesCheckPeriod;
	}

	@Override
	public IncomingRequestsStorage getRequestsStorage()
	{
		return this.incomingRequestsStorage;
	}

	@Override
	public Map<Integer, Long> getMessagesSentByType()
	{
		Map<Integer,Long> result=new HashMap<Integer, Long>();
		Iterator<Entry<Integer, AtomicLong>> iterator=messagesSentByType.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Integer, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey(), currEntry.getValue().get());
		}
		
		return result;
	}

	@Override
	public Map<Integer, Long> getMessagesReceivedByType()
	{
		Map<Integer,Long> result=new HashMap<Integer, Long>();
		Iterator<Entry<Integer, AtomicLong>> iterator=messagesReceivedByType.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Integer, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey(), currEntry.getValue().get());
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getErrorsSentByType()
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		Iterator<Entry<Long, AtomicLong>> iterator=errorsSentByType.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Long, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey(), currEntry.getValue().get());
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getErrorsReceivedByType()
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		Iterator<Entry<Long, AtomicLong>> iterator=errorsReceivedByType.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Long, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey(), currEntry.getValue().get());
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getOutgoingSessionByApplication()
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		Iterator<Entry<Long, AtomicLong>> iterator=outgoingSessionsByApplication.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Long, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey(), currEntry.getValue().get());
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getIncomingSessionsByApplication()
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		Iterator<Entry<Long, AtomicLong>> iterator=incomingSessionsByApplication.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Long, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey(), currEntry.getValue().get());
		}
		
		return result;
	}

	@Override
	public Map<Integer, Long> getMessagesSentByTypeAndApplication(long applicationID)
	{
		Map<Integer,Long> result=new HashMap<Integer, Long>();
		Map<Integer,AtomicLong> messagesSentByType = messagesSentByTypeAndApplication.get(applicationID);
		if(messagesSentByType!=null) {
			Iterator<Entry<Integer, AtomicLong>> iterator=messagesSentByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Integer, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<Integer, Long> getMessagesReceivedByTypeAndApplication(long applicationID)
	{
		Map<Integer,Long> result=new HashMap<Integer, Long>();
		Map<Integer,AtomicLong> messagesReceivedByType = messagesReceivedByTypeAndApplication.get(applicationID);
		if(messagesReceivedByType!=null) {
			Iterator<Entry<Integer, AtomicLong>> iterator=messagesReceivedByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Integer, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getErrorsSentByTypeAndApplication(long applicationID)
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		Map<Long,AtomicLong> errorsSentByType = errorsSentByTypeAndApplication.get(applicationID);
		if(errorsSentByType!=null) {
			Iterator<Entry<Long, AtomicLong>> iterator=errorsSentByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Long, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getErrorsReceivedByTypeAndApplication(long applicationID)
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		Map<Long,AtomicLong> errorsReceivedByType = errorsReceivedByTypeAndApplication.get(applicationID);
		if(errorsReceivedByType!=null) {
			Iterator<Entry<Long, AtomicLong>> iterator=errorsReceivedByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Long, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<Integer, Long> getLinkMessagesSentByTypeAndApplication(String linkID, long applicationID)
	{
		Map<Integer,Long> result=new HashMap<Integer, Long>();
		ConcurrentHashMap<Long, ConcurrentHashMap<Integer, AtomicLong>> messagesSentByTypeAndApplication = messagesSentByLinkTypeAndApplication.get(linkID);
		if(messagesSentByTypeAndApplication==null)
			return null;
		
		Map<Integer,AtomicLong> messagesSentByType = messagesSentByTypeAndApplication.get(applicationID);
		if(messagesSentByType!=null) {
			Iterator<Entry<Integer, AtomicLong>> iterator=messagesSentByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Integer, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey(), currEntry.getValue().get());
			}
		}
		
		return result;
	}
    
	@Override
	public Map<Integer,Long> getLinkMessagesReceivedByTypeAndApplication(String linkID, long applicationID)    
    {
		Map<Integer,Long> result=new HashMap<Integer, Long>();
		ConcurrentHashMap<Long, ConcurrentHashMap<Integer, AtomicLong>> messagesReceivedByTypeAndApplication = messagesReceivedByLinkTypeAndApplication.get(linkID);
		if(messagesReceivedByTypeAndApplication==null)
			return null;
		
		Map<Integer,AtomicLong> messagesReceivedByType = messagesReceivedByTypeAndApplication.get(applicationID);
		if(messagesReceivedByType!=null) {
			Iterator<Entry<Integer, AtomicLong>> iterator=messagesReceivedByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Integer, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getLinkErrorsSentByTypeAndApplication(String linkID, long applicationID)
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		ConcurrentHashMap<Long, ConcurrentHashMap<Long, AtomicLong>> errorsSentByTypeAndApplication = errorsSentByLinkTypeAndApplication.get(linkID);
		if(errorsSentByTypeAndApplication==null)
			return null;
		
		Map<Long,AtomicLong> errorsSentByType = errorsSentByTypeAndApplication.get(applicationID);
		if(errorsSentByType!=null) {
			Iterator<Entry<Long, AtomicLong>> iterator=errorsSentByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Long, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getLinkErrorsReceivedByTypeAndApplication(String linkID, long applicationID)
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		ConcurrentHashMap<Long, ConcurrentHashMap<Long, AtomicLong>> errorsReceivedByTypeAndApplication = errorsReceivedByLinkTypeAndApplication.get(linkID);
		if(errorsReceivedByTypeAndApplication==null)
			return null;
		
		Map<Long,AtomicLong> errorsReceivedByType = errorsReceivedByTypeAndApplication.get(applicationID);
		if(errorsReceivedByType!=null) {
			Iterator<Entry<Long, AtomicLong>> iterator=errorsReceivedByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Long, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public void messageReceived(DiameterMessage message, String linkID)
	{
		DiameterCommandDefinition commandDef = DiameterParser.getCommandDefinition(message.getClass());
		AtomicLong counter = messagesReceivedByType.get(commandDef.commandCode());
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesReceivedByType.putIfAbsent(commandDef.commandCode(), counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
		
		ConcurrentHashMap<Integer, AtomicLong> messagesReceivedByType = messagesReceivedByTypeAndApplication.get(commandDef.applicationId());
		if(messagesReceivedByType == null)
		{
			messagesReceivedByType = new ConcurrentHashMap<Integer, AtomicLong>();
			ConcurrentHashMap<Integer, AtomicLong> oldMap = messagesReceivedByTypeAndApplication.putIfAbsent(commandDef.applicationId(), messagesReceivedByType);
			if(oldMap!=null)
				messagesReceivedByType = oldMap;								
		}
		
		counter = messagesReceivedByType.get(commandDef.commandCode());
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesReceivedByType.putIfAbsent(commandDef.commandCode(), counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
		
		ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>> messagesReceivedByTypeAndApplication = messagesReceivedByLinkTypeAndApplication.get(linkID);
		if(messagesReceivedByTypeAndApplication == null)
		{
			messagesReceivedByTypeAndApplication = new ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>>();
			ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>> oldMap = messagesReceivedByLinkTypeAndApplication.putIfAbsent(linkID, messagesReceivedByTypeAndApplication);
			if(oldMap!=null)
				messagesReceivedByTypeAndApplication = oldMap;								
		}
		
		messagesReceivedByType = messagesReceivedByTypeAndApplication.get(commandDef.applicationId());
		if(messagesReceivedByType == null)
		{
			messagesReceivedByType = new ConcurrentHashMap<Integer, AtomicLong>();
			ConcurrentHashMap<Integer, AtomicLong> oldMap = messagesReceivedByTypeAndApplication.putIfAbsent(commandDef.applicationId(), messagesReceivedByType);
			if(oldMap!=null)
				messagesReceivedByType = oldMap;								
		}
		
		counter = messagesReceivedByType.get(commandDef.commandCode());
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesReceivedByType.putIfAbsent(commandDef.commandCode(), counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
		
		if(message instanceof DiameterAnswer)
		{
			DiameterAnswer answer=(DiameterAnswer)message;
			if(answer.getIsError())
			{
				counter = errorsReceivedByType.get(answer.getResultCode());
				if(counter == null)
				{
					counter = new AtomicLong(0);
					AtomicLong oldCounter = errorsReceivedByType.putIfAbsent(answer.getResultCode(), counter);
					if(oldCounter != null)
						counter = oldCounter;
				}
				
				counter.incrementAndGet();
				
				ConcurrentHashMap<Long, AtomicLong> errorsReceivedByType = errorsReceivedByTypeAndApplication.get(commandDef.applicationId());
				if(errorsReceivedByType == null)
				{
					errorsReceivedByType = new ConcurrentHashMap<Long, AtomicLong>();
					ConcurrentHashMap<Long, AtomicLong> oldMap = errorsReceivedByTypeAndApplication.putIfAbsent(commandDef.applicationId(), errorsReceivedByType);
					if(oldMap!=null)
						errorsReceivedByType = oldMap;								
				}
				
				counter = errorsReceivedByType.get(answer.getResultCode());
				if(counter == null)
				{
					counter = new AtomicLong(0);
					AtomicLong oldCounter = errorsReceivedByType.putIfAbsent(answer.getResultCode(), counter);
					if(oldCounter != null)
						counter = oldCounter;
				}
				
				counter.incrementAndGet();
				
				ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>> errorsReceivedByTypeAndApplication = errorsReceivedByLinkTypeAndApplication.get(linkID);
				if(errorsReceivedByTypeAndApplication == null)
				{
					errorsReceivedByTypeAndApplication = new ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>>();
					ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>> oldMap = errorsReceivedByLinkTypeAndApplication.putIfAbsent(linkID, errorsReceivedByTypeAndApplication);
					if(oldMap!=null)
						errorsReceivedByTypeAndApplication = oldMap;								
				}
				
				errorsReceivedByType = errorsReceivedByTypeAndApplication.get(commandDef.applicationId());
				if(errorsReceivedByType == null)
				{
					errorsReceivedByType = new ConcurrentHashMap<Long, AtomicLong>();
					ConcurrentHashMap<Long, AtomicLong> oldMap = errorsReceivedByTypeAndApplication.putIfAbsent(commandDef.applicationId(), errorsReceivedByType);
					if(oldMap!=null)
						errorsReceivedByType = oldMap;								
				}
				
				counter = errorsReceivedByType.get(answer.getResultCode());
				if(counter == null)
				{
					counter = new AtomicLong(0);
					AtomicLong oldCounter = errorsReceivedByType.putIfAbsent(answer.getResultCode(), counter);
					if(oldCounter != null)
						counter = oldCounter;
				}
				
				counter.incrementAndGet();
			}
		}
	}

	@Override
	public void messageSent(DiameterMessage message, String linkID)
	{
		DiameterCommandDefinition commandDef = DiameterParser.getCommandDefinition(message.getClass());
		AtomicLong counter = messagesSentByType.get(commandDef.commandCode());
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesSentByType.putIfAbsent(commandDef.commandCode(), counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
		
		ConcurrentHashMap<Integer, AtomicLong> messagesSentByType = messagesSentByTypeAndApplication.get(commandDef.applicationId());
		if(messagesSentByType == null)
		{
			messagesSentByType = new ConcurrentHashMap<Integer, AtomicLong>();
			ConcurrentHashMap<Integer, AtomicLong> oldMap = messagesSentByTypeAndApplication.putIfAbsent(commandDef.applicationId(), messagesSentByType);
			if(oldMap!=null)
				messagesSentByType = oldMap;								
		}
		
		counter = messagesSentByType.get(commandDef.commandCode());
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesSentByType.putIfAbsent(commandDef.commandCode(), counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
		
		ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>> messagesSentByTypeAndApplication = messagesSentByLinkTypeAndApplication.get(linkID);
		if(messagesSentByTypeAndApplication == null)
		{
			messagesSentByTypeAndApplication = new ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>>();
			ConcurrentHashMap<Long,ConcurrentHashMap<Integer, AtomicLong>> oldMap = messagesSentByLinkTypeAndApplication.putIfAbsent(linkID, messagesSentByTypeAndApplication);
			if(oldMap!=null)
				messagesSentByTypeAndApplication = oldMap;								
		}
		
		messagesSentByType = messagesSentByTypeAndApplication.get(commandDef.applicationId());
		if(messagesSentByType == null)
		{
			messagesSentByType = new ConcurrentHashMap<Integer, AtomicLong>();
			ConcurrentHashMap<Integer, AtomicLong> oldMap = messagesSentByTypeAndApplication.putIfAbsent(commandDef.applicationId(), messagesSentByType);
			if(oldMap!=null)
				messagesSentByType = oldMap;								
		}
		
		counter = messagesSentByType.get(commandDef.commandCode());
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesSentByType.putIfAbsent(commandDef.commandCode(), counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
		
		if(message instanceof DiameterAnswer)
		{
			DiameterAnswer answer=(DiameterAnswer)message;
			if(answer.getIsError())
			{
				counter = errorsSentByType.get(answer.getResultCode());
				if(counter == null)
				{
					counter = new AtomicLong(0);
					AtomicLong oldCounter = errorsSentByType.putIfAbsent(answer.getResultCode(), counter);
					if(oldCounter != null)
						counter = oldCounter;
				}
				
				counter.incrementAndGet();
				
				ConcurrentHashMap<Long, AtomicLong> errorsSentByType = errorsSentByTypeAndApplication.get(commandDef.applicationId());
				if(errorsSentByType == null)
				{
					errorsSentByType = new ConcurrentHashMap<Long, AtomicLong>();
					ConcurrentHashMap<Long, AtomicLong> oldMap = errorsSentByTypeAndApplication.putIfAbsent(commandDef.applicationId(), errorsSentByType);
					if(oldMap!=null)
						errorsSentByType = oldMap;								
				}
				
				counter = errorsSentByType.get(answer.getResultCode());
				if(counter == null)
				{
					counter = new AtomicLong(0);
					AtomicLong oldCounter = errorsSentByType.putIfAbsent(answer.getResultCode(), counter);
					if(oldCounter != null)
						counter = oldCounter;
				}
				
				counter.incrementAndGet();
				
				ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>> errorsSentByTypeAndApplication = errorsSentByLinkTypeAndApplication.get(linkID);
				if(errorsSentByTypeAndApplication == null)
				{
					errorsSentByTypeAndApplication = new ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>>();
					ConcurrentHashMap<Long,ConcurrentHashMap<Long, AtomicLong>> oldMap = errorsSentByLinkTypeAndApplication.putIfAbsent(linkID, errorsSentByTypeAndApplication);
					if(oldMap!=null)
						errorsSentByTypeAndApplication = oldMap;								
				}
				
				errorsSentByType = errorsSentByTypeAndApplication.get(commandDef.applicationId());
				if(errorsSentByType == null)
				{
					errorsSentByType = new ConcurrentHashMap<Long, AtomicLong>();
					ConcurrentHashMap<Long, AtomicLong> oldMap = errorsSentByTypeAndApplication.putIfAbsent(commandDef.applicationId(), errorsSentByType);
					if(oldMap!=null)
						errorsSentByType = oldMap;								
				}
				
				counter = errorsSentByType.get(answer.getResultCode());
				if(counter == null)
				{
					counter = new AtomicLong(0);
					AtomicLong oldCounter = errorsSentByType.putIfAbsent(answer.getResultCode(), counter);
					if(oldCounter != null)
						counter = oldCounter;
				}
				
				counter.incrementAndGet();
			}
		}
	}
	
	@Override
	public void newIncomingSession(long applicationID)
	{
		AtomicLong counter = incomingSessionsByApplication.get(applicationID);
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = incomingSessionsByApplication.putIfAbsent(applicationID, counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
	}

	@Override
	public void newOutgoingSession(long applicationID)
	{
		AtomicLong counter = outgoingSessionsByApplication.get(applicationID);
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = outgoingSessionsByApplication.putIfAbsent(applicationID, counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
	}

	@Override
	public Map<Long, Long> getSessionEndedByResultCode()
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		Iterator<Entry<Long, AtomicLong>> iterator=sessionsEndedByResultCode.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Long, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey(), currEntry.getValue().get());
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getSessionEndedByResultCodeAndApplication(long applicationID)
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		Map<Long,AtomicLong> sessionsEndedByResultCode = sessionsEndedByResultCodeAndApplication.get(applicationID);
		if(sessionsEndedByResultCode!=null) {
			Iterator<Entry<Long, AtomicLong>> iterator=sessionsEndedByResultCode.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Long, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public void sessionEnded(Long resultCode, long applicationID)
	{
		if(resultCode==null)
			return;
		
		AtomicLong counter = sessionsEndedByResultCode.get(resultCode);
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = sessionsEndedByResultCode.putIfAbsent(resultCode, counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
		
		ConcurrentHashMap<Long, AtomicLong> sessionsEndedByResultCode = sessionsEndedByResultCodeAndApplication.get(applicationID);
		if(sessionsEndedByResultCode == null)
		{
			sessionsEndedByResultCode = new ConcurrentHashMap<Long, AtomicLong>();
			ConcurrentHashMap<Long, AtomicLong> oldMap = sessionsEndedByResultCodeAndApplication.putIfAbsent(applicationID, sessionsEndedByResultCode);
			if(oldMap!=null)
				sessionsEndedByResultCode = oldMap;								
		}
		
		counter = sessionsEndedByResultCode.get(resultCode);
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = sessionsEndedByResultCode.putIfAbsent(resultCode, counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
	}
}