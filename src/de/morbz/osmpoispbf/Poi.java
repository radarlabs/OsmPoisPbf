/*
	Copyright 2012-2015, Merten Peetz
	
	This file is part of OsmPoisPbf.
	OsmPoisPbf is free software: you can redistribute it and/or modify it under the terms of the GNU 
	General Public License as published by the Free Software Foundation, either version 3 of the 
	License, or (at your option) any later version.
	
	OsmPoisPbf is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
	even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
	General Public License for more details.
	
	You should have received a copy of the GNU General Public License along with OsmPoisPbj. If not, 
	see http://www.gnu.org/licenses/.
*/

package de.morbz.osmpoispbf;

import java.util.Locale;

import net.morbz.osmonaut.osm.LatLon;

public class Poi {
	private String name;
	private String cat;
	private LatLon coords;
	private String osmId;
	
	private static String format;
	private static char seperator;
	
	public Poi(String name, String cat, LatLon coords, String osmId) {
		this.name = name;
		this.cat = cat;
		this.coords = coords;
		this.osmId = osmId;
	}
	
	public String toCsv() {
		String str = "";
		str += getEscapedCsvString(cat) + seperator;
		str += osmId + seperator;
		str += round(coords.getLat()) + "" + seperator;
		str += round(coords.getLon()) + "" + seperator;
		str += getEscapedCsvString(name);
		return str;
	}
	
	public String toString() {
		return "[Poi(name=\""+name+"\",osm-id=\""+osmId+"\",cat="+cat+",coords="+coords.toString()+")]";
	}
	
	private String getEscapedCsvString(String str) {
		str = str.replace(seperator, ' ');
		return str;
	}
	
	private String round(double coordinate) {
		return String.format((Locale)null, format, coordinate);
	}
	
	/* Setters */
	public static void setDecimals(int decimals) {
		format = "%." + decimals + "f";
	}
	
	public static void setSeperator(char seperator) {
		Poi.seperator = seperator;
	}
}
