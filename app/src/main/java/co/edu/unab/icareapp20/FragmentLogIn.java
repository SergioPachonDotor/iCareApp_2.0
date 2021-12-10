package co.edu.unab.icareapp20;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLogIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLogIn extends Fragment {

    Button signUpButtonF;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public FragmentLogIn() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLogIn.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLogIn newInstance(String param1, String param2) {
        FragmentLogIn fragment = new FragmentLogIn();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentLogIn fragmentLogIn = new FragmentLogIn();
        FragmentSignUp fragmentSignUp = new FragmentSignUp();
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_log_in, container, false);
        signUpButtonF = root.findViewById(R.id.signUpButton);
        signUpButtonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Holy", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    public void onClick(View v){
        Toast.makeText(getContext(),"Hola", Toast.LENGTH_SHORT);

    }
}