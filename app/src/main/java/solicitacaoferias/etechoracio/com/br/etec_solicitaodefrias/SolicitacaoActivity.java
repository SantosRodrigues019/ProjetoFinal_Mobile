package solicitacaoferias.etechoracio.com.br.etec_solicitaodefrias;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.icu.text.RelativeDateTimeFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import solicitacaoferias.etechoracio.com.br.etec_solicitaodefrias.Utils.DateTimeUtils;

import static java.lang.Integer.parseInt;

public class SolicitacaoActivity extends AppCompatActivity {
    private Button btnData;
    private TextView dtfim;
    private Spinner spndiasferias;
    private  TextView quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);

        btnData = findViewById(R.id.btnData);
        dtfim = findViewById(R.id.dtfim);
        spndiasferias = findViewById(R.id.spndiasferias);
        quantidade = findViewById(R.id.quantidade);

        spndiasferias.setAdapter(getAbomoSim());
        spndiasferias.setAdapter(getAbomoNao());


    }

    protected Dialog onCreateDialog (int id) {
        Calendar calendario = Calendar.getInstance();

        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case R.id.btnData:
                return new DatePickerDialog(this, mDateSetListener, ano, mes, dia);
        }
        return null;

    }

    private  DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int ano, int mes, int dia) {
            btnData.setText(DateTimeUtils.formatDate(dia,mes,ano));

        }
    };

    public void onSelecionar (View v ) { showDialog((v.getId())); }

    public void onCadastrar (View v) {

        Date data = DateTimeUtils.toDate(btnData.getText().toString());

        if (!DateTimeUtils.isSegundaFeira(data)){
            Toast.makeText(SolicitacaoActivity.this,"Não é uma segunda-feira",Toast.LENGTH_SHORT).show();
        }
        else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(data);
            cal.add(Calendar.DATE, parseInt(spndiasferias.getSelectedItem().toString()));
            dtfim.setText(DateTimeUtils.formatarDataFinal(cal));

        }
    }
            private ArrayAdapter getAbomoSim ()
            {
                return new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(20, 30));
            }

            private ArrayAdapter getAbomoNao ()
            {
                return new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(10,15,20, 30));
            }

            public void onRadioClick(View v){
                if(v.getId() == R.id.radiosim)
                {
                    spndiasferias.setAdapter(getAbomoSim());
                }
                    else {
                    spndiasferias.setAdapter(getAbomoNao());
                }
            }

        }



