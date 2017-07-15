package android.adhoctalent.com.aplicacion25;

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

public class DialogoSeleccion extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] items = {"JETTA", "CAMARO", "RIO"};

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle("Selección")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Log.e("Dialogos", "Opción elegida: " + items[item]);
                    }
                });

        return builder.create();
    }

}
