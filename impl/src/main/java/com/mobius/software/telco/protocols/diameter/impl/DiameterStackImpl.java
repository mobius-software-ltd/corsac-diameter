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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.restcomm.cluster.ClusteredID;
import org.restcomm.cluster.IDGenerator;

import com.mobius.software.common.dal.timers.CountableQueue;
import com.mobius.software.common.dal.timers.PeriodicQueuedTasks;
import com.mobius.software.common.dal.timers.Task;
import com.mobius.software.common.dal.timers.Timer;
import com.mobius.software.telco.protocols.diameter.ApplicationID;
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.AsyncCallback;
import com.mobius.software.telco.protocols.diameter.CommandCode;
import com.mobius.software.telco.protocols.diameter.DiameterProvider;
import com.mobius.software.telco.protocols.diameter.DiameterSessionStorage;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.IncomingRequestsStorage;
import com.mobius.software.telco.protocols.diameter.NetworkManager;
import com.mobius.software.telco.protocols.diameter.annotations.DiameterCommandDefinition;
import com.mobius.software.telco.protocols.diameter.commands.DiameterAnswer;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.DiameterRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.app.creditcontrol.CreditControlProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.creditcontrol.ericsson.EricssonCreditControlProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.creditcontrol.huawei.HuaweiCreditControlProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.cxdx.CxDxProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.e4.E4ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.eap.EAPProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gi.GiProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gmb.GMBProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gq.GqProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gqtag.GqTagProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gx.GxProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gxx.GxxProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.gy.GyProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.mb2c.Mb2cProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.mm10.MM10ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.nas.NasProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.np.NpProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.nt.NtProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.nta.NtaProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.pc2.PC2ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.pc4a.PC4AProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.pc6.PC6ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.rf.RfProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.rfc4004.RFC4004ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.rfc4740.Rfc4740ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.rfc5778a.Rfc5778aProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.rfc5778i.Rfc5778iProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.ro.RoProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.rx.RxProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s13.S13ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s15.S15ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s6a.S6aProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s6b.S6bProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s6c.S6cProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s6m.S6mProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s6t.S6tProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s7a.S7aProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s9.S9ProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s9a.S9aProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.sgd.SgdProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.s9atag.S9atagProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.sd.SdProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.slg.SlgProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.sh.ShProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.slh.SlhProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.sta.StaProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.swa.SwaProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.swd.SwdProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.sy.SyProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.app.st.StProviderImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerWithSessionImpl;
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
	
	private ConcurrentHashMap<String,DiameterProvider<?, ?, ?, ?, ?>> registeredProvidersByPackage=new ConcurrentHashMap<String,DiameterProvider<?, ?, ?, ?, ?>>();
	
	private ConcurrentHashMap<CommandCode, AtomicLong> messagesSentByType = new ConcurrentHashMap<CommandCode, AtomicLong>();
	private ConcurrentHashMap<CommandCode, AtomicLong> messagesReceivedByType = new ConcurrentHashMap<CommandCode, AtomicLong>();
	private ConcurrentHashMap<Long, AtomicLong> errorsSentByType = new ConcurrentHashMap<Long, AtomicLong>();
	private ConcurrentHashMap<Long, AtomicLong> errorsReceivedByType = new ConcurrentHashMap<Long, AtomicLong>();
	private ConcurrentHashMap<ApplicationID, AtomicLong> outgoingSessionsByApplication = new ConcurrentHashMap<ApplicationID, AtomicLong>();
	private ConcurrentHashMap<ApplicationID, AtomicLong> incomingSessionsByApplication = new ConcurrentHashMap<ApplicationID, AtomicLong>();
	
	private ConcurrentHashMap<Long, AtomicLong> sessionsEndedByResultCode = new ConcurrentHashMap<Long, AtomicLong>();
	private ConcurrentHashMap<ApplicationID, ConcurrentHashMap<Long, AtomicLong>> sessionsEndedByResultCodeAndApplication = new ConcurrentHashMap<ApplicationID, ConcurrentHashMap<Long, AtomicLong>>();
		
	private ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>> messagesSentByTypeAndApplication=new ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>>();
	private ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>> messagesReceivedByTypeAndApplication=new ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>>();
	private ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>> errorsSentByTypeAndApplication=new ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>>();
	private ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>> errorsReceivedByTypeAndApplication=new ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>>();
    
	private ConcurrentHashMap<String,ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>>> messagesSentByLinkTypeAndApplication=new ConcurrentHashMap<String,ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>>>();
	private ConcurrentHashMap<String,ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>>> messagesReceivedByLinkTypeAndApplication=new ConcurrentHashMap<String,ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>>>();
	private ConcurrentHashMap<String,ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>>> errorsSentByLinkTypeAndApplication=new ConcurrentHashMap<String,ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>>>();
	private ConcurrentHashMap<String,ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>>> errorsReceivedByLinkTypeAndApplication=new ConcurrentHashMap<String,ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>>>();
    
	protected DiameterSessionStorage sessionStorage;
	protected IncomingRequestsStorage incomingRequestsStorage;
	
	private Long responseTimeout = DEFAULT_RESPONSE_TIMEOUT;
	private Long idleTimeout = DEFAULT_IDLE_TIMEOUT;
	private Long duplicateTimeout = 0L;
	private Long duplicatesCheckPeriod = 0L;
	
	private CountableQueue<Task> queue;
	private PeriodicQueuedTasks<Timer> periodicQueue;
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
	
	private ClassLoader classLoader;
	
	public static List<String> allCommands=new ArrayList<String>();
	public static List<String> allApplications=new ArrayList<String>();
    
	private Boolean isSessionLess;
	private DiameterParser globalParser;
	
    static
    {
    	for(CommandCode commandCode:CommandCode.values())
    		allCommands.add(commandCode.name());
        
    	allCommands.add("UNKNOWN"); 
    	
    	for(ApplicationID applicationID:ApplicationID.values())
    		allApplications.add(applicationID.name());
        
    	allApplications.add("UNKNOWN"); 
    }
    
	protected DiameterStackImpl(ClassLoader classLoader, IDGenerator<?> idGenerator,CountableQueue<Task> queue, PeriodicQueuedTasks<Timer> periodicQueue,int workerThreads,String localHost, String productName, Long vendorId,Long firmwareRevision, Long idleTimeout, Long responseTimeout, Long reconnectTimeout, Long duplicateTimeout, Long duplicatesCheckPeriod, Boolean sessionLess) throws Exception
	{
		this.isSessionLess = sessionLess;
		this.classLoader = classLoader;
		this.idGenerator = idGenerator;
		this.queue = queue;
		this.periodicQueue = periodicQueue;
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
		
		this.globalParser = new DiameterParser(classLoader, Arrays.asList(new Class<?>[] { DiameterErrorAnswerImpl.class , DiameterErrorAnswerWithSessionImpl.class }),Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		this.globalParser.registerApplication(classLoader, Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.common"));
		this.networkManager = new NetworkManagerImpl(this, workerThreads, idleTimeout, this.responseTimeout, reconnectTimeout);
		this.stackID = idGenerator.generateID();
	}
    
    public DiameterStackImpl(ClassLoader classLoader, IDGenerator<?> idGenerator,CountableQueue<Task> queue, PeriodicQueuedTasks<Timer> periodicQueue,int workerThreads,String localHost, String productName, Long vendorId,Long firmwareRevision, Long idleTimeout, Long responseTimeout, Long reconnectTimeout, Long duplicateTimeout, Long duplicatesCheckPeriod) throws Exception
	{
    	this(classLoader, idGenerator, queue, periodicQueue, workerThreads, localHost, productName, vendorId, firmwareRevision, idleTimeout, responseTimeout, reconnectTimeout, duplicateTimeout, duplicatesCheckPeriod, false);
    	
    	sessionStorage = new LocalDiameterSessionStorageImpl(this);
		incomingRequestsStorage = new LocalIncomingRequestsStorageImpl(this);				
	}
	
	public DiameterStackImpl(ClassLoader classLoader, IDGenerator<?> idGenerator,CountableQueue<Task> queue, PeriodicQueuedTasks<Timer> periodicQueue,int workerThreads,String localHost, String productName, Long vendorId,Long firmwareRevision, Long idleTimeout, Long responseTimeout, Long reconnectTimeout, Long duplicateTimeout, Long duplicatesCheckPeriod, Boolean sessionLess, DiameterSessionStorage sessionStorage, IncomingRequestsStorage incomingRequestsStorage) throws Exception
	{
		this(classLoader, idGenerator, queue, periodicQueue, workerThreads, localHost, productName, vendorId, firmwareRevision, idleTimeout, responseTimeout, reconnectTimeout, duplicateTimeout, duplicatesCheckPeriod, false);
    	
    	this.sessionStorage = sessionStorage;
		this.incomingRequestsStorage = incomingRequestsStorage;		
	}
	
	@Override
	public void registerCustomProvider(DiameterProvider<?,?,?,?,?> provider,Package parentPackage)
	{
		if(isSessionLess)
			return;
		
		registeredProvidersByPackage.putIfAbsent(parentPackage.getName(), provider);
	}
	
	//its not required to create the providers from here, they may be created as needed
	@Override
	public DiameterProvider<?, ?, ?, ?, ?> getProvider(Long applicationID, Package parentPackage)
	{
		if(isSessionLess)
			return null;
		
		if(parentPackage==null)
			return null;
		
		DiameterProvider<?, ?, ?, ?, ?> provider = registeredProvidersByPackage.get(parentPackage.getName());
		if(provider != null)
			return provider;
		
		//TODO:create providers when exists
		
		switch(applicationID.intValue())
		{
			case ApplicationIDs.COMMON:
				break;
			case ApplicationIDs.NASREQ:
				if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.gi"))
				{
					GiProviderImpl giProvider=new GiProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), giProvider);
					return giProvider;
				}
				else if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.nas"))
				{
					NasProviderImpl nasProvider=new NasProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), nasProvider);
					return nasProvider;
				}
				break;
			case ApplicationIDs.MOBILE_IPV4:
				RFC4004ProviderImpl rfc4004Provider=new RFC4004ProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), rfc4004Provider);
				return rfc4004Provider;
			case ApplicationIDs.ACCOUNTING:
				RfProviderImpl rfProvider=new RfProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), rfProvider);
				return rfProvider;
			case ApplicationIDs.CREDIT_CONTROL:
				if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.ro"))
				{
					RoProviderImpl roProvider=new RoProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), roProvider);
					return roProvider;					
				}
				else if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.gy"))
				{
					GyProviderImpl gyProvider=new GyProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), gyProvider);
					return gyProvider;
				}
				else if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.creditcontrol"))
				{
					CreditControlProviderImpl creditControlProvider=new CreditControlProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), creditControlProvider);
					return creditControlProvider;
				}
				else if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.ericsson"))
				{
					EricssonCreditControlProviderImpl ericssonCreditControlProvider=new EricssonCreditControlProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), ericssonCreditControlProvider);
					return ericssonCreditControlProvider;
				}
				else if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.huawei"))
				{
					HuaweiCreditControlProviderImpl huaweiCreditControlProvider=new HuaweiCreditControlProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), huaweiCreditControlProvider);
					return huaweiCreditControlProvider;
				}
				break;
			case ApplicationIDs.EAP:				
				EAPProviderImpl eapProvider=new EAPProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), eapProvider);
				return eapProvider;
			case ApplicationIDs.SIP_APPLICATION:
				Rfc4740ProviderImpl rfc4740Provider=new Rfc4740ProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), rfc4740Provider);
				return rfc4740Provider;
			case ApplicationIDs.MIP6I:
				Rfc5778iProviderImpl rfc5778iProvider=new Rfc5778iProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), rfc5778iProvider);
				return rfc5778iProvider;
			case ApplicationIDs.MIP6A:
				Rfc5778aProviderImpl rfc5778aProvider=new Rfc5778aProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), rfc5778aProvider);
				return rfc5778aProvider;		
			case ApplicationIDs.CX_DX:
				CxDxProviderImpl cxDxProvider=new CxDxProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), cxDxProvider);
				return cxDxProvider;				
			case ApplicationIDs.SH:
				ShProviderImpl shProvider=new ShProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), shProvider);
				return shProvider;
			case ApplicationIDs.GQ:
				if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.gq"))
				{
					GqProviderImpl gqProvider=new GqProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), gqProvider);
					return gqProvider;
				}
				else if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.gqtag"))
				{
					GqTagProviderImpl gqTagProvider=new GqTagProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), gqTagProvider);
					return gqTagProvider;
				}
				break;
			case ApplicationIDs.GMB:
				GMBProviderImpl gmbProvider=new GMBProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), gmbProvider);
				return gmbProvider;
			case ApplicationIDs.MM10:
				MM10ProviderImpl mm10Provider=new MM10ProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), mm10Provider);
				return mm10Provider;
			case ApplicationIDs.E4:
				E4ProviderImpl e4Provider=new E4ProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), e4Provider);
				return e4Provider;
			case ApplicationIDs.MB2C:
				Mb2cProviderImpl mb2cProvider=new Mb2cProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), mb2cProvider);
				return mb2cProvider;
			case ApplicationIDs.RX:
				RxProviderImpl rxProvider=new RxProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), rxProvider);
				return rxProvider;
			case ApplicationIDs.GX:
				GxProviderImpl gxProvider=new GxProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), gxProvider);
				return gxProvider;
			case ApplicationIDs.STA:
				if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.sta"))
				{
					StaProviderImpl staProvider=new StaProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), staProvider);
					return staProvider;
				}
				else if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.swa"))
				{
					SwaProviderImpl swaProvider=new SwaProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), swaProvider);
					return swaProvider;
				}
				else if(parentPackage.getName().equals("com.mobius.software.telco.protocols.diameter.commands.swd"))
				{
					SwdProviderImpl swdProvider=new SwdProviderImpl(this, parentPackage.getName());
					registeredProvidersByPackage.put(parentPackage.getName(), swdProvider);
					return swdProvider;
				}
			case ApplicationIDs.S6A:
				S6aProviderImpl s6aProvider=new S6aProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s6aProvider);
				return s6aProvider;
			case ApplicationIDs.S13:
				S13ProviderImpl s13Provider=new S13ProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s13Provider);
				return s13Provider;
			case ApplicationIDs.S15:
				S15ProviderImpl s15Provider=new S15ProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s15Provider);
				return s15Provider;	
			case ApplicationIDs.SLG:
				SlgProviderImpl slgProvider=new SlgProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), slgProvider);
				return slgProvider;
			case ApplicationIDs.SWM:
				break;
			case ApplicationIDs.SWX:
				break;
			case ApplicationIDs.GXX:
				GxxProviderImpl gxxProvider=new GxxProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), gxxProvider);
				return gxxProvider;
			case ApplicationIDs.S9:
				S9ProviderImpl s9Provider=new S9ProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s9Provider);
				return s9Provider;
			case ApplicationIDs.S6B:
				S6bProviderImpl s6bProvider=new S6bProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s6bProvider);
				return s6bProvider;
			case ApplicationIDs.SLH:
				SlhProviderImpl slhProvider=new SlhProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), slhProvider);
				return slhProvider;
			case ApplicationIDs.SGMB:
				break;
			case ApplicationIDs.SY:
				SyProviderImpl syProvider=new SyProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), syProvider);
				return syProvider;
			case ApplicationIDs.SD:
				SdProviderImpl sdProvider=new SdProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), sdProvider);
				return sdProvider;
			case ApplicationIDs.S7A:
				S7aProviderImpl s7aProvider=new S7aProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s7aProvider);
				return s7aProvider;
			case ApplicationIDs.TSP:
				break;
			case ApplicationIDs.S6M:
				S6mProviderImpl s6mProvider=new S6mProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s6mProvider);
				return s6mProvider;
			case ApplicationIDs.T4:
				break;
			case ApplicationIDs.S6C:
				S6cProviderImpl s6cProvider=new S6cProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s6cProvider);
				return s6cProvider;
			case ApplicationIDs.SGD:
				SgdProviderImpl sgdProvider=new SgdProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), sgdProvider);
				return sgdProvider;
			case ApplicationIDs.S9A:
				S9aProviderImpl s9aProvider=new S9aProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s9aProvider);
				return s9aProvider;
			case ApplicationIDs.S9ATAG:
				S9atagProviderImpl s9atagProvider=new S9atagProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s9atagProvider);
				return s9atagProvider;
			case ApplicationIDs.PC4A:
				PC4AProviderImpl pc4aProvider=new PC4AProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), pc4aProvider);
				return pc4aProvider;
			case ApplicationIDs.PC6:
				PC6ProviderImpl pc6Provider=new PC6ProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), pc6Provider);
				return pc6Provider;
			case ApplicationIDs.NP:
				NpProviderImpl npProvider=new NpProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), npProvider);
				return npProvider;
			case ApplicationIDs.S6T:
				S6tProviderImpl s6tProvider=new S6tProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), s6tProvider);
				return s6tProvider;
			case ApplicationIDs.T6A:
				break;
			case ApplicationIDs.NT:
				NtProviderImpl ntProvider=new NtProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), ntProvider);
				return ntProvider;
			case ApplicationIDs.NTA:
				NtaProviderImpl ntaProvider=new NtaProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), ntaProvider);
				return ntaProvider;	
			case ApplicationIDs.ST:
				StProviderImpl stProvider=new StProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), stProvider);
				return stProvider;
			case ApplicationIDs.PC2:
				PC2ProviderImpl pc2Provider=new PC2ProviderImpl(this, parentPackage.getName());
				registeredProvidersByPackage.put(parentPackage.getName(), pc2Provider);
				return pc2Provider;
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
	public Map<String, Long> getMessagesSentByType()
	{
		Map<String,Long> result=new HashMap<String, Long>();
		Iterator<Entry<CommandCode, AtomicLong>> iterator=messagesSentByType.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<CommandCode, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey().name(), currEntry.getValue().get());
		}
		
		return result;
	}

	@Override
	public Map<String, Long> getMessagesReceivedByType()
	{
		Map<String,Long> result=new HashMap<String, Long>();
		Iterator<Entry<CommandCode, AtomicLong>> iterator=messagesReceivedByType.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<CommandCode, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey().name(), currEntry.getValue().get());
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
	public Map<String, Long> getOutgoingSessionByApplication()
	{
		Map<String,Long> result=new HashMap<String, Long>();
		Iterator<Entry<ApplicationID, AtomicLong>> iterator=outgoingSessionsByApplication.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<ApplicationID, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey().name(), currEntry.getValue().get());
		}
		
		return result;
	}

	@Override
	public Map<String, Long> getIncomingSessionsByApplication()
	{
		Map<String,Long> result=new HashMap<String, Long>();
		Iterator<Entry<ApplicationID, AtomicLong>> iterator=incomingSessionsByApplication.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<ApplicationID, AtomicLong> currEntry=iterator.next();
			result.put(currEntry.getKey().name(), currEntry.getValue().get());
		}
		
		return result;
	}

	@Override
	public Map<String, Long> getMessagesSentByTypeAndApplication(ApplicationID applicationID)
	{
		Map<String,Long> result=new HashMap<String, Long>();
		Map<CommandCode,AtomicLong> messagesSentByType = messagesSentByTypeAndApplication.get(applicationID);
		if(messagesSentByType!=null) {
			Iterator<Entry<CommandCode, AtomicLong>> iterator=messagesSentByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<CommandCode, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey().name(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<String, Long> getMessagesReceivedByTypeAndApplication(ApplicationID applicationID)
	{
		Map<String,Long> result=new HashMap<String, Long>();
		Map<CommandCode,AtomicLong> messagesReceivedByType = messagesReceivedByTypeAndApplication.get(applicationID);
		if(messagesReceivedByType!=null) {
			Iterator<Entry<CommandCode, AtomicLong>> iterator=messagesReceivedByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<CommandCode, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey().name(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getErrorsSentByTypeAndApplication(ApplicationID applicationID)
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
	public Map<Long, Long> getErrorsReceivedByTypeAndApplication(ApplicationID applicationID)
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
	public Map<String, Long> getLinkMessagesSentByTypeAndApplication(String linkID, ApplicationID applicationID)
	{
		Map<String,Long> result=new HashMap<String, Long>();
		ConcurrentHashMap<ApplicationID, ConcurrentHashMap<CommandCode, AtomicLong>> messagesSentByTypeAndApplication = messagesSentByLinkTypeAndApplication.get(linkID);
		if(messagesSentByTypeAndApplication==null)
			return null;
		
		Map<CommandCode,AtomicLong> messagesSentByType = messagesSentByTypeAndApplication.get(applicationID);
		if(messagesSentByType!=null) {
			Iterator<Entry<CommandCode, AtomicLong>> iterator=messagesSentByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<CommandCode, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey().name(), currEntry.getValue().get());
			}
		}
		
		return result;
	}
    
	@Override
	public Map<String,Long> getLinkMessagesReceivedByTypeAndApplication(String linkID, ApplicationID applicationID)    
    {
		Map<String,Long> result=new HashMap<String, Long>();
		ConcurrentHashMap<ApplicationID, ConcurrentHashMap<CommandCode, AtomicLong>> messagesReceivedByTypeAndApplication = messagesReceivedByLinkTypeAndApplication.get(linkID);
		if(messagesReceivedByTypeAndApplication==null)
			return null;
		
		Map<CommandCode,AtomicLong> messagesReceivedByType = messagesReceivedByTypeAndApplication.get(applicationID);
		if(messagesReceivedByType!=null) {
			Iterator<Entry<CommandCode, AtomicLong>> iterator=messagesReceivedByType.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<CommandCode, AtomicLong> currEntry=iterator.next();
				result.put(currEntry.getKey().name(), currEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<Long, Long> getLinkErrorsSentByTypeAndApplication(String linkID, ApplicationID applicationID)
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		ConcurrentHashMap<ApplicationID, ConcurrentHashMap<Long, AtomicLong>> errorsSentByTypeAndApplication = errorsSentByLinkTypeAndApplication.get(linkID);
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
	public Map<Long, Long> getLinkErrorsReceivedByTypeAndApplication(String linkID, ApplicationID applicationID)
	{
		Map<Long,Long> result=new HashMap<Long, Long>();
		ConcurrentHashMap<ApplicationID, ConcurrentHashMap<Long, AtomicLong>> errorsReceivedByTypeAndApplication = errorsReceivedByLinkTypeAndApplication.get(linkID);
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
	public Map<String, Map<String, Long>> getLinkMessagesSentByTypeAndApplication(String linkID)
	{
		Map<String, Map<String, Long>> result=new HashMap<String, Map<String, Long>>();
		ConcurrentHashMap<ApplicationID, ConcurrentHashMap<CommandCode, AtomicLong>> messagesSentByTypeAndApplication = messagesSentByLinkTypeAndApplication.get(linkID);
		if(messagesSentByTypeAndApplication==null)
			return null;
		
		Iterator<Entry<ApplicationID, ConcurrentHashMap<CommandCode, AtomicLong>>> outerIterator = messagesSentByTypeAndApplication.entrySet().iterator();
		while(outerIterator.hasNext())
		{
			Entry<ApplicationID, ConcurrentHashMap<CommandCode, AtomicLong>> currOuterEntry = outerIterator.next();
			Map<String,Long> currMap = new  HashMap<String, Long>();
			result.put(currOuterEntry.getKey().name(), currMap);
			
			Iterator<Entry<CommandCode, AtomicLong>> innerIterator = currOuterEntry.getValue().entrySet().iterator();
			while(innerIterator.hasNext())
			{
				Entry<CommandCode, AtomicLong> innerEntry = innerIterator.next();
				currMap.put(innerEntry.getKey().name(), innerEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<String, Map<String, Long>> getLinkMessagesReceivedByTypeAndApplication(String linkID)
	{
		Map<String, Map<String, Long>> result=new HashMap<String, Map<String, Long>>();
		ConcurrentHashMap<ApplicationID, ConcurrentHashMap<CommandCode, AtomicLong>> messagesReceivedByTypeAndApplication = messagesReceivedByLinkTypeAndApplication.get(linkID);
		if(messagesReceivedByTypeAndApplication==null)
			return null;
		
		Iterator<Entry<ApplicationID, ConcurrentHashMap<CommandCode, AtomicLong>>> outerIterator = messagesReceivedByTypeAndApplication.entrySet().iterator();
		while(outerIterator.hasNext())
		{
			Entry<ApplicationID, ConcurrentHashMap<CommandCode, AtomicLong>> currOuterEntry = outerIterator.next();
			Map<String,Long> currMap = new  HashMap<String, Long>();
			result.put(currOuterEntry.getKey().name(), currMap);
			
			Iterator<Entry<CommandCode, AtomicLong>> innerIterator = currOuterEntry.getValue().entrySet().iterator();
			while(innerIterator.hasNext())
			{
				Entry<CommandCode, AtomicLong> innerEntry = innerIterator.next();
				currMap.put(innerEntry.getKey().name(), innerEntry.getValue().get());
			}
		}
		
		return result;
	}

	@Override
	public Map<String, Map<Long, Long>> getLinkErrorsSentByTypeAndApplication(String linkID)
	{
		Map<String, Map<Long, Long>> result=new HashMap<String, Map<Long, Long>>();
		ConcurrentHashMap<ApplicationID, ConcurrentHashMap<Long, AtomicLong>> errorsSentByTypeAndApplication = errorsSentByLinkTypeAndApplication.get(linkID);
		if(errorsSentByTypeAndApplication==null)
			return null;
		
		Iterator<Entry<ApplicationID, ConcurrentHashMap<Long, AtomicLong>>> outerIterator = errorsSentByTypeAndApplication.entrySet().iterator();
		while(outerIterator.hasNext())
		{
			Entry<ApplicationID, ConcurrentHashMap<Long, AtomicLong>> currOuterEntry = outerIterator.next();
			Map<Long,Long> currMap = new  HashMap<Long, Long>();
			result.put(currOuterEntry.getKey().name(), currMap);
			
			Iterator<Entry<Long, AtomicLong>> innerIterator = currOuterEntry.getValue().entrySet().iterator();
			while(innerIterator.hasNext())
			{
				Entry<Long, AtomicLong> innerEntry = innerIterator.next();
				currMap.put(innerEntry.getKey(), innerEntry.getValue().get());
			}			
		}
		
		return result;
	}

	@Override
	public Map<String, Map<Long, Long>> getLinkErrorsReceivedByTypeAndApplication(String linkID)
	{
		Map<String, Map<Long, Long>> result=new HashMap<String, Map<Long, Long>>();
		ConcurrentHashMap<ApplicationID, ConcurrentHashMap<Long, AtomicLong>> errorsReceivedByTypeAndApplication = errorsReceivedByLinkTypeAndApplication.get(linkID);
		if(errorsReceivedByTypeAndApplication==null)
			return null;
		
		Iterator<Entry<ApplicationID, ConcurrentHashMap<Long, AtomicLong>>> outerIterator = errorsReceivedByTypeAndApplication.entrySet().iterator();
		while(outerIterator.hasNext())
		{
			Entry<ApplicationID, ConcurrentHashMap<Long, AtomicLong>> currOuterEntry = outerIterator.next();
			Map<Long,Long> currMap = new  HashMap<Long, Long>();
			result.put(currOuterEntry.getKey().name(), currMap);
			
			Iterator<Entry<Long, AtomicLong>> innerIterator = currOuterEntry.getValue().entrySet().iterator();
			while(innerIterator.hasNext())
			{
				Entry<Long, AtomicLong> innerEntry = innerIterator.next();
				currMap.put(innerEntry.getKey(), innerEntry.getValue().get());
			}			
		}
		
		return result;
	}

	@Override
	public void messageReceived(DiameterMessage message, String linkID)
	{
		Integer commandCodeValue=null;
		Long applicationIDValue=null;
		if(message instanceof DiameterErrorAnswerImpl)
		{	
			commandCodeValue = ((DiameterErrorAnswerImpl)message).getCommandCode();
			applicationIDValue = ((DiameterErrorAnswerImpl)message).getApplicationId();
		}
		else if(message instanceof DiameterErrorAnswerWithSessionImpl)
		{
			commandCodeValue = ((DiameterErrorAnswerWithSessionImpl)message).getCommandCode();
			applicationIDValue = ((DiameterErrorAnswerWithSessionImpl)message).getApplicationId();
		}
		else
		{
			DiameterCommandDefinition commandDef = DiameterParser.getCommandDefinition(message.getClass());
			if(commandDef==null)
				return;
			
			commandCodeValue = commandDef.commandCode();
			applicationIDValue = commandDef.applicationId();
		}
		
		CommandCode commandCode = CommandCode.fromInt(commandCodeValue);
		if(commandCode==null)
			return;
		
		AtomicLong counter = messagesReceivedByType.get(commandCode);
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesReceivedByType.putIfAbsent(commandCode, counter);
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
			}
		}
		
		ApplicationID applicationID = ApplicationID.fromInt(applicationIDValue.intValue());
		if(applicationID==null)
			return;
		
		ConcurrentHashMap<CommandCode, AtomicLong> messagesReceivedByType = messagesReceivedByTypeAndApplication.get(applicationID);
		if(messagesReceivedByType == null)
		{
			messagesReceivedByType = new ConcurrentHashMap<CommandCode, AtomicLong>();
			ConcurrentHashMap<CommandCode, AtomicLong> oldMap = messagesReceivedByTypeAndApplication.putIfAbsent(applicationID, messagesReceivedByType);
			if(oldMap!=null)
				messagesReceivedByType = oldMap;								
		}
		
		counter = messagesReceivedByType.get(commandCode);
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesReceivedByType.putIfAbsent(commandCode, counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
		
		ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>> messagesReceivedByTypeAndApplication = messagesReceivedByLinkTypeAndApplication.get(linkID);
		if(messagesReceivedByTypeAndApplication == null)
		{
			messagesReceivedByTypeAndApplication = new ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>>();
			ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>> oldMap = messagesReceivedByLinkTypeAndApplication.putIfAbsent(linkID, messagesReceivedByTypeAndApplication);
			if(oldMap!=null)
				messagesReceivedByTypeAndApplication = oldMap;								
		}
		
		messagesReceivedByType = messagesReceivedByTypeAndApplication.get(applicationID);
		if(messagesReceivedByType == null)
		{
			messagesReceivedByType = new ConcurrentHashMap<CommandCode, AtomicLong>();
			ConcurrentHashMap<CommandCode, AtomicLong> oldMap = messagesReceivedByTypeAndApplication.putIfAbsent(applicationID, messagesReceivedByType);
			if(oldMap!=null)
				messagesReceivedByType = oldMap;								
		}
		
		counter = messagesReceivedByType.get(commandCode);
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesReceivedByType.putIfAbsent(commandCode, counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
		
		if(message instanceof DiameterAnswer)
		{
			DiameterAnswer answer=(DiameterAnswer)message;
			if(answer.getIsError())
			{
				ConcurrentHashMap<Long, AtomicLong> errorsReceivedByType = errorsReceivedByTypeAndApplication.get(applicationID);
				if(errorsReceivedByType == null)
				{
					errorsReceivedByType = new ConcurrentHashMap<Long, AtomicLong>();
					ConcurrentHashMap<Long, AtomicLong> oldMap = errorsReceivedByTypeAndApplication.putIfAbsent(applicationID, errorsReceivedByType);
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
				
				ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>> errorsReceivedByTypeAndApplication = errorsReceivedByLinkTypeAndApplication.get(linkID);
				if(errorsReceivedByTypeAndApplication == null)
				{
					errorsReceivedByTypeAndApplication = new ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>>();
					ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>> oldMap = errorsReceivedByLinkTypeAndApplication.putIfAbsent(linkID, errorsReceivedByTypeAndApplication);
					if(oldMap!=null)
						errorsReceivedByTypeAndApplication = oldMap;								
				}
				
				errorsReceivedByType = errorsReceivedByTypeAndApplication.get(applicationID);
				if(errorsReceivedByType == null)
				{
					errorsReceivedByType = new ConcurrentHashMap<Long, AtomicLong>();
					ConcurrentHashMap<Long, AtomicLong> oldMap = errorsReceivedByTypeAndApplication.putIfAbsent(applicationID, errorsReceivedByType);
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
		Integer commandCodeValue=null;
		Long applicationIDValue=null;
		if(message instanceof DiameterErrorAnswerImpl)
		{	
			commandCodeValue = ((DiameterErrorAnswerImpl)message).getCommandCode();
			applicationIDValue = ((DiameterErrorAnswerImpl)message).getApplicationId();
		}
		else if(message instanceof DiameterErrorAnswerWithSessionImpl)
		{
			commandCodeValue = ((DiameterErrorAnswerWithSessionImpl)message).getCommandCode();
			applicationIDValue = ((DiameterErrorAnswerWithSessionImpl)message).getApplicationId();
		}
		else
		{
			DiameterCommandDefinition commandDef = DiameterParser.getCommandDefinition(message.getClass());
			if(commandDef==null)
				return;
			
			commandCodeValue = commandDef.commandCode();
			applicationIDValue = commandDef.applicationId();
		}
		
		CommandCode commandCode = CommandCode.fromInt(commandCodeValue);
		if(commandCode==null)
			return;
		
		AtomicLong counter = messagesSentByType.get(commandCode);
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesSentByType.putIfAbsent(commandCode, counter);
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
			}
		}
		
		ApplicationID applicationID = ApplicationID.fromInt(applicationIDValue.intValue());
		if(applicationID==null)
			return;
		
		ConcurrentHashMap<CommandCode, AtomicLong> messagesSentByType = messagesSentByTypeAndApplication.get(applicationID);
		if(messagesSentByType == null)
		{
			messagesSentByType = new ConcurrentHashMap<CommandCode, AtomicLong>();
			ConcurrentHashMap<CommandCode, AtomicLong> oldMap = messagesSentByTypeAndApplication.putIfAbsent(applicationID, messagesSentByType);
			if(oldMap!=null)
				messagesSentByType = oldMap;								
		}
		
		counter = messagesSentByType.get(commandCode);
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesSentByType.putIfAbsent(commandCode, counter);
			if(oldCounter != null)
				counter = oldCounter;
		}
		
		counter.incrementAndGet();
		
		ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>> messagesSentByTypeAndApplication = messagesSentByLinkTypeAndApplication.get(linkID);
		if(messagesSentByTypeAndApplication == null)
		{
			messagesSentByTypeAndApplication = new ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>>();
			ConcurrentHashMap<ApplicationID,ConcurrentHashMap<CommandCode, AtomicLong>> oldMap = messagesSentByLinkTypeAndApplication.putIfAbsent(linkID, messagesSentByTypeAndApplication);
			if(oldMap!=null)
				messagesSentByTypeAndApplication = oldMap;								
		}
		
		messagesSentByType = messagesSentByTypeAndApplication.get(applicationID);
		if(messagesSentByType == null)
		{
			messagesSentByType = new ConcurrentHashMap<CommandCode, AtomicLong>();
			ConcurrentHashMap<CommandCode, AtomicLong> oldMap = messagesSentByTypeAndApplication.putIfAbsent(applicationID, messagesSentByType);
			if(oldMap!=null)
				messagesSentByType = oldMap;								
		}
		
		counter = messagesSentByType.get(commandCode);
		if(counter == null)
		{
			counter = new AtomicLong(0);
			AtomicLong oldCounter = messagesSentByType.putIfAbsent(commandCode, counter);
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
				
				ConcurrentHashMap<Long, AtomicLong> errorsSentByType = errorsSentByTypeAndApplication.get(applicationID);
				if(errorsSentByType == null)
				{
					errorsSentByType = new ConcurrentHashMap<Long, AtomicLong>();
					ConcurrentHashMap<Long, AtomicLong> oldMap = errorsSentByTypeAndApplication.putIfAbsent(applicationID, errorsSentByType);
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
				
				ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>> errorsSentByTypeAndApplication = errorsSentByLinkTypeAndApplication.get(linkID);
				if(errorsSentByTypeAndApplication == null)
				{
					errorsSentByTypeAndApplication = new ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>>();
					ConcurrentHashMap<ApplicationID,ConcurrentHashMap<Long, AtomicLong>> oldMap = errorsSentByLinkTypeAndApplication.putIfAbsent(linkID, errorsSentByTypeAndApplication);
					if(oldMap!=null)
						errorsSentByTypeAndApplication = oldMap;								
				}
				
				errorsSentByType = errorsSentByTypeAndApplication.get(applicationID);
				if(errorsSentByType == null)
				{
					errorsSentByType = new ConcurrentHashMap<Long, AtomicLong>();
					ConcurrentHashMap<Long, AtomicLong> oldMap = errorsSentByTypeAndApplication.putIfAbsent(applicationID, errorsSentByType);
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
	public void newIncomingSession(ApplicationID applicationID)
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
	public void newOutgoingSession(ApplicationID applicationID)
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
	public Map<Long, Long> getSessionEndedByResultCodeAndApplication(ApplicationID applicationID)
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
	public void sessionEnded(Long resultCode, ApplicationID applicationID)
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

	@Override
	public CountableQueue<Task> getQueue()
	{
		return queue;
	}

	@Override
	public PeriodicQueuedTasks<Timer> getPeriodicQueue()
	{
		return periodicQueue;
	}

	@Override
	public ClassLoader getClassLoader()
	{
		return this.classLoader;
	}
	
	public void registerGlobalApplication(Package providerPackageName, Package packageName) throws DiameterException
	{
		globalParser.registerGlobalApplication(classLoader, providerPackageName, packageName);
	}
	
	public DiameterParser getGlobalParser()
	{
		return globalParser;
	}

	@Override
	public Boolean isSessionLess()
	{
		return isSessionLess;
	}
}