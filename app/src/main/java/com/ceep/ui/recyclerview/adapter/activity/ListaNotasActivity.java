package com.ceep.ui.recyclerview.adapter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ceep.R;
import com.ceep.dao.NotaDao;
import com.ceep.model.Nota;
import com.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    private ListaNotasAdapter adapter;
    private List<Nota> todasNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);
        this.todasNotas = notaDeExemplo();
        List<Nota> todasNotas = this.todasNotas;
        configuraRecyclerView(todasNotas);

        TextView botaoInsereNota = findViewById(R.id.lista_notas_insere_nota);
        botaoInsereNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iniciaFormulario = new Intent(ListaNotasActivity.this,
                        FormularioNotaActivity.class);
                startActivity(iniciaFormulario);
            }
        });

    }

    @Override
    protected void onResume() {
        NotaDao dao = new NotaDao();
        todasNotas.clear();
        todasNotas.addAll(dao.todos());
        adapter.notifyDataSetChanged();
        super.onResume();
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
        adapter = new ListaNotasAdapter(this, todasNotas);
        listaNotas.setAdapter(adapter);
    }
}
