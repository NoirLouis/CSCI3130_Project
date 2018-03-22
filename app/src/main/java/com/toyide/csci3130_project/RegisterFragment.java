package com.toyide.csci3130_project;
import android.app.Activity;
import android.content.Context;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
//import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
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
    private String location;
    private String courseWeekday;
    private String courseTime;
    private String courseType;
    private int spotMax;
    private int spotCurrent;

    private static final String TAG = "test";
    //Not needed in the registration

    private ListView RegistrationListView;
    private Button RegButton;
    private ArrayList<Courses> CourseList;

    private FirebaseListAdapter<Courses> firebaseAdapter;

    public RegisterFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // create a view instance to add the courseInfo
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        //course items that should be shown in the schedule
        CourseList = getData.courses_list;

        RegButton= (Button) view.findViewById(R.id.RegisterButt);
        //for(int i=0; i<CourseList.size();i++) {
            RegistrationListView = (ListView) view.findViewById(R.id.listView_Registration);
            //RegistrationAdapter adapter = new RegistrationAdapter(getContext(), R.layout.fragment_schedule, CourseList);
            //RegistrationListView.setAdapter(adapter);
       // }
        /*RegButton.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                StringBuilder result = new StringBuilder();
                for(int i=0;i<adapter.mCheckStates.size();i++)
                {
                    if(adapter.mCheckStates.get(i)==true)
                    {

                        result.append(app_info[i].applicationName);
                        result.append("\n");
                    }

                }
                Toast.makeText(MainActivity.this, result, 1000).show();
            }

        });*/

        //Retrieve schedual information for current user
        String userId = LocalData.getUserID(); //Get userID from local

        //Set-up Firebase
        appState = (MyApplicationData) getActivity().getApplicationContext();
        appState.firebaseDBInstance = FirebaseDatabase.getInstance();
        appState.firebaseReference = appState.firebaseDBInstance.getReference("Courses");
        //Set-up Firebase

        //Get the reference to the UI contents
        Activity act = getActivity();
        Log.i(TAG, "MyClass.getView()  " + getData.courses_list.toString()+" second");


        /*
        RegistrationListView = (ListView) view.findViewById(R.id.listView_Registration);

        //Set up the List View
        firebaseAdapter = new FirebaseListAdapter<Courses>(getActivity(), Courses.class,
                android.R.layout.simple_list_item_1, appState.firebaseReference) {

            @Override
            protected void populateView ( View v , Courses model, int position) {
                Log.i(TAG, "MyClass.getView()  " + model.toString()+" secod");
                TextView register = (TextView) v.findViewById(android.R.id.text1);
                TextView courseTitleView = (TextView) v.findViewById(R.id.courseName);
                TextView courseInfoView = (TextView) v.findViewById(R.id.courseInfo);
                TextView courseTime = (TextView) v.findViewById(R.id.courseTime);
                TextView courseSpot = (TextView) v.findViewById(R.id.courseSpot);
                CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkBox);
                Map<String, Object> course = model.toMap();
                //set text for TextView
                if(course !=null){
                    courseTitleView.setText(course.get("CourseTitle").toString());
                    courseInfoView.setText(course.get("CourseInfo").toString());
                    courseTime.setText(course.get("CourseWeekday").toString() + course.get("CourseTime").toString());
                    courseSpot.setText(course.get("SpotCurrent").toString() + "/" + course.get("SpotMax").toString() );
                }

            }
        };
        */
/*
        RegistrationListView.setAdapter(firebaseAdapter);

        /*
        RegistrationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = (Course) firebaseAdapter.getItem(position);

            }
        });*/
        /*
        appState.firebaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    Course course = dataSnapshot.getValue(Course.class);
                    courseTitle = course.getCourseTitle().toString();
                    courseInfo = course.getCourseInfo().toString();
                    courseTime = course.getCourseTime().toString();
                    spotMax = course.getSpotMax();
                    spotCurrent = course.getSpotCurrent();
                    location = course.getLocation().toString();
                    courseWeekday = course.getCourseWeekday().toString();
                    courseType = course.getCourseType().toString();
                }
                Course C = new Course(courseTitle,courseType, courseWeekday, courseTime, courseInfo, location, spotCurrent, spotMax);
                CourseList.add(C);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
*/
        //create a new CourseListAdapter object(CourseListAdapter.java)
        //turns the content of courseArrayList into things that the ListView(fragment_schedule) can display
        // RegistrationAdapter adapter = new RegistrationAdapter(getContext(), R.layout.fragment_register, CourseList);

        //look within the ListView(fragment_schedule) layout for the element with id.lv_schedule
        //ListView listView = (ListView) view.findViewById(R.id.listView_Registration);

        //use ListView(fragment_schedule) adapter to draw the things on the screen
        //  listView.setAdapter(adapter);



/*
        TableLayout courseInfoView = view.findViewById(R.id.registerCourseInfo);
        RegisterCourseInfo myRegisteration = new RegisterCourseInfo(getActivity(),this,view);
        myRegisteration.init();
*/
/*
        Button RegButt = (Button) view.findViewById(R.id.RegisterButt);
        RegButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Register Confirmed", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        */
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