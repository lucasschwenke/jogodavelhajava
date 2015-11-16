package br.com.jogodavelha.repository;

import br.com.jogodavelha.VO.RankingVO;
import br.com.jogodavelha.entity.Jogador;
import br.com.jogodavelha.entity.Ranking;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class RankingRepository extends GenericRepository {

    private static RankingRepository instance;

    public static RankingRepository getInstance() {
        if (instance == null) {
            instance = new RankingRepository();
        }
        return instance;
    }

    public Ranking verificarRankingDoJogador(Jogador jogador) {
        Ranking ranking;
        try {
            StringBuilder stringBuilder = new StringBuilder("FROM Ranking r ");
            stringBuilder.append("WHERE r.rankingPK.idJogador = :idJogador");
            if (!entityManager.isOpen()) {
                getEntityManager();
            }
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(stringBuilder.toString());
            query.setParameter("idJogador", jogador.getId());
            ranking = (Ranking) query.getSingleResult();
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            ranking = null;
        } finally {
            entityManager.close();
        }

        return ranking;
    }

    public List<RankingVO> obterRanking() {
        List<RankingVO> lista = new ArrayList<>();
        try {
            StringBuilder string = new StringBuilder("SELECT j.apelido as Apelido, r.jogos as Jogos ");
            string.append("FROM ranking r ");
            string.append("INNER JOIN jogador j ON j.id = r.id_jogador ");
            string.append("ORDER BY r.jogos DESC LIMIT 10");
            if (!entityManager.isOpen()) {
                getEntityManager();
            }
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery(string.toString());
            lista = (List<RankingVO>) query.unwrap(SQLQuery.class)
                    .addScalar("Apelido", StringType.INSTANCE)
                    .addScalar("Jogos", IntegerType.INSTANCE)
                    .setResultTransformer(Transformers.aliasToBean(RankingVO.class))
                    .list();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return lista;

    }

}
