package com.yongqi.model;

/**
 * 影评实体类
 * @author yinyunqi
 * 2018年12月18日15:54:19
 */
public class MovieComment {
	String moviename;
	String avater;
	String comment;
	String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getAvater() {
		return avater;
	}
	public void setAvater(String avater) {
		this.avater = avater;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
