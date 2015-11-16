package br.com.jogodavelha.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Ranking.findAll", query = "SELECT r FROM Ranking r"),
    @NamedQuery(name = "Ranking.findById", query = "SELECT r FROM Ranking r WHERE r.rankingPK.id = :id"),
    @NamedQuery(name = "Ranking.findByIdJogador", query = "SELECT r FROM Ranking r WHERE r.rankingPK.idJogador = :idJogador"),
    @NamedQuery(name = "Ranking.findByJogos", query = "SELECT r FROM Ranking r WHERE r.jogos = :jogos")})
public class Ranking implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected RankingPK rankingPK;
    
    private int jogos;
    
    @JoinColumn(name = "id_jogador", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne
    private Jogador jogador;

    public Ranking() {
    }

    public Ranking(RankingPK rankingPK) {
        this.rankingPK = rankingPK;
    }

    public Ranking(RankingPK rankingPK, int jogos) {
        this.rankingPK = rankingPK;
        this.jogos = jogos;
    }

    public Ranking(int id, int idJogador) {
        this.rankingPK = new RankingPK(id, idJogador);
    }

    public RankingPK getRankingPK() {
        return rankingPK;
    }

    public void setRankingPK(RankingPK rankingPK) {
        this.rankingPK = rankingPK;
    }

    public int getJogos() {
        return jogos;
    }

    public void setJogos(int jogos) {
        this.jogos = jogos;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rankingPK != null ? rankingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ranking)) {
            return false;
        }
        Ranking other = (Ranking) object;
        return !((this.rankingPK == null && other.rankingPK != null) || (this.rankingPK != null && !this.rankingPK.equals(other.rankingPK)));
    }

    @Override
    public String toString() {
        return "br.com.jogodavelha.entity.Ranking[ rankingPK=" + rankingPK + " ]";
    }
    
}
