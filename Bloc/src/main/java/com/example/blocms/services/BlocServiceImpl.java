package com.example.blocms.services;

import com.example.blocms.entities.Bloc;
import com.example.blocms.repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBloc{


    BlocRepository blocRepository ;
    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc) ;
    }

    @Override
    public Bloc getBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public List<Bloc> getAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public void deleteBloc(long idBloc) {
         blocRepository.deleteById(idBloc);

    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
}
