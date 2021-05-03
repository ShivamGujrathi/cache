package com.example.movief;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CharecterDetails implements Serializable {

	@SerializedName("films")
	private List<String> films;

	@SerializedName("homeworld")
	private String homeworld;

	@SerializedName("gender")
	private String gender;

	@SerializedName("skin_color")
	private String skinColor;

	@SerializedName("edited")
	private String edited;

	@SerializedName("created")
	private String created;

	@SerializedName("mass")
	private String mass;

	@SerializedName("vehicles")
	private List<String> vehicles;

	@SerializedName("url")
	private String url;

	@SerializedName("hair_color")
	private String hairColor;

	@SerializedName("birth_year")
	private String birthYear;

	@SerializedName("eye_color")
	private String eyeColor;

	@SerializedName("species")
	private List<Object> species;

	@SerializedName("starships")
	private List<String> starships;

	@SerializedName("name")
	private String name;

	@SerializedName("height")
	private String height;

	public List<String> getFilms(){
		return films;
	}

	public String getHomeworld(){
		return homeworld;
	}

	public String getGender(){
		return gender;
	}

	public String getSkinColor(){
		return skinColor;
	}

	public String getEdited(){
		return edited;
	}

	public String getCreated(){
		return created;
	}

	public String getMass(){
		return mass;
	}

	public List<String> getVehicles(){
		return vehicles;
	}

	public String getUrl(){
		return url;
	}

	public String getHairColor(){
		return hairColor;
	}

	public String getBirthYear(){
		return birthYear;
	}

	public String getEyeColor(){
		return eyeColor;
	}

	public List<Object> getSpecies(){
		return species;
	}

	public List<String> getStarships(){
		return starships;
	}

	public String getName(){
		return name;
	}

	public String getHeight(){
		return height;
	}
}