package com.example.blocms.controllers;


import com.example.blocms.entities.Bloc;
import com.example.blocms.services.BlocServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {


    BlocServiceImpl blocService ;

    @PostMapping("/add")
    Bloc addBloc(@RequestBody Bloc bloc)
    {
        return blocService.addBloc(bloc);
    }


    @GetMapping("")
    List<Bloc> GetAllBloc()
    {
        return blocService.getAllBloc();
    }


    @GetMapping("/{id}")
    Bloc GetBlocById(@PathVariable Long id)
    {
        return blocService.getBloc(id);
    }


    @DeleteMapping("/{id}")
    void deleteBloc(@PathVariable Long id )
    {
        blocService.deleteBloc(id);
    }

    @PutMapping("/update")
    Bloc updateBloc(@RequestBody Bloc bloc)
    {
        return blocService.updateBloc(bloc);
    }



}
