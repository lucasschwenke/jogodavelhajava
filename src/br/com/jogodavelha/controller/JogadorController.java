package br.com.jogodavelha.controller;

import br.com.jogodavelha.entity.Jogador;
import br.com.jogodavelha.repository.JogadorRepository;

public class JogadorController {

    private final JogadorRepository repository;
    
    public JogadorController() {
        repository = JogadorRepository.getInstance();
    }
    
    public void salvarJogador(Jogador jogador) {
        Jogador j = repository.verificarSeExisteJogadorCadastrado(jogador);
        if (j == null) {
            repository.insert(jogador);
        } else {
            jogador.setId(j.getId());
        }
    }

}
