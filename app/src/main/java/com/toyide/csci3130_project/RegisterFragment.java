package com.toyide.csci3130_project;
import android.app.Activity;
import android.content.Context;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;

import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
//import android.widget.TableLayout;
import android.widget.PopupWindow;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;


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
    private MyApplicationData appCourseData;
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

    public String currentIDList;// selected courseIDList for later conflict check
    private CheckTimeConflict checkTimeConflict;
    private String userId ;
    private String intialSelectedCourseStr;//intial selected course list
    private final ArrayList<Courses> intialSelectedSpotArray = new ArrayList<Courses>();


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // create a view instance to add the courseInfo
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        //course items that should be shown in the schedule
        CourseList = getData.courses_list;
        checkTimeConflict = new CheckTimeConflict();
        RegistrationListView= (ListView) view.findViewById(R.id.listView_Registration);
        RegButton= (Button) view.findViewById(R.id.RegisterButt);

        final RegistrationAdapter adapter = new RegistrationAdapter(getContext(), R.layout.fragment_register, CourseList);
        RegistrationListView.setAdapter(adapter);

        //Retrieve schedual information for current user
        userId = LocalData.getUserID(); //Get userID from local


        //Get the reference to the UI contents
        Activity act = getActivity();
        Log.i(TAG, "MyClass.getView()  " + getData.courses_list.toString()+" second");

        //Set-up Firebase
        appState = (MyApplicationData) getActivity().getApplicationContext();
        appState.firebaseDBInstance = FirebaseDatabase.getInstance();
        appState.firebaseReference = appState.firebaseDBInstance.getReference("Registrations");
        //Get intial selected course list
        appState.firebaseReference.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot userSnapshot) {
                intialSelectedCourseStr = userSnapshot.child(userId).child("CourseID").getValue().toString();
                //String intialSelectedCourse = appState.firebaseReference.child(LocalData.getUserID()).child("CourseID").;
                //Profile profile = userSnapshot.child(userID).getValue(Profile.class);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Current spot of courses in the list -1
        ArrayList<String> intialSelectedCourseList = new ArrayList<String> (Arrays.asList(intialSelectedCourseStr.split(",")));

        //FIXME: get intial course list from firebase
        //Get intial selected course list
        appCourseData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appCourseData.firebaseReference = appCourseData.firebaseDBInstance.getReference("Courses");
        appCourseData.firebaseReference.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> courseSnapshot =dataSnapshot.getChildren();

                for (DataSnapshot course : courseSnapshot ){
                    Courses temp = course.getValue(Courses.class);
                    intialSelectedSpotArray.add(temp);
                    getData.courses_list.add(temp);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String IDlist = adapter.CourseIDString.toString().replace("[", "").replace("]", "").replace(" ","");
                //appState.firebaseReference.child(LocalData.getUserID()).child("CourseID").setValue(IDlist);

                //confirm information on screen

                currentIDList = IDlist;

                boolean checkConflict = false;//false -> no conflict
                ArrayList<String> selectedCourseTimeList = new ArrayList<String>();
                ArrayList<String> selectedCourseDayList = new ArrayList<String>();
                Log.i(TAG,  "View()"+currentIDList.toString().split(",")[0]+"  alalal  "+currentIDList.toString().split(",").length);

                //Check conflict: CourseList a list of courses
                for (int i = 0; i < currentIDList.toString().split(",").length; i++) {
                    outerloop:
                    for (int j = 0; j < CourseList.size(); j++) {
                        Courses temp_course = CourseList.get(j);
                        //Courss matches get courseTime
                        Log.i(TAG,  "View()"+currentIDList.toString().split(",")[i]+"  alalal  "+temp_course.CourseID.toString());
                        if (temp_course.CourseID.toString().equals(currentIDList.toString().split(",")[i]) ) {

                            String currentCourseTime = temp_course.CourseTime;
                            String currentCourseDay = temp_course.CourseWeekday;
                            //Check if current courseTime and weekday confict with the existing one
                            int length =selectedCourseTimeList.size();
                            for (int k = 0; k < length; k++) {
                                //Conflictcheck(selectedCourseTimeList[k],currentCourseTime

                                Log.i(TAG,  "  alalal  "+checkTimeConflict.confliCtcheck(selectedCourseTimeList.get(k), currentCourseTime) + "   "+ checkTimeConflict.sameChars(selectedCourseDayList.get(k), currentCourseDay));
                                if (checkTimeConflict.confliCtcheck(selectedCourseTimeList.get(k), currentCourseTime) && checkTimeConflict.sameChars(selectedCourseDayList.get(k), currentCourseDay)) {
                                    Log.i(TAG,  "  alalal  "+k);
                                    checkConflict = true; //there is conflict
                                    break outerloop;
                                }
                                selectedCourseTimeList.add(currentCourseTime) ;
                                selectedCourseDayList.add(currentCourseDay);
                                //No conflict add to courseLis
                            }

                            if (i==0) {
                                selectedCourseTimeList.add(currentCourseTime) ;
                                selectedCourseDayList.add(currentCourseDay);
                            }
                        }
                    }
                }
                if (checkConflict == false) {
                    appState.firebaseReference.child(LocalData.getUserID()).child("CourseID").setValue(currentIDList);
                    Toast.makeText(getActivity(), "Success!", Toast.LENGTH_SHORT).show();

                    //FIXME: Update current spot
                    /*
                    //Current spot of courses in currentIDList  +1
                    for (int i = 0; i < appCourseData; i++) {
                        appCourseData.firebaseReference.child(intialSelectedCourseList.get(i)).child("SpotCurrent").setValue()
                    }
                    for(int i = 0; i < intialSelectedCourseList.size(); i++) {
                        appCourseData.firebaseReference.child()
                    }
                       */


                    //Get the registed course list using userId
                }
                else {
                    Toast.makeText(getActivity(), "Conflicted.", Toast.LENGTH_SHORT).show();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.i(TAG, "MyClass.getView()  " +" secod");
                        }
                    }, 400);
                    //TODO update currentSpot

                }

            }

        });

        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            /*
            ArrayList<Courses> curCourses = new ArrayList<Courses>();
            for (String s : adapter.CourseIDString) {
                for (Courses c : CourseList) {
                    if (s.equals(c.CourseID))
                        curCourses.add(c);
                }
            }

            for (int i = 0; i < curCourses.size(); i++) {
                for (int j = i + 1; j < curCourses.size(); j++) {
                    for (char day : curCourses.get(i).CourseWeekday.toCharArray()) {
                        if (curCourses.get(j).CourseWeekday.indexOf(day) != -1) {
                            String time1[] = curCourses.get(i).CourseTime.split("-");
                            String time2[] = curCourses.get(j).CourseTime.split("-");

                        }
                    }

                }
            }
            */


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