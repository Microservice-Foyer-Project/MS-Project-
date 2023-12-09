package com.example.blocms.services;

import com.example.blocms.entities.Bloc;

import java.util.List;

public interface IBloc {
    Bloc addBloc(Bloc bloc) ;
    Bloc getBloc(long idBloc );
    List<Bloc> getAllBloc();
    void deleteBloc(long idBloc);
    Bloc updateBloc(Bloc bloc);
}
