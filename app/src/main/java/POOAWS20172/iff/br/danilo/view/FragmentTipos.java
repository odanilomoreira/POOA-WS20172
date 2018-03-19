package POOAWS20172.iff.br.danilo.view;

import android.content.res.Configuration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

import POOAWS20172.iff.br.danilo.adapter.SimpleBeanRecyclerViewAdapter;
import POOAWS20172.iff.br.danilo.business.Tipo;
import POOAWS20172.iff.br.danilo.holder.SimpleBeanViewHolder;
import POOAWS20172.iff.br.danilo.holder.TipoViewHolder;

public class FragmentTipos extends AbstractFragment<Tipo, Tipo> {

    public static FragmentTipos newInstance() {
        return new FragmentTipos();
    }

    @Override
    public String createTitle() {
        return "Tipo de veículo";
    }

    @Override
    public String createSubTitle() {
        return null;
    }

    @Override
    public void createData(SimpleBeanRecyclerViewAdapter<Tipo> adapter) {
        adapter.setData(new ArrayList<>(Arrays.asList(Tipo.TIPOS)));
    }

    @Override
    protected SimpleBeanViewHolder createHolder(LayoutInflater inflater, ViewGroup parent) {
        return new TipoViewHolder(inflater, parent);
    }

    @Override
    public void onClick(Tipo obj) {
        ((MainActivity)getActivity()).showFragment(FragmentMarcas.getInstance(obj));
    }

    @Override
    protected boolean enableBack() {
        return false;
    }
    @Override
    protected boolean enableSearch() {
        return false;
    }

    @Override
    protected RecyclerView.LayoutManager createRecyclerViewLayoutManager() {
        boolean land = getActivity().getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE;
        if (land) {
            return new GridLayoutManager(getContext(), 3);
        }
        return super.createRecyclerViewLayoutManager();
    }
}