package springcontroller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MovieRating {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String date;
	
	@NotNull(message="title must not be null")
	@Size(min=3, max=25, message="character length between 3 and 25")
	private String title;
	
	@NotNull(message="rating must not be null")
	@Min(value = 1, message = "minimum rating is 1")
	@Max(value = 5, message = "maximum rating is 5")
	private int rating;	
	
	@NotNull(message="name must not be null")
	@Size(min = 3, max = 25, message = "character length between 3 and 25")
	private String posterName;
	
	public MovieRating() {
		
	}
	
	public MovieRating(String date, long id, String title, int rating, String posterName) {
		super();
		this.date = date;
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.posterName = posterName;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getPosterName() {
		return posterName;
	}

	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}		
	
}
