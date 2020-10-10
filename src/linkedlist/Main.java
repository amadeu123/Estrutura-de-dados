/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author Amadeu Martim Silva De Oliveira
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aluno verLista = null;
        Aluno a1 = new Aluno("Anderson", 42);
        Aluno a2 = new Aluno("Ana", 31);
        Aluno a3 = new Aluno("José", 23);
        Aluno a4 = new Aluno("mariazinha", 44);
        Aluno a5 = new Aluno("joana", 55);

        ListaEncadeada lista = new ListaEncadeada();

        lista.AdicionaFim(a1); //ok
        lista.AdicionaFim(a2); //ok
        lista.AdicionaFim(a3); //ok
        lista.AdicionaInicio(a4); //ok
        lista.adicionaPos(a5, 4); //ok
        
        lista.removerPos(0); //ok
        
        lista.RemoverFim(); //ok
        
//        lista.limparLista(); // ok

        for (int i = 0; i < lista.quantidadeElementos(); i++) {
            verLista = (Aluno) lista.recuperarPos(i);
            System.out.println(verLista.getNome() + " - " + verLista.getIdade());
        }

        System.out.println(lista.quantidadeElementos());

    }

}
