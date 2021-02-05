package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_table")
public class Movie {
	
	@Id
	@Column(name = "movie_id")
	private int movieID;
	
	@Column(name = "image_url")
	private String imageURL;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "release_date")
	private String releaseDate;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "movie_rating")
	private double movieRating;
	
	@Column(name = "genre")
	private String genre;

	public Movie() {
		super();
	}

	public Movie(int movieID, String imageURL, String title, String description, String releaseDate, String director,
			double movieRating, String genre) {
		super();
		this.movieID = movieID;
		this.imageURL = imageURL;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.director = director;
		this.movieRating = movieRating;
		this.genre = genre;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", imageURL=" + imageURL + ", title=" + title + ", description="
				+ description + ", releaseDate=" + releaseDate + ", director=" + director + ", movieRating="
				+ movieRating + ", genre=" + genre + "]";
	}

	
	
}
