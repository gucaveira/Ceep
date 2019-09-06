package com.ceep;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ceep.dao.NotaDao;
import com.ceep.model.Nota;
import com.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);
        List<Nota> todasNotas = notaDeExemplo();
        configuraRecyclerView(todasNotas);
    }

    private List<Nota> notaDeExemplo() {
        NotaDao dao = new NotaDao();
        for (int i = 1; i < 1000; i++) {
            dao.insere(new Nota("Titulo" + i, "Descrição" + i));
        }
        return dao.todos();
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclirview);
        configuraAdapter(todasNotas, listaNotas);
    }

    private void configuraAdapter(List<Nota> todasNotas, RecyclerView listaNotas) {
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
    }
}
