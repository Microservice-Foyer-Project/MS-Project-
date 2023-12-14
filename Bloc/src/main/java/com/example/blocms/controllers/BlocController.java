package com.example.blocms.controllers;


import com.example.blocms.entities.Bloc;
import com.example.blocms.services.BlocServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BlocController {


    BlocServiceImpl blocService ;

    @PostMapping("/addbloc")
    Bloc addBloc(@RequestBody Bloc bloc)
    {
        return blocService.addBloc(bloc);
    }


    @GetMapping("/bloc")
    List<Bloc> GetAllBloc()
    {
        return blocService.getAllBloc();
    }


    @GetMapping("/bloc/{id}")
    Bloc GetBlocById(@PathVariable Long id)
    {
        return blocService.getBloc(id);
    }


    @DeleteMapping("/bloc/{id}")
    void deleteBloc(@PathVariable Long id )
    {
        blocService.deleteBloc(id);
    }

    @PutMapping("/bloc/update")
    Bloc updateBloc(@RequestBody Bloc bloc)
    {
        return blocService.updateBloc(bloc);
    }



}
