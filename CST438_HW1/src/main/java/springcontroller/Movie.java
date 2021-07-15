package springcontroller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Movie{ //		localhost:8080
	
	@Autowired
	MovieRatingRepository movieRatingRepository;
	
	@GetMapping("/movies/new")
	public String createMovieRating(Model model) {
		MovieRating movierating = new MovieRating();
		model.addAttribute("movierating", movierating);
		return "movie_form";
	}
	
	@PostMapping("/movies/new")
	public String processMovieForm(@Valid @ModelAttribute("movierating")
			MovieRating movierating,	
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "movie_form";
		}		
		movieRatingRepository.save(movierating);
		model.addAttribute("time", new java.util.Date().toString()); 
		return "movie_show";
	}

	@GetMapping("/movies")
	public String getAllMovieRatings(Model model) {
		Iterable<MovieRating> movieratings = movieRatingRepository.findAllMovieRatingsOrderByTitleDateDesc();
		model.addAttribute("movieratings", movieratings);
		return "movies_list";
	}
}
