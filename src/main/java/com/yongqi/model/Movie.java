package com.yongqi.model;

import java.util.List;

/**
 * 电影实体类
 * @author yinyunqi
 * 2018年12月18日15:50:15
 */
public class Movie {
	String id;
	String movieName;
	String movieUrl;
	String image;
	String score;
	String commentsAmount;
	String director;
	String scenario;
	String staring;
	String movieType;
	String releaseDate;
	String runtime;
	String intro;
	
	public String getMovieUrl() {
		return movieUrl;
	}
	public void setMovieUrl(String movieUrl) {
		this.movieUrl = movieUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	// 存放影评
	List<MovieComment> movieComments;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public String getStaring() {
		return staring;
	}
	public void setStaring(String staring) {
		this.staring = staring;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public List<MovieComment> getMovieComments() {
		return movieComments;
	}
	public void setMovieComments(List<MovieComment> movieComments) {
		this.movieComments = movieComments;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getCommentsAmount() {
		return commentsAmount;
	}
	public void setCommentsAmount(String commentsAmount) {
		this.commentsAmount = commentsAmount;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
