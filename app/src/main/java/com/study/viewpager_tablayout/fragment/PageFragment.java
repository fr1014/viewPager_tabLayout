package com.study.viewpager_tablayout.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.study.viewpager_tablayout.R;


public class PageFragment extends Fragment {

    @LayoutRes
    int exampleLayoutRes;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static PageFragment newInstance(@LayoutRes int exampleLayoutRes) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("exampleLayoutRes", exampleLayoutRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            exampleLayoutRes = getArguments().getInt("exampleLayoutRes");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        ViewStub exampleStub = view.findViewById(R.id.exampleViewStub);
        exampleStub.setLayoutResource(exampleLayoutRes);
        exampleStub.inflate();
        return view;
    }

}
