package com.study.viewpager_tablayout;

import android.support.annotation.LayoutRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.study.viewpager_tablayout.adapter.PageAdapter;
import com.study.viewpager_tablayout.fragment.PageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    List<String> titleList = new ArrayList<>();
    List<Fragment> fragmentList = new ArrayList<>();
    List<PageModel> pageModels = new ArrayList<>();
    PageFragment pageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doBisness();
    }

    private void doBisness() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), getFragmentList(), getTitleList()));

        tabLayout.setupWithViewPager(viewPager);
    }

    private List<String> getTitleList() {
        titleList.add("Tab1");
        titleList.add("Tab2");
        return titleList;
    }

    private List<Fragment> getFragmentList() {

        pageModels.add(new PageModel(R.layout.examplelayout1));
        pageModels.add(new PageModel(R.layout.examplelayout2));

        for (int i = 0; i < pageModels.size(); i++) {
            pageFragment = PageFragment.newInstance(pageModels.get(i).exampleLayoutRes);
            fragmentList.add(pageFragment);
        }
        return fragmentList;
    }

    class PageModel {
        @LayoutRes
        int exampleLayoutRes;

        public PageModel(@LayoutRes int exampleLayoutRes) {
            this.exampleLayoutRes = exampleLayoutRes;
        }
    }
}
