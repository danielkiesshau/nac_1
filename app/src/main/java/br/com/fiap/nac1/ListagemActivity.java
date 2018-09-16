package br.com.fiap.nac1;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
        db = MyDataBase.getMyInstance(getApplicationContext());
        recycler = findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,
                false);
        recycler.setLayoutManager(layoutManager);
        alunos = new ArrayList<Aluno>();
        consultaUsuarios();
    }

    private void consultaUsuarios() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("Nome",db.alunoDao().getAll().get(0).getEndereco());
                adapter = new AlunoAdapter(db.alunoDao().getAll(), ListagemActivity.this);
            }
        });
        recycler.setAdapter(adapter);
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
