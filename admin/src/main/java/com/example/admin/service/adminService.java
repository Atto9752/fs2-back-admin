package com.example.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.model.dto.admin;
import com.example.admin.repository.adminRepositorio;

@Service
public class adminService {

    //para que se inicie junto con el repo y no se desconecten uno del otro
    @Autowired
    private adminRepositorio repositorio;

    public List<admin> listarAdmins() {
        return repositorio.findAll();
    }

    public admin guardarAdmin(admin admin) {
        return repositorio.save(admin);
    }

    public void eliminarAdmin(int id) {
        repositorio.deleteById(id);
    }

    public admin buscarAdmin(int id) {
        return repositorio.findById(id).orElse(null);
    }

    public admin actualizarAdmin(int id, admin adminActualizado) {
        admin adminExistente = repositorio.findById(id).orElse(null);
        if (adminExistente != null) {
            adminExistente.setNombre(adminActualizado.getNombre());
            adminExistente.setCorreo(adminActualizado.getCorreo());
            adminExistente.setContrasena(adminActualizado.getContrasena());
            // El rol no se actualiza ya que debe ser siempre "ADMIN"
            return repositorio.save(adminExistente);
        }
        return null;
    }

}
