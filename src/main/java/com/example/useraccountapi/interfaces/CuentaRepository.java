package com.example.useraccountapi.interfaces;

import com.example.useraccountapi.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {

}
