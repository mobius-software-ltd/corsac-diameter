package com.mobius.software.telco.protocols.diameter.test.parser;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Test;

import com.mobius.software.telco.protocols.diameter.ApplicationIDs;
import com.mobius.software.telco.protocols.diameter.ResultCodes;
import com.mobius.software.telco.protocols.diameter.VendorIDs;
import com.mobius.software.telco.protocols.diameter.commands.DiameterMessage;
import com.mobius.software.telco.protocols.diameter.commands.gx.CreditControlAnswer;
import com.mobius.software.telco.protocols.diameter.commands.gx.CreditControlRequest;
import com.mobius.software.telco.protocols.diameter.exceptions.DiameterException;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.DiameterErrorAnswerWithSessionImpl;
import com.mobius.software.telco.protocols.diameter.impl.commands.gx.CreditControlRequestImpl;
import com.mobius.software.telco.protocols.diameter.impl.primitives.gx.AllocationRetentionPriorityImpl;
import com.mobius.software.telco.protocols.diameter.parser.DiameterParser;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.CcRequestTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.SubscriptionIdTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.creditcontrol.UserEquipmentInfoTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerControlModeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerOperationEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.BearerUsageEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.EventTriggerEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.IPCANTypeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSClassIdentifierEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.QoSUpgradeEnum;
import com.mobius.software.telco.protocols.diameter.primitives.gx.RATTypeEnum;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class GxCreditControlTest
{
	//this is original message from capture , it has 6 headers out of standard order which are shown in separate rows
	private ByteBuf creditControlRequestMessage=Unpooled.wrappedBuffer(new byte[] {0x01 ,0x00 ,0x02 ,(byte)0xec ,(byte)0xc0 ,0x00 ,0x01 ,0x10 ,0x01 ,0x00 ,0x00 ,0x16 ,(byte)0xef ,(byte)0xeb ,(byte)0xb9 ,0x55 ,(byte)0x93 ,(byte)0xc4 ,0x26 ,0x5f ,0x00 ,0x00 ,0x01 ,0x07 ,0x40 ,0x00 ,0x00 ,0x2c ,0x63 ,0x30 ,0x2d ,0x31 ,0x37 ,0x32 ,0x2d ,0x32 ,0x35 ,0x2d ,0x33 ,0x37 ,0x2d ,0x33 ,0x2d ,0x67 ,0x67 ,0x73 ,0x6e ,0x39 ,0x37 ,0x31 ,0x3b ,0x31 ,0x33 ,0x39 ,0x37 ,0x31 ,0x30 ,0x37 ,0x30 ,0x30 ,0x34 ,0x3b ,0x35 ,0x32 ,0x00 ,0x00 ,0x01 ,0x02 ,0x60 ,0x00 ,0x00 ,0x0c ,0x01 ,0x00 ,0x00 ,0x16 ,0x00 ,0x00 ,0x01 ,0x08 ,0x40 ,0x00 ,0x00 ,0x1e ,0x63 ,0x30 ,0x2d ,0x31 ,0x37 ,0x32 ,0x2d ,0x32 ,0x35 ,0x2d ,0x33 ,0x37 ,0x2d ,0x33 ,0x2d ,0x67 ,0x67 ,0x73 ,0x6e ,0x39 ,0x37 ,0x31 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,0x28 ,0x40 ,0x00 ,0x00 ,0x12 ,0x6f ,0x63 ,0x73 ,0x2e ,0x6f ,0x63 ,0x61 ,0x2e ,0x67 ,0x70 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,0x1b ,0x60 ,0x00 ,0x00 ,0x15 ,0x75 ,0x31 ,0x63 ,0x63 ,0x6e ,0x31 ,0x2e ,0x6f ,0x63 ,0x61 ,0x2e ,0x67 ,0x70 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,(byte)0xa0 ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x01 ,(byte)0x9f ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x00 ,
			//Gx Capabilities List - 24 bytes
			0x00 ,0x00 ,0x04 ,0x24 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x00 ,(byte)0xc1 ,0x00 ,0x01 ,0x00 ,0x01 ,
			//MS-Timezone - 16 bytes with padding
			0x00 ,0x00 ,0x00 ,0x17 ,(byte)0xc0 ,0x00 ,0x00 ,0x0e ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x69 ,0x00 ,0x00 ,0x00 ,
			0x00 ,0x00 ,0x01 ,0x16 ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x02 ,0x00 ,0x00 ,0x01 ,(byte)0xbb ,0x60 ,0x00 ,0x00 ,0x28 ,0x00 ,0x00 ,0x01 ,(byte)0xc2 ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,(byte)0xbc ,0x60 ,0x00 ,0x00 ,0x14 ,0x35 ,0x39 ,0x36 ,0x36 ,0x39 ,0x36 ,0x33 ,0x31 ,0x30 ,0x33 ,0x36 ,0x34 ,0x00 ,0x00 ,0x01 ,(byte)0xbb ,0x60 ,0x00 ,0x00 ,0x2c ,0x00 ,0x00 ,0x01 ,(byte)0xc2 ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x01 ,(byte)0xbc ,0x60 ,0x00 ,0x00 ,0x17 ,0x33 ,0x34 ,0x30 ,0x30 ,0x31 ,0x39 ,0x37 ,0x30 ,0x32 ,0x37 ,0x34 ,0x37 ,0x35 ,0x30 ,0x38 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xfc ,(byte)0xc0 ,0x00 ,0x00 ,0x0d ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x35 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xfd ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x00 ,0x08 ,0x60 ,0x00 ,0x00 ,0x0c ,(byte)0xac ,0x1a ,(byte)0xa1 ,0x06 ,0x00 ,0x00 ,0x04 ,0x03 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x15 ,(byte)0xe0 ,0x00 ,0x00 ,0x0d ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x01 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x04 ,0x08 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x03 ,(byte)0xe8 ,0x00 ,0x00 ,0x01 ,(byte)0xca ,0x60 ,0x00 ,0x00 ,0x2c ,0x00 ,0x00 ,0x01 ,(byte)0xcb ,0x20 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,(byte)0xcc ,0x20 ,0x00 ,0x00 ,0x18 ,0x33 ,0x35 ,0x38 ,0x32 ,0x34 ,0x30 ,0x30 ,0x33 ,0x32 ,0x32 ,0x34 ,0x33 ,0x37 ,0x33 ,0x34 ,0x38 ,0x00 ,0x00 ,0x03 ,(byte)0xf8 ,(byte)0xc0 ,0x00 ,0x00 ,0x58 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,
				0x00 ,0x00 ,0x04 ,0x04 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x06 ,
				//Max-Requested-Bandwidth-DL
				0x00 ,0x00 ,0x02 ,0x03 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,(byte)0x83 ,(byte)0xd6 ,0x00 ,
				//Max-Requested-Bandwidth-UL
				0x00 ,0x00 ,0x02 ,0x04 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x3d ,(byte)0x86 ,0x00 ,
				0x00 ,0x00 ,0x04 ,0x0a ,(byte)0xc0 ,0x00 ,0x00 ,0x1c ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x04 ,0x16 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x04 ,0x06 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x00 ,0x12 ,(byte)0xe0 ,0x00 ,0x00 ,0x11 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x33 ,0x34 ,0x30 ,0x30 ,0x31 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x06 ,(byte)0xe0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,(byte)0xc1 ,(byte)0xfb ,(byte)0xa4 ,(byte)0xa1 ,0x00 ,0x00 ,0x00 ,0x1e ,0x60 ,0x00 ,0x00 ,0x11 ,0x6f ,0x63 ,0x73 ,0x70 ,0x72 ,0x6f ,0x64 ,0x67 ,0x70 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xe8 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,(byte)0xf5 ,(byte)0xc0 ,0x00 ,0x00 ,0x12 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x01 ,(byte)0xc1 ,(byte)0xfb ,(byte)0xa4 ,(byte)0x83 ,0x00 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xfe ,(byte)0xc0 ,0x00 ,0x00 ,0x20 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x01 ,(byte)0xf7 ,(byte)0xc0 ,0x00 ,0x00 ,0x14 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x34 ,0x36 ,0x34 ,0x37 ,0x39 ,0x36 ,0x38 ,0x30 ,
			//RAI - 24 bytes with Padding
			0x00 ,0x00 ,0x03 ,(byte)0x8d ,(byte)0xc0 ,0x00 ,0x00 ,0x17 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x33 ,0x34 ,0x30 ,0x30 ,0x31 ,0x66 ,0x66 ,0x66 ,0x65 ,0x66 ,0x66 ,0x00 ,
			//Supported - Features - 56 bytes
			0x00 ,0x00 ,0x02 , 0x74 ,(byte)0x80 ,0x00 ,0x00 ,0x38 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x01 ,0x0a ,0x40 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x02 ,0x75 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x02 ,0x76 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x03
	});
	
	//this is patche message from capture , it has 4 headers in standard order which are shown in separate rows
	private ByteBuf patchedCreditControlRequestMessage=Unpooled.wrappedBuffer(new byte[] {0x01 ,0x00 ,0x02 ,(byte)0xec ,(byte)0xc0 ,0x00 ,0x01 ,0x10 ,0x01 ,0x00 ,0x00 ,0x16 ,(byte)0xef ,(byte)0xeb ,(byte)0xb9 ,0x55 ,(byte)0x93 ,(byte)0xc4 ,0x26 ,0x5f ,0x00 ,0x00 ,0x01 ,0x07 ,0x40 ,0x00 ,0x00 ,0x2c ,0x63 ,0x30 ,0x2d ,0x31 ,0x37 ,0x32 ,0x2d ,0x32 ,0x35 ,0x2d ,0x33 ,0x37 ,0x2d ,0x33 ,0x2d ,0x67 ,0x67 ,0x73 ,0x6e ,0x39 ,0x37 ,0x31 ,0x3b ,0x31 ,0x33 ,0x39 ,0x37 ,0x31 ,0x30 ,0x37 ,0x30 ,0x30 ,0x34 ,0x3b ,0x35 ,0x32 ,0x00 ,0x00 ,0x01 ,0x02 ,0x60 ,0x00 ,0x00 ,0x0c ,0x01 ,0x00 ,0x00 ,0x16 ,0x00 ,0x00 ,0x01 ,0x08 ,0x40 ,0x00 ,0x00 ,0x1e ,0x63 ,0x30 ,0x2d ,0x31 ,0x37 ,0x32 ,0x2d ,0x32 ,0x35 ,0x2d ,0x33 ,0x37 ,0x2d ,0x33 ,0x2d ,0x67 ,0x67 ,0x73 ,0x6e ,0x39 ,0x37 ,0x31 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,0x28 ,0x40 ,0x00 ,0x00 ,0x12 ,0x6f ,0x63 ,0x73 ,0x2e ,0x6f ,0x63 ,0x61 ,0x2e ,0x67 ,0x70 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,0x1b ,0x60 ,0x00 ,0x00 ,0x15 ,0x75 ,0x31 ,0x63 ,0x63 ,0x6e ,0x31 ,0x2e ,0x6f ,0x63 ,0x61 ,0x2e ,0x67 ,0x70 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,(byte)0xa0 ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x01 ,(byte)0x9f ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x00 ,
			0x00 ,0x00 ,0x01 ,0x16 ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x02 ,0x00 ,0x00 ,0x01 ,(byte)0xbb ,0x60 ,0x00 ,0x00 ,0x28 ,0x00 ,0x00 ,0x01 ,(byte)0xc2 ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,(byte)0xbc ,0x60 ,0x00 ,0x00 ,0x14 ,0x35 ,0x39 ,0x36 ,0x36 ,0x39 ,0x36 ,0x33 ,0x31 ,0x30 ,0x33 ,0x36 ,0x34 ,0x00 ,0x00 ,0x01 ,(byte)0xbb ,0x60 ,0x00 ,0x00 ,0x2c ,0x00 ,0x00 ,0x01 ,(byte)0xc2 ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x01 ,(byte)0xbc ,0x60 ,0x00 ,0x00 ,0x17 ,0x33 ,0x34 ,0x30 ,0x30 ,0x31 ,0x39 ,0x37 ,0x30 ,0x32 ,0x37 ,0x34 ,0x37 ,0x35 ,0x30 ,0x38 ,0x00 ,
			//Supported - Features - 56 bytes
			0x00 ,0x00 ,0x02 , 0x74 ,(byte)0x80 ,0x00 ,0x00 ,0x38 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x01 ,0x0a ,0x40 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x02 ,0x75 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x02 ,0x76 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x03,
			0x00 ,0x00 ,0x03 ,(byte)0xfc ,(byte)0xc0 ,0x00 ,0x00 ,0x0d ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x35 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xfd ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x00 ,0x08 ,0x60 ,0x00 ,0x00 ,0x0c ,(byte)0xac ,0x1a ,(byte)0xa1 ,0x06 ,0x00 ,0x00 ,0x04 ,0x03 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x15 ,(byte)0xe0 ,0x00 ,0x00 ,0x0d ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x01 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x04 ,0x08 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x03 ,(byte)0xe8 ,0x00 ,0x00 ,0x01 ,(byte)0xca ,0x60 ,0x00 ,0x00 ,0x2c ,0x00 ,0x00 ,0x01 ,(byte)0xcb ,0x20 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,(byte)0xcc ,0x20 ,0x00 ,0x00 ,0x18 ,0x33 ,0x35 ,0x38 ,0x32 ,0x34 ,0x30 ,0x30 ,0x33 ,0x32 ,0x32 ,0x34 ,0x33 ,0x37 ,0x33 ,0x34 ,0x38 ,0x00 ,0x00 ,0x03 ,(byte)0xf8 ,(byte)0xc0 ,0x00 ,0x00 ,0x58 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,
				0x00 ,0x00 ,0x04 ,0x04 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x06 ,
				//Max-Requested-Bandwidth-UL
				0x00 ,0x00 ,0x02 ,0x04 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x3d ,(byte)0x86 ,0x00 ,
				//Max-Requested-Bandwidth-DL
				0x00 ,0x00 ,0x02 ,0x03 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,(byte)0x83 ,(byte)0xd6 ,0x00 ,
				0x00 ,0x00 ,0x04 ,0x0a ,(byte)0xc0 ,0x00 ,0x00 ,0x1c ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x04 ,0x16 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x04 ,0x06 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x00 ,0x12 ,(byte)0xe0 ,0x00 ,0x00 ,0x11 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x33 ,0x34 ,0x30 ,0x30 ,0x31 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x06 ,(byte)0xe0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,(byte)0xc1 ,(byte)0xfb ,(byte)0xa4 ,(byte)0xa1 ,
			//RAI - 24 bytes with Padding
			0x00 ,0x00 ,0x03 ,(byte)0x8d ,(byte)0xc0 ,0x00 ,0x00 ,0x17 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x33 ,0x34 ,0x30 ,0x30 ,0x31 ,0x66 ,0x66 ,0x66 ,0x65 ,0x66 ,0x66 ,0x00 ,
			//MS-Timezone - 16 bytes with padding
			0x00 ,0x00 ,0x00 ,0x17 ,(byte)0xc0 ,0x00 ,0x00 ,0x0e ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x69 ,0x00 ,0x00 ,0x00 ,
			0x00 ,0x00 ,0x00 ,0x1e ,0x60 ,0x00 ,0x00 ,0x11 ,0x6f ,0x63 ,0x73 ,0x70 ,0x72 ,0x6f ,0x64 ,0x67 ,0x70 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xe8 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,(byte)0xf5 ,(byte)0xc0 ,0x00 ,0x00 ,0x12 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x01 ,(byte)0xc1 ,(byte)0xfb ,(byte)0xa4 ,(byte)0x83 ,0x00 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xfe ,(byte)0xc0 ,0x00 ,0x00 ,0x20 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x01 ,(byte)0xf7 ,(byte)0xc0 ,0x00 ,0x00 ,0x14 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x34 ,0x36 ,0x34 ,0x37 ,0x39 ,0x36 ,0x38 ,0x30 ,
			//Gx Capabilities List - 24 bytes
			0x00 ,0x00 ,0x04 ,0x24 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x00 ,(byte)0xc1 ,0x00 ,0x01 ,0x00 ,0x01			
		});
	
	//this is original message from capture , it has 6 headers out of standard order which are shown in separate rows
	private ByteBuf creditControlAnswerMessage = Unpooled.wrappedBuffer(new byte[] {0x01 ,0x00 ,0x02 ,0x00 ,0x40 ,0x00 ,0x01 ,0x10 ,0x01 ,0x00 ,0x00 ,0x16 ,(byte)0xef ,(byte)0xeb ,(byte)0xb9 ,0x57 ,(byte)0x93 ,(byte)0xc4 ,0x26 ,0x61 ,0x00 ,0x00 ,0x01 ,0x07 ,0x40 ,0x00 ,0x00 ,0x2c ,0x63 ,0x30 ,0x2d ,0x31 ,0x37 ,0x32 ,0x2d ,0x32 ,0x35 ,0x2d ,0x33 ,0x37 ,0x2d ,0x33 ,0x2d ,0x67 ,0x67 ,0x73 ,0x6e ,0x39 ,0x37 ,0x31 ,0x3b ,0x31 ,0x33 ,0x39 ,0x37 ,0x31 ,0x30 ,0x37 ,0x30 ,0x30 ,0x34 ,0x3b ,0x35 ,0x33 ,
			//Result-Code
			0x00 ,0x00 ,0x01 ,0x0c ,0x40 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x07 ,(byte)0xd1 ,
			0x00 ,0x00 ,0x01 ,0x08 ,0x40 ,0x00 ,0x00 ,0x16 ,0x75 ,0x31 ,0x73 ,0x64 ,0x70 ,0x31 ,0x62 ,0x2e ,0x6f ,0x63 ,0x61 ,0x2e ,0x67 ,0x70 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,0x28 ,0x40 ,0x00 ,0x00 ,0x15 ,0x75 ,0x31 ,0x73 ,0x64 ,0x70 ,0x31 ,0x2e ,0x6f ,0x63 ,0x61 ,0x2e ,0x67 ,0x70 ,0x00 ,0x00 ,0x00 ,
			//Auth-Application-Id
			0x00 ,0x00 ,0x01 ,0x02 ,0x60 ,0x00 ,0x00 ,0x0c ,0x01 ,0x00 ,0x00 ,0x16 ,
			//CC-Request-Number
			0x00 ,0x00 ,0x01 ,(byte)0x9f ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x00 ,
			//CC-Request-Type
			0x00 ,0x00 ,0x01 ,(byte)0xa0 ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x01 ,
			0x00 ,0x00 ,0x02 ,0x74 ,(byte)0x80 ,0x00 ,0x00 ,0x38 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x01 ,0x0a ,0x40 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x02 ,0x75 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x02 ,0x76 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,
			//Charging-Rule-Install
			0x00 ,0x00 ,0x03 ,(byte)0xe9 ,(byte)0xc0 ,0x00 ,0x00 ,0x30 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x03 ,(byte)0xed ,(byte)0xc0 ,0x00 ,0x00 ,0x12 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x31 ,0x30 ,0x30 ,0x30 ,0x32 ,0x30 ,0x00 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xfc ,(byte)0xc0 ,0x00 ,0x00 ,0x0d ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x35 ,0x00 ,0x00 ,0x00 ,
			0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x02 ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x04 ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x0d ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x19 ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x11 ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,
			0x00 ,0x00 ,0x03 ,(byte)0xf8 ,(byte)0xc0 ,0x00 ,0x00 ,0x68 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,
				0x00 ,0x00 ,0x04 ,0x04 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x06 ,
				//Allocation-Retention-Priority
				0x00 ,0x00 ,0x04 ,0x0a ,(byte)0x80 ,0x00 ,0x00 ,0x1c ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x04 ,0x16 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,
				//Bearer-Identifier
				0x00 ,0x00 ,0x03 ,(byte)0xfc ,(byte)0xc0 ,0x00 ,0x00 ,0x0d ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x35 ,0x00 ,0x00 ,0x00 ,
				0x00 ,0x00 ,0x02 ,0x04 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x3d ,(byte)0x86 ,0x00 ,0x00 ,0x00 ,0x02 ,0x03 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,(byte)0x83 ,(byte)0xd6 ,0x00 ,
			//Bearer-Control-Mode
			0x00 ,0x00 ,0x03 ,(byte)0xff ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x00 ,
			0x00 ,0x00 ,0x04 ,0x12 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,(byte)0xd6 ,(byte)0xf9 ,0x24 ,0x4c });
	
	//this is original message from capture , it has 6 headers out of standard order which are shown in separate rows
	private ByteBuf patchedCreditControlAnswerMessage = Unpooled.wrappedBuffer(new byte[] {0x01 ,0x00 ,0x02 ,0x00 ,0x40 ,0x00 ,0x01 ,0x10 ,0x01 ,0x00 ,0x00 ,0x16 ,(byte)0xef ,(byte)0xeb ,(byte)0xb9 ,0x57 ,(byte)0x93 ,(byte)0xc4 ,0x26 ,0x61 ,0x00 ,0x00 ,0x01 ,0x07 ,0x40 ,0x00 ,0x00 ,0x2c ,0x63 ,0x30 ,0x2d ,0x31 ,0x37 ,0x32 ,0x2d ,0x32 ,0x35 ,0x2d ,0x33 ,0x37 ,0x2d ,0x33 ,0x2d ,0x67 ,0x67 ,0x73 ,0x6e ,0x39 ,0x37 ,0x31 ,0x3b ,0x31 ,0x33 ,0x39 ,0x37 ,0x31 ,0x30 ,0x37 ,0x30 ,0x30 ,0x34 ,0x3b ,0x35 ,0x33 ,
			//Auth-Application-Id
			0x00 ,0x00 ,0x01 ,0x02 ,0x60 ,0x00 ,0x00 ,0x0c ,0x01 ,0x00 ,0x00 ,0x16 ,
			0x00 ,0x00 ,0x01 ,0x08 ,0x40 ,0x00 ,0x00 ,0x16 ,0x75 ,0x31 ,0x73 ,0x64 ,0x70 ,0x31 ,0x62 ,0x2e ,0x6f ,0x63 ,0x61 ,0x2e ,0x67 ,0x70 ,0x00 ,0x00 ,0x00 ,0x00 ,0x01 ,0x28 ,0x40 ,0x00 ,0x00 ,0x15 ,0x75 ,0x31 ,0x73 ,0x64 ,0x70 ,0x31 ,0x2e ,0x6f ,0x63 ,0x61 ,0x2e ,0x67 ,0x70 ,0x00 ,0x00 ,0x00 ,
			//Result-Code
			0x00 ,0x00 ,0x01 ,0x0c ,0x40 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x07 ,(byte)0xd1 ,
			//CC-Request-Type
			0x00 ,0x00 ,0x01 ,(byte)0xa0 ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x01 ,
			//CC-Request-Number
			0x00 ,0x00 ,0x01 ,(byte)0x9f ,0x60 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x00 ,0x00 ,
			0x00 ,0x00 ,0x02 ,0x74 ,(byte)0x80 ,0x00 ,0x00 ,0x38 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x01 ,0x0a ,0x40 ,0x00 ,0x00 ,0x0c ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x02 ,0x75 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,0x00 ,0x00 ,0x02 ,0x76 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,
			//Bearer-Control-Mode
			0x00 ,0x00 ,0x03 ,(byte)0xff ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x00 ,
			0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x02 ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x04 ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x0d ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x19 ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x11 ,0x00 ,0x00 ,0x03 ,(byte)0xee ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,
			//Charging-Rule-Install
			0x00 ,0x00 ,0x03 ,(byte)0xe9 ,(byte)0xc0 ,0x00 ,0x00 ,0x30 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x03 ,(byte)0xed ,(byte)0xc0 ,0x00 ,0x00 ,0x12 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x31 ,0x30 ,0x30 ,0x30 ,0x32 ,0x30 ,0x00 ,0x00 ,0x00 ,0x00 ,0x03 ,(byte)0xfc ,(byte)0xc0 ,0x00 ,0x00 ,0x0d ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x35 ,0x00 ,0x00 ,0x00 ,
			0x00 ,0x00 ,0x03 ,(byte)0xf8 ,(byte)0xc0 ,0x00 ,0x00 ,0x68 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,
				0x00 ,0x00 ,0x04 ,0x04 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x06 ,
				0x00 ,0x00 ,0x02 ,0x04 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x3d ,(byte)0x86 ,0x00 ,0x00 ,0x00 ,0x02 ,0x03 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,(byte)0x83 ,(byte)0xd6 ,0x00 ,
				//Bearer-Identifier
				0x00 ,0x00 ,0x03 ,(byte)0xfc ,(byte)0xc0 ,0x00 ,0x00 ,0x0d ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x35 ,0x00 ,0x00 ,0x00 ,
				//Allocation-Retention-Priority
				0x00 ,0x00 ,0x04 ,0x0a ,(byte)0x80 ,0x00 ,0x00 ,0x1c ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x04 ,0x16 ,(byte)0x80 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,0x00 ,0x00 ,0x00 ,0x01 ,				
			0x00 ,0x00 ,0x04 ,0x12 ,(byte)0xc0 ,0x00 ,0x00 ,0x10 ,0x00 ,0x00 ,0x28 ,(byte)0xaf ,(byte)0xd6 ,(byte)0xf9 ,0x24 ,0x4c });

	@Test
	public void testCreditControlRequest() throws DiameterException
	{		
		DiameterParser diameterParser=new DiameterParser(this.getClass().getClassLoader(), Arrays.asList(new Class<?>[] { DiameterErrorAnswerImpl.class , DiameterErrorAnswerWithSessionImpl.class }),Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.primitives"));
		
		//make sure classes are loaded
		Class<?> clazz = CreditControlRequestImpl.class;
		Class<?> avpClass = AllocationRetentionPriorityImpl.class;
		assertNotNull(clazz);
		assertNotNull(avpClass);
		
		diameterParser.registerApplication(this.getClass().getClassLoader(), Package.getPackage("com.mobius.software.telco.protocols.diameter.impl.commands.gx"));
		
		creditControlRequestMessage.resetReaderIndex();
		DiameterMessage decodeMessage = diameterParser.decode(creditControlRequestMessage, false);
		assertNotNull(decodeMessage);
		assertTrue(decodeMessage instanceof CreditControlRequest);
		CreditControlRequest ccr = (CreditControlRequest)decodeMessage;
		assertFalse(ccr.getIsRetransmit());
		assertTrue(ccr.getIsProxyable());
		assertNotNull(ccr.getEndToEndIdentifier());
		assertNotNull(ccr.getHopByHopIdentifier());
		assertEquals(ccr.getEndToEndIdentifier(),new Long(0x93c4265fL));
		assertEquals(ccr.getHopByHopIdentifier(),new Long(0xefebb955L));
		assertNotNull(ccr.getSessionId());
		assertEquals(ccr.getSessionId(),"c0-172-25-37-3-ggsn971;1397107004;52");
		assertNotNull(ccr.getAuthApplicationId());
		assertEquals(ccr.getAuthApplicationId(),new Long(ApplicationIDs.GX));
		assertNotNull(ccr.getOriginHost());
		assertEquals(ccr.getOriginHost(),"c0-172-25-37-3-ggsn971");
		assertNotNull(ccr.getOriginRealm());
		assertEquals(ccr.getOriginRealm(),"ocs.oca.gp");
		assertNotNull(ccr.getDestinationRealm());
		assertEquals(ccr.getDestinationRealm(),"u1ccn1.oca.gp");
		assertNotNull(ccr.getCcRequestType());
		assertEquals(ccr.getCcRequestType(),CcRequestTypeEnum.INITIAL_REQUEST);
		assertNotNull(ccr.getCcRequestNumber());
		assertEquals(ccr.getCcRequestNumber(),new Long(0));
		assertNotNull(ccr.getTGPPMSTimeZone());
		ByteBuf tgppMsTimezone=ccr.getTGPPMSTimeZone();
		assertEquals(tgppMsTimezone.readableBytes(),2);
		assertEquals(tgppMsTimezone.readByte(),0x69);
		assertEquals(tgppMsTimezone.readByte(),0x00);
		assertNotNull(ccr.getOriginStateId());
		assertEquals(ccr.getOriginStateId(),new Long(2));
		assertNotNull(ccr.getSubscriptionId());
		assertEquals(ccr.getSubscriptionId().size(),2);
		assertEquals(ccr.getSubscriptionId().get(0).getSubscriptionIdType(),SubscriptionIdTypeEnum.END_USER_E164);
		assertEquals(ccr.getSubscriptionId().get(0).getSubscriptionIdData(),"596696310364");
		assertEquals(ccr.getSubscriptionId().get(1).getSubscriptionIdType(),SubscriptionIdTypeEnum.END_USER_IMSI);
		assertEquals(ccr.getSubscriptionId().get(1).getSubscriptionIdData(),"340019702747508");
		assertNotNull(ccr.getBearerIdentifier());
		ByteBuf bearerIdentifier=ccr.getBearerIdentifier();
		assertEquals(bearerIdentifier.readableBytes(),1);
		assertEquals(bearerIdentifier.readByte(),0x35);
		assertNotNull(ccr.getBearerOperation());
		assertEquals(ccr.getBearerOperation(),BearerOperationEnum.ESTABLISHMENT);
		assertNotNull(ccr.getFramedIPAddress());
		assertEquals(ccr.getFramedIPAddress().getHostAddress(),"172.26.161.6");
		assertNotNull(ccr.getIPCANType());
		assertEquals(ccr.getIPCANType(),IPCANTypeEnum.TGPP_GPRS);
		assertNotNull(ccr.getTGPPRATType());
		ByteBuf tgppRatType=ccr.getTGPPRATType();
		assertEquals(tgppRatType.readableBytes(),1);
		assertEquals(tgppRatType.readByte(),0x01);
		assertNotNull(ccr.getRATType());
		assertEquals(ccr.getRATType(),RATTypeEnum.UTRAN);
		assertNotNull(ccr.getUserEquipmentInfo());
		assertEquals(ccr.getUserEquipmentInfo().getUserEquipmentInfoType(),UserEquipmentInfoTypeEnum.IMEISV);
		assertEquals(ccr.getUserEquipmentInfo().getUserEquipmentInfoValue().toString(Charset.defaultCharset()),"3582400322437348");
		assertNotNull(ccr.getQoSInformation());
		assertNotNull(ccr.getQoSInformation().getQoSClassIdentifier());
		assertEquals(ccr.getQoSInformation().getQoSClassIdentifier(),QoSClassIdentifierEnum.QCI_6);
		assertNotNull(ccr.getQoSInformation().getMaxRequestedBandwidthDL());
		assertEquals(ccr.getQoSInformation().getMaxRequestedBandwidthDL(),new Long(8640000));
		assertNotNull(ccr.getQoSInformation().getMaxRequestedBandwidthUL());
		assertEquals(ccr.getQoSInformation().getMaxRequestedBandwidthUL(),new Long(4032000));
		assertNotNull(ccr.getQoSInformation().getAllocationRetentionPriority());
		assertNotNull(ccr.getQoSInformation().getAllocationRetentionPriority().getPriorityLevel());
		assertEquals(ccr.getQoSInformation().getAllocationRetentionPriority().getPriorityLevel(),new Long(1));
		assertNotNull(ccr.getQoSUpgrade());
		assertEquals(ccr.getQoSUpgrade(),QoSUpgradeEnum.QOS_UPGRADE_SUPPORTED);
		assertNotNull(ccr.getTGPPSGSNMCCMNC());
		assertEquals(ccr.getTGPPSGSNMCCMNC(),"34001");
		assertNotNull(ccr.getTGPPSGSNAddress());
		ByteBuf tgppSgsnAddress = ccr.getTGPPSGSNAddress();
		assertEquals(tgppSgsnAddress.readableBytes(),4);
		assertEquals(tgppSgsnAddress.readUnsignedByte(),193);
		assertEquals(tgppSgsnAddress.readUnsignedByte(),251);
		assertEquals(tgppSgsnAddress.readUnsignedByte(),164);
		assertEquals(tgppSgsnAddress.readUnsignedByte(),161);
		assertNotNull(ccr.getCalledStationId());
		assertEquals(ccr.getCalledStationId(),"ocsprodgp");
		assertNotNull(ccr.getBearerUsage());
		assertEquals(ccr.getBearerUsage(),BearerUsageEnum.GENERAL);
		assertNotNull(ccr.getAccessNetworkChargingAddress());
		assertEquals(ccr.getAccessNetworkChargingAddress().getHostAddress(),"193.251.164.131");
		assertNotNull(ccr.getAccessNetworkChargingIdentifierGx());
		assertEquals(ccr.getAccessNetworkChargingIdentifierGx().size(),1);
		assertEquals(ccr.getAccessNetworkChargingIdentifierGx().get(0).getAccessNetworkChargingIdentifierValue().toString(Charset.defaultCharset()),"46479680");
		assertNotNull(ccr.getRAI());
		assertEquals(ccr.getRAI(),"34001fffeff");
		assertNotNull(ccr.getSupportedFeatures());
		assertEquals(ccr.getSupportedFeatures().size(),1);
		assertEquals(ccr.getSupportedFeatures().get(0).getFeatureListID(),new Long(1));
		assertEquals(ccr.getSupportedFeatures().get(0).getFeatureList(),new Long(3));
		
		//add optional avps - Gx Capabilities List
		
		ByteBuf encodedMessage = diameterParser.encode(ccr);
		byte[] ccrEncodedData = new byte[encodedMessage.readableBytes()];
		encodedMessage.readBytes(ccrEncodedData);
		patchedCreditControlRequestMessage.setIndex(0,patchedCreditControlRequestMessage.writerIndex());
		byte[] ccrData = new byte[patchedCreditControlRequestMessage.readableBytes()];
		patchedCreditControlRequestMessage.readBytes(ccrData);
		assertArrayEquals(ccrEncodedData, ccrData);
		
		System.out.println(diameterParser.printMessage(ccr));
		
		creditControlAnswerMessage.resetReaderIndex();
		decodeMessage = diameterParser.decode(creditControlAnswerMessage, false);
		assertNotNull(decodeMessage);
		assertTrue(decodeMessage instanceof CreditControlAnswer);
		CreditControlAnswer cca = (CreditControlAnswer)decodeMessage;
		assertFalse(cca.getIsError());
		assertTrue(cca.getIsProxyable());
		assertFalse(cca.getIsRetransmit());
		assertNotNull(cca.getEndToEndIdentifier());
		assertNotNull(cca.getHopByHopIdentifier());
		assertEquals(cca.getEndToEndIdentifier(),new Long(0x93c42661L));
		assertEquals(cca.getHopByHopIdentifier(),new Long(0xefebb957L));
		assertNotNull(cca.getSessionId());
		assertEquals(cca.getSessionId(),"c0-172-25-37-3-ggsn971;1397107004;53");
		assertNotNull(cca.getResultCode());
		assertEquals(cca.getResultCode(),new Long(ResultCodes.DIAMETER_SUCCESS));
		assertNotNull(cca.getOriginHost());
		assertEquals(cca.getOriginHost(),"u1sdp1b.oca.gp");
		assertNotNull(cca.getOriginRealm());
		assertEquals(cca.getOriginRealm(),"u1sdp1.oca.gp");
		assertNotNull(cca.getAuthApplicationId());
		assertEquals(cca.getAuthApplicationId(), new Long(16777238L));
		assertNotNull(cca.getCcRequestNumber());
		assertEquals(cca.getCcRequestNumber(), new Long(0L));
		assertNotNull(cca.getCcRequestType());
		assertEquals(cca.getCcRequestType(), CcRequestTypeEnum.INITIAL_REQUEST);
		assertNotNull(cca.getSupportedFeatures());
		assertEquals(cca.getSupportedFeatures().size(),1);
		assertNotNull(cca.getSupportedFeatures().get(0).getVendorId());
		assertEquals(cca.getSupportedFeatures().get(0).getVendorId(), new Long(VendorIDs.TGPP_ID));
		assertNotNull(cca.getSupportedFeatures().get(0).getFeatureListID());
		assertEquals(cca.getSupportedFeatures().get(0).getFeatureListID(), new Long(1L));
		assertNotNull(cca.getSupportedFeatures().get(0).getFeatureList());
		assertEquals(cca.getSupportedFeatures().get(0).getFeatureList(), new Long(1L));
		assertNotNull(cca.getChargingRuleInstall());
		assertEquals(cca.getChargingRuleInstall().size(),1);
		assertNotNull(cca.getChargingRuleInstall().get(0).getChargingRuleName());
		assertEquals(cca.getChargingRuleInstall().get(0).getChargingRuleName().size(), 1);
		assertEquals(cca.getChargingRuleInstall().get(0).getChargingRuleName().get(0).toString(Charset.defaultCharset()), "100020");
		assertNotNull(cca.getChargingRuleInstall().get(0).getBearerIdentifier());
		assertEquals(cca.getChargingRuleInstall().get(0).getBearerIdentifier().readableBytes(), 1);
		assertEquals(cca.getChargingRuleInstall().get(0).getBearerIdentifier().readByte(), 0x35);
		assertNotNull(cca.getEventTrigger());
		assertEquals(cca.getEventTrigger().size(),7);
		assertEquals(cca.getEventTrigger().get(0), EventTriggerEnum.SGSN_CHANGE);
		assertEquals(cca.getEventTrigger().get(1), EventTriggerEnum.RAT_CHANGE);
		assertEquals(cca.getEventTrigger().get(2), EventTriggerEnum.PLMN_CHANGE);
		assertEquals(cca.getEventTrigger().get(3), EventTriggerEnum.USER_LOCATION_CHANGE);
		assertEquals(cca.getEventTrigger().get(4), EventTriggerEnum.UE_TIME_ZONE_CHANGE);
		assertEquals(cca.getEventTrigger().get(5), EventTriggerEnum.REVALIDATION_TIMEOUT);
		assertEquals(cca.getEventTrigger().get(6), EventTriggerEnum.QOS_CHANGE);
		assertNotNull(cca.getQoSInformation());
		assertEquals(cca.getQoSInformation().size(), 1);
		assertNotNull(cca.getQoSInformation().get(0).getQoSClassIdentifier());
		assertEquals(cca.getQoSInformation().get(0).getQoSClassIdentifier(),QoSClassIdentifierEnum.QCI_6);
		assertNotNull(cca.getQoSInformation().get(0).getAllocationRetentionPriority());
		assertNotNull(cca.getQoSInformation().get(0).getAllocationRetentionPriority().getPriorityLevel());
		assertEquals(cca.getQoSInformation().get(0).getAllocationRetentionPriority().getPriorityLevel(),new Long(1));
		assertNotNull(cca.getQoSInformation().get(0).getBearerIdentifier());
		bearerIdentifier=cca.getQoSInformation().get(0).getBearerIdentifier();
		assertEquals(bearerIdentifier.readableBytes(),1);
		assertEquals(bearerIdentifier.readByte(),0x35);
		assertNotNull(cca.getQoSInformation().get(0).getMaxRequestedBandwidthUL());
		assertEquals(cca.getQoSInformation().get(0).getMaxRequestedBandwidthUL(),new Long(4032000));
		assertNotNull(cca.getQoSInformation().get(0).getMaxRequestedBandwidthDL());
		assertEquals(cca.getQoSInformation().get(0).getMaxRequestedBandwidthDL(),new Long(8640000));
		assertNotNull(cca.getBearerControlMode());
		assertEquals(cca.getBearerControlMode(), BearerControlModeEnum.UE_ONLY);
		assertNotNull(cca.getRevalidationTime());
		assertEquals(cca.getRevalidationTime().getTime(), 1397663180000L);
		
		
		encodedMessage = diameterParser.encode(cca);
		byte[] dwaEncodedData = new byte[encodedMessage.readableBytes()];
		encodedMessage.readBytes(dwaEncodedData);
		patchedCreditControlAnswerMessage.setIndex(0,patchedCreditControlAnswerMessage.writerIndex());
		byte[] ccaData = new byte[patchedCreditControlAnswerMessage.readableBytes()];
		patchedCreditControlAnswerMessage.readBytes(ccaData);
		assertArrayEquals(dwaEncodedData, ccaData);
		
		System.out.println(diameterParser.printMessage(cca));		
	}
}