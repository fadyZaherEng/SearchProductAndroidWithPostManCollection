package com.example.revisionandroid.pogo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("image")
	private String image;

	@SerializedName("images")
	private List<String> images;

	@SerializedName("price")
	private int price;

	@SerializedName("in_cart")
	private boolean inCart;

	@SerializedName("in_favorites")
	private boolean inFavorites;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	public String getImage(){
		return image;
	}

	public List<String> getImages(){
		return images;
	}

	public int getPrice(){
		return price;
	}

	public boolean isInCart(){
		return inCart;
	}

	public boolean isInFavorites(){
		return inFavorites;
	}

	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}
}