
package Modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TabelaDTO extends AbstractTableModel{
    
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public TabelaDTO(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    /* Método = Contagem do número de colunas */
    //@Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    /* Método = Contagem do número de linhas */
    //@Override
    public int getRowCount(){
        return linhas.size();
    }
    
    /* Método = absorve o nome da coluna e retorna o número de colunas */
    //@Override
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    
    /* Método = constroi a tabela de resultados */
    //@Override
    public Object getValueAt(int numLin, int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
    
}
