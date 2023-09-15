
package br.com.jaia.b1naryinspec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jaia.b1naryinspec.entity.PrestadorServico;
import br.com.jaia.b1naryinspec.service.PrestadorInterface;

@RestController
@RequestMapping(value = "/prestador")
@CrossOrigin
public class PrestadorController{

    @Autowired
    private PrestadorInterface prestador;

    @GetMapping
    public List<PrestadorServico> todosPrestadores(){
        return prestador.buscarTodosPrestadores();
    }

    @GetMapping(value = "/{cnpj}")
    public PrestadorServico buscarPorCnpj(@PathVariable("cnpj") String cnpj){
        return prestador.buscarPrestadoPorCnpj(cnpj);
    }

    @GetMapping(value = "/{email}")
    public PrestadorServico buscarPorEmail(@PathVariable("email") String email){
        return prestador.buscarPrestadorPorEmail(email);
    }

    @PostMapping
    public PrestadorServico novoPrestador(@RequestBody PrestadorServico prestadorServ){
        return prestador.novoPrestador(prestadorServ);
    }
}