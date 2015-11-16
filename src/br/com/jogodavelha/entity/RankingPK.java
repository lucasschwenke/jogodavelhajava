package br.com.jogodavelha.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RankingPK implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    
    @Column(name = "id_jogador")
    private int idJogador;

    public RankingPK() {
    }

    public RankingPK(int id, int idJogador) {
        this.id = id;
        this.idJogador = idJogador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idJogador;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RankingPK)) {
            return false;
        }
        RankingPK other = (RankingPK) object;
        if (this.id != other.id) {
            return false;
        }
        return this.idJogador == other.idJogador;
    }

    @Override
    public String toString() {
        return "br.com.jogodavelha.entity.RankingPK[ id=" + id + ", idJogador=" + idJogador + " ]";
    }
    
}
