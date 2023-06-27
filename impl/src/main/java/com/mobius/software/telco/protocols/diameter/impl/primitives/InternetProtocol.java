package com.mobius.software.telco.protocols.diameter.impl.primitives;

import java.util.HashMap;
import java.util.Map;

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

public enum InternetProtocol 
{
	ANY("ip"),HOPOPT("0"),ICMP("1"),IGMP("2"),GGP("3"),IPv4("4"),ST("5"),TCP("6"),
	CBT("7"),EGP("8"),IGP("9"),BBN_RCC_MON("10"),NVP_II("11"),PUP("12"),ARGUS("13"),
	EMCON("14"),XNET("15"),CHAOS("16"),UDP("17"),MUX("18"),DCN_MEAS("19"),HMP("20"),
	PRM("21"),XNS_IDP("22"),TRUNK_1("23"),TRUNK_2("24"),LEAF_1("25"),LEAF_2("26"),RDP("27"),
	IRTP("28"),ISO_TP4("29"),NETBLT("30"),MFE_NSP("31"),MERIT_INP("32"),DCCP("33"),THREE_PC("34"),
	IDPR("35"),XTP("36"),DDP("37"),IDPR_CMTP("38"),TP_PLUS_PLUS("39"),IL("40"),IPv6("41"),
	SDRP("42"),IPv6_ROUTE("43"),IPv6_FRAG("44"),IDRP("45"),RSVP("46"),GRE("47"),DSR("48"),
	BNA("49"),ESP("50"),AH("51"),I_NLSP("52"),SWIPE("53"),NARP("54"),MOBILE("55"),
	TLSP("56"),SKIP("57"),IPv6_ICMP("58"),IPv6_NONXT("59"),IPv6_OPTS("60"),HOST_INTERNAL("61"),CFTP("62"),
	NETWORK_INTERNAL("63"),SAT_EXPAK("64"),KRYPTOLAN("65"),RVD("66"),IPPC("67"),DIST_FS("68"),SAT_MON("69"),
	VISA("70"),IPCV("71"),CPNX("72"),CPHB("73"),WSN("74"),PVP("75"),BR_SAT_MON("76"),
	SUN_ND("77"),WB_MON("78"),WB_EXPAK("79"),ISO_IP("80"),VMTP("81"),SECURE_VMTP("82"),VINES("83"),
	IPTM("84"),NSFNET_IGP("85"),DGP("86"),TCF("87"),EIGRP("88"),OSPFIGP("89"),Sprite_RPC("90"),
	LARP("91"),MTP("92"),AX_25("93"),IPIP("94"),MICP("95"),SCC_SP("96"),ETHERIP("97"),
	ENCAP("98"),PRIV_ENC("99"),GMTP("100"),IFMP("101"),PNNI("102"),PIM("103"),ARIS("104"),
	SCPS("105"),QNX("106"),A_N("107"),IP_COMP("108"),SNP("109"),COMPAQ_PEER("110"),IPX_IN_IP("111"),
	VRRP("112"),PGM("113"),ZERO_HOP("114"),L2TP("115"),DDX("116"),IATP("117"),STP("118"),
	SRP("119"),UTI("120"),SMP("121"),SM("122"),PTP("123"),ISIS_OVER_IPv4("124"),FIRE("125"),
	CRTP("126"),CRUDP("127"),SSCOPMCE("128"),IPLT("129"),SPS("130"),PIPE("131"),SCTP("132"),
	FC("133"),RSVP_E2E_IGNORE("134"),MOBILITY_HEADER("135"),UDP_LITE("136"),MPLS_IN_IP("137"),MANET("138"),HIP("139"),
	SHIM6("140"),WESP("141"),ROHC("142"),ETHERNET("143"),AGGFRAG("144"),NSH("145"),TESTING_253("253"),TESTING_254("254");

	private static final Map<String, InternetProtocol> strToTypeMap = new HashMap<String, InternetProtocol>();
	static 
	{
	    for (InternetProtocol type : InternetProtocol.values()) 
	    {
	    	strToTypeMap.put(type.value, type);
	    }
	}

	public static InternetProtocol fromString(String value) 
	{
		InternetProtocol type = strToTypeMap.get(value.toLowerCase());
	    return type;
	}
	
	private String value;
	
	private InternetProtocol(String value)
	{
		this.value=value;
	}
	
	public String getValue()
	{
		return value;
	}
}
