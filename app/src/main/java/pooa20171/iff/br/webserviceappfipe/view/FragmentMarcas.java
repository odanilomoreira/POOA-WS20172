package pooa20171.iff.br.webserviceappfipe.view;

import android.os.Bundle;

import java.util.ArrayList;

import pooa20171.iff.br.webserviceappfipe.adapter.SimpleBeanRecyclerViewAdapter;
import pooa20171.iff.br.webserviceappfipe.business.Marca;
import pooa20171.iff.br.webserviceappfipe.business.Tipo;
import pooa20171.iff.br.webserviceappfipe.service.FipeService;
import pooa20171.iff.br.webserviceappfipe.service.ServiceCallback;

public class FragmentMarcas extends AbstractFragment<Marca,Tipo> {

    public static FragmentMarcas getInstance(Tipo tipo){
        FragmentMarcas fragment = new FragmentMarcas();
        Bundle args = new Bundle();
        args.putSerializable(PARAMETER, tipo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String createTitle() {
        return "Marcas";
    }

    @Override
    public String createSubTitle() {
        return parameter.getName();
    }

    @Override
    public void createData(final SimpleBeanRecyclerViewAdapter<Marca> adapter) {
        new FipeService((MainActivity)getActivity()).getMarcas(parameter, new ServiceCallback<ArrayList<Marca>>() {
            @Override
            public void onSuccess(ArrayList<Marca> data) {
                adapter.setData(data);
            }
        });
    }

    @Override
    public void onClick(Marca obj) {
        ((MainActivity)getActivity()).showFragment(FragmentVeiculos.getInstance(obj));
    }

}
