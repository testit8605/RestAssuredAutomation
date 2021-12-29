package serializationDeserialization;

import java.io.Serializable;

public class VideoGame implements Serializable
{
	
	public int id = 0;
	public String name;
	public String releaseData;
	public int reviewScore;
	public String category;
	public String rating;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReleaseData() {
		return releaseData;
	}
	public void setReleaseData(String releaseData) {
		this.releaseData = releaseData;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String toString()
	{
		return (this.id+ " "+ this.name+ " "+ this.releaseData+ " "+ this.reviewScore+ " "+ this.category+ " "+ this.rating);
	}
	
	
	

}
