package frenchdonuts.tasty.standard.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import frenchdonuts.tasty.standard.FragmentTransactor;
import frenchdonuts.tasty.standard.NamesItemAdapter;
import frenchdonuts.tasty.standard.R;

/**
 * Created by pamelactan on 12/7/15.
 */
public class NameListFragment extends Fragment {
    private FragmentTransactor fragmentTransactor;

    NamesItemAdapter namesItemAdapter;
    RecyclerView rvNames;

    public NameListFragment() {}
    public static Fragment newInstance() {
        return new NameListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentTransactor = (FragmentTransactor) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.name_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        namesItemAdapter = new NamesItemAdapter(fragmentTransactor);

        RecyclerView rvNames = (RecyclerView) view.findViewById(R.id.rvNames);
        rvNames.setAdapter(namesItemAdapter);
        rvNames.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onStart() {
        super.onStart();
        namesItemAdapter.setNames(Arrays.asList("Tom ", "Jon", "Robin", "Ajay"));
    }
}
