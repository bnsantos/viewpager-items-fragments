package com.bnsantos.viewpager.fragments.issue;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bnsantos.viewpager.fragments.issue.databinding.FragmentViewPagerBinding;

import java.lang.reflect.Field;

import static android.R.attr.fragment;

public class ViewPagerFragment extends Fragment implements View.OnClickListener {
  private static final String FRAGMENT_POS = "ViewPagerFragment_BUNDLE_POS";
  public static final String TAG = ViewPagerFragment.class.getSimpleName();
  private int mPos;
  private FragmentViewPagerBinding mBinding;

  public ViewPagerFragment() { }

  public static ViewPagerFragment newInstance(int pos) {
    ViewPagerFragment fragment = new ViewPagerFragment();
    Bundle args = new Bundle();
    args.putInt(FRAGMENT_POS, pos);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mPos = getArguments().getInt(FRAGMENT_POS);
    }
    Log.i(TAG, "onCreate fragment " + mPos);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager, container, false);
    Log.i(TAG, "onCreateView fragment " + mPos);
    return  mBinding.getRoot();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mBinding.text.setText(Integer.toString(mPos));
    switch (mPos){
      case 1:
        mBinding.layout.setBackgroundResource(android.R.color.holo_blue_dark);
        break;
      case 2:
        mBinding.layout.setBackgroundResource(android.R.color.holo_green_dark);
        break;
      default:
        mBinding.startFragment.setVisibility(hasChildFragment()?View.GONE:View.VISIBLE);
        break;
    }
    Log.i(TAG, "onViewCreated fragment " + mPos);
    mBinding.startFragment.setOnClickListener(this);
  }
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    Log.i(TAG, "onAttach fragment " + mPos);
  }

  @Override
  public void onDetach() {
    super.onDetach();
    Log.i(TAG, "onDetach fragment " + mPos);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    Log.i(TAG, "onDestroyView fragment " + mPos);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.i(TAG, "onDestroy fragment " + mPos);
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.i(TAG, "onResume fragment " + mPos);
  }

  @Override
  public void onClick(View v) {
    mBinding.startFragment.setVisibility(View.GONE);

    FragmentTransaction trans = getChildFragmentManager().beginTransaction();
    trans.replace(R.id.content, TopFragment.newInstance());
    trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    trans.addToBackStack(null);
    trans.commit();
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.i(TAG, "onSaveInstanceState fragment " + mPos);
  }

  public boolean onBackPressed() {
    if(hasChildFragment()){
      mBinding.startFragment.setVisibility(View.VISIBLE);
      getChildFragmentManager().popBackStack();
      return true;
    }
    return false;
  }

  private boolean hasChildFragment(){
    FragmentManager childFragmentManager = getChildFragmentManager();
    return childFragmentManager.getBackStackEntryCount()!=0&&mPos==0;
  }
}
