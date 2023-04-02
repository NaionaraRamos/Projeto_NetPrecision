package com.netprecision.lanchonete.servicos;

import com.netprecision.lanchonete.entidades.Pedido;
import com.netprecision.lanchonete.repositorios.RepositorioPedido;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ServicoPedido {

    RepositorioPedido repositorioPedido;

    public List<Pedido> buscarTodos() {
        return repositorioPedido.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return repositorioPedido.findById(id).get();
    }

    public Pedido salvar(Pedido pedido) {
        return repositorioPedido.save(pedido);
    }

    public void excluir(Long id) {
        repositorioPedido.deleteById(id);
    }

    public void adicionarProduto(Long id, int produto) {
        int qtdProdutos = buscarPorId(id).getListaProdutosQuantidade().get(produto);

        if(Objects.isNull(qtdProdutos)) buscarPorId(id).getListaProdutosQuantidade().put(produto, 1);
        else buscarPorId(id).getListaProdutosQuantidade().put(produto, ++qtdProdutos);
    }

    public void removerProduto(Long id, Integer produto) throws Exception {
        int qtdProdutos = buscarPorId(id).getListaProdutosQuantidade().get(produto);

        if(Objects.isNull(qtdProdutos) || qtdProdutos == 0) throw new Exception("Produto não encontrado");
        else buscarPorId(id).getListaProdutosQuantidade().put(produto, --qtdProdutos);
    }

    public double calcularValorTotal(Long id) {
        double valorTotal = 0;
        for(int i : buscarPorId(id).getListaProdutosQuantidade().values()) {
            valorTotal += i;
        }
        return valorTotal;
    }
}
