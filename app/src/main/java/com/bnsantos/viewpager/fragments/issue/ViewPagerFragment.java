package com.bnsantos.viewpager.fragments.issue;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bnsantos.viewpager.fragments.issue.databinding.FragmentViewPagerBinding;

public class ViewPagerFragment extends Fragment implements View.OnClickListener {
  private static final String FRAGMENT_POS = "ViewPagerFragment_BUNDLE_POS";
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
    Log.i(ViewPagerFragment.class.getSimpleName(), "onCreate fragment " + mPos);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager, container, false);
    Log.i(ViewPagerFragment.class.getSimpleName(), "onCreateView fragment " + mPos);
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
        mBinding.startFragment.setVisibility(View.VISIBLE);
        break;
    }
    Log.i(ViewPagerFragment.class.getSimpleName(), "onViewCreated fragment " + mPos);
    mBinding.startFragment.setOnClickListener(this);
  }
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    Log.i(ViewPagerFragment.class.getSimpleName(), "onAttach fragment " + mPos);
  }

  @Override
  public void onDetach() {
    super.onDetach();
    Log.i(ViewPagerFragment.class.getSimpleName(), "onDetach fragment " + mPos);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    Log.i(ViewPagerFragment.class.getSimpleName(), "onDestroyView fragment " + mPos);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.i(ViewPagerFragment.class.getSimpleName(), "onDestroy fragment " + mPos);
  }

  @Override
  public void onClick(View v) {
    FragmentTransaction trans = getFragmentManager().beginTransaction();
    trans.replace(R.id.root_frame, TopFragment.newInstance());
    trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    trans.addToBackStack(null);
    trans.commitAllowingStateLoss();
  }
}
