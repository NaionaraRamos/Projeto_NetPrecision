package com.netprecision.lanchonete.repositorios;

import com.netprecision.lanchonete.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPedido extends JpaRepository<Pedido, Long> { }
