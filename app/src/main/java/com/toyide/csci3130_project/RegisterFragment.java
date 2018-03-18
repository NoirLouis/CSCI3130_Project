package com.toyide.csci3130_project;


import android.content.Context;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegisterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegisterFragment newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    private MyApplicationData appState;
    private String[] cidList;
    private String courseTitle;
    private String courseInfo;
    private String courseSpot;
    private int spotMax;
    private int spotCurrent;

    //Not needed in the registration
    private String courseWeekday;
    private String courseTime;
    private String courseType;


    private ArrayList<Course> CourseList;

    public RegisterFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // create a view instance to add the courseInfo
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        //course items that should be shown in the schedule
        ArrayList<Course> courseArrayList = new ArrayList<>();

        //Retrieve schedual information for current user
        String userId = LocalData.getUserID(); //Get userID from local

        //Set-up Firebase
        appState = (MyApplicationData) getActivity().getApplicationContext();
        appState.firebaseDBInstance = FirebaseDatabase.getInstance();
        appState.firebaseReference = appState.firebaseDBInstance.getReference("Courses");
        appState.firebaseReference.orderByChild("CourseID").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    Course course = dataSnapshot.getValue(Course.class);
                    courseTitle = course.getCourseTitle();
                    courseInfo = course.getCourseInfo();
                    courseTime = course.getCourseTime();
                    spotMax = course.getSpotMax();
                    spotCurrent = course.getSpotCurrent();


                    courseWeekday = course.getCourseWeekday();
                    courseType = course.getCourseType();
                }
                Course C = new Course(courseTitle,courseType, courseWeekday, courseTime, courseInfo, spotCurrent,spotMax);
                CourseList.add(C);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        //create a new CourseListAdapter object(CourseListAdapter.java)
        //turns the content of courseArrayList into things that the ListView(fragment_schedule) can display
        RegistrationAdapter adapter = new RegistrationAdapter(getContext(), R.layout.fragment_register, CourseList);

        //look within the ListView(fragment_schedule) layout for the element with id.lv_schedule
        ListView listView = (ListView) view.findViewById(R.id.listView_Registration);

        //use ListView(fragment_schedule) adapter to draw the things on the screen
        listView.setAdapter(adapter);






        TableLayout courseInfoView = view.findViewById(R.id.registerCourseInfo);
        RegisterCourseInfo myRegisteration = new RegisterCourseInfo(getActivity(),this,view);
        myRegisteration.init();
        Button RegButt = (Button) view.findViewById(R.id.RegisterButt);
        RegButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Register Confirmed", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
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
            Toast.makeText(context, "RegisterFragment attached", Toast.LENGTH_SHORT).show();
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