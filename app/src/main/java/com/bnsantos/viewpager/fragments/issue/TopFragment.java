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
  public static final String TAG = TopFragment.class.getSimpleName();

  public static TopFragment newInstance() {
    TopFragment fragment = new TopFragment();
    return fragment;
  }
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.i(TAG, "onCreate fragment ");
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_top, container, false);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    Log.i(TAG, "onViewCreated fragment ");

  }
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    Log.i(TAG, "onAttach fragment ");
  }

  @Override
  public void onDetach() {
    super.onDetach();
    Log.i(TAG, "onDetach fragment ");
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    Log.i(TAG, "onDestroyView fragment ");
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.i(TopFragment.class.getSimpleName(), "onDestroy fragment ");
  }
}
