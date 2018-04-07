package com.toyide.csci3130_project;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import com.toyide.csci3130_project.login;


public class ScheduleFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private static final String TAG = "test";

    private MyApplicationData appState;
    private ArrayList<String> cidList;
    private ArrayList<Course> CourseList;
    private String cid;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        //course items that should be shown in the schedule
        CourseList = new ArrayList<Course>();
        cidList = new ArrayList<String>();

        //Retrieve schedual information for current user
        final Profile myprofile = (Profile) getActivity().getIntent().getSerializableExtra("profile") ;

        //Set-up Firebase
        appState = (MyApplicationData) getActivity().getApplicationContext();
        appState.firebaseDBInstance = FirebaseDatabase.getInstance();
        appState.firebaseReference = appState.firebaseDBInstance.getReference("Registrations");
        appState.firebaseReference.addListenerForSingleValueEvent(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(myprofile.UserID).exists()) {
                    setCidList( dataSnapshot.child(myprofile.UserID).child("CourseID").getValue(String.class));
                    Log.i(TAG, "MyClass.getView()  " + cid);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                while (cid ==null) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //Do something after 100ms
                        }
                    }, 100);
                }
                Log.i(TAG, "MyClass.getView()  " + cid+" secod");

                for (String s : cid.split(",")) {
                        if (!s.isEmpty())
                            cidList.add(s);
                }

                appState.firebaseReference = appState.firebaseDBInstance.getReference("Courses");
                for ( int i = 0; i < cidList.size(); i++) {
                    final String courseID = cidList.get(i);

                    appState.firebaseReference.addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String courseTitle = "courseTitle", courseType = "courseType", courseWeekday = "courseWeekday", courseTime = "courseTime", courseInfo = "courseInfo", Location="TAD";
                            if (dataSnapshot != null) {
                                Course course = dataSnapshot.child(courseID).getValue(Course.class);
                                courseTitle = course.CourseTitle;
                                courseType = course.CourseType;
                                courseWeekday = course.CourseWeekday;
                                courseTime = course.CourseTime;
                                courseInfo = course.CourseInfo;
                                Location = course.Location;
                            }
                            Course C = new Course(
                                    courseTitle,
                                    courseType,
                                    courseWeekday,
                                    courseTime,
                                    courseInfo,
                                    Location
                            );
                            CourseList.add(C);
                            Log.i(TAG, "MyClass.getView()  " + CourseList.toString()+" secod");
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            while (cidList.size() != CourseList.size()) {
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //Do something after 100ms
                                    }
                                }, 50);
                            }
                            Log.i(TAG, "MyClass.getView()  " + cidList.toString()+" secod");
                            //create a new CourseListAdapter object(CourseListAdapter.java)
                            //turns the content of courseArrayList into things that the ListView(fragment_schedule) can display
                            CourseListAdapter adapter = new CourseListAdapter(getContext(), R.layout.fragment_schedule, CourseList);

                            //look within the ListView(fragment_schedule) layout for the element with id.lv_schedule
                            ListView listView = (ListView) view.findViewById(R.id.lv_schedule);

                            //use ListView(fragment_schedule) adapter to draw the things on the screen
                            listView.setAdapter(adapter);
                        }
                    }, 400);

                }

        }, 100);


        //Set background color for different course type
        view.setBackgroundColor(0x00FF00);


        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    public  void setCidList(String Course){
        cid =  Course;
    }
    public void wait(String x){
        x = "";
    }
    public String getCList(){
        return cid;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(context, "ScheduleFragment attached", Toast.LENGTH_SHORT).show();
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
