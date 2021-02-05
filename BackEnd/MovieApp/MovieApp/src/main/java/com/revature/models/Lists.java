package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lists_table_2")
public class Lists {
	
	@Id
	@Column(name = "list_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int listID;
	
	@Column(name = "movie_id", nullable = false)
	private int movieID;
	
	@Column(name = "movie_like")
	private boolean movieLike;
	
	@Column(name = "movie_watch_list")
	private boolean movieWatchList;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public Lists() {
		super();
	}

	public Lists(int listId, int movieID, boolean movieLike, boolean movieWatchList, User user) {
		super();
		this.listID = listId;
		this.movieID = movieID;
		this.movieLike = movieLike;
		this.movieWatchList = movieWatchList;
		this.user = user;
	}

	public int getListId() {
		return listID;
	}

	public void setFeatureId(int listId) {
		this.listID = listId;
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public boolean isMovieLike() {
		return movieLike;
	}

	public void setMovieLike(boolean movieLike) {
		this.movieLike = movieLike;
	}

	public boolean isMovieWatchList() {
		return movieWatchList;
	}

	public void setMovieWatchList(boolean movieWatchList) {
		this.movieWatchList = movieWatchList;
	}

	public User getUserID() {
		return user;
	}

	public void setUserID(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Lists [listId=" + listID + ", movieID=" + movieID + ", movieLike=" + movieLike
				+ ", movieWatchList=" + movieWatchList + ", user=" + user + "]";
	}
	
}
