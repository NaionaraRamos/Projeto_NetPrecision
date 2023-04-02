package com.netprecision.lanchonete.controladores;

import com.netprecision.lanchonete.entidades.Pedido;
import com.netprecision.lanchonete.servicos.ServicoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class ControladorPedidos {

    @Autowired
    private ServicoPedido servicoPedido;

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        return servicoPedido.salvar(pedido);
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable("id") Long id) {
        return servicoPedido.buscarPorId(id);
    }

    @PatchMapping("/{id}/{produto}")
    public void adicionarProduto(@PathVariable Long id, int idProduto) {
        servicoPedido.adicionarProduto(id, idProduto);
    }

    @PatchMapping("/{id}/{produto}")
    public void removerProduto(@PathVariable Long id, int idProduto) throws Exception {
        servicoPedido.removerProduto(id, idProduto);
    }

    @GetMapping("/valorTotal/{id}")
    public double calcularValorTotal(@PathVariable Long id) {
        return servicoPedido.calcularValorTotal(id);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        servicoPedido.excluir(id);
    }

    @GetMapping
    public List<Pedido> buscarTodos() {
        return servicoPedido.buscarTodos();
    }
}
