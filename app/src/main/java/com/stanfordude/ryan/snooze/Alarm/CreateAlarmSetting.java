package com.stanfordude.ryan.snooze.Alarm;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.stanfordude.ryan.snooze.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreateAlarmSetting.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */

/* This fragment is put into view when the "add" button is pressed in the AlarmFragment class
it allows the user to create an alarm setting, and returns that setting in some form to the AlarmFragment
class to put in the listview.

Also, when an existing list_item in the AlarmFragment is pressed, this fragment will be displayed with the current list_item setting
and will permit editing of an alarm setting.

I'm not replacing existing views with views from other layouts, too much of a hassle, I'll simply add a button in runtime, and change
the text on the existing buttons

TODO:Convert current dialog into use with AlertDialog, it has a better design, and flexibility/usability increases

 */



public class CreateAlarmSetting extends DialogFragment implements View.OnClickListener, AlertDialog.OnClickListener, TimePicker.OnTimeChangedListener, NumberPicker.OnValueChangeListener {

    /*
    the isEdit variable is set to true when an existing alarm time is clicked, this will add the
    "delete" button to the dialog, to possibly delete the item from the listview
     */
    private boolean isEdit = false;
    public static final String ISEDIT_PARAM = "isEdit";
    public static final String ALARMSETTING_PARAM = "AlarmSetting";
    public AlarmSetting alarmSetting;

    private TimePicker timePicker;
    private NumberPicker numberPicker;
    //private Button cancelButton, createButton, deleteButton;
    //View of the dialog layout that will be inflated
    private View main;
    private OnFragmentInteractionListener mListener;

    public CreateAlarmSetting() {

    }

    /*
    Below are a few of the Fragment lifecycle methods
     */

    public void setArguments(Bundle bundle) {
        isEdit = bundle.getBoolean(ISEDIT_PARAM);
        alarmSetting = (AlarmSetting) bundle.get(ALARMSETTING_PARAM);

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        Not doing anything yet, because findViewById() doesn't work at this point in the lifecycle
         */

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //    TODO: check if this is to edit a current alarmSetting and add the save button and delete button


        main = inflater.inflate(R.layout.fragment_create_alarm_setting, null;
        //Initialize views and their listeners
        timePicker = (TimePicker) main.findViewById(R.id.alarm_fragment_dialog_timepicker);
        numberPicker = (NumberPicker) main.findViewById(R.id.alarm_fragment_dialog_numberpicker);
        //    cancelButton = (Button)  main.findViewById(R.id.alarm_fragment_dialog_cancel_button);
        //  createButton = (Button)  main.findViewById(R.id.alarm_fragment_dialog_create_button);
        timePicker.setOnTimeChangedListener(this);
        numberPicker.setOnValueChangedListener(this);
        //cancelButton.setOnClickListener(this);
        //createButton.setOnClickListener(this);
        numberPicker.setMaxValue(45);
        numberPicker.setMinValue(0);
        //create display based on given parameters
  /*
        if (isEdit) {
         //   ViewGroup parent= (ViewGroup) main.findViewById(R.id.alarm_fragment_dialog_button_container);
            deleteButton= (Button) main.findViewById(R.id.alarm_fragment_dialog_delete_button);
            deleteButton.setText("Delete");
            deleteButton.getLayoutParams().height= LinearLayout.LayoutParams.WRAP_CONTENT;
            deleteButton.getLayoutParams().width= LinearLayout.LayoutParams.WRAP_CONTENT;
            deleteButton.setOnClickListener(this);
            createButton.setText("Save");

//TODO: Set Display Settings to current alarm settings, includes having cancel, delete, save buttons
            timePicker.setCurrentHour(alarmSetting.getHours());
            timePicker.setCurrentMinute(alarmSetting.getMinutes());



            //Replace create button with the save add the delete button
            ViewGroup parent= (ViewGroup) main.findViewById(R.id.alarm_fragment_dialog_button_container);
            ViewGroup v=(ViewGroup) edit.findViewById(R.id.miscellaneous_items_container);
            //v.removeView(edit.findViewById(R.id.alarm_fragment_dialog_delete_button));
            parent.addView(edit.findViewById(R.id.alarm_fragment_dialog_delete_button), 1);
            //Replace create button with save button
            parent = (ViewGroup) createButton.getParent();
            int index = parent.indexOfChild(createButton);
            parent.removeView(createButton);
            parent.addView(parent.findViewById(R.id.alarm_fragment_dialog_save_button), index);


        }*/

        return main;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        if (main == null) {
            main = getActivity().getLayoutInflater().inflate(R.layout.fragment_create_alarm_setting, null);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Create a new Alarm Setting");
        builder.setNegativeButton("Cancel", this);
        builder.setPositiveButton("Create", this);

        builder.setView(main);

        return builder.create();



    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /*
    Below are listeners for the actions in the dialog
     */
    @Override
    public void onClick(DialogInterface dialogInterface, int id) {
        switch (id) {
            case DialogInterface.BUTTON_NEGATIVE:


            case DialogInterface.BUTTON_NEUTRAL:


            case DialogInterface.BUTTON_POSITIVE:

        }


    }


    @Override
    public void onValueChange(NumberPicker picker, int val, int num) {
        //Do something

    }

    @Override
    public void onTimeChanged(TimePicker picker, int hours, int minutes) {
        if (alarmSetting != null) {
            alarmSetting.setHours(hours);
            alarmSetting.setMinutes(minutes);
        } else alarmSetting = new AlarmSetting(hours, minutes, false);


    }


    @Override
    public void onClick(View v) {
        //do stuff for each button
        switch (v.getId()) {


        }


    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
