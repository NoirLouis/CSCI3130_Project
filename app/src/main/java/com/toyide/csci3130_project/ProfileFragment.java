package com.toyide.csci3130_project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static android.content.Intent.getIntent;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//Refactoring- remove useless variables
public class ProfileFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    TextView oldPass;
    EditText newPass;
    TextView name;
    TextView info1;
    TextView state1;
    TextView state2;
    TextView state3;
    TextView pass1;
    TextView pass2;
    Button state;
    Button info;
    Button pass;
    Button modify;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Profile myprofile;



    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container,false);
        myprofile = (Profile) getActivity().getIntent().getSerializableExtra("profile") ;

        name = view.findViewById(R.id.viewAntoNieva);
        info1 = view.findViewById(R.id.Bnumber);
        state1 = view.findViewById(R.id.department);
        state2 = view.findViewById(R.id.level);
        state3 = view.findViewById(R.id.university);
        pass1 = view.findViewById(R.id.oldpassword);
        pass2 = view.findViewById(R.id.newpassword);
        oldPass = view.findViewById(R.id.oldpass);
        newPass = view.findViewById(R.id.newpass);
        state = view.findViewById(R.id.state);
        info =view.findViewById(R.id.info);
        pass = view.findViewById(R.id.pass);
        modify = view.findViewById(R.id.confirm);
        showData(myprofile);
        //Set-up Firebase
        state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileOnClick(v);
            }
        });
        info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                profileOnClick(v);
            }
        });
        pass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                profileOnClick(v);
            }
        });
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileOnClick(v);
            }
        });
        if(myprofile != null){
            name.setText(myprofile.UserName);
            info1.setText(myprofile.UserID);
            oldPass.setText(myprofile.Password);
            state1.setText(myprofile.Department);
            state2.setText(myprofile.UserDegree);
        }
        return view;
    }

    private void showData(Profile profile) {
            Map<String, Object> pros = profile.toMap();
            name.setText(pros.get("UserID").toString()); //set the ID
            info1.setText(pros.get("UserName").toString()); //set the username
            oldPass.setText(pros.get("Password").toString()); //set the password
            state1.setText(pros.get("Department").toString()); //set the department
            state2.setText(pros.get("UserDegree").toString()); //set the degree
            //display all the information

    }

    /**
     * A function for Button OnClickLitener.
     * Fragment is different with Activity
     * so the function implemented the features of four buttons
     * The parameter View v used to call the components
     */
    public void profileOnClick(View v) {

        switch (v.getId()) {
            case R.id.info: {
                state1.setVisibility(View.INVISIBLE);
                state2.setVisibility(View.INVISIBLE);
                state3.setVisibility(View.INVISIBLE);
                pass1.setVisibility(View.INVISIBLE);
                pass2.setVisibility(View.INVISIBLE);
                modify.setVisibility(View.INVISIBLE);
                info1.setVisibility(View.VISIBLE);
                oldPass.setVisibility(View.INVISIBLE);
                newPass.setVisibility(View.INVISIBLE);
                modify.setVisibility((View.INVISIBLE));
                break;
            }
            case R.id.state: {
                info1.setVisibility(View.INVISIBLE);
                state1.setVisibility(View.VISIBLE);
                state2.setVisibility(View.VISIBLE);
                state3.setVisibility(View.VISIBLE);
                pass1.setVisibility(View.INVISIBLE);
                pass2.setVisibility(View.INVISIBLE);
                oldPass.setVisibility(View.INVISIBLE);
                newPass.setVisibility(View.INVISIBLE);
                modify.setVisibility((View.INVISIBLE));
                break;
            }
            case R.id.pass: {
                info1.setVisibility(View.INVISIBLE);
                state1.setVisibility(View.INVISIBLE);
                state2.setVisibility(View.INVISIBLE);
                state3.setVisibility(View.INVISIBLE);
                pass1.setVisibility(View.VISIBLE);
                pass2.setVisibility(View.VISIBLE);
                oldPass.setVisibility(View.VISIBLE);
                newPass.setVisibility(View.VISIBLE);
                modify.setVisibility((View.VISIBLE));
                state.setVisibility(View.INVISIBLE);
                info.setVisibility(View.INVISIBLE);
                pass.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.confirm: {
                if(newPass.getText().toString() != null){
                    oldPass.setText(newPass.getText().toString());
                    newPass.setText("");
                    updateProfile(oldPass);
                }
            }
            default:
                break;
        }
    }

    private void updateProfile(TextView oldPass) {
        String ID = info1.getText().toString();
        String Name = name.getText().toString();
        String password = oldPass.getText().toString();
        String Department = state1.getText().toString();
        String Degree = state2.getText().toString();

        Profile new_Value = new Profile(ID, Name, password, Department,Degree);
        MyApplicationData appState = (MyApplicationData) getActivity().getApplication();
        appState.firebaseDBInstance = FirebaseDatabase.getInstance();
        appState.firebaseReference = appState.firebaseDBInstance.getReference("Users");
        appState.firebaseReference.child(ID).setValue(new_Value);
        getActivity().finish();
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
            Toast.makeText(context, "ProfileFragment attached", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        profileOnClick(v);
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