package com.mobius.software.telco.protocols.diameter.test.parser;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.commands.common.CapabilitiesExchangeRequestmpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.CreditControlRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.cxdx.LocationInfoRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.e4.PushNotificationsRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.eap.EAPRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gi.AccountingRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gmb.AARequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.common.AcctApplicationIdImpl;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;

public class LoadingTest
{
	@Test
	public void testCommon() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = CapabilitiesExchangeRequestmpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.common"));		
	}
	
	@Test
	public void testCreditControl() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = CreditControlRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol"));		
	}
	
	@Test
	public void testCreditControlHuawei() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.huawei.CreditControlRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.huawei"));		
	}
	
	@Test
	public void testCreditControlEricsson() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.ericsson.CreditControlRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.creditcontrol.ericsson"));		
	}
	
	@Test
	public void testCxDx() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = LocationInfoRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.cxdx"));		
	}
	
	@Test
	public void testE4() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = PushNotificationsRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.e4"));		
	}
	
	@Test
	public void testEap() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = EAPRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.eap"));		
	}
	
	@Test
	public void testGi() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = AccountingRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.gi"));		
	}
	
	@Test
	public void testGmb() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = AARequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.gmb"));		
	}
	
	@Test
	public void testGq() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.gq.AARequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.gq"));		
	}
	
	@Test
	public void testGqTag() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.gqtag.AARequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.gqtag"));		
	}
	
	@Test
	public void testGx() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.gx.CreditControlRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.gx"));		
	}
	
	@Test
	public void testGxx() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.gxx.CreditControlRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.gxx"));		
	}
	
	@Test
	public void testMB2C() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.mb2c.GCSActionRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.mb2c"));		
	}
	
	@Test
	public void testMM10() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.mm10.MessageProcessRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.gxx"));		
	}
	
	@Test
	public void testNas() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.nas.AccountingRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.nas"));		
	}
	
	@Test
	public void testNp() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.np.NonAggregatedRUCIReportRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.np"));		
	}
	
	@Test
	public void testNt() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.nt.BackgroundDataTransferRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.nt"));		
	}
	
	@Test
	public void testPC2() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.pc2.ProXimityActionRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.pc2"));		
	}
	
	@Test
	public void testPC4A() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.pc4a.ProSeInitialLocationInformationRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.pc4a"));		
	}
	
	@Test
	public void testPC6() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.pc6.ProSeAlertRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.pc6"));		
	}
	
	@Test
	public void testRf() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.rf.AccountingRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.rf"));		
	}
	
	@Test
	public void testRfc4004() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004.AAMobileNodeRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.rfc4004"));		
	}
	
	@Test
	public void testRfc4740() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740.MultimediaAuthRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.rfc4740"));		
	}
	
	@Test
	public void testRfc5778() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778.MIP6RequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.rfc5778"));		
	}
	
	@Test
	public void testRo() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.ro.CreditControlRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.ro"));		
	}
	
	@Test
	public void testRx() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.rx.AARequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.rx"));		
	}
	
	@Test
	public void testS13() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.s13.MEIdentityCheckRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s13"));		
	}
	
	@Test
	public void testS6A() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.s6a.CancelLocationRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s6a"));		
	}
	
	@Test
	public void testS6B() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.s6b.EAPRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s6b"));		
	}
	
	@Test
	public void testS6C() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.s6c.AlertServiceCentreRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s6c"));		
	}
	
	@Test
	public void testS6M() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.s6m.SubscriberInformationRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s6m"));		
	}
	
	@Test
	public void testS6T() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.s6t.ReportingInformationRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s6t"));		
	}
	
	@Test
	public void testS7A() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.s7a.InsertSubscriberDataRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s7a"));		
	}
	
	@Test
	public void testS9() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.s9.CreditControlRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s9"));		
	}
	
	@Test
	public void testS9A() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.s9a.CreditControlRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s9a"));		
	}
	
	@Test
	public void testS9ATag() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.s9atag.CreditControlRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.s9atag"));		
	}
	
	@Test
	public void testSd() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.sd.CreditControlRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.sd"));		
	}
	
	@Test
	public void testSgd() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.sgd.MOForwardShortMessageRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.sgd"));		
	}
	
	@Test
	public void testSgmb() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.sgmb.ReAuthRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.sgmb"));		
	}
	
	@Test
	public void testSh() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.sh.PushNotificationsRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.sh"));		
	}
	
	@Test
	public void testSlg() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.slg.LocationReportRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.slg"));		
	}
	
	@Test
	public void testSlh() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.slh.LCSRoutingInfoRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.slh"));		
	}
	
	@Test
	public void testSt() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.st.TDFSessionRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.st"));		
	}
	
	@Test
	public void testSta() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.sta.EAPRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.sta"));		
	}
	
	@Test
	public void testSwa() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.swa.EAPRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.swa"));		
	}
	
	@Test
	public void testSwd() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.swd.EAPRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.swd"));		
	}
	
	@Test
	public void testSwm() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.swm.EAPRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.swm"));		
	}
	
	@Test
	public void testSwx() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.swx.MultimediaAuthRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.swx"));		
	}
	
	@Test
	public void testSy() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.sy.SpendingLimitRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.sy"));		
	}
	
	@Test
	public void testT4() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.t4.DeliveryReportRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.t4"));		
	}
	
	@Test
	public void testT6A() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.t6a.ConfigurationInformationRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.t6a"));		
	}
	
	@Test
	public void testTsp() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser();
		
		//make sure classes are loaded
		Class<?> clazz = com.mobius.software.telco.protocols.diameter.impl.commands.tsp.DeviceActionRequestImpl.class;
		Class<?> avpClass = AcctApplicationIdImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerAvps(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		diameterParser.registerApplication(Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.tsp"));		
	}
}