package com.bnsantos.viewpager.fragments.issue;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bnsantos.viewpager.fragments.issue.databinding.ActivityViewPagerBinding;

public class ViewPagerActivity extends AppCompatActivity {

  private ActivityViewPagerBinding mBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_pager);

    mBinding.toolbar.setTitle(R.string.tabs);
    setSupportActionBar(mBinding.toolbar);
    initAdapter();
  }

  private void initAdapter(){
    mBinding.viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    mBinding.tabs.setupWithViewPager(mBinding.viewPager);
    mBinding.tabs.getTabAt(0).setIcon(android.R.drawable.ic_menu_camera);
    mBinding.tabs.getTabAt(1).setIcon(android.R.drawable.ic_dialog_dialer);
    mBinding.tabs.getTabAt(2).setIcon(android.R.drawable.ic_dialog_map);
  }

  @Override
  public void onBackPressed() {
    if(mBinding.viewPager.getCurrentItem() == 0){
      Fragment fragment = ((ViewPagerAdapter) mBinding.viewPager.getAdapter()).getFragment(0);
      if (((ViewPagerFragment)fragment).onBackPressed()) {
        return;
      }
    }
    super.onBackPressed();
  }

  private class ViewPagerAdapter extends FragmentStatePagerAdapter{
    public ViewPagerAdapter(FragmentManager fm) {
      super(fm);
      mFragments = new Fragment[getCount()];
    }

    private Fragment[] mFragments;

    @Override
    public Fragment getItem(int position) {
      if (mFragments[position] == null) {
        mFragments[position] = ViewPagerFragment.newInstance(position);
      }
      return mFragments[position];
    }

    @Override
    public int getCount() {
      return 3;
    }

    public Fragment getFragment(int pos) {
      return mFragments[pos];
    }
  }
}
