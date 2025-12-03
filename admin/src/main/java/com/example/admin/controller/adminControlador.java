package com.example.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.admin.model.dto.admin;
import com.example.admin.service.adminService;

@RestController
@RequestMapping("/api/v1/admins")
public class adminControlador {

    //para que cuando se levante el controlador se inicie el servicio 
    @Autowired
    private adminService servicio;

    @GetMapping
    public List<admin> listarAdmins() {
        return servicio.listarAdmins();
    }

    @PostMapping
    public admin guardarAdmin(admin admin) {
        return servicio.guardarAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void eliminarAdmin(int id) {
        servicio.eliminarAdmin(id);
    }

    @GetMapping("/{id}")
    public admin buscarAdmin(int id) {
        return servicio.buscarAdmin(id);
    }

    @PutMapping("/{id}")
    public admin actualizarAdmin(int id, admin adminActualizado) {
        return servicio.actualizarAdmin(id, adminActualizado);
    }

}
