package com.example.lizandra.projectdetectalzheimer_2.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.lizandra.projectdetectalzheimer_2.R;
import com.example.lizandra.projectdetectalzheimer_2.adapters.PessoaAdapter;
import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.interfaces.OnRecyclerViewItemClickListener;
import com.example.lizandra.projectdetectalzheimer_2.view.MainActivity;

import java.util.List;

/**
 * Created by LIZANDRA on 23/06/2017.
 */

public class FragmenListPessoas extends Fragment implements PopupMenu.OnMenuItemClickListener {
    private RecyclerView recyclerview;
    private List<Individuo> pessoas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_listpessoas, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.rv_list);
        recyclerview.setHasFixedSize(true);
        recyclerview.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                PessoaAdapter adapter = (PessoaAdapter) recyclerView.getAdapter();

               }
        });

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(llm);

        pessoas = ((MainActivity) getActivity()).getListPessoas(10);
        PessoaAdapter adapter = new PessoaAdapter(pessoas, getActivity());
        recyclerview.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
