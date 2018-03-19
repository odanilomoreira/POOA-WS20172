package pooa20171.iff.br.webserviceappfipe.view;

import android.os.Bundle;

import java.util.ArrayList;

import pooa20171.iff.br.webserviceappfipe.adapter.SimpleBeanRecyclerViewAdapter;
import pooa20171.iff.br.webserviceappfipe.business.Marca;
import pooa20171.iff.br.webserviceappfipe.business.Veiculo;
import pooa20171.iff.br.webserviceappfipe.service.FipeService;
import pooa20171.iff.br.webserviceappfipe.service.ServiceCallback;

public class FragmentVeiculos extends AbstractFragment<Veiculo,Marca>{

    public static FragmentVeiculos getInstance(Marca marca){
        FragmentVeiculos fragment = new FragmentVeiculos();
        Bundle args = new Bundle();
        args.putSerializable(PARAMETER, marca);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String createTitle() {
        return "Veículos";
    }

    @Override
    public String createSubTitle() {
        return parameter.getTipo()+" > "+parameter.getName();
    }

    @Override
    public void createData(final SimpleBeanRecyclerViewAdapter<Veiculo> adapter) {
        new FipeService((MainActivity)getActivity()).getVeiculos(parameter, new ServiceCallback<ArrayList<Veiculo>>() {
            @Override
            public void onSuccess(ArrayList<Veiculo> data) {
                adapter.setData(data);
            }
        });
    }

    @Override
    public String searchHint() {
        return "Ex. Gol City 1.0 8v 2p";
    }

    @Override
    public void onClick(Veiculo obj) {
        ((MainActivity)getActivity()).showFragment(FragmentModelos.getInstance(obj));
    }

}