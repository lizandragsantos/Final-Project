package com.example.lizandra.projectdetectalzheimer_2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.lizandra.projectdetectalzheimer_2.R;
import com.example.lizandra.projectdetectalzheimer_2.dao.IndividuoDAO;
import com.example.lizandra.projectdetectalzheimer_2.dominio.Individuo;


/**
 * Created by LIZANDRA on 18/03/2017.
 */

public class AddIndividuoActivity extends AppCompatActivity {

    private Button btn_cadastrar;
    private Toolbar toolbar;
    private EditText editnome, editidade;
    private TextView txtsexoerr, txtescolaerr;
    private RadioGroup rg_sexo, rg_escola;
    private String rg_sexo_value, rg_escola_value;
    private IndividuoDAO individuoDAO;
    private Individuo auxIndividuo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addindividuo);

        initViews();
        addIndividuo();

        this.individuoDAO = new IndividuoDAO(this);
    }

    public void initViews(){
        this.toolbar = (Toolbar) findViewById(R.id.app_bar2);
        this.toolbar.setTitle("Cadastro");
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_left);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.btn_cadastrar = (Button) findViewById(R.id.btn_finalizar);
        this.btn_cadastrar.setText(R.string.cadastrar);
        this.editnome = (EditText) findViewById(R.id.edt_nome);
        this.editidade = (EditText) findViewById(R.id.edt_idade);
        this.txtsexoerr = (TextView) findViewById(R.id.txt_sexo);
        this.txtescolaerr = (TextView) findViewById(R.id.txt_escola);
        this.rg_sexo = (RadioGroup) findViewById(R.id.rdo_group_sexo);
        this.rg_escola = (RadioGroup) findViewById(R.id.rdo_group_escola);
    }

    public boolean selecionarSexo(){

        boolean flags = false;

        if (rg_sexo.getCheckedRadioButtonId()!= -1){
            rg_sexo_value = ((RadioButton) findViewById(rg_sexo.getCheckedRadioButtonId())).getText().toString();
            flags = true;
        }
        return flags;
    }

    public boolean selecionarEscolaridade(){

        boolean flage = false;
        if (rg_escola.getCheckedRadioButtonId() != -1){
            rg_escola_value = ((RadioButton) findViewById(rg_escola.getCheckedRadioButtonId())).getText().toString();
            flage = true;
        }
        return flage;
    }


    public void addIndividuo(){


        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            Bundle params = new Bundle();
            Intent intent = new Intent();

            @Override
            public void onClick(View v) {

                if (editnome.getText().toString().isEmpty()){
                    editnome.setError("Campo obrigatório");
                    editnome.requestFocus();
                }
                else if (editidade.getText().toString().isEmpty()){
                    editidade.setError("Campo obrigatório");
                    editidade.requestFocus();
                }
                else if (!selecionarSexo()){
                    txtsexoerr.setError("Campo Obrigatório");
                }
                else if (!selecionarEscolaridade()){
                    txtescolaerr.setError("Campo Obrigatório");
                }
                else {
                    auxIndividuo = individuoDAO.inserirIndividuo(editnome.getText().toString(), rg_sexo_value, rg_escola_value, editidade.getText().toString());
                    intent.putExtra(ListIndividuosActivity.EXTRA_ADDED_INDIVIDUO, auxIndividuo);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
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
