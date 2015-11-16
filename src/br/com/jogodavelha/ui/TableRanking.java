package br.com.jogodavelha.ui;

import br.com.jogodavelha.VO.RankingVO;
import br.com.jogodavelha.controller.RankingController;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableRanking extends AbstractTableModel {
    
    private static List<RankingVO> ranking;
    private static final String[] colunas = {"Posição", "Jogador", "Pontuação"};
    private static final long serialVersionUID = 1L;
    private int POSICAO;

    public TableRanking() {
        POSICAO = 1;
    }
    
    
    @Override
    public int getRowCount() {
        return ranking.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RankingVO rank = ranking.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return POSICAO;
            case 1:
                POSICAO++;
                return rank.getApelido();
            case 2:
                return rank.getJogos();
            default:
                throw new IndexOutOfBoundsException("ERRO: columnIndex out of bounds");
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    public List<RankingVO> obterRanking() {
        RankingController controller = new RankingController();
        ranking = controller.pegarRanking();
        return ranking;
    }
}

