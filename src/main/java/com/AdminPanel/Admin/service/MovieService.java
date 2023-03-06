package com.AdminPanel.Admin.service;

import com.AdminPanel.Admin.dto.MovieDTO;
import com.AdminPanel.Admin.dto.request.RequestMovieSaveDTO;
import com.AdminPanel.Admin.dto.request.RequestMovieUpdateDTO;
import javassist.NotFoundException;

import java.util.List;

public interface MovieService {
    String addMovie(RequestMovieSaveDTO requestMovieSaveDTO);

    String updateMOvie(RequestMovieUpdateDTO requestUserUpdateDTO);

    boolean deleteMovie(int id) throws NotFoundException;

    List<MovieDTO> getAllMovie();

    int countAllMovie();
}
