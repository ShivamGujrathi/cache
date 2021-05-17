package com.example.movief;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {

	@SerializedName("edited")
	private String edited;

	@SerializedName("director")
	private String director;

	@SerializedName("created")
	private String created;

	@SerializedName("vehicles")
	private List<String> vehicles;

	@SerializedName("opening_crawl")
	private String openingCrawl;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("characters")
	private List<String> characters;

	@SerializedName("episode_id")
	private int episodeId;

	@SerializedName("planets")
	private List<String> planets;

	@SerializedName("release_date")
	private String releaseDate;

	@SerializedName("starships")
	private List<String> starships;

	@SerializedName("species")
	private List<String> species;

	@SerializedName("producer")
	private String producer;

	protected ResultsItem(Parcel in) {
		edited = in.readString();
		director = in.readString();
		created = in.readString();
		vehicles = in.createStringArrayList();
		openingCrawl = in.readString();
		title = in.readString();
		url = in.readString();
		characters = in.createStringArrayList();
		episodeId = in.readInt();
		planets = in.createStringArrayList();
		releaseDate = in.readString();
		starships = in.createStringArrayList();
		species = in.createStringArrayList();
		producer = in.readString();
	}

	public static final Creator<ResultsItem> CREATOR = new Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel in) {
			return new ResultsItem(in);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};

	public ResultsItem() {

	}

	public String getEdited(){
		return edited;
	}

	public String getDirector(){
		return director;
	}

	public String getCreated(){
		return created;
	}

	public List<String> getVehicles(){
		return vehicles;
	}

	public String getOpeningCrawl(){
		return openingCrawl;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}

	public List<String> getCharacters(){
		return characters;
	}

	public int getEpisodeId(){
		return episodeId;
	}

	public List<String> getPlanets(){
		return planets;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public List<String> getStarships(){
		return starships;
	}

	public List<String> getSpecies(){
		return species;
	}

	public String getProducer(){
		return producer;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(edited);
		parcel.writeString(director);
		parcel.writeString(created);
		parcel.writeStringList(vehicles);
		parcel.writeString(openingCrawl);
		parcel.writeString(title);
		parcel.writeString(url);
		parcel.writeStringList(characters);
		parcel.writeInt(episodeId);
		parcel.writeStringList(planets);
		parcel.writeString(releaseDate);
		parcel.writeStringList(starships);
		parcel.writeStringList(species);
		parcel.writeString(producer);
	}
}