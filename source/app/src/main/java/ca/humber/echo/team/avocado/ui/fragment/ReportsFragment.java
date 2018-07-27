package ca.humber.echo.team.avocado.ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ca.humber.echo.team.avocado.R;
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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView textViewReport1;
    private TextView textViewReport2;
    private TextView textViewReport3;
    private TextView textViewReport4;
    ReportsViewModel viewModel;

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
    // TODO: Rename and change types and number of parameters
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

        String largestExpenseName = viewModel.getLargestExpenseName().getValue();
        Double largestExpenseValue = viewModel.getLargestExpenseValue().getValue();
        String largestEntryCategoryName = viewModel.getLargestEntryCategoryName().getValue();
        Integer largestEntryCategoryCount = viewModel.getLargestEntryCategoryCount().getValue();
        String largestEntrySubCategoryName = viewModel.getLargestEntrySubCategoryName().getValue();
        Integer largestEntrySubCategoryCount = viewModel.getLargestEntrySubCategoryCount().getValue();
        String largestEntryDescriptionName = viewModel.getLargestEntryDescriptionName().getValue();
        Integer largestEntryDescriptionCount = viewModel.getLargestEntryDescriptionCount().getValue();

        textViewReport1 = (TextView) view.findViewById(R.id.textViewReport1);
        textViewReport1.setText("The largest Expense is " + largestExpenseName + " at a value of " + largestExpenseValue);

        textViewReport2 = (TextView) view.findViewById(R.id.textViewReport2);
        textViewReport2.setText("You registered " + largestEntryCategoryCount + " entries on the category " + largestEntryCategoryName);

        textViewReport3 = (TextView) view.findViewById(R.id.textViewReport3);
        textViewReport3.setText("You registered " + largestEntrySubCategoryCount + " entries on the subcategory " + largestEntrySubCategoryName);

        textViewReport4 = (TextView) view.findViewById(R.id.textViewReport4);
        textViewReport4.setText("You most common entry is " + largestEntryDescriptionName + " with " + largestEntryDescriptionCount + " entries registerd");

//        floatingActionButton = view.findViewById(R.id.floatingActionButton);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), ExpenseEntryActivity.class);
//                startActivity(intent);
//            }
//        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
