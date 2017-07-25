package com.example.lizandra.projectdetectalzheimer_2.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lizandra.projectdetectalzheimer_2.R;
import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.dominio.TestMeem;
import com.example.lizandra.projectdetectalzheimer_2.interfaces.OnRecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by LIZANDRA on 20/07/2017.
 */

public class TestMeemAdapter extends RecyclerView.Adapter<TestMeemAdapter.ViewHolder> {

    private List<TestMeem> testmeem;
    private LayoutInflater layoutinflater;

    public TestMeemAdapter(List<Individuo> testmeem, FragmentActivity activity) {
    }


    public TestMeemAdapter(List<TestMeem> testmeem,  Context context) {
        this.testmeem = testmeem;
        this.layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public TestMeemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutinflater.inflate(R.layout.item_testmeem_card, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_data.setText("Data: "+(testmeem.get(position).getData().toString()));
        holder.tv_ori_temporal.setText("Orientação Temporal: "+((int) testmeem.get(position).getOri_temporal()));
        holder.tv_ori_espacial.setText("Orientação Espacial"+((int) testmeem.get(position).getOri_espacial()));
        holder.tv_mem_imediata.setText("Memória Imediata: "+((int) testmeem.get(position).getMem_imediata()));
        holder.tv_mem_recente.setText("Memória Recente"+((int) testmeem.get(position).getMem_recente()));
        holder.tv_calculo.setText("Calculo"+((int) testmeem.get(position).getCalculo()));
        holder.tv_linguagem.setText("Linguagem"+((int) testmeem.get(position).getLinguagem()));
        holder.tv_acertos.setText("Acertos"+((int) testmeem.get(position).getAcertos()));
        holder.tv_erros.setText("Erros"+((int) testmeem.get(position).getErros()));

        holder.bt_excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return testmeem.size();
    }

    public void addListItem(TestMeem tm, int position){
        testmeem.add(tm);
        notifyItemInserted(position);
    }

    public void removeListItem(TestMeem tm, int position){
        testmeem.remove(tm);
        notifyItemRemoved(position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_data;
        public TextView tv_ori_temporal;
        public TextView tv_ori_espacial;
        public TextView tv_mem_imediata;
        public TextView tv_mem_recente;
        public TextView tv_calculo;
        public TextView tv_linguagem;
        public TextView tv_acertos;
        public TextView tv_erros;
        public Button bt_excluir;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_data = (TextView) itemView.findViewById(R.id.tv_data);
            tv_ori_temporal = (TextView) itemView.findViewById(R.id.tv_ori_temporal);
            tv_ori_espacial = (TextView) itemView.findViewById(R.id.tv_ori_espacial);
            tv_mem_imediata = (TextView) itemView.findViewById(R.id.tv_mem_imediata);
            tv_mem_recente = (TextView) itemView.findViewById(R.id.tv_mem_recente);
            tv_calculo = (TextView) itemView.findViewById(R.id.tv_calculo);
            tv_linguagem = (TextView) itemView.findViewById(R.id.tv_linguagem);
            tv_acertos = (TextView) itemView.findViewById(R.id.tv_acertos);
            tv_erros = (TextView) itemView.findViewById(R.id.tv_erros);
            bt_excluir = (Button) itemView.findViewById(R.id.bt_excluir);
        }
    }
}
