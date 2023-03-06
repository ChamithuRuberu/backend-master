package com.AdminPanel.Admin.service.impl;

import com.AdminPanel.Admin.dto.MovieDTO;
import com.AdminPanel.Admin.dto.request.RequestMovieSaveDTO;
import com.AdminPanel.Admin.dto.request.RequestMovieUpdateDTO;
import com.AdminPanel.Admin.entity.Movie;
import com.AdminPanel.Admin.repo.MovieRepo;
import com.AdminPanel.Admin.service.MovieService;
import com.AdminPanel.Admin.util.StanderResponse;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceIMPL implements MovieService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MovieRepo movieRepo;


    @Override
    public String addMovie(RequestMovieSaveDTO requestMovieSaveDTO) {
        Movie movie=new Movie(
                requestMovieSaveDTO.getMovieName(),
               requestMovieSaveDTO.getDescription(),
               requestMovieSaveDTO.getReleaseDate(),
               requestMovieSaveDTO.getDirector(),
               requestMovieSaveDTO.getDuration(),
               requestMovieSaveDTO.getPhoto(),
               true
        );
        movieRepo.save(movie);
        return movie.getMovieId() + " saved..!";

    }

    @Override
    public String updateMOvie(RequestMovieUpdateDTO requestMovieUpdateDTO) {
        if (movieRepo.existsById(requestMovieUpdateDTO.getMovieId())) {
            Movie movie = movieRepo.getById(requestMovieUpdateDTO.getMovieId());
            movie.setMovieName(requestMovieUpdateDTO.getMovieName());
            movie.setDescription(requestMovieUpdateDTO.getDescription());
            movie.setReleaseDate(requestMovieUpdateDTO.getReleaseDate());
            movie.setDirector(requestMovieUpdateDTO.getDirector());
            movie.setDuration(requestMovieUpdateDTO.getDuration());
            return movieRepo.save(movie).getMovieName();
        }
        return "Not in DATABASE";
    }

    @Override
    public boolean deleteMovie(int id) throws NotFoundException {
        if (movieRepo.existsById(id)) {
            movieRepo.deleteById(id);
        } else {
            throw new NotFoundException("not found member for this id");
        }
        return true;
    }

    @Override
    public List<MovieDTO> getAllMovie() {
        List<Movie> getMovie = movieRepo.findAll();
        List<MovieDTO> movieDTOS = new ArrayList<>();

        List<MovieDTO> movieDTOS1 = modelMapper.
                map(getMovie, new TypeToken<List<MovieDTO>>() {
                }.getType());
        return movieDTOS1;
    }

    @Override
    public int countAllMovie() {
        int count =movieRepo.countByActivestateEquals(true);
        return count;
    }
}
