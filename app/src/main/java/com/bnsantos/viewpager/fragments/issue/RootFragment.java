package com.bnsantos.viewpager.fragments.issue;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RootFragment extends Fragment{
  private static final String FRAGMENT_POS = "RootFragment_BUNDLE_POS";
  private int mPos;

  public static RootFragment newInstance(int pos) {
    RootFragment fragment = new RootFragment();
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
    Log.i(RootFragment.class.getSimpleName(), "onCreate fragment " + mPos);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_root, container, false);

    FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction.replace(R.id.root_frame, ViewPagerFragment.newInstance(mPos));
    transaction.commit();

    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    Log.i(RootFragment.class.getSimpleName(), "onViewCreated fragment " + mPos);

  }
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    Log.i(RootFragment.class.getSimpleName(), "onAttach fragment " + mPos);
  }

  @Override
  public void onDetach() {
    super.onDetach();
    Log.i(RootFragment.class.getSimpleName(), "onDetach fragment " + mPos);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    Log.i(RootFragment.class.getSimpleName(), "onDestroyView fragment " + mPos);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.i(RootFragment.class.getSimpleName(), "onDestroy fragment " + mPos);
  }
}
