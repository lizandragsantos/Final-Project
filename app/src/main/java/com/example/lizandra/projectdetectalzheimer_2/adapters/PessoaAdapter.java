package com.example.lizandra.projectdetectalzheimer_2.adapters;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lizandra.projectdetectalzheimer_2.R;
import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.interfaces.OnRecyclerViewItemClickListener;
import com.example.lizandra.projectdetectalzheimer_2.view.MenuItemClickListener;

import java.util.List;

/**
 * Created by LIZANDRA on 23/06/2017.
 */

public class PessoaAdapter extends RecyclerView.Adapter<PessoaAdapter.ViewHolder> {

    private List<Individuo> pessoas;
    private LayoutInflater layoutinflater;

    public PessoaAdapter(List<Individuo> pessoas, Context context) {
        this.pessoas = pessoas;
        this.layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public PessoaAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.i("LOG", "onCreateViewHolder()");
        View view = layoutinflater.inflate(R.layout.item_pessoa_card, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.i("LOG", "onBindViewHolder()");
        holder.tvnome.setText(pessoas.get(position).getNome());
        holder.tvescolaridade.setText(pessoas.get(position).getEscolaridade());
        holder.tvidade.setText(pessoas.get(position).getIdade()+" Anos");

        holder.imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                showPopupMenu(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pessoas.size();
    }

    public void addListItem(Individuo p, int position){
        pessoas.add(p);
        notifyItemInserted(position);
    }

    public void removeListItem(Individuo p, int position){
        pessoas.remove(p);
        notifyItemRemoved(position);
    }

    private void showPopupMenu(View view,int position) {
        // inflate menu
        PopupMenu popup = new PopupMenu(view.getContext(),view );
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popmenu_item_detail, popup.getMenu());
        popup.setOnMenuItemClickListener(new MenuItemClickListener(view, position));
        popup.show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvnome;
        public TextView tvescolaridade;
        public TextView tvidade;
        private ImageButton imagebutton;

        public ViewHolder(View itemView) {
            super(itemView);
            imagebutton = (ImageButton) itemView.findViewById(R.id.ib_item_detail);
            tvnome = (TextView) itemView.findViewById(R.id.tv_nome);
            tvescolaridade = (TextView) itemView.findViewById(R.id.tv_escolaridade);
            tvidade = (TextView) itemView.findViewById(R.id.tv_idade);
        }
    }



}
