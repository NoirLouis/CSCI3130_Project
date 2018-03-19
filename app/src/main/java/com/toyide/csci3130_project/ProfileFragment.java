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

public class ProfileFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    EditText oldPass;
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
    Button back;
    Button out;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Profile myprofile;
    private MyApplicationData appState;

    private String userID;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }
    */




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container,false);

        userID = LocalData.getUserID();
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
        back = view.findViewById(R.id.back);
        state = view.findViewById(R.id.state);
        info =view.findViewById(R.id.info);
        pass = view.findViewById(R.id.pass);
        modify = view.findViewById(R.id.confirm);
        out = view.findViewById(R.id.out);

        //Set-up Firebase
        appState = (MyApplicationData) getActivity().getApplicationContext();
        appState.firebaseDBInstance = FirebaseDatabase.getInstance();
        appState.firebaseReference = appState.firebaseDBInstance.getReference("Courses");
        appState.firebaseReference.orderByChild("CourseID").addValueEventListener(new ValueEventListener() {
            @Override public void onDataChange(DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        });
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
        back.setOnClickListener(new View.OnClickListener(){
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
        out.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getActivity().finish();
            }
        });
        if(myprofile != null){
            name.setText(myprofile.username);
            info1.setText(myprofile.uid);
            pass1.setText(myprofile.password);
            state1.setText(myprofile.department);
            state2.setText(myprofile.degree);

        }
        return view;


    }

    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){

            name.setText(ds.child(userID).getValue(Profile.class).getUid()); //set the ID
            info1.setText(ds.child(userID).getValue(Profile.class).getUsername()); //set the username
            pass1.setText(ds.child(userID).getValue(Profile.class).getPassword()); //set the password
            state1.setText(ds.child(userID).getValue(Profile.class).getDepartment()); //set the department
            state2.setText(ds.child(userID).getValue(Profile.class).getDegree()); //set the degree
            //display all the information
            Log.d(TAG, "showData: UserID: " + name);
            Log.d(TAG, "showData: Username: " + info1);
            Log.d(TAG, "showData: Password: " + pass1);
            Log.d(TAG, "showData: Deparment: " + state1);
            Log.d(TAG, "showData: Degree: " + state2);

        }
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
                back.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.back: {
                state1.setVisibility(View.INVISIBLE);
                state2.setVisibility(View.INVISIBLE);
                state3.setVisibility(View.INVISIBLE);
                pass1.setVisibility(View.INVISIBLE);
                pass2.setVisibility(View.INVISIBLE);
                modify.setVisibility(View.INVISIBLE);
                info1.setVisibility(View.INVISIBLE);
                oldPass.setVisibility(View.INVISIBLE);
                newPass.setVisibility(View.INVISIBLE);
                modify.setVisibility((View.INVISIBLE));
                back.setVisibility(View.INVISIBLE);
                info.setVisibility(View.VISIBLE);
                state.setVisibility(View.VISIBLE);
                pass.setVisibility(View.VISIBLE);
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

    private void updateProfile(EditText oldPass) {
        String ID = info1.getText().toString();
        String Name = name.getText().toString();
        String password = oldPass.getText().toString();
        String Department = state1.getText().toString();
        String Degree = state2.getText().toString();

        Profile newfile = new Profile(ID, Name, password, Department,Degree);

        appState.firebaseReference.child(ID).setValue(newfile);
        getActivity().finish();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);


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