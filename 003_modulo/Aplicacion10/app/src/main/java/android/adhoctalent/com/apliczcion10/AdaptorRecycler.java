package android.adhoctalent.com.apliczcion10;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class AdaptorRecycler extends
        RecyclerView.Adapter
                <AdaptorRecycler.ViewHolderAdaptador>
      implements  View.OnClickListener
{

    private List<Contacto> datos;
    private View.OnClickListener listener;

    public AdaptorRecycler(List<Contacto> datos){
        this.datos = datos;
    }

    @Override
    public ViewHolderAdaptador onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).
                     inflate(R.layout.card_contacto,parent,false);
        vista.setOnClickListener(this);
        ViewHolderAdaptador vh = new ViewHolderAdaptador(vista);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolderAdaptador holder, int position) {
            Contacto cont = datos.get(position);
            holder.txtNombre.setText(cont.getNombre());
            holder.txtTelefono.setText(cont.getTelefono());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setListener (View.OnClickListener
                                     lister)
    {
        this.listener = lister;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
        {
            listener.onClick(view);
        }
    }

    public static class ViewHolderAdaptador extends
            RecyclerView.ViewHolder{

        TextView txtNombre;
        TextView txtTelefono;

        public ViewHolderAdaptador(View item){
            super(item);
            txtNombre = (TextView) item.findViewById
                    (R.id.cNombre);
            txtTelefono = (TextView) item.findViewById
                    (R.id.cTelefono);
        }

    }

}
