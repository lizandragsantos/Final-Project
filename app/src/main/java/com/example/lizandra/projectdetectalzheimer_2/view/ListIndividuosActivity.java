package com.example.lizandra.projectdetectalzheimer_2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.lizandra.projectdetectalzheimer_2.R;
import com.example.lizandra.projectdetectalzheimer_2.adapters.IndividuoAdapter;
import com.example.lizandra.projectdetectalzheimer_2.dao.IndividuoDAO;
import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.interfaces.OnPopupMenuListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LIZANDRA on 22/09/2017.
 */

public class ListIndividuosActivity extends AppCompatActivity implements OnPopupMenuListener {

    public static final int REQUEST_CODE_ADD_INDIVIDUO = 1;
    public static final String EXTRA_ADDED_INDIVIDUO = "extra_key_added_individuo";

    private RecyclerView recyclerview;
    private List<Individuo> listIndividuos;
    private IndividuoDAO individuoDAO;
    private IndividuoAdapter individuoAdapter;
    private Toolbar toolbar;
    private LinearLayoutManager llm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listindividuos);
        initViews();

        individuoDAO = new IndividuoDAO(this);

        listIndividuos = new ArrayList<Individuo>();
        listIndividuos = individuoDAO.listarIndividuos();
        if ((listIndividuos != null) && (!listIndividuos.isEmpty())){
            individuoAdapter = new IndividuoAdapter(listIndividuos, ListIndividuosActivity.this);
            individuoAdapter.setPopupMenuListner(this);
            recyclerview.setAdapter(individuoAdapter);
        }else {
            recyclerview.setVisibility(View.GONE);
        }
    }

    private void initViews(){
        //Inicialização das views
        this.toolbar = (Toolbar) findViewById(R.id.app_toolbar);
        this.toolbar.setTitle("AppName");
        setSupportActionBar(toolbar);
        this.llm = new LinearLayoutManager(ListIndividuosActivity.this);
        this.llm.setOrientation(LinearLayoutManager.VERTICAL);
        this.recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        this.recyclerview.setHasFixedSize(true);
        this.recyclerview.setLayoutManager(llm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //ação para os itens da actionbar
        Intent intent;
        switch (item.getItemId()){
            case (R.id.add_teste):{
                intent = new Intent(ListIndividuosActivity.this,AddIndividuoActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD_INDIVIDUO);
                break;
            }
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Atualização do recylerview após adicionar novo itens à lista de individuos
        if (requestCode == REQUEST_CODE_ADD_INDIVIDUO){
            if (resultCode == RESULT_OK){
                if (data != null){
                    Individuo auxIndividuo = (Individuo) data.getSerializableExtra(EXTRA_ADDED_INDIVIDUO);
                    if (auxIndividuo != null){
                        if (listIndividuos == null){
                            listIndividuos = new ArrayList<Individuo>();
                        }
                        listIndividuos.add(auxIndividuo);
                        if (individuoAdapter == null){
                            if (recyclerview.getVisibility() != View.VISIBLE)
                                recyclerview.setVisibility(View.VISIBLE);
                            individuoAdapter = new IndividuoAdapter(listIndividuos, ListIndividuosActivity.this);
                            recyclerview.setAdapter(individuoAdapter);
                            individuoAdapter.setPopupMenuListner(this);

                        }
                        else {
                            individuoAdapter.setItems(listIndividuos);
                        }
                    }
                }
            }
        }else
            super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        individuoDAO.close();
    }

    @Override
    public void OnPopupMenuListener(MenuItem menuItem, int adapterPosition) {
        Long id;
        Bundle params = new Bundle();
        Individuo auxIndividuo = individuoAdapter.getItem(adapterPosition);
        id = auxIndividuo.getId();
        params.putLong("id", id);

        switch (menuItem.getItemId()) {
            case (R.id.item_teste): {
                Intent intent = new Intent(ListIndividuosActivity.this, InstrucaoActivity.class);
                intent.putExtras(params);
                startActivity(intent);
                break;
            }
            case (R.id.item_visualizar_cadastro): {
                break;
            }
            case (R.id.item_delete_cadastro): {
                listIndividuos.remove(auxIndividuo);
                individuoAdapter.removeListItem(auxIndividuo,adapterPosition);
                individuoDAO.deletarIndividuo(auxIndividuo);
                break;
            }
            case (R.id.item_testes_realizados):{
                Intent intent = new Intent(ListIndividuosActivity.this, ListTestsActivity.class);
                intent.putExtras(params);
                startActivity(intent);
                break;
            }
        }
    }
}
