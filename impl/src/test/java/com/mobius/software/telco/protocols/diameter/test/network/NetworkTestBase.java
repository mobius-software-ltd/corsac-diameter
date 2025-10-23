package com.mobius.software.telco.protocols.diameter.test.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Arrays;

import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.jdiameter.api.rf.ServerRfSessionListener;
import org.jdiameter.api.ro.ServerRoSessionListener;
import org.restcomm.cluster.IDGenerator;
import org.restcomm.cluster.UUIDGenerator;

import com.mobius.software.common.dal.timers.WorkerPool;
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterStackImpl;
import com.mobius.software.telco.protocols.diameter.primitives.common.DisconnectCauseEnum;
import com.mobius.software.telco.protocols.diameter.primitives.common.VendorSpecificApplicationId;
/*
 * Mobius Software LTD
 * Copyright 2019 - 2023, Mobius Software LTD and individual contributors
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

/**
*
* @author yulian oifa
*
*/
public class NetworkTestBase
{
	protected JDiameterStackWrapper peerStack;
	protected DiameterStack localStack;
	private WorkerPool workerPool;
	protected IDGenerator<?> generator = new UUIDGenerator();
	
	protected Long idleTimeout = 1000L;
	protected Long responseTimeout = 1000L;
	protected Long reconnectTimeout = 1000L;
	
	protected static final String localLinkID = "1";
	
	public void setupRemote(ServerRoSessionListener sessionRoListener,ServerRfSessionListener sessionRfListener) throws Exception
	{
		Configurator.initialize(new DefaultConfiguration());
		
		File f = new File(this.getClass().getClassLoader().getResource("jdiameter-config.xml").getPath());
		InputStream targetStream = null;
		try 
		{
			targetStream = new FileInputStream(f);
			peerStack = new JDiameterStackWrapper(targetStream, sessionRoListener, sessionRfListener);
			peerStack.start();
		}
		finally 
		{
			if(targetStream!=null)
				targetStream.close();
		}	
		
		try
		{
			Thread.sleep(reconnectTimeout * 2);
		}
		catch(InterruptedException ex)
		{
			
		}		
	}
	
	public void setupLocal() throws Exception
	{
		workerPool = new WorkerPool("Diameter");
		workerPool.start(4);

		//classes area needed to allow proper loading of packages, otherwise compiler may not see them
		@SuppressWarnings("unused")
		Class<?> roClazz = com.mobius.software.telco.protocols.diameter.impl.commands.ro.CreditControlRequestImpl.class;
		@SuppressWarnings("unused")
		Class<?> rfClazz = com.mobius.software.telco.protocols.diameter.impl.commands.rf.AccountingRequestImpl.class;
		
		localStack=new DiameterStackImpl(this.getClass().getClassLoader(), generator, workerPool, 4, "client.restcomm.org", "Mobius Diameter", 0L, 10L, idleTimeout, responseTimeout, reconnectTimeout, 0L, 0L);
		localStack.getNetworkManager().addLink(localLinkID, InetAddress.getByName("127.0.0.1"), 4868,  InetAddress.getByName("127.0.0.1"), 13868, false, true, "127.0.0.1", "client.restcomm.org", "127.0.0.1", "server.restcomm.org", false);
		localStack.getNetworkManager().registerApplication(localLinkID, Arrays.asList(new VendorSpecificApplicationId[] {}), Arrays.asList(new Long[] { new Long(ApplicationIDs.CREDIT_CONTROL) }), Arrays.asList(new Long[] {}), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.ro"), Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.ro"));
		localStack.getNetworkManager().registerApplication(localLinkID, Arrays.asList(new VendorSpecificApplicationId[] {}), Arrays.asList(new Long[] {}), Arrays.asList(new Long[] { new Long(ApplicationIDs.ACCOUNTING) }), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.rf"), Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.rf"));
		localStack.getNetworkManager().startLink(localLinkID);		
	}
	
	public void setupLocalWithImproperApplications() throws Exception
	{
		workerPool = new WorkerPool("Diameter");
		workerPool.start(4);

		//classes area needed to allow proper loading of packages, otherwise compiler may not see them
		@SuppressWarnings("unused")
		Class<?> roClazz = com.mobius.software.telco.protocols.diameter.impl.commands.s6t.ConfigurationInformationRequestImpl.class;
		
		localStack=new DiameterStackImpl(this.getClass().getClassLoader(), generator, workerPool, 4, "client.restcomm.org", "Mobius Diameter", 0L, 10L, idleTimeout, responseTimeout, reconnectTimeout, 0L, 0L);
		localStack.getNetworkManager().addLink(localLinkID, InetAddress.getByName("127.0.0.1"), 4868,  InetAddress.getByName("127.0.0.1"), 13868, false, true, "127.0.0.1", "client.restcomm.org", "127.0.0.1", "server.restcomm.org", false);
		localStack.getNetworkManager().registerApplication(localLinkID, Arrays.asList(new VendorSpecificApplicationId[] {}), Arrays.asList(new Long[] { new Long(ApplicationIDs.S6T) }), Arrays.asList(new Long[] {}), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.s6t"), Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s6t"));
		localStack.getNetworkManager().startLink(localLinkID);		
	}
	
	public void stopRemote() throws Exception
	{
		if(peerStack!=null)
		{
			peerStack.loadConnections();
			peerStack.stop(DisconnectCauseEnum.REBOOTING.getValue());
			peerStack.destroy();
			peerStack.terminate();
			peerStack = null;
		}				
	}
	
	public void stopLocal() throws DiameterException
	{
		if(localStack!=null)
		{
			localStack.stop();
			localStack = null;
		}			
	}
}