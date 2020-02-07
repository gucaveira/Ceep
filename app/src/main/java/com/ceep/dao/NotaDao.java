package com.ceep.dao;

import com.ceep.model.Nota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NotaDao {

    private static final ArrayList<Nota> notas = new ArrayList();

    public List<Nota> todos() {
        return (List<Nota>) notas.clone();
    }

    public void insere(Nota... notas) {
        NotaDao.notas.addAll(Arrays.asList(notas));
    }

    public void altera(int posicao, Nota nota) {
        notas.set(posicao, nota);
    }

    public void remove(int posicao) {
        notas.remove(posicao);
    }

    public void troca(int posicaoInicia, int posicaoFinal) {
        Collections.swap(notas, posicaoInicia, posicaoFinal);
    }

    public void removeTodos() {
        notas.clear();
    }
}