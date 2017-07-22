package android.adhoctalent.com.aplicacion30;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment {


    RecyclerView rv;


    public ShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_show, container, false);

        rv = (RecyclerView) view.findViewById(R.id.listaPersonal);

        AdaptadorRecycler arc = new AdaptadorRecycler(getContext());
        rv.setAdapter(arc);


        rv.hasFixedSize();
        LinearLayoutManager llm  = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);

        return view;
    }

}
