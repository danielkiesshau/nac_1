package br.com.fiap.nac1;

import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText dataNascimento;
    private EditText nome;
    private EditText endereco;
    private Button cadastrar;
    private Button listar;
    private Date dataUsuario;
    private MyDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = MyDataBase.getMyInstance(getApplicationContext());


        /**
         * Inicializa o componente de edittext que receberá a data selecionada
         */
        dataNascimento = findViewById(R.id.dataNascimento);
        /**
         * Configura o evento onClick para o edittext que recebe nossa data selecionada
         */
        dataNascimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Fecha nosso teclado
                 */
                ((InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                        dataNascimento.getWindowToken(), 0);
                /**
                 * Inicializa nosso DatePicker
                 */
                DialogFragment datePicker = new DatePickerFragment();
                /**
                 * Abre nosso fragment com um datepicker
                 */
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        nome = findViewById(R.id.nome);
        endereco = findViewById(R.id.endereco);
        cadastrar = findViewById(R.id.cadastrar);
        listar = findViewById(R.id.listar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nome.getText().toString();
                String e = endereco.getText().toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
                Date d = null;
                try {
                    d = dateFormat.parse(dataNascimento.getText().toString());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

                cadastrar(new Aluno(n,e,d));
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Abre a tela de listagem
                 */
                Intent intent = new Intent(getApplicationContext(), ListagemActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        dataUsuario = c.getTime();
        String dataSelecionada = DateFormat.getDateInstance().format(c.getTime());
        dataNascimento.setText(dataSelecionada);
    }

    public void cadastrar(final Aluno aluno) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.alunoDao().insert(aluno);
                Log.d("Nome",db.alunoDao().getAll().get(0).getEndereco());
            }
        }).start();
    }
}
