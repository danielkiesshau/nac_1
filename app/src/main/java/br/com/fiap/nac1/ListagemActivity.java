package br.com.fiap.nac1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ListagemActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private List<Aluno> alunos;
    private EditText nome;
    private EditText endereco;
    private EditText nascimento;
    private Button cadastrar;
    private Button cancelar;
    private Aluno aluno;
    private MyDataBase db;
    private AlunoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        recycler = findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false);
        recycler.setLayoutManager(layoutManager);
        alunos = new ArrayList<Aluno>();
        consultaUsuarios();
    }

    private void consultaUsuarios() {
        /**
         * Cria a função e a lógica para construlação da consulta no banco de dados e a lógica para popular os dados na tela
         * Caso necessite pode criar outros métodos para lhe apoiar nesta tarefa
         */
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        aluno = alunos.get(adapter.getSelectedPos());
        if (item.getTitle() == "Edit") {
            displayDialog();
        } else if (item.getTitle() == "Delete") {
            adapter.deleteAluno();
            deleteAluno(aluno);
        }
        return super.onContextItemSelected(item);
    }

    private void deleteAluno(Aluno aluno) {
        /**
         * Exclui o aluno da base de dados
         */
    }

    private void displayDialog() {
        /**
         * Abre a tela de dialogo para atualizar os dados do aluno
         */
    }

    public void atualizar() {
        /**
         * Atualiza os dados do aluno no banco de dados
         */
    }
}
