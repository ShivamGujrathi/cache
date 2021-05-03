package com.example.movief;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Serializable {

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

}