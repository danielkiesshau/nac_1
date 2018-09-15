package br.com.fiap.nac1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoViewHolder> {

    private ArrayList<Aluno> Alunos;
    private Context context;
    private int selectedPos;

    public AlunoAdapter(List<Aluno> Alunos, Context context) {
        this.Alunos = (ArrayList<Aluno>) Alunos;
        this.context = context;
    }

    @NonNull
    @Override
    public AlunoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        AlunoViewHolder AlunoViewHolder = new AlunoViewHolder(view);
        return AlunoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlunoViewHolder holder, int position) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);
        Aluno AlunoPosicao = Alunos.get(position);
        holder.nome.setText(AlunoPosicao.getNome());
        holder.endereco.setText(AlunoPosicao.getEndereco());
        if(AlunoPosicao.getNascimento() != null) {
            holder.nascimento.setText(format.format(AlunoPosicao.getNascimento()));
        }
        holder.setLongClickListener(new MyLongClickListener() {
            @Override
            public void onLongClick(int pos) {
                selectedPos = pos;
            }
        });
        holder.setClickListener(new MyClickListener() {
            @Override
            public void onClick(int pos) {
                selectedPos = pos;
                Toast.makeText(context, "Posição clicada:" + pos, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Alunos != null ? Alunos.size() : 0;
    }
    public void deleteAluno()
    {
        Aluno Aluno = Alunos.get(selectedPos);
        int id = selectedPos;

        if(Alunos.remove(Aluno))
        {
            Toast.makeText(context,"Exclusão realizada com sucesso-" + selectedPos,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Unable To Delete",Toast.LENGTH_SHORT).show();
        }

        this.notifyItemRemoved(selectedPos);
    }

    public int getSelectedPos() {
        return selectedPos;
    }
}
