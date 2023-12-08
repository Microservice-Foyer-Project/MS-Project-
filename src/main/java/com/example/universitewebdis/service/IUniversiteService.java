package com.example.universitewebdis.service;

import com.example.universitewebdis.entites.Universite;

import java.util.List;

public interface IUniversiteService {

    Universite addUniversite(Universite universite);

    Universite getUniversite(Long id);

    List<Universite> getAllUniversites();

    void deleteUniversite(Long id);

    Universite updateUniversite(Long id, Universite newUniversite);
}