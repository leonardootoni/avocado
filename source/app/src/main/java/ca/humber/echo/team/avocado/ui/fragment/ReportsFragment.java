package ca.humber.echo.team.avocado.ui.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.humber.echo.team.avocado.R;
import ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter.LargeCategoryCountAdapter;
import ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter.LargeCategoryNameAdapter;
import ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter.LargeDescriptionCountAdapter;
import ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter.LargeDescriptionNameAdapter;
import ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter.LargeExpenseNameAdapter;
import ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter.LargeExpenseValueAdapter;
import ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter.LargeSubCategoryCountAdapter;
import ca.humber.echo.team.avocado.ui.fragment.ReportsAdapter.LargeSubCategoryNameAdapter;
import ca.humber.echo.team.avocado.viewmodel.ReportsViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ReportsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ReportsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportsFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView textViewReport1;
    private TextView textViewReport2;
    private TextView textViewReport3;
    private TextView textViewReport4;

    ReportsViewModel viewModel;

    //List<String> largestExpenseName;
    List<Double> largestExpenseValue;
    //List<Expense> largestEntryCategoryName;
    //List<Expense> largestEntryCategoryCount;
    //List<Expense> largestEntrySubCategoryName;
    //List<Expense> largestEntrySubCategoryCount;
    //List<Expense> largestEntryDescriptionName;
    //List<Expense> largestEntryDescriptionCount;

    private OnFragmentInteractionListener mListener;

    private FloatingActionButton floatingActionButton;

    public ReportsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReportsFragment.
     */
    public static ReportsFragment newInstance(String param1, String param2) {
        ReportsFragment fragment = new ReportsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static ReportsFragment newInstance() {
        ReportsFragment fragment = new ReportsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        viewModel = ViewModelProviders.of(this).get(ReportsViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_reports, container, false);

        RecyclerView recyclerviewLargeExpenseName = view.findViewById(R.id.recyclerviewLargeExpenseName);
        final LargeExpenseNameAdapter adapter = new LargeExpenseNameAdapter(this.getContext());
        recyclerviewLargeExpenseName.setAdapter(adapter);
        recyclerviewLargeExpenseName.setLayoutManager(new LinearLayoutManager(this.getContext()));

        viewModel.getLargestExpenseName().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable final List<String> expense) {
                adapter.setLargestExpenseName(expense);
            }
        });


        RecyclerView recyclerviewLargeExpenseValue = view.findViewById(R.id.recyclerviewLargeExpenseValue);
        final LargeExpenseValueAdapter largeExpenseValueAdapter = new LargeExpenseValueAdapter(this.getContext());
        recyclerviewLargeExpenseValue.setAdapter(largeExpenseValueAdapter);
        recyclerviewLargeExpenseValue.setLayoutManager(new LinearLayoutManager(this.getContext()));

        viewModel.getLargestExpenseValue().observe(this, new Observer<List<Double>>() {
            @Override
            public void onChanged(@Nullable final List<Double> expense) {
                largeExpenseValueAdapter.setLargestExpenseValue(expense);
            }
        });

        RecyclerView recyclerViewCategoryName = view.findViewById(R.id.recyclerViewCategoryName);
        final LargeCategoryNameAdapter largeCategoryNameAdapter = new LargeCategoryNameAdapter(this.getContext());
        recyclerViewCategoryName.setAdapter(largeCategoryNameAdapter);
        recyclerViewCategoryName.setLayoutManager(new LinearLayoutManager(this.getContext()));

        viewModel.getLargestEntryCategoryName().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable final List<String> expense) {
                largeCategoryNameAdapter.setLargestCategoryName(expense);
            }
        });

        RecyclerView recyclerViewCategoryCount = view.findViewById(R.id.recyclerViewCategoryCount);
        final LargeCategoryCountAdapter largeCategoryCountAdapter = new LargeCategoryCountAdapter(this.getContext());
        recyclerViewCategoryCount.setAdapter(largeCategoryCountAdapter);
        recyclerViewCategoryCount.setLayoutManager(new LinearLayoutManager(this.getContext()));

        viewModel.getLargestEntryCategoryCount().observe(this, new Observer<List<Integer>>() {
            @Override
            public void onChanged(@Nullable final List<Integer> expense) {
                largeCategoryCountAdapter.setLargestCategoryCount(expense);
            }
        });

        RecyclerView recyclerViewSubCategoryName = view.findViewById(R.id.recyclerViewSubCategoryName);
        final LargeSubCategoryNameAdapter largeSubCategoryNameAdapter = new LargeSubCategoryNameAdapter(this.getContext());
        recyclerViewSubCategoryName.setAdapter(largeSubCategoryNameAdapter);
        recyclerViewSubCategoryName.setLayoutManager(new LinearLayoutManager(this.getContext()));

        viewModel.getLargestEntrySubCategoryName().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable final List<String> expense) {
                largeSubCategoryNameAdapter.setLargestSubCategoryName(expense);
            }
        });

        RecyclerView recyclerViewSubCategoryCount = view.findViewById(R.id.recyclerViewSubCategoryCount);
        final LargeSubCategoryCountAdapter largeSubCategoryCountAdapter = new LargeSubCategoryCountAdapter(this.getContext());
        recyclerViewSubCategoryCount.setAdapter(largeSubCategoryCountAdapter);
        recyclerViewSubCategoryCount.setLayoutManager(new LinearLayoutManager(this.getContext()));

        viewModel.getLargestEntrySubCategoryCount().observe(this, new Observer<List<Integer>>() {
            @Override
            public void onChanged(@Nullable final List<Integer> expense) {
                largeSubCategoryCountAdapter.setLargestSubCategoryCount(expense);
            }
        });




        RecyclerView recyclerViewDescriptionName = view.findViewById(R.id.recyclerViewDescriptionName);
        final LargeDescriptionNameAdapter largeDescriptionNameAdapter = new LargeDescriptionNameAdapter(this.getContext());
        recyclerViewDescriptionName.setAdapter(largeDescriptionNameAdapter);
        recyclerViewDescriptionName.setLayoutManager(new LinearLayoutManager(this.getContext()));

        viewModel.getLargestEntryDescriptionName().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable final List<String> expense) {
                largeDescriptionNameAdapter.setLargestDescriptionName(expense);
            }
        });

        RecyclerView recyclerViewDescriptionCount = view.findViewById(R.id.recyclerViewDescriptionCount);
        final LargeDescriptionCountAdapter largeDescriptionCountAdapter = new LargeDescriptionCountAdapter(this.getContext());
        recyclerViewDescriptionCount.setAdapter(largeDescriptionCountAdapter);
        recyclerViewDescriptionCount.setLayoutManager(new LinearLayoutManager(this.getContext()));

        viewModel.getLargestEntryDescriptionCount().observe(this, new Observer<List<Integer>>() {
            @Override
            public void onChanged(@Nullable final List<Integer> expense) {
                largeDescriptionCountAdapter.setLargestDescriptionCount(expense);
            }
        });

        textViewReport1 = (TextView) view.findViewById(R.id.textViewReport1);
        textViewReport2 = (TextView) view.findViewById(R.id.textViewReport2);
        textViewReport3 = (TextView) view.findViewById(R.id.textViewReport3);
        textViewReport4 = (TextView) view.findViewById(R.id.textViewReport4);

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
