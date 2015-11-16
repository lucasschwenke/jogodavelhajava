package br.com.jogodavelha.repository;

import br.com.jogodavelha.entity.Jogador;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class JogadorRepository extends GenericRepository {
    
    private static JogadorRepository instance;
    
    public static JogadorRepository getInstance() {
        if (instance == null) {
            instance = new JogadorRepository();
        }
        return instance;
    }
    
    public Jogador verificarSeExisteJogadorCadastrado(Jogador jogador) {
        Jogador resultSet = null;
        try {
            StringBuilder stringBuilder = new StringBuilder("FROM Jogador j ");
            stringBuilder.append("WHERE j.apelido = :apelido");
            if (!entityManager.isOpen()) {
                getEntityManager();
            }            
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(stringBuilder.toString());
            query.setParameter("apelido", jogador.getApelido());
            resultSet = (Jogador) query.getSingleResult();
            entityManager.getTransaction().commit();
        } catch (NoResultException e) {
            return resultSet;
        } finally {
            entityManager.close();
        }
        
        return resultSet;
    }
    
}
