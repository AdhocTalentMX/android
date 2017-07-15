package android.adhoctalent.com.aplicacion26;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
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

public class DialogoCheck  extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] items = {"JETTA", "CAMARO", "RIO"};

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle("Selección")
                .setMultiChoiceItems(items,null,  new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        Log.e("Dialogos", "Opción elegida: " + items[i]);
                        Log.e("Estado" , String.valueOf(b));
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
