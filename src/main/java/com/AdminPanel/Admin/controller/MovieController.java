package com.AdminPanel.Admin.controller;

import com.AdminPanel.Admin.dto.MovieDTO;
import com.AdminPanel.Admin.dto.UserDTO;
import com.AdminPanel.Admin.dto.request.RequestMovieSaveDTO;
import com.AdminPanel.Admin.dto.request.RequestMovieUpdateDTO;
import com.AdminPanel.Admin.service.MovieService;
import com.AdminPanel.Admin.util.StanderResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/saveMovie")
    public ResponseEntity<StanderResponse> saveMovie(@RequestBody RequestMovieSaveDTO requestMovieSaveDTO) {
        String id = movieService.addMovie(requestMovieSaveDTO);
        return new ResponseEntity<StanderResponse>(
                new StanderResponse(201, id + " Saved Succecfully ", id),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/updateMovie")
    public String updateMovie(@RequestBody RequestMovieUpdateDTO requestUserUpdateDTO) {
        String updated = movieService.updateMOvie(requestUserUpdateDTO);
        return updated + " updated";
    }

    @DeleteMapping(
            path = {"/delete-Movie/{id}"}
    )
    public String deleteMovie(@PathVariable(value = "id") int id) throws NotFoundException {
        boolean deleteMovie = movieService.deleteMovie(id);
        return " deleted";
    }


    @GetMapping(
            path = "get-all-Movie"
    )
    public ResponseEntity<StanderResponse> getallMovie() {

        List<MovieDTO> movieDTOS = movieService.getAllMovie();
        return new ResponseEntity<StanderResponse>(

                new StanderResponse(200," done",movieDTOS),
                HttpStatus.OK
        );
    }
    @GetMapping(
            path = "count-all-Movies"
    )
    public ResponseEntity<StanderResponse> getAllMovieCount(){

        int suplimentCount = movieService.countAllMovie();

        return new ResponseEntity<StanderResponse>(
                new StanderResponse(200, " done",suplimentCount),
                HttpStatus.OK
        );
    }
}

