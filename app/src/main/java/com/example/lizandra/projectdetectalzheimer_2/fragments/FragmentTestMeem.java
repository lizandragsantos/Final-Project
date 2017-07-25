package com.example.lizandra.projectdetectalzheimer_2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lizandra.projectdetectalzheimer_2.R;
import com.example.lizandra.projectdetectalzheimer_2.adapters.PessoaAdapter;
import com.example.lizandra.projectdetectalzheimer_2.adapters.TestMeemAdapter;
import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.dominio.TestMeem;
import com.example.lizandra.projectdetectalzheimer_2.interfaces.OnRecyclerViewItemClickListener;
import com.example.lizandra.projectdetectalzheimer_2.view.MainActivity;

import java.util.List;

/**
 * Created by LIZANDRA on 20/07/2017.
 */

public class FragmentTestMeem extends Fragment{
    private RecyclerView recyclerview;
    private List<TestMeem> testmeem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_listtestmeem, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.rv_listtestmeem);
        recyclerview.setHasFixedSize(true);
        recyclerview.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                TestMeemAdapter adapter = (TestMeemAdapter) recyclerView.getAdapter();

            }
        });
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(llm);

        //testmeem = ((MainActivity) getActivity()).getListPessoas(10);
        TestMeemAdapter adapter = new TestMeemAdapter(testmeem, getActivity());
        recyclerview.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
