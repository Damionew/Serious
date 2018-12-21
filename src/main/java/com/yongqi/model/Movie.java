package com.yongqi.model;

import java.util.List;

/**
 * 电影实体类
 * @author yinyunqi
 * 2018年12月18日15:50:15
 */
public class Movie {
	String moviename;
	String image;
	String score;
	String commentsamount;
	String director;
	String scenario;
	String staring;
	String movietype;
	String releasedate;
	String runtime;
	String intro;
	// 存放影评
	List<MovieComment> movieComments;
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
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
	
	public String getCommentsamount() {
		return commentsamount;
	}
	public void setCommentsamount(String commentsamount) {
		this.commentsamount = commentsamount;
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
	public String getMovietype() {
		return movietype;
	}
	public void setMovietype(String movietype) {
		this.movietype = movietype;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
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
	
}
