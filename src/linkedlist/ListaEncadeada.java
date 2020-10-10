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
public class ListaEncadeada<T> {

    private Celula inicio, fim;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    //Adiciona por posição
    public void adicionaPos(T elemento, int posicao) {
        if (!existeDado()) {
            throw new ArrayIndexOutOfBoundsException("A lista se encontra vazia");
        } else if (posicao < 0 || posicao > quantidadeElementos()) {
            throw new ArrayIndexOutOfBoundsException("Posição Inválida");
        } else {
            Celula nova = new Celula();
            if (posicao == 0) {
                AdicionaInicio(elemento);
            } else if (posicao == quantidadeElementos()) {
                AdicionaFim(elemento);
            } else {
                Iterador it = new Iterador(this.inicio);
                int i = 0;
                while (it.hasNext()) {
                    if (quantidadeElementos() == 1) {
                        AdicionaFim(elemento);
                        break;
                    }
                    if (i < posicao - 1) {
                        it.next();
                        i++;
                    } else {
                        nova.setProximo(it.getAtual().getProximo());
                        it.getAtual().setProximo(nova);
                        this.tamanho++;
                        break;
                    }
                }
            }
        }
    }

    //Adiciona um elemeneto no inicio da lista 
    public void AdicionaInicio(T elemento) {
        Celula nova = new Celula(elemento);
        if (this.inicio == null) {
            inicio = nova;
            fim = nova;
            this.tamanho++;
        } else {
            nova.setProximo(inicio);// novo elemento aponta para o inicio
            inicio = nova;
            this.tamanho++;
        }

    }

    //adiciona na ultima posição da lista 
    public void AdicionaFim(T elemento) {
        Celula nova = new Celula(elemento);
        if (this.tamanho == 0) {
            AdicionaInicio(elemento);
        } else {
            this.fim.setProximo(nova);
            fim = nova;
            this.tamanho++;
        }

    }

    //Remove o primeiro elemento
    public void RemoverInicio() {
        if (listaVazia() == true) {
            System.out.println("Lista vazia");
        } else if (quantidadeElementos() == 0) {
            inicio = fim = null;
        } else {
            inicio = inicio.getProximo();
            this.tamanho--;
        }
    }

    //Remover um elemento de qualquer posição da lista 
    public void removerPos(int posicao) {
        if (!existeDado()) {
            throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
        } else if (posicao > tamanho || posicao < 0) {
            throw new ArrayIndexOutOfBoundsException("Posição inválida");
        } else if (quantidadeElementos() == 1 || posicao == 0) {
            RemoverInicio();
        } else {
            if (posicao == quantidadeElementos() - 1) {
                RemoverFim();
            } else {
                Iterador it = new Iterador(this.inicio);
                int i = 0;
                while (it.hasNext()) {
                    if (i < posicao - 1) {
                        it.next();
                        i++;
                    } else {
                        Celula remove = it.getAtual().getProximo();
                        it.getAtual().setProximo(remove.getProximo());
                        remove.setProximo(null);
                        this.tamanho--;
                        break;
                    }
                }
            }
        }

    }

    //remove o ultimo elemento 
    public Celula RemoverFim() {
        int i = 1;
        Iterador it = new Iterador(this.inicio);
        if (quantidadeElementos() == 0) {
            System.out.println("A lista se encotra vazia");
        } else if (this.tamanho == 1) {
            limparLista();
        } else {
            while (it.hasNext()) {
                if (i != quantidadeElementos() - 1) {
                    it.next();
                    i++;
                } else {
                    it.getAtual().setProximo(null);
                    fim = it.getAtual();
                    this.tamanho--;
                    break;
                }
            }
        }
        return null;
    }

    //retorna uma posição na lista 
    public T recuperarPos(int posicao) {
        if (this.tamanho == 0) {
            throw new ArrayIndexOutOfBoundsException("A lista está vazia!");
        } else if (posicao < 0 || posicao >= this.tamanho) {
            throw new ArrayIndexOutOfBoundsException("Posição Inválida");
        } else {
            Iterador it = new Iterador(this.inicio);
            int i = 0;

            while (it.hasNext()) {
                if (i != posicao) {
                    it.next();
                    i++;
                } else {

                    break;
                }
            }
            return (T) it.getAtual().getElemento();
        }
    }

    //retorna a quantidade de elemetosna lista
    public int quantidadeElementos() {
        if (this.tamanho < 0) {
            this.tamanho = 0;
        }
        return this.tamanho;
    }

    //exclui todos os elemenstos da lista
    public void limparLista() {
        if (quantidadeElementos() == 0) {
            System.out.println("A lista ja se encntra vazia");
        } else {
            inicio = fim = null;
            this.tamanho = 0;
        }
    }

    //verifica se a lista esta vazia
    public boolean listaVazia() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    //verifica se existe um dado específico na lista
    public boolean existeDado() {
        return inicio != null;
    }
}
