package br.com.fiap.nac1;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

public class AlunoViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener, View.OnCreateContextMenuListener {

    TextView nome, endereco, nascimento;
    MyLongClickListener longClickListener;
    MyClickListener clickListener;

    public AlunoViewHolder(View itemView) {
        super(itemView);
        nome = (TextView) itemView.findViewById(R.id.nome);
        endereco = (TextView) itemView.findViewById(R.id.endereco);
        nascimento = (TextView) itemView.findViewById(R.id.nascimento);
        itemView.setOnLongClickListener(this);
        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Ações : ");
        menu.add(0,0,0,"Edit");
        menu.add(0,1,0,"Delete");
    }


    public void setLongClickListener(MyLongClickListener longClickListener)
    {
        this.longClickListener = longClickListener;
    }

    @Override
    public boolean onLongClick(View v) {
        this.longClickListener.onLongClick(getLayoutPosition());
        return false;
    }

    public void setClickListener(MyClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public void onClick(View v) {
        this.clickListener.onClick(getLayoutPosition());
    }

}
