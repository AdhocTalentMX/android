package android.adhoctalent.com.aplicacion24;

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

public class DialogoConfirmar extends DialogFragment {

    Results r;


    public DialogoConfirmar() {

    }

    public static DialogoConfirmar newInstance(Results r) {
        DialogoConfirmar dialogoConfirmar = new DialogoConfirmar();
        dialogoConfirmar.r = r;
        return dialogoConfirmar;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setMessage("¿Confirma la acción seleccionada?")
                .setTitle("Confirmacion")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("Dialogos", "Confirmacion Aceptada.");
                        dialog.cancel();
                        r.returnValue(true);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("Dialogos", "Confirmacion Cancelada.");
                        dialog.cancel();
                        r.returnValue(false);
                    }
                });

        return builder.create();
    }

}
