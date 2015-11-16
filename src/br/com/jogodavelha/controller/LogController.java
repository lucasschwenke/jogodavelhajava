package br.com.jogodavelha.controller;

import br.com.jogodavelha.entity.Jogador;
import br.com.jogodavelha.entity.Log;
import br.com.jogodavelha.repository.LogRepository;
import java.util.List;

public class LogController {

    private final LogRepository repository;
    
    public LogController() {
        repository = LogRepository.getInstance();
    }
    
    public void salvarLog(Log log) {
        repository.insert(log);
    }
    
    public void limparHistorico(Jogador jogador) {
        int retorno = repository.limparLog(jogador);
    }
    
    public List<Log> pegarHistorico(String apelido) {
        return repository.pegarLog(apelido);
    }
    
}
