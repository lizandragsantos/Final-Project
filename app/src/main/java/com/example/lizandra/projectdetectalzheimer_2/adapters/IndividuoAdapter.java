package com.example.lizandra.projectdetectalzheimer_2.adapters;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lizandra.projectdetectalzheimer_2.R;
import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.interfaces.OnPopupMenuListener;

import java.util.List;

/**
 * Created by LIZANDRA on 23/06/2017.
 */

public class IndividuoAdapter extends RecyclerView.Adapter<IndividuoAdapter.ViewHolder> {

    private List<Individuo> listIndividuos;
    private LayoutInflater layoutinflater;
    private OnPopupMenuListener popupMenuListener;


    public IndividuoAdapter(List<Individuo> listIndividuos, Context context) {
        this.listIndividuos = listIndividuos;
        this.layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public IndividuoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.i("LOG", "onCreateViewHolder()");
        View view = layoutinflater.inflate(R.layout.item_pessoa_card, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    public void setPopupMenuListner(OnPopupMenuListener popupMenuListener){
        this.popupMenuListener = popupMenuListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.i("LOG", "onBindViewHolder()");
        holder.tvnome.setText((listIndividuos.get(position).getNome()));
        holder.tvescolaridade.setText(listIndividuos.get(position).getEscolaridade());
        holder.tvidade.setText((listIndividuos.get(position).getIdade())+" Anos");

    }

    @Override
    public int getItemCount() {
        return listIndividuos.size();
    }

    public List<Individuo> getItems() {
        return listIndividuos;
    }

    public void setItems(List<Individuo> mItems) {
        this.listIndividuos = mItems;
        notifyDataSetChanged();
    }

    public void addListItem(Individuo item, int position){
        listIndividuos.add(item);
        notifyItemInserted(position);
    }

    public void removeListItem(Individuo item, int position){
        listIndividuos.remove(item);
        notifyItemRemoved(position);
    }

    public Individuo getItem(int position) {
        return (getItems() != null && !getItems().isEmpty()) ? getItems().get(position) : null ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements PopupMenu.OnMenuItemClickListener {
        public TextView tvnome;
        public TextView tvescolaridade;
        public TextView tvidade;
        private ImageButton imagebutton;

        public ViewHolder(View itemView) {
            super(itemView);
            imagebutton = (ImageButton) itemView.findViewById(R.id.ib_item_detail);
            tvnome = (TextView) itemView.findViewById(R.id.tv_nome);
            tvescolaridade = (TextView) itemView.findViewById(R.id.tv_escolaridade);
            tvidade = (TextView) itemView.findViewById(R.id.tv_idade2);

            imagebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    showPopupMenu(v);
                }
            });


        }

        private void showPopupMenu(View view) {
            // inflate menu
            PopupMenu popup = new PopupMenu(view.getContext(), view);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.popmenu_item_detail, popup.getMenu());
            popup.setOnMenuItemClickListener(this);
            popup.show();
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {

            popupMenuListener.OnPopupMenuListener(item, getAdapterPosition());

            return false;
        }


    }
}