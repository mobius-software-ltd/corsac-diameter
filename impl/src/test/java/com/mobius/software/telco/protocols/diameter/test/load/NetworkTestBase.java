package com.mobius.software.telco.protocols.diameter.test.load;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.restcomm.cluster.IDGenerator;
import org.restcomm.cluster.UUIDGenerator;

import com.mobius.software.common.dal.timers.WorkerPool;
import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.DiameterStack;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.DiameterStackImpl;
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
	protected DiameterStack serverStack;
	protected DiameterStack localStack;
	private WorkerPool workerPool;
	protected IDGenerator<?> generator = new UUIDGenerator();
	
	protected Long idleTimeout = 2000L;
	protected Long responseTimeout = 1000L;
	protected Long reconnectTimeout = 1000L;
	
	protected static final List<String> localLinkIDs = Arrays.asList(new String[] {"1","2","3","4"});
	
	public void setupRemote(Long duplicateTimeout,Long duplicatePeriod) throws Exception
	{
		Configurator.initialize(new DefaultConfiguration());
		
		if(workerPool==null)
		{
			workerPool = new WorkerPool("Diameter");
			workerPool.start(4);
		}
		
		//classes area needed to allow proper loading of packages, otherwise compiler may not see them
		@SuppressWarnings("unused")
		Class<?> roClazz = com.mobius.software.telco.protocols.diameter.impl.commands.mm10.MessageProcessRequestImpl.class;
		
		serverStack=new DiameterStackImpl(this.getClass().getClassLoader(), generator, workerPool, 4, "client.mobius-software.com", "Mobius Diameter", 0L, 10L, idleTimeout, responseTimeout, reconnectTimeout, duplicateTimeout, duplicatePeriod);
		for(String localLinkID:localLinkIDs)
		{
			serverStack.getNetworkManager().addLink(localLinkID, InetAddress.getByName("127.0.0.1"), 13868 + Integer.parseInt(localLinkID),  InetAddress.getByName("127.0.0.1"), 4868 + Integer.parseInt(localLinkID), true, true, "127.0.0.1", "server.mobius-software.com", "127.0.0.1", "client.mobius-software.com", false);
			serverStack.getNetworkManager().registerApplication(localLinkID, Arrays.asList(new VendorSpecificApplicationId[] {}), Arrays.asList(new Long[] { new Long(ApplicationIDs.MM10) }), Arrays.asList(new Long[] {}), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.mm10"), Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.mm10"));
			serverStack.getNetworkManager().startLink(localLinkID);
		}
	}
	
	public void setupLocal(Long duplicateTimeout,Long duplicatePeriod) throws Exception
	{
		if(workerPool==null)
		{
			workerPool = new WorkerPool("Diameter");
			workerPool.start(4);
		}
		
		//classes area needed to allow proper loading of packages, otherwise compiler may not see them
		@SuppressWarnings("unused")
		Class<?> roClazz = com.mobius.software.telco.protocols.diameter.impl.commands.mm10.MessageProcessRequestImpl.class;
		
		localStack=new DiameterStackImpl(this.getClass().getClassLoader(), generator, workerPool, 4, "client.mobius-software.com", "Mobius Diameter", 0L, 10L, idleTimeout, responseTimeout, reconnectTimeout, duplicateTimeout, duplicatePeriod);
		for(String localLinkID:localLinkIDs)
		{
			localStack.getNetworkManager().addLink(localLinkID, InetAddress.getByName("127.0.0.1"), 4868 + Integer.parseInt(localLinkID),  InetAddress.getByName("127.0.0.1"), 13868 + Integer.parseInt(localLinkID), false, true, "127.0.0.1", "client.mobius-software.com", "127.0.0.1", "server.mobius-software.com", false);
			localStack.getNetworkManager().registerApplication(localLinkID, Arrays.asList(new VendorSpecificApplicationId[] {}), Arrays.asList(new Long[] { new Long(ApplicationIDs.MM10) }), Arrays.asList(new Long[] {}), Package.getPackage("com.mobius.software.telco.protocols.diameter.commands.mm10"), Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.mm10"));
			localStack.getNetworkManager().startLink(localLinkID);		
		}
	}
	
	public void stopRemote() throws Exception
	{
		if(serverStack!=null)
		{
			serverStack.stop();
			serverStack = null;
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