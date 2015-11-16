package br.com.jogodavelha.controller;

import br.com.jogodavelha.VO.RankingVO;
import br.com.jogodavelha.entity.Jogador;
import br.com.jogodavelha.entity.Ranking;
import br.com.jogodavelha.entity.RankingPK;
import br.com.jogodavelha.repository.JogadorRepository;
import br.com.jogodavelha.repository.RankingRepository;
import java.util.List;

public class RankingController {

    private final RankingRepository repository;

    public RankingController() {
        repository = RankingRepository.getInstance();
    }

    public boolean salvarRanking(Ranking ranking) {
        Jogador jogador = ranking.getJogador();
        boolean mudou = false;
        if (jogador.getId() == null) {
            JogadorRepository repository1 = JogadorRepository.getInstance();
            jogador = repository1.verificarSeExisteJogadorCadastrado(jogador);
            ranking.setJogador(jogador);
        }

        Ranking atualRanking = repository.verificarRankingDoJogador(jogador);
        if (atualRanking == null) {
            RankingPK pk = new RankingPK();
            pk.setIdJogador(jogador.getId());
            ranking.setRankingPK(pk);
            repository.insert(ranking);
            mudou = true;
        } else if (atualRanking.getJogos() < ranking.getJogos()) {
            atualRanking.setJogos(ranking.getJogos());
            repository.update(atualRanking);
            mudou = true;
        }

        return mudou;
    }

    public List<RankingVO> pegarRanking() {
        return repository.obterRanking();
    }

}
