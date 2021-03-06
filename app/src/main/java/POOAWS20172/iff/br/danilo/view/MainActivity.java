package POOAWS20172.iff.br.danilo.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import POOAWS20172.iff.br.danilo.R;
import POOAWS20172.iff.br.danilo.utils.Android;

public class MainActivity extends AppCompatActivity implements MaterialSearchView.OnQueryTextListener{

    private MaterialSearchView searchView;
    private MenuItem itemSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(this);
        searchView.setHint("Pesquisar");

        if(savedInstanceState == null){
            showFragment(FragmentTipos.newInstance());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        itemSearch = menu.findItem(R.id.menu_search);
        searchView.setMenuItem(itemSearch);

        AbstractFragment frag = getSelectedFragment();
        if(frag!=null){
            setSearchVisible(frag.enableSearch());
        }

        return true;
    }

    public void setSearchVisible(boolean b){
        if(itemSearch!=null){
            itemSearch.setVisible(b);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search: {

                return true;
            }
            default: return false;
        }
    }

    @Override
    public void onBackPressed() {
        if (closeSearch()) {
            return;
        }
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 1) {
            fm.popBackStack();
        } else {
            Android.finishDialog(this);
        }
    }

    public boolean closeSearch(){
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
            return true;
        }
        return false;
    }

    public void setSearchHint(String hint){
        searchView.setHint(hint);
    }

    public void showFragment(AbstractFragment fragment) {
        closeSearch();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_body, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        AbstractFragment selected = getSelectedFragment();
        if(selected!=null && newText!=null && !newText.isEmpty()){
            selected.orderList(newText);
            return true;
        }
        return false;
    }

    public AbstractFragment getSelectedFragment(){
        return (AbstractFragment) getSupportFragmentManager().findFragmentById(R.id.container_body);
    }

    @Override
    public boolean onQueryTextSubmit(String query) { return false; }

}