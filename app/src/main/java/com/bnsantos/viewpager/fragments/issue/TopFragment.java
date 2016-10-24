package com.bnsantos.viewpager.fragments.issue;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopFragment extends Fragment{

  public static TopFragment newInstance() {
    TopFragment fragment = new TopFragment();
    return fragment;
  }
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TopFragment.class.getSimpleName(), "onCreate fragment ");
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_top, container, false);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    Log.i(TopFragment.class.getSimpleName(), "onViewCreated fragment ");

  }
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    Log.i(TopFragment.class.getSimpleName(), "onAttach fragment ");
  }

  @Override
  public void onDetach() {
    super.onDetach();
    Log.i(TopFragment.class.getSimpleName(), "onDetach fragment ");
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    Log.i(TopFragment.class.getSimpleName(), "onDestroyView fragment ");
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.i(TopFragment.class.getSimpleName(), "onDestroy fragment ");
  }
}
