package com.mobius.software.telco.protocols.diameter.primitives.accounting;

import java.util.HashMap;
import java.util.Map;

import com.mobius.software.telco.protocols.diameter.primitives.IntegerEnum;

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
/**
*
* @author yulian oifa
*
*/
/*
 * 	7.2.42 Content-Class AVP
	The Content-Class AVP (AVP code 1220) is of type Enumerated and classifies the content of the MM to the highest
	content class to which the MM belongs, as defined in MMS Encapsulation [209]. The classes can be one of the
	following:
	
	0 text
	1 image-basic
	2 image-rich
	3 video-basic
	4 video-rich
	5 megapixel
	6 content-basic
	7 content-rich
 */
public enum ContentClassEnum implements IntegerEnum
{
	TEXT(0),IMAGE_BASIC(1),IMAGE_RICH(2),VIDEO_BASIC(3),VIDEO_RICH(4),MEGAPIXEL(5),CONTENT_BASIC(6),CONTENT_RICH(7);

	private static final Map<Integer, ContentClassEnum> intToTypeMap = new HashMap<Integer, ContentClassEnum>();
	static 
	{
	    for (ContentClassEnum type : ContentClassEnum.values()) 
	    {
	    	intToTypeMap.put(type.value, type);
	    }
	}

	public static ContentClassEnum fromInt(Integer value) 
	{
		ContentClassEnum type = intToTypeMap.get(value);
	    return type;
	}
	
	private int value;
	
	private ContentClassEnum(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
}
