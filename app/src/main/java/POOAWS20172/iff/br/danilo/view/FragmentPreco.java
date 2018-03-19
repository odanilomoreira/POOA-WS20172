package POOAWS20172.iff.br.danilo.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import POOAWS20172.iff.br.danilo.adapter.SimpleBeanRecyclerViewAdapter;
import POOAWS20172.iff.br.danilo.business.Modelo;
import POOAWS20172.iff.br.danilo.business.Preco;
import POOAWS20172.iff.br.danilo.holder.PrecoViewHolder;
import POOAWS20172.iff.br.danilo.holder.SimpleBeanViewHolder;
import POOAWS20172.iff.br.danilo.service.FipeService;
import POOAWS20172.iff.br.danilo.service.ServiceCallback;

public class FragmentPreco extends AbstractFragment<Preco, Modelo>{

    public static FragmentPreco getInstance(Modelo modelo){
        FragmentPreco fragment = new FragmentPreco();
        Bundle args = new Bundle();
        args.putSerializable(PARAMETER, modelo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String createTitle() {
        return "Consulta FIPE";
    }

    @Override
    public String createSubTitle() {
        return null;
    }

    @Override
    public void createData(final SimpleBeanRecyclerViewAdapter<Preco> adapter) {
        new FipeService((MainActivity)getActivity()).getPreco(parameter, new ServiceCallback<ArrayList<Preco>>() {
            @Override
            public void onSuccess(ArrayList<Preco> data) {
                adapter.setData(data);
            }
        });
    }

    @Override
    protected SimpleBeanViewHolder createHolder(LayoutInflater inflater, ViewGroup parent) {
        return new PrecoViewHolder(inflater, parent);
    }

    @Override
    protected boolean enableSearch() {
        return false;
    }

    @Override
    public void onClick(Preco obj) {
        //TODO
        ((MainActivity)getActivity()).closeSearch();
    }
}
