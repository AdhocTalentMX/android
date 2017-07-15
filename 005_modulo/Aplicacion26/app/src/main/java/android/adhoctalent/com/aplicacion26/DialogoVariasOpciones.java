package android.adhoctalent.com.aplicacion26;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * Description:
 * <p>
 * Copyright 2017 AdhocTalent
 * <p>
 * Created by luiscobian on 7/14/17.
 * Edit by ---- on 7/14/17
 */

public class DialogoVariasOpciones extends DialogFragment {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] items = {"JETTA", "CAMARO", "RIO"};

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle("Selección")
                .setSingleChoiceItems(items, -1,  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Log.e("Dialogos", "Opción elegida: " + items[item]);
                    }
                }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener()  {
            public void onClick(DialogInterface dialog, int id) {
                Log.i("Dialogos", "Confirmacion Aceptada.");
                dialog.cancel();
            }
        });

        return builder.create();
    }



}
