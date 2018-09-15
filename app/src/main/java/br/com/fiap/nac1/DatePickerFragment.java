package br.com.fiap.nac1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Raphael Pizzo on 20/03/2018.
 */

/**
 * Classe responsável por administrar a data atual a ser aberta em nosso calendário
 */
public class DatePickerFragment extends DialogFragment {

    /**
     * Quando o Dialog do datepicker é inicializado este método é executado
     * @param savedInstanceState
     * @return
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int ano = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), ano, mes, dia);
    }
}
