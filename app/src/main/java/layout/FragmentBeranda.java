package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xample.masyadi.coffelate2.R;
import com.xample.masyadi.coffelate2.adapter.MenuProdukAdapter;
import com.xample.masyadi.coffelate2.model.MenuProdukModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBeranda extends Fragment {

    RecyclerView contentRecyclerView;
    MenuProdukAdapter adapter;

    public FragmentBeranda() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        contentRecyclerView = (RecyclerView) view.findViewById(R.id.container_recycle_beranda);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        contentRecyclerView.setLayoutManager(gridLayoutManager);


        List<MenuProdukModel> modelList = new ArrayList<>();

        modelList.add(new MenuProdukModel("Nasi goreng 1", 10000));
        modelList.add(new MenuProdukModel("Nasi goreng 2", 9000));
        modelList.add(new MenuProdukModel("Nasi goreng 3", 8000));
        modelList.add(new MenuProdukModel("Nasi goreng 4", 7000));
        modelList.add(new MenuProdukModel("Nasi goreng 5", 6000));
        modelList.add(new MenuProdukModel("Nasi goreng 6", 5000));
        modelList.add(new MenuProdukModel("Nasi goreng 7", 10000));
        modelList.add(new MenuProdukModel("Nasi goreng 8", 10000));
        modelList.add(new MenuProdukModel("Nasi goreng 9", 10000));
        modelList.add(new MenuProdukModel("Nasi goreng 10", 10000));
        modelList.add(new MenuProdukModel("Nasi goreng 11", 10000));
        modelList.add(new MenuProdukModel("Nasi goreng 12", 10000));


        adapter = new MenuProdukAdapter(getContext(), modelList);
        contentRecyclerView.setAdapter(adapter);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.isHeader(position) ? gridLayoutManager.getSpanCount() : 1;
            }
        });


    }
}
