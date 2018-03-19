package POOAWS20172.iff.br.danilo.holder;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import POOAWS20172.iff.br.danilo.R;
import POOAWS20172.iff.br.danilo.business.Tipo;

public class TipoViewHolder extends SimpleBeanViewHolder<Tipo>{

    public final ImageView ivTipo;

    public TipoViewHolder(View view) {
        super(view);
        ivTipo = (ImageView) view.findViewById(R.id.iv_tipo);
    }

    public TipoViewHolder(LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(R.layout.item_tipo, parent, false));
    }

    public void onBindViewHolder(Tipo item){
        super.onBindViewHolder(item);
        ivTipo.setImageDrawable(ContextCompat.getDrawable(mView.getContext(), item.getIcon()));
    }

}
