/*! * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * @File:
 * ParcelableNameValuePair.java
* @Project:
*		Rhythm
* @Abstract:
*		
* @Copyright:
*     		Copyright © 2014 Saregama India Ltd. All Rights Reserved
*			Written under contract by Robosoft Technologies Pvt. Ltd.
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
/*
Created by pankaj and adarsha on 27-Mar-2014
 */

package com.basicsetup.webservices;
import org.apache.http.NameValuePair;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableNameValuePair implements NameValuePair, Parcelable {

	String name, value;

	public ParcelableNameValuePair(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return value;
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeString(name);
		out.writeString(value);
	}

	// this is used to regenerate your object. All Parcelables must have a
	// CREATOR that implements these two methods
	public static final Parcelable.Creator<ParcelableNameValuePair> CREATOR = new Parcelable.Creator<ParcelableNameValuePair>() {
		public ParcelableNameValuePair createFromParcel(Parcel in) {
			return new ParcelableNameValuePair(in);
		}

		public ParcelableNameValuePair[] newArray(int size) {
			return new ParcelableNameValuePair[size];
		}
	};

	// example constructor that takes a Parcel and gives you an object populated
	// with it's values
	private ParcelableNameValuePair(Parcel in) {
		name = in.readString();
		value = in.readString();
	}

	@Override
	public String toString() {
		return name+":"+value;
	}
	
	@Override
	public boolean equals(Object o) { 
		return name.equalsIgnoreCase(((ParcelableNameValuePair)o).name);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
