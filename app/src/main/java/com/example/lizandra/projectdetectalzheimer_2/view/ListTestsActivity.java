package com.example.lizandra.projectdetectalzheimer_2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.lizandra.projectdetectalzheimer_2.R;
import com.example.lizandra.projectdetectalzheimer_2.adapters.IndividuoAdapter;
import com.example.lizandra.projectdetectalzheimer_2.adapters.TestMeemAdapter;
import com.example.lizandra.projectdetectalzheimer_2.dao.IndividuoDAO;
import com.example.lizandra.projectdetectalzheimer_2.dao.TestMeemDAO;
import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.dominio.TestMeem;
import com.example.lizandra.projectdetectalzheimer_2.interfaces.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LIZANDRA on 22/09/2017.
 */

public class ListTestsActivity extends AppCompatActivity implements OnRecyclerViewItemClickListener {

    private RecyclerView recyclerview;
    private List<TestMeem> listTests;
    private TestMeemDAO testMeemDAO;
    private TestMeemAdapter testMeemAdapter;
    private Toolbar toolbar;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listtests);
        initViews();
        this.testMeemDAO = new TestMeemDAO(this);
        receberDadosListTests();

        if ((listTests != null) && (!listTests.isEmpty())){
            testMeemAdapter = new TestMeemAdapter(listTests, this);
            testMeemAdapter.setOnRecyclerViewItemClickListener(this);
            recyclerview.setAdapter(testMeemAdapter);
        }else {
            recyclerview.setVisibility(View.GONE);
        }

    }

    private void initViews(){
        this.toolbar = (Toolbar) findViewById(R.id.app_toolbar);
        this.toolbar.setTitle("AppName");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        getSupportActionBar().setHomeButtonEnabled(true);
        this.llm = new LinearLayoutManager(this);
        this.llm.setOrientation(LinearLayoutManager.VERTICAL);
        this.recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        this.recyclerview.setHasFixedSize(true);
        this.recyclerview.setLayoutManager(llm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_toolbar2, menu);
        return true;
    }

    @Override
    public void onClickListener(View view, int adapterPosition) {
        if (view.getId() == R.id.btn_excluir){
            TestMeem auxTestmeem = testMeemAdapter.getItem(adapterPosition);
            testMeemDAO.deletarTesteMeem(auxTestmeem);
            listTests.remove(auxTestmeem);
            testMeemAdapter.setItems(listTests);
        }
    }

    public void receberDadosListTests(){
        Intent intent = getIntent();
        listTests = new ArrayList<TestMeem>();
        if (intent != null) {
            Bundle params = intent.getExtras();
            Long id = params.getLong("id");
            listTests = testMeemDAO.getTestesofIndividuo(id);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                //startActivity(new Intent(this, InstrucaoActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish(); //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
