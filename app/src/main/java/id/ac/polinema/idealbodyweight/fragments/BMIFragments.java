package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BMIIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BMIFragments.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BMIFragments extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BMIFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmifragments, container, false);
        final EditText massaText = view.findViewById(R.id.txt_massa);
        final EditText heightText = view.findViewById(R.id.txt_height);

        Button calc = view.findViewById(R.id.bmi_calculate);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    if (!heightText.getText().toString().equals("") && !massaText.getText().toString().equals("")){
                        int heightGet = Integer.parseInt(heightText.getText().toString());
                        int massaGet = Integer.parseInt(massaText.getText().toString());
                        BMIIndex bmi = new BMIIndex(massaGet,heightGet);
                        mListener.onCalculateBMI(bmi.getBmi(),bmi.getCdt());
                    }
                    else{
                    Toast.makeText(getActivity(),"Please select gender and input your height", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
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
        void onCalculateBMI(float index, String status);
    }
}
