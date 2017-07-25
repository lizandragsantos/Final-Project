package com.example.lizandra.projectdetectalzheimer_2.view;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lizandra.projectdetectalzheimer_2.R;
import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;
import com.example.lizandra.projectdetectalzheimer_2.fragments.FragmenListPessoas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LIZANDRA on 21/06/2017.
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar.setNavigationIcon(R.drawable.ic_menu_black_18dp);
        toolbar.setTitle("AppName");
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CadastroIndividuo.class));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        exibirFragmentoListPessoas();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.layout_drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.layout_drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //ação para os itens da actionbar
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //ação para os itens da navigationdrawer
        int id = item.getItemId();
        selecionarTela(id);
        return true;
    }

    private void selecionarTela(int itemId){

        switch (itemId){
            case (R.id.nav_instrucao):{
                startActivity(new Intent(MainActivity.this,InstruTest.class));
                break;
            }
            case (R.id.nav_testmemoria):{
                startActivity(new Intent(MainActivity.this,CadastroIndividuo.class));
                break;
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.layout_drawer);
        drawer.closeDrawer(GravityCompat.START);

    }

    private void exibirFragmentoListPessoas(){
        Fragment  fragment = null;

        if (fragment==null) {
            fragment = new FragmenListPessoas();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.commit();
        }
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        builder.show();
    }
    //teste
    public List<Individuo> getListPessoas(int qtd){

        String[] nome = new String[]{"Teste1", "Teste2", "Teste3", "Teste 4", "Teste5", "Teste6", "Teste7", "Teste8", "Teste9", "Teste10"};
        List<Individuo> listaux = new ArrayList<>();

        for (int i = 0; i < qtd; i++){
            Individuo p = new Individuo(nome[i], "feminino", "6 serie", 70);
            listaux.add(p);
        }
        return listaux;
    }
}
