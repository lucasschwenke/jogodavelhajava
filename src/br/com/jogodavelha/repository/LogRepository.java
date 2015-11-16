package br.com.jogodavelha.repository;

import br.com.jogodavelha.entity.Jogador;
import br.com.jogodavelha.entity.Log;
import static br.com.jogodavelha.repository.GenericRepository.entityManager;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class LogRepository extends GenericRepository {

    private static LogRepository instance;

    public static LogRepository getInstance() {
        if (instance == null) {
            instance = new LogRepository();
        }
        return instance;
    }

    public int limparLog(Jogador jogador) {
        int retorno = 0;
        try {
            StringBuilder hql = new StringBuilder("DELETE FROM Log ");
            hql.append("WHERE idJogador = :idJogador");
            if (!entityManager.isOpen()) {
                getEntityManager();
            }
            entityManager.getTransaction().begin();        
            Query query = entityManager.createQuery(hql.toString());
            query.setParameter("idJogador", jogador);
            retorno = query.executeUpdate();
            entityManager.getTransaction().commit();
            return retorno;            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }
    
    public List<Log> pegarLog(String apelido) {
        try {
            StringBuilder hql = new StringBuilder("FROM Log ");
            hql.append("WHERE idJogador.apelido = :apelido");
            if (!entityManager.isOpen()) {
                getEntityManager();
            }
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(hql.toString());
            query.setParameter("apelido", apelido); 
            List<Log> lista = (List<Log>)query.getResultList();
            entityManager.getTransaction().commit();
            return lista;
        } catch (NoResultException e) {
            return null;
        }
    }

}
