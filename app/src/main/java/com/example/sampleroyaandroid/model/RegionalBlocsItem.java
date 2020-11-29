package com.example.sampleroyaandroid.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RegionalBlocsItem{

	@SerializedName("otherNames")
	private List<Object> otherNames;

	@SerializedName("acronym")
	private String acronym;

	@SerializedName("name")
	private String name;

	@SerializedName("otherAcronyms")
	private List<Object> otherAcronyms;

	public List<Object> getOtherNames(){
		return otherNames;
	}

	public String getAcronym(){
		return acronym;
	}

	public String getName(){
		return name;
	}

	public List<Object> getOtherAcronyms(){
		return otherAcronyms;
	}
}